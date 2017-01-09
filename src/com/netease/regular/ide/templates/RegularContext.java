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

package com.netease.regular.ide.templates;

import com.intellij.codeInsight.template.TemplateContextType;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.netease.regular.RegularLanguage;
import org.jetbrains.annotations.NotNull;

public class RegularContext extends TemplateContextType {
    protected RegularContext() {
        super("Regular", "Regular");
    }

    @Override
    public boolean isInContext(@NotNull PsiFile psiFile, int i) {
        PsiElement elementAt = psiFile.findElementAt(i);
        if (elementAt != null) {
            return psiFile.getLanguage().is(RegularLanguage.INSTANCE) && !elementAt.getLanguage().is(RegularLanguage.INSTANCE);
        }
        return false;
    }
}
