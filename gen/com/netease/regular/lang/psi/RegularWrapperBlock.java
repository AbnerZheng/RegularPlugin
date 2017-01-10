// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RegularWrapperBlock extends PsiElement {

  @NotNull
  List<RegularIfExpr> getIfExprList();

  @NotNull
  List<RegularIncludeExpr> getIncludeExprList();

  @NotNull
  List<RegularInterpolationExpr> getInterpolationExprList();

  @NotNull
  List<RegularListExpr> getListExprList();

}