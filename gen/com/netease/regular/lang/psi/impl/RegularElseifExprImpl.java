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

public class RegularElseifExprImpl extends ASTWrapperPsiElement implements RegularElseifExpr {

  public RegularElseifExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull RegularVisitor visitor) {
    visitor.visitElseifExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof RegularVisitor) accept((RegularVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public RegularExpression getExpression() {
    return findNotNullChildByClass(RegularExpression.class);
  }

  @Override
  @Nullable
  public RegularStatement getStatement() {
    return findChildByClass(RegularStatement.class);
  }

}
