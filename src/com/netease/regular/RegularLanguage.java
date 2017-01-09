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

package com.netease.regular;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.netease.regular.lang.file.RegularFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RegularLanguage extends Language implements TemplateLanguage {
    public static final Language INSTANCE = new RegularLanguage();

    private RegularLanguage() {
        super("RegularTemplateLanguage");
    }

    public static LanguageFileType getDefaultTemplateLang() {
        return StdFileTypes.HTML;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Regular";
    }

    @Nullable
    @Override
    public LanguageFileType getAssociatedFileType() {
        return RegularFileType.INSTANCE;
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
