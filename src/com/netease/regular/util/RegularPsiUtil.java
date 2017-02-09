package com.netease.regular.util;

import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.netease.regular.ide.folding.RegularFoldingBuilder;

/**
 * Created by abnerzheng on 2017/1/11.
 */
public class RegularPsiUtil {

    public static boolean isNonRootStatementsElement(PsiElement element){
//        PsiTreeUtil.findFirstParent(element, true, elememt1 -> elememt1 != null
//                                                                        && elememt1 instanceof )
        return true;
    }
}
