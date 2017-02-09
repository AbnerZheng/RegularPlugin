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
import com.intellij.psi.xml.XmlTag;
import com.netease.regular.RegularTokens;
import com.netease.regular.lang.psi.RegularTokenType;
import com.netease.regular.lang.psi.RegularTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.text.resources.cldr.ln.FormatData_ln;

import javax.xml.crypto.Data;
import java.util.List;
import static com.intellij.psi.formatter.WrappingUtil.getWrapType;
import static com.netease.regular.lang.file.RegularFileViewProvider.Regular_FRAGMENT;


/**
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
     * 正如Handlebar 插件所说
     * @param element
     * @param settings
     * @return
     */
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        //todo 加上配置项

        final PsiFile containingFile = element.getContainingFile();
        Block rootBlock;

        ASTNode node = element.getNode();

//        if(node.getElementType() != Regular_FRAGMENT){// 外部元素
//            return new SimpleTemplateLanguageFormattingModelBuilder().createModel(element, settings); // 按照原有的模式进行format
//        } else{

         rootBlock = getRootBlock(containingFile, containingFile.getViewProvider(), settings);
//        }

        return new DocumentBasedFormattingModel(rootBlock, element.getProject(), settings, containingFile.getFileType(), containingFile);
    }

    @Override
    public boolean dontFormatMyModel() {
        return false; // 负负得正，要求做format
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
            return RegularTypes.CONTENT; // 所有的content由Template引擎进行format
        }

        @Override
        public Indent getIndent() {
            if(myNode.getText().trim().length() == 0){ // 忽略空白符
                return Indent.getNoneIndent();
            }
            // Todo 对是否为attribute的判断
            DataLanguageBlockWrapper foreignBlockParent = getForeignBlockParent(false);
            if(foreignBlockParent == null){
                return Indent.getNormalIndent();
            }

            if(foreignBlockParent.getNode() instanceof XmlTag){
                XmlTag xmlTag = (XmlTag) foreignBlockParent.getNode();
                if(!myHtmlPolicy.indentChildrenOf(xmlTag)){
                    // HTML 没有indent,所以加上我们自己的Indent
                    return Indent.getNormalIndent();
                }
            }
            return Indent.getNoneIndent();
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
