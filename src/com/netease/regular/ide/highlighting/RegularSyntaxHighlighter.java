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

package com.netease.regular.ide.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.netease.regular.RegularTokens;
import com.netease.regular.lang.lexer.RegularLexer;
import com.netease.regular.lang.psi.RegularTypes;
import org.jetbrains.annotations.NotNull;

public class RegularSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey BRACES = TextAttributesKey.createTextAttributesKey("OPEN_CLOSE_TEMPLATE",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    public static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[]{BRACES};

    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("STRING",
            DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};


    public static final TextAttributesKey RULES = TextAttributesKey.createTextAttributesKey("RULES",
            DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey[] RULES_KEYS = new TextAttributesKey[]{RULES};


    public static final TextAttributesKey IDENT = TextAttributesKey.createTextAttributesKey("IDENT",
            DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey[] IDENT_KEYS = new TextAttributesKey[]{IDENT, DefaultLanguageHighlighterColors.GLOBAL_VARIABLE};

    public static final TextAttributesKey COMMENTS = TextAttributesKey.createTextAttributesKey("COMMENTS",
            DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey[] COMMENTS_KEYS = new TextAttributesKey[]{COMMENTS};

    public static final TextAttributesKey BEGINRULE = TextAttributesKey.createTextAttributesKey("BEGIN RULE", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey[] BEGINRULE_KEYS = new TextAttributesKey[]{BEGINRULE};

    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new RegularLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
        if(RegularTokens.tsBRACES.contains(type)){
            return BRACES_KEYS;
        }
        if (RegularTokens.tsSTRINGS.contains(type)) {
            return STRING_KEYS;
        }
        if (RegularTokens.tsRULES.contains(type)) {
            return RULES_KEYS;
        }

        if (type == RegularTypes.ID) {
            return IDENT_KEYS;
        }
//        if (type == RegularTypes.COMM) {
//            return COMMENTS_KEYS;
//        }
        return EMPTY;
    }
}
