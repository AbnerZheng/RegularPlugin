// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.netease.regular.lang.psi.impl.*;

public interface RegularTypes {

  IElementType ADDORSUB_OPERATOR = new RegularElementType("ADDORSUB_OPERATOR");
  IElementType ARGS = new RegularElementType("ARGS");
  IElementType ARRAY = new RegularElementType("ARRAY");
  IElementType ASSIGN_OPERATOR = new RegularElementType("ASSIGN_OPERATOR");
  IElementType BIND_ONCE_EXPR = new RegularElementType("BIND_ONCE_EXPR");
  IElementType CALL_EXPR = new RegularElementType("CALL_EXPR");
  IElementType CALL_EXPR_SUFFIX = new RegularElementType("CALL_EXPR_SUFFIX");
  IElementType ELSEIF_EXPR = new RegularElementType("ELSEIF_EXPR");
  IElementType ELSE_EXPR = new RegularElementType("ELSE_EXPR");
  IElementType EQUATION_OPERATOR = new RegularElementType("EQUATION_OPERATOR");
  IElementType EXPRESSION = new RegularElementType("EXPRESSION");
  IElementType FILTER = new RegularElementType("FILTER");
  IElementType IF_EXPR = new RegularElementType("IF_EXPR");
  IElementType INCLUDE_EXPR = new RegularElementType("INCLUDE_EXPR");
  IElementType INTERPOLATION_EXPR = new RegularElementType("INTERPOLATION_EXPR");
  IElementType LEFT_HAND_EXPR = new RegularElementType("LEFT_HAND_EXPR");
  IElementType LIST_EXPR = new RegularElementType("LIST_EXPR");
  IElementType MULT_OR_DIV_OPERATOR = new RegularElementType("MULT_OR_DIV_OPERATOR");
  IElementType OBJECT = new RegularElementType("OBJECT");
  IElementType PROP = new RegularElementType("PROP");
  IElementType PROPERTY_REFERENCE_SUFFIX = new RegularElementType("PROPERTY_REFERENCE_SUFFIX");
  IElementType PROP_ASSIGN = new RegularElementType("PROP_ASSIGN");
  IElementType RELATION_OPERATOR = new RegularElementType("RELATION_OPERATOR");
  IElementType UNARY_OPERATOR = new RegularElementType("UNARY_OPERATOR");

  IElementType AS = new RegularTokenType("as");
  IElementType AT = new RegularTokenType("@");
  IElementType BY = new RegularTokenType("by");
  IElementType COLON = new RegularTokenType(":");
  IElementType COMMA = new RegularTokenType(",");
  IElementType CONTENT = new RegularTokenType("CONTENT");
  IElementType DOT = new RegularTokenType(".");
  IElementType ELSE = new RegularTokenType("else");
  IElementType ELSEIF = new RegularTokenType("elseif");
  IElementType ENDCOMMAND = new RegularTokenType("{/");
  IElementType FALSE = new RegularTokenType("false");
  IElementType FILTEROP = new RegularTokenType("|");
  IElementType ID = new RegularTokenType("ID");
  IElementType IF = new RegularTokenType("if");
  IElementType INCLUDE = new RegularTokenType("include");
  IElementType LBRACE = new RegularTokenType("{");
  IElementType LBRAKET = new RegularTokenType("[");
  IElementType LIST = new RegularTokenType("list");
  IElementType LPARAM = new RegularTokenType("(");
  IElementType NULL = new RegularTokenType("null");
  IElementType NUMBER = new RegularTokenType("NUMBER");
  IElementType RBRACE = new RegularTokenType("}");
  IElementType RBRAKET = new RegularTokenType("]");
  IElementType RPARAM = new RegularTokenType(")");
  IElementType STARTCOMMAND = new RegularTokenType("{#");
  IElementType STRING = new RegularTokenType("STRING");
  IElementType THIS = new RegularTokenType("this");
  IElementType TRUE = new RegularTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ADDORSUB_OPERATOR) {
        return new RegularAddorsubOperatorImpl(node);
      }
      else if (type == ARGS) {
        return new RegularArgsImpl(node);
      }
      else if (type == ARRAY) {
        return new RegularArrayImpl(node);
      }
      else if (type == ASSIGN_OPERATOR) {
        return new RegularAssignOperatorImpl(node);
      }
      else if (type == BIND_ONCE_EXPR) {
        return new RegularBindOnceExprImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new RegularCallExprImpl(node);
      }
      else if (type == CALL_EXPR_SUFFIX) {
        return new RegularCallExprSuffixImpl(node);
      }
      else if (type == ELSEIF_EXPR) {
        return new RegularElseifExprImpl(node);
      }
      else if (type == ELSE_EXPR) {
        return new RegularElseExprImpl(node);
      }
      else if (type == EQUATION_OPERATOR) {
        return new RegularEquationOperatorImpl(node);
      }
      else if (type == EXPRESSION) {
        return new RegularExpressionImpl(node);
      }
      else if (type == FILTER) {
        return new RegularFilterImpl(node);
      }
      else if (type == IF_EXPR) {
        return new RegularIfExprImpl(node);
      }
      else if (type == INCLUDE_EXPR) {
        return new RegularIncludeExprImpl(node);
      }
      else if (type == INTERPOLATION_EXPR) {
        return new RegularInterpolationExprImpl(node);
      }
      else if (type == LEFT_HAND_EXPR) {
        return new RegularLeftHandExprImpl(node);
      }
      else if (type == LIST_EXPR) {
        return new RegularListExprImpl(node);
      }
      else if (type == MULT_OR_DIV_OPERATOR) {
        return new RegularMultOrDivOperatorImpl(node);
      }
      else if (type == OBJECT) {
        return new RegularObjectImpl(node);
      }
      else if (type == PROP) {
        return new RegularPropImpl(node);
      }
      else if (type == PROPERTY_REFERENCE_SUFFIX) {
        return new RegularPropertyReferenceSuffixImpl(node);
      }
      else if (type == PROP_ASSIGN) {
        return new RegularPropAssignImpl(node);
      }
      else if (type == RELATION_OPERATOR) {
        return new RegularRelationOperatorImpl(node);
      }
      else if (type == UNARY_OPERATOR) {
        return new RegularUnaryOperatorImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
