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

public class RegularListExprImpl extends ASTWrapperPsiElement implements RegularListExpr {

  public RegularListExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RegularVisitor visitor) {
    visitor.visitListExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RegularVisitor) accept((RegularVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<RegularExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, RegularExpression.class);
  }

  @Override
  @Nullable
  public RegularWrapperBlock getWrapperBlock() {
    return findChildByClass(RegularWrapperBlock.class);
  }

  @Override
  @Nullable
  public PsiElement getId() {
    return findChildByType(ID);
  }

}
