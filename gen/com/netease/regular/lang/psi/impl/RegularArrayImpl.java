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

public class RegularArrayImpl extends ASTWrapperPsiElement implements RegularArray {

  public RegularArrayImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RegularVisitor visitor) {
    visitor.visitArray(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RegularVisitor) accept((RegularVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RegularAddorsubOperator> getAddorsubOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularAddorsubOperator.class);
  }

  @Override
  @NotNull
  public List<RegularArgs> getArgsList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularArgs.class);
  }

  @Override
  @NotNull
  public List<RegularArray> getArrayList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularArray.class);
  }

  @Override
  @NotNull
  public List<RegularAssignOperator> getAssignOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularAssignOperator.class);
  }

  @Override
  @NotNull
  public List<RegularEquationOperator> getEquationOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularEquationOperator.class);
  }

  @Override
  @NotNull
  public List<RegularExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularExpression.class);
  }

  @Override
  @NotNull
  public List<RegularLeftHandExpr> getLeftHandExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularLeftHandExpr.class);
  }

  @Override
  @NotNull
  public List<RegularMultOrDivOperator> getMultOrDivOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularMultOrDivOperator.class);
  }

  @Override
  @NotNull
  public List<RegularObject> getObjectList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularObject.class);
  }

  @Override
  @NotNull
  public List<RegularPropertyReferenceSuffix> getPropertyReferenceSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularPropertyReferenceSuffix.class);
  }

  @Override
  @NotNull
  public List<RegularRelationOperator> getRelationOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularRelationOperator.class);
  }

  @Override
  @NotNull
  public List<RegularUnaryOperator> getUnaryOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularUnaryOperator.class);
  }

}
