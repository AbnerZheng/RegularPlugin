package com.netease.regular.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.netease.regular.lang.psi.RegularTypes.*;

%%

%{
  public _RegularLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _RegularLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode
%state YYCONTENT

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
CONTENT=\"[^\"\{]*\"
NUMBER=[0-9]+
ID=[a-zA-Z][a-zA-Z_0-9]*

%%
<YYINITIAL> {
       "{"             { yypushback(1); yybegin(YYCONTENT);}
        [^{]+           { return CONTENT; }
}
<YYCONTENT> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  "{"                { return LBRACE; }
  "}"                { yybegin(YYINITIAL); return RBRACE; }
  "["                { return LBRAKET; }
  "]"                { return RBRAKET; }
  "."                { return DOT; }
  "{#"               { return STARTCOMMAND; }
  "{/"               { return ENDCOMMAND; }
  "if"               { return IF; }
  "else"             { return ELSE; }
  "elseif"           { return ELSEIF; }
  "|"                { return FILTEROP; }
  "list"             { return LIST; }
  "as"               { return AS; }
  "@"                { return AT; }
  "by"               { return BY; }
  "this"             { return THIS; }
  "null"             { return NULL; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  ","                { return COMMA; }
  ":"                { return COLON; }
  "("                { return LPARAM; }
  ")"                { return RPARAM; }
  "include"          { return INCLUDE; }
  "STRING"           { return STRING; }

  {NUMBER}           { return NUMBER; }
  {ID}               { return ID; }

}

[^] { return BAD_CHARACTER; }
