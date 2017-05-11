/* The following code was generated by JFlex 1.7.0-SNAPSHOT tweaked for IntelliJ platform */

package com.netease.regular.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.netease.regular.lang.psi.RegularTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-SNAPSHOT
 * from the specification file <tt>_RegularLexer.flex</tt>
 */
public class _RegularLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int YYCONTENT = 2;
  public static final int YYTAG = 4;
  public static final int YYCOMMENT = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\4\1\2\1\1\1\5\1\3\22\0\1\4\1\13\1\6\1\22\1\11\1\50\1\52\1\45\1\55"+
    "\1\56\1\47\1\46\1\53\1\14\1\21\1\23\12\10\1\54\1\0\1\12\1\43\1\15\1\0\1\34"+
    "\6\11\1\66\1\11\1\64\4\11\1\65\3\11\1\63\1\61\1\62\6\11\1\17\1\44\1\20\1\0"+
    "\1\11\1\0\1\33\1\35\1\57\1\60\1\26\1\25\1\11\1\37\1\24\2\11\1\27\1\11\1\40"+
    "\3\11\1\42\1\30\1\32\1\41\3\11\1\36\1\11\1\7\1\31\1\16\1\51\6\0\1\1\242\0"+
    "\2\1\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\2\2\1\3\1\1\1\4\2\5\1\4"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\4\4\10\1\21\2\10\1\22"+
    "\2\10\1\23\1\4\1\24\2\4\1\25\1\4\1\26"+
    "\1\27\1\30\1\31\1\10\1\32\2\2\1\32\2\4"+
    "\2\0\1\33\1\0\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\4\10\1\43\2\10\1\44\1\45\1\10"+
    "\1\46\2\0\1\47\1\50\1\51\1\52\1\10\1\53"+
    "\1\32\4\0\7\10\1\54\1\10\1\32\1\55\1\56"+
    "\2\10\1\57\1\60\1\61\1\62\1\63\1\10\1\53"+
    "\1\10\1\64\2\10\1\32\1\10\1\65\1\33\1\66";

  private static int [] zzUnpackAction() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\67\0\156\0\245\0\334\0\334\0\u0113\0\334"+
    "\0\u014a\0\334\0\334\0\u0181\0\u01b8\0\u01ef\0\u0226\0\u025d"+
    "\0\u0294\0\334\0\u02cb\0\u0302\0\334\0\334\0\334\0\334"+
    "\0\u0339\0\u0370\0\u03a7\0\u03de\0\u0415\0\u044c\0\u0483\0\u04ba"+
    "\0\334\0\u04f1\0\u0528\0\u055f\0\u0596\0\u05cd\0\u0604\0\u063b"+
    "\0\334\0\u0672\0\334\0\334\0\334\0\334\0\u06a9\0\u06e0"+
    "\0\u06e0\0\u0717\0\u074e\0\u0785\0\u07bc\0\u07f3\0\u01b8\0\334"+
    "\0\u082a\0\334\0\334\0\334\0\334\0\334\0\334\0\u025d"+
    "\0\u0861\0\u0898\0\u08cf\0\u0906\0\334\0\u093d\0\u0974\0\u025d"+
    "\0\u025d\0\u09ab\0\u09e2\0\u0596\0\u0a19\0\334\0\334\0\334"+
    "\0\334\0\u0a50\0\334\0\u0a87\0\u0785\0\u07bc\0\u0abe\0\u0af5"+
    "\0\u0b2c\0\u0b63\0\u0b9a\0\u0bd1\0\u0c08\0\u0c3f\0\u0c76\0\334"+
    "\0\u0cad\0\u0ce4\0\334\0\334\0\u0d1b\0\u0d52\0\u0d89\0\u025d"+
    "\0\u025d\0\u025d\0\u025d\0\u0dc0\0\u0df7\0\u0e2e\0\u025d\0\u0e65"+
    "\0\u0e9c\0\u0df7\0\u0ed3\0\u025d\0\u025d\0\u025d";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\2\5\1\6\1\7\2\6\1\5\1\10\2\5\1\11"+
    "\54\5\2\12\1\13\1\14\2\13\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\12\1\31\1\32\1\33\1\34\1\35\1\20"+
    "\1\36\1\37\1\40\1\41\1\42\2\20\1\43\2\20"+
    "\1\44\1\12\1\45\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\2\20\1\57\5\20\2\60"+
    "\1\61\1\62\2\61\1\60\1\10\2\60\1\63\54\60"+
    "\14\64\1\65\52\64\71\0\1\6\77\0\1\66\55\0"+
    "\1\13\64\0\6\67\1\70\35\67\1\71\22\67\22\0"+
    "\1\72\1\73\53\0\1\17\66\0\2\20\12\0\5\20"+
    "\1\0\2\20\1\0\6\20\14\0\10\20\43\0\1\74"+
    "\66\0\1\75\66\0\1\76\66\0\1\77\33\0\2\20"+
    "\12\0\1\20\1\100\3\20\1\0\2\20\1\0\3\20"+
    "\1\101\2\20\14\0\10\20\10\0\2\20\12\0\5\20"+
    "\1\0\1\20\1\102\1\0\6\20\14\0\10\20\10\0"+
    "\2\20\12\0\3\20\1\103\1\20\1\0\2\20\1\0"+
    "\6\20\14\0\10\20\10\0\2\20\12\0\1\104\4\20"+
    "\1\0\2\20\1\0\6\20\14\0\10\20\31\0\1\105"+
    "\45\0\2\20\12\0\5\20\1\0\2\20\1\0\2\20"+
    "\1\106\2\20\1\107\14\0\10\20\10\0\2\20\12\0"+
    "\4\20\1\110\1\0\2\20\1\0\6\20\14\0\10\20"+
    "\10\0\2\20\12\0\5\20\1\0\2\20\1\0\1\20"+
    "\1\111\4\20\14\0\10\20\10\0\2\20\12\0\5\20"+
    "\1\0\2\20\1\0\4\20\1\112\1\20\14\0\10\20"+
    "\43\0\1\113\23\0\44\114\1\115\1\70\21\114\43\0"+
    "\1\116\66\0\1\117\66\0\1\120\75\0\1\121\24\0"+
    "\2\20\12\0\5\20\1\0\2\20\1\0\6\20\14\0"+
    "\3\20\1\122\4\20\7\60\1\123\2\60\1\63\56\60"+
    "\1\61\4\60\1\123\2\60\1\63\63\60\1\123\2\60"+
    "\1\63\1\124\53\60\14\125\1\126\66\125\1\127\52\125"+
    "\14\0\1\130\52\0\1\67\3\0\1\67\1\0\61\67"+
    "\10\0\2\20\12\0\5\20\1\0\2\20\1\0\6\20"+
    "\14\0\1\131\7\20\10\0\2\20\12\0\3\20\1\132"+
    "\1\20\1\0\2\20\1\0\6\20\14\0\10\20\10\0"+
    "\2\20\12\0\4\20\1\133\1\0\2\20\1\0\6\20"+
    "\14\0\10\20\10\0\2\20\12\0\4\20\1\134\1\0"+
    "\2\20\1\0\6\20\14\0\10\20\10\0\2\20\12\0"+
    "\1\135\4\20\1\0\2\20\1\0\6\20\14\0\10\20"+
    "\10\0\2\20\12\0\5\20\1\0\2\20\1\0\4\20"+
    "\1\136\1\20\14\0\10\20\10\0\2\20\12\0\3\20"+
    "\1\137\1\20\1\0\2\20\1\0\6\20\14\0\10\20"+
    "\43\0\1\140\23\0\1\114\3\0\1\114\1\0\61\114"+
    "\10\0\2\20\12\0\5\20\1\0\2\20\1\0\6\20"+
    "\14\0\4\20\1\141\3\20\7\60\1\123\2\60\1\63"+
    "\1\60\1\142\52\60\14\125\1\127\1\143\51\125\14\0"+
    "\1\144\62\0\2\20\12\0\3\20\1\145\1\20\1\0"+
    "\2\20\1\0\6\20\14\0\10\20\10\0\2\20\12\0"+
    "\4\20\1\146\1\0\2\20\1\0\6\20\14\0\10\20"+
    "\10\0\2\20\12\0\2\20\1\147\2\20\1\0\2\20"+
    "\1\0\6\20\14\0\10\20\10\0\2\20\12\0\5\20"+
    "\1\0\1\150\1\20\1\0\6\20\14\0\10\20\10\0"+
    "\2\20\12\0\4\20\1\151\1\0\2\20\1\0\6\20"+
    "\14\0\10\20\10\0\2\20\12\0\2\20\1\152\2\20"+
    "\1\0\2\20\1\0\6\20\14\0\10\20\10\0\2\20"+
    "\12\0\3\20\1\153\1\20\1\0\2\20\1\0\6\20"+
    "\14\0\10\20\10\0\2\20\12\0\5\20\1\0\2\20"+
    "\1\0\6\20\14\0\5\20\1\154\2\20\7\60\1\123"+
    "\2\60\1\63\1\60\1\155\52\60\10\0\2\20\12\0"+
    "\5\20\1\0\2\20\1\0\4\20\1\156\1\20\14\0"+
    "\10\20\10\0\2\20\12\0\2\20\1\157\2\20\1\0"+
    "\2\20\1\0\6\20\14\0\10\20\10\0\2\20\12\0"+
    "\1\160\4\20\1\0\2\20\1\0\6\20\14\0\10\20"+
    "\10\0\2\20\12\0\5\20\1\0\2\20\1\0\6\20"+
    "\14\0\6\20\1\161\1\20\7\162\1\0\57\162\10\0"+
    "\2\20\12\0\5\20\1\0\2\20\1\0\6\20\14\0"+
    "\1\20\1\163\6\20\10\0\2\20\12\0\1\20\1\164"+
    "\3\20\1\0\2\20\1\0\6\20\14\0\10\20\10\0"+
    "\2\20\12\0\5\20\1\0\2\20\1\0\6\20\14\0"+
    "\7\20\1\165\10\0\2\20\12\0\2\20\1\166\2\20"+
    "\1\0\2\20\1\0\6\20\14\0\10\20";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3850];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\2\11\1\1\1\11\1\1\2\11\6\1\1\11"+
    "\2\1\4\11\10\1\1\11\7\1\1\11\1\1\4\11"+
    "\7\1\2\0\1\11\1\0\6\11\5\1\1\11\6\1"+
    "\2\0\4\11\1\1\1\11\1\1\4\0\7\1\1\11"+
    "\2\1\2\11\22\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[118];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  StringBuffer string = new StringBuffer();

  public _RegularLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _RegularLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { yypushback(1); yybegin(YYTAG);
            }
          case 55: break;
          case 2: 
            { 
            }
          case 56: break;
          case 3: 
            { yypushback(1); yybegin(YYCONTENT);
            }
          case 57: break;
          case 4: 
            { return BAD_CHARACTER;
            }
          case 58: break;
          case 5: 
            { return WHITE_SPACE;
            }
          case 59: break;
          case 6: 
            { return LBRACE;
            }
          case 60: break;
          case 7: 
            { return NUMBER;
            }
          case 61: break;
          case 8: 
            { return ID;
            }
          case 62: break;
          case 9: 
            { return SMALLER;
            }
          case 63: break;
          case 10: 
            { return NOTOP;
            }
          case 64: break;
          case 11: 
            { return SUB;
            }
          case 65: break;
          case 12: 
            { return BIGGER;
            }
          case 66: break;
          case 13: 
            { yybegin(YYINITIAL); return RBRACE;
            }
          case 67: break;
          case 14: 
            { return LBRAKET;
            }
          case 68: break;
          case 15: 
            { return RBRAKET;
            }
          case 69: break;
          case 16: 
            { return DOT;
            }
          case 70: break;
          case 17: 
            { return FILTEROP;
            }
          case 71: break;
          case 18: 
            { return AT;
            }
          case 72: break;
          case 19: 
            { return ASSIGNOP;
            }
          case 73: break;
          case 20: 
            { return ADD;
            }
          case 74: break;
          case 21: 
            { return BITNOTOP;
            }
          case 75: break;
          case 22: 
            { return COMMA;
            }
          case 76: break;
          case 23: 
            { return COLON;
            }
          case 77: break;
          case 24: 
            { return LPARAM;
            }
          case 78: break;
          case 25: 
            { return RPARAM;
            }
          case 79: break;
          case 26: 
            { return CONTENT;
            }
          case 80: break;
          case 27: 
            { return STRING;
            }
          case 81: break;
          case 28: 
            { return STARTCOMMAND;
            }
          case 82: break;
          case 29: 
            { return ENDCOMMAND;
            }
          case 83: break;
          case 30: 
            { return SMALLEREQUAL;
            }
          case 84: break;
          case 31: 
            { return SUBASSIGN;
            }
          case 85: break;
          case 32: 
            { return BIGGEREQUAL;
            }
          case 86: break;
          case 33: 
            { return DIVASSIGN;
            }
          case 87: break;
          case 34: 
            { return IF;
            }
          case 88: break;
          case 35: 
            { return OROP;
            }
          case 89: break;
          case 36: 
            { return AS;
            }
          case 90: break;
          case 37: 
            { return BY;
            }
          case 91: break;
          case 38: 
            { return EQUALEQUAL;
            }
          case 92: break;
          case 39: 
            { return ADDASSIGN;
            }
          case 93: break;
          case 40: 
            { return MULASSIGN;
            }
          case 94: break;
          case 41: 
            { return MODASSIGN;
            }
          case 95: break;
          case 42: 
            { return ANDOP;
            }
          case 96: break;
          case 43: 
            { if(yytext().toString().endsWith("{")){
                    yypushback(1);
                    yybegin(YYCONTENT);
                    return CONTENT;
                  }
                  yypushback(4);
                  yybegin(YYCOMMENT);
                  return CONTENT;
            }
          case 97: break;
          case 44: 
            { return STRICTEQUAL;
            }
          case 98: break;
          case 45: 
            { yybegin(YYINITIAL); return COMMENT;
            }
          case 99: break;
          case 46: 
            { yybegin(YYCOMMENT);
            }
          case 100: break;
          case 47: 
            { return ELSE;
            }
          case 101: break;
          case 48: 
            { return LIST;
            }
          case 102: break;
          case 49: 
            { return THIS;
            }
          case 103: break;
          case 50: 
            { return TRUE;
            }
          case 104: break;
          case 51: 
            { return NULL;
            }
          case 105: break;
          case 52: 
            { return FALSE;
            }
          case 106: break;
          case 53: 
            { return ELSEIF;
            }
          case 107: break;
          case 54: 
            { return INCLUDE;
            }
          case 108: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
