package com.regular.ide.fold;

import com.intellij.openapi.application.PathManager;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.regular.RegularTestUtil;
import com.regular.lang.lexer.RegularJsLexerTest;

/**
 * Created by abnerzheng on 2017/1/10.
 */
public class RegularCodeInsightTest extends LightCodeInsightFixtureTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected String getTestDataPath() {
        return RegularTestUtil.getBaseTestDataPath();
    }

    public void testFolding(){
        myFixture.testFolding(getTestDataPath() + "/fold/folding.rgl");
    }
}
