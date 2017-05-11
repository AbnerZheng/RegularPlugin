package com.regular;

import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import sun.net.ResourceManager;

import static org.junit.Assert.assertTrue;

/**
 * Created by abnerzheng on 2017/1/9.
 */
public class RegularTestUtil {
    public static String getBaseTestDataPath() {
//        return PathManager.getJarPathForClass(clazz) + "/" + clazz.getPackage().getName().replace('.', '/') + "/data/";
      return PathManager.getHomePath() + "/testData";
    }

    public static int findOffsetBySignature(String signature, final PsiFile psiFile) {
        final String caretSignature = "<caret>";
        int caretOffset = signature.indexOf(caretSignature);
        assert caretOffset >= 0;
        signature = signature.substring(0, caretOffset) + signature.substring(caretOffset + caretSignature.length());
        int pos = psiFile.getText().indexOf(signature);
        assertTrue(pos >= 0);
        return pos + caretOffset;
    }

    public static String getDirectiveDefinitionText(PsiElement resolve) {
        return resolve.getParent().getText();
    }
}
