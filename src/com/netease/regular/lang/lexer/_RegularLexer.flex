package com.netease.regular.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.netease.regular.lang.psi.RegularTypes.*;

%%

%{
  StringBuffer string = new StringBuffer();
  int lBraceCount = 0;

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
%state YYCONTENT, YYTAG, YYCOMMENT

EOL=\R
LineTerminator = \r|\n|\r\n

WHITE_SPACE={LineTerminator} | [ \t\f]

SPACE=[ \t\n\x0B\f\r]+
CONTENT=\"[^\"\{]*\"
NUMBER=[0-9]+
ID=[_$a-zA-Z][_$a-zA-Z_0-9]*

%%
<YYINITIAL> {
        {WHITE_SPACE}  {}
       "{"             { yypushback(1); yybegin(YYCONTENT);}
        "<!--"          { yybegin(YYCOMMENT);}
        [^{]           { yypushback(1); yybegin(YYTAG);}
}

<YYCOMMENT>{
        ~"-->" { yybegin(YYINITIAL); return COMMENT;}
}

<YYTAG>{
    {WHITE_SPACE}  {}
    "{"         {yypushback(1); yybegin(YYCONTENT);}
    ~("<!--"|"{")     {
                  if(yytext().toString().endsWith("{")){
                    yypushback(1);
                    yybegin(YYCONTENT);
                    return CONTENT;
                  }
                  yypushback(4);
                  yybegin(YYCOMMENT);
                  return CONTENT;
    }
    [^{]+       { return CONTENT;}
}
<YYCONTENT> {
  {WHITE_SPACE}      { return WHITE_SPACE; }
  "{"                { lBraceCount +=1; return LBRACE; }
  "}"                { lBraceCount -=1;
                       if(lBraceCount == 0){
                          yybegin(YYINITIAL);
                       }
                       return RBRACE;
                     }
  "["                { return LBRAKET; }
  "]"                { return RBRAKET; }
  "."                { return DOT; }
  "{#"               { lBraceCount +=1; return STARTCOMMAND; }
  "{/"               { lBraceCount +=1; return ENDCOMMAND; }
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
  \"([^\"\\]|\\.)*\" { return STRING; }
  '([^'\\]|\\.)*' { return STRING; }
//  \"                 { string.setLength(0); yybegin(YYSTRING);}
//      "'"                 { string.setLength(0); yybegin(YYSTRING_SINGLE);}
      "="                { return ASSIGNOP; }
  "+="               { return ADDASSIGN; }
  "-="               { return SUBASSIGN; }
  "*="               { return MULASSIGN; }
  "/="               { return DIVASSIGN; }
  "%="               { return MODASSIGN; }
  "<"                { return SMALLER;   }
  ">"                { return BIGGER;    }
  "<="               { return SMALLEREQUAL;}
  ">="               { return BIGGEREQUAL;}
  "+"                { return ADD; }
  "-"                { return SUB; }
  "!"                { return NOTOP;}
  "~"                { return BITNOTOP;}
  "&&"               { return ANDOP;}
  "||"               { return OROP;}
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
