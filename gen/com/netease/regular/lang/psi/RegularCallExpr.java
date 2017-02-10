// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface RegularCallExpr extends PsiElement {

  @NotNull
  List<RegularArgs> getArgsList();

  @Nullable
  RegularArray getArray();

  @NotNull
  List<RegularCallExprSuffix> getCallExprSuffixList();

  @NotNull
  List<RegularExpression> getExpressionList();

  @Nullable
  RegularObject getObject();

  @NotNull
  List<RegularPropertyReferenceSuffix> getPropertyReferenceSuffixList();

  @Nullable
  PsiElement getId();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

}
