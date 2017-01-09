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

package com.netease.regular.lang.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.netease.regular.RegularLanguage;
import com.netease.regular.lang.file.RegularFileType;
import org.jetbrains.annotations.NotNull;

public class RegularFile extends PsiFileBase {
    public RegularFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, RegularLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return RegularFileType.INSTANCE;
    }
}
