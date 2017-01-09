// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RegularPropAssign extends PsiElement {

  @NotNull
  List<RegularAddorsubOperator> getAddorsubOperatorList();

  @NotNull
  List<RegularArgs> getArgsList();

  @NotNull
  List<RegularArray> getArrayList();

  @NotNull
  List<RegularAssignOperator> getAssignOperatorList();

  @NotNull
  List<RegularEquationOperator> getEquationOperatorList();

  @NotNull
  List<RegularExpression> getExpressionList();

  @NotNull
  List<RegularLeftHandExpr> getLeftHandExprList();

  @NotNull
  List<RegularMultOrDivOperator> getMultOrDivOperatorList();

  @NotNull
  List<RegularObject> getObjectList();

  @NotNull
  RegularProp getProp();

  @NotNull
  List<RegularPropertyReferenceSuffix> getPropertyReferenceSuffixList();

  @NotNull
  List<RegularRelationOperator> getRelationOperatorList();

  @NotNull
  List<RegularUnaryOperator> getUnaryOperatorList();

}
