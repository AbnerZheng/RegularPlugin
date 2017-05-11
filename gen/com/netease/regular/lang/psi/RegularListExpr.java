// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RegularListExpr extends PsiElement {

  @NotNull
  List<RegularExpression> getExpressionList();

  @Nullable
  RegularStatement getStatement();

  @Nullable
  PsiElement getId();

}
