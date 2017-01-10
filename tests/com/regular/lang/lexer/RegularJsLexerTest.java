package com.regular.lang.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.application.PathManager;
import com.intellij.testFramework.LexerTestCase;
import com.netease.regular.lang.lexer.RegularLexer;
import com.regular.RegularTestUtil;

/**
 * Created by abnerzheng on 2017/1/9.
 */
public class RegularJsLexerTest extends LexerTestCase {
    @Override
    protected Lexer createLexer() {
        return new RegularLexer();
    }

    public void testIdent() {
        doFileTest("rgl");
    }

    public void testList(){
        doFileTest("rgl");
    }

    public void testIf(){
        doFileTest("rgl");
    }

    public void testDirective(){
        doFileTest("rgl");
    }
    public void testInclude(){
        doFileTest("rgl");
    }

    public void testBugfix(){
        doFileTest("rgl");
    }

    @Override
    protected String getDirPath() {
        return RegularTestUtil.getBaseTestDataPath(RegularJsLexerTest.class).substring(PathManager.getHomePath().length());
    }
}
