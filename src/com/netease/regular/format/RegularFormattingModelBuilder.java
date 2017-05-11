package com.netease.regular.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.formatter.xml.SyntheticBlock;
import com.intellij.psi.templateLanguages.SimpleTemplateLanguageFormattingModelBuilder;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.xml.XmlTag;
import com.netease.regular.RegularTokens;
import com.netease.regular.ide.templates.RegularContext;
import com.netease.regular.lang.psi.RegularStatement;
import com.netease.regular.lang.psi.RegularTokenType;
import com.netease.regular.lang.psi.RegularTypes;
import com.netease.regular.lang.psi.impl.RegularStatementImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.text.resources.cldr.ln.FormatData_ln;

import javax.xml.crypto.Data;
import java.util.List;
import static com.intellij.psi.formatter.WrappingUtil.getWrapType;
import static com.netease.regular.lang.file.RegularFileViewProvider.Regular_FRAGMENT;


/**
 * TemplateLanguageFormattingModelBuilder �ṩģ�����Ĺ���
 * Created by abnerzheng on 2017/1/11.
 */
public class RegularFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder{
    @Override
    public TemplateLanguageBlock createTemplateLanguageBlock(@NotNull ASTNode node,
                                                             @Nullable Wrap wrap,
                                                             @Nullable Alignment alignment,
                                                             @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                                             @NotNull CodeStyleSettings codeStyleSettings) {
        final FormattingDocumentModelImpl documentModel = FormattingDocumentModelImpl.createOn(node.getPsi().getContainingFile());
        HtmlPolicy policy = new HtmlPolicy(codeStyleSettings, documentModel);
        return new RegularBlock(node, wrap, alignment, this, codeStyleSettings, foreignChildren, policy);

    }

    /**
     * ����Handlebar �����˵, ������Ҫoverride{@link com.intellij.formatting.templateLanguages.TemplateLanguageFormattingModelBuilder#createModel}
     * ��Ϊ������������ģ�����Դ��� ��Щ���ԣ�xml/html�������Ǹ�������Ҫ���Ե�
     * @param element
     * @param settings
     * @return
     */
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        //todo ����������

        final PsiFile containingFile = element.getContainingFile();
        Block rootBlock;

        ASTNode node = element.getNode();

        if(node.getElementType() == Regular_FRAGMENT){//����Ԫ����Regular���ⲿԪ��
            return new SimpleTemplateLanguageFormattingModelBuilder().createModel(element, settings); // ����ԭ�е�ģʽ����format
        } else{
         rootBlock = getRootBlock(containingFile, containingFile.getViewProvider(), settings);
        }

        return new DocumentBasedFormattingModel(rootBlock, element.getProject(), settings, containingFile.getFileType(), containingFile);
    }

    @Override
    public boolean dontFormatMyModel() {
        return false; // ����������Ҫ����format
    }

    private static class RegularBlock extends TemplateLanguageBlock{
        @NotNull
        protected final HtmlPolicy myHtmlPolicy;

        RegularBlock(@NotNull ASTNode node,
                     Wrap wrap,
                     Alignment alignment,
                     @NotNull TemplateLanguageBlockFactory blockFactory,
                     @NotNull CodeStyleSettings settings,
                     @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                     @NotNull HtmlPolicy htmlPolicy
                     ){
            super(node, wrap, alignment, blockFactory, settings, foreignChildren);
            myHtmlPolicy = htmlPolicy;
        }

        @Override
        protected IElementType getTemplateTextElementType() {
            return RegularTypes.CONTENT; // ���е�content��Template�������format
        }

        public boolean isRootStatementsElement(PsiElement element){
            PsiElement firstParent = PsiTreeUtil.findFirstParent(element, true, element1 -> element1 != null
              && element1 instanceof RegularStatementImpl);
            return firstParent == null;
        }


        /**
         * ����
         * @return
         */
        @Override
        public Indent getIndent() {
          return Indent.getNoneIndent();
//            if(myNode.getText().trim().length() == 0){ // ���Կհ׷�
//                return Indent.getNoneIndent();
//            }
//             Todo ���Ƿ�Ϊattribute���ж�
//            if(isRootStatementsElement(myNode.getPsi())) {
//              return Indent.getNoneIndent();
//            }
//            DataLanguageBlockWrapper foreignBlockParent = getForeignBlockParent(false);
//            if(foreignBlockParent == null){
//                return Indent.getNormalIndent();
//            }
//
//            if (foreignBlockParent.getNode() instanceof XmlTag) {
//                XmlTag xmlTag = (XmlTag) foreignBlockParent.getNode();
//                if (!myHtmlPolicy.indentChildrenOf(xmlTag)) {
//                     HTML û��indent,���Լ��������Լ���Indent
//                    return Indent.getNormalIndent();
//                }
//            }
//            }
//            return Indent.getNoneIndent();
        }

        private  DataLanguageBlockWrapper getForeignBlockParent(boolean immediate){
            DataLanguageBlockWrapper foreignBlockParent = null;
            BlockWithParent parent = getParent();

            while(parent != null){
                if(parent instanceof DataLanguageBlockWrapper && !(((DataLanguageBlockWrapper) parent).getOriginal() instanceof SyntheticBlock)){
                    foreignBlockParent = (DataLanguageBlockWrapper)parent;
                    break;
                }else if(immediate && parent instanceof RegularBlock){
                    break;
                }
                parent = parent.getParent();
            }

            return foreignBlockParent;
        }

        @Override
        public boolean isRequiredRange(TextRange range) {
            return false;
        }
    }






    private static boolean isAttribute(ASTNode child){
        IElementType type = child.getElementType();
        return type == RegularTypes.LPARAM;
    }
}
