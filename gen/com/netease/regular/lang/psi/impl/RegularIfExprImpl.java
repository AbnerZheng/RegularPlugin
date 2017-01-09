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

public class RegularIfExprImpl extends ASTWrapperPsiElement implements RegularIfExpr {

  public RegularIfExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RegularVisitor visitor) {
    visitor.visitIfExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RegularVisitor) accept((RegularVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public RegularElseExpr getElseExpr() {
    return findChildByClass(RegularElseExpr.class);
  }

  @Override
  @Nullable
  public RegularElseifExpr getElseifExpr() {
    return findChildByClass(RegularElseifExpr.class);
  }

  @Override
  @NotNull
  public RegularExpression getExpression() {
    return findNotNullChildByClass(RegularExpression.class);
  }

  @Override
  @NotNull
  public List<RegularIfExpr> getIfExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularIfExpr.class);
  }

  @Override
  @NotNull
  public List<RegularIncludeExpr> getIncludeExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularIncludeExpr.class);
  }

  @Override
  @NotNull
  public List<RegularInterpolationExpr> getInterpolationExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularInterpolationExpr.class);
  }

  @Override
  @NotNull
  public List<RegularListExpr> getListExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularListExpr.class);
  }

}
