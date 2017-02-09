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

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

import static com.intellij.psi.CustomHighlighterTokenType.STRING;
import static com.netease.regular.lang.psi.RegularTypes.*;
import static javax.xml.stream.XMLStreamConstants.COMMENT;


public interface RegularTokens {
    TokenSet tsSTRINGS = TokenSet.create(STRING);
    //    TokenSet tsCOMMENTS = TokenSet.create(COMMENT);
    TokenSet tsWHITESPACE = TokenSet.create(TokenType.WHITE_SPACE);
    TokenSet tsRULES = TokenSet.create(
            IF,
            ELSE,
            ELSEIF,
            LIST,
            INCLUDE
    );
    TokenSet tsBRACES = TokenSet.create(
            RBRACE,
            LBRACE,
            STARTCOMMAND,
            ENDCOMMAND
    );
}
