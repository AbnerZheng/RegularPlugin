package com.netease.regular.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.grammar.psi.BnfTypes;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.netease.regular.lang.psi.RegularTypes.*;

%%

%{
  StringBuffer string = new StringBuffer();

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
%state YYCONTENT, YYSTRING

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
CONTENT=\"[^\"\{]*\"
NUMBER=[0-9]+
ID=[_$a-zA-Z][_$a-zA-Z_0-9]*

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
  "==="              { return STRICTEQUAL; }
  "=="               { return EQUALEQUAL; }
  \"                 { string.setLength(0); yybegin(YYSTRING);}
  "="                { return ASSIGNOP; }
  "+="               { return ADDASSIGN; }
  "-="               { return SUBASSIGN; }
  "*="               { return MULASSIGN; }
  "/="               { return DIVASSIGN; }
  "%="               { return MODASSIGN; }
  "+"                { return ADD; }
  "-"                { return SUB; }
  ","                { return COMMA; }
  ":"                { return COLON; }
  "("                { return LPARAM; }
  ")"                { return RPARAM; }
  "include"          { return INCLUDE; }
  "STRING"           { return STRING; }

  {NUMBER}           { return NUMBER; }
  {ID}               { return ID; }

}

<YYSTRING> {
    \"               { yybegin(YYCONTENT); return STRING; }
    [^\n\r\"\\]+                   { string.append( yytext() ); }
          \\t                            { string.append('\t'); }
          \\n                            { string.append('\n'); }

          \\r                            { string.append('\r'); }
          \\\"                           { string.append('\"'); }
          \\                             { string.append('\\'); }

}

[^] { return BAD_CHARACTER; }
