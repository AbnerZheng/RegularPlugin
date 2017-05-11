package com.regular.format;

import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.psi.codeStyle.CodeStyleSettings;

/**
 * Created by abnerzheng on 2017/5/10.
 */
public class FormatterTestSettings {
  private final CodeStyleSettings mySettings;
  private int myPrevIndentSize;
  private String myPrevDoNotIndentSetting;


  public FormatterTestSettings(CodeStyleSettings codeStyleSettings){
    mySettings = codeStyleSettings;
  }

  public void setUp(){
    myPrevIndentSize = mySettings.getIndentOptions(StdFileTypes.HTML).INDENT_SIZE;
    mySettings.getIndentOptions(StdFileTypes.HTML).INDENT_SIZE = 4;

    myPrevDoNotIndentSetting = mySettings.HTML_DO_NOT_INDENT_CHILDREN_OF;
    mySettings.HTML_DO_NOT_INDENT_CHILDREN_OF = "";
  }

  public void tearDown(){
    mySettings.getIndentOptions(StdFileTypes.HTML).INDENT_SIZE = myPrevIndentSize;
    mySettings.HTML_DO_NOT_INDENT_CHILDREN_OF = myPrevDoNotIndentSetting;
  }
}
