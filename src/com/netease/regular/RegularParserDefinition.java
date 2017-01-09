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

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.netease.regular.lang.file.RegularFileElementType;
import com.netease.regular.lang.lexer.RegularLexer;
import com.netease.regular.lang.parser.RegularParser;
import com.netease.regular.lang.psi.RegularFile;
import com.netease.regular.lang.psi.RegularTypes;
import org.jetbrains.annotations.NotNull;

//import static com.netease.regular.lang.JetTypes.Factory;

public class RegularParserDefinition implements ParserDefinition {

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new RegularLexer();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new RegularParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return RegularFileElementType.INSTANCE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return RegularTokens.tsWHITESPACE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return RegularTokens.tsWHITESPACE;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return RegularTokens.tsSTRINGS;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return RegularTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider provider) {
        return new RegularFile(provider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode node, ASTNode node1) {
        return SpaceRequirements.MAY;
    }
}
