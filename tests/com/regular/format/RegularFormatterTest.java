package com.regular.format;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.impl.DocumentImpl;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsManager;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import com.intellij.util.IncorrectOperationException;
import com.netease.regular.RegularLanguage;
import com.regular.RegularTestUtil;
import org.jetbrains.annotations.NonNls;

import java.io.File;

/**
 * Created by abnerzheng on 2017/5/10.
 */
public class RegularFormatterTest extends LightPlatformCodeInsightFixtureTestCase implements RegularFormattingModelBuilderTest {
  public static final String TEST_DATA_PATH = new File(RegularTestUtil.getBaseTestDataPath(),"formatter").getAbsolutePath();

  protected FormatterTestSettings formatterTestSettings;

  @Override
  protected void setUp() throws Exception {
    super.setUp();

    formatterTestSettings = new FormatterTestSettings(CodeStyleSettingsManager.getSettings(getProject()));
    formatterTestSettings.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    try {
      formatterTestSettings.tearDown();
    }finally {
      super.tearDown();
    }
  }

  void doFileBasedTest() throws Exception {
    doFileBasedTest(getTestName(false) + ".rgl");
  }

  void doFileBasedTest(@NonNls String fileNameBefore) throws Exception {
    doFileBasedTest(fileNameBefore, RegularLanguage.getDefaultTemplateLang());
  }

  void doFileBasedTest(@NonNls String fileNameBefore, LanguageFileType templateDataLanguageType) throws Exception {
    doTextTest(loadFile(fileNameBefore), loadFile(fileNameBefore.replace(".rgl", "_expected.rgl")), templateDataLanguageType);
  }

  void doStringBasedTest(@NonNls final String text, @NonNls String textAfter) throws IncorrectOperationException {
    doTextTest(text, textAfter, RegularLanguage.getDefaultTemplateLang());
  }

  private abstract static class FormatRunnableFactory {
    abstract Runnable createFormatRunnable(PsiFile file);
  }

  void doTextTest(final String beforeText, String textAfter, LanguageFileType templateDataLanguageType) throws IncorrectOperationException {
    // define action to run "Reformat Code" on the whole "file" defined by beforeText
    FormatRunnableFactory fullFormatRunnableFactory = new FormatRunnableFactory() {
      @Override
      Runnable createFormatRunnable(final PsiFile file) {
        return () -> {
          try {
            TextRange rangeToUse = file.getTextRange();
            CodeStyleManager styleManager = CodeStyleManager.getInstance(getProject());
            styleManager.reformatText(file, rangeToUse.getStartOffset(), rangeToUse.getEndOffset());
          }
          catch (IncorrectOperationException e) {
            assertTrue(e.getLocalizedMessage(), false);
          }
        };
      }
    };

    // define action to run "Adjust line indent" on every line in the "file" defined by beforeText
    FormatRunnableFactory lineFormatRunnableFactory = new FormatRunnableFactory() {
      @Override
      Runnable createFormatRunnable(final PsiFile file) {
        return () -> {
          try {
            final PsiDocumentManager manager = PsiDocumentManager.getInstance(getProject());
            final Document document = manager.getDocument(file);

            assert document != null;

            for (int lineNum = 0; lineNum < document.getLineCount(); lineNum++) {
              CodeStyleManager codeStyleManager = CodeStyleManager.getInstance(getProject());
              int offset = document.getLineStartOffset(lineNum);
              @SuppressWarnings("deprecation") // if this breaks at some point, we should
                // refactor to invoke AutoIndentLinesAction
                // instead of doing the indent directly
                boolean lineToBeIndented = codeStyleManager.isLineToBeIndented(file, offset);
              if (lineToBeIndented) {
                codeStyleManager.adjustLineIndent(file, offset);
              }
            }
          }
          catch (IncorrectOperationException e) {
            assertTrue(e.getLocalizedMessage(), false);
          }
        };
      }
    };

    doFormatterActionTest(fullFormatRunnableFactory, beforeText, textAfter, templateDataLanguageType);
    doFormatterActionTest(lineFormatRunnableFactory, beforeText, textAfter, templateDataLanguageType);
  }

  private void doFormatterActionTest(final FormatRunnableFactory formatAction,
                                     final String beforeText,
                                     String textAfter,
                                     LanguageFileType templateDataLanguageType) {
    PsiFile baseFile = myFixture.configureByText("A.rgl", beforeText);

    VirtualFile virtualFile = baseFile.getVirtualFile();
    assert virtualFile != null;
    TemplateDataLanguageMappings.getInstance(getProject()).setMapping(virtualFile, templateDataLanguageType.getLanguage());

    // fetch a fresh instance of the file -- the template data mapping creates a new instance,
    // which was causing problems in PsiFileImpl.isValid()
    final PsiFile file = PsiManager.getInstance(getProject()).findFile(virtualFile);
    assert file != null;

    CommandProcessor.getInstance().executeCommand(getProject(),
      () -> ApplicationManager.getApplication()
        .runWriteAction(formatAction.createFormatRunnable(file)), "", "");

    TemplateDataLanguageMappings.getInstance(getProject()).cleanupForNextTest();

    assertEquals("Reformat Code failed", prepareText(textAfter), prepareText(file.getText()));
  }

  private String prepareText(String actual) {
    actual = StringUtil.trimStart(actual, "\n");
    actual = StringUtil.trimStart(actual, "\n");

    // Strip trailing spaces
    final Document doc = EditorFactory.getInstance().createDocument(actual);
    CommandProcessor.getInstance().executeCommand(getProject(), () -> ApplicationManager.getApplication().runWriteAction(() -> {
      ((DocumentImpl)doc).stripTrailingSpaces(getProject());
    }), "formatting", null);

    return doc.getText();
  }

  private static String loadFile(String name) throws Exception {
    String fullName = new File(TEST_DATA_PATH, name).getAbsolutePath();
    String text = FileUtil.loadFile(new File(fullName));
    text = StringUtil.convertLineSeparators(text);
    return text;
  }
}
