/*
 *
 *  * Copyright 2016 José Santos
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.netease.regular.lang.file;

import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.openapi.fileTypes.PlainTextLanguage;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import com.intellij.psi.tree.IElementType;
import com.netease.regular.lang.psi.RegularTypes;
import gnu.trove.THashSet;
import com.netease.regular.RegularLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;

public class RegularFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    private final Language myTemplateDataLanguage;
    public static final IElementType Regular_FRAGMENT = new IElementType("RegularFragmentElementType", RegularLanguage.INSTANCE);
    public static final IElementType TEMPLATE_DATA =
            new TemplateDataElementType("RegularTextElementType", RegularLanguage.INSTANCE, RegularTypes.CONTENT, Regular_FRAGMENT);

    public RegularFileViewProvider(PsiManager manager, VirtualFile file, boolean physical) {
        super(manager, file, physical);

        Language dataLang = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if (dataLang == null) dataLang = StdFileTypes.HTML.getLanguage();

        if (dataLang instanceof TemplateLanguage) {
            myTemplateDataLanguage = PlainTextLanguage.INSTANCE;
        } else {
            myTemplateDataLanguage = LanguageSubstitutors.INSTANCE.substituteLanguage(dataLang, file, manager.getProject());
        }
    }

    public RegularFileViewProvider(PsiManager psiManager, VirtualFile virtualFile, boolean physical, Language myTemplateDataLanguage) {
        super(psiManager, virtualFile, physical);
        this.myTemplateDataLanguage = myTemplateDataLanguage;
    }


    @NotNull
    @Override
    public Language getBaseLanguage() {
        return RegularLanguage.INSTANCE;
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return myTemplateDataLanguage;
    }

    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return new THashSet<Language>(Arrays.asList(new Language[]{RegularLanguage.INSTANCE, myTemplateDataLanguage}));
    }


    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(VirtualFile file) {
        return new RegularFileViewProvider(getManager(), file, false, myTemplateDataLanguage);
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Language lang) {
        if (lang == myTemplateDataLanguage) {
            PsiFileImpl file = (PsiFileImpl) LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
            file.setContentElementType(TEMPLATE_DATA);
            return file;
        } else if (lang == RegularLanguage.INSTANCE) {
            return LanguageParserDefinitions.INSTANCE.forLanguage(lang).createFile(this);
        } else {
            return null;
        }
    }
}
