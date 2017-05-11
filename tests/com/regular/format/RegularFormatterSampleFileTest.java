package com.regular.format;

import com.intellij.lang.javascript.JavaScriptFileType;

/**
 * Created by abnerzheng on 2017/5/10.
 */
public class RegularFormatterSampleFileTest extends RegularFormatterTest{
  public void testRuleAsRoot()
    throws Exception {
    doFileBasedTest();
  }

//  /**
//   * Test out formatting with a non-HTML template data language
//   *
//   * @throws Exception
//   */
//  public void testSampleFileWithCustomTemplateDataLang()
//    throws Exception {
//    doFileBasedTest("JSSampleFile.rgl", JavaScriptFileType.INSTANCE);
//  }
}
