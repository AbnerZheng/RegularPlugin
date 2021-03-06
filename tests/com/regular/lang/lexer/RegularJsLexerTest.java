package com.regular.lang.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.application.PathManager;
import com.intellij.testFramework.LexerTestCase;
import com.netease.regular.lang.lexer.RegularLexer;
import com.regular.RegularTestUtil;

import java.nio.file.Paths;

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

    public void testNei(){
        doFileTest("rgl");
    }
    public void testComment(){
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

    public void testHash(){
        doFileTest("rgl");
    }

    @Override
    protected String getDirPath() {
        return Paths.get(RegularTestUtil.getBaseTestDataPath(), "lexer").toString().substring(PathManager.getHomePath().length());
    }
}
