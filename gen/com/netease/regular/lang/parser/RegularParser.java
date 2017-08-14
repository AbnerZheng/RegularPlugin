// This is a generated file. Not intended for manual editing.
package com.netease.regular.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.netease.regular.lang.psi.RegularTypes.*;
import static com.netease.regular.lang.parser.RegularParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class RegularParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ADDORSUB_OPERATOR) {
      r = addorsubOperator(b, 0);
    }
    else if (t == ARGS) {
      r = args(b, 0);
    }
    else if (t == ARRAY) {
      r = array(b, 0);
    }
    else if (t == ASSIGN_OPERATOR) {
      r = assignOperator(b, 0);
    }
    else if (t == BIND_ONCE_EXPR) {
      r = bindOnceExpr(b, 0);
    }
    else if (t == CALL_EXPR) {
      r = callExpr(b, 0);
    }
    else if (t == CALL_EXPR_SUFFIX) {
      r = callExprSuffix(b, 0);
    }
    else if (t == ELSE_EXPR) {
      r = elseExpr(b, 0);
    }
    else if (t == ELSEIF_EXPR) {
      r = elseifExpr(b, 0);
    }
    else if (t == EQUATION_OPERATOR) {
      r = equationOperator(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == FILTER) {
      r = filter(b, 0);
    }
    else if (t == IF_EXPR) {
      r = ifExpr(b, 0);
    }
    else if (t == IF_EXPR_START) {
      r = ifExprStart(b, 0);
    }
    else if (t == INCLUDE_EXPR) {
      r = includeExpr(b, 0);
    }
    else if (t == INTERPOLATION_EXPR) {
      r = interpolationExpr(b, 0);
    }
    else if (t == LEFT_HAND_EXPR) {
      r = leftHandExpr(b, 0);
    }
    else if (t == LIST_EXPR) {
      r = listExpr(b, 0);
    }
    else if (t == MULT_OR_DIV_OPERATOR) {
      r = multOrDivOperator(b, 0);
    }
    else if (t == OBJECT) {
      r = object(b, 0);
    }
    else if (t == PROPERTY_REFERENCE_SUFFIX) {
      r = propertyReferenceSuffix(b, 0);
    }
    else if (t == RELATION_OPERATOR) {
      r = relationOperator(b, 0);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == UNARY_OPERATOR) {
      r = unaryOperator(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // multive (addorsubOperator multive)*
  static boolean additive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multive(b, l + 1);
    r = r && additive_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (addorsubOperator multive)*
  private static boolean additive_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!additive_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additive_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // addorsubOperator multive
  private static boolean additive_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additive_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = addorsubOperator(b, l + 1);
    r = r && multive(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-'
  public static boolean addorsubOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addorsubOperator")) return false;
    if (!nextTokenIs(b, "<addorsub operator>", ADD, SUB)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDORSUB_OPERATOR, "<addorsub operator>");
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equal '&&' and | equal
  static boolean and(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = and_0(b, l + 1);
    if (!r) r = equal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // equal '&&' and
  private static boolean and_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equal(b, l + 1);
    r = r && consumeToken(b, ANDOP);
    r = r && and(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // assign (COMMA assign)*
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, ARGS, "<args>");
    r = assign(b, l + 1);
    r = r && args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA assign)*
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA assign
  private static boolean args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRAKET assign (COMMA assign)* RBRAKET
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, LBRAKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRAKET);
    r = r && assign(b, l + 1);
    r = r && array_2(b, l + 1);
    r = r && consumeToken(b, RBRAKET);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // (COMMA assign)*
  private static boolean array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!array_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA assign
  private static boolean array_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // condition | leftHandExpr assignOperator condition
  static boolean assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condition(b, l + 1);
    if (!r) r = assign_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // leftHandExpr assignOperator condition
  private static boolean assign_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = leftHandExpr(b, l + 1);
    r = r && assignOperator(b, l + 1);
    r = r && condition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '=' | '+=' | '-=' | '*=' | '/=' | '%='
  public static boolean assignOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_OPERATOR, "<assign operator>");
    r = consumeToken(b, ASSIGNOP);
    if (!r) r = consumeToken(b, ADDASSIGN);
    if (!r) r = consumeToken(b, SUBASSIGN);
    if (!r) r = consumeToken(b, MULASSIGN);
    if (!r) r = consumeToken(b, DIVASSIGN);
    if (!r) r = consumeToken(b, MODASSIGN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AT LPARAM expr RPARAM
  public static boolean bindOnceExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bindOnceExpr")) return false;
    if (!nextTokenIs(b, AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT, LPARAM);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPARAM);
    exit_section_(b, m, BIND_ONCE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // member LPARAM args? RPARAM callExprSuffix*
  public static boolean callExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL_EXPR, "<call expr>");
    r = member(b, l + 1);
    r = r && consumeToken(b, LPARAM);
    r = r && callExpr_2(b, l + 1);
    r = r && consumeToken(b, RPARAM);
    r = r && callExpr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // args?
  private static boolean callExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpr_2")) return false;
    args(b, l + 1);
    return true;
  }

  // callExprSuffix*
  private static boolean callExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpr_4")) return false;
    int c = current_position_(b);
    while (true) {
      if (!callExprSuffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "callExpr_4", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // LPARAM args? RPARAM
  //                  | indexSuffix
  //                  | propertyReferenceSuffix
  public static boolean callExprSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExprSuffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL_EXPR_SUFFIX, "<call expr suffix>");
    r = callExprSuffix_0(b, l + 1);
    if (!r) r = indexSuffix(b, l + 1);
    if (!r) r = propertyReferenceSuffix(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPARAM args? RPARAM
  private static boolean callExprSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExprSuffix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARAM);
    r = r && callExprSuffix_0_1(b, l + 1);
    r = r && consumeToken(b, RPARAM);
    exit_section_(b, m, null, r);
    return r;
  }

  // args?
  private static boolean callExprSuffix_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExprSuffix_0_1")) return false;
    args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // or '?' assign COLON assign
  //             | or
  static boolean condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = condition_0(b, l + 1);
    if (!r) r = or(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // or '?' assign COLON assign
  private static boolean condition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "condition_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = or(b, l + 1);
    r = r && consumeToken(b, "?");
    r = r && assign(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && assign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // STARTCOMMAND ELSE RBRACE statement?
  public static boolean elseExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseExpr")) return false;
    if (!nextTokenIs(b, STARTCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STARTCOMMAND, ELSE, RBRACE);
    r = r && elseExpr_3(b, l + 1);
    exit_section_(b, m, ELSE_EXPR, r);
    return r;
  }

  // statement?
  private static boolean elseExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseExpr_3")) return false;
    statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STARTCOMMAND ELSEIF expression RBRACE statement?
  public static boolean elseifExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifExpr")) return false;
    if (!nextTokenIs(b, STARTCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STARTCOMMAND, ELSEIF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && elseifExpr_4(b, l + 1);
    exit_section_(b, m, ELSEIF_EXPR, r);
    return r;
  }

  // statement?
  private static boolean elseifExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseifExpr_4")) return false;
    statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // relation (equationOperator relation)*
  static boolean equal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equal")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relation(b, l + 1);
    r = r && equal_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (equationOperator relation)*
  private static boolean equal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equal_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!equal_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equal_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // equationOperator relation
  private static boolean equal_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equal_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equationOperator(b, l + 1);
    r = r && relation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '==' | '===' | '!=' | '!=='
  public static boolean equationOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equationOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUATION_OPERATOR, "<equation operator>");
    r = consumeToken(b, EQUALEQUAL);
    if (!r) r = consumeToken(b, STRICTEQUAL);
    if (!r) r = consumeToken(b, "!=");
    if (!r) r = consumeToken(b, "!==");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // filter
  static boolean expr(PsiBuilder b, int l) {
    return filter(b, l + 1);
  }

  /* ********************************************************** */
  // bindOnceExpr | expr
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = bindOnceExpr(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // statement*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    int c = current_position_(b);
    while (true) {
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // assign (FILTEROP ID (COLON args)?)*
  public static boolean filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILTER, "<filter>");
    r = assign(b, l + 1);
    r = r && filter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (FILTEROP ID (COLON args)?)*
  private static boolean filter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!filter_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "filter_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // FILTEROP ID (COLON args)?
  private static boolean filter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FILTEROP, ID);
    r = r && filter_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON args)?
  private static boolean filter_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_1_0_2")) return false;
    filter_1_0_2_0(b, l + 1);
    return true;
  }

  // COLON args
  private static boolean filter_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && args(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ifExprStart statement? elseifExpr? elseExpr? ENDCOMMAND IF RBRACE
  public static boolean ifExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpr")) return false;
    if (!nextTokenIs(b, STARTCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ifExprStart(b, l + 1);
    r = r && ifExpr_1(b, l + 1);
    r = r && ifExpr_2(b, l + 1);
    r = r && ifExpr_3(b, l + 1);
    r = r && consumeTokens(b, 0, ENDCOMMAND, IF, RBRACE);
    exit_section_(b, m, IF_EXPR, r);
    return r;
  }

  // statement?
  private static boolean ifExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpr_1")) return false;
    statement(b, l + 1);
    return true;
  }

  // elseifExpr?
  private static boolean ifExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpr_2")) return false;
    elseifExpr(b, l + 1);
    return true;
  }

  // elseExpr?
  private static boolean ifExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExpr_3")) return false;
    elseExpr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // STARTCOMMAND IF expression RBRACE
  public static boolean ifExprStart(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifExprStart")) return false;
    if (!nextTokenIs(b, STARTCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STARTCOMMAND, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, IF_EXPR_START, r);
    return r;
  }

  /* ********************************************************** */
  // STARTCOMMAND INCLUDE ID RBRACE
  public static boolean includeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "includeExpr")) return false;
    if (!nextTokenIs(b, STARTCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STARTCOMMAND, INCLUDE, ID, RBRACE);
    exit_section_(b, m, INCLUDE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // LBRAKET expression RBRAKET
  static boolean indexSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexSuffix")) return false;
    if (!nextTokenIs(b, LBRAKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRAKET);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RBRAKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE expression  RBRACE
  public static boolean interpolationExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interpolationExpr")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, INTERPOLATION_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // callExpr | member
  public static boolean leftHandExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "leftHandExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LEFT_HAND_EXPR, "<left hand expr>");
    r = callExpr(b, l + 1);
    if (!r) r = member(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STARTCOMMAND LIST expression (AS ID (BY expression)?)? RBRACE statement? ENDCOMMAND LIST RBRACE
  public static boolean listExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr")) return false;
    if (!nextTokenIs(b, STARTCOMMAND)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STARTCOMMAND, LIST);
    r = r && expression(b, l + 1);
    r = r && listExpr_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && listExpr_5(b, l + 1);
    r = r && consumeTokens(b, 0, ENDCOMMAND, LIST, RBRACE);
    exit_section_(b, m, LIST_EXPR, r);
    return r;
  }

  // (AS ID (BY expression)?)?
  private static boolean listExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_3")) return false;
    listExpr_3_0(b, l + 1);
    return true;
  }

  // AS ID (BY expression)?
  private static boolean listExpr_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, ID);
    r = r && listExpr_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (BY expression)?
  private static boolean listExpr_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_3_0_2")) return false;
    listExpr_3_0_2_0(b, l + 1);
    return true;
  }

  // BY expression
  private static boolean listExpr_3_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_3_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BY);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // statement?
  private static boolean listExpr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listExpr_5")) return false;
    statement(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NULL | TRUE
  //             | FALSE
  //             | STRING
  //             | NUMBER
  static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primary memberSuffix*
  static boolean member(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary(b, l + 1);
    r = r && member_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // memberSuffix*
  private static boolean member_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "member_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!memberSuffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "member_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // indexSuffix | propertyReferenceSuffix | LPARAM args? RPARAM
  static boolean memberSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberSuffix")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexSuffix(b, l + 1);
    if (!r) r = propertyReferenceSuffix(b, l + 1);
    if (!r) r = memberSuffix_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPARAM args? RPARAM
  private static boolean memberSuffix_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberSuffix_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARAM);
    r = r && memberSuffix_2_1(b, l + 1);
    r = r && consumeToken(b, RPARAM);
    exit_section_(b, m, null, r);
    return r;
  }

  // args?
  private static boolean memberSuffix_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberSuffix_2_1")) return false;
    args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '*' | '/'
  public static boolean multOrDivOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multOrDivOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULT_OR_DIV_OPERATOR, "<mult or div operator>");
    r = consumeToken(b, "*");
    if (!r) r = consumeToken(b, "/");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unary (multOrDivOperator unary)*
  static boolean multive(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multive")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary(b, l + 1);
    r = r && multive_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (multOrDivOperator unary)*
  private static boolean multive_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multive_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!multive_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multive_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // multOrDivOperator unary
  private static boolean multive_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multive_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multOrDivOperator(b, l + 1);
    r = r && unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE propAssign (COMMA propAssign)* RBRACE
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && propAssign(b, l + 1);
    r = r && object_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, OBJECT, r);
    return r;
  }

  // (COMMA propAssign)*
  private static boolean object_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!object_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "object_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA propAssign
  private static boolean object_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && propAssign(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // and '||' or | and
  static boolean or(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = or_0(b, l + 1);
    if (!r) r = and(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // and '||' or
  private static boolean or_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = and(b, l + 1);
    r = r && consumeToken(b, OROP);
    r = r && or(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THIS | ID
  //              | literal | array
  //              | object | LPARAM expression RPARAM
  static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THIS);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = literal(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = object(b, l + 1);
    if (!r) r = primary_5(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPARAM expression RPARAM
  private static boolean primary_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPARAM);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPARAM);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | ID | STRING
  static boolean prop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prop")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ID);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // prop COLON prop
  static boolean propAssign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propAssign")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prop(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && prop(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOT ID
  public static boolean propertyReferenceSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertyReferenceSuffix")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID);
    exit_section_(b, m, PROPERTY_REFERENCE_SUFFIX, r);
    return r;
  }

  /* ********************************************************** */
  // additive (relationOperator additive)*
  static boolean relation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additive(b, l + 1);
    r = r && relation_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (relationOperator additive)*
  private static boolean relation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!relation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relation_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // relationOperator additive
  private static boolean relation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relation_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationOperator(b, l + 1);
    r = r && additive(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SMALLER | BIGGER | BIGGEREQUAL | SMALLEREQUAL
  public static boolean relationOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATION_OPERATOR, "<relation operator>");
    r = consumeToken(b, SMALLER);
    if (!r) r = consumeToken(b, BIGGER);
    if (!r) r = consumeToken(b, BIGGEREQUAL);
    if (!r) r = consumeToken(b, SMALLEREQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (CONTENT | ifExpr | listExpr | interpolationExpr | includeExpr | COMMENT)+
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!statement_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CONTENT | ifExpr | listExpr | interpolationExpr | includeExpr | COMMENT
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTENT);
    if (!r) r = ifExpr(b, l + 1);
    if (!r) r = listExpr(b, l + 1);
    if (!r) r = interpolationExpr(b, l + 1);
    if (!r) r = includeExpr(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unaryOperator unary | member
  static boolean unary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary_0(b, l + 1);
    if (!r) r = member(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unaryOperator unary
  private static boolean unary_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryOperator(b, l + 1);
    r = r && unary(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' | '-' | '~' | '!'
  public static boolean unaryOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OPERATOR, "<unary operator>");
    r = consumeToken(b, ADD);
    if (!r) r = consumeToken(b, SUB);
    if (!r) r = consumeToken(b, BITNOTOP);
    if (!r) r = consumeToken(b, NOTOP);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
