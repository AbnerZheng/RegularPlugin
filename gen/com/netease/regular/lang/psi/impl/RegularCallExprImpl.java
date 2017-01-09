// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.netease.regular.lang.psi.RegularTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.netease.regular.lang.psi.*;

public class RegularCallExprImpl extends ASTWrapperPsiElement implements RegularCallExpr {

  public RegularCallExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RegularVisitor visitor) {
    visitor.visitCallExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RegularVisitor) accept((RegularVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RegularArgs> getArgsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularArgs.class);
  }

  @Override
  @Nullable
  public RegularArray getArray() {
    return findChildByClass(RegularArray.class);
  }

  @Override
  @NotNull
  public List<RegularCallExprSuffix> getCallExprSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularCallExprSuffix.class);
  }

  @Override
  @NotNull
  public List<RegularExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularExpression.class);
  }

  @Override
  @Nullable
  public RegularObject getObject() {
    return findChildByClass(RegularObject.class);
  }

  @Override
  @NotNull
  public List<RegularPropertyReferenceSuffix> getPropertyReferenceSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularPropertyReferenceSuffix.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

}
