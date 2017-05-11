package com.netease.regular.ide.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.CustomFoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.netease.regular.lang.psi.*;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Created by abnerzheng on 2017/1/10.
 *
 * @link https://github.com/JetBrains/intellij-plugins/blob/master/handlebars/src/com/dmarcotte/handlebars/editor/folding/HbFoldingBuilder.java
 */
public class RegularFoldingBuilder extends CustomFoldingBuilder implements DumbAware {

    @Override
    protected void buildLanguageFoldRegions(@NotNull List<FoldingDescriptor> list, @NotNull PsiElement psiElement, @NotNull Document document, boolean b) {
        if (!(psiElement instanceof RegularFile)) return;

        final RegularFile regularFile = (RegularFile) psiElement;

        final Collection<PsiElement> collection = PsiTreeUtil.collectElementsOfType(psiElement, new Class[]{RegularStatement.class});
//        foldCommens(list, collection, fileHeaderRange);
        foldBlock(list, collection, document);
    }

    private void foldBlock(List<FoldingDescriptor> list, Collection<PsiElement> collection, Document document) {
        for (PsiElement psiElement : collection) {
            final RegularStatement blockElement = (RegularStatement) psiElement; // blockElement 一定是非空，但是还是判断一下
            if (blockElement.getFirstChild() == null) {
                continue;
            }

            list.add(new FoldingDescriptor(blockElement, blockElement.getTextRange()));
        }

    }

    @Override
    protected String getLanguagePlaceholderText(@NotNull ASTNode astNode, @NotNull TextRange textRange) {
//        final PsiElement psi = astNode.getPsi();
//        if(isSingleLine(psi, textRange)){
//            return "...";
//        }
//        return "\n...\n";
        return "...";
    }

    @Override
    protected boolean isRegionCollapsedByDefault(@NotNull ASTNode astNode) {
        return false;
    }

    /**
     * 判断是否为多行
     *
     * @param element
     * @param textRange
     * @return boolean
     */
    private static boolean isSingleLine(PsiElement element, TextRange textRange) {
        return element.getText().indexOf('\n') == -1;
    }
}
