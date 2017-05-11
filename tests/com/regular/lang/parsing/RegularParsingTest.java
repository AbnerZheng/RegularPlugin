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

package com.regular.lang.parsing;

import com.intellij.openapi.application.PathManager;
import com.intellij.testFramework.ParsingTestCase;
import com.netease.regular.RegularParserDefinition;
import com.regular.RegularTestUtil;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RegularParsingTest extends ParsingTestCase {
    public RegularParsingTest() {
        super("", "rgl", new RegularParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return Paths.get(RegularTestUtil.getBaseTestDataPath(), "parsing").toString();
//        return "RegularPlugin/testData";
    }

    @Override
    protected boolean skipSpaces() {
        return true;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}
