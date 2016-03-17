// $ANTLR 3.1.3 Mar 17, 2009 19:23:44 /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g 2016-02-22 15:44:37

package org.python.antlr;

import org.antlr.runtime.CommonToken;

import org.python.antlr.ParseException;
import org.python.antlr.PythonTree;
import org.python.antlr.ast.alias;
import org.python.antlr.ast.arguments;
import org.python.antlr.ast.Assert;
import org.python.antlr.ast.Assign;
import org.python.antlr.ast.Attribute;
import org.python.antlr.ast.AugAssign;
import org.python.antlr.ast.BinOp;
import org.python.antlr.ast.BoolOp;
import org.python.antlr.ast.boolopType;
import org.python.antlr.ast.Break;
import org.python.antlr.ast.Call;
import org.python.antlr.ast.ClassDef;
import org.python.antlr.ast.cmpopType;
import org.python.antlr.ast.Compare;
import org.python.antlr.ast.comprehension;
import org.python.antlr.ast.Context;
import org.python.antlr.ast.Continue;
import org.python.antlr.ast.Delete;
import org.python.antlr.ast.Dict;
import org.python.antlr.ast.Ellipsis;
import org.python.antlr.ast.ErrorMod;
import org.python.antlr.ast.ExceptHandler;
import org.python.antlr.ast.Exec;
import org.python.antlr.ast.Expr;
import org.python.antlr.ast.Expression;
import org.python.antlr.ast.expr_contextType;
import org.python.antlr.ast.ExtSlice;
import org.python.antlr.ast.For;
import org.python.antlr.ast.GeneratorExp;
import org.python.antlr.ast.Global;
import org.python.antlr.ast.If;
import org.python.antlr.ast.IfExp;
import org.python.antlr.ast.Import;
import org.python.antlr.ast.ImportFrom;
import org.python.antlr.ast.Index;
import org.python.antlr.ast.Interactive;
import org.python.antlr.ast.keyword;
import org.python.antlr.ast.ListComp;
import org.python.antlr.ast.Lambda;
import org.python.antlr.ast.Module;
import org.python.antlr.ast.Name;
import org.python.antlr.ast.Num;
import org.python.antlr.ast.operatorType;
import org.python.antlr.ast.Pass;
import org.python.antlr.ast.Print;
import org.python.antlr.ast.Raise;
import org.python.antlr.ast.Repr;
import org.python.antlr.ast.Return;
import org.python.antlr.ast.Slice;
import org.python.antlr.ast.Str;
import org.python.antlr.ast.Subscript;
import org.python.antlr.ast.TryExcept;
import org.python.antlr.ast.TryFinally;
import org.python.antlr.ast.Tuple;
import org.python.antlr.ast.unaryopType;
import org.python.antlr.ast.UnaryOp;
import org.python.antlr.ast.While;
import org.python.antlr.ast.With;
import org.python.antlr.ast.Yield;
import org.python.antlr.base.excepthandler;
import org.python.antlr.base.expr;
import org.python.antlr.base.mod;
import org.python.antlr.base.slice;
import org.python.antlr.base.stmt;
import org.python.core.Py;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PyUnicode;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/** Python 2.3.3 Grammar
 *
 *  Terence Parr and Loring Craymer
 *  February 2004
 *
 *  Converted to ANTLR v3 November 2005 by Terence Parr.
 *
 *  This grammar was derived automatically from the Python 2.3.3
 *  parser grammar to get a syntactically correct ANTLR grammar
 *  for Python.  Then Terence hand tweaked it to be semantically
 *  correct; i.e., removed lookahead issues etc...  It is LL(1)
 *  except for the (sometimes optional) trailing commas and semi-colons.
 *  It needs two symbols of lookahead in this case.
 *
 *  Starting with Loring's preliminary lexer for Python, I modified it
 *  to do my version of the whole nasty INDENT/DEDENT issue just so I
 *  could understand the problem better.  This grammar requires
 *  PythonTokenStream.java to work.  Also I used some rules from the
 *  semi-formal grammar on the web for Python (automatically
 *  translated to ANTLR format by an ANTLR grammar, naturally <grin>).
 *  The lexical rules for python are particularly nasty and it took me
 *  a long time to get it 'right'; i.e., think about it in the proper
 *  way.  Resist changing the lexer unless you've used ANTLR a lot. ;)
 *
 *  I (Terence) tested this by running it on the jython-2.1/Lib
 *  directory of 40k lines of Python.
 *
 *  REQUIRES ANTLR v3
 *
 *
 *  Updated the original parser for Python 2.5 features. The parser has been
 *  altered to produce an AST - the AST work started from tne newcompiler
 *  grammar from Jim Baker.  The current parsing and compiling strategy looks
 *  like this:
 *
 *  Python source->Python.g->AST (org/python/parser/ast/*)->CodeCompiler(ASM)->.class
 */
public class PythonParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "INDENT", "DEDENT", "TRAILBACKSLASH", "NEWLINE", "LEADING_WS", "NAME", "DOT", "AND", "AS", "ASSERT", "BREAK", "CLASS", "CONTINUE", "DEF", "DELETE", "ELIF", "EXCEPT", "EXEC", "FINALLY", "FROM", "FOR", "GLOBAL", "IF", "IMPORT", "IN", "IS", "LAMBDA", "NOT", "OR", "ORELSE", "PASS", "PRINT", "RAISE", "RETURN", "TRY", "WHILE", "WITH", "YIELD", "AT", "LPAREN", "RPAREN", "COLON", "ASSIGN", "COMMA", "STAR", "DOUBLESTAR", "SEMI", "PLUSEQUAL", "MINUSEQUAL", "STAREQUAL", "SLASHEQUAL", "PERCENTEQUAL", "AMPEREQUAL", "VBAREQUAL", "CIRCUMFLEXEQUAL", "LEFTSHIFTEQUAL", "RIGHTSHIFTEQUAL", "DOUBLESTAREQUAL", "DOUBLESLASHEQUAL", "RIGHTSHIFT", "LESS", "GREATER", "EQUAL", "GREATEREQUAL", "LESSEQUAL", "ALT_NOTEQUAL", "NOTEQUAL", "VBAR", "CIRCUMFLEX", "AMPER", "LEFTSHIFT", "PLUS", "MINUS", "SLASH", "PERCENT", "DOUBLESLASH", "TILDE", "LBRACK", "RBRACK", "LCURLY", "RCURLY", "BACKQUOTE", "INT", "LONGINT", "FLOAT", "COMPLEX", "STRING", "DIGITS", "Exponent", "TRIAPOS", "TRIQUOTE", "ESC", "COMMENT", "CONTINUED_LINE", "WS"
    };
    public static final int SLASHEQUAL=54;
    public static final int BACKQUOTE=85;
    public static final int STAR=48;
    public static final int CIRCUMFLEXEQUAL=58;
    public static final int WHILE=39;
    public static final int TRIAPOS=93;
    public static final int ORELSE=33;
    public static final int GREATEREQUAL=67;
    public static final int COMPLEX=89;
    public static final int NOT=31;
    public static final int EXCEPT=20;
    public static final int EOF=-1;
    public static final int BREAK=14;
    public static final int PASS=34;
    public static final int LEADING_WS=8;
    public static final int NOTEQUAL=70;
    public static final int MINUSEQUAL=52;
    public static final int VBAR=71;
    public static final int RPAREN=44;
    public static final int IMPORT=27;
    public static final int NAME=9;
    public static final int GREATER=65;
    public static final int DOUBLESTAREQUAL=61;
    public static final int RETURN=37;
    public static final int LESS=64;
    public static final int RAISE=36;
    public static final int COMMENT=96;
    public static final int RBRACK=82;
    public static final int LCURLY=83;
    public static final int INT=86;
    public static final int DELETE=18;
    public static final int RIGHTSHIFT=63;
    public static final int ASSERT=13;
    public static final int TRY=38;
    public static final int DOUBLESLASHEQUAL=62;
    public static final int ELIF=19;
    public static final int WS=98;
    public static final int VBAREQUAL=57;
    public static final int OR=32;
    public static final int LONGINT=87;
    public static final int FROM=23;
    public static final int PERCENTEQUAL=55;
    public static final int LESSEQUAL=68;
    public static final int DOUBLESLASH=79;
    public static final int CLASS=15;
    public static final int CONTINUED_LINE=97;
    public static final int LBRACK=81;
    public static final int DEF=17;
    public static final int DOUBLESTAR=49;
    public static final int ESC=95;
    public static final int DIGITS=91;
    public static final int Exponent=92;
    public static final int FOR=24;
    public static final int DEDENT=5;
    public static final int FLOAT=88;
    public static final int AND=11;
    public static final int RIGHTSHIFTEQUAL=60;
    public static final int INDENT=4;
    public static final int LPAREN=43;
    public static final int IF=26;
    public static final int PLUSEQUAL=51;
    public static final int AT=42;
    public static final int AS=12;
    public static final int SLASH=77;
    public static final int IN=28;
    public static final int CONTINUE=16;
    public static final int COMMA=47;
    public static final int IS=29;
    public static final int AMPER=73;
    public static final int EQUAL=66;
    public static final int YIELD=41;
    public static final int TILDE=80;
    public static final int LEFTSHIFTEQUAL=59;
    public static final int LEFTSHIFT=74;
    public static final int PLUS=75;
    public static final int LAMBDA=30;
    public static final int DOT=10;
    public static final int WITH=40;
    public static final int PERCENT=78;
    public static final int EXEC=21;
    public static final int MINUS=76;
    public static final int SEMI=50;
    public static final int PRINT=35;
    public static final int TRIQUOTE=94;
    public static final int COLON=45;
    public static final int TRAILBACKSLASH=6;
    public static final int NEWLINE=7;
    public static final int AMPEREQUAL=56;
    public static final int FINALLY=22;
    public static final int RCURLY=84;
    public static final int ASSIGN=46;
    public static final int GLOBAL=25;
    public static final int STAREQUAL=53;
    public static final int CIRCUMFLEX=72;
    public static final int STRING=90;
    public static final int ALT_NOTEQUAL=69;

    // delegates
    // delegators


        public PythonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public PythonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return PythonParser.tokenNames; }
    public String getGrammarFileName() { return "/run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g"; }


        private ErrorHandler errorHandler;

        private GrammarActions actions = new GrammarActions();

        private String encoding;

        public void setErrorHandler(ErrorHandler eh) {
            this.errorHandler = eh;
            actions.setErrorHandler(eh);
        }

        protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow)
            throws RecognitionException {

            Object o = errorHandler.recoverFromMismatchedToken(this, input, ttype, follow);
            if (o != null) {
                return o;
            }
            return super.recoverFromMismatchedToken(input, ttype, follow);
        }

        public PythonParser(TokenStream input, String encoding) {
            this(input);
            this.encoding = encoding;
        }



    public static class single_input_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "single_input"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:270:1: single_input : ( ( NEWLINE )* EOF | simple_stmt ( NEWLINE )* EOF | compound_stmt ( NEWLINE )+ EOF );
    public final PythonParser.single_input_return single_input() throws RecognitionException {
        PythonParser.single_input_return retval = new PythonParser.single_input_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token NEWLINE1=null;
        Token EOF2=null;
        Token NEWLINE4=null;
        Token EOF5=null;
        Token NEWLINE7=null;
        Token EOF8=null;
        PythonParser.simple_stmt_return simple_stmt3 = null;

        PythonParser.compound_stmt_return compound_stmt6 = null;


        PythonTree NEWLINE1_tree=null;
        PythonTree EOF2_tree=null;
        PythonTree NEWLINE4_tree=null;
        PythonTree EOF5_tree=null;
        PythonTree NEWLINE7_tree=null;
        PythonTree EOF8_tree=null;


            mod mtype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:277:5: ( ( NEWLINE )* EOF | simple_stmt ( NEWLINE )* EOF | compound_stmt ( NEWLINE )+ EOF )
            int alt4=3;
            switch ( input.LA(1) ) {
            case EOF:
            case NEWLINE:
                {
                alt4=1;
                }
                break;
            case NAME:
            case ASSERT:
            case BREAK:
            case CONTINUE:
            case DELETE:
            case EXEC:
            case FROM:
            case GLOBAL:
            case IMPORT:
            case LAMBDA:
            case NOT:
            case PASS:
            case PRINT:
            case RAISE:
            case RETURN:
            case YIELD:
            case LPAREN:
            case PLUS:
            case MINUS:
            case TILDE:
            case LBRACK:
            case LCURLY:
            case BACKQUOTE:
            case INT:
            case LONGINT:
            case FLOAT:
            case COMPLEX:
            case STRING:
                {
                alt4=2;
                }
                break;
            case CLASS:
            case DEF:
            case FOR:
            case IF:
            case TRY:
            case WHILE:
            case WITH:
            case AT:
                {
                alt4=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:277:7: ( NEWLINE )* EOF
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:277:7: ( NEWLINE )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==NEWLINE) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:277:7: NEWLINE
                    	    {
                    	    NEWLINE1=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input116); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE1_tree = (PythonTree)adaptor.create(NEWLINE1);
                    	    adaptor.addChild(root_0, NEWLINE1_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_single_input119); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EOF2_tree = (PythonTree)adaptor.create(EOF2);
                    adaptor.addChild(root_0, EOF2_tree);
                    }
                    if ( state.backtracking==0 ) {

                              mtype = new Interactive(((Token)retval.start), new ArrayList<stmt>());
                            
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:281:7: simple_stmt ( NEWLINE )* EOF
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_stmt_in_single_input135);
                    simple_stmt3=simple_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_stmt3.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:281:19: ( NEWLINE )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==NEWLINE) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:281:19: NEWLINE
                    	    {
                    	    NEWLINE4=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input137); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE4_tree = (PythonTree)adaptor.create(NEWLINE4);
                    	    adaptor.addChild(root_0, NEWLINE4_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_single_input140); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EOF5_tree = (PythonTree)adaptor.create(EOF5);
                    adaptor.addChild(root_0, EOF5_tree);
                    }
                    if ( state.backtracking==0 ) {

                              mtype = new Interactive(((Token)retval.start), actions.castStmts((simple_stmt3!=null?simple_stmt3.stypes:null)));
                            
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:285:7: compound_stmt ( NEWLINE )+ EOF
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_compound_stmt_in_single_input156);
                    compound_stmt6=compound_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_stmt6.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:285:21: ( NEWLINE )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==NEWLINE) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:285:21: NEWLINE
                    	    {
                    	    NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_single_input158); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    NEWLINE7_tree = (PythonTree)adaptor.create(NEWLINE7);
                    	    adaptor.addChild(root_0, NEWLINE7_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    EOF8=(Token)match(input,EOF,FOLLOW_EOF_in_single_input161); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EOF8_tree = (PythonTree)adaptor.create(EOF8);
                    adaptor.addChild(root_0, EOF8_tree);
                    }
                    if ( state.backtracking==0 ) {

                              mtype = new Interactive(((Token)retval.start), actions.castStmts((compound_stmt6!=null?((PythonTree)compound_stmt6.tree):null)));
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = mtype;

            }
        }
        catch (RecognitionException re) {

                    errorHandler.reportError(this, re);
                    errorHandler.recover(this, input,re);
                    PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
                    retval.tree = new ErrorMod(badNode);
                
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "single_input"

    public static class file_input_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "file_input"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:299:1: file_input : ( NEWLINE | stmt )* EOF ;
    public final PythonParser.file_input_return file_input() throws RecognitionException {
        PythonParser.file_input_return retval = new PythonParser.file_input_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token NEWLINE9=null;
        Token EOF11=null;
        PythonParser.stmt_return stmt10 = null;


        PythonTree NEWLINE9_tree=null;
        PythonTree EOF11_tree=null;


            mod mtype = null;
            List stypes = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:317:5: ( ( NEWLINE | stmt )* EOF )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:317:7: ( NEWLINE | stmt )* EOF
            {
            root_0 = (PythonTree)adaptor.nil();

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:317:7: ( NEWLINE | stmt )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==NEWLINE) ) {
                    alt5=1;
                }
                else if ( (LA5_0==NAME||(LA5_0>=ASSERT && LA5_0<=DELETE)||LA5_0==EXEC||(LA5_0>=FROM && LA5_0<=IMPORT)||(LA5_0>=LAMBDA && LA5_0<=NOT)||(LA5_0>=PASS && LA5_0<=LPAREN)||(LA5_0>=PLUS && LA5_0<=MINUS)||(LA5_0>=TILDE && LA5_0<=LBRACK)||LA5_0==LCURLY||(LA5_0>=BACKQUOTE && LA5_0<=STRING)) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:317:8: NEWLINE
            	    {
            	    NEWLINE9=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_file_input213); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEWLINE9_tree = (PythonTree)adaptor.create(NEWLINE9);
            	    adaptor.addChild(root_0, NEWLINE9_tree);
            	    }

            	    }
            	    break;
            	case 2 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:318:9: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_file_input223);
            	    stmt10=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt10.getTree());
            	    if ( state.backtracking==0 ) {

            	                if ((stmt10!=null?stmt10.stypes:null) != null)
            	                       {stypes.addAll((stmt10!=null?stmt10.stypes:null));}
            	            
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            EOF11=(Token)match(input,EOF,FOLLOW_EOF_in_file_input242); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF11_tree = (PythonTree)adaptor.create(EOF11);
            adaptor.addChild(root_0, EOF11_tree);
            }
            if ( state.backtracking==0 ) {

                           mtype = new Module(((Token)retval.start), actions.castStmts(stypes));
                       
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (!stypes.isEmpty()) {
                      //The EOF token messes up the end offsets, so set them manually.
                      //XXX: this may no longer be true now that PythonTokenSource is
                      //     adjusting EOF offsets -- but needs testing before I remove
                      //     this.
                      PythonTree stop = (PythonTree)stypes.get(stypes.size() -1);
                      mtype.setCharStopIndex(stop.getCharStopIndex());
                      mtype.setTokenStopIndex(stop.getTokenStopIndex());
                  }

                  retval.tree = mtype;

            }
        }
        catch (RecognitionException re) {

                    errorHandler.reportError(this, re);
                    errorHandler.recover(this, input,re);
                    PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
                    retval.tree = new ErrorMod(badNode);
                
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "file_input"

    public static class eval_input_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "eval_input"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:337:1: eval_input : ( LEADING_WS )? ( NEWLINE )* testlist[expr_contextType.Load] ( NEWLINE )* EOF ;
    public final PythonParser.eval_input_return eval_input() throws RecognitionException {
        PythonParser.eval_input_return retval = new PythonParser.eval_input_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token LEADING_WS12=null;
        Token NEWLINE13=null;
        Token NEWLINE15=null;
        Token EOF16=null;
        PythonParser.testlist_return testlist14 = null;


        PythonTree LEADING_WS12_tree=null;
        PythonTree NEWLINE13_tree=null;
        PythonTree NEWLINE15_tree=null;
        PythonTree EOF16_tree=null;


            mod mtype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:5: ( ( LEADING_WS )? ( NEWLINE )* testlist[expr_contextType.Load] ( NEWLINE )* EOF )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:7: ( LEADING_WS )? ( NEWLINE )* testlist[expr_contextType.Load] ( NEWLINE )* EOF
            {
            root_0 = (PythonTree)adaptor.nil();

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:7: ( LEADING_WS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LEADING_WS) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:7: LEADING_WS
                    {
                    LEADING_WS12=(Token)match(input,LEADING_WS,FOLLOW_LEADING_WS_in_eval_input296); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEADING_WS12_tree = (PythonTree)adaptor.create(LEADING_WS12);
                    adaptor.addChild(root_0, LEADING_WS12_tree);
                    }

                    }
                    break;

            }

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:19: ( NEWLINE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==NEWLINE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:20: NEWLINE
            	    {
            	    NEWLINE13=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_eval_input300); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEWLINE13_tree = (PythonTree)adaptor.create(NEWLINE13);
            	    adaptor.addChild(root_0, NEWLINE13_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            pushFollow(FOLLOW_testlist_in_eval_input304);
            testlist14=testlist(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist14.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:62: ( NEWLINE )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==NEWLINE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:344:63: NEWLINE
            	    {
            	    NEWLINE15=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_eval_input308); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    NEWLINE15_tree = (PythonTree)adaptor.create(NEWLINE15);
            	    adaptor.addChild(root_0, NEWLINE15_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            EOF16=(Token)match(input,EOF,FOLLOW_EOF_in_eval_input312); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF16_tree = (PythonTree)adaptor.create(EOF16);
            adaptor.addChild(root_0, EOF16_tree);
            }
            if ( state.backtracking==0 ) {

                      mtype = new Expression(((Token)retval.start), actions.castExpr((testlist14!=null?((PythonTree)testlist14.tree):null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = mtype;

            }
        }
        catch (RecognitionException re) {

                    errorHandler.reportError(this, re);
                    errorHandler.recover(this, input,re);
                    PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
                    retval.tree = new ErrorMod(badNode);
                
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "eval_input"

    public static class dotted_attr_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dotted_attr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:359:1: dotted_attr returns [expr etype] : n1= NAME ( ( DOT n2+= NAME )+ | ) ;
    public final PythonParser.dotted_attr_return dotted_attr() throws RecognitionException {
        PythonParser.dotted_attr_return retval = new PythonParser.dotted_attr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token n1=null;
        Token DOT17=null;
        Token n2=null;
        List list_n2=null;

        PythonTree n1_tree=null;
        PythonTree DOT17_tree=null;
        PythonTree n2_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:361:5: (n1= NAME ( ( DOT n2+= NAME )+ | ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:361:7: n1= NAME ( ( DOT n2+= NAME )+ | )
            {
            root_0 = (PythonTree)adaptor.nil();

            n1=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_attr364); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            n1_tree = (PythonTree)adaptor.create(n1);
            adaptor.addChild(root_0, n1_tree);
            }
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:362:7: ( ( DOT n2+= NAME )+ | )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==DOT) ) {
                alt10=1;
            }
            else if ( (LA10_0==NEWLINE||LA10_0==LPAREN) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:362:9: ( DOT n2+= NAME )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:362:9: ( DOT n2+= NAME )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==DOT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:362:10: DOT n2+= NAME
                    	    {
                    	    DOT17=(Token)match(input,DOT,FOLLOW_DOT_in_dotted_attr375); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    DOT17_tree = (PythonTree)adaptor.create(DOT17);
                    	    adaptor.addChild(root_0, DOT17_tree);
                    	    }
                    	    n2=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_attr379); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    n2_tree = (PythonTree)adaptor.create(n2);
                    	    adaptor.addChild(root_0, n2_tree);
                    	    }
                    	    if (list_n2==null) list_n2=new ArrayList();
                    	    list_n2.add(n2);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    if ( state.backtracking==0 ) {

                                  retval.etype = actions.makeDottedAttr(n1, list_n2);
                              
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:367:9: 
                    {
                    if ( state.backtracking==0 ) {

                                  retval.etype = new Name(n1, (n1!=null?n1.getText():null), expr_contextType.Load);
                              
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dotted_attr"

    public static class attr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:376:1: attr : ( NAME | AND | AS | ASSERT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NOT | OR | ORELSE | PASS | PRINT | RAISE | RETURN | TRY | WHILE | WITH | YIELD );
    public final PythonParser.attr_return attr() throws RecognitionException {
        PythonParser.attr_return retval = new PythonParser.attr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token set18=null;

        PythonTree set18_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:377:5: ( NAME | AND | AS | ASSERT | BREAK | CLASS | CONTINUE | DEF | DELETE | ELIF | EXCEPT | EXEC | FINALLY | FROM | FOR | GLOBAL | IF | IMPORT | IN | IS | LAMBDA | NOT | OR | ORELSE | PASS | PRINT | RAISE | RETURN | TRY | WHILE | WITH | YIELD )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:
            {
            root_0 = (PythonTree)adaptor.nil();

            set18=(Token)input.LT(1);
            if ( input.LA(1)==NAME||(input.LA(1)>=AND && input.LA(1)<=YIELD) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (PythonTree)adaptor.create(set18));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attr"

    public static class decorator_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decorator"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:412:1: decorator returns [expr etype] : AT dotted_attr ( LPAREN ( arglist | ) RPAREN | ) NEWLINE ;
    public final PythonParser.decorator_return decorator() throws RecognitionException {
        PythonParser.decorator_return retval = new PythonParser.decorator_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token AT19=null;
        Token LPAREN21=null;
        Token RPAREN23=null;
        Token NEWLINE24=null;
        PythonParser.dotted_attr_return dotted_attr20 = null;

        PythonParser.arglist_return arglist22 = null;


        PythonTree AT19_tree=null;
        PythonTree LPAREN21_tree=null;
        PythonTree RPAREN23_tree=null;
        PythonTree NEWLINE24_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:417:5: ( AT dotted_attr ( LPAREN ( arglist | ) RPAREN | ) NEWLINE )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:417:7: AT dotted_attr ( LPAREN ( arglist | ) RPAREN | ) NEWLINE
            {
            root_0 = (PythonTree)adaptor.nil();

            AT19=(Token)match(input,AT,FOLLOW_AT_in_decorator716); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            AT19_tree = (PythonTree)adaptor.create(AT19);
            adaptor.addChild(root_0, AT19_tree);
            }
            pushFollow(FOLLOW_dotted_attr_in_decorator718);
            dotted_attr20=dotted_attr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dotted_attr20.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:418:5: ( LPAREN ( arglist | ) RPAREN | )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LPAREN) ) {
                alt12=1;
            }
            else if ( (LA12_0==NEWLINE) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:418:7: LPAREN ( arglist | ) RPAREN
                    {
                    LPAREN21=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_decorator726); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN21_tree = (PythonTree)adaptor.create(LPAREN21);
                    adaptor.addChild(root_0, LPAREN21_tree);
                    }
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:419:7: ( arglist | )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==NAME||(LA11_0>=LAMBDA && LA11_0<=NOT)||LA11_0==LPAREN||(LA11_0>=STAR && LA11_0<=DOUBLESTAR)||(LA11_0>=PLUS && LA11_0<=MINUS)||(LA11_0>=TILDE && LA11_0<=LBRACK)||LA11_0==LCURLY||(LA11_0>=BACKQUOTE && LA11_0<=STRING)) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==RPAREN) ) {
                        alt11=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;
                    }
                    switch (alt11) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:419:9: arglist
                            {
                            pushFollow(FOLLOW_arglist_in_decorator736);
                            arglist22=arglist();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, arglist22.getTree());
                            if ( state.backtracking==0 ) {

                                          retval.etype = actions.makeCall(LPAREN21, (dotted_attr20!=null?dotted_attr20.etype:null), (arglist22!=null?arglist22.args:null), (arglist22!=null?arglist22.keywords:null),
                                                   (arglist22!=null?arglist22.starargs:null), (arglist22!=null?arglist22.kwargs:null));
                                      
                            }

                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:425:9: 
                            {
                            if ( state.backtracking==0 ) {

                                          retval.etype = actions.makeCall(LPAREN21, (dotted_attr20!=null?dotted_attr20.etype:null));
                                      
                            }

                            }
                            break;

                    }

                    RPAREN23=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_decorator780); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN23_tree = (PythonTree)adaptor.create(RPAREN23);
                    adaptor.addChild(root_0, RPAREN23_tree);
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:431:7: 
                    {
                    if ( state.backtracking==0 ) {

                                retval.etype = (dotted_attr20!=null?dotted_attr20.etype:null);
                            
                    }

                    }
                    break;

            }

            NEWLINE24=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_decorator802); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE24_tree = (PythonTree)adaptor.create(NEWLINE24);
            adaptor.addChild(root_0, NEWLINE24_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = retval.etype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decorator"

    public static class decorators_return extends ParserRuleReturnScope {
        public List etypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "decorators"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:438:1: decorators returns [List etypes] : (d+= decorator )+ ;
    public final PythonParser.decorators_return decorators() throws RecognitionException {
        PythonParser.decorators_return retval = new PythonParser.decorators_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        List list_d=null;
        PythonParser.decorator_return d = null;
         d = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:440:5: ( (d+= decorator )+ )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:440:7: (d+= decorator )+
            {
            root_0 = (PythonTree)adaptor.nil();

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:440:8: (d+= decorator )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==AT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:440:8: d+= decorator
            	    {
            	    pushFollow(FOLLOW_decorator_in_decorators830);
            	    d=decorator();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            	    if (list_d==null) list_d=new ArrayList();
            	    list_d.add(d.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            if ( state.backtracking==0 ) {

                        retval.etypes = list_d;
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "decorators"

    public static class funcdef_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "funcdef"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:447:1: funcdef : ( decorators )? DEF NAME parameters COLON suite[false] ;
    public final PythonParser.funcdef_return funcdef() throws RecognitionException {
        PythonParser.funcdef_return retval = new PythonParser.funcdef_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token DEF26=null;
        Token NAME27=null;
        Token COLON29=null;
        PythonParser.decorators_return decorators25 = null;

        PythonParser.parameters_return parameters28 = null;

        PythonParser.suite_return suite30 = null;


        PythonTree DEF26_tree=null;
        PythonTree NAME27_tree=null;
        PythonTree COLON29_tree=null;

         stmt stype = null; 
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:450:5: ( ( decorators )? DEF NAME parameters COLON suite[false] )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:450:7: ( decorators )? DEF NAME parameters COLON suite[false]
            {
            root_0 = (PythonTree)adaptor.nil();

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:450:7: ( decorators )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==AT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:450:7: decorators
                    {
                    pushFollow(FOLLOW_decorators_in_funcdef867);
                    decorators25=decorators();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decorators25.getTree());

                    }
                    break;

            }

            DEF26=(Token)match(input,DEF,FOLLOW_DEF_in_funcdef870); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DEF26_tree = (PythonTree)adaptor.create(DEF26);
            adaptor.addChild(root_0, DEF26_tree);
            }
            NAME27=(Token)match(input,NAME,FOLLOW_NAME_in_funcdef872); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME27_tree = (PythonTree)adaptor.create(NAME27);
            adaptor.addChild(root_0, NAME27_tree);
            }
            pushFollow(FOLLOW_parameters_in_funcdef874);
            parameters28=parameters();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, parameters28.getTree());
            COLON29=(Token)match(input,COLON,FOLLOW_COLON_in_funcdef876); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON29_tree = (PythonTree)adaptor.create(COLON29);
            adaptor.addChild(root_0, COLON29_tree);
            }
            pushFollow(FOLLOW_suite_in_funcdef878);
            suite30=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, suite30.getTree());
            if ( state.backtracking==0 ) {

                      Token t = DEF26;
                      if ((decorators25!=null?((Token)decorators25.start):null) != null) {
                          t = (decorators25!=null?((Token)decorators25.start):null);
                      }
                      stype = actions.makeFuncdef(t, NAME27, (parameters28!=null?parameters28.args:null), (suite30!=null?suite30.stypes:null), (decorators25!=null?decorators25.etypes:null));
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {
               retval.tree = stype; 
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "funcdef"

    public static class parameters_return extends ParserRuleReturnScope {
        public arguments args;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "parameters"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:461:1: parameters returns [arguments args] : LPAREN ( varargslist | ) RPAREN ;
    public final PythonParser.parameters_return parameters() throws RecognitionException {
        PythonParser.parameters_return retval = new PythonParser.parameters_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token LPAREN31=null;
        Token RPAREN33=null;
        PythonParser.varargslist_return varargslist32 = null;


        PythonTree LPAREN31_tree=null;
        PythonTree RPAREN33_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:463:5: ( LPAREN ( varargslist | ) RPAREN )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:463:7: LPAREN ( varargslist | ) RPAREN
            {
            root_0 = (PythonTree)adaptor.nil();

            LPAREN31=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_parameters911); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LPAREN31_tree = (PythonTree)adaptor.create(LPAREN31);
            adaptor.addChild(root_0, LPAREN31_tree);
            }
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:464:7: ( varargslist | )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==NAME||LA15_0==LPAREN||(LA15_0>=STAR && LA15_0<=DOUBLESTAR)) ) {
                alt15=1;
            }
            else if ( (LA15_0==RPAREN) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:464:8: varargslist
                    {
                    pushFollow(FOLLOW_varargslist_in_parameters920);
                    varargslist32=varargslist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varargslist32.getTree());
                    if ( state.backtracking==0 ) {

                                    retval.args = (varargslist32!=null?varargslist32.args:null);
                              
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:469:9: 
                    {
                    if ( state.backtracking==0 ) {

                                  retval.args = new arguments(((Token)retval.start), new ArrayList<expr>(), null, null, new ArrayList<expr>());
                              
                    }

                    }
                    break;

            }

            RPAREN33=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_parameters964); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            RPAREN33_tree = (PythonTree)adaptor.create(RPAREN33);
            adaptor.addChild(root_0, RPAREN33_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "parameters"

    public static class defparameter_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defparameter"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:477:1: defparameter[List defaults] returns [expr etype] : fpdef[expr_contextType.Param] ( ASSIGN test[expr_contextType.Load] )? ;
    public final PythonParser.defparameter_return defparameter(List defaults) throws RecognitionException {
        PythonParser.defparameter_return retval = new PythonParser.defparameter_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token ASSIGN35=null;
        PythonParser.fpdef_return fpdef34 = null;

        PythonParser.test_return test36 = null;


        PythonTree ASSIGN35_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:482:5: ( fpdef[expr_contextType.Param] ( ASSIGN test[expr_contextType.Load] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:482:7: fpdef[expr_contextType.Param] ( ASSIGN test[expr_contextType.Load] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_fpdef_in_defparameter997);
            fpdef34=fpdef(expr_contextType.Param);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, fpdef34.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:482:37: ( ASSIGN test[expr_contextType.Load] )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==ASSIGN) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:482:38: ASSIGN test[expr_contextType.Load]
                    {
                    ASSIGN35=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_defparameter1001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN35_tree = (PythonTree)adaptor.create(ASSIGN35);
                    adaptor.addChild(root_0, ASSIGN35_tree);
                    }
                    pushFollow(FOLLOW_test_in_defparameter1003);
                    test36=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, test36.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        retval.etype = actions.castExpr((fpdef34!=null?((PythonTree)fpdef34.tree):null));
                        if (ASSIGN35 != null) {
                            defaults.add((test36!=null?((PythonTree)test36.tree):null));
                        } else if (!defaults.isEmpty()) {
                            throw new ParseException("non-default argument follows default argument", (fpdef34!=null?((PythonTree)fpdef34.tree):null));
                        }
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = retval.etype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "defparameter"

    public static class varargslist_return extends ParserRuleReturnScope {
        public arguments args;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varargslist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:496:1: varargslist returns [arguments args] : (d+= defparameter[defaults] ( options {greedy=true; } : COMMA d+= defparameter[defaults] )* ( COMMA ( STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )? )? | STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME );
    public final PythonParser.varargslist_return varargslist() throws RecognitionException {
        PythonParser.varargslist_return retval = new PythonParser.varargslist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token starargs=null;
        Token kwargs=null;
        Token COMMA37=null;
        Token COMMA38=null;
        Token STAR39=null;
        Token COMMA40=null;
        Token DOUBLESTAR41=null;
        Token DOUBLESTAR42=null;
        Token STAR43=null;
        Token COMMA44=null;
        Token DOUBLESTAR45=null;
        Token DOUBLESTAR46=null;
        List list_d=null;
        PythonParser.defparameter_return d = null;
         d = null;
        PythonTree starargs_tree=null;
        PythonTree kwargs_tree=null;
        PythonTree COMMA37_tree=null;
        PythonTree COMMA38_tree=null;
        PythonTree STAR39_tree=null;
        PythonTree COMMA40_tree=null;
        PythonTree DOUBLESTAR41_tree=null;
        PythonTree DOUBLESTAR42_tree=null;
        PythonTree STAR43_tree=null;
        PythonTree COMMA44_tree=null;
        PythonTree DOUBLESTAR45_tree=null;
        PythonTree DOUBLESTAR46_tree=null;


            List defaults = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:501:5: (d+= defparameter[defaults] ( options {greedy=true; } : COMMA d+= defparameter[defaults] )* ( COMMA ( STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )? )? | STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )
            int alt22=3;
            switch ( input.LA(1) ) {
            case NAME:
            case LPAREN:
                {
                alt22=1;
                }
                break;
            case STAR:
                {
                alt22=2;
                }
                break;
            case DOUBLESTAR:
                {
                alt22=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:501:7: d+= defparameter[defaults] ( options {greedy=true; } : COMMA d+= defparameter[defaults] )* ( COMMA ( STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )? )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_defparameter_in_varargslist1049);
                    d=defparameter(defaults);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
                    if (list_d==null) list_d=new ArrayList();
                    list_d.add(d.getTree());

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:501:33: ( options {greedy=true; } : COMMA d+= defparameter[defaults] )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==COMMA) ) {
                            int LA17_1 = input.LA(2);

                            if ( (LA17_1==NAME||LA17_1==LPAREN) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:501:57: COMMA d+= defparameter[defaults]
                    	    {
                    	    COMMA37=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1060); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA37_tree = (PythonTree)adaptor.create(COMMA37);
                    	    adaptor.addChild(root_0, COMMA37_tree);
                    	    }
                    	    pushFollow(FOLLOW_defparameter_in_varargslist1064);
                    	    d=defparameter(defaults);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
                    	    if (list_d==null) list_d=new ArrayList();
                    	    list_d.add(d.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:502:7: ( COMMA ( STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )? )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==COMMA) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:502:8: COMMA ( STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )?
                            {
                            COMMA38=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1076); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA38_tree = (PythonTree)adaptor.create(COMMA38);
                            adaptor.addChild(root_0, COMMA38_tree);
                            }
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:503:11: ( STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )? | DOUBLESTAR kwargs= NAME )?
                            int alt19=3;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==STAR) ) {
                                alt19=1;
                            }
                            else if ( (LA19_0==DOUBLESTAR) ) {
                                alt19=2;
                            }
                            switch (alt19) {
                                case 1 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:503:12: STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )?
                                    {
                                    STAR39=(Token)match(input,STAR,FOLLOW_STAR_in_varargslist1089); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    STAR39_tree = (PythonTree)adaptor.create(STAR39);
                                    adaptor.addChild(root_0, STAR39_tree);
                                    }
                                    starargs=(Token)match(input,NAME,FOLLOW_NAME_in_varargslist1093); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    starargs_tree = (PythonTree)adaptor.create(starargs);
                                    adaptor.addChild(root_0, starargs_tree);
                                    }
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:503:31: ( COMMA DOUBLESTAR kwargs= NAME )?
                                    int alt18=2;
                                    int LA18_0 = input.LA(1);

                                    if ( (LA18_0==COMMA) ) {
                                        alt18=1;
                                    }
                                    switch (alt18) {
                                        case 1 :
                                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:503:32: COMMA DOUBLESTAR kwargs= NAME
                                            {
                                            COMMA40=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1096); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            COMMA40_tree = (PythonTree)adaptor.create(COMMA40);
                                            adaptor.addChild(root_0, COMMA40_tree);
                                            }
                                            DOUBLESTAR41=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1098); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            DOUBLESTAR41_tree = (PythonTree)adaptor.create(DOUBLESTAR41);
                                            adaptor.addChild(root_0, DOUBLESTAR41_tree);
                                            }
                                            kwargs=(Token)match(input,NAME,FOLLOW_NAME_in_varargslist1102); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            kwargs_tree = (PythonTree)adaptor.create(kwargs);
                                            adaptor.addChild(root_0, kwargs_tree);
                                            }

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:504:13: DOUBLESTAR kwargs= NAME
                                    {
                                    DOUBLESTAR42=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1118); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    DOUBLESTAR42_tree = (PythonTree)adaptor.create(DOUBLESTAR42);
                                    adaptor.addChild(root_0, DOUBLESTAR42_tree);
                                    }
                                    kwargs=(Token)match(input,NAME,FOLLOW_NAME_in_varargslist1122); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    kwargs_tree = (PythonTree)adaptor.create(kwargs);
                                    adaptor.addChild(root_0, kwargs_tree);
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                retval.args = actions.makeArgumentsType(((Token)retval.start), list_d, starargs, kwargs, defaults);
                            
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:510:7: STAR starargs= NAME ( COMMA DOUBLESTAR kwargs= NAME )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    STAR43=(Token)match(input,STAR,FOLLOW_STAR_in_varargslist1160); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR43_tree = (PythonTree)adaptor.create(STAR43);
                    adaptor.addChild(root_0, STAR43_tree);
                    }
                    starargs=(Token)match(input,NAME,FOLLOW_NAME_in_varargslist1164); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    starargs_tree = (PythonTree)adaptor.create(starargs);
                    adaptor.addChild(root_0, starargs_tree);
                    }
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:510:26: ( COMMA DOUBLESTAR kwargs= NAME )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==COMMA) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:510:27: COMMA DOUBLESTAR kwargs= NAME
                            {
                            COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_varargslist1167); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA44_tree = (PythonTree)adaptor.create(COMMA44);
                            adaptor.addChild(root_0, COMMA44_tree);
                            }
                            DOUBLESTAR45=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1169); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DOUBLESTAR45_tree = (PythonTree)adaptor.create(DOUBLESTAR45);
                            adaptor.addChild(root_0, DOUBLESTAR45_tree);
                            }
                            kwargs=(Token)match(input,NAME,FOLLOW_NAME_in_varargslist1173); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            kwargs_tree = (PythonTree)adaptor.create(kwargs);
                            adaptor.addChild(root_0, kwargs_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                retval.args = actions.makeArgumentsType(((Token)retval.start), list_d, starargs, kwargs, defaults);
                            
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:514:7: DOUBLESTAR kwargs= NAME
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    DOUBLESTAR46=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_varargslist1191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLESTAR46_tree = (PythonTree)adaptor.create(DOUBLESTAR46);
                    adaptor.addChild(root_0, DOUBLESTAR46_tree);
                    }
                    kwargs=(Token)match(input,NAME,FOLLOW_NAME_in_varargslist1195); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    kwargs_tree = (PythonTree)adaptor.create(kwargs);
                    adaptor.addChild(root_0, kwargs_tree);
                    }
                    if ( state.backtracking==0 ) {

                                retval.args = actions.makeArgumentsType(((Token)retval.start), list_d, null, kwargs, defaults);
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "varargslist"

    public static class fpdef_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fpdef"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:521:1: fpdef[expr_contextType ctype] : ( NAME -> ^( NAME[$NAME, $NAME.text, ctype] ) | ( LPAREN fpdef[null] COMMA )=> LPAREN fplist RPAREN -> ^( LPAREN[$fplist.start, actions.castExprs($fplist.etypes), expr_contextType.Store] ) | LPAREN fplist RPAREN -> fplist );
    public final PythonParser.fpdef_return fpdef(expr_contextType ctype) throws RecognitionException {
        PythonParser.fpdef_return retval = new PythonParser.fpdef_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token NAME47=null;
        Token LPAREN48=null;
        Token RPAREN50=null;
        Token LPAREN51=null;
        Token RPAREN53=null;
        PythonParser.fplist_return fplist49 = null;

        PythonParser.fplist_return fplist52 = null;


        PythonTree NAME47_tree=null;
        PythonTree LPAREN48_tree=null;
        PythonTree RPAREN50_tree=null;
        PythonTree LPAREN51_tree=null;
        PythonTree RPAREN53_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_fplist=new RewriteRuleSubtreeStream(adaptor,"rule fplist");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:525:5: ( NAME -> ^( NAME[$NAME, $NAME.text, ctype] ) | ( LPAREN fpdef[null] COMMA )=> LPAREN fplist RPAREN -> ^( LPAREN[$fplist.start, actions.castExprs($fplist.etypes), expr_contextType.Store] ) | LPAREN fplist RPAREN -> fplist )
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==NAME) ) {
                alt23=1;
            }
            else if ( (LA23_0==LPAREN) ) {
                int LA23_2 = input.LA(2);

                if ( (synpred1_Python()) ) {
                    alt23=2;
                }
                else if ( (true) ) {
                    alt23=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:525:7: NAME
                    {
                    NAME47=(Token)match(input,NAME,FOLLOW_NAME_in_fpdef1227); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME47);



                    // AST REWRITE
                    // elements: NAME
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 526:4: -> ^( NAME[$NAME, $NAME.text, ctype] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:526:7: ^( NAME[$NAME, $NAME.text, ctype] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Name(NAME, NAME47, (NAME47!=null?NAME47.getText():null), ctype), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:527:7: ( LPAREN fpdef[null] COMMA )=> LPAREN fplist RPAREN
                    {
                    LPAREN48=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_fpdef1259); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN48);

                    pushFollow(FOLLOW_fplist_in_fpdef1261);
                    fplist49=fplist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fplist.add(fplist49.getTree());
                    RPAREN50=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_fpdef1263); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN50);



                    // AST REWRITE
                    // elements: LPAREN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 528:4: -> ^( LPAREN[$fplist.start, actions.castExprs($fplist.etypes), expr_contextType.Store] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:528:7: ^( LPAREN[$fplist.start, actions.castExprs($fplist.etypes), expr_contextType.Store] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Tuple(LPAREN, (fplist49!=null?((Token)fplist49.start):null), actions.castExprs((fplist49!=null?fplist49.etypes:null)), expr_contextType.Store), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:529:7: LPAREN fplist RPAREN
                    {
                    LPAREN51=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_fpdef1284); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN51);

                    pushFollow(FOLLOW_fplist_in_fpdef1286);
                    fplist52=fplist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_fplist.add(fplist52.getTree());
                    RPAREN53=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_fpdef1288); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN53);



                    // AST REWRITE
                    // elements: fplist
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 530:4: -> fplist
                    {
                        adaptor.addChild(root_0, stream_fplist.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  actions.checkAssign(actions.castExpr(((PythonTree)retval.tree)));

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fpdef"

    public static class fplist_return extends ParserRuleReturnScope {
        public List etypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fplist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:534:1: fplist returns [List etypes] : f+= fpdef[expr_contextType.Store] ( options {greedy=true; } : COMMA f+= fpdef[expr_contextType.Store] )* ( COMMA )? ;
    public final PythonParser.fplist_return fplist() throws RecognitionException {
        PythonParser.fplist_return retval = new PythonParser.fplist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA54=null;
        Token COMMA55=null;
        List list_f=null;
        PythonParser.fpdef_return f = null;
         f = null;
        PythonTree COMMA54_tree=null;
        PythonTree COMMA55_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:536:5: (f+= fpdef[expr_contextType.Store] ( options {greedy=true; } : COMMA f+= fpdef[expr_contextType.Store] )* ( COMMA )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:536:7: f+= fpdef[expr_contextType.Store] ( options {greedy=true; } : COMMA f+= fpdef[expr_contextType.Store] )* ( COMMA )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_fpdef_in_fplist1323);
            f=fpdef(expr_contextType.Store);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            if (list_f==null) list_f=new ArrayList();
            list_f.add(f.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:537:7: ( options {greedy=true; } : COMMA f+= fpdef[expr_contextType.Store] )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==COMMA) ) {
                    int LA24_1 = input.LA(2);

                    if ( (LA24_1==NAME||LA24_1==LPAREN) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:537:31: COMMA f+= fpdef[expr_contextType.Store]
            	    {
            	    COMMA54=(Token)match(input,COMMA,FOLLOW_COMMA_in_fplist1340); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA54_tree = (PythonTree)adaptor.create(COMMA54);
            	    adaptor.addChild(root_0, COMMA54_tree);
            	    }
            	    pushFollow(FOLLOW_fpdef_in_fplist1344);
            	    f=fpdef(expr_contextType.Store);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());
            	    if (list_f==null) list_f=new ArrayList();
            	    list_f.add(f.getTree());


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:537:72: ( COMMA )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==COMMA) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:537:73: COMMA
                    {
                    COMMA55=(Token)match(input,COMMA,FOLLOW_COMMA_in_fplist1350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA55_tree = (PythonTree)adaptor.create(COMMA55);
                    adaptor.addChild(root_0, COMMA55_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        retval.etypes = list_f;
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "fplist"

    public static class stmt_return extends ParserRuleReturnScope {
        public List stypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:544:1: stmt returns [List stypes] : ( simple_stmt | compound_stmt );
    public final PythonParser.stmt_return stmt() throws RecognitionException {
        PythonParser.stmt_return retval = new PythonParser.stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.simple_stmt_return simple_stmt56 = null;

        PythonParser.compound_stmt_return compound_stmt57 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:546:5: ( simple_stmt | compound_stmt )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==NAME||(LA26_0>=ASSERT && LA26_0<=BREAK)||LA26_0==CONTINUE||LA26_0==DELETE||LA26_0==EXEC||LA26_0==FROM||LA26_0==GLOBAL||LA26_0==IMPORT||(LA26_0>=LAMBDA && LA26_0<=NOT)||(LA26_0>=PASS && LA26_0<=RETURN)||LA26_0==YIELD||LA26_0==LPAREN||(LA26_0>=PLUS && LA26_0<=MINUS)||(LA26_0>=TILDE && LA26_0<=LBRACK)||LA26_0==LCURLY||(LA26_0>=BACKQUOTE && LA26_0<=STRING)) ) {
                alt26=1;
            }
            else if ( (LA26_0==CLASS||LA26_0==DEF||LA26_0==FOR||LA26_0==IF||(LA26_0>=TRY && LA26_0<=WITH)||LA26_0==AT) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:546:7: simple_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_stmt_in_stmt1386);
                    simple_stmt56=simple_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_stmt56.getTree());
                    if ( state.backtracking==0 ) {

                                retval.stypes = (simple_stmt56!=null?simple_stmt56.stypes:null);
                            
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:550:7: compound_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_compound_stmt_in_stmt1402);
                    compound_stmt57=compound_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, compound_stmt57.getTree());
                    if ( state.backtracking==0 ) {

                                retval.stypes = new ArrayList();
                                retval.stypes.add((compound_stmt57!=null?((PythonTree)compound_stmt57.tree):null));
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stmt"

    public static class simple_stmt_return extends ParserRuleReturnScope {
        public List stypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simple_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:558:1: simple_stmt returns [List stypes] : s+= small_stmt ( options {greedy=true; } : SEMI s+= small_stmt )* ( SEMI )? NEWLINE ;
    public final PythonParser.simple_stmt_return simple_stmt() throws RecognitionException {
        PythonParser.simple_stmt_return retval = new PythonParser.simple_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token SEMI58=null;
        Token SEMI59=null;
        Token NEWLINE60=null;
        List list_s=null;
        PythonParser.small_stmt_return s = null;
         s = null;
        PythonTree SEMI58_tree=null;
        PythonTree SEMI59_tree=null;
        PythonTree NEWLINE60_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:560:5: (s+= small_stmt ( options {greedy=true; } : SEMI s+= small_stmt )* ( SEMI )? NEWLINE )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:560:7: s+= small_stmt ( options {greedy=true; } : SEMI s+= small_stmt )* ( SEMI )? NEWLINE
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_small_stmt_in_simple_stmt1438);
            s=small_stmt();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            if (list_s==null) list_s=new ArrayList();
            list_s.add(s.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:560:21: ( options {greedy=true; } : SEMI s+= small_stmt )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==SEMI) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==NAME||(LA27_1>=ASSERT && LA27_1<=BREAK)||LA27_1==CONTINUE||LA27_1==DELETE||LA27_1==EXEC||LA27_1==FROM||LA27_1==GLOBAL||LA27_1==IMPORT||(LA27_1>=LAMBDA && LA27_1<=NOT)||(LA27_1>=PASS && LA27_1<=RETURN)||LA27_1==YIELD||LA27_1==LPAREN||(LA27_1>=PLUS && LA27_1<=MINUS)||(LA27_1>=TILDE && LA27_1<=LBRACK)||LA27_1==LCURLY||(LA27_1>=BACKQUOTE && LA27_1<=STRING)) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:560:45: SEMI s+= small_stmt
            	    {
            	    SEMI58=(Token)match(input,SEMI,FOLLOW_SEMI_in_simple_stmt1448); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    SEMI58_tree = (PythonTree)adaptor.create(SEMI58);
            	    adaptor.addChild(root_0, SEMI58_tree);
            	    }
            	    pushFollow(FOLLOW_small_stmt_in_simple_stmt1452);
            	    s=small_stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());
            	    if (list_s==null) list_s=new ArrayList();
            	    list_s.add(s.getTree());


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:560:66: ( SEMI )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==SEMI) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:560:67: SEMI
                    {
                    SEMI59=(Token)match(input,SEMI,FOLLOW_SEMI_in_simple_stmt1457); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMI59_tree = (PythonTree)adaptor.create(SEMI59);
                    adaptor.addChild(root_0, SEMI59_tree);
                    }

                    }
                    break;

            }

            NEWLINE60=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_simple_stmt1461); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NEWLINE60_tree = (PythonTree)adaptor.create(NEWLINE60);
            adaptor.addChild(root_0, NEWLINE60_tree);
            }
            if ( state.backtracking==0 ) {

                        retval.stypes = list_s;
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simple_stmt"

    public static class small_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "small_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:568:1: small_stmt : ( expr_stmt | print_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | exec_stmt | assert_stmt );
    public final PythonParser.small_stmt_return small_stmt() throws RecognitionException {
        PythonParser.small_stmt_return retval = new PythonParser.small_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.expr_stmt_return expr_stmt61 = null;

        PythonParser.print_stmt_return print_stmt62 = null;

        PythonParser.del_stmt_return del_stmt63 = null;

        PythonParser.pass_stmt_return pass_stmt64 = null;

        PythonParser.flow_stmt_return flow_stmt65 = null;

        PythonParser.import_stmt_return import_stmt66 = null;

        PythonParser.global_stmt_return global_stmt67 = null;

        PythonParser.exec_stmt_return exec_stmt68 = null;

        PythonParser.assert_stmt_return assert_stmt69 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:568:12: ( expr_stmt | print_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | exec_stmt | assert_stmt )
            int alt29=9;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:568:14: expr_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_stmt_in_small_stmt1484);
                    expr_stmt61=expr_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_stmt61.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:569:14: print_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_print_stmt_in_small_stmt1499);
                    print_stmt62=print_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, print_stmt62.getTree());

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:570:14: del_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_del_stmt_in_small_stmt1514);
                    del_stmt63=del_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, del_stmt63.getTree());

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:571:14: pass_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_pass_stmt_in_small_stmt1529);
                    pass_stmt64=pass_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, pass_stmt64.getTree());

                    }
                    break;
                case 5 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:572:14: flow_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_flow_stmt_in_small_stmt1544);
                    flow_stmt65=flow_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, flow_stmt65.getTree());

                    }
                    break;
                case 6 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:573:14: import_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_import_stmt_in_small_stmt1559);
                    import_stmt66=import_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, import_stmt66.getTree());

                    }
                    break;
                case 7 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:574:14: global_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_global_stmt_in_small_stmt1574);
                    global_stmt67=global_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, global_stmt67.getTree());

                    }
                    break;
                case 8 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:575:14: exec_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_exec_stmt_in_small_stmt1589);
                    exec_stmt68=exec_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exec_stmt68.getTree());

                    }
                    break;
                case 9 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:576:14: assert_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_assert_stmt_in_small_stmt1604);
                    assert_stmt69=assert_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assert_stmt69.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "small_stmt"

    public static class expr_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:581:1: expr_stmt : ( ( testlist[null] augassign )=>lhs= testlist[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) ) | ( testlist[null] ASSIGN )=>lhs= testlist[expr_contextType.Store] ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) ) | lhs= testlist[expr_contextType.Load] ) ;
    public final PythonParser.expr_stmt_return expr_stmt() throws RecognitionException {
        PythonParser.expr_stmt_return retval = new PythonParser.expr_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token at=null;
        Token ay=null;
        List list_t=null;
        List list_y2=null;
        PythonParser.testlist_return lhs = null;

        PythonParser.augassign_return aay = null;

        PythonParser.yield_expr_return y1 = null;

        PythonParser.augassign_return aat = null;

        PythonParser.testlist_return rhs = null;

        PythonParser.testlist_return t = null;
         t = null;
        PythonParser.yield_expr_return y2 = null;
         y2 = null;
        PythonTree at_tree=null;
        PythonTree ay_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_augassign=new RewriteRuleSubtreeStream(adaptor,"rule augassign");
        RewriteRuleSubtreeStream stream_yield_expr=new RewriteRuleSubtreeStream(adaptor,"rule yield_expr");
        RewriteRuleSubtreeStream stream_testlist=new RewriteRuleSubtreeStream(adaptor,"rule testlist");

            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:590:5: ( ( ( testlist[null] augassign )=>lhs= testlist[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) ) | ( testlist[null] ASSIGN )=>lhs= testlist[expr_contextType.Store] ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) ) | lhs= testlist[expr_contextType.Load] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:590:7: ( ( testlist[null] augassign )=>lhs= testlist[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) ) | ( testlist[null] ASSIGN )=>lhs= testlist[expr_contextType.Store] ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) ) | lhs= testlist[expr_contextType.Load] )
            {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:590:7: ( ( testlist[null] augassign )=>lhs= testlist[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) ) | ( testlist[null] ASSIGN )=>lhs= testlist[expr_contextType.Store] ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) ) | lhs= testlist[expr_contextType.Load] )
            int alt34=3;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:590:8: ( testlist[null] augassign )=>lhs= testlist[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) )
                    {
                    pushFollow(FOLLOW_testlist_in_expr_stmt1652);
                    lhs=testlist(expr_contextType.AugStore);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_testlist.add(lhs.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:591:9: ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) )
                    int alt30=2;
                    alt30 = dfa30.predict(input);
                    switch (alt30) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:591:11: (aay= augassign y1= yield_expr )
                            {
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:591:11: (aay= augassign y1= yield_expr )
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:591:12: aay= augassign y1= yield_expr
                            {
                            pushFollow(FOLLOW_augassign_in_expr_stmt1668);
                            aay=augassign();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_augassign.add(aay.getTree());
                            pushFollow(FOLLOW_yield_expr_in_expr_stmt1672);
                            y1=yield_expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_yield_expr.add(y1.getTree());
                            if ( state.backtracking==0 ) {

                                             actions.checkAssign(actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)));
                                             stype = new AugAssign((lhs!=null?((PythonTree)lhs.tree):null), actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)), (aay!=null?aay.op:null), actions.castExpr((y1!=null?((PythonTree)y1.tree):null)));
                                         
                            }

                            }


                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:597:11: (aat= augassign rhs= testlist[expr_contextType.Load] )
                            {
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:597:11: (aat= augassign rhs= testlist[expr_contextType.Load] )
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:597:12: aat= augassign rhs= testlist[expr_contextType.Load]
                            {
                            pushFollow(FOLLOW_augassign_in_expr_stmt1712);
                            aat=augassign();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_augassign.add(aat.getTree());
                            pushFollow(FOLLOW_testlist_in_expr_stmt1716);
                            rhs=testlist(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_testlist.add(rhs.getTree());
                            if ( state.backtracking==0 ) {

                                             actions.checkAssign(actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)));
                                             stype = new AugAssign((lhs!=null?((PythonTree)lhs.tree):null), actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)), (aat!=null?aat.op:null), actions.castExpr((rhs!=null?((PythonTree)rhs.tree):null)));
                                         
                            }

                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:604:7: ( testlist[null] ASSIGN )=>lhs= testlist[expr_contextType.Store] ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) )
                    {
                    pushFollow(FOLLOW_testlist_in_expr_stmt1771);
                    lhs=testlist(expr_contextType.Store);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_testlist.add(lhs.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:605:9: ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) )
                    int alt33=3;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==NEWLINE||LA33_0==SEMI) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==ASSIGN) ) {
                        int LA33_2 = input.LA(2);

                        if ( (LA33_2==NAME||(LA33_2>=LAMBDA && LA33_2<=NOT)||LA33_2==LPAREN||(LA33_2>=PLUS && LA33_2<=MINUS)||(LA33_2>=TILDE && LA33_2<=LBRACK)||LA33_2==LCURLY||(LA33_2>=BACKQUOTE && LA33_2<=STRING)) ) {
                            alt33=2;
                        }
                        else if ( (LA33_2==YIELD) ) {
                            alt33=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 33, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:606:9: 
                            {
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:606:11: ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) )
                            {
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:606:11: ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) )
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:606:12: (at= ASSIGN t+= testlist[expr_contextType.Store] )+
                            {
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:606:12: (at= ASSIGN t+= testlist[expr_contextType.Store] )+
                            int cnt31=0;
                            loop31:
                            do {
                                int alt31=2;
                                int LA31_0 = input.LA(1);

                                if ( (LA31_0==ASSIGN) ) {
                                    alt31=1;
                                }


                                switch (alt31) {
                            	case 1 :
                            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:606:13: at= ASSIGN t+= testlist[expr_contextType.Store]
                            	    {
                            	    at=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_expr_stmt1798); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_ASSIGN.add(at);

                            	    pushFollow(FOLLOW_testlist_in_expr_stmt1802);
                            	    t=testlist(expr_contextType.Store);

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_testlist.add(t.getTree());
                            	    if (list_t==null) list_t=new ArrayList();
                            	    list_t.add(t.getTree());


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt31 >= 1 ) break loop31;
                            	    if (state.backtracking>0) {state.failed=true; return retval;}
                                        EarlyExitException eee =
                                            new EarlyExitException(31, input);
                                        throw eee;
                                }
                                cnt31++;
                            } while (true);



                            // AST REWRITE
                            // elements: ASSIGN
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 607:8: -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:607:11: ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Assign(ASSIGN, (lhs!=null?((Token)lhs.start):null), actions.makeAssignTargets(actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)), list_t), actions.makeAssignValue(list_t)), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }


                            }
                            break;
                        case 3 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:610:11: ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) )
                            {
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:610:11: ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) )
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:610:12: (ay= ASSIGN y2+= yield_expr )+
                            {
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:610:12: (ay= ASSIGN y2+= yield_expr )+
                            int cnt32=0;
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==ASSIGN) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:610:13: ay= ASSIGN y2+= yield_expr
                            	    {
                            	    ay=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_expr_stmt1850); if (state.failed) return retval; 
                            	    if ( state.backtracking==0 ) stream_ASSIGN.add(ay);

                            	    pushFollow(FOLLOW_yield_expr_in_expr_stmt1854);
                            	    y2=yield_expr();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_yield_expr.add(y2.getTree());
                            	    if (list_y2==null) list_y2=new ArrayList();
                            	    list_y2.add(y2.getTree());


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt32 >= 1 ) break loop32;
                            	    if (state.backtracking>0) {state.failed=true; return retval;}
                                        EarlyExitException eee =
                                            new EarlyExitException(32, input);
                                        throw eee;
                                }
                                cnt32++;
                            } while (true);



                            // AST REWRITE
                            // elements: ASSIGN
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 611:8: -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:611:11: ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Assign(ASSIGN, (lhs!=null?((Token)lhs.start):null), actions.makeAssignTargets(actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)), list_y2), actions.makeAssignValue(list_y2)), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }


                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:615:7: lhs= testlist[expr_contextType.Load]
                    {
                    pushFollow(FOLLOW_testlist_in_expr_stmt1905);
                    lhs=testlist(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_testlist.add(lhs.getTree());
                    if ( state.backtracking==0 ) {

                                stype = new Expr((lhs!=null?((Token)lhs.start):null), actions.castExpr((lhs!=null?((PythonTree)lhs.tree):null)));
                            
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (stype != null) {
                      retval.tree = stype;
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expr_stmt"

    public static class augassign_return extends ParserRuleReturnScope {
        public operatorType op;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "augassign"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:624:1: augassign returns [operatorType op] : ( PLUSEQUAL | MINUSEQUAL | STAREQUAL | SLASHEQUAL | PERCENTEQUAL | AMPEREQUAL | VBAREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL );
    public final PythonParser.augassign_return augassign() throws RecognitionException {
        PythonParser.augassign_return retval = new PythonParser.augassign_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token PLUSEQUAL70=null;
        Token MINUSEQUAL71=null;
        Token STAREQUAL72=null;
        Token SLASHEQUAL73=null;
        Token PERCENTEQUAL74=null;
        Token AMPEREQUAL75=null;
        Token VBAREQUAL76=null;
        Token CIRCUMFLEXEQUAL77=null;
        Token LEFTSHIFTEQUAL78=null;
        Token RIGHTSHIFTEQUAL79=null;
        Token DOUBLESTAREQUAL80=null;
        Token DOUBLESLASHEQUAL81=null;

        PythonTree PLUSEQUAL70_tree=null;
        PythonTree MINUSEQUAL71_tree=null;
        PythonTree STAREQUAL72_tree=null;
        PythonTree SLASHEQUAL73_tree=null;
        PythonTree PERCENTEQUAL74_tree=null;
        PythonTree AMPEREQUAL75_tree=null;
        PythonTree VBAREQUAL76_tree=null;
        PythonTree CIRCUMFLEXEQUAL77_tree=null;
        PythonTree LEFTSHIFTEQUAL78_tree=null;
        PythonTree RIGHTSHIFTEQUAL79_tree=null;
        PythonTree DOUBLESTAREQUAL80_tree=null;
        PythonTree DOUBLESLASHEQUAL81_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:626:5: ( PLUSEQUAL | MINUSEQUAL | STAREQUAL | SLASHEQUAL | PERCENTEQUAL | AMPEREQUAL | VBAREQUAL | CIRCUMFLEXEQUAL | LEFTSHIFTEQUAL | RIGHTSHIFTEQUAL | DOUBLESTAREQUAL | DOUBLESLASHEQUAL )
            int alt35=12;
            switch ( input.LA(1) ) {
            case PLUSEQUAL:
                {
                alt35=1;
                }
                break;
            case MINUSEQUAL:
                {
                alt35=2;
                }
                break;
            case STAREQUAL:
                {
                alt35=3;
                }
                break;
            case SLASHEQUAL:
                {
                alt35=4;
                }
                break;
            case PERCENTEQUAL:
                {
                alt35=5;
                }
                break;
            case AMPEREQUAL:
                {
                alt35=6;
                }
                break;
            case VBAREQUAL:
                {
                alt35=7;
                }
                break;
            case CIRCUMFLEXEQUAL:
                {
                alt35=8;
                }
                break;
            case LEFTSHIFTEQUAL:
                {
                alt35=9;
                }
                break;
            case RIGHTSHIFTEQUAL:
                {
                alt35=10;
                }
                break;
            case DOUBLESTAREQUAL:
                {
                alt35=11;
                }
                break;
            case DOUBLESLASHEQUAL:
                {
                alt35=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:626:7: PLUSEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    PLUSEQUAL70=(Token)match(input,PLUSEQUAL,FOLLOW_PLUSEQUAL_in_augassign1947); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUSEQUAL70_tree = (PythonTree)adaptor.create(PLUSEQUAL70);
                    adaptor.addChild(root_0, PLUSEQUAL70_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Add;
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:628:7: MINUSEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    MINUSEQUAL71=(Token)match(input,MINUSEQUAL,FOLLOW_MINUSEQUAL_in_augassign1965); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUSEQUAL71_tree = (PythonTree)adaptor.create(MINUSEQUAL71);
                    adaptor.addChild(root_0, MINUSEQUAL71_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Sub;
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:630:7: STAREQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    STAREQUAL72=(Token)match(input,STAREQUAL,FOLLOW_STAREQUAL_in_augassign1983); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAREQUAL72_tree = (PythonTree)adaptor.create(STAREQUAL72);
                    adaptor.addChild(root_0, STAREQUAL72_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Mult;
                    }

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:632:7: SLASHEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    SLASHEQUAL73=(Token)match(input,SLASHEQUAL,FOLLOW_SLASHEQUAL_in_augassign2001); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SLASHEQUAL73_tree = (PythonTree)adaptor.create(SLASHEQUAL73);
                    adaptor.addChild(root_0, SLASHEQUAL73_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Div;
                    }

                    }
                    break;
                case 5 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:634:7: PERCENTEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    PERCENTEQUAL74=(Token)match(input,PERCENTEQUAL,FOLLOW_PERCENTEQUAL_in_augassign2019); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENTEQUAL74_tree = (PythonTree)adaptor.create(PERCENTEQUAL74);
                    adaptor.addChild(root_0, PERCENTEQUAL74_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Mod;
                    }

                    }
                    break;
                case 6 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:636:7: AMPEREQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    AMPEREQUAL75=(Token)match(input,AMPEREQUAL,FOLLOW_AMPEREQUAL_in_augassign2037); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AMPEREQUAL75_tree = (PythonTree)adaptor.create(AMPEREQUAL75);
                    adaptor.addChild(root_0, AMPEREQUAL75_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.BitAnd;
                    }

                    }
                    break;
                case 7 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:638:7: VBAREQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    VBAREQUAL76=(Token)match(input,VBAREQUAL,FOLLOW_VBAREQUAL_in_augassign2055); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    VBAREQUAL76_tree = (PythonTree)adaptor.create(VBAREQUAL76);
                    adaptor.addChild(root_0, VBAREQUAL76_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.BitOr;
                    }

                    }
                    break;
                case 8 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:640:7: CIRCUMFLEXEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    CIRCUMFLEXEQUAL77=(Token)match(input,CIRCUMFLEXEQUAL,FOLLOW_CIRCUMFLEXEQUAL_in_augassign2073); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CIRCUMFLEXEQUAL77_tree = (PythonTree)adaptor.create(CIRCUMFLEXEQUAL77);
                    adaptor.addChild(root_0, CIRCUMFLEXEQUAL77_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.BitXor;
                    }

                    }
                    break;
                case 9 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:642:7: LEFTSHIFTEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    LEFTSHIFTEQUAL78=(Token)match(input,LEFTSHIFTEQUAL,FOLLOW_LEFTSHIFTEQUAL_in_augassign2091); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFTSHIFTEQUAL78_tree = (PythonTree)adaptor.create(LEFTSHIFTEQUAL78);
                    adaptor.addChild(root_0, LEFTSHIFTEQUAL78_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.LShift;
                    }

                    }
                    break;
                case 10 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:644:7: RIGHTSHIFTEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    RIGHTSHIFTEQUAL79=(Token)match(input,RIGHTSHIFTEQUAL,FOLLOW_RIGHTSHIFTEQUAL_in_augassign2109); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHTSHIFTEQUAL79_tree = (PythonTree)adaptor.create(RIGHTSHIFTEQUAL79);
                    adaptor.addChild(root_0, RIGHTSHIFTEQUAL79_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.RShift;
                    }

                    }
                    break;
                case 11 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:646:7: DOUBLESTAREQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    DOUBLESTAREQUAL80=(Token)match(input,DOUBLESTAREQUAL,FOLLOW_DOUBLESTAREQUAL_in_augassign2127); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLESTAREQUAL80_tree = (PythonTree)adaptor.create(DOUBLESTAREQUAL80);
                    adaptor.addChild(root_0, DOUBLESTAREQUAL80_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Pow;
                    }

                    }
                    break;
                case 12 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:648:7: DOUBLESLASHEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    DOUBLESLASHEQUAL81=(Token)match(input,DOUBLESLASHEQUAL,FOLLOW_DOUBLESLASHEQUAL_in_augassign2145); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLESLASHEQUAL81_tree = (PythonTree)adaptor.create(DOUBLESLASHEQUAL81);
                    adaptor.addChild(root_0, DOUBLESLASHEQUAL81_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.FloorDiv;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "augassign"

    public static class print_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "print_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:654:1: print_stmt : PRINT (t1= printlist -> ^( PRINT[$PRINT, null, actions.castExprs($t1.elts), $t1.newline] ) | RIGHTSHIFT t2= printlist2 -> ^( PRINT[$PRINT, actions.castExpr($t2.elts.get(0)), actions.castExprs($t2.elts, 1), $t2.newline] ) | -> ^( PRINT[$PRINT, null, new ArrayList<expr>(), true] ) ) ;
    public final PythonParser.print_stmt_return print_stmt() throws RecognitionException {
        PythonParser.print_stmt_return retval = new PythonParser.print_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token PRINT82=null;
        Token RIGHTSHIFT83=null;
        PythonParser.printlist_return t1 = null;

        PythonParser.printlist2_return t2 = null;


        PythonTree PRINT82_tree=null;
        PythonTree RIGHTSHIFT83_tree=null;
        RewriteRuleTokenStream stream_RIGHTSHIFT=new RewriteRuleTokenStream(adaptor,"token RIGHTSHIFT");
        RewriteRuleTokenStream stream_PRINT=new RewriteRuleTokenStream(adaptor,"token PRINT");
        RewriteRuleSubtreeStream stream_printlist=new RewriteRuleSubtreeStream(adaptor,"rule printlist");
        RewriteRuleSubtreeStream stream_printlist2=new RewriteRuleSubtreeStream(adaptor,"rule printlist2");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:655:5: ( PRINT (t1= printlist -> ^( PRINT[$PRINT, null, actions.castExprs($t1.elts), $t1.newline] ) | RIGHTSHIFT t2= printlist2 -> ^( PRINT[$PRINT, actions.castExpr($t2.elts.get(0)), actions.castExprs($t2.elts, 1), $t2.newline] ) | -> ^( PRINT[$PRINT, null, new ArrayList<expr>(), true] ) ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:655:7: PRINT (t1= printlist -> ^( PRINT[$PRINT, null, actions.castExprs($t1.elts), $t1.newline] ) | RIGHTSHIFT t2= printlist2 -> ^( PRINT[$PRINT, actions.castExpr($t2.elts.get(0)), actions.castExprs($t2.elts, 1), $t2.newline] ) | -> ^( PRINT[$PRINT, null, new ArrayList<expr>(), true] ) )
            {
            PRINT82=(Token)match(input,PRINT,FOLLOW_PRINT_in_print_stmt2174); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PRINT.add(PRINT82);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:656:7: (t1= printlist -> ^( PRINT[$PRINT, null, actions.castExprs($t1.elts), $t1.newline] ) | RIGHTSHIFT t2= printlist2 -> ^( PRINT[$PRINT, actions.castExpr($t2.elts.get(0)), actions.castExprs($t2.elts, 1), $t2.newline] ) | -> ^( PRINT[$PRINT, null, new ArrayList<expr>(), true] ) )
            int alt36=3;
            switch ( input.LA(1) ) {
            case NAME:
            case LAMBDA:
            case NOT:
            case LPAREN:
            case PLUS:
            case MINUS:
            case TILDE:
            case LBRACK:
            case LCURLY:
            case BACKQUOTE:
            case INT:
            case LONGINT:
            case FLOAT:
            case COMPLEX:
            case STRING:
                {
                alt36=1;
                }
                break;
            case RIGHTSHIFT:
                {
                alt36=2;
                }
                break;
            case NEWLINE:
            case SEMI:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:656:8: t1= printlist
                    {
                    pushFollow(FOLLOW_printlist_in_print_stmt2185);
                    t1=printlist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_printlist.add(t1.getTree());


                    // AST REWRITE
                    // elements: PRINT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 657:6: -> ^( PRINT[$PRINT, null, actions.castExprs($t1.elts), $t1.newline] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:657:9: ^( PRINT[$PRINT, null, actions.castExprs($t1.elts), $t1.newline] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Print(PRINT, PRINT82, null, actions.castExprs((t1!=null?t1.elts:null)), (t1!=null?t1.newline:false)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:658:9: RIGHTSHIFT t2= printlist2
                    {
                    RIGHTSHIFT83=(Token)match(input,RIGHTSHIFT,FOLLOW_RIGHTSHIFT_in_print_stmt2210); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RIGHTSHIFT.add(RIGHTSHIFT83);

                    pushFollow(FOLLOW_printlist2_in_print_stmt2214);
                    t2=printlist2();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_printlist2.add(t2.getTree());


                    // AST REWRITE
                    // elements: PRINT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 659:6: -> ^( PRINT[$PRINT, actions.castExpr($t2.elts.get(0)), actions.castExprs($t2.elts, 1), $t2.newline] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:659:9: ^( PRINT[$PRINT, actions.castExpr($t2.elts.get(0)), actions.castExprs($t2.elts, 1), $t2.newline] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Print(PRINT, PRINT82, actions.castExpr((t2!=null?t2.elts:null).get(0)), actions.castExprs((t2!=null?t2.elts:null), 1), (t2!=null?t2.newline:false)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:661:6: 
                    {

                    // AST REWRITE
                    // elements: PRINT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 661:6: -> ^( PRINT[$PRINT, null, new ArrayList<expr>(), true] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:661:9: ^( PRINT[$PRINT, null, new ArrayList<expr>(), true] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Print(PRINT, PRINT82, null, new ArrayList<expr>(), true), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "print_stmt"

    public static class printlist_return extends ParserRuleReturnScope {
        public boolean newline;
        public List elts;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "printlist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:666:1: printlist returns [boolean newline, List elts] : ( ( test[null] COMMA )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )? | t+= test[expr_contextType.Load] );
    public final PythonParser.printlist_return printlist() throws RecognitionException {
        PythonParser.printlist_return retval = new PythonParser.printlist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token trailcomma=null;
        Token COMMA84=null;
        List list_t=null;
        PythonParser.test_return t = null;
         t = null;
        PythonTree trailcomma_tree=null;
        PythonTree COMMA84_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:668:5: ( ( test[null] COMMA )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )? | t+= test[expr_contextType.Load] )
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:668:7: ( test[null] COMMA )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_test_in_printlist2306);
                    t=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if (list_t==null) list_t=new ArrayList();
                    list_t.add(t.getTree());

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:669:39: ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )*
                    loop37:
                    do {
                        int alt37=2;
                        alt37 = dfa37.predict(input);
                        switch (alt37) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:669:56: COMMA t+= test[expr_contextType.Load]
                    	    {
                    	    COMMA84=(Token)match(input,COMMA,FOLLOW_COMMA_in_printlist2318); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA84_tree = (PythonTree)adaptor.create(COMMA84);
                    	    adaptor.addChild(root_0, COMMA84_tree);
                    	    }
                    	    pushFollow(FOLLOW_test_in_printlist2322);
                    	    t=test(expr_contextType.Load);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    	    if (list_t==null) list_t=new ArrayList();
                    	    list_t.add(t.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:669:95: (trailcomma= COMMA )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==COMMA) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:669:96: trailcomma= COMMA
                            {
                            trailcomma=(Token)match(input,COMMA,FOLLOW_COMMA_in_printlist2330); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            trailcomma_tree = (PythonTree)adaptor.create(trailcomma);
                            adaptor.addChild(root_0, trailcomma_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                 retval.elts =list_t;
                                 if (trailcomma == null) {
                                     retval.newline = true;
                                 } else {
                                     retval.newline = false;
                                 }
                             
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:678:7: t+= test[expr_contextType.Load]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_test_in_printlist2351);
                    t=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if (list_t==null) list_t=new ArrayList();
                    list_t.add(t.getTree());

                    if ( state.backtracking==0 ) {

                                retval.elts =list_t;
                                retval.newline = true;
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "printlist"

    public static class printlist2_return extends ParserRuleReturnScope {
        public boolean newline;
        public List elts;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "printlist2"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:687:1: printlist2 returns [boolean newline, List elts] : ( ( test[null] COMMA test[null] )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )? | t+= test[expr_contextType.Load] );
    public final PythonParser.printlist2_return printlist2() throws RecognitionException {
        PythonParser.printlist2_return retval = new PythonParser.printlist2_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token trailcomma=null;
        Token COMMA85=null;
        List list_t=null;
        PythonParser.test_return t = null;
         t = null;
        PythonTree trailcomma_tree=null;
        PythonTree COMMA85_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:689:5: ( ( test[null] COMMA test[null] )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )? | t+= test[expr_contextType.Load] )
            int alt42=2;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:689:7: ( test[null] COMMA test[null] )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_test_in_printlist22408);
                    t=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if (list_t==null) list_t=new ArrayList();
                    list_t.add(t.getTree());

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:690:39: ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )*
                    loop40:
                    do {
                        int alt40=2;
                        alt40 = dfa40.predict(input);
                        switch (alt40) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:690:56: COMMA t+= test[expr_contextType.Load]
                    	    {
                    	    COMMA85=(Token)match(input,COMMA,FOLLOW_COMMA_in_printlist22420); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA85_tree = (PythonTree)adaptor.create(COMMA85);
                    	    adaptor.addChild(root_0, COMMA85_tree);
                    	    }
                    	    pushFollow(FOLLOW_test_in_printlist22424);
                    	    t=test(expr_contextType.Load);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    	    if (list_t==null) list_t=new ArrayList();
                    	    list_t.add(t.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:690:95: (trailcomma= COMMA )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==COMMA) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:690:96: trailcomma= COMMA
                            {
                            trailcomma=(Token)match(input,COMMA,FOLLOW_COMMA_in_printlist22432); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            trailcomma_tree = (PythonTree)adaptor.create(trailcomma);
                            adaptor.addChild(root_0, trailcomma_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {
                       retval.elts =list_t;
                                 if (trailcomma == null) {
                                     retval.newline = true;
                                 } else {
                                     retval.newline = false;
                                 }
                             
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:698:7: t+= test[expr_contextType.Load]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_test_in_printlist22453);
                    t=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if (list_t==null) list_t=new ArrayList();
                    list_t.add(t.getTree());

                    if ( state.backtracking==0 ) {

                                retval.elts =list_t;
                                retval.newline = true;
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "printlist2"

    public static class del_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "del_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:707:1: del_stmt : DELETE del_list -> ^( DELETE[$DELETE, $del_list.etypes] ) ;
    public final PythonParser.del_stmt_return del_stmt() throws RecognitionException {
        PythonParser.del_stmt_return retval = new PythonParser.del_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token DELETE86=null;
        PythonParser.del_list_return del_list87 = null;


        PythonTree DELETE86_tree=null;
        RewriteRuleTokenStream stream_DELETE=new RewriteRuleTokenStream(adaptor,"token DELETE");
        RewriteRuleSubtreeStream stream_del_list=new RewriteRuleSubtreeStream(adaptor,"rule del_list");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:708:5: ( DELETE del_list -> ^( DELETE[$DELETE, $del_list.etypes] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:708:7: DELETE del_list
            {
            DELETE86=(Token)match(input,DELETE,FOLLOW_DELETE_in_del_stmt2481); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DELETE.add(DELETE86);

            pushFollow(FOLLOW_del_list_in_del_stmt2483);
            del_list87=del_list();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_del_list.add(del_list87.getTree());


            // AST REWRITE
            // elements: DELETE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 709:4: -> ^( DELETE[$DELETE, $del_list.etypes] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:709:7: ^( DELETE[$DELETE, $del_list.etypes] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Delete(DELETE, DELETE86, (del_list87!=null?del_list87.etypes:null)), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "del_stmt"

    public static class pass_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pass_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:713:1: pass_stmt : PASS -> ^( PASS[$PASS] ) ;
    public final PythonParser.pass_stmt_return pass_stmt() throws RecognitionException {
        PythonParser.pass_stmt_return retval = new PythonParser.pass_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token PASS88=null;

        PythonTree PASS88_tree=null;
        RewriteRuleTokenStream stream_PASS=new RewriteRuleTokenStream(adaptor,"token PASS");

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:714:5: ( PASS -> ^( PASS[$PASS] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:714:7: PASS
            {
            PASS88=(Token)match(input,PASS,FOLLOW_PASS_in_pass_stmt2514); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PASS.add(PASS88);



            // AST REWRITE
            // elements: PASS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 715:4: -> ^( PASS[$PASS] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:715:7: ^( PASS[$PASS] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Pass(PASS, PASS88), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pass_stmt"

    public static class flow_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "flow_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:719:1: flow_stmt : ( break_stmt | continue_stmt | return_stmt | raise_stmt | yield_stmt );
    public final PythonParser.flow_stmt_return flow_stmt() throws RecognitionException {
        PythonParser.flow_stmt_return retval = new PythonParser.flow_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.break_stmt_return break_stmt89 = null;

        PythonParser.continue_stmt_return continue_stmt90 = null;

        PythonParser.return_stmt_return return_stmt91 = null;

        PythonParser.raise_stmt_return raise_stmt92 = null;

        PythonParser.yield_stmt_return yield_stmt93 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:720:5: ( break_stmt | continue_stmt | return_stmt | raise_stmt | yield_stmt )
            int alt43=5;
            switch ( input.LA(1) ) {
            case BREAK:
                {
                alt43=1;
                }
                break;
            case CONTINUE:
                {
                alt43=2;
                }
                break;
            case RETURN:
                {
                alt43=3;
                }
                break;
            case RAISE:
                {
                alt43=4;
                }
                break;
            case YIELD:
                {
                alt43=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:720:7: break_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_break_stmt_in_flow_stmt2545);
                    break_stmt89=break_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, break_stmt89.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:721:7: continue_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_continue_stmt_in_flow_stmt2553);
                    continue_stmt90=continue_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, continue_stmt90.getTree());

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:722:7: return_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_return_stmt_in_flow_stmt2561);
                    return_stmt91=return_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, return_stmt91.getTree());

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:723:7: raise_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_raise_stmt_in_flow_stmt2569);
                    raise_stmt92=raise_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, raise_stmt92.getTree());

                    }
                    break;
                case 5 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:724:7: yield_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_yield_stmt_in_flow_stmt2577);
                    yield_stmt93=yield_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, yield_stmt93.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "flow_stmt"

    public static class break_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "break_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:728:1: break_stmt : BREAK -> ^( BREAK[$BREAK] ) ;
    public final PythonParser.break_stmt_return break_stmt() throws RecognitionException {
        PythonParser.break_stmt_return retval = new PythonParser.break_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token BREAK94=null;

        PythonTree BREAK94_tree=null;
        RewriteRuleTokenStream stream_BREAK=new RewriteRuleTokenStream(adaptor,"token BREAK");

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:729:5: ( BREAK -> ^( BREAK[$BREAK] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:729:7: BREAK
            {
            BREAK94=(Token)match(input,BREAK,FOLLOW_BREAK_in_break_stmt2595); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_BREAK.add(BREAK94);



            // AST REWRITE
            // elements: BREAK
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 730:4: -> ^( BREAK[$BREAK] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:730:7: ^( BREAK[$BREAK] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Break(BREAK, BREAK94), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "break_stmt"

    public static class continue_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "continue_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:734:1: continue_stmt : CONTINUE -> ^( CONTINUE[$CONTINUE] ) ;
    public final PythonParser.continue_stmt_return continue_stmt() throws RecognitionException {
        PythonParser.continue_stmt_return retval = new PythonParser.continue_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token CONTINUE95=null;

        PythonTree CONTINUE95_tree=null;
        RewriteRuleTokenStream stream_CONTINUE=new RewriteRuleTokenStream(adaptor,"token CONTINUE");

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:735:5: ( CONTINUE -> ^( CONTINUE[$CONTINUE] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:735:7: CONTINUE
            {
            CONTINUE95=(Token)match(input,CONTINUE,FOLLOW_CONTINUE_in_continue_stmt2626); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONTINUE.add(CONTINUE95);

            if ( state.backtracking==0 ) {

                        if (!suite_stack.isEmpty() && ((suite_scope)suite_stack.peek()).continueIllegal) {
                            errorHandler.error("'continue' not supported inside 'finally' clause", new PythonTree(((Token)retval.start)));
                        }
                    
            }


            // AST REWRITE
            // elements: CONTINUE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 741:4: -> ^( CONTINUE[$CONTINUE] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:741:7: ^( CONTINUE[$CONTINUE] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Continue(CONTINUE, CONTINUE95), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "continue_stmt"

    public static class return_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "return_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:745:1: return_stmt : RETURN ( testlist[expr_contextType.Load] -> ^( RETURN[$RETURN, actions.castExpr($testlist.tree)] ) | -> ^( RETURN[$RETURN, null] ) ) ;
    public final PythonParser.return_stmt_return return_stmt() throws RecognitionException {
        PythonParser.return_stmt_return retval = new PythonParser.return_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token RETURN96=null;
        PythonParser.testlist_return testlist97 = null;


        PythonTree RETURN96_tree=null;
        RewriteRuleTokenStream stream_RETURN=new RewriteRuleTokenStream(adaptor,"token RETURN");
        RewriteRuleSubtreeStream stream_testlist=new RewriteRuleSubtreeStream(adaptor,"rule testlist");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:746:5: ( RETURN ( testlist[expr_contextType.Load] -> ^( RETURN[$RETURN, actions.castExpr($testlist.tree)] ) | -> ^( RETURN[$RETURN, null] ) ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:746:7: RETURN ( testlist[expr_contextType.Load] -> ^( RETURN[$RETURN, actions.castExpr($testlist.tree)] ) | -> ^( RETURN[$RETURN, null] ) )
            {
            RETURN96=(Token)match(input,RETURN,FOLLOW_RETURN_in_return_stmt2665); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RETURN.add(RETURN96);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:747:7: ( testlist[expr_contextType.Load] -> ^( RETURN[$RETURN, actions.castExpr($testlist.tree)] ) | -> ^( RETURN[$RETURN, null] ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==NAME||(LA44_0>=LAMBDA && LA44_0<=NOT)||LA44_0==LPAREN||(LA44_0>=PLUS && LA44_0<=MINUS)||(LA44_0>=TILDE && LA44_0<=LBRACK)||LA44_0==LCURLY||(LA44_0>=BACKQUOTE && LA44_0<=STRING)) ) {
                alt44=1;
            }
            else if ( (LA44_0==NEWLINE||LA44_0==SEMI) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:747:8: testlist[expr_contextType.Load]
                    {
                    pushFollow(FOLLOW_testlist_in_return_stmt2674);
                    testlist97=testlist(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_testlist.add(testlist97.getTree());


                    // AST REWRITE
                    // elements: RETURN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 748:6: -> ^( RETURN[$RETURN, actions.castExpr($testlist.tree)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:748:9: ^( RETURN[$RETURN, actions.castExpr($testlist.tree)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Return(RETURN, RETURN96, actions.castExpr((testlist97!=null?((PythonTree)testlist97.tree):null))), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:750:6: 
                    {

                    // AST REWRITE
                    // elements: RETURN
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 750:6: -> ^( RETURN[$RETURN, null] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:750:9: ^( RETURN[$RETURN, null] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Return(RETURN, RETURN96, null), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "return_stmt"

    public static class yield_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "yield_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:755:1: yield_stmt : yield_expr -> ^( YIELD[$yield_expr.start, actions.castExpr($yield_expr.tree)] ) ;
    public final PythonParser.yield_stmt_return yield_stmt() throws RecognitionException {
        PythonParser.yield_stmt_return retval = new PythonParser.yield_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.yield_expr_return yield_expr98 = null;


        RewriteRuleSubtreeStream stream_yield_expr=new RewriteRuleSubtreeStream(adaptor,"rule yield_expr");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:756:5: ( yield_expr -> ^( YIELD[$yield_expr.start, actions.castExpr($yield_expr.tree)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:756:7: yield_expr
            {
            pushFollow(FOLLOW_yield_expr_in_yield_stmt2741);
            yield_expr98=yield_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_yield_expr.add(yield_expr98.getTree());


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 757:4: -> ^( YIELD[$yield_expr.start, actions.castExpr($yield_expr.tree)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:757:7: ^( YIELD[$yield_expr.start, actions.castExpr($yield_expr.tree)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Expr(YIELD, (yield_expr98!=null?((Token)yield_expr98.start):null), actions.castExpr((yield_expr98!=null?((PythonTree)yield_expr98.tree):null))), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "yield_stmt"

    public static class raise_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "raise_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:761:1: raise_stmt : RAISE (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )? )? )? -> ^( RAISE[$RAISE, actions.castExpr($t1.tree), actions.castExpr($t2.tree), actions.castExpr($t3.tree)] ) ;
    public final PythonParser.raise_stmt_return raise_stmt() throws RecognitionException {
        PythonParser.raise_stmt_return retval = new PythonParser.raise_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token RAISE99=null;
        Token COMMA100=null;
        Token COMMA101=null;
        PythonParser.test_return t1 = null;

        PythonParser.test_return t2 = null;

        PythonParser.test_return t3 = null;


        PythonTree RAISE99_tree=null;
        PythonTree COMMA100_tree=null;
        PythonTree COMMA101_tree=null;
        RewriteRuleTokenStream stream_RAISE=new RewriteRuleTokenStream(adaptor,"token RAISE");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:762:5: ( RAISE (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )? )? )? -> ^( RAISE[$RAISE, actions.castExpr($t1.tree), actions.castExpr($t2.tree), actions.castExpr($t3.tree)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:762:7: RAISE (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )? )? )?
            {
            RAISE99=(Token)match(input,RAISE,FOLLOW_RAISE_in_raise_stmt2772); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_RAISE.add(RAISE99);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:762:13: (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )? )? )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==NAME||(LA47_0>=LAMBDA && LA47_0<=NOT)||LA47_0==LPAREN||(LA47_0>=PLUS && LA47_0<=MINUS)||(LA47_0>=TILDE && LA47_0<=LBRACK)||LA47_0==LCURLY||(LA47_0>=BACKQUOTE && LA47_0<=STRING)) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:762:14: t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )? )?
                    {
                    pushFollow(FOLLOW_test_in_raise_stmt2777);
                    t1=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(t1.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:762:45: ( COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )? )?
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( (LA46_0==COMMA) ) {
                        alt46=1;
                    }
                    switch (alt46) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:762:46: COMMA t2= test[expr_contextType.Load] ( COMMA t3= test[expr_contextType.Load] )?
                            {
                            COMMA100=(Token)match(input,COMMA,FOLLOW_COMMA_in_raise_stmt2781); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA100);

                            pushFollow(FOLLOW_test_in_raise_stmt2785);
                            t2=test(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_test.add(t2.getTree());
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:763:9: ( COMMA t3= test[expr_contextType.Load] )?
                            int alt45=2;
                            int LA45_0 = input.LA(1);

                            if ( (LA45_0==COMMA) ) {
                                alt45=1;
                            }
                            switch (alt45) {
                                case 1 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:763:10: COMMA t3= test[expr_contextType.Load]
                                    {
                                    COMMA101=(Token)match(input,COMMA,FOLLOW_COMMA_in_raise_stmt2797); if (state.failed) return retval; 
                                    if ( state.backtracking==0 ) stream_COMMA.add(COMMA101);

                                    pushFollow(FOLLOW_test_in_raise_stmt2801);
                                    t3=test(expr_contextType.Load);

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_test.add(t3.getTree());

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: RAISE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 764:4: -> ^( RAISE[$RAISE, actions.castExpr($t1.tree), actions.castExpr($t2.tree), actions.castExpr($t3.tree)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:764:7: ^( RAISE[$RAISE, actions.castExpr($t1.tree), actions.castExpr($t2.tree), actions.castExpr($t3.tree)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Raise(RAISE, RAISE99, actions.castExpr((t1!=null?((PythonTree)t1.tree):null)), actions.castExpr((t2!=null?((PythonTree)t2.tree):null)), actions.castExpr((t3!=null?((PythonTree)t3.tree):null))), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "raise_stmt"

    public static class import_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "import_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:768:1: import_stmt : ( import_name | import_from );
    public final PythonParser.import_stmt_return import_stmt() throws RecognitionException {
        PythonParser.import_stmt_return retval = new PythonParser.import_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.import_name_return import_name102 = null;

        PythonParser.import_from_return import_from103 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:769:5: ( import_name | import_from )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==IMPORT) ) {
                alt48=1;
            }
            else if ( (LA48_0==FROM) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:769:7: import_name
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_import_name_in_import_stmt2839);
                    import_name102=import_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, import_name102.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:770:7: import_from
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_import_from_in_import_stmt2847);
                    import_from103=import_from();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, import_from103.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "import_stmt"

    public static class import_name_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "import_name"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:774:1: import_name : IMPORT dotted_as_names -> ^( IMPORT[$IMPORT, $dotted_as_names.atypes] ) ;
    public final PythonParser.import_name_return import_name() throws RecognitionException {
        PythonParser.import_name_return retval = new PythonParser.import_name_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token IMPORT104=null;
        PythonParser.dotted_as_names_return dotted_as_names105 = null;


        PythonTree IMPORT104_tree=null;
        RewriteRuleTokenStream stream_IMPORT=new RewriteRuleTokenStream(adaptor,"token IMPORT");
        RewriteRuleSubtreeStream stream_dotted_as_names=new RewriteRuleSubtreeStream(adaptor,"rule dotted_as_names");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:775:5: ( IMPORT dotted_as_names -> ^( IMPORT[$IMPORT, $dotted_as_names.atypes] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:775:7: IMPORT dotted_as_names
            {
            IMPORT104=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_import_name2865); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IMPORT.add(IMPORT104);

            pushFollow(FOLLOW_dotted_as_names_in_import_name2867);
            dotted_as_names105=dotted_as_names();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_dotted_as_names.add(dotted_as_names105.getTree());


            // AST REWRITE
            // elements: IMPORT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 776:4: -> ^( IMPORT[$IMPORT, $dotted_as_names.atypes] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:776:7: ^( IMPORT[$IMPORT, $dotted_as_names.atypes] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Import(IMPORT, IMPORT104, (dotted_as_names105!=null?dotted_as_names105.atypes:null)), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "import_name"

    public static class import_from_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "import_from"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:781:1: import_from : FROM ( (d+= DOT )* dotted_name | (d+= DOT )+ ) IMPORT ( STAR -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeStarAlias($STAR), actions.makeLevel($d)] ) | i1= import_as_names -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i1.atypes), actions.makeLevel($d)] ) | LPAREN i2= import_as_names ( COMMA )? RPAREN -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i2.atypes), actions.makeLevel($d)] ) ) ;
    public final PythonParser.import_from_return import_from() throws RecognitionException {
        PythonParser.import_from_return retval = new PythonParser.import_from_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token FROM106=null;
        Token IMPORT108=null;
        Token STAR109=null;
        Token LPAREN110=null;
        Token COMMA111=null;
        Token RPAREN112=null;
        Token d=null;
        List list_d=null;
        PythonParser.import_as_names_return i1 = null;

        PythonParser.import_as_names_return i2 = null;

        PythonParser.dotted_name_return dotted_name107 = null;


        PythonTree FROM106_tree=null;
        PythonTree IMPORT108_tree=null;
        PythonTree STAR109_tree=null;
        PythonTree LPAREN110_tree=null;
        PythonTree COMMA111_tree=null;
        PythonTree RPAREN112_tree=null;
        PythonTree d_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IMPORT=new RewriteRuleTokenStream(adaptor,"token IMPORT");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_import_as_names=new RewriteRuleSubtreeStream(adaptor,"rule import_as_names");
        RewriteRuleSubtreeStream stream_dotted_name=new RewriteRuleSubtreeStream(adaptor,"rule dotted_name");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:5: ( FROM ( (d+= DOT )* dotted_name | (d+= DOT )+ ) IMPORT ( STAR -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeStarAlias($STAR), actions.makeLevel($d)] ) | i1= import_as_names -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i1.atypes), actions.makeLevel($d)] ) | LPAREN i2= import_as_names ( COMMA )? RPAREN -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i2.atypes), actions.makeLevel($d)] ) ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:7: FROM ( (d+= DOT )* dotted_name | (d+= DOT )+ ) IMPORT ( STAR -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeStarAlias($STAR), actions.makeLevel($d)] ) | i1= import_as_names -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i1.atypes), actions.makeLevel($d)] ) | LPAREN i2= import_as_names ( COMMA )? RPAREN -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i2.atypes), actions.makeLevel($d)] ) )
            {
            FROM106=(Token)match(input,FROM,FOLLOW_FROM_in_import_from2899); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FROM.add(FROM106);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:12: ( (d+= DOT )* dotted_name | (d+= DOT )+ )
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:13: (d+= DOT )* dotted_name
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:14: (d+= DOT )*
                    loop49:
                    do {
                        int alt49=2;
                        int LA49_0 = input.LA(1);

                        if ( (LA49_0==DOT) ) {
                            alt49=1;
                        }


                        switch (alt49) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:14: d+= DOT
                    	    {
                    	    d=(Token)match(input,DOT,FOLLOW_DOT_in_import_from2904); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_DOT.add(d);

                    	    if (list_d==null) list_d=new ArrayList();
                    	    list_d.add(d);


                    	    }
                    	    break;

                    	default :
                    	    break loop49;
                        }
                    } while (true);

                    pushFollow(FOLLOW_dotted_name_in_import_from2907);
                    dotted_name107=dotted_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_dotted_name.add(dotted_name107.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:35: (d+= DOT )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:36: (d+= DOT )+
                    int cnt50=0;
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==DOT) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:782:36: d+= DOT
                    	    {
                    	    d=(Token)match(input,DOT,FOLLOW_DOT_in_import_from2913); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_DOT.add(d);

                    	    if (list_d==null) list_d=new ArrayList();
                    	    list_d.add(d);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt50 >= 1 ) break loop50;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(50, input);
                                throw eee;
                        }
                        cnt50++;
                    } while (true);


                    }
                    break;

            }

            IMPORT108=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_import_from2917); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IMPORT.add(IMPORT108);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:783:9: ( STAR -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeStarAlias($STAR), actions.makeLevel($d)] ) | i1= import_as_names -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i1.atypes), actions.makeLevel($d)] ) | LPAREN i2= import_as_names ( COMMA )? RPAREN -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i2.atypes), actions.makeLevel($d)] ) )
            int alt53=3;
            switch ( input.LA(1) ) {
            case STAR:
                {
                alt53=1;
                }
                break;
            case NAME:
                {
                alt53=2;
                }
                break;
            case LPAREN:
                {
                alt53=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:783:10: STAR
                    {
                    STAR109=(Token)match(input,STAR,FOLLOW_STAR_in_import_from2928); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_STAR.add(STAR109);



                    // AST REWRITE
                    // elements: FROM
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 784:8: -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeStarAlias($STAR), actions.makeLevel($d)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:784:11: ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeStarAlias($STAR), actions.makeLevel($d)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new ImportFrom(FROM, FROM106, actions.makeFromText(list_d, (dotted_name107!=null?dotted_name107.name:null)), actions.makeStarAlias(STAR109), actions.makeLevel(list_d)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:786:11: i1= import_as_names
                    {
                    pushFollow(FOLLOW_import_as_names_in_import_from2959);
                    i1=import_as_names();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_import_as_names.add(i1.getTree());


                    // AST REWRITE
                    // elements: FROM
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 787:8: -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i1.atypes), actions.makeLevel($d)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:787:11: ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i1.atypes), actions.makeLevel($d)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new ImportFrom(FROM, FROM106, actions.makeFromText(list_d, (dotted_name107!=null?dotted_name107.name:null)), actions.makeAliases((i1!=null?i1.atypes:null)), actions.makeLevel(list_d)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:789:11: LPAREN i2= import_as_names ( COMMA )? RPAREN
                    {
                    LPAREN110=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_import_from2988); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN110);

                    pushFollow(FOLLOW_import_as_names_in_import_from2992);
                    i2=import_as_names();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_import_as_names.add(i2.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:789:37: ( COMMA )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==COMMA) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:789:37: COMMA
                            {
                            COMMA111=(Token)match(input,COMMA,FOLLOW_COMMA_in_import_from2994); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA111);


                            }
                            break;

                    }

                    RPAREN112=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_import_from2997); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN112);



                    // AST REWRITE
                    // elements: FROM
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 790:8: -> ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i2.atypes), actions.makeLevel($d)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:790:11: ^( FROM[$FROM, actions.makeFromText($d, $dotted_name.name),\n actions.makeAliases($i2.atypes), actions.makeLevel($d)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new ImportFrom(FROM, FROM106, actions.makeFromText(list_d, (dotted_name107!=null?dotted_name107.name:null)), actions.makeAliases((i2!=null?i2.atypes:null)), actions.makeLevel(list_d)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "import_from"

    public static class import_as_names_return extends ParserRuleReturnScope {
        public List<alias> atypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "import_as_names"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:796:1: import_as_names returns [List<alias> atypes] : n+= import_as_name ( COMMA n+= import_as_name )* ;
    public final PythonParser.import_as_names_return import_as_names() throws RecognitionException {
        PythonParser.import_as_names_return retval = new PythonParser.import_as_names_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA113=null;
        List list_n=null;
        PythonParser.import_as_name_return n = null;
         n = null;
        PythonTree COMMA113_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:798:5: (n+= import_as_name ( COMMA n+= import_as_name )* )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:798:7: n+= import_as_name ( COMMA n+= import_as_name )*
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_import_as_name_in_import_as_names3052);
            n=import_as_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, n.getTree());
            if (list_n==null) list_n=new ArrayList();
            list_n.add(n.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:798:25: ( COMMA n+= import_as_name )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==COMMA) ) {
                    int LA54_2 = input.LA(2);

                    if ( (LA54_2==NAME) ) {
                        alt54=1;
                    }


                }


                switch (alt54) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:798:26: COMMA n+= import_as_name
            	    {
            	    COMMA113=(Token)match(input,COMMA,FOLLOW_COMMA_in_import_as_names3055); if (state.failed) return retval;
            	    pushFollow(FOLLOW_import_as_name_in_import_as_names3060);
            	    n=import_as_name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, n.getTree());
            	    if (list_n==null) list_n=new ArrayList();
            	    list_n.add(n.getTree());


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            if ( state.backtracking==0 ) {

                      retval.atypes = list_n;
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "import_as_names"

    public static class import_as_name_return extends ParserRuleReturnScope {
        public alias atype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "import_as_name"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:805:1: import_as_name returns [alias atype] : name= NAME ( AS asname= NAME )? ;
    public final PythonParser.import_as_name_return import_as_name() throws RecognitionException {
        PythonParser.import_as_name_return retval = new PythonParser.import_as_name_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token name=null;
        Token asname=null;
        Token AS114=null;

        PythonTree name_tree=null;
        PythonTree asname_tree=null;
        PythonTree AS114_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:810:5: (name= NAME ( AS asname= NAME )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:810:7: name= NAME ( AS asname= NAME )?
            {
            root_0 = (PythonTree)adaptor.nil();

            name=(Token)match(input,NAME,FOLLOW_NAME_in_import_as_name3101); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            name_tree = (PythonTree)adaptor.create(name);
            adaptor.addChild(root_0, name_tree);
            }
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:810:17: ( AS asname= NAME )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==AS) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:810:18: AS asname= NAME
                    {
                    AS114=(Token)match(input,AS,FOLLOW_AS_in_import_as_name3104); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS114_tree = (PythonTree)adaptor.create(AS114);
                    adaptor.addChild(root_0, AS114_tree);
                    }
                    asname=(Token)match(input,NAME,FOLLOW_NAME_in_import_as_name3108); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    asname_tree = (PythonTree)adaptor.create(asname);
                    adaptor.addChild(root_0, asname_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      retval.atype = new alias(name, (name!=null?name.getText():null), (asname!=null?asname.getText():null));
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = retval.atype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "import_as_name"

    public static class dotted_as_name_return extends ParserRuleReturnScope {
        public alias atype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dotted_as_name"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:818:1: dotted_as_name returns [alias atype] : dotted_name ( AS NAME )? ;
    public final PythonParser.dotted_as_name_return dotted_as_name() throws RecognitionException {
        PythonParser.dotted_as_name_return retval = new PythonParser.dotted_as_name_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token AS116=null;
        Token NAME117=null;
        PythonParser.dotted_name_return dotted_name115 = null;


        PythonTree AS116_tree=null;
        PythonTree NAME117_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:824:5: ( dotted_name ( AS NAME )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:824:7: dotted_name ( AS NAME )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_dotted_name_in_dotted_as_name3149);
            dotted_name115=dotted_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, dotted_name115.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:824:19: ( AS NAME )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==AS) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:824:20: AS NAME
                    {
                    AS116=(Token)match(input,AS,FOLLOW_AS_in_dotted_as_name3152); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    AS116_tree = (PythonTree)adaptor.create(AS116);
                    adaptor.addChild(root_0, AS116_tree);
                    }
                    NAME117=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_as_name3154); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NAME117_tree = (PythonTree)adaptor.create(NAME117);
                    adaptor.addChild(root_0, NAME117_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      retval.atype = new alias(NAME117, (dotted_name115!=null?dotted_name115.name:null), (NAME117!=null?NAME117.getText():null));
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = retval.atype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dotted_as_name"

    public static class dotted_as_names_return extends ParserRuleReturnScope {
        public List<alias> atypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dotted_as_names"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:831:1: dotted_as_names returns [List<alias> atypes] : d+= dotted_as_name ( COMMA d+= dotted_as_name )* ;
    public final PythonParser.dotted_as_names_return dotted_as_names() throws RecognitionException {
        PythonParser.dotted_as_names_return retval = new PythonParser.dotted_as_names_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA118=null;
        List list_d=null;
        PythonParser.dotted_as_name_return d = null;
         d = null;
        PythonTree COMMA118_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:833:5: (d+= dotted_as_name ( COMMA d+= dotted_as_name )* )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:833:7: d+= dotted_as_name ( COMMA d+= dotted_as_name )*
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_dotted_as_name_in_dotted_as_names3190);
            d=dotted_as_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            if (list_d==null) list_d=new ArrayList();
            list_d.add(d.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:833:25: ( COMMA d+= dotted_as_name )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==COMMA) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:833:26: COMMA d+= dotted_as_name
            	    {
            	    COMMA118=(Token)match(input,COMMA,FOLLOW_COMMA_in_dotted_as_names3193); if (state.failed) return retval;
            	    pushFollow(FOLLOW_dotted_as_name_in_dotted_as_names3198);
            	    d=dotted_as_name();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());
            	    if (list_d==null) list_d=new ArrayList();
            	    list_d.add(d.getTree());


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            if ( state.backtracking==0 ) {

                      retval.atypes = list_d;
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dotted_as_names"

    public static class dotted_name_return extends ParserRuleReturnScope {
        public String name;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dotted_name"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:840:1: dotted_name returns [String name] : NAME ( DOT dn+= attr )* ;
    public final PythonParser.dotted_name_return dotted_name() throws RecognitionException {
        PythonParser.dotted_name_return retval = new PythonParser.dotted_name_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token NAME119=null;
        Token DOT120=null;
        List list_dn=null;
        PythonParser.attr_return dn = null;
         dn = null;
        PythonTree NAME119_tree=null;
        PythonTree DOT120_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:842:5: ( NAME ( DOT dn+= attr )* )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:842:7: NAME ( DOT dn+= attr )*
            {
            root_0 = (PythonTree)adaptor.nil();

            NAME119=(Token)match(input,NAME,FOLLOW_NAME_in_dotted_name3232); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME119_tree = (PythonTree)adaptor.create(NAME119);
            adaptor.addChild(root_0, NAME119_tree);
            }
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:842:12: ( DOT dn+= attr )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==DOT) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:842:13: DOT dn+= attr
            	    {
            	    DOT120=(Token)match(input,DOT,FOLLOW_DOT_in_dotted_name3235); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DOT120_tree = (PythonTree)adaptor.create(DOT120);
            	    adaptor.addChild(root_0, DOT120_tree);
            	    }
            	    pushFollow(FOLLOW_attr_in_dotted_name3239);
            	    dn=attr();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, dn.getTree());
            	    if (list_dn==null) list_dn=new ArrayList();
            	    list_dn.add(dn.getTree());


            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            if ( state.backtracking==0 ) {

                      retval.name = actions.makeDottedText(NAME119, list_dn);
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dotted_name"

    public static class global_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "global_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:849:1: global_stmt : GLOBAL n+= NAME ( COMMA n+= NAME )* -> ^( GLOBAL[$GLOBAL, actions.makeNames($n)] ) ;
    public final PythonParser.global_stmt_return global_stmt() throws RecognitionException {
        PythonParser.global_stmt_return retval = new PythonParser.global_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token GLOBAL121=null;
        Token COMMA122=null;
        Token n=null;
        List list_n=null;

        PythonTree GLOBAL121_tree=null;
        PythonTree COMMA122_tree=null;
        PythonTree n_tree=null;
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_GLOBAL=new RewriteRuleTokenStream(adaptor,"token GLOBAL");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:850:5: ( GLOBAL n+= NAME ( COMMA n+= NAME )* -> ^( GLOBAL[$GLOBAL, actions.makeNames($n)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:850:7: GLOBAL n+= NAME ( COMMA n+= NAME )*
            {
            GLOBAL121=(Token)match(input,GLOBAL,FOLLOW_GLOBAL_in_global_stmt3265); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_GLOBAL.add(GLOBAL121);

            n=(Token)match(input,NAME,FOLLOW_NAME_in_global_stmt3269); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NAME.add(n);

            if (list_n==null) list_n=new ArrayList();
            list_n.add(n);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:850:22: ( COMMA n+= NAME )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==COMMA) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:850:23: COMMA n+= NAME
            	    {
            	    COMMA122=(Token)match(input,COMMA,FOLLOW_COMMA_in_global_stmt3272); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA122);

            	    n=(Token)match(input,NAME,FOLLOW_NAME_in_global_stmt3276); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_NAME.add(n);

            	    if (list_n==null) list_n=new ArrayList();
            	    list_n.add(n);


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);



            // AST REWRITE
            // elements: GLOBAL
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 851:4: -> ^( GLOBAL[$GLOBAL, actions.makeNames($n)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:851:7: ^( GLOBAL[$GLOBAL, actions.makeNames($n)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Global(GLOBAL, GLOBAL121, actions.makeNames(list_n)), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "global_stmt"

    public static class exec_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exec_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:855:1: exec_stmt : EXEC expr[expr_contextType.Load] ( IN t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? )? ;
    public final PythonParser.exec_stmt_return exec_stmt() throws RecognitionException {
        PythonParser.exec_stmt_return retval = new PythonParser.exec_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token EXEC123=null;
        Token IN125=null;
        Token COMMA126=null;
        PythonParser.test_return t1 = null;

        PythonParser.test_return t2 = null;

        PythonParser.expr_return expr124 = null;


        PythonTree EXEC123_tree=null;
        PythonTree IN125_tree=null;
        PythonTree COMMA126_tree=null;


            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:862:5: ( EXEC expr[expr_contextType.Load] ( IN t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:862:7: EXEC expr[expr_contextType.Load] ( IN t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? )?
            {
            root_0 = (PythonTree)adaptor.nil();

            EXEC123=(Token)match(input,EXEC,FOLLOW_EXEC_in_exec_stmt3319); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EXEC123_tree = (PythonTree)adaptor.create(EXEC123);
            adaptor.addChild(root_0, EXEC123_tree);
            }
            pushFollow(FOLLOW_expr_in_exec_stmt3321);
            expr124=expr(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr124.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:862:40: ( IN t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==IN) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:862:41: IN t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )?
                    {
                    IN125=(Token)match(input,IN,FOLLOW_IN_in_exec_stmt3325); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN125_tree = (PythonTree)adaptor.create(IN125);
                    adaptor.addChild(root_0, IN125_tree);
                    }
                    pushFollow(FOLLOW_test_in_exec_stmt3329);
                    t1=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:862:75: ( COMMA t2= test[expr_contextType.Load] )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==COMMA) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:862:76: COMMA t2= test[expr_contextType.Load]
                            {
                            COMMA126=(Token)match(input,COMMA,FOLLOW_COMMA_in_exec_stmt3333); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA126_tree = (PythonTree)adaptor.create(COMMA126);
                            adaptor.addChild(root_0, COMMA126_tree);
                            }
                            pushFollow(FOLLOW_test_in_exec_stmt3337);
                            t2=test(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, t2.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                       stype = new Exec(EXEC123, actions.castExpr((expr124!=null?((PythonTree)expr124.tree):null)), actions.castExpr((t1!=null?((PythonTree)t1.tree):null)), actions.castExpr((t2!=null?((PythonTree)t2.tree):null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = stype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exec_stmt"

    public static class assert_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assert_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:869:1: assert_stmt : ASSERT t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? -> ^( ASSERT[$ASSERT, actions.castExpr($t1.tree), actions.castExpr($t2.tree)] ) ;
    public final PythonParser.assert_stmt_return assert_stmt() throws RecognitionException {
        PythonParser.assert_stmt_return retval = new PythonParser.assert_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token ASSERT127=null;
        Token COMMA128=null;
        PythonParser.test_return t1 = null;

        PythonParser.test_return t2 = null;


        PythonTree ASSERT127_tree=null;
        PythonTree COMMA128_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_ASSERT=new RewriteRuleTokenStream(adaptor,"token ASSERT");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:870:5: ( ASSERT t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )? -> ^( ASSERT[$ASSERT, actions.castExpr($t1.tree), actions.castExpr($t2.tree)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:870:7: ASSERT t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Load] )?
            {
            ASSERT127=(Token)match(input,ASSERT,FOLLOW_ASSERT_in_assert_stmt3368); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSERT.add(ASSERT127);

            pushFollow(FOLLOW_test_in_assert_stmt3372);
            t1=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_test.add(t1.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:870:45: ( COMMA t2= test[expr_contextType.Load] )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==COMMA) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:870:46: COMMA t2= test[expr_contextType.Load]
                    {
                    COMMA128=(Token)match(input,COMMA,FOLLOW_COMMA_in_assert_stmt3376); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMMA.add(COMMA128);

                    pushFollow(FOLLOW_test_in_assert_stmt3380);
                    t2=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(t2.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: ASSERT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 871:4: -> ^( ASSERT[$ASSERT, actions.castExpr($t1.tree), actions.castExpr($t2.tree)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:871:7: ^( ASSERT[$ASSERT, actions.castExpr($t1.tree), actions.castExpr($t2.tree)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Assert(ASSERT, ASSERT127, actions.castExpr((t1!=null?((PythonTree)t1.tree):null)), actions.castExpr((t2!=null?((PythonTree)t2.tree):null))), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assert_stmt"

    public static class compound_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "compound_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:875:1: compound_stmt : ( if_stmt | while_stmt | for_stmt | try_stmt | with_stmt | ( ( decorators )? DEF )=> funcdef | classdef );
    public final PythonParser.compound_stmt_return compound_stmt() throws RecognitionException {
        PythonParser.compound_stmt_return retval = new PythonParser.compound_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.if_stmt_return if_stmt129 = null;

        PythonParser.while_stmt_return while_stmt130 = null;

        PythonParser.for_stmt_return for_stmt131 = null;

        PythonParser.try_stmt_return try_stmt132 = null;

        PythonParser.with_stmt_return with_stmt133 = null;

        PythonParser.funcdef_return funcdef134 = null;

        PythonParser.classdef_return classdef135 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:876:5: ( if_stmt | while_stmt | for_stmt | try_stmt | with_stmt | ( ( decorators )? DEF )=> funcdef | classdef )
            int alt63=7;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==IF) ) {
                alt63=1;
            }
            else if ( (LA63_0==WHILE) ) {
                alt63=2;
            }
            else if ( (LA63_0==FOR) ) {
                alt63=3;
            }
            else if ( (LA63_0==TRY) ) {
                alt63=4;
            }
            else if ( (LA63_0==WITH) ) {
                alt63=5;
            }
            else if ( (LA63_0==AT) ) {
                int LA63_6 = input.LA(2);

                if ( (synpred6_Python()) ) {
                    alt63=6;
                }
                else if ( (true) ) {
                    alt63=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 6, input);

                    throw nvae;
                }
            }
            else if ( (LA63_0==DEF) && (synpred6_Python())) {
                alt63=6;
            }
            else if ( (LA63_0==CLASS) ) {
                alt63=7;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:876:7: if_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_if_stmt_in_compound_stmt3414);
                    if_stmt129=if_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, if_stmt129.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:877:7: while_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_while_stmt_in_compound_stmt3422);
                    while_stmt130=while_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, while_stmt130.getTree());

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:878:7: for_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_for_stmt_in_compound_stmt3430);
                    for_stmt131=for_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, for_stmt131.getTree());

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:879:7: try_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_try_stmt_in_compound_stmt3438);
                    try_stmt132=try_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, try_stmt132.getTree());

                    }
                    break;
                case 5 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:880:7: with_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_with_stmt_in_compound_stmt3446);
                    with_stmt133=with_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, with_stmt133.getTree());

                    }
                    break;
                case 6 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:881:7: ( ( decorators )? DEF )=> funcdef
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_funcdef_in_compound_stmt3463);
                    funcdef134=funcdef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, funcdef134.getTree());

                    }
                    break;
                case 7 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:882:7: classdef
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_classdef_in_compound_stmt3471);
                    classdef135=classdef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, classdef135.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "compound_stmt"

    public static class if_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "if_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:886:1: if_stmt : IF test[expr_contextType.Load] COLON ifsuite= suite[false] ( elif_clause[$test.start] )? -> ^( IF[$IF, actions.castExpr($test.tree), actions.castStmts($ifsuite.stypes),\n actions.makeElse($elif_clause.stypes, $elif_clause.tree)] ) ;
    public final PythonParser.if_stmt_return if_stmt() throws RecognitionException {
        PythonParser.if_stmt_return retval = new PythonParser.if_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token IF136=null;
        Token COLON138=null;
        PythonParser.suite_return ifsuite = null;

        PythonParser.test_return test137 = null;

        PythonParser.elif_clause_return elif_clause139 = null;


        PythonTree IF136_tree=null;
        PythonTree COLON138_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_elif_clause=new RewriteRuleSubtreeStream(adaptor,"rule elif_clause");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        RewriteRuleSubtreeStream stream_suite=new RewriteRuleSubtreeStream(adaptor,"rule suite");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:887:5: ( IF test[expr_contextType.Load] COLON ifsuite= suite[false] ( elif_clause[$test.start] )? -> ^( IF[$IF, actions.castExpr($test.tree), actions.castStmts($ifsuite.stypes),\n actions.makeElse($elif_clause.stypes, $elif_clause.tree)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:887:7: IF test[expr_contextType.Load] COLON ifsuite= suite[false] ( elif_clause[$test.start] )?
            {
            IF136=(Token)match(input,IF,FOLLOW_IF_in_if_stmt3489); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IF.add(IF136);

            pushFollow(FOLLOW_test_in_if_stmt3491);
            test137=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_test.add(test137.getTree());
            COLON138=(Token)match(input,COLON,FOLLOW_COLON_in_if_stmt3494); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON138);

            pushFollow(FOLLOW_suite_in_if_stmt3498);
            ifsuite=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_suite.add(ifsuite.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:887:65: ( elif_clause[$test.start] )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==ELIF||LA64_0==ORELSE) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:887:65: elif_clause[$test.start]
                    {
                    pushFollow(FOLLOW_elif_clause_in_if_stmt3501);
                    elif_clause139=elif_clause((test137!=null?((Token)test137.start):null));

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_elif_clause.add(elif_clause139.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: IF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 888:4: -> ^( IF[$IF, actions.castExpr($test.tree), actions.castStmts($ifsuite.stypes),\n actions.makeElse($elif_clause.stypes, $elif_clause.tree)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:888:7: ^( IF[$IF, actions.castExpr($test.tree), actions.castStmts($ifsuite.stypes),\n actions.makeElse($elif_clause.stypes, $elif_clause.tree)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new If(IF, IF136, actions.castExpr((test137!=null?((PythonTree)test137.tree):null)), actions.castStmts((ifsuite!=null?ifsuite.stypes:null)), actions.makeElse((elif_clause139!=null?elif_clause139.stypes:null), (elif_clause139!=null?((PythonTree)elif_clause139.tree):null))), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_stmt"

    public static class elif_clause_return extends ParserRuleReturnScope {
        public List stypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elif_clause"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:893:1: elif_clause[Token iftest] returns [List stypes] : ( else_clause | ELIF test[expr_contextType.Load] COLON suite[false] (e2= elif_clause[$iftest] -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), actions.makeElse($e2.stypes, $e2.tree)] ) | -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), new ArrayList<stmt>()] ) ) );
    public final PythonParser.elif_clause_return elif_clause(Token iftest) throws RecognitionException {
        PythonParser.elif_clause_return retval = new PythonParser.elif_clause_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token ELIF141=null;
        Token COLON143=null;
        PythonParser.elif_clause_return e2 = null;

        PythonParser.else_clause_return else_clause140 = null;

        PythonParser.test_return test142 = null;

        PythonParser.suite_return suite144 = null;


        PythonTree ELIF141_tree=null;
        PythonTree COLON143_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_ELIF=new RewriteRuleTokenStream(adaptor,"token ELIF");
        RewriteRuleSubtreeStream stream_elif_clause=new RewriteRuleSubtreeStream(adaptor,"rule elif_clause");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        RewriteRuleSubtreeStream stream_suite=new RewriteRuleSubtreeStream(adaptor,"rule suite");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:895:5: ( else_clause | ELIF test[expr_contextType.Load] COLON suite[false] (e2= elif_clause[$iftest] -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), actions.makeElse($e2.stypes, $e2.tree)] ) | -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), new ArrayList<stmt>()] ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==ORELSE) ) {
                alt66=1;
            }
            else if ( (LA66_0==ELIF) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:895:7: else_clause
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_else_clause_in_elif_clause3544);
                    else_clause140=else_clause();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, else_clause140.getTree());
                    if ( state.backtracking==0 ) {

                                retval.stypes = (else_clause140!=null?else_clause140.stypes:null);
                            
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:899:7: ELIF test[expr_contextType.Load] COLON suite[false] (e2= elif_clause[$iftest] -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), actions.makeElse($e2.stypes, $e2.tree)] ) | -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), new ArrayList<stmt>()] ) )
                    {
                    ELIF141=(Token)match(input,ELIF,FOLLOW_ELIF_in_elif_clause3560); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ELIF.add(ELIF141);

                    pushFollow(FOLLOW_test_in_elif_clause3562);
                    test142=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(test142.getTree());
                    COLON143=(Token)match(input,COLON,FOLLOW_COLON_in_elif_clause3565); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLON.add(COLON143);

                    pushFollow(FOLLOW_suite_in_elif_clause3567);
                    suite144=suite(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_suite.add(suite144.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:900:9: (e2= elif_clause[$iftest] -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), actions.makeElse($e2.stypes, $e2.tree)] ) | -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), new ArrayList<stmt>()] ) )
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==ELIF||LA65_0==ORELSE) ) {
                        alt65=1;
                    }
                    else if ( (LA65_0==EOF||LA65_0==DEDENT||LA65_0==NEWLINE||LA65_0==NAME||(LA65_0>=ASSERT && LA65_0<=DELETE)||LA65_0==EXEC||(LA65_0>=FROM && LA65_0<=IMPORT)||(LA65_0>=LAMBDA && LA65_0<=NOT)||(LA65_0>=PASS && LA65_0<=LPAREN)||(LA65_0>=PLUS && LA65_0<=MINUS)||(LA65_0>=TILDE && LA65_0<=LBRACK)||LA65_0==LCURLY||(LA65_0>=BACKQUOTE && LA65_0<=STRING)) ) {
                        alt65=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 65, 0, input);

                        throw nvae;
                    }
                    switch (alt65) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:900:10: e2= elif_clause[$iftest]
                            {
                            pushFollow(FOLLOW_elif_clause_in_elif_clause3581);
                            e2=elif_clause(iftest);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_elif_clause.add(e2.getTree());


                            // AST REWRITE
                            // elements: ELIF
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 901:8: -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), actions.makeElse($e2.stypes, $e2.tree)] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:901:11: ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), actions.makeElse($e2.stypes, $e2.tree)] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new If(ELIF, iftest, actions.castExpr((test142!=null?((PythonTree)test142.tree):null)), actions.castStmts((suite144!=null?suite144.stypes:null)), actions.makeElse((e2!=null?e2.stypes:null), (e2!=null?((PythonTree)e2.tree):null))), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:903:8: 
                            {

                            // AST REWRITE
                            // elements: ELIF
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 903:8: -> ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), new ArrayList<stmt>()] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:903:11: ^( ELIF[$iftest, actions.castExpr($test.tree), actions.castStmts($suite.stypes), new ArrayList<stmt>()] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new If(ELIF, iftest, actions.castExpr((test142!=null?((PythonTree)test142.tree):null)), actions.castStmts((suite144!=null?suite144.stypes:null)), new ArrayList<stmt>()), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elif_clause"

    public static class else_clause_return extends ParserRuleReturnScope {
        public List stypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "else_clause"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:908:1: else_clause returns [List stypes] : ORELSE COLON elsesuite= suite[false] ;
    public final PythonParser.else_clause_return else_clause() throws RecognitionException {
        PythonParser.else_clause_return retval = new PythonParser.else_clause_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token ORELSE145=null;
        Token COLON146=null;
        PythonParser.suite_return elsesuite = null;


        PythonTree ORELSE145_tree=null;
        PythonTree COLON146_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:910:5: ( ORELSE COLON elsesuite= suite[false] )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:910:7: ORELSE COLON elsesuite= suite[false]
            {
            root_0 = (PythonTree)adaptor.nil();

            ORELSE145=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_else_clause3662); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ORELSE145_tree = (PythonTree)adaptor.create(ORELSE145);
            adaptor.addChild(root_0, ORELSE145_tree);
            }
            COLON146=(Token)match(input,COLON,FOLLOW_COLON_in_else_clause3664); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON146_tree = (PythonTree)adaptor.create(COLON146);
            adaptor.addChild(root_0, COLON146_tree);
            }
            pushFollow(FOLLOW_suite_in_else_clause3668);
            elsesuite=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, elsesuite.getTree());
            if ( state.backtracking==0 ) {

                        retval.stypes = (elsesuite!=null?elsesuite.stypes:null);
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "else_clause"

    public static class while_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "while_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:917:1: while_stmt : WHILE test[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? ;
    public final PythonParser.while_stmt_return while_stmt() throws RecognitionException {
        PythonParser.while_stmt_return retval = new PythonParser.while_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token WHILE147=null;
        Token COLON149=null;
        Token ORELSE150=null;
        Token COLON151=null;
        PythonParser.suite_return s1 = null;

        PythonParser.suite_return s2 = null;

        PythonParser.test_return test148 = null;


        PythonTree WHILE147_tree=null;
        PythonTree COLON149_tree=null;
        PythonTree ORELSE150_tree=null;
        PythonTree COLON151_tree=null;


            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:924:5: ( WHILE test[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:924:7: WHILE test[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            WHILE147=(Token)match(input,WHILE,FOLLOW_WHILE_in_while_stmt3705); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE147_tree = (PythonTree)adaptor.create(WHILE147);
            adaptor.addChild(root_0, WHILE147_tree);
            }
            pushFollow(FOLLOW_test_in_while_stmt3707);
            test148=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test148.getTree());
            COLON149=(Token)match(input,COLON,FOLLOW_COLON_in_while_stmt3710); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON149_tree = (PythonTree)adaptor.create(COLON149);
            adaptor.addChild(root_0, COLON149_tree);
            }
            pushFollow(FOLLOW_suite_in_while_stmt3714);
            s1=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, s1.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:924:63: ( ORELSE COLON s2= suite[false] )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==ORELSE) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:924:64: ORELSE COLON s2= suite[false]
                    {
                    ORELSE150=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_while_stmt3718); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORELSE150_tree = (PythonTree)adaptor.create(ORELSE150);
                    adaptor.addChild(root_0, ORELSE150_tree);
                    }
                    COLON151=(Token)match(input,COLON,FOLLOW_COLON_in_while_stmt3720); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON151_tree = (PythonTree)adaptor.create(COLON151);
                    adaptor.addChild(root_0, COLON151_tree);
                    }
                    pushFollow(FOLLOW_suite_in_while_stmt3724);
                    s2=suite(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, s2.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        stype = actions.makeWhile(WHILE147, actions.castExpr((test148!=null?((PythonTree)test148.tree):null)), (s1!=null?s1.stypes:null), (s2!=null?s2.stypes:null));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = stype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "while_stmt"

    public static class for_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "for_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:931:1: for_stmt : FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? ;
    public final PythonParser.for_stmt_return for_stmt() throws RecognitionException {
        PythonParser.for_stmt_return retval = new PythonParser.for_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token FOR152=null;
        Token IN154=null;
        Token COLON156=null;
        Token ORELSE157=null;
        Token COLON158=null;
        PythonParser.suite_return s1 = null;

        PythonParser.suite_return s2 = null;

        PythonParser.exprlist_return exprlist153 = null;

        PythonParser.testlist_return testlist155 = null;


        PythonTree FOR152_tree=null;
        PythonTree IN154_tree=null;
        PythonTree COLON156_tree=null;
        PythonTree ORELSE157_tree=null;
        PythonTree COLON158_tree=null;


            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:938:5: ( FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:938:7: FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] COLON s1= suite[false] ( ORELSE COLON s2= suite[false] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            FOR152=(Token)match(input,FOR,FOLLOW_FOR_in_for_stmt3763); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOR152_tree = (PythonTree)adaptor.create(FOR152);
            adaptor.addChild(root_0, FOR152_tree);
            }
            pushFollow(FOLLOW_exprlist_in_for_stmt3765);
            exprlist153=exprlist(expr_contextType.Store);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exprlist153.getTree());
            IN154=(Token)match(input,IN,FOLLOW_IN_in_for_stmt3768); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN154_tree = (PythonTree)adaptor.create(IN154);
            adaptor.addChild(root_0, IN154_tree);
            }
            pushFollow(FOLLOW_testlist_in_for_stmt3770);
            testlist155=testlist(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist155.getTree());
            COLON156=(Token)match(input,COLON,FOLLOW_COLON_in_for_stmt3773); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON156_tree = (PythonTree)adaptor.create(COLON156);
            adaptor.addChild(root_0, COLON156_tree);
            }
            pushFollow(FOLLOW_suite_in_for_stmt3777);
            s1=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, s1.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:939:9: ( ORELSE COLON s2= suite[false] )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==ORELSE) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:939:10: ORELSE COLON s2= suite[false]
                    {
                    ORELSE157=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_for_stmt3789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ORELSE157_tree = (PythonTree)adaptor.create(ORELSE157);
                    adaptor.addChild(root_0, ORELSE157_tree);
                    }
                    COLON158=(Token)match(input,COLON,FOLLOW_COLON_in_for_stmt3791); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON158_tree = (PythonTree)adaptor.create(COLON158);
                    adaptor.addChild(root_0, COLON158_tree);
                    }
                    pushFollow(FOLLOW_suite_in_for_stmt3795);
                    s2=suite(false);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, s2.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        stype = actions.makeFor(FOR152, (exprlist153!=null?exprlist153.etype:null), actions.castExpr((testlist155!=null?((PythonTree)testlist155.tree):null)), (s1!=null?s1.stypes:null), (s2!=null?s2.stypes:null));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = stype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "for_stmt"

    public static class try_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "try_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:950:1: try_stmt : TRY COLON trysuite= suite[!$suite.isEmpty() && $suite::continueIllegal] ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] ) ;
    public final PythonParser.try_stmt_return try_stmt() throws RecognitionException {
        PythonParser.try_stmt_return retval = new PythonParser.try_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token TRY159=null;
        Token COLON160=null;
        Token ORELSE161=null;
        Token COLON162=null;
        Token FINALLY163=null;
        Token COLON164=null;
        Token FINALLY165=null;
        Token COLON166=null;
        List list_e=null;
        PythonParser.suite_return trysuite = null;

        PythonParser.suite_return elsesuite = null;

        PythonParser.suite_return finalsuite = null;

        PythonParser.except_clause_return e = null;
         e = null;
        PythonTree TRY159_tree=null;
        PythonTree COLON160_tree=null;
        PythonTree ORELSE161_tree=null;
        PythonTree COLON162_tree=null;
        PythonTree FINALLY163_tree=null;
        PythonTree COLON164_tree=null;
        PythonTree FINALLY165_tree=null;
        PythonTree COLON166_tree=null;


            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:957:5: ( TRY COLON trysuite= suite[!$suite.isEmpty() && $suite::continueIllegal] ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:957:7: TRY COLON trysuite= suite[!$suite.isEmpty() && $suite::continueIllegal] ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] )
            {
            root_0 = (PythonTree)adaptor.nil();

            TRY159=(Token)match(input,TRY,FOLLOW_TRY_in_try_stmt3838); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            TRY159_tree = (PythonTree)adaptor.create(TRY159);
            adaptor.addChild(root_0, TRY159_tree);
            }
            COLON160=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt3840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON160_tree = (PythonTree)adaptor.create(COLON160);
            adaptor.addChild(root_0, COLON160_tree);
            }
            pushFollow(FOLLOW_suite_in_try_stmt3844);
            trysuite=suite(!suite_stack.isEmpty() && ((suite_scope)suite_stack.peek()).continueIllegal);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, trysuite.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:7: ( (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )? | FINALLY COLON finalsuite= suite[true] )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==EXCEPT) ) {
                alt72=1;
            }
            else if ( (LA72_0==FINALLY) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:9: (e+= except_clause )+ ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )? ( FINALLY COLON finalsuite= suite[true] )?
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:10: (e+= except_clause )+
                    int cnt69=0;
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==EXCEPT) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:10: e+= except_clause
                    	    {
                    	    pushFollow(FOLLOW_except_clause_in_try_stmt3857);
                    	    e=except_clause();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
                    	    if (list_e==null) list_e=new ArrayList();
                    	    list_e.add(e.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt69 >= 1 ) break loop69;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(69, input);
                                throw eee;
                        }
                        cnt69++;
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:27: ( ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal] )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==ORELSE) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:28: ORELSE COLON elsesuite= suite[!$suite.isEmpty() && $suite::continueIllegal]
                            {
                            ORELSE161=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_try_stmt3861); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ORELSE161_tree = (PythonTree)adaptor.create(ORELSE161);
                            adaptor.addChild(root_0, ORELSE161_tree);
                            }
                            COLON162=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt3863); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COLON162_tree = (PythonTree)adaptor.create(COLON162);
                            adaptor.addChild(root_0, COLON162_tree);
                            }
                            pushFollow(FOLLOW_suite_in_try_stmt3867);
                            elsesuite=suite(!suite_stack.isEmpty() && ((suite_scope)suite_stack.peek()).continueIllegal);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, elsesuite.getTree());

                            }
                            break;

                    }

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:105: ( FINALLY COLON finalsuite= suite[true] )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==FINALLY) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:958:106: FINALLY COLON finalsuite= suite[true]
                            {
                            FINALLY163=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_try_stmt3873); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            FINALLY163_tree = (PythonTree)adaptor.create(FINALLY163);
                            adaptor.addChild(root_0, FINALLY163_tree);
                            }
                            COLON164=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt3875); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COLON164_tree = (PythonTree)adaptor.create(COLON164);
                            adaptor.addChild(root_0, COLON164_tree);
                            }
                            pushFollow(FOLLOW_suite_in_try_stmt3879);
                            finalsuite=suite(true);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, finalsuite.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                  stype = actions.makeTryExcept(TRY159, (trysuite!=null?trysuite.stypes:null), list_e, (elsesuite!=null?elsesuite.stypes:null), (finalsuite!=null?finalsuite.stypes:null));
                              
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:962:9: FINALLY COLON finalsuite= suite[true]
                    {
                    FINALLY165=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_try_stmt3902); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FINALLY165_tree = (PythonTree)adaptor.create(FINALLY165);
                    adaptor.addChild(root_0, FINALLY165_tree);
                    }
                    COLON166=(Token)match(input,COLON,FOLLOW_COLON_in_try_stmt3904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON166_tree = (PythonTree)adaptor.create(COLON166);
                    adaptor.addChild(root_0, COLON166_tree);
                    }
                    pushFollow(FOLLOW_suite_in_try_stmt3908);
                    finalsuite=suite(true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, finalsuite.getTree());
                    if ( state.backtracking==0 ) {

                                  stype = actions.makeTryFinally(TRY159, (trysuite!=null?trysuite.stypes:null), (finalsuite!=null?finalsuite.stypes:null));
                              
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = stype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "try_stmt"

    public static class with_stmt_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "with_stmt"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:970:1: with_stmt : WITH test[expr_contextType.Load] ( with_var )? COLON suite[false] ;
    public final PythonParser.with_stmt_return with_stmt() throws RecognitionException {
        PythonParser.with_stmt_return retval = new PythonParser.with_stmt_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token WITH167=null;
        Token COLON170=null;
        PythonParser.test_return test168 = null;

        PythonParser.with_var_return with_var169 = null;

        PythonParser.suite_return suite171 = null;


        PythonTree WITH167_tree=null;
        PythonTree COLON170_tree=null;


            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:977:5: ( WITH test[expr_contextType.Load] ( with_var )? COLON suite[false] )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:977:7: WITH test[expr_contextType.Load] ( with_var )? COLON suite[false]
            {
            root_0 = (PythonTree)adaptor.nil();

            WITH167=(Token)match(input,WITH,FOLLOW_WITH_in_with_stmt3957); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WITH167_tree = (PythonTree)adaptor.create(WITH167);
            adaptor.addChild(root_0, WITH167_tree);
            }
            pushFollow(FOLLOW_test_in_with_stmt3959);
            test168=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test168.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:977:40: ( with_var )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==NAME||LA73_0==AS) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:977:41: with_var
                    {
                    pushFollow(FOLLOW_with_var_in_with_stmt3963);
                    with_var169=with_var();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, with_var169.getTree());

                    }
                    break;

            }

            COLON170=(Token)match(input,COLON,FOLLOW_COLON_in_with_stmt3967); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON170_tree = (PythonTree)adaptor.create(COLON170);
            adaptor.addChild(root_0, COLON170_tree);
            }
            pushFollow(FOLLOW_suite_in_with_stmt3969);
            suite171=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, suite171.getTree());
            if ( state.backtracking==0 ) {

                        stype = new With(WITH167, actions.castExpr((test168!=null?((PythonTree)test168.tree):null)), (with_var169!=null?with_var169.etype:null),
                            actions.castStmts((suite171!=null?suite171.stypes:null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = stype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "with_stmt"

    public static class with_var_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "with_var"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:985:1: with_var returns [expr etype] : ( AS | NAME ) expr[expr_contextType.Store] ;
    public final PythonParser.with_var_return with_var() throws RecognitionException {
        PythonParser.with_var_return retval = new PythonParser.with_var_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token set172=null;
        PythonParser.expr_return expr173 = null;


        PythonTree set172_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:987:5: ( ( AS | NAME ) expr[expr_contextType.Store] )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:987:7: ( AS | NAME ) expr[expr_contextType.Store]
            {
            root_0 = (PythonTree)adaptor.nil();

            set172=(Token)input.LT(1);
            if ( input.LA(1)==NAME||input.LA(1)==AS ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (PythonTree)adaptor.create(set172));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            pushFollow(FOLLOW_expr_in_with_var4012);
            expr173=expr(expr_contextType.Store);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, expr173.getTree());
            if ( state.backtracking==0 ) {

                        retval.etype = actions.castExpr((expr173!=null?((PythonTree)expr173.tree):null));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "with_var"

    public static class except_clause_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "except_clause"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:994:1: except_clause : EXCEPT (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Store] )? )? COLON suite[!$suite.isEmpty() && $suite::continueIllegal] -> ^( EXCEPT[$EXCEPT, actions.castExpr($t1.tree), actions.castExpr($t2.tree),\n actions.castStmts($suite.stypes)] ) ;
    public final PythonParser.except_clause_return except_clause() throws RecognitionException {
        PythonParser.except_clause_return retval = new PythonParser.except_clause_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token EXCEPT174=null;
        Token COMMA175=null;
        Token COLON176=null;
        PythonParser.test_return t1 = null;

        PythonParser.test_return t2 = null;

        PythonParser.suite_return suite177 = null;


        PythonTree EXCEPT174_tree=null;
        PythonTree COMMA175_tree=null;
        PythonTree COLON176_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_EXCEPT=new RewriteRuleTokenStream(adaptor,"token EXCEPT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        RewriteRuleSubtreeStream stream_suite=new RewriteRuleSubtreeStream(adaptor,"rule suite");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:995:5: ( EXCEPT (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Store] )? )? COLON suite[!$suite.isEmpty() && $suite::continueIllegal] -> ^( EXCEPT[$EXCEPT, actions.castExpr($t1.tree), actions.castExpr($t2.tree),\n actions.castStmts($suite.stypes)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:995:7: EXCEPT (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Store] )? )? COLON suite[!$suite.isEmpty() && $suite::continueIllegal]
            {
            EXCEPT174=(Token)match(input,EXCEPT,FOLLOW_EXCEPT_in_except_clause4039); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EXCEPT.add(EXCEPT174);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:995:14: (t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Store] )? )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==NAME||(LA75_0>=LAMBDA && LA75_0<=NOT)||LA75_0==LPAREN||(LA75_0>=PLUS && LA75_0<=MINUS)||(LA75_0>=TILDE && LA75_0<=LBRACK)||LA75_0==LCURLY||(LA75_0>=BACKQUOTE && LA75_0<=STRING)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:995:15: t1= test[expr_contextType.Load] ( COMMA t2= test[expr_contextType.Store] )?
                    {
                    pushFollow(FOLLOW_test_in_except_clause4044);
                    t1=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(t1.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:995:46: ( COMMA t2= test[expr_contextType.Store] )?
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==COMMA) ) {
                        alt74=1;
                    }
                    switch (alt74) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:995:47: COMMA t2= test[expr_contextType.Store]
                            {
                            COMMA175=(Token)match(input,COMMA,FOLLOW_COMMA_in_except_clause4048); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA175);

                            pushFollow(FOLLOW_test_in_except_clause4052);
                            t2=test(expr_contextType.Store);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_test.add(t2.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            COLON176=(Token)match(input,COLON,FOLLOW_COLON_in_except_clause4059); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON176);

            pushFollow(FOLLOW_suite_in_except_clause4061);
            suite177=suite(!suite_stack.isEmpty() && ((suite_scope)suite_stack.peek()).continueIllegal);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_suite.add(suite177.getTree());


            // AST REWRITE
            // elements: EXCEPT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 996:4: -> ^( EXCEPT[$EXCEPT, actions.castExpr($t1.tree), actions.castExpr($t2.tree),\n actions.castStmts($suite.stypes)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:996:7: ^( EXCEPT[$EXCEPT, actions.castExpr($t1.tree), actions.castExpr($t2.tree),\n actions.castStmts($suite.stypes)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new ExceptHandler(EXCEPT, EXCEPT174, actions.castExpr((t1!=null?((PythonTree)t1.tree):null)), actions.castExpr((t2!=null?((PythonTree)t2.tree):null)), actions.castStmts((suite177!=null?suite177.stypes:null))), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "except_clause"

    protected static class suite_scope {
        boolean continueIllegal;
    }
    protected Stack suite_stack = new Stack();

    public static class suite_return extends ParserRuleReturnScope {
        public List stypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "suite"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1001:1: suite[boolean fromFinally] returns [List stypes] : ( simple_stmt | NEWLINE INDENT ( stmt )+ DEDENT );
    public final PythonParser.suite_return suite(boolean fromFinally) throws RecognitionException {
        suite_stack.push(new suite_scope());
        PythonParser.suite_return retval = new PythonParser.suite_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token NEWLINE179=null;
        Token INDENT180=null;
        Token DEDENT182=null;
        PythonParser.simple_stmt_return simple_stmt178 = null;

        PythonParser.stmt_return stmt181 = null;


        PythonTree NEWLINE179_tree=null;
        PythonTree INDENT180_tree=null;
        PythonTree DEDENT182_tree=null;


            if (((suite_scope)suite_stack.peek()).continueIllegal || fromFinally) {
                ((suite_scope)suite_stack.peek()).continueIllegal = true;
            } else {
                ((suite_scope)suite_stack.peek()).continueIllegal = false;
            }
            retval.stypes = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1014:5: ( simple_stmt | NEWLINE INDENT ( stmt )+ DEDENT )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==NAME||(LA77_0>=ASSERT && LA77_0<=BREAK)||LA77_0==CONTINUE||LA77_0==DELETE||LA77_0==EXEC||LA77_0==FROM||LA77_0==GLOBAL||LA77_0==IMPORT||(LA77_0>=LAMBDA && LA77_0<=NOT)||(LA77_0>=PASS && LA77_0<=RETURN)||LA77_0==YIELD||LA77_0==LPAREN||(LA77_0>=PLUS && LA77_0<=MINUS)||(LA77_0>=TILDE && LA77_0<=LBRACK)||LA77_0==LCURLY||(LA77_0>=BACKQUOTE && LA77_0<=STRING)) ) {
                alt77=1;
            }
            else if ( (LA77_0==NEWLINE) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1014:7: simple_stmt
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_simple_stmt_in_suite4112);
                    simple_stmt178=simple_stmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simple_stmt178.getTree());
                    if ( state.backtracking==0 ) {

                                retval.stypes = (simple_stmt178!=null?simple_stmt178.stypes:null);
                            
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1018:7: NEWLINE INDENT ( stmt )+ DEDENT
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    NEWLINE179=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_suite4128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NEWLINE179_tree = (PythonTree)adaptor.create(NEWLINE179);
                    adaptor.addChild(root_0, NEWLINE179_tree);
                    }
                    INDENT180=(Token)match(input,INDENT,FOLLOW_INDENT_in_suite4130); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INDENT180_tree = (PythonTree)adaptor.create(INDENT180);
                    adaptor.addChild(root_0, INDENT180_tree);
                    }
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1019:7: ( stmt )+
                    int cnt76=0;
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==NAME||(LA76_0>=ASSERT && LA76_0<=DELETE)||LA76_0==EXEC||(LA76_0>=FROM && LA76_0<=IMPORT)||(LA76_0>=LAMBDA && LA76_0<=NOT)||(LA76_0>=PASS && LA76_0<=LPAREN)||(LA76_0>=PLUS && LA76_0<=MINUS)||(LA76_0>=TILDE && LA76_0<=LBRACK)||LA76_0==LCURLY||(LA76_0>=BACKQUOTE && LA76_0<=STRING)) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1019:8: stmt
                    	    {
                    	    pushFollow(FOLLOW_stmt_in_suite4139);
                    	    stmt181=stmt();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt181.getTree());
                    	    if ( state.backtracking==0 ) {

                    	                 if ((stmt181!=null?stmt181.stypes:null) != null) {
                    	                     retval.stypes.addAll((stmt181!=null?stmt181.stypes:null));
                    	                 }
                    	             
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt76 >= 1 ) break loop76;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(76, input);
                                throw eee;
                        }
                        cnt76++;
                    } while (true);

                    DEDENT182=(Token)match(input,DEDENT,FOLLOW_DEDENT_in_suite4159); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEDENT182_tree = (PythonTree)adaptor.create(DEDENT182);
                    adaptor.addChild(root_0, DEDENT182_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
            suite_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "suite"

    public static class test_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "test"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1029:1: test[expr_contextType ctype] : (o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] -> ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] ) | -> or_test ) | lambdef );
    public final PythonParser.test_return test(expr_contextType ctype) throws RecognitionException {
        PythonParser.test_return retval = new PythonParser.test_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token IF183=null;
        Token ORELSE184=null;
        PythonParser.or_test_return o1 = null;

        PythonParser.or_test_return o2 = null;

        PythonParser.test_return e = null;

        PythonParser.lambdef_return lambdef185 = null;


        PythonTree IF183_tree=null;
        PythonTree ORELSE184_tree=null;
        RewriteRuleTokenStream stream_ORELSE=new RewriteRuleTokenStream(adaptor,"token ORELSE");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        RewriteRuleSubtreeStream stream_or_test=new RewriteRuleSubtreeStream(adaptor,"rule or_test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1030:5: (o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] -> ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] ) | -> or_test ) | lambdef )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==NAME||LA79_0==NOT||LA79_0==LPAREN||(LA79_0>=PLUS && LA79_0<=MINUS)||(LA79_0>=TILDE && LA79_0<=LBRACK)||LA79_0==LCURLY||(LA79_0>=BACKQUOTE && LA79_0<=STRING)) ) {
                alt79=1;
            }
            else if ( (LA79_0==LAMBDA) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1030:6: o1= or_test[ctype] ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] -> ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] ) | -> or_test )
                    {
                    pushFollow(FOLLOW_or_test_in_test4179);
                    o1=or_test(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_or_test.add(o1.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1031:7: ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] -> ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] ) | -> or_test )
                    int alt78=2;
                    alt78 = dfa78.predict(input);
                    switch (alt78) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1031:9: ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load]
                            {
                            IF183=(Token)match(input,IF,FOLLOW_IF_in_test4201); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IF.add(IF183);

                            pushFollow(FOLLOW_or_test_in_test4205);
                            o2=or_test(ctype);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_or_test.add(o2.getTree());
                            ORELSE184=(Token)match(input,ORELSE,FOLLOW_ORELSE_in_test4208); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_ORELSE.add(ORELSE184);

                            pushFollow(FOLLOW_test_in_test4212);
                            e=test(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_test.add(e.getTree());


                            // AST REWRITE
                            // elements: IF
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1032:6: -> ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1032:9: ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new IfExp(IF, (o1!=null?((Token)o1.start):null), actions.castExpr((o2!=null?((PythonTree)o2.tree):null)), actions.castExpr((o1!=null?((PythonTree)o1.tree):null)), actions.castExpr((e!=null?((PythonTree)e.tree):null))), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1034:6: 
                            {

                            // AST REWRITE
                            // elements: or_test
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1034:6: -> or_test
                            {
                                adaptor.addChild(root_0, stream_or_test.nextTree());

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1036:7: lambdef
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_lambdef_in_test4261);
                    lambdef185=lambdef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lambdef185.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "test"

    public static class or_test_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "or_test"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1040:1: or_test[expr_contextType ctype] : left= and_test[ctype] ( (or= OR right+= and_test[ctype] )+ | -> $left) ;
    public final PythonParser.or_test_return or_test(expr_contextType ctype) throws RecognitionException {
        PythonParser.or_test_return retval = new PythonParser.or_test_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token or=null;
        List list_right=null;
        PythonParser.and_test_return left = null;

        PythonParser.and_test_return right = null;
         right = null;
        PythonTree or_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_and_test=new RewriteRuleSubtreeStream(adaptor,"rule and_test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1046:5: (left= and_test[ctype] ( (or= OR right+= and_test[ctype] )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1046:7: left= and_test[ctype] ( (or= OR right+= and_test[ctype] )+ | -> $left)
            {
            pushFollow(FOLLOW_and_test_in_or_test4287);
            left=and_test(ctype);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_and_test.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1047:9: ( (or= OR right+= and_test[ctype] )+ | -> $left)
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==OR) ) {
                alt81=1;
            }
            else if ( (LA81_0==EOF||LA81_0==NEWLINE||LA81_0==NAME||LA81_0==AS||LA81_0==FOR||LA81_0==IF||LA81_0==ORELSE||(LA81_0>=RPAREN && LA81_0<=COMMA)||(LA81_0>=SEMI && LA81_0<=DOUBLESLASHEQUAL)||LA81_0==RBRACK||(LA81_0>=RCURLY && LA81_0<=BACKQUOTE)) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1047:11: (or= OR right+= and_test[ctype] )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1047:11: (or= OR right+= and_test[ctype] )+
                    int cnt80=0;
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==OR) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1047:12: or= OR right+= and_test[ctype]
                    	    {
                    	    or=(Token)match(input,OR,FOLLOW_OR_in_or_test4303); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_OR.add(or);

                    	    pushFollow(FOLLOW_and_test_in_or_test4307);
                    	    right=and_test(ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_and_test.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt80 >= 1 ) break loop80;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(80, input);
                                throw eee;
                        }
                        cnt80++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1050:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1050:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (or != null) {
                      retval.tree = actions.makeBoolOp((left!=null?((PythonTree)left.tree):null), boolopType.Or, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "or_test"

    public static class and_test_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and_test"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1055:1: and_test[expr_contextType ctype] : left= not_test[ctype] ( (and= AND right+= not_test[ctype] )+ | -> $left) ;
    public final PythonParser.and_test_return and_test(expr_contextType ctype) throws RecognitionException {
        PythonParser.and_test_return retval = new PythonParser.and_test_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token and=null;
        List list_right=null;
        PythonParser.not_test_return left = null;

        PythonParser.not_test_return right = null;
         right = null;
        PythonTree and_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleSubtreeStream stream_not_test=new RewriteRuleSubtreeStream(adaptor,"rule not_test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1061:5: (left= not_test[ctype] ( (and= AND right+= not_test[ctype] )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1061:7: left= not_test[ctype] ( (and= AND right+= not_test[ctype] )+ | -> $left)
            {
            pushFollow(FOLLOW_not_test_in_and_test4379);
            left=not_test(ctype);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_not_test.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1062:9: ( (and= AND right+= not_test[ctype] )+ | -> $left)
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==AND) ) {
                alt83=1;
            }
            else if ( (LA83_0==EOF||LA83_0==NEWLINE||LA83_0==NAME||LA83_0==AS||LA83_0==FOR||LA83_0==IF||(LA83_0>=OR && LA83_0<=ORELSE)||(LA83_0>=RPAREN && LA83_0<=COMMA)||(LA83_0>=SEMI && LA83_0<=DOUBLESLASHEQUAL)||LA83_0==RBRACK||(LA83_0>=RCURLY && LA83_0<=BACKQUOTE)) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1062:11: (and= AND right+= not_test[ctype] )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1062:11: (and= AND right+= not_test[ctype] )+
                    int cnt82=0;
                    loop82:
                    do {
                        int alt82=2;
                        int LA82_0 = input.LA(1);

                        if ( (LA82_0==AND) ) {
                            alt82=1;
                        }


                        switch (alt82) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1062:12: and= AND right+= not_test[ctype]
                    	    {
                    	    and=(Token)match(input,AND,FOLLOW_AND_in_and_test4395); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AND.add(and);

                    	    pushFollow(FOLLOW_not_test_in_and_test4399);
                    	    right=not_test(ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_not_test.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt82 >= 1 ) break loop82;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(82, input);
                                throw eee;
                        }
                        cnt82++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1065:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1065:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (and != null) {
                      retval.tree = actions.makeBoolOp((left!=null?((PythonTree)left.tree):null), boolopType.And, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "and_test"

    public static class not_test_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "not_test"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1070:1: not_test[expr_contextType ctype] : ( NOT nt= not_test[ctype] -> ^( NOT[$NOT, unaryopType.Not, actions.castExpr($nt.tree)] ) | comparison[ctype] );
    public final PythonParser.not_test_return not_test(expr_contextType ctype) throws RecognitionException {
        PythonParser.not_test_return retval = new PythonParser.not_test_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token NOT186=null;
        PythonParser.not_test_return nt = null;

        PythonParser.comparison_return comparison187 = null;


        PythonTree NOT186_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleSubtreeStream stream_not_test=new RewriteRuleSubtreeStream(adaptor,"rule not_test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1071:5: ( NOT nt= not_test[ctype] -> ^( NOT[$NOT, unaryopType.Not, actions.castExpr($nt.tree)] ) | comparison[ctype] )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==NOT) ) {
                alt84=1;
            }
            else if ( (LA84_0==NAME||LA84_0==LPAREN||(LA84_0>=PLUS && LA84_0<=MINUS)||(LA84_0>=TILDE && LA84_0<=LBRACK)||LA84_0==LCURLY||(LA84_0>=BACKQUOTE && LA84_0<=STRING)) ) {
                alt84=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1071:7: NOT nt= not_test[ctype]
                    {
                    NOT186=(Token)match(input,NOT,FOLLOW_NOT_in_not_test4464); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT186);

                    pushFollow(FOLLOW_not_test_in_not_test4468);
                    nt=not_test(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_not_test.add(nt.getTree());


                    // AST REWRITE
                    // elements: NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1072:4: -> ^( NOT[$NOT, unaryopType.Not, actions.castExpr($nt.tree)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1072:7: ^( NOT[$NOT, unaryopType.Not, actions.castExpr($nt.tree)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new UnaryOp(NOT, NOT186, unaryopType.Not, actions.castExpr((nt!=null?((PythonTree)nt.tree):null))), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1073:7: comparison[ctype]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_comparison_in_not_test4490);
                    comparison187=comparison(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, comparison187.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "not_test"

    public static class comparison_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparison"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1077:1: comparison[expr_contextType ctype] : left= expr[ctype] ( ( comp_op right+= expr[ctype] )+ | -> $left) ;
    public final PythonParser.comparison_return comparison(expr_contextType ctype) throws RecognitionException {
        PythonParser.comparison_return retval = new PythonParser.comparison_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        List list_right=null;
        PythonParser.expr_return left = null;

        PythonParser.comp_op_return comp_op188 = null;

        PythonParser.expr_return right = null;
         right = null;
        RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"rule expr");
        RewriteRuleSubtreeStream stream_comp_op=new RewriteRuleSubtreeStream(adaptor,"rule comp_op");

            List cmps = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1087:5: (left= expr[ctype] ( ( comp_op right+= expr[ctype] )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1087:7: left= expr[ctype] ( ( comp_op right+= expr[ctype] )+ | -> $left)
            {
            pushFollow(FOLLOW_expr_in_comparison4522);
            left=expr(ctype);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_expr.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1088:8: ( ( comp_op right+= expr[ctype] )+ | -> $left)
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( ((LA86_0>=IN && LA86_0<=IS)||LA86_0==NOT||(LA86_0>=LESS && LA86_0<=NOTEQUAL)) ) {
                alt86=1;
            }
            else if ( (LA86_0==EOF||LA86_0==NEWLINE||LA86_0==NAME||(LA86_0>=AND && LA86_0<=AS)||LA86_0==FOR||LA86_0==IF||(LA86_0>=OR && LA86_0<=ORELSE)||(LA86_0>=RPAREN && LA86_0<=COMMA)||(LA86_0>=SEMI && LA86_0<=DOUBLESLASHEQUAL)||LA86_0==RBRACK||(LA86_0>=RCURLY && LA86_0<=BACKQUOTE)) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1088:10: ( comp_op right+= expr[ctype] )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1088:10: ( comp_op right+= expr[ctype] )+
                    int cnt85=0;
                    loop85:
                    do {
                        int alt85=2;
                        int LA85_0 = input.LA(1);

                        if ( ((LA85_0>=IN && LA85_0<=IS)||LA85_0==NOT||(LA85_0>=LESS && LA85_0<=NOTEQUAL)) ) {
                            alt85=1;
                        }


                        switch (alt85) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1088:12: comp_op right+= expr[ctype]
                    	    {
                    	    pushFollow(FOLLOW_comp_op_in_comparison4536);
                    	    comp_op188=comp_op();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_comp_op.add(comp_op188.getTree());
                    	    pushFollow(FOLLOW_expr_in_comparison4540);
                    	    right=expr(ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_expr.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());

                    	    if ( state.backtracking==0 ) {

                    	                     cmps.add((comp_op188!=null?comp_op188.op:null));
                    	                 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt85 >= 1 ) break loop85;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(85, input);
                                throw eee;
                        }
                        cnt85++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1094:7: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1094:7: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (!cmps.isEmpty()) {
                      retval.tree = new Compare((left!=null?((Token)left.start):null), actions.castExpr((left!=null?((PythonTree)left.tree):null)), actions.makeCmpOps(cmps),
                          actions.castExprs(list_right));
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparison"

    public static class comp_op_return extends ParserRuleReturnScope {
        public cmpopType op;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comp_op"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1099:1: comp_op returns [cmpopType op] : ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT );
    public final PythonParser.comp_op_return comp_op() throws RecognitionException {
        PythonParser.comp_op_return retval = new PythonParser.comp_op_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token LESS189=null;
        Token GREATER190=null;
        Token EQUAL191=null;
        Token GREATEREQUAL192=null;
        Token LESSEQUAL193=null;
        Token ALT_NOTEQUAL194=null;
        Token NOTEQUAL195=null;
        Token IN196=null;
        Token NOT197=null;
        Token IN198=null;
        Token IS199=null;
        Token IS200=null;
        Token NOT201=null;

        PythonTree LESS189_tree=null;
        PythonTree GREATER190_tree=null;
        PythonTree EQUAL191_tree=null;
        PythonTree GREATEREQUAL192_tree=null;
        PythonTree LESSEQUAL193_tree=null;
        PythonTree ALT_NOTEQUAL194_tree=null;
        PythonTree NOTEQUAL195_tree=null;
        PythonTree IN196_tree=null;
        PythonTree NOT197_tree=null;
        PythonTree IN198_tree=null;
        PythonTree IS199_tree=null;
        PythonTree IS200_tree=null;
        PythonTree NOT201_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1101:5: ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT )
            int alt87=11;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1101:7: LESS
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    LESS189=(Token)match(input,LESS,FOLLOW_LESS_in_comp_op4621); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LESS189_tree = (PythonTree)adaptor.create(LESS189);
                    adaptor.addChild(root_0, LESS189_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.Lt;
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1103:7: GREATER
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    GREATER190=(Token)match(input,GREATER,FOLLOW_GREATER_in_comp_op4639); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GREATER190_tree = (PythonTree)adaptor.create(GREATER190);
                    adaptor.addChild(root_0, GREATER190_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.Gt;
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1105:7: EQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    EQUAL191=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_comp_op4657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    EQUAL191_tree = (PythonTree)adaptor.create(EQUAL191);
                    adaptor.addChild(root_0, EQUAL191_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.Eq;
                    }

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1107:7: GREATEREQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    GREATEREQUAL192=(Token)match(input,GREATEREQUAL,FOLLOW_GREATEREQUAL_in_comp_op4675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    GREATEREQUAL192_tree = (PythonTree)adaptor.create(GREATEREQUAL192);
                    adaptor.addChild(root_0, GREATEREQUAL192_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.GtE;
                    }

                    }
                    break;
                case 5 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1109:7: LESSEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    LESSEQUAL193=(Token)match(input,LESSEQUAL,FOLLOW_LESSEQUAL_in_comp_op4693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LESSEQUAL193_tree = (PythonTree)adaptor.create(LESSEQUAL193);
                    adaptor.addChild(root_0, LESSEQUAL193_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.LtE;
                    }

                    }
                    break;
                case 6 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1111:7: ALT_NOTEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    ALT_NOTEQUAL194=(Token)match(input,ALT_NOTEQUAL,FOLLOW_ALT_NOTEQUAL_in_comp_op4711); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ALT_NOTEQUAL194_tree = (PythonTree)adaptor.create(ALT_NOTEQUAL194);
                    adaptor.addChild(root_0, ALT_NOTEQUAL194_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.NotEq;
                    }

                    }
                    break;
                case 7 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1113:7: NOTEQUAL
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    NOTEQUAL195=(Token)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_comp_op4729); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOTEQUAL195_tree = (PythonTree)adaptor.create(NOTEQUAL195);
                    adaptor.addChild(root_0, NOTEQUAL195_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.NotEq;
                    }

                    }
                    break;
                case 8 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1115:7: IN
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    IN196=(Token)match(input,IN,FOLLOW_IN_in_comp_op4747); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN196_tree = (PythonTree)adaptor.create(IN196);
                    adaptor.addChild(root_0, IN196_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.In;
                    }

                    }
                    break;
                case 9 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1117:7: NOT IN
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    NOT197=(Token)match(input,NOT,FOLLOW_NOT_in_comp_op4765); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT197_tree = (PythonTree)adaptor.create(NOT197);
                    adaptor.addChild(root_0, NOT197_tree);
                    }
                    IN198=(Token)match(input,IN,FOLLOW_IN_in_comp_op4767); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IN198_tree = (PythonTree)adaptor.create(IN198);
                    adaptor.addChild(root_0, IN198_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.NotIn;
                    }

                    }
                    break;
                case 10 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1119:7: IS
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    IS199=(Token)match(input,IS,FOLLOW_IS_in_comp_op4785); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS199_tree = (PythonTree)adaptor.create(IS199);
                    adaptor.addChild(root_0, IS199_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.Is;
                    }

                    }
                    break;
                case 11 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1121:7: IS NOT
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    IS200=(Token)match(input,IS,FOLLOW_IS_in_comp_op4803); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IS200_tree = (PythonTree)adaptor.create(IS200);
                    adaptor.addChild(root_0, IS200_tree);
                    }
                    NOT201=(Token)match(input,NOT,FOLLOW_NOT_in_comp_op4805); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT201_tree = (PythonTree)adaptor.create(NOT201);
                    adaptor.addChild(root_0, NOT201_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = cmpopType.IsNot;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comp_op"

    protected static class expr_scope {
        expr_contextType ctype;
    }
    protected Stack expr_stack = new Stack();

    public static class expr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1127:1: expr[expr_contextType ect] : left= xor_expr ( (op= VBAR right+= xor_expr )+ | -> $left) ;
    public final PythonParser.expr_return expr(expr_contextType ect) throws RecognitionException {
        expr_stack.push(new expr_scope());
        PythonParser.expr_return retval = new PythonParser.expr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token op=null;
        List list_right=null;
        PythonParser.xor_expr_return left = null;

        PythonParser.xor_expr_return right = null;
         right = null;
        PythonTree op_tree=null;
        RewriteRuleTokenStream stream_VBAR=new RewriteRuleTokenStream(adaptor,"token VBAR");
        RewriteRuleSubtreeStream stream_xor_expr=new RewriteRuleSubtreeStream(adaptor,"rule xor_expr");

            ((expr_scope)expr_stack.peek()).ctype = ect;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1139:5: (left= xor_expr ( (op= VBAR right+= xor_expr )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1139:7: left= xor_expr ( (op= VBAR right+= xor_expr )+ | -> $left)
            {
            pushFollow(FOLLOW_xor_expr_in_expr4851);
            left=xor_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_xor_expr.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1140:9: ( (op= VBAR right+= xor_expr )+ | -> $left)
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==VBAR) ) {
                alt89=1;
            }
            else if ( (LA89_0==EOF||LA89_0==NEWLINE||LA89_0==NAME||(LA89_0>=AND && LA89_0<=AS)||LA89_0==FOR||LA89_0==IF||(LA89_0>=IN && LA89_0<=IS)||(LA89_0>=NOT && LA89_0<=ORELSE)||(LA89_0>=RPAREN && LA89_0<=COMMA)||(LA89_0>=SEMI && LA89_0<=DOUBLESLASHEQUAL)||(LA89_0>=LESS && LA89_0<=NOTEQUAL)||LA89_0==RBRACK||(LA89_0>=RCURLY && LA89_0<=BACKQUOTE)) ) {
                alt89=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1140:11: (op= VBAR right+= xor_expr )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1140:11: (op= VBAR right+= xor_expr )+
                    int cnt88=0;
                    loop88:
                    do {
                        int alt88=2;
                        int LA88_0 = input.LA(1);

                        if ( (LA88_0==VBAR) ) {
                            alt88=1;
                        }


                        switch (alt88) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1140:12: op= VBAR right+= xor_expr
                    	    {
                    	    op=(Token)match(input,VBAR,FOLLOW_VBAR_in_expr4866); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_VBAR.add(op);

                    	    pushFollow(FOLLOW_xor_expr_in_expr4870);
                    	    right=xor_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_xor_expr.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt88 >= 1 ) break loop88;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(88, input);
                                throw eee;
                        }
                        cnt88++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1143:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1143:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (op != null) {
                      retval.tree = actions.makeBinOp((left!=null?((PythonTree)left.tree):null), operatorType.BitOr, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
            expr_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "expr"

    public static class xor_expr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "xor_expr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1149:1: xor_expr : left= and_expr ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left) ;
    public final PythonParser.xor_expr_return xor_expr() throws RecognitionException {
        PythonParser.xor_expr_return retval = new PythonParser.xor_expr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token op=null;
        List list_right=null;
        PythonParser.and_expr_return left = null;

        PythonParser.and_expr_return right = null;
         right = null;
        PythonTree op_tree=null;
        RewriteRuleTokenStream stream_CIRCUMFLEX=new RewriteRuleTokenStream(adaptor,"token CIRCUMFLEX");
        RewriteRuleSubtreeStream stream_and_expr=new RewriteRuleSubtreeStream(adaptor,"rule and_expr");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1155:5: (left= and_expr ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1155:7: left= and_expr ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left)
            {
            pushFollow(FOLLOW_and_expr_in_xor_expr4941);
            left=and_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_and_expr.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1156:9: ( (op= CIRCUMFLEX right+= and_expr )+ | -> $left)
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==CIRCUMFLEX) ) {
                alt91=1;
            }
            else if ( (LA91_0==EOF||LA91_0==NEWLINE||LA91_0==NAME||(LA91_0>=AND && LA91_0<=AS)||LA91_0==FOR||LA91_0==IF||(LA91_0>=IN && LA91_0<=IS)||(LA91_0>=NOT && LA91_0<=ORELSE)||(LA91_0>=RPAREN && LA91_0<=COMMA)||(LA91_0>=SEMI && LA91_0<=DOUBLESLASHEQUAL)||(LA91_0>=LESS && LA91_0<=VBAR)||LA91_0==RBRACK||(LA91_0>=RCURLY && LA91_0<=BACKQUOTE)) ) {
                alt91=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1156:11: (op= CIRCUMFLEX right+= and_expr )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1156:11: (op= CIRCUMFLEX right+= and_expr )+
                    int cnt90=0;
                    loop90:
                    do {
                        int alt90=2;
                        int LA90_0 = input.LA(1);

                        if ( (LA90_0==CIRCUMFLEX) ) {
                            alt90=1;
                        }


                        switch (alt90) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1156:12: op= CIRCUMFLEX right+= and_expr
                    	    {
                    	    op=(Token)match(input,CIRCUMFLEX,FOLLOW_CIRCUMFLEX_in_xor_expr4956); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_CIRCUMFLEX.add(op);

                    	    pushFollow(FOLLOW_and_expr_in_xor_expr4960);
                    	    right=and_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_and_expr.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt90 >= 1 ) break loop90;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(90, input);
                                throw eee;
                        }
                        cnt90++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1159:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1159:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (op != null) {
                      retval.tree = actions.makeBinOp((left!=null?((PythonTree)left.tree):null), operatorType.BitXor, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "xor_expr"

    public static class and_expr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "and_expr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1164:1: and_expr : left= shift_expr ( (op= AMPER right+= shift_expr )+ | -> $left) ;
    public final PythonParser.and_expr_return and_expr() throws RecognitionException {
        PythonParser.and_expr_return retval = new PythonParser.and_expr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token op=null;
        List list_right=null;
        PythonParser.shift_expr_return left = null;

        PythonParser.shift_expr_return right = null;
         right = null;
        PythonTree op_tree=null;
        RewriteRuleTokenStream stream_AMPER=new RewriteRuleTokenStream(adaptor,"token AMPER");
        RewriteRuleSubtreeStream stream_shift_expr=new RewriteRuleSubtreeStream(adaptor,"rule shift_expr");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1170:5: (left= shift_expr ( (op= AMPER right+= shift_expr )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1170:7: left= shift_expr ( (op= AMPER right+= shift_expr )+ | -> $left)
            {
            pushFollow(FOLLOW_shift_expr_in_and_expr5030);
            left=shift_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_shift_expr.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1171:9: ( (op= AMPER right+= shift_expr )+ | -> $left)
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==AMPER) ) {
                alt93=1;
            }
            else if ( (LA93_0==EOF||LA93_0==NEWLINE||LA93_0==NAME||(LA93_0>=AND && LA93_0<=AS)||LA93_0==FOR||LA93_0==IF||(LA93_0>=IN && LA93_0<=IS)||(LA93_0>=NOT && LA93_0<=ORELSE)||(LA93_0>=RPAREN && LA93_0<=COMMA)||(LA93_0>=SEMI && LA93_0<=DOUBLESLASHEQUAL)||(LA93_0>=LESS && LA93_0<=CIRCUMFLEX)||LA93_0==RBRACK||(LA93_0>=RCURLY && LA93_0<=BACKQUOTE)) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1171:11: (op= AMPER right+= shift_expr )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1171:11: (op= AMPER right+= shift_expr )+
                    int cnt92=0;
                    loop92:
                    do {
                        int alt92=2;
                        int LA92_0 = input.LA(1);

                        if ( (LA92_0==AMPER) ) {
                            alt92=1;
                        }


                        switch (alt92) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1171:12: op= AMPER right+= shift_expr
                    	    {
                    	    op=(Token)match(input,AMPER,FOLLOW_AMPER_in_and_expr5045); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AMPER.add(op);

                    	    pushFollow(FOLLOW_shift_expr_in_and_expr5049);
                    	    right=shift_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_shift_expr.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt92 >= 1 ) break loop92;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(92, input);
                                throw eee;
                        }
                        cnt92++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1174:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1174:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (op != null) {
                      retval.tree = actions.makeBinOp((left!=null?((PythonTree)left.tree):null), operatorType.BitAnd, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "and_expr"

    public static class shift_expr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shift_expr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1179:1: shift_expr : left= arith_expr ( ( shift_op right+= arith_expr )+ | -> $left) ;
    public final PythonParser.shift_expr_return shift_expr() throws RecognitionException {
        PythonParser.shift_expr_return retval = new PythonParser.shift_expr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        List list_right=null;
        PythonParser.arith_expr_return left = null;

        PythonParser.shift_op_return shift_op202 = null;

        PythonParser.arith_expr_return right = null;
         right = null;
        RewriteRuleSubtreeStream stream_arith_expr=new RewriteRuleSubtreeStream(adaptor,"rule arith_expr");
        RewriteRuleSubtreeStream stream_shift_op=new RewriteRuleSubtreeStream(adaptor,"rule shift_op");

            List ops = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1188:5: (left= arith_expr ( ( shift_op right+= arith_expr )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1188:7: left= arith_expr ( ( shift_op right+= arith_expr )+ | -> $left)
            {
            pushFollow(FOLLOW_arith_expr_in_shift_expr5124);
            left=arith_expr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_arith_expr.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1189:9: ( ( shift_op right+= arith_expr )+ | -> $left)
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==RIGHTSHIFT||LA95_0==LEFTSHIFT) ) {
                alt95=1;
            }
            else if ( (LA95_0==EOF||LA95_0==NEWLINE||LA95_0==NAME||(LA95_0>=AND && LA95_0<=AS)||LA95_0==FOR||LA95_0==IF||(LA95_0>=IN && LA95_0<=IS)||(LA95_0>=NOT && LA95_0<=ORELSE)||(LA95_0>=RPAREN && LA95_0<=COMMA)||(LA95_0>=SEMI && LA95_0<=DOUBLESLASHEQUAL)||(LA95_0>=LESS && LA95_0<=AMPER)||LA95_0==RBRACK||(LA95_0>=RCURLY && LA95_0<=BACKQUOTE)) ) {
                alt95=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1189:11: ( shift_op right+= arith_expr )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1189:11: ( shift_op right+= arith_expr )+
                    int cnt94=0;
                    loop94:
                    do {
                        int alt94=2;
                        int LA94_0 = input.LA(1);

                        if ( (LA94_0==RIGHTSHIFT||LA94_0==LEFTSHIFT) ) {
                            alt94=1;
                        }


                        switch (alt94) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1189:13: shift_op right+= arith_expr
                    	    {
                    	    pushFollow(FOLLOW_shift_op_in_shift_expr5138);
                    	    shift_op202=shift_op();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_shift_op.add(shift_op202.getTree());
                    	    pushFollow(FOLLOW_arith_expr_in_shift_expr5142);
                    	    right=arith_expr();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_arith_expr.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());

                    	    if ( state.backtracking==0 ) {

                    	                      ops.add((shift_op202!=null?shift_op202.op:null));
                    	                  
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt94 >= 1 ) break loop94;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(94, input);
                                throw eee;
                        }
                        cnt94++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1195:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1195:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (!ops.isEmpty()) {
                      retval.tree = actions.makeBinOp((left!=null?((PythonTree)left.tree):null), ops, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shift_expr"

    public static class shift_op_return extends ParserRuleReturnScope {
        public operatorType op;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shift_op"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1199:1: shift_op returns [operatorType op] : ( LEFTSHIFT | RIGHTSHIFT );
    public final PythonParser.shift_op_return shift_op() throws RecognitionException {
        PythonParser.shift_op_return retval = new PythonParser.shift_op_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token LEFTSHIFT203=null;
        Token RIGHTSHIFT204=null;

        PythonTree LEFTSHIFT203_tree=null;
        PythonTree RIGHTSHIFT204_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1201:5: ( LEFTSHIFT | RIGHTSHIFT )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==LEFTSHIFT) ) {
                alt96=1;
            }
            else if ( (LA96_0==RIGHTSHIFT) ) {
                alt96=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1201:7: LEFTSHIFT
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    LEFTSHIFT203=(Token)match(input,LEFTSHIFT,FOLLOW_LEFTSHIFT_in_shift_op5226); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LEFTSHIFT203_tree = (PythonTree)adaptor.create(LEFTSHIFT203);
                    adaptor.addChild(root_0, LEFTSHIFT203_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.LShift;
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1203:7: RIGHTSHIFT
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    RIGHTSHIFT204=(Token)match(input,RIGHTSHIFT,FOLLOW_RIGHTSHIFT_in_shift_op5244); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RIGHTSHIFT204_tree = (PythonTree)adaptor.create(RIGHTSHIFT204);
                    adaptor.addChild(root_0, RIGHTSHIFT204_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.RShift;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "shift_op"

    public static class arith_expr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arith_expr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1208:1: arith_expr : left= term ( ( arith_op right+= term )+ | -> $left) ;
    public final PythonParser.arith_expr_return arith_expr() throws RecognitionException {
        PythonParser.arith_expr_return retval = new PythonParser.arith_expr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        List list_right=null;
        PythonParser.term_return left = null;

        PythonParser.arith_op_return arith_op205 = null;

        PythonParser.term_return right = null;
         right = null;
        RewriteRuleSubtreeStream stream_arith_op=new RewriteRuleSubtreeStream(adaptor,"rule arith_op");
        RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

            List ops = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1217:5: (left= term ( ( arith_op right+= term )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1217:7: left= term ( ( arith_op right+= term )+ | -> $left)
            {
            pushFollow(FOLLOW_term_in_arith_expr5284);
            left=term();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_term.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1218:9: ( ( arith_op right+= term )+ | -> $left)
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( ((LA98_0>=PLUS && LA98_0<=MINUS)) ) {
                alt98=1;
            }
            else if ( (LA98_0==EOF||LA98_0==NEWLINE||LA98_0==NAME||(LA98_0>=AND && LA98_0<=AS)||LA98_0==FOR||LA98_0==IF||(LA98_0>=IN && LA98_0<=IS)||(LA98_0>=NOT && LA98_0<=ORELSE)||(LA98_0>=RPAREN && LA98_0<=COMMA)||(LA98_0>=SEMI && LA98_0<=LEFTSHIFT)||LA98_0==RBRACK||(LA98_0>=RCURLY && LA98_0<=BACKQUOTE)) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1218:11: ( arith_op right+= term )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1218:11: ( arith_op right+= term )+
                    int cnt97=0;
                    loop97:
                    do {
                        int alt97=2;
                        int LA97_0 = input.LA(1);

                        if ( ((LA97_0>=PLUS && LA97_0<=MINUS)) ) {
                            alt97=1;
                        }


                        switch (alt97) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1218:12: arith_op right+= term
                    	    {
                    	    pushFollow(FOLLOW_arith_op_in_arith_expr5297);
                    	    arith_op205=arith_op();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_arith_op.add(arith_op205.getTree());
                    	    pushFollow(FOLLOW_term_in_arith_expr5301);
                    	    right=term();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_term.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());

                    	    if ( state.backtracking==0 ) {

                    	                     ops.add((arith_op205!=null?arith_op205.op:null));
                    	                 
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt97 >= 1 ) break loop97;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(97, input);
                                throw eee;
                        }
                        cnt97++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1224:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1224:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (!ops.isEmpty()) {
                      retval.tree = actions.makeBinOp((left!=null?((PythonTree)left.tree):null), ops, list_right);
                  }

            }
        }
        catch (RewriteCardinalityException rce) {

                    PythonTree badNode = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), null);
                    retval.tree = badNode;
                    errorHandler.error("Internal Parser Error", badNode);
                
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arith_expr"

    public static class arith_op_return extends ParserRuleReturnScope {
        public operatorType op;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arith_op"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1236:1: arith_op returns [operatorType op] : ( PLUS | MINUS );
    public final PythonParser.arith_op_return arith_op() throws RecognitionException {
        PythonParser.arith_op_return retval = new PythonParser.arith_op_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token PLUS206=null;
        Token MINUS207=null;

        PythonTree PLUS206_tree=null;
        PythonTree MINUS207_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1238:5: ( PLUS | MINUS )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==PLUS) ) {
                alt99=1;
            }
            else if ( (LA99_0==MINUS) ) {
                alt99=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1238:7: PLUS
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    PLUS206=(Token)match(input,PLUS,FOLLOW_PLUS_in_arith_op5409); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS206_tree = (PythonTree)adaptor.create(PLUS206);
                    adaptor.addChild(root_0, PLUS206_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Add;
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1240:7: MINUS
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    MINUS207=(Token)match(input,MINUS,FOLLOW_MINUS_in_arith_op5427); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS207_tree = (PythonTree)adaptor.create(MINUS207);
                    adaptor.addChild(root_0, MINUS207_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Sub;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arith_op"

    public static class term_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1245:1: term : left= factor ( ( term_op right+= factor )+ | -> $left) ;
    public final PythonParser.term_return term() throws RecognitionException {
        PythonParser.term_return retval = new PythonParser.term_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        List list_right=null;
        PythonParser.factor_return left = null;

        PythonParser.term_op_return term_op208 = null;

        PythonParser.factor_return right = null;
         right = null;
        RewriteRuleSubtreeStream stream_term_op=new RewriteRuleSubtreeStream(adaptor,"rule term_op");
        RewriteRuleSubtreeStream stream_factor=new RewriteRuleSubtreeStream(adaptor,"rule factor");

            List ops = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1254:5: (left= factor ( ( term_op right+= factor )+ | -> $left) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1254:7: left= factor ( ( term_op right+= factor )+ | -> $left)
            {
            pushFollow(FOLLOW_factor_in_term5467);
            left=factor();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_factor.add(left.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1255:9: ( ( term_op right+= factor )+ | -> $left)
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==STAR||(LA101_0>=SLASH && LA101_0<=DOUBLESLASH)) ) {
                alt101=1;
            }
            else if ( (LA101_0==EOF||LA101_0==NEWLINE||LA101_0==NAME||(LA101_0>=AND && LA101_0<=AS)||LA101_0==FOR||LA101_0==IF||(LA101_0>=IN && LA101_0<=IS)||(LA101_0>=NOT && LA101_0<=ORELSE)||(LA101_0>=RPAREN && LA101_0<=COMMA)||(LA101_0>=SEMI && LA101_0<=MINUS)||LA101_0==RBRACK||(LA101_0>=RCURLY && LA101_0<=BACKQUOTE)) ) {
                alt101=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1255:11: ( term_op right+= factor )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1255:11: ( term_op right+= factor )+
                    int cnt100=0;
                    loop100:
                    do {
                        int alt100=2;
                        int LA100_0 = input.LA(1);

                        if ( (LA100_0==STAR||(LA100_0>=SLASH && LA100_0<=DOUBLESLASH)) ) {
                            alt100=1;
                        }


                        switch (alt100) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1255:12: term_op right+= factor
                    	    {
                    	    pushFollow(FOLLOW_term_op_in_term5480);
                    	    term_op208=term_op();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_term_op.add(term_op208.getTree());
                    	    pushFollow(FOLLOW_factor_in_term5484);
                    	    right=factor();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_factor.add(right.getTree());
                    	    if (list_right==null) list_right=new ArrayList();
                    	    list_right.add(right.getTree());

                    	    if ( state.backtracking==0 ) {

                    	                    ops.add((term_op208!=null?term_op208.op:null));
                    	                
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt100 >= 1 ) break loop100;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(100, input);
                                throw eee;
                        }
                        cnt100++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1261:8: 
                    {

                    // AST REWRITE
                    // elements: left
                    // token labels: 
                    // rule labels: retval, left
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_left=new RewriteRuleSubtreeStream(adaptor,"rule left",left!=null?left.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1261:8: -> $left
                    {
                        adaptor.addChild(root_0, stream_left.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (!ops.isEmpty()) {
                      retval.tree = actions.makeBinOp((left!=null?((PythonTree)left.tree):null), ops, list_right);
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term"

    public static class term_op_return extends ParserRuleReturnScope {
        public operatorType op;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "term_op"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1265:1: term_op returns [operatorType op] : ( STAR | SLASH | PERCENT | DOUBLESLASH );
    public final PythonParser.term_op_return term_op() throws RecognitionException {
        PythonParser.term_op_return retval = new PythonParser.term_op_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token STAR209=null;
        Token SLASH210=null;
        Token PERCENT211=null;
        Token DOUBLESLASH212=null;

        PythonTree STAR209_tree=null;
        PythonTree SLASH210_tree=null;
        PythonTree PERCENT211_tree=null;
        PythonTree DOUBLESLASH212_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1267:5: ( STAR | SLASH | PERCENT | DOUBLESLASH )
            int alt102=4;
            switch ( input.LA(1) ) {
            case STAR:
                {
                alt102=1;
                }
                break;
            case SLASH:
                {
                alt102=2;
                }
                break;
            case PERCENT:
                {
                alt102=3;
                }
                break;
            case DOUBLESLASH:
                {
                alt102=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1267:6: STAR
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    STAR209=(Token)match(input,STAR,FOLLOW_STAR_in_term_op5565); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR209_tree = (PythonTree)adaptor.create(STAR209);
                    adaptor.addChild(root_0, STAR209_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Mult;
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1269:6: SLASH
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    SLASH210=(Token)match(input,SLASH,FOLLOW_SLASH_in_term_op5582); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SLASH210_tree = (PythonTree)adaptor.create(SLASH210);
                    adaptor.addChild(root_0, SLASH210_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Div;
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1271:6: PERCENT
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    PERCENT211=(Token)match(input,PERCENT,FOLLOW_PERCENT_in_term_op5599); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PERCENT211_tree = (PythonTree)adaptor.create(PERCENT211);
                    adaptor.addChild(root_0, PERCENT211_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.Mod;
                    }

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1273:6: DOUBLESLASH
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    DOUBLESLASH212=(Token)match(input,DOUBLESLASH,FOLLOW_DOUBLESLASH_in_term_op5616); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLESLASH212_tree = (PythonTree)adaptor.create(DOUBLESLASH212);
                    adaptor.addChild(root_0, DOUBLESLASH212_tree);
                    }
                    if ( state.backtracking==0 ) {
                      retval.op = operatorType.FloorDiv;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "term_op"

    public static class factor_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "factor"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1278:1: factor returns [expr etype] : ( PLUS p= factor | MINUS m= factor | TILDE t= factor | power );
    public final PythonParser.factor_return factor() throws RecognitionException {
        PythonParser.factor_return retval = new PythonParser.factor_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token PLUS213=null;
        Token MINUS214=null;
        Token TILDE215=null;
        PythonParser.factor_return p = null;

        PythonParser.factor_return m = null;

        PythonParser.factor_return t = null;

        PythonParser.power_return power216 = null;


        PythonTree PLUS213_tree=null;
        PythonTree MINUS214_tree=null;
        PythonTree TILDE215_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1283:5: ( PLUS p= factor | MINUS m= factor | TILDE t= factor | power )
            int alt103=4;
            switch ( input.LA(1) ) {
            case PLUS:
                {
                alt103=1;
                }
                break;
            case MINUS:
                {
                alt103=2;
                }
                break;
            case TILDE:
                {
                alt103=3;
                }
                break;
            case NAME:
            case LPAREN:
            case LBRACK:
            case LCURLY:
            case BACKQUOTE:
            case INT:
            case LONGINT:
            case FLOAT:
            case COMPLEX:
            case STRING:
                {
                alt103=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1283:7: PLUS p= factor
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    PLUS213=(Token)match(input,PLUS,FOLLOW_PLUS_in_factor5657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    PLUS213_tree = (PythonTree)adaptor.create(PLUS213);
                    adaptor.addChild(root_0, PLUS213_tree);
                    }
                    pushFollow(FOLLOW_factor_in_factor5661);
                    p=factor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());
                    if ( state.backtracking==0 ) {
                      retval.etype = new UnaryOp(PLUS213, unaryopType.UAdd, (p!=null?p.etype:null));
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1285:7: MINUS m= factor
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    MINUS214=(Token)match(input,MINUS,FOLLOW_MINUS_in_factor5679); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS214_tree = (PythonTree)adaptor.create(MINUS214);
                    adaptor.addChild(root_0, MINUS214_tree);
                    }
                    pushFollow(FOLLOW_factor_in_factor5683);
                    m=factor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());
                    if ( state.backtracking==0 ) {
                      retval.etype = actions.negate(MINUS214, (m!=null?m.etype:null));
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1287:7: TILDE t= factor
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    TILDE215=(Token)match(input,TILDE,FOLLOW_TILDE_in_factor5701); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TILDE215_tree = (PythonTree)adaptor.create(TILDE215);
                    adaptor.addChild(root_0, TILDE215_tree);
                    }
                    pushFollow(FOLLOW_factor_in_factor5705);
                    t=factor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    if ( state.backtracking==0 ) {
                      retval.etype = new UnaryOp(TILDE215, unaryopType.Invert, (t!=null?t.etype:null));
                    }

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1289:7: power
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_power_in_factor5723);
                    power216=power();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, power216.getTree());
                    if ( state.backtracking==0 ) {
                      retval.etype = actions.castExpr((power216!=null?((PythonTree)power216.tree):null));
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = retval.etype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "factor"

    public static class power_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "power"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1294:1: power returns [expr etype] : atom (t+= trailer[$atom.start, $atom.tree] )* ( options {greedy=true; } : d= DOUBLESTAR factor )? ;
    public final PythonParser.power_return power() throws RecognitionException {
        PythonParser.power_return retval = new PythonParser.power_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token d=null;
        List list_t=null;
        PythonParser.atom_return atom217 = null;

        PythonParser.factor_return factor218 = null;

        PythonParser.trailer_return t = null;
         t = null;
        PythonTree d_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1299:5: ( atom (t+= trailer[$atom.start, $atom.tree] )* ( options {greedy=true; } : d= DOUBLESTAR factor )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1299:7: atom (t+= trailer[$atom.start, $atom.tree] )* ( options {greedy=true; } : d= DOUBLESTAR factor )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_power5764);
            atom217=atom();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, atom217.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1299:12: (t+= trailer[$atom.start, $atom.tree] )*
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==DOT||LA104_0==LPAREN||LA104_0==LBRACK) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1299:13: t+= trailer[$atom.start, $atom.tree]
            	    {
            	    pushFollow(FOLLOW_trailer_in_power5769);
            	    t=trailer((atom217!=null?((Token)atom217.start):null), (atom217!=null?((PythonTree)atom217.tree):null));

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            	    if (list_t==null) list_t=new ArrayList();
            	    list_t.add(t.getTree());


            	    }
            	    break;

            	default :
            	    break loop104;
                }
            } while (true);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1299:51: ( options {greedy=true; } : d= DOUBLESTAR factor )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==DOUBLESTAR) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1299:75: d= DOUBLESTAR factor
                    {
                    d=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_power5784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    d_tree = (PythonTree)adaptor.create(d);
                    adaptor.addChild(root_0, d_tree);
                    }
                    pushFollow(FOLLOW_factor_in_power5786);
                    factor218=factor();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, factor218.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        //XXX: This could be better.
                        retval.etype = actions.castExpr((atom217!=null?((PythonTree)atom217.tree):null));
                        if (list_t != null) {
                            for(Object o : list_t) {
                                if (retval.etype instanceof Context) {
                                    ((Context)retval.etype).setContext(expr_contextType.Load);
                                }
                                if (o instanceof Call) {
                                    Call c = (Call)o;
                                    c.setFunc((PyObject)retval.etype);
                                    retval.etype = c;
                                } else if (o instanceof Subscript) {
                                    Subscript c = (Subscript)o;
                                    c.setValue((PyObject)retval.etype);
                                    retval.etype = c;
                                } else if (o instanceof Attribute) {
                                    Attribute c = (Attribute)o;
                                    c.setCharStartIndex(retval.etype.getCharStartIndex());
                                    c.setValue((PyObject)retval.etype);
                                    retval.etype = c;
                                }
                            }
                        }
                        if (d != null) {
                            List right = new ArrayList();
                            right.add((factor218!=null?((PythonTree)factor218.tree):null));
                            retval.etype = actions.makeBinOp(retval.etype, operatorType.Pow, right);
                        }
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = retval.etype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "power"

    public static class atom_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1337:1: atom : ( LPAREN ( yield_expr -> yield_expr | testlist_gexp -> testlist_gexp | -> ^( LPAREN[$LPAREN, new ArrayList<expr>(), $expr::ctype] ) ) RPAREN | LBRACK ( listmaker[$LBRACK] -> listmaker | -> ^( LBRACK[$LBRACK, new ArrayList<expr>(), $expr::ctype] ) ) RBRACK | LCURLY ( dictmaker -> ^( LCURLY[$LCURLY, actions.castExprs($dictmaker.keys),\n actions.castExprs($dictmaker.values)] ) | -> ^( LCURLY[$LCURLY, new ArrayList<expr>(), new ArrayList<expr>()] ) ) RCURLY | lb= BACKQUOTE testlist[expr_contextType.Load] rb= BACKQUOTE -> ^( BACKQUOTE[$lb, actions.castExpr($testlist.tree)] ) | NAME -> ^( NAME[$NAME, $NAME.text, $expr::ctype] ) | INT -> ^( INT[$INT, actions.makeInt($INT)] ) | LONGINT -> ^( LONGINT[$LONGINT, actions.makeInt($LONGINT)] ) | FLOAT -> ^( FLOAT[$FLOAT, actions.makeFloat($FLOAT)] ) | COMPLEX -> ^( COMPLEX[$COMPLEX, actions.makeComplex($COMPLEX)] ) | (S+= STRING )+ -> ^( STRING[actions.extractStringToken($S), actions.extractStrings($S, encoding)] ) );
    public final PythonParser.atom_return atom() throws RecognitionException {
        PythonParser.atom_return retval = new PythonParser.atom_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token lb=null;
        Token rb=null;
        Token LPAREN219=null;
        Token RPAREN222=null;
        Token LBRACK223=null;
        Token RBRACK225=null;
        Token LCURLY226=null;
        Token RCURLY228=null;
        Token NAME230=null;
        Token INT231=null;
        Token LONGINT232=null;
        Token FLOAT233=null;
        Token COMPLEX234=null;
        Token S=null;
        List list_S=null;
        PythonParser.yield_expr_return yield_expr220 = null;

        PythonParser.testlist_gexp_return testlist_gexp221 = null;

        PythonParser.listmaker_return listmaker224 = null;

        PythonParser.dictmaker_return dictmaker227 = null;

        PythonParser.testlist_return testlist229 = null;


        PythonTree lb_tree=null;
        PythonTree rb_tree=null;
        PythonTree LPAREN219_tree=null;
        PythonTree RPAREN222_tree=null;
        PythonTree LBRACK223_tree=null;
        PythonTree RBRACK225_tree=null;
        PythonTree LCURLY226_tree=null;
        PythonTree RCURLY228_tree=null;
        PythonTree NAME230_tree=null;
        PythonTree INT231_tree=null;
        PythonTree LONGINT232_tree=null;
        PythonTree FLOAT233_tree=null;
        PythonTree COMPLEX234_tree=null;
        PythonTree S_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_BACKQUOTE=new RewriteRuleTokenStream(adaptor,"token BACKQUOTE");
        RewriteRuleTokenStream stream_NAME=new RewriteRuleTokenStream(adaptor,"token NAME");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_RCURLY=new RewriteRuleTokenStream(adaptor,"token RCURLY");
        RewriteRuleTokenStream stream_LONGINT=new RewriteRuleTokenStream(adaptor,"token LONGINT");
        RewriteRuleTokenStream stream_LCURLY=new RewriteRuleTokenStream(adaptor,"token LCURLY");
        RewriteRuleTokenStream stream_COMPLEX=new RewriteRuleTokenStream(adaptor,"token COMPLEX");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
        RewriteRuleSubtreeStream stream_testlist_gexp=new RewriteRuleSubtreeStream(adaptor,"rule testlist_gexp");
        RewriteRuleSubtreeStream stream_dictmaker=new RewriteRuleSubtreeStream(adaptor,"rule dictmaker");
        RewriteRuleSubtreeStream stream_yield_expr=new RewriteRuleSubtreeStream(adaptor,"rule yield_expr");
        RewriteRuleSubtreeStream stream_listmaker=new RewriteRuleSubtreeStream(adaptor,"rule listmaker");
        RewriteRuleSubtreeStream stream_testlist=new RewriteRuleSubtreeStream(adaptor,"rule testlist");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1338:5: ( LPAREN ( yield_expr -> yield_expr | testlist_gexp -> testlist_gexp | -> ^( LPAREN[$LPAREN, new ArrayList<expr>(), $expr::ctype] ) ) RPAREN | LBRACK ( listmaker[$LBRACK] -> listmaker | -> ^( LBRACK[$LBRACK, new ArrayList<expr>(), $expr::ctype] ) ) RBRACK | LCURLY ( dictmaker -> ^( LCURLY[$LCURLY, actions.castExprs($dictmaker.keys),\n actions.castExprs($dictmaker.values)] ) | -> ^( LCURLY[$LCURLY, new ArrayList<expr>(), new ArrayList<expr>()] ) ) RCURLY | lb= BACKQUOTE testlist[expr_contextType.Load] rb= BACKQUOTE -> ^( BACKQUOTE[$lb, actions.castExpr($testlist.tree)] ) | NAME -> ^( NAME[$NAME, $NAME.text, $expr::ctype] ) | INT -> ^( INT[$INT, actions.makeInt($INT)] ) | LONGINT -> ^( LONGINT[$LONGINT, actions.makeInt($LONGINT)] ) | FLOAT -> ^( FLOAT[$FLOAT, actions.makeFloat($FLOAT)] ) | COMPLEX -> ^( COMPLEX[$COMPLEX, actions.makeComplex($COMPLEX)] ) | (S+= STRING )+ -> ^( STRING[actions.extractStringToken($S), actions.extractStrings($S, encoding)] ) )
            int alt110=10;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt110=1;
                }
                break;
            case LBRACK:
                {
                alt110=2;
                }
                break;
            case LCURLY:
                {
                alt110=3;
                }
                break;
            case BACKQUOTE:
                {
                alt110=4;
                }
                break;
            case NAME:
                {
                alt110=5;
                }
                break;
            case INT:
                {
                alt110=6;
                }
                break;
            case LONGINT:
                {
                alt110=7;
                }
                break;
            case FLOAT:
                {
                alt110=8;
                }
                break;
            case COMPLEX:
                {
                alt110=9;
                }
                break;
            case STRING:
                {
                alt110=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }

            switch (alt110) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1338:7: LPAREN ( yield_expr -> yield_expr | testlist_gexp -> testlist_gexp | -> ^( LPAREN[$LPAREN, new ArrayList<expr>(), $expr::ctype] ) ) RPAREN
                    {
                    LPAREN219=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atom5818); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN219);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1339:7: ( yield_expr -> yield_expr | testlist_gexp -> testlist_gexp | -> ^( LPAREN[$LPAREN, new ArrayList<expr>(), $expr::ctype] ) )
                    int alt106=3;
                    switch ( input.LA(1) ) {
                    case YIELD:
                        {
                        alt106=1;
                        }
                        break;
                    case NAME:
                    case LAMBDA:
                    case NOT:
                    case LPAREN:
                    case PLUS:
                    case MINUS:
                    case TILDE:
                    case LBRACK:
                    case LCURLY:
                    case BACKQUOTE:
                    case INT:
                    case LONGINT:
                    case FLOAT:
                    case COMPLEX:
                    case STRING:
                        {
                        alt106=2;
                        }
                        break;
                    case RPAREN:
                        {
                        alt106=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 106, 0, input);

                        throw nvae;
                    }

                    switch (alt106) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1339:9: yield_expr
                            {
                            pushFollow(FOLLOW_yield_expr_in_atom5828);
                            yield_expr220=yield_expr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_yield_expr.add(yield_expr220.getTree());


                            // AST REWRITE
                            // elements: yield_expr
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1340:6: -> yield_expr
                            {
                                adaptor.addChild(root_0, stream_yield_expr.nextTree());

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1341:9: testlist_gexp
                            {
                            pushFollow(FOLLOW_testlist_gexp_in_atom5847);
                            testlist_gexp221=testlist_gexp();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_testlist_gexp.add(testlist_gexp221.getTree());


                            // AST REWRITE
                            // elements: testlist_gexp
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1342:6: -> testlist_gexp
                            {
                                adaptor.addChild(root_0, stream_testlist_gexp.nextTree());

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 3 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1344:6: 
                            {

                            // AST REWRITE
                            // elements: LPAREN
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1344:6: -> ^( LPAREN[$LPAREN, new ArrayList<expr>(), $expr::ctype] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1344:9: ^( LPAREN[$LPAREN, new ArrayList<expr>(), $expr::ctype] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Tuple(LPAREN, LPAREN219, new ArrayList<expr>(), ((expr_scope)expr_stack.peek()).ctype), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }

                    RPAREN222=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atom5895); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN222);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1347:7: LBRACK ( listmaker[$LBRACK] -> listmaker | -> ^( LBRACK[$LBRACK, new ArrayList<expr>(), $expr::ctype] ) ) RBRACK
                    {
                    LBRACK223=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_atom5903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK223);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1348:7: ( listmaker[$LBRACK] -> listmaker | -> ^( LBRACK[$LBRACK, new ArrayList<expr>(), $expr::ctype] ) )
                    int alt107=2;
                    int LA107_0 = input.LA(1);

                    if ( (LA107_0==NAME||(LA107_0>=LAMBDA && LA107_0<=NOT)||LA107_0==LPAREN||(LA107_0>=PLUS && LA107_0<=MINUS)||(LA107_0>=TILDE && LA107_0<=LBRACK)||LA107_0==LCURLY||(LA107_0>=BACKQUOTE && LA107_0<=STRING)) ) {
                        alt107=1;
                    }
                    else if ( (LA107_0==RBRACK) ) {
                        alt107=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 107, 0, input);

                        throw nvae;
                    }
                    switch (alt107) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1348:8: listmaker[$LBRACK]
                            {
                            pushFollow(FOLLOW_listmaker_in_atom5912);
                            listmaker224=listmaker(LBRACK223);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_listmaker.add(listmaker224.getTree());


                            // AST REWRITE
                            // elements: listmaker
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1349:6: -> listmaker
                            {
                                adaptor.addChild(root_0, stream_listmaker.nextTree());

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1351:6: 
                            {

                            // AST REWRITE
                            // elements: LBRACK
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1351:6: -> ^( LBRACK[$LBRACK, new ArrayList<expr>(), $expr::ctype] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1351:9: ^( LBRACK[$LBRACK, new ArrayList<expr>(), $expr::ctype] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new org.python.antlr.ast.List(LBRACK, LBRACK223, new ArrayList<expr>(), ((expr_scope)expr_stack.peek()).ctype), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }

                    RBRACK225=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_atom5969); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK225);


                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1354:7: LCURLY ( dictmaker -> ^( LCURLY[$LCURLY, actions.castExprs($dictmaker.keys),\n actions.castExprs($dictmaker.values)] ) | -> ^( LCURLY[$LCURLY, new ArrayList<expr>(), new ArrayList<expr>()] ) ) RCURLY
                    {
                    LCURLY226=(Token)match(input,LCURLY,FOLLOW_LCURLY_in_atom5977); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LCURLY.add(LCURLY226);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1355:8: ( dictmaker -> ^( LCURLY[$LCURLY, actions.castExprs($dictmaker.keys),\n actions.castExprs($dictmaker.values)] ) | -> ^( LCURLY[$LCURLY, new ArrayList<expr>(), new ArrayList<expr>()] ) )
                    int alt108=2;
                    int LA108_0 = input.LA(1);

                    if ( (LA108_0==NAME||(LA108_0>=LAMBDA && LA108_0<=NOT)||LA108_0==LPAREN||(LA108_0>=PLUS && LA108_0<=MINUS)||(LA108_0>=TILDE && LA108_0<=LBRACK)||LA108_0==LCURLY||(LA108_0>=BACKQUOTE && LA108_0<=STRING)) ) {
                        alt108=1;
                    }
                    else if ( (LA108_0==RCURLY) ) {
                        alt108=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 108, 0, input);

                        throw nvae;
                    }
                    switch (alt108) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1355:9: dictmaker
                            {
                            pushFollow(FOLLOW_dictmaker_in_atom5987);
                            dictmaker227=dictmaker();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_dictmaker.add(dictmaker227.getTree());


                            // AST REWRITE
                            // elements: LCURLY
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1356:7: -> ^( LCURLY[$LCURLY, actions.castExprs($dictmaker.keys),\n actions.castExprs($dictmaker.values)] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1356:10: ^( LCURLY[$LCURLY, actions.castExprs($dictmaker.keys),\n actions.castExprs($dictmaker.values)] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Dict(LCURLY, LCURLY226, actions.castExprs((dictmaker227!=null?dictmaker227.keys:null)), actions.castExprs((dictmaker227!=null?dictmaker227.values:null))), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1359:7: 
                            {

                            // AST REWRITE
                            // elements: LCURLY
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1359:7: -> ^( LCURLY[$LCURLY, new ArrayList<expr>(), new ArrayList<expr>()] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1359:10: ^( LCURLY[$LCURLY, new ArrayList<expr>(), new ArrayList<expr>()] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Dict(LCURLY, LCURLY226, new ArrayList<expr>(), new ArrayList<expr>()), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }

                    RCURLY228=(Token)match(input,RCURLY,FOLLOW_RCURLY_in_atom6046); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RCURLY.add(RCURLY228);


                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1362:8: lb= BACKQUOTE testlist[expr_contextType.Load] rb= BACKQUOTE
                    {
                    lb=(Token)match(input,BACKQUOTE,FOLLOW_BACKQUOTE_in_atom6057); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BACKQUOTE.add(lb);

                    pushFollow(FOLLOW_testlist_in_atom6059);
                    testlist229=testlist(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_testlist.add(testlist229.getTree());
                    rb=(Token)match(input,BACKQUOTE,FOLLOW_BACKQUOTE_in_atom6064); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_BACKQUOTE.add(rb);



                    // AST REWRITE
                    // elements: BACKQUOTE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1363:5: -> ^( BACKQUOTE[$lb, actions.castExpr($testlist.tree)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1363:8: ^( BACKQUOTE[$lb, actions.castExpr($testlist.tree)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Repr(BACKQUOTE, lb, actions.castExpr((testlist229!=null?((PythonTree)testlist229.tree):null))), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1364:8: NAME
                    {
                    NAME230=(Token)match(input,NAME,FOLLOW_NAME_in_atom6087); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NAME.add(NAME230);



                    // AST REWRITE
                    // elements: NAME
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1365:5: -> ^( NAME[$NAME, $NAME.text, $expr::ctype] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1365:8: ^( NAME[$NAME, $NAME.text, $expr::ctype] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Name(NAME, NAME230, (NAME230!=null?NAME230.getText():null), ((expr_scope)expr_stack.peek()).ctype), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1366:8: INT
                    {
                    INT231=(Token)match(input,INT,FOLLOW_INT_in_atom6110); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT231);



                    // AST REWRITE
                    // elements: INT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1367:5: -> ^( INT[$INT, actions.makeInt($INT)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1367:8: ^( INT[$INT, actions.makeInt($INT)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Num(INT, INT231, actions.makeInt(INT231)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1368:8: LONGINT
                    {
                    LONGINT232=(Token)match(input,LONGINT,FOLLOW_LONGINT_in_atom6133); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LONGINT.add(LONGINT232);



                    // AST REWRITE
                    // elements: LONGINT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1369:5: -> ^( LONGINT[$LONGINT, actions.makeInt($LONGINT)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1369:8: ^( LONGINT[$LONGINT, actions.makeInt($LONGINT)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Num(LONGINT, LONGINT232, actions.makeInt(LONGINT232)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1370:8: FLOAT
                    {
                    FLOAT233=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atom6156); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FLOAT.add(FLOAT233);



                    // AST REWRITE
                    // elements: FLOAT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1371:5: -> ^( FLOAT[$FLOAT, actions.makeFloat($FLOAT)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1371:8: ^( FLOAT[$FLOAT, actions.makeFloat($FLOAT)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Num(FLOAT, FLOAT233, actions.makeFloat(FLOAT233)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1372:8: COMPLEX
                    {
                    COMPLEX234=(Token)match(input,COMPLEX,FOLLOW_COMPLEX_in_atom6179); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COMPLEX.add(COMPLEX234);



                    // AST REWRITE
                    // elements: COMPLEX
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1373:5: -> ^( COMPLEX[$COMPLEX, actions.makeComplex($COMPLEX)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1373:8: ^( COMPLEX[$COMPLEX, actions.makeComplex($COMPLEX)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Num(COMPLEX, COMPLEX234, actions.makeComplex(COMPLEX234)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1374:8: (S+= STRING )+
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1374:8: (S+= STRING )+
                    int cnt109=0;
                    loop109:
                    do {
                        int alt109=2;
                        int LA109_0 = input.LA(1);

                        if ( (LA109_0==STRING) ) {
                            alt109=1;
                        }


                        switch (alt109) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1374:9: S+= STRING
                    	    {
                    	    S=(Token)match(input,STRING,FOLLOW_STRING_in_atom6205); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_STRING.add(S);

                    	    if (list_S==null) list_S=new ArrayList();
                    	    list_S.add(S);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt109 >= 1 ) break loop109;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(109, input);
                                throw eee;
                        }
                        cnt109++;
                    } while (true);



                    // AST REWRITE
                    // elements: STRING
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1375:5: -> ^( STRING[actions.extractStringToken($S), actions.extractStrings($S, encoding)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1375:8: ^( STRING[actions.extractStringToken($S), actions.extractStrings($S, encoding)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Str(STRING, actions.extractStringToken(list_S), actions.extractStrings(list_S, encoding)), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class listmaker_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listmaker"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1379:1: listmaker[Token lbrack] : t+= test[$expr::ctype] ( list_for[gens] | ( options {greedy=true; } : COMMA t+= test[$expr::ctype] )* ) ( COMMA )? ;
    public final PythonParser.listmaker_return listmaker(Token lbrack) throws RecognitionException {
        PythonParser.listmaker_return retval = new PythonParser.listmaker_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA236=null;
        Token COMMA237=null;
        List list_t=null;
        PythonParser.list_for_return list_for235 = null;

        PythonParser.test_return t = null;
         t = null;
        PythonTree COMMA236_tree=null;
        PythonTree COMMA237_tree=null;


            List gens = new ArrayList();
            expr etype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1387:5: (t+= test[$expr::ctype] ( list_for[gens] | ( options {greedy=true; } : COMMA t+= test[$expr::ctype] )* ) ( COMMA )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1387:7: t+= test[$expr::ctype] ( list_for[gens] | ( options {greedy=true; } : COMMA t+= test[$expr::ctype] )* ) ( COMMA )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_test_in_listmaker6253);
            t=test(((expr_scope)expr_stack.peek()).ctype);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
            if (list_t==null) list_t=new ArrayList();
            list_t.add(t.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1388:9: ( list_for[gens] | ( options {greedy=true; } : COMMA t+= test[$expr::ctype] )* )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==FOR) ) {
                alt112=1;
            }
            else if ( (LA112_0==COMMA||LA112_0==RBRACK) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1388:10: list_for[gens]
                    {
                    pushFollow(FOLLOW_list_for_in_listmaker6265);
                    list_for235=list_for(gens);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, list_for235.getTree());
                    if ( state.backtracking==0 ) {

                                   Collections.reverse(gens);
                                   List<comprehension> c = gens;
                                   etype = new ListComp(((Token)retval.start), actions.castExpr(list_t.get(0)), c);
                               
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1394:11: ( options {greedy=true; } : COMMA t+= test[$expr::ctype] )*
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1394:11: ( options {greedy=true; } : COMMA t+= test[$expr::ctype] )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==COMMA) ) {
                            int LA111_1 = input.LA(2);

                            if ( (LA111_1==NAME||(LA111_1>=LAMBDA && LA111_1<=NOT)||LA111_1==LPAREN||(LA111_1>=PLUS && LA111_1<=MINUS)||(LA111_1>=TILDE && LA111_1<=LBRACK)||LA111_1==LCURLY||(LA111_1>=BACKQUOTE && LA111_1<=STRING)) ) {
                                alt111=1;
                            }


                        }


                        switch (alt111) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1394:35: COMMA t+= test[$expr::ctype]
                    	    {
                    	    COMMA236=(Token)match(input,COMMA,FOLLOW_COMMA_in_listmaker6297); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA236_tree = (PythonTree)adaptor.create(COMMA236);
                    	    adaptor.addChild(root_0, COMMA236_tree);
                    	    }
                    	    pushFollow(FOLLOW_test_in_listmaker6301);
                    	    t=test(((expr_scope)expr_stack.peek()).ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());
                    	    if (list_t==null) list_t=new ArrayList();
                    	    list_t.add(t.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop111;
                        }
                    } while (true);

                    if ( state.backtracking==0 ) {

                                     etype = new org.python.antlr.ast.List(lbrack, actions.castExprs(list_t), ((expr_scope)expr_stack.peek()).ctype);
                                 
                    }

                    }
                    break;

            }

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1398:11: ( COMMA )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==COMMA) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1398:12: COMMA
                    {
                    COMMA237=(Token)match(input,COMMA,FOLLOW_COMMA_in_listmaker6330); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA237_tree = (PythonTree)adaptor.create(COMMA237);
                    adaptor.addChild(root_0, COMMA237_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = etype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listmaker"

    public static class testlist_gexp_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "testlist_gexp"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1402:1: testlist_gexp : t+= test[$expr::ctype] ( ( ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )? -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] ) -> test ) | ( gen_for[gens] ) ) ;
    public final PythonParser.testlist_gexp_return testlist_gexp() throws RecognitionException {
        PythonParser.testlist_gexp_return retval = new PythonParser.testlist_gexp_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token c1=null;
        Token c2=null;
        List list_t=null;
        PythonParser.gen_for_return gen_for238 = null;

        PythonParser.test_return t = null;
         t = null;
        PythonTree c1_tree=null;
        PythonTree c2_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        RewriteRuleSubtreeStream stream_gen_for=new RewriteRuleSubtreeStream(adaptor,"rule gen_for");

            expr etype = null;
            List gens = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1412:5: (t+= test[$expr::ctype] ( ( ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )? -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] ) -> test ) | ( gen_for[gens] ) ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1412:7: t+= test[$expr::ctype] ( ( ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )? -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] ) -> test ) | ( gen_for[gens] ) )
            {
            pushFollow(FOLLOW_test_in_testlist_gexp6362);
            t=test(((expr_scope)expr_stack.peek()).ctype);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_test.add(t.getTree());
            if (list_t==null) list_t=new ArrayList();
            list_t.add(t.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:9: ( ( ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )? -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] ) -> test ) | ( gen_for[gens] ) )
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==RPAREN||LA116_0==COMMA) ) {
                alt116=1;
            }
            else if ( (LA116_0==FOR) ) {
                alt116=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }
            switch (alt116) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:11: ( ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )? -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] ) -> test )
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:11: ( ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )? -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] ) -> test )
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:12: ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )* (c2= COMMA )?
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:12: ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )*
                    loop114:
                    do {
                        int alt114=2;
                        alt114 = dfa114.predict(input);
                        switch (alt114) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:29: c1= COMMA t+= test[$expr::ctype]
                    	    {
                    	    c1=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist_gexp6387); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(c1);

                    	    pushFollow(FOLLOW_test_in_testlist_gexp6391);
                    	    t=test(((expr_scope)expr_stack.peek()).ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_test.add(t.getTree());
                    	    if (list_t==null) list_t=new ArrayList();
                    	    list_t.add(t.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop114;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:62: (c2= COMMA )?
                    int alt115=2;
                    int LA115_0 = input.LA(1);

                    if ( (LA115_0==COMMA) ) {
                        alt115=1;
                    }
                    switch (alt115) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1413:63: c2= COMMA
                            {
                            c2=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist_gexp6399); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(c2);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: test, COMMA
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1414:10: -> { $c1 != null || $c2 != null }? ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] )
                    if ( c1 != null || c2 != null ) {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1415:17: ^( COMMA[$testlist_gexp.start, actions.castExprs($t), $expr::ctype] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Tuple(COMMA, ((Token)retval.start), actions.castExprs(list_t), ((expr_scope)expr_stack.peek()).ctype), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }
                    else // 1416:10: -> test
                    {
                        adaptor.addChild(root_0, stream_test.nextTree());

                    }

                    retval.tree = root_0;}
                    }


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1418:11: ( gen_for[gens] )
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1418:11: ( gen_for[gens] )
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1418:12: gen_for[gens]
                    {
                    pushFollow(FOLLOW_gen_for_in_testlist_gexp6476);
                    gen_for238=gen_for(gens);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_gen_for.add(gen_for238.getTree());
                    if ( state.backtracking==0 ) {

                                     Collections.reverse(gens);
                                     List<comprehension> c = gens;
                                     expr e = actions.castExpr(list_t.get(0));
                                     if (e instanceof Context) {
                                         ((Context)e).setContext(expr_contextType.Load);
                                     }
                                     etype = new GeneratorExp(((Token)retval.start), actions.castExpr(list_t.get(0)), c);
                                 
                    }

                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (etype != null) {
                      retval.tree = etype;
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "testlist_gexp"

    public static class lambdef_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lambdef"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1433:1: lambdef : LAMBDA ( varargslist )? COLON test[expr_contextType.Load] ;
    public final PythonParser.lambdef_return lambdef() throws RecognitionException {
        PythonParser.lambdef_return retval = new PythonParser.lambdef_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token LAMBDA239=null;
        Token COLON241=null;
        PythonParser.varargslist_return varargslist240 = null;

        PythonParser.test_return test242 = null;


        PythonTree LAMBDA239_tree=null;
        PythonTree COLON241_tree=null;


            expr etype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1440:5: ( LAMBDA ( varargslist )? COLON test[expr_contextType.Load] )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1440:7: LAMBDA ( varargslist )? COLON test[expr_contextType.Load]
            {
            root_0 = (PythonTree)adaptor.nil();

            LAMBDA239=(Token)match(input,LAMBDA,FOLLOW_LAMBDA_in_lambdef6540); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            LAMBDA239_tree = (PythonTree)adaptor.create(LAMBDA239);
            adaptor.addChild(root_0, LAMBDA239_tree);
            }
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1440:14: ( varargslist )?
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==NAME||LA117_0==LPAREN||(LA117_0>=STAR && LA117_0<=DOUBLESTAR)) ) {
                alt117=1;
            }
            switch (alt117) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1440:15: varargslist
                    {
                    pushFollow(FOLLOW_varargslist_in_lambdef6543);
                    varargslist240=varargslist();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, varargslist240.getTree());

                    }
                    break;

            }

            COLON241=(Token)match(input,COLON,FOLLOW_COLON_in_lambdef6547); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON241_tree = (PythonTree)adaptor.create(COLON241);
            adaptor.addChild(root_0, COLON241_tree);
            }
            pushFollow(FOLLOW_test_in_lambdef6549);
            test242=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test242.getTree());
            if ( state.backtracking==0 ) {

                        arguments a = (varargslist240!=null?varargslist240.args:null);
                        if (a == null) {
                            a = new arguments(LAMBDA239, new ArrayList<expr>(), null, null, new ArrayList<expr>());
                        }
                        etype = new Lambda(LAMBDA239, a, actions.castExpr((test242!=null?((PythonTree)test242.tree):null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  retval.tree = etype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "lambdef"

    public static class trailer_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "trailer"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1451:1: trailer[Token begin, PythonTree tree] : ( LPAREN ( arglist -> ^( LPAREN[$begin, actions.castExpr($tree), actions.castExprs($arglist.args),\n actions.makeKeywords($arglist.keywords), $arglist.starargs, $arglist.kwargs] ) | -> ^( LPAREN[$begin, actions.castExpr($tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null] ) ) RPAREN | LBRACK subscriptlist[$begin] RBRACK -> ^( LBRACK[$begin, actions.castExpr($tree), actions.castSlice($subscriptlist.tree), $expr::ctype] ) | DOT attr -> ^( DOT[$begin, actions.castExpr($tree), $attr.text, $expr::ctype] ) );
    public final PythonParser.trailer_return trailer(Token begin, PythonTree tree) throws RecognitionException {
        PythonParser.trailer_return retval = new PythonParser.trailer_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token LPAREN243=null;
        Token RPAREN245=null;
        Token LBRACK246=null;
        Token RBRACK248=null;
        Token DOT249=null;
        PythonParser.arglist_return arglist244 = null;

        PythonParser.subscriptlist_return subscriptlist247 = null;

        PythonParser.attr_return attr250 = null;


        PythonTree LPAREN243_tree=null;
        PythonTree RPAREN245_tree=null;
        PythonTree LBRACK246_tree=null;
        PythonTree RBRACK248_tree=null;
        PythonTree DOT249_tree=null;
        RewriteRuleTokenStream stream_RBRACK=new RewriteRuleTokenStream(adaptor,"token RBRACK");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LBRACK=new RewriteRuleTokenStream(adaptor,"token LBRACK");
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_arglist=new RewriteRuleSubtreeStream(adaptor,"rule arglist");
        RewriteRuleSubtreeStream stream_subscriptlist=new RewriteRuleSubtreeStream(adaptor,"rule subscriptlist");
        RewriteRuleSubtreeStream stream_attr=new RewriteRuleSubtreeStream(adaptor,"rule attr");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1452:5: ( LPAREN ( arglist -> ^( LPAREN[$begin, actions.castExpr($tree), actions.castExprs($arglist.args),\n actions.makeKeywords($arglist.keywords), $arglist.starargs, $arglist.kwargs] ) | -> ^( LPAREN[$begin, actions.castExpr($tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null] ) ) RPAREN | LBRACK subscriptlist[$begin] RBRACK -> ^( LBRACK[$begin, actions.castExpr($tree), actions.castSlice($subscriptlist.tree), $expr::ctype] ) | DOT attr -> ^( DOT[$begin, actions.castExpr($tree), $attr.text, $expr::ctype] ) )
            int alt119=3;
            switch ( input.LA(1) ) {
            case LPAREN:
                {
                alt119=1;
                }
                break;
            case LBRACK:
                {
                alt119=2;
                }
                break;
            case DOT:
                {
                alt119=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1452:7: LPAREN ( arglist -> ^( LPAREN[$begin, actions.castExpr($tree), actions.castExprs($arglist.args),\n actions.makeKeywords($arglist.keywords), $arglist.starargs, $arglist.kwargs] ) | -> ^( LPAREN[$begin, actions.castExpr($tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null] ) ) RPAREN
                    {
                    LPAREN243=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_trailer6578); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN243);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1453:9: ( arglist -> ^( LPAREN[$begin, actions.castExpr($tree), actions.castExprs($arglist.args),\n actions.makeKeywords($arglist.keywords), $arglist.starargs, $arglist.kwargs] ) | -> ^( LPAREN[$begin, actions.castExpr($tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null] ) )
                    int alt118=2;
                    int LA118_0 = input.LA(1);

                    if ( (LA118_0==NAME||(LA118_0>=LAMBDA && LA118_0<=NOT)||LA118_0==LPAREN||(LA118_0>=STAR && LA118_0<=DOUBLESTAR)||(LA118_0>=PLUS && LA118_0<=MINUS)||(LA118_0>=TILDE && LA118_0<=LBRACK)||LA118_0==LCURLY||(LA118_0>=BACKQUOTE && LA118_0<=STRING)) ) {
                        alt118=1;
                    }
                    else if ( (LA118_0==RPAREN) ) {
                        alt118=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 118, 0, input);

                        throw nvae;
                    }
                    switch (alt118) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1453:10: arglist
                            {
                            pushFollow(FOLLOW_arglist_in_trailer6589);
                            arglist244=arglist();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_arglist.add(arglist244.getTree());


                            // AST REWRITE
                            // elements: LPAREN
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1454:8: -> ^( LPAREN[$begin, actions.castExpr($tree), actions.castExprs($arglist.args),\n actions.makeKeywords($arglist.keywords), $arglist.starargs, $arglist.kwargs] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1454:11: ^( LPAREN[$begin, actions.castExpr($tree), actions.castExprs($arglist.args),\n actions.makeKeywords($arglist.keywords), $arglist.starargs, $arglist.kwargs] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Call(LPAREN, begin, actions.castExpr(tree), actions.castExprs((arglist244!=null?arglist244.args:null)), actions.makeKeywords((arglist244!=null?arglist244.keywords:null)), (arglist244!=null?arglist244.starargs:null), (arglist244!=null?arglist244.kwargs:null)), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;
                        case 2 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1457:8: 
                            {

                            // AST REWRITE
                            // elements: LPAREN
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            if ( state.backtracking==0 ) {
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (PythonTree)adaptor.nil();
                            // 1457:8: -> ^( LPAREN[$begin, actions.castExpr($tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null] )
                            {
                                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1457:11: ^( LPAREN[$begin, actions.castExpr($tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null] )
                                {
                                PythonTree root_1 = (PythonTree)adaptor.nil();
                                root_1 = (PythonTree)adaptor.becomeRoot(new Call(LPAREN, begin, actions.castExpr(tree), new ArrayList<expr>(), new ArrayList<keyword>(), null, null), root_1);

                                adaptor.addChild(root_0, root_1);
                                }

                            }

                            retval.tree = root_0;}
                            }
                            break;

                    }

                    RPAREN245=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_trailer6651); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN245);


                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1460:7: LBRACK subscriptlist[$begin] RBRACK
                    {
                    LBRACK246=(Token)match(input,LBRACK,FOLLOW_LBRACK_in_trailer6659); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACK.add(LBRACK246);

                    pushFollow(FOLLOW_subscriptlist_in_trailer6661);
                    subscriptlist247=subscriptlist(begin);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_subscriptlist.add(subscriptlist247.getTree());
                    RBRACK248=(Token)match(input,RBRACK,FOLLOW_RBRACK_in_trailer6664); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACK.add(RBRACK248);



                    // AST REWRITE
                    // elements: LBRACK
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1461:4: -> ^( LBRACK[$begin, actions.castExpr($tree), actions.castSlice($subscriptlist.tree), $expr::ctype] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1461:7: ^( LBRACK[$begin, actions.castExpr($tree), actions.castSlice($subscriptlist.tree), $expr::ctype] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Subscript(LBRACK, begin, actions.castExpr(tree), actions.castSlice((subscriptlist247!=null?((PythonTree)subscriptlist247.tree):null)), ((expr_scope)expr_stack.peek()).ctype), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1462:7: DOT attr
                    {
                    DOT249=(Token)match(input,DOT,FOLLOW_DOT_in_trailer6685); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT249);

                    pushFollow(FOLLOW_attr_in_trailer6687);
                    attr250=attr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_attr.add(attr250.getTree());


                    // AST REWRITE
                    // elements: DOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1463:4: -> ^( DOT[$begin, actions.castExpr($tree), $attr.text, $expr::ctype] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1463:7: ^( DOT[$begin, actions.castExpr($tree), $attr.text, $expr::ctype] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Attribute(DOT, begin, actions.castExpr(tree), (attr250!=null?input.toString(attr250.start,attr250.stop):null), ((expr_scope)expr_stack.peek()).ctype), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "trailer"

    public static class subscriptlist_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subscriptlist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1467:1: subscriptlist[Token begin] : sub+= subscript ( options {greedy=true; } : c1= COMMA sub+= subscript )* (c2= COMMA )? ;
    public final PythonParser.subscriptlist_return subscriptlist(Token begin) throws RecognitionException {
        PythonParser.subscriptlist_return retval = new PythonParser.subscriptlist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token c1=null;
        Token c2=null;
        List list_sub=null;
        PythonParser.subscript_return sub = null;
         sub = null;
        PythonTree c1_tree=null;
        PythonTree c2_tree=null;


            slice sltype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1474:5: (sub+= subscript ( options {greedy=true; } : c1= COMMA sub+= subscript )* (c2= COMMA )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1474:7: sub+= subscript ( options {greedy=true; } : c1= COMMA sub+= subscript )* (c2= COMMA )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_subscript_in_subscriptlist6731);
            sub=subscript();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, sub.getTree());
            if (list_sub==null) list_sub=new ArrayList();
            list_sub.add(sub.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1474:22: ( options {greedy=true; } : c1= COMMA sub+= subscript )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==COMMA) ) {
                    int LA120_1 = input.LA(2);

                    if ( ((LA120_1>=NAME && LA120_1<=DOT)||(LA120_1>=LAMBDA && LA120_1<=NOT)||LA120_1==LPAREN||LA120_1==COLON||(LA120_1>=PLUS && LA120_1<=MINUS)||(LA120_1>=TILDE && LA120_1<=LBRACK)||LA120_1==LCURLY||(LA120_1>=BACKQUOTE && LA120_1<=STRING)) ) {
                        alt120=1;
                    }


                }


                switch (alt120) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1474:46: c1= COMMA sub+= subscript
            	    {
            	    c1=(Token)match(input,COMMA,FOLLOW_COMMA_in_subscriptlist6743); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    c1_tree = (PythonTree)adaptor.create(c1);
            	    adaptor.addChild(root_0, c1_tree);
            	    }
            	    pushFollow(FOLLOW_subscript_in_subscriptlist6747);
            	    sub=subscript();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, sub.getTree());
            	    if (list_sub==null) list_sub=new ArrayList();
            	    list_sub.add(sub.getTree());


            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1474:72: (c2= COMMA )?
            int alt121=2;
            int LA121_0 = input.LA(1);

            if ( (LA121_0==COMMA) ) {
                alt121=1;
            }
            switch (alt121) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1474:73: c2= COMMA
                    {
                    c2=(Token)match(input,COMMA,FOLLOW_COMMA_in_subscriptlist6754); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c2_tree = (PythonTree)adaptor.create(c2);
                    adaptor.addChild(root_0, c2_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        sltype = actions.makeSliceType(begin, c1, c2, list_sub);
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = sltype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subscriptlist"

    public static class subscript_return extends ParserRuleReturnScope {
        public slice sltype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "subscript"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1481:1: subscript returns [slice sltype] : (d1= DOT DOT DOT -> DOT[$d1] | ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )? | ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )? | test[expr_contextType.Load] -> ^( LPAREN[$test.start, actions.castExpr($test.tree)] ) );
    public final PythonParser.subscript_return subscript() throws RecognitionException {
        PythonParser.subscript_return retval = new PythonParser.subscript_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token d1=null;
        Token c1=null;
        Token c2=null;
        Token DOT251=null;
        Token DOT252=null;
        PythonParser.test_return lower = null;

        PythonParser.test_return upper1 = null;

        PythonParser.test_return upper2 = null;

        PythonParser.sliceop_return sliceop253 = null;

        PythonParser.sliceop_return sliceop254 = null;

        PythonParser.test_return test255 = null;


        PythonTree d1_tree=null;
        PythonTree c1_tree=null;
        PythonTree c2_tree=null;
        PythonTree DOT251_tree=null;
        PythonTree DOT252_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1488:5: (d1= DOT DOT DOT -> DOT[$d1] | ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )? | ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )? | test[expr_contextType.Load] -> ^( LPAREN[$test.start, actions.castExpr($test.tree)] ) )
            int alt127=4;
            alt127 = dfa127.predict(input);
            switch (alt127) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1488:7: d1= DOT DOT DOT
                    {
                    d1=(Token)match(input,DOT,FOLLOW_DOT_in_subscript6797); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(d1);

                    DOT251=(Token)match(input,DOT,FOLLOW_DOT_in_subscript6799); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT251);

                    DOT252=(Token)match(input,DOT,FOLLOW_DOT_in_subscript6801); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DOT.add(DOT252);



                    // AST REWRITE
                    // elements: DOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1489:4: -> DOT[$d1]
                    {
                        adaptor.addChild(root_0, new Ellipsis(DOT, d1));

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1490:7: ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_test_in_subscript6834);
                    lower=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lower.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1491:41: (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )?
                    int alt124=2;
                    int LA124_0 = input.LA(1);

                    if ( (LA124_0==COLON) ) {
                        alt124=1;
                    }
                    switch (alt124) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1491:42: c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )?
                            {
                            c1=(Token)match(input,COLON,FOLLOW_COLON_in_subscript6840); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            c1_tree = (PythonTree)adaptor.create(c1);
                            adaptor.addChild(root_0, c1_tree);
                            }
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1491:51: (upper1= test[expr_contextType.Load] )?
                            int alt122=2;
                            int LA122_0 = input.LA(1);

                            if ( (LA122_0==NAME||(LA122_0>=LAMBDA && LA122_0<=NOT)||LA122_0==LPAREN||(LA122_0>=PLUS && LA122_0<=MINUS)||(LA122_0>=TILDE && LA122_0<=LBRACK)||LA122_0==LCURLY||(LA122_0>=BACKQUOTE && LA122_0<=STRING)) ) {
                                alt122=1;
                            }
                            switch (alt122) {
                                case 1 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1491:52: upper1= test[expr_contextType.Load]
                                    {
                                    pushFollow(FOLLOW_test_in_subscript6845);
                                    upper1=test(expr_contextType.Load);

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, upper1.getTree());

                                    }
                                    break;

                            }

                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1491:89: ( sliceop )?
                            int alt123=2;
                            int LA123_0 = input.LA(1);

                            if ( (LA123_0==COLON) ) {
                                alt123=1;
                            }
                            switch (alt123) {
                                case 1 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1491:90: sliceop
                                    {
                                    pushFollow(FOLLOW_sliceop_in_subscript6851);
                                    sliceop253=sliceop();

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sliceop253.getTree());

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                              retval.sltype = actions.makeSubscript((lower!=null?((PythonTree)lower.tree):null), c1, (upper1!=null?((PythonTree)upper1.tree):null), (sliceop253!=null?((PythonTree)sliceop253.tree):null));
                            
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1495:7: ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    c2=(Token)match(input,COLON,FOLLOW_COLON_in_subscript6882); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    c2_tree = (PythonTree)adaptor.create(c2);
                    adaptor.addChild(root_0, c2_tree);
                    }
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1496:16: (upper2= test[expr_contextType.Load] )?
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==NAME||(LA125_0>=LAMBDA && LA125_0<=NOT)||LA125_0==LPAREN||(LA125_0>=PLUS && LA125_0<=MINUS)||(LA125_0>=TILDE && LA125_0<=LBRACK)||LA125_0==LCURLY||(LA125_0>=BACKQUOTE && LA125_0<=STRING)) ) {
                        alt125=1;
                    }
                    switch (alt125) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1496:17: upper2= test[expr_contextType.Load]
                            {
                            pushFollow(FOLLOW_test_in_subscript6887);
                            upper2=test(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, upper2.getTree());

                            }
                            break;

                    }

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1496:54: ( sliceop )?
                    int alt126=2;
                    int LA126_0 = input.LA(1);

                    if ( (LA126_0==COLON) ) {
                        alt126=1;
                    }
                    switch (alt126) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1496:55: sliceop
                            {
                            pushFollow(FOLLOW_sliceop_in_subscript6893);
                            sliceop254=sliceop();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, sliceop254.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                retval.sltype = actions.makeSubscript(null, c2, (upper2!=null?((PythonTree)upper2.tree):null), (sliceop254!=null?((PythonTree)sliceop254.tree):null));
                            
                    }

                    }
                    break;
                case 4 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1500:7: test[expr_contextType.Load]
                    {
                    pushFollow(FOLLOW_test_in_subscript6911);
                    test255=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(test255.getTree());


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1501:4: -> ^( LPAREN[$test.start, actions.castExpr($test.tree)] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1501:7: ^( LPAREN[$test.start, actions.castExpr($test.tree)] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Index(LPAREN, (test255!=null?((Token)test255.start):null), actions.castExpr((test255!=null?((PythonTree)test255.tree):null))), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                  if (retval.sltype != null) {
                      retval.tree = retval.sltype;
                  }

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "subscript"

    public static class sliceop_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sliceop"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1505:1: sliceop : COLON ( test[expr_contextType.Load] -> test | -> ^( COLON[$COLON, \"None\", expr_contextType.Load] ) ) ;
    public final PythonParser.sliceop_return sliceop() throws RecognitionException {
        PythonParser.sliceop_return retval = new PythonParser.sliceop_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COLON256=null;
        PythonParser.test_return test257 = null;


        PythonTree COLON256_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1506:5: ( COLON ( test[expr_contextType.Load] -> test | -> ^( COLON[$COLON, \"None\", expr_contextType.Load] ) ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1506:7: COLON ( test[expr_contextType.Load] -> test | -> ^( COLON[$COLON, \"None\", expr_contextType.Load] ) )
            {
            COLON256=(Token)match(input,COLON,FOLLOW_COLON_in_sliceop6943); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLON.add(COLON256);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1507:6: ( test[expr_contextType.Load] -> test | -> ^( COLON[$COLON, \"None\", expr_contextType.Load] ) )
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==NAME||(LA128_0>=LAMBDA && LA128_0<=NOT)||LA128_0==LPAREN||(LA128_0>=PLUS && LA128_0<=MINUS)||(LA128_0>=TILDE && LA128_0<=LBRACK)||LA128_0==LCURLY||(LA128_0>=BACKQUOTE && LA128_0<=STRING)) ) {
                alt128=1;
            }
            else if ( (LA128_0==COMMA||LA128_0==RBRACK) ) {
                alt128=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 128, 0, input);

                throw nvae;
            }
            switch (alt128) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1507:7: test[expr_contextType.Load]
                    {
                    pushFollow(FOLLOW_test_in_sliceop6951);
                    test257=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(test257.getTree());


                    // AST REWRITE
                    // elements: test
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1508:5: -> test
                    {
                        adaptor.addChild(root_0, stream_test.nextTree());

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1510:5: 
                    {

                    // AST REWRITE
                    // elements: COLON
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1510:5: -> ^( COLON[$COLON, \"None\", expr_contextType.Load] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1510:8: ^( COLON[$COLON, \"None\", expr_contextType.Load] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Name(COLON, COLON256, "None", expr_contextType.Load), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sliceop"

    public static class exprlist_return extends ParserRuleReturnScope {
        public expr etype;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exprlist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1515:1: exprlist[expr_contextType ctype] returns [expr etype] : ( ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )? | expr[ctype] );
    public final PythonParser.exprlist_return exprlist(expr_contextType ctype) throws RecognitionException {
        PythonParser.exprlist_return retval = new PythonParser.exprlist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA258=null;
        Token COMMA259=null;
        List list_e=null;
        PythonParser.expr_return expr260 = null;

        PythonParser.expr_return e = null;
         e = null;
        PythonTree COMMA258_tree=null;
        PythonTree COMMA259_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:5: ( ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )? | expr[ctype] )
            int alt131=2;
            alt131 = dfa131.predict(input);
            switch (alt131) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:7: ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_exprlist7027);
                    e=expr(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
                    if (list_e==null) list_e=new ArrayList();
                    list_e.add(e.getTree());

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:44: ( options {k=2; } : COMMA e+= expr[ctype] )*
                    loop129:
                    do {
                        int alt129=2;
                        alt129 = dfa129.predict(input);
                        switch (alt129) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:61: COMMA e+= expr[ctype]
                    	    {
                    	    COMMA258=(Token)match(input,COMMA,FOLLOW_COMMA_in_exprlist7039); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA258_tree = (PythonTree)adaptor.create(COMMA258);
                    	    adaptor.addChild(root_0, COMMA258_tree);
                    	    }
                    	    pushFollow(FOLLOW_expr_in_exprlist7043);
                    	    e=expr(ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
                    	    if (list_e==null) list_e=new ArrayList();
                    	    list_e.add(e.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop129;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:84: ( COMMA )?
                    int alt130=2;
                    int LA130_0 = input.LA(1);

                    if ( (LA130_0==COMMA) ) {
                        alt130=1;
                    }
                    switch (alt130) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:85: COMMA
                            {
                            COMMA259=(Token)match(input,COMMA,FOLLOW_COMMA_in_exprlist7049); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA259_tree = (PythonTree)adaptor.create(COMMA259);
                            adaptor.addChild(root_0, COMMA259_tree);
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                 retval.etype = new Tuple(((Token)retval.start), actions.castExprs(list_e), ctype);
                             
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1521:7: expr[ctype]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_expr_in_exprlist7068);
                    expr260=expr(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, expr260.getTree());
                    if ( state.backtracking==0 ) {

                              retval.etype = actions.castExpr((expr260!=null?((PythonTree)expr260.tree):null));
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exprlist"

    public static class del_list_return extends ParserRuleReturnScope {
        public List<expr> etypes;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "del_list"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1529:1: del_list returns [List<expr> etypes] : e+= expr[expr_contextType.Del] ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )* ( COMMA )? ;
    public final PythonParser.del_list_return del_list() throws RecognitionException {
        PythonParser.del_list_return retval = new PythonParser.del_list_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA261=null;
        Token COMMA262=null;
        List list_e=null;
        PythonParser.expr_return e = null;
         e = null;
        PythonTree COMMA261_tree=null;
        PythonTree COMMA262_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1531:5: (e+= expr[expr_contextType.Del] ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )* ( COMMA )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1531:7: e+= expr[expr_contextType.Del] ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )* ( COMMA )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_expr_in_del_list7106);
            e=expr(expr_contextType.Del);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if (list_e==null) list_e=new ArrayList();
            list_e.add(e.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1531:37: ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )*
            loop132:
            do {
                int alt132=2;
                alt132 = dfa132.predict(input);
                switch (alt132) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1531:54: COMMA e+= expr[expr_contextType.Del]
            	    {
            	    COMMA261=(Token)match(input,COMMA,FOLLOW_COMMA_in_del_list7118); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA261_tree = (PythonTree)adaptor.create(COMMA261);
            	    adaptor.addChild(root_0, COMMA261_tree);
            	    }
            	    pushFollow(FOLLOW_expr_in_del_list7122);
            	    e=expr(expr_contextType.Del);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            	    if (list_e==null) list_e=new ArrayList();
            	    list_e.add(e.getTree());


            	    }
            	    break;

            	default :
            	    break loop132;
                }
            } while (true);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1531:92: ( COMMA )?
            int alt133=2;
            int LA133_0 = input.LA(1);

            if ( (LA133_0==COMMA) ) {
                alt133=1;
            }
            switch (alt133) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1531:93: COMMA
                    {
                    COMMA262=(Token)match(input,COMMA,FOLLOW_COMMA_in_del_list7128); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA262_tree = (PythonTree)adaptor.create(COMMA262);
                    adaptor.addChild(root_0, COMMA262_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        retval.etypes = actions.makeDeleteList(list_e);
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "del_list"

    public static class testlist_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "testlist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1538:1: testlist[expr_contextType ctype] : ( ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )? -> ^( COMMA[$testlist.start, actions.castExprs($t), ctype] ) | test[ctype] );
    public final PythonParser.testlist_return testlist(expr_contextType ctype) throws RecognitionException {
        PythonParser.testlist_return retval = new PythonParser.testlist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA263=null;
        Token COMMA264=null;
        List list_t=null;
        PythonParser.test_return test265 = null;

        PythonParser.test_return t = null;
         t = null;
        PythonTree COMMA263_tree=null;
        PythonTree COMMA264_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_test=new RewriteRuleSubtreeStream(adaptor,"rule test");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1539:5: ( ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )? -> ^( COMMA[$testlist.start, actions.castExprs($t), ctype] ) | test[ctype] )
            int alt136=2;
            alt136 = dfa136.predict(input);
            switch (alt136) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1539:7: ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )?
                    {
                    pushFollow(FOLLOW_test_in_testlist7171);
                    t=test(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_test.add(t.getTree());
                    if (list_t==null) list_t=new ArrayList();
                    list_t.add(t.getTree());

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1540:22: ( options {k=2; } : COMMA t+= test[ctype] )*
                    loop134:
                    do {
                        int alt134=2;
                        alt134 = dfa134.predict(input);
                        switch (alt134) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1540:39: COMMA t+= test[ctype]
                    	    {
                    	    COMMA263=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist7183); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA263);

                    	    pushFollow(FOLLOW_test_in_testlist7187);
                    	    t=test(ctype);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_test.add(t.getTree());
                    	    if (list_t==null) list_t=new ArrayList();
                    	    list_t.add(t.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop134;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1540:62: ( COMMA )?
                    int alt135=2;
                    int LA135_0 = input.LA(1);

                    if ( (LA135_0==COMMA) ) {
                        alt135=1;
                    }
                    switch (alt135) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1540:63: COMMA
                            {
                            COMMA264=(Token)match(input,COMMA,FOLLOW_COMMA_in_testlist7193); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_COMMA.add(COMMA264);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: COMMA
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (PythonTree)adaptor.nil();
                    // 1541:4: -> ^( COMMA[$testlist.start, actions.castExprs($t), ctype] )
                    {
                        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1541:7: ^( COMMA[$testlist.start, actions.castExprs($t), ctype] )
                        {
                        PythonTree root_1 = (PythonTree)adaptor.nil();
                        root_1 = (PythonTree)adaptor.becomeRoot(new Tuple(COMMA, ((Token)retval.start), actions.castExprs(list_t), ctype), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1542:7: test[ctype]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_test_in_testlist7216);
                    test265=test(ctype);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, test265.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "testlist"

    public static class dictmaker_return extends ParserRuleReturnScope {
        public List keys;
        public List values;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dictmaker"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1546:1: dictmaker returns [List keys, List values] : k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] ( options {k=2; } : COMMA k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] )* ( COMMA )? ;
    public final PythonParser.dictmaker_return dictmaker() throws RecognitionException {
        PythonParser.dictmaker_return retval = new PythonParser.dictmaker_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COLON266=null;
        Token COMMA267=null;
        Token COLON268=null;
        Token COMMA269=null;
        List list_k=null;
        List list_v=null;
        PythonParser.test_return k = null;
         k = null;
        PythonParser.test_return v = null;
         v = null;
        PythonTree COLON266_tree=null;
        PythonTree COMMA267_tree=null;
        PythonTree COLON268_tree=null;
        PythonTree COMMA269_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1548:5: (k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] ( options {k=2; } : COMMA k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] )* ( COMMA )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1548:7: k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] ( options {k=2; } : COMMA k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] )* ( COMMA )?
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_test_in_dictmaker7245);
            k=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());
            if (list_k==null) list_k=new ArrayList();
            list_k.add(k.getTree());

            COLON266=(Token)match(input,COLON,FOLLOW_COLON_in_dictmaker7248); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON266_tree = (PythonTree)adaptor.create(COLON266);
            adaptor.addChild(root_0, COLON266_tree);
            }
            pushFollow(FOLLOW_test_in_dictmaker7252);
            v=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            if (list_v==null) list_v=new ArrayList();
            list_v.add(v.getTree());

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1549:9: ( options {k=2; } : COMMA k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] )*
            loop137:
            do {
                int alt137=2;
                alt137 = dfa137.predict(input);
                switch (alt137) {
            	case 1 :
            	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1549:25: COMMA k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load]
            	    {
            	    COMMA267=(Token)match(input,COMMA,FOLLOW_COMMA_in_dictmaker7271); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMA267_tree = (PythonTree)adaptor.create(COMMA267);
            	    adaptor.addChild(root_0, COMMA267_tree);
            	    }
            	    pushFollow(FOLLOW_test_in_dictmaker7275);
            	    k=test(expr_contextType.Load);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());
            	    if (list_k==null) list_k=new ArrayList();
            	    list_k.add(k.getTree());

            	    COLON268=(Token)match(input,COLON,FOLLOW_COLON_in_dictmaker7278); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COLON268_tree = (PythonTree)adaptor.create(COLON268);
            	    adaptor.addChild(root_0, COLON268_tree);
            	    }
            	    pushFollow(FOLLOW_test_in_dictmaker7282);
            	    v=test(expr_contextType.Load);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            	    if (list_v==null) list_v=new ArrayList();
            	    list_v.add(v.getTree());


            	    }
            	    break;

            	default :
            	    break loop137;
                }
            } while (true);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1550:9: ( COMMA )?
            int alt138=2;
            int LA138_0 = input.LA(1);

            if ( (LA138_0==COMMA) ) {
                alt138=1;
            }
            switch (alt138) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1550:10: COMMA
                    {
                    COMMA269=(Token)match(input,COMMA,FOLLOW_COMMA_in_dictmaker7296); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA269_tree = (PythonTree)adaptor.create(COMMA269);
                    adaptor.addChild(root_0, COMMA269_tree);
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        retval.keys = list_k;
                        retval.values = list_v;
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dictmaker"

    public static class classdef_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "classdef"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1558:1: classdef : ( decorators )? CLASS NAME ( LPAREN ( testlist[expr_contextType.Load] )? RPAREN )? COLON suite[false] ;
    public final PythonParser.classdef_return classdef() throws RecognitionException {
        PythonParser.classdef_return retval = new PythonParser.classdef_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token CLASS271=null;
        Token NAME272=null;
        Token LPAREN273=null;
        Token RPAREN275=null;
        Token COLON276=null;
        PythonParser.decorators_return decorators270 = null;

        PythonParser.testlist_return testlist274 = null;

        PythonParser.suite_return suite277 = null;


        PythonTree CLASS271_tree=null;
        PythonTree NAME272_tree=null;
        PythonTree LPAREN273_tree=null;
        PythonTree RPAREN275_tree=null;
        PythonTree COLON276_tree=null;


            stmt stype = null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:5: ( ( decorators )? CLASS NAME ( LPAREN ( testlist[expr_contextType.Load] )? RPAREN )? COLON suite[false] )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:7: ( decorators )? CLASS NAME ( LPAREN ( testlist[expr_contextType.Load] )? RPAREN )? COLON suite[false]
            {
            root_0 = (PythonTree)adaptor.nil();

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:7: ( decorators )?
            int alt139=2;
            int LA139_0 = input.LA(1);

            if ( (LA139_0==AT) ) {
                alt139=1;
            }
            switch (alt139) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:7: decorators
                    {
                    pushFollow(FOLLOW_decorators_in_classdef7334);
                    decorators270=decorators();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, decorators270.getTree());

                    }
                    break;

            }

            CLASS271=(Token)match(input,CLASS,FOLLOW_CLASS_in_classdef7337); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            CLASS271_tree = (PythonTree)adaptor.create(CLASS271);
            adaptor.addChild(root_0, CLASS271_tree);
            }
            NAME272=(Token)match(input,NAME,FOLLOW_NAME_in_classdef7339); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NAME272_tree = (PythonTree)adaptor.create(NAME272);
            adaptor.addChild(root_0, NAME272_tree);
            }
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:30: ( LPAREN ( testlist[expr_contextType.Load] )? RPAREN )?
            int alt141=2;
            int LA141_0 = input.LA(1);

            if ( (LA141_0==LPAREN) ) {
                alt141=1;
            }
            switch (alt141) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:31: LPAREN ( testlist[expr_contextType.Load] )? RPAREN
                    {
                    LPAREN273=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_classdef7342); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN273_tree = (PythonTree)adaptor.create(LPAREN273);
                    adaptor.addChild(root_0, LPAREN273_tree);
                    }
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:38: ( testlist[expr_contextType.Load] )?
                    int alt140=2;
                    int LA140_0 = input.LA(1);

                    if ( (LA140_0==NAME||(LA140_0>=LAMBDA && LA140_0<=NOT)||LA140_0==LPAREN||(LA140_0>=PLUS && LA140_0<=MINUS)||(LA140_0>=TILDE && LA140_0<=LBRACK)||LA140_0==LCURLY||(LA140_0>=BACKQUOTE && LA140_0<=STRING)) ) {
                        alt140=1;
                    }
                    switch (alt140) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1565:38: testlist[expr_contextType.Load]
                            {
                            pushFollow(FOLLOW_testlist_in_classdef7344);
                            testlist274=testlist(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist274.getTree());

                            }
                            break;

                    }

                    RPAREN275=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_classdef7348); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN275_tree = (PythonTree)adaptor.create(RPAREN275);
                    adaptor.addChild(root_0, RPAREN275_tree);
                    }

                    }
                    break;

            }

            COLON276=(Token)match(input,COLON,FOLLOW_COLON_in_classdef7352); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            COLON276_tree = (PythonTree)adaptor.create(COLON276);
            adaptor.addChild(root_0, COLON276_tree);
            }
            pushFollow(FOLLOW_suite_in_classdef7354);
            suite277=suite(false);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, suite277.getTree());
            if ( state.backtracking==0 ) {

                        Token t = CLASS271;
                        if ((decorators270!=null?((Token)decorators270.start):null) != null) {
                            t = (decorators270!=null?((Token)decorators270.start):null);
                        }
                        stype = new ClassDef(t, actions.cantBeNone(NAME272),
                            actions.makeBases(actions.castExpr((testlist274!=null?((PythonTree)testlist274.tree):null))),
                            actions.castStmts((suite277!=null?suite277.stypes:null)),
                            actions.castExprs((decorators270!=null?decorators270.etypes:null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

                 retval.tree = stype;

            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "classdef"

    public static class arglist_return extends ParserRuleReturnScope {
        public List args;
        public List keywords;
        public expr starargs;
        public expr kwargs;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arglist"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1579:1: arglist returns [List args, List keywords, expr starargs, expr kwargs] : ( argument[arguments, kws, gens, true] ( COMMA argument[arguments, kws, gens, false] )* ( COMMA ( STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )? )? | STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] );
    public final PythonParser.arglist_return arglist() throws RecognitionException {
        PythonParser.arglist_return retval = new PythonParser.arglist_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token COMMA279=null;
        Token COMMA281=null;
        Token STAR282=null;
        Token COMMA283=null;
        Token DOUBLESTAR284=null;
        Token DOUBLESTAR285=null;
        Token STAR286=null;
        Token COMMA287=null;
        Token DOUBLESTAR288=null;
        Token DOUBLESTAR289=null;
        PythonParser.test_return s = null;

        PythonParser.test_return k = null;

        PythonParser.argument_return argument278 = null;

        PythonParser.argument_return argument280 = null;


        PythonTree COMMA279_tree=null;
        PythonTree COMMA281_tree=null;
        PythonTree STAR282_tree=null;
        PythonTree COMMA283_tree=null;
        PythonTree DOUBLESTAR284_tree=null;
        PythonTree DOUBLESTAR285_tree=null;
        PythonTree STAR286_tree=null;
        PythonTree COMMA287_tree=null;
        PythonTree DOUBLESTAR288_tree=null;
        PythonTree DOUBLESTAR289_tree=null;


            List arguments = new ArrayList();
            List kws = new ArrayList();
            List gens = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1586:5: ( argument[arguments, kws, gens, true] ( COMMA argument[arguments, kws, gens, false] )* ( COMMA ( STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )? )? | STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )
            int alt147=3;
            switch ( input.LA(1) ) {
            case NAME:
            case LAMBDA:
            case NOT:
            case LPAREN:
            case PLUS:
            case MINUS:
            case TILDE:
            case LBRACK:
            case LCURLY:
            case BACKQUOTE:
            case INT:
            case LONGINT:
            case FLOAT:
            case COMPLEX:
            case STRING:
                {
                alt147=1;
                }
                break;
            case STAR:
                {
                alt147=2;
                }
                break;
            case DOUBLESTAR:
                {
                alt147=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 147, 0, input);

                throw nvae;
            }

            switch (alt147) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1586:7: argument[arguments, kws, gens, true] ( COMMA argument[arguments, kws, gens, false] )* ( COMMA ( STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )? )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_argument_in_arglist7394);
                    argument278=argument(arguments, kws, gens, true);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument278.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1586:44: ( COMMA argument[arguments, kws, gens, false] )*
                    loop142:
                    do {
                        int alt142=2;
                        int LA142_0 = input.LA(1);

                        if ( (LA142_0==COMMA) ) {
                            int LA142_1 = input.LA(2);

                            if ( (LA142_1==NAME||(LA142_1>=LAMBDA && LA142_1<=NOT)||LA142_1==LPAREN||(LA142_1>=PLUS && LA142_1<=MINUS)||(LA142_1>=TILDE && LA142_1<=LBRACK)||LA142_1==LCURLY||(LA142_1>=BACKQUOTE && LA142_1<=STRING)) ) {
                                alt142=1;
                            }


                        }


                        switch (alt142) {
                    	case 1 :
                    	    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1586:45: COMMA argument[arguments, kws, gens, false]
                    	    {
                    	    COMMA279=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist7398); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    COMMA279_tree = (PythonTree)adaptor.create(COMMA279);
                    	    adaptor.addChild(root_0, COMMA279_tree);
                    	    }
                    	    pushFollow(FOLLOW_argument_in_arglist7400);
                    	    argument280=argument(arguments, kws, gens, false);

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, argument280.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop142;
                        }
                    } while (true);

                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1587:11: ( COMMA ( STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )? )?
                    int alt145=2;
                    int LA145_0 = input.LA(1);

                    if ( (LA145_0==COMMA) ) {
                        alt145=1;
                    }
                    switch (alt145) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1587:12: COMMA ( STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )?
                            {
                            COMMA281=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist7416); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA281_tree = (PythonTree)adaptor.create(COMMA281);
                            adaptor.addChild(root_0, COMMA281_tree);
                            }
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1588:15: ( STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )? | DOUBLESTAR k= test[expr_contextType.Load] )?
                            int alt144=3;
                            int LA144_0 = input.LA(1);

                            if ( (LA144_0==STAR) ) {
                                alt144=1;
                            }
                            else if ( (LA144_0==DOUBLESTAR) ) {
                                alt144=2;
                            }
                            switch (alt144) {
                                case 1 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1588:17: STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )?
                                    {
                                    STAR282=(Token)match(input,STAR,FOLLOW_STAR_in_arglist7434); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    STAR282_tree = (PythonTree)adaptor.create(STAR282);
                                    adaptor.addChild(root_0, STAR282_tree);
                                    }
                                    pushFollow(FOLLOW_test_in_arglist7438);
                                    s=test(expr_contextType.Load);

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1588:52: ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )?
                                    int alt143=2;
                                    int LA143_0 = input.LA(1);

                                    if ( (LA143_0==COMMA) ) {
                                        alt143=1;
                                    }
                                    switch (alt143) {
                                        case 1 :
                                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1588:53: COMMA DOUBLESTAR k= test[expr_contextType.Load]
                                            {
                                            COMMA283=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist7442); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            COMMA283_tree = (PythonTree)adaptor.create(COMMA283);
                                            adaptor.addChild(root_0, COMMA283_tree);
                                            }
                                            DOUBLESTAR284=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_arglist7444); if (state.failed) return retval;
                                            if ( state.backtracking==0 ) {
                                            DOUBLESTAR284_tree = (PythonTree)adaptor.create(DOUBLESTAR284);
                                            adaptor.addChild(root_0, DOUBLESTAR284_tree);
                                            }
                                            pushFollow(FOLLOW_test_in_arglist7448);
                                            k=test(expr_contextType.Load);

                                            state._fsp--;
                                            if (state.failed) return retval;
                                            if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1589:17: DOUBLESTAR k= test[expr_contextType.Load]
                                    {
                                    DOUBLESTAR285=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_arglist7469); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) {
                                    DOUBLESTAR285_tree = (PythonTree)adaptor.create(DOUBLESTAR285);
                                    adaptor.addChild(root_0, DOUBLESTAR285_tree);
                                    }
                                    pushFollow(FOLLOW_test_in_arglist7473);
                                    k=test(expr_contextType.Load);

                                    state._fsp--;
                                    if (state.failed) return retval;
                                    if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                if (arguments.size() > 1 && gens.size() > 0) {
                                    actions.errorGenExpNotSoleArg(new PythonTree(((Token)retval.start)));
                                }
                                retval.args =arguments;
                                retval.keywords =kws;
                                retval.starargs =actions.castExpr((s!=null?((PythonTree)s.tree):null));
                                retval.kwargs =actions.castExpr((k!=null?((PythonTree)k.tree):null));
                            
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1601:7: STAR s= test[expr_contextType.Load] ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )?
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    STAR286=(Token)match(input,STAR,FOLLOW_STAR_in_arglist7520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STAR286_tree = (PythonTree)adaptor.create(STAR286);
                    adaptor.addChild(root_0, STAR286_tree);
                    }
                    pushFollow(FOLLOW_test_in_arglist7524);
                    s=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1601:42: ( COMMA DOUBLESTAR k= test[expr_contextType.Load] )?
                    int alt146=2;
                    int LA146_0 = input.LA(1);

                    if ( (LA146_0==COMMA) ) {
                        alt146=1;
                    }
                    switch (alt146) {
                        case 1 :
                            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1601:43: COMMA DOUBLESTAR k= test[expr_contextType.Load]
                            {
                            COMMA287=(Token)match(input,COMMA,FOLLOW_COMMA_in_arglist7528); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            COMMA287_tree = (PythonTree)adaptor.create(COMMA287);
                            adaptor.addChild(root_0, COMMA287_tree);
                            }
                            DOUBLESTAR288=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_arglist7530); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DOUBLESTAR288_tree = (PythonTree)adaptor.create(DOUBLESTAR288);
                            adaptor.addChild(root_0, DOUBLESTAR288_tree);
                            }
                            pushFollow(FOLLOW_test_in_arglist7534);
                            k=test(expr_contextType.Load);

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                                retval.starargs =actions.castExpr((s!=null?((PythonTree)s.tree):null));
                                  retval.kwargs =actions.castExpr((k!=null?((PythonTree)k.tree):null));
                            
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1606:7: DOUBLESTAR k= test[expr_contextType.Load]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    DOUBLESTAR289=(Token)match(input,DOUBLESTAR,FOLLOW_DOUBLESTAR_in_arglist7553); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DOUBLESTAR289_tree = (PythonTree)adaptor.create(DOUBLESTAR289);
                    adaptor.addChild(root_0, DOUBLESTAR289_tree);
                    }
                    pushFollow(FOLLOW_test_in_arglist7557);
                    k=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, k.getTree());
                    if ( state.backtracking==0 ) {

                                  retval.kwargs =actions.castExpr((k!=null?((PythonTree)k.tree):null));
                            
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arglist"

    public static class argument_return extends ParserRuleReturnScope {
        public boolean genarg;
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argument"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1613:1: argument[List arguments, List kws, List gens, boolean first] returns [boolean genarg] : t1= test[expr_contextType.Load] ( ( ASSIGN t2= test[expr_contextType.Load] ) | gen_for[$gens] | ) ;
    public final PythonParser.argument_return argument(List arguments, List kws, List gens, boolean first) throws RecognitionException {
        PythonParser.argument_return retval = new PythonParser.argument_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token ASSIGN290=null;
        PythonParser.test_return t1 = null;

        PythonParser.test_return t2 = null;

        PythonParser.gen_for_return gen_for291 = null;


        PythonTree ASSIGN290_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1615:5: (t1= test[expr_contextType.Load] ( ( ASSIGN t2= test[expr_contextType.Load] ) | gen_for[$gens] | ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1615:7: t1= test[expr_contextType.Load] ( ( ASSIGN t2= test[expr_contextType.Load] ) | gen_for[$gens] | )
            {
            root_0 = (PythonTree)adaptor.nil();

            pushFollow(FOLLOW_test_in_argument7596);
            t1=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1616:9: ( ( ASSIGN t2= test[expr_contextType.Load] ) | gen_for[$gens] | )
            int alt148=3;
            switch ( input.LA(1) ) {
            case ASSIGN:
                {
                alt148=1;
                }
                break;
            case FOR:
                {
                alt148=2;
                }
                break;
            case RPAREN:
            case COMMA:
                {
                alt148=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 148, 0, input);

                throw nvae;
            }

            switch (alt148) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1616:10: ( ASSIGN t2= test[expr_contextType.Load] )
                    {
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1616:10: ( ASSIGN t2= test[expr_contextType.Load] )
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1616:11: ASSIGN t2= test[expr_contextType.Load]
                    {
                    ASSIGN290=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_argument7609); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ASSIGN290_tree = (PythonTree)adaptor.create(ASSIGN290);
                    adaptor.addChild(root_0, ASSIGN290_tree);
                    }
                    pushFollow(FOLLOW_test_in_argument7613);
                    t2=test(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, t2.getTree());

                    }

                    if ( state.backtracking==0 ) {

                                    List<expr> exprs = new ArrayList<expr>();
                                    exprs.add(actions.castExpr((t1!=null?((PythonTree)t1.tree):null)));
                                    exprs.add(actions.castExpr((t2!=null?((PythonTree)t2.tree):null)));
                                    kws.add(exprs);
                                
                    }

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1623:11: gen_for[$gens]
                    {
                    pushFollow(FOLLOW_gen_for_in_argument7639);
                    gen_for291=gen_for(gens);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gen_for291.getTree());
                    if ( state.backtracking==0 ) {

                                    if (!first) {
                                        actions.errorGenExpNotSoleArg((gen_for291!=null?((PythonTree)gen_for291.tree):null));
                                    }
                                    retval.genarg = true;
                                    Collections.reverse(gens);
                                    List<comprehension> c = gens;
                                    arguments.add(new GeneratorExp((t1!=null?((Token)t1.start):null), actions.castExpr((t1!=null?((PythonTree)t1.tree):null)), c));
                                
                    }

                    }
                    break;
                case 3 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1634:11: 
                    {
                    if ( state.backtracking==0 ) {

                                    if (kws.size() > 0) {
                                        errorHandler.error("non-keyword arg after keyword arg", (t1!=null?((PythonTree)t1.tree):null));
                                    }
                                    arguments.add((t1!=null?((PythonTree)t1.tree):null));
                                
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "argument"

    public static class list_iter_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list_iter"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1644:1: list_iter[List gens, List ifs] : ( list_for[gens] | list_if[gens, ifs] );
    public final PythonParser.list_iter_return list_iter(List gens, List ifs) throws RecognitionException {
        PythonParser.list_iter_return retval = new PythonParser.list_iter_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.list_for_return list_for292 = null;

        PythonParser.list_if_return list_if293 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1645:5: ( list_for[gens] | list_if[gens, ifs] )
            int alt149=2;
            int LA149_0 = input.LA(1);

            if ( (LA149_0==FOR) ) {
                alt149=1;
            }
            else if ( (LA149_0==IF) ) {
                alt149=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 149, 0, input);

                throw nvae;
            }
            switch (alt149) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1645:7: list_for[gens]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_list_for_in_list_iter7704);
                    list_for292=list_for(gens);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, list_for292.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1646:7: list_if[gens, ifs]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_list_if_in_list_iter7713);
                    list_if293=list_if(gens, ifs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, list_if293.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list_iter"

    public static class list_for_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list_for"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1650:1: list_for[List gens] : FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] ( list_iter[gens, ifs] )? ;
    public final PythonParser.list_for_return list_for(List gens) throws RecognitionException {
        PythonParser.list_for_return retval = new PythonParser.list_for_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token FOR294=null;
        Token IN296=null;
        PythonParser.exprlist_return exprlist295 = null;

        PythonParser.testlist_return testlist297 = null;

        PythonParser.list_iter_return list_iter298 = null;


        PythonTree FOR294_tree=null;
        PythonTree IN296_tree=null;


            List ifs = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1654:5: ( FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] ( list_iter[gens, ifs] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1654:7: FOR exprlist[expr_contextType.Store] IN testlist[expr_contextType.Load] ( list_iter[gens, ifs] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            FOR294=(Token)match(input,FOR,FOLLOW_FOR_in_list_for7739); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOR294_tree = (PythonTree)adaptor.create(FOR294);
            adaptor.addChild(root_0, FOR294_tree);
            }
            pushFollow(FOLLOW_exprlist_in_list_for7741);
            exprlist295=exprlist(expr_contextType.Store);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exprlist295.getTree());
            IN296=(Token)match(input,IN,FOLLOW_IN_in_list_for7744); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN296_tree = (PythonTree)adaptor.create(IN296);
            adaptor.addChild(root_0, IN296_tree);
            }
            pushFollow(FOLLOW_testlist_in_list_for7746);
            testlist297=testlist(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, testlist297.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1654:79: ( list_iter[gens, ifs] )?
            int alt150=2;
            int LA150_0 = input.LA(1);

            if ( (LA150_0==FOR||LA150_0==IF) ) {
                alt150=1;
            }
            switch (alt150) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1654:80: list_iter[gens, ifs]
                    {
                    pushFollow(FOLLOW_list_iter_in_list_for7750);
                    list_iter298=list_iter(gens, ifs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, list_iter298.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        Collections.reverse(ifs);
                        gens.add(new comprehension(FOR294, (exprlist295!=null?exprlist295.etype:null), actions.castExpr((testlist297!=null?((PythonTree)testlist297.tree):null)), ifs));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list_for"

    public static class list_if_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list_if"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1662:1: list_if[List gens, List ifs] : IF test[expr_contextType.Load] ( list_iter[gens, ifs] )? ;
    public final PythonParser.list_if_return list_if(List gens, List ifs) throws RecognitionException {
        PythonParser.list_if_return retval = new PythonParser.list_if_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token IF299=null;
        PythonParser.test_return test300 = null;

        PythonParser.list_iter_return list_iter301 = null;


        PythonTree IF299_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1663:5: ( IF test[expr_contextType.Load] ( list_iter[gens, ifs] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1663:7: IF test[expr_contextType.Load] ( list_iter[gens, ifs] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            IF299=(Token)match(input,IF,FOLLOW_IF_in_list_if7780); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF299_tree = (PythonTree)adaptor.create(IF299);
            adaptor.addChild(root_0, IF299_tree);
            }
            pushFollow(FOLLOW_test_in_list_if7782);
            test300=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test300.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1663:38: ( list_iter[gens, ifs] )?
            int alt151=2;
            int LA151_0 = input.LA(1);

            if ( (LA151_0==FOR||LA151_0==IF) ) {
                alt151=1;
            }
            switch (alt151) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1663:39: list_iter[gens, ifs]
                    {
                    pushFollow(FOLLOW_list_iter_in_list_if7786);
                    list_iter301=list_iter(gens, ifs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, list_iter301.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      ifs.add(actions.castExpr((test300!=null?((PythonTree)test300.tree):null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list_if"

    public static class gen_iter_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gen_iter"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1670:1: gen_iter[List gens, List ifs] : ( gen_for[gens] | gen_if[gens, ifs] );
    public final PythonParser.gen_iter_return gen_iter(List gens, List ifs) throws RecognitionException {
        PythonParser.gen_iter_return retval = new PythonParser.gen_iter_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        PythonParser.gen_for_return gen_for302 = null;

        PythonParser.gen_if_return gen_if303 = null;



        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1671:5: ( gen_for[gens] | gen_if[gens, ifs] )
            int alt152=2;
            int LA152_0 = input.LA(1);

            if ( (LA152_0==FOR) ) {
                alt152=1;
            }
            else if ( (LA152_0==IF) ) {
                alt152=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 152, 0, input);

                throw nvae;
            }
            switch (alt152) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1671:7: gen_for[gens]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_gen_for_in_gen_iter7817);
                    gen_for302=gen_for(gens);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gen_for302.getTree());

                    }
                    break;
                case 2 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1672:7: gen_if[gens, ifs]
                    {
                    root_0 = (PythonTree)adaptor.nil();

                    pushFollow(FOLLOW_gen_if_in_gen_iter7826);
                    gen_if303=gen_if(gens, ifs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gen_if303.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gen_iter"

    public static class gen_for_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gen_for"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1676:1: gen_for[List gens] : FOR exprlist[expr_contextType.Store] IN or_test[expr_contextType.Load] ( gen_iter[gens, ifs] )? ;
    public final PythonParser.gen_for_return gen_for(List gens) throws RecognitionException {
        PythonParser.gen_for_return retval = new PythonParser.gen_for_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token FOR304=null;
        Token IN306=null;
        PythonParser.exprlist_return exprlist305 = null;

        PythonParser.or_test_return or_test307 = null;

        PythonParser.gen_iter_return gen_iter308 = null;


        PythonTree FOR304_tree=null;
        PythonTree IN306_tree=null;


            List ifs = new ArrayList();

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1680:5: ( FOR exprlist[expr_contextType.Store] IN or_test[expr_contextType.Load] ( gen_iter[gens, ifs] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1680:7: FOR exprlist[expr_contextType.Store] IN or_test[expr_contextType.Load] ( gen_iter[gens, ifs] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            FOR304=(Token)match(input,FOR,FOLLOW_FOR_in_gen_for7852); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FOR304_tree = (PythonTree)adaptor.create(FOR304);
            adaptor.addChild(root_0, FOR304_tree);
            }
            pushFollow(FOLLOW_exprlist_in_gen_for7854);
            exprlist305=exprlist(expr_contextType.Store);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exprlist305.getTree());
            IN306=(Token)match(input,IN,FOLLOW_IN_in_gen_for7857); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IN306_tree = (PythonTree)adaptor.create(IN306);
            adaptor.addChild(root_0, IN306_tree);
            }
            pushFollow(FOLLOW_or_test_in_gen_for7859);
            or_test307=or_test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, or_test307.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1680:78: ( gen_iter[gens, ifs] )?
            int alt153=2;
            int LA153_0 = input.LA(1);

            if ( (LA153_0==FOR||LA153_0==IF) ) {
                alt153=1;
            }
            switch (alt153) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1680:78: gen_iter[gens, ifs]
                    {
                    pushFollow(FOLLOW_gen_iter_in_gen_for7862);
                    gen_iter308=gen_iter(gens, ifs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gen_iter308.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                        Collections.reverse(ifs);
                        gens.add(new comprehension(FOR304, (exprlist305!=null?exprlist305.etype:null), actions.castExpr((or_test307!=null?((PythonTree)or_test307.tree):null)), ifs));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gen_for"

    public static class gen_if_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "gen_if"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1688:1: gen_if[List gens, List ifs] : IF test[expr_contextType.Load] ( gen_iter[gens, ifs] )? ;
    public final PythonParser.gen_if_return gen_if(List gens, List ifs) throws RecognitionException {
        PythonParser.gen_if_return retval = new PythonParser.gen_if_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token IF309=null;
        PythonParser.test_return test310 = null;

        PythonParser.gen_iter_return gen_iter311 = null;


        PythonTree IF309_tree=null;

        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1689:5: ( IF test[expr_contextType.Load] ( gen_iter[gens, ifs] )? )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1689:7: IF test[expr_contextType.Load] ( gen_iter[gens, ifs] )?
            {
            root_0 = (PythonTree)adaptor.nil();

            IF309=(Token)match(input,IF,FOLLOW_IF_in_gen_if7891); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF309_tree = (PythonTree)adaptor.create(IF309);
            adaptor.addChild(root_0, IF309_tree);
            }
            pushFollow(FOLLOW_test_in_gen_if7893);
            test310=test(expr_contextType.Load);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, test310.getTree());
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1689:38: ( gen_iter[gens, ifs] )?
            int alt154=2;
            int LA154_0 = input.LA(1);

            if ( (LA154_0==FOR||LA154_0==IF) ) {
                alt154=1;
            }
            switch (alt154) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1689:38: gen_iter[gens, ifs]
                    {
                    pushFollow(FOLLOW_gen_iter_in_gen_if7896);
                    gen_iter311=gen_iter(gens, ifs);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, gen_iter311.getTree());

                    }
                    break;

            }

            if ( state.backtracking==0 ) {

                      ifs.add(actions.castExpr((test310!=null?((PythonTree)test310.tree):null)));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "gen_if"

    public static class yield_expr_return extends ParserRuleReturnScope {
        PythonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "yield_expr"
    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1696:1: yield_expr : YIELD ( testlist[expr_contextType.Load] )? -> ^( YIELD[$YIELD, actions.castExpr($testlist.tree)] ) ;
    public final PythonParser.yield_expr_return yield_expr() throws RecognitionException {
        PythonParser.yield_expr_return retval = new PythonParser.yield_expr_return();
        retval.start = input.LT(1);

        PythonTree root_0 = null;

        Token YIELD312=null;
        PythonParser.testlist_return testlist313 = null;


        PythonTree YIELD312_tree=null;
        RewriteRuleTokenStream stream_YIELD=new RewriteRuleTokenStream(adaptor,"token YIELD");
        RewriteRuleSubtreeStream stream_testlist=new RewriteRuleSubtreeStream(adaptor,"rule testlist");
        try {
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1697:5: ( YIELD ( testlist[expr_contextType.Load] )? -> ^( YIELD[$YIELD, actions.castExpr($testlist.tree)] ) )
            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1697:7: YIELD ( testlist[expr_contextType.Load] )?
            {
            YIELD312=(Token)match(input,YIELD,FOLLOW_YIELD_in_yield_expr7924); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_YIELD.add(YIELD312);

            // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1697:13: ( testlist[expr_contextType.Load] )?
            int alt155=2;
            int LA155_0 = input.LA(1);

            if ( (LA155_0==NAME||(LA155_0>=LAMBDA && LA155_0<=NOT)||LA155_0==LPAREN||(LA155_0>=PLUS && LA155_0<=MINUS)||(LA155_0>=TILDE && LA155_0<=LBRACK)||LA155_0==LCURLY||(LA155_0>=BACKQUOTE && LA155_0<=STRING)) ) {
                alt155=1;
            }
            switch (alt155) {
                case 1 :
                    // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1697:13: testlist[expr_contextType.Load]
                    {
                    pushFollow(FOLLOW_testlist_in_yield_expr7926);
                    testlist313=testlist(expr_contextType.Load);

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_testlist.add(testlist313.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: YIELD
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (PythonTree)adaptor.nil();
            // 1698:4: -> ^( YIELD[$YIELD, actions.castExpr($testlist.tree)] )
            {
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1698:7: ^( YIELD[$YIELD, actions.castExpr($testlist.tree)] )
                {
                PythonTree root_1 = (PythonTree)adaptor.nil();
                root_1 = (PythonTree)adaptor.becomeRoot(new Yield(YIELD, YIELD312, actions.castExpr((testlist313!=null?((PythonTree)testlist313.tree):null))), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (PythonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }

        catch (RecognitionException re) {
            errorHandler.reportError(this, re);
            errorHandler.recover(this, input,re);
            retval.tree = (PythonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "yield_expr"

    // $ANTLR start synpred1_Python
    public final void synpred1_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:527:7: ( LPAREN fpdef[null] COMMA )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:527:8: LPAREN fpdef[null] COMMA
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred1_Python1249); if (state.failed) return ;
        pushFollow(FOLLOW_fpdef_in_synpred1_Python1251);
        fpdef(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred1_Python1254); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Python

    // $ANTLR start synpred2_Python
    public final void synpred2_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:590:8: ( testlist[null] augassign )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:590:9: testlist[null] augassign
        {
        pushFollow(FOLLOW_testlist_in_synpred2_Python1642);
        testlist(null);

        state._fsp--;
        if (state.failed) return ;
        pushFollow(FOLLOW_augassign_in_synpred2_Python1645);
        augassign();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_Python

    // $ANTLR start synpred3_Python
    public final void synpred3_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:604:7: ( testlist[null] ASSIGN )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:604:8: testlist[null] ASSIGN
        {
        pushFollow(FOLLOW_testlist_in_synpred3_Python1761);
        testlist(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,ASSIGN,FOLLOW_ASSIGN_in_synpred3_Python1764); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_Python

    // $ANTLR start synpred4_Python
    public final void synpred4_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:668:7: ( test[null] COMMA )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:668:8: test[null] COMMA
        {
        pushFollow(FOLLOW_test_in_synpred4_Python2289);
        test(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred4_Python2292); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_Python

    // $ANTLR start synpred5_Python
    public final void synpred5_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:689:7: ( test[null] COMMA test[null] )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:689:8: test[null] COMMA test[null]
        {
        pushFollow(FOLLOW_test_in_synpred5_Python2388);
        test(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred5_Python2391); if (state.failed) return ;
        pushFollow(FOLLOW_test_in_synpred5_Python2393);
        test(null);

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_Python

    // $ANTLR start synpred6_Python
    public final void synpred6_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:881:7: ( ( decorators )? DEF )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:881:8: ( decorators )? DEF
        {
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:881:8: ( decorators )?
        int alt156=2;
        int LA156_0 = input.LA(1);

        if ( (LA156_0==AT) ) {
            alt156=1;
        }
        switch (alt156) {
            case 1 :
                // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:881:8: decorators
                {
                pushFollow(FOLLOW_decorators_in_synpred6_Python3455);
                decorators();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }

        match(input,DEF,FOLLOW_DEF_in_synpred6_Python3458); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_Python

    // $ANTLR start synpred7_Python
    public final void synpred7_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1031:9: ( IF or_test[null] ORELSE )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1031:10: IF or_test[null] ORELSE
        {
        match(input,IF,FOLLOW_IF_in_synpred7_Python4191); if (state.failed) return ;
        pushFollow(FOLLOW_or_test_in_synpred7_Python4193);
        or_test(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,ORELSE,FOLLOW_ORELSE_in_synpred7_Python4196); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_Python

    // $ANTLR start synpred8_Python
    public final void synpred8_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1490:7: ( test[null] COLON )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1490:8: test[null] COLON
        {
        pushFollow(FOLLOW_test_in_synpred8_Python6821);
        test(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,COLON,FOLLOW_COLON_in_synpred8_Python6824); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred8_Python

    // $ANTLR start synpred9_Python
    public final void synpred9_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1495:7: ( COLON )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1495:8: COLON
        {
        match(input,COLON,FOLLOW_COLON_in_synpred9_Python6872); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_Python

    // $ANTLR start synpred10_Python
    public final void synpred10_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:7: ( expr[null] COMMA )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1517:8: expr[null] COMMA
        {
        pushFollow(FOLLOW_expr_in_synpred10_Python7017);
        expr(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred10_Python7020); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_Python

    // $ANTLR start synpred11_Python
    public final void synpred11_Python_fragment() throws RecognitionException {   
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1539:7: ( test[null] COMMA )
        // /run/media/abhi/0cc7e6ad-008e-43cd-b47d-f3ed6f127f92/home/abhi/dacapo-9.12-bach-src (2)/benchmarks/bms/jython/build/grammar/Python.g:1539:8: test[null] COMMA
        {
        pushFollow(FOLLOW_test_in_synpred11_Python7158);
        test(null);

        state._fsp--;
        if (state.failed) return ;
        match(input,COMMA,FOLLOW_COMMA_in_synpred11_Python7161); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_Python

    // Delegated rules

    public final boolean synpred5_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_Python() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_Python_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA29 dfa29 = new DFA29(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA78 dfa78 = new DFA78(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA114 dfa114 = new DFA114(this);
    protected DFA127 dfa127 = new DFA127(this);
    protected DFA131 dfa131 = new DFA131(this);
    protected DFA129 dfa129 = new DFA129(this);
    protected DFA132 dfa132 = new DFA132(this);
    protected DFA136 dfa136 = new DFA136(this);
    protected DFA134 dfa134 = new DFA134(this);
    protected DFA137 dfa137 = new DFA137(this);
    static final String DFA29_eotS =
        "\12\uffff";
    static final String DFA29_eofS =
        "\12\uffff";
    static final String DFA29_minS =
        "\1\11\11\uffff";
    static final String DFA29_maxS =
        "\1\132\11\uffff";
    static final String DFA29_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String DFA29_specialS =
        "\12\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\3\uffff\1\11\1\5\1\uffff\1\5\1\uffff\1\3\2\uffff\1\10\1"+
            "\uffff\1\6\1\uffff\1\7\1\uffff\1\6\2\uffff\2\1\2\uffff\1\4\1"+
            "\2\2\5\3\uffff\1\5\1\uffff\1\1\37\uffff\2\1\3\uffff\2\1\1\uffff"+
            "\1\1\1\uffff\6\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "568:1: small_stmt : ( expr_stmt | print_stmt | del_stmt | pass_stmt | flow_stmt | import_stmt | global_stmt | exec_stmt | assert_stmt );";
        }
    }
    static final String DFA34_eotS =
        "\23\uffff";
    static final String DFA34_eofS =
        "\23\uffff";
    static final String DFA34_minS =
        "\1\11\17\0\3\uffff";
    static final String DFA34_maxS =
        "\1\132\17\0\3\uffff";
    static final String DFA34_acceptS =
        "\20\uffff\1\1\1\2\1\3";
    static final String DFA34_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\3\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\11\24\uffff\1\17\1\1\13\uffff\1\5\37\uffff\1\2\1\3\3\uffff"+
            "\1\4\1\6\1\uffff\1\7\1\uffff\1\10\1\12\1\13\1\14\1\15\1\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "590:7: ( ( testlist[null] augassign )=>lhs= testlist[expr_contextType.AugStore] ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) ) | ( testlist[null] ASSIGN )=>lhs= testlist[expr_contextType.Store] ( | ( (at= ASSIGN t+= testlist[expr_contextType.Store] )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $t),\n actions.makeAssignValue($t)] ) ) | ( (ay= ASSIGN y2+= yield_expr )+ -> ^( ASSIGN[$lhs.start, actions.makeAssignTargets(actions.castExpr($lhs.tree), $y2),\n actions.makeAssignValue($y2)] ) ) ) | lhs= testlist[expr_contextType.Load] )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_1 = input.LA(1);

                         
                        int index34_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_2 = input.LA(1);

                         
                        int index34_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_3 = input.LA(1);

                         
                        int index34_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA34_4 = input.LA(1);

                         
                        int index34_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA34_5 = input.LA(1);

                         
                        int index34_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA34_6 = input.LA(1);

                         
                        int index34_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA34_7 = input.LA(1);

                         
                        int index34_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA34_8 = input.LA(1);

                         
                        int index34_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA34_9 = input.LA(1);

                         
                        int index34_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA34_10 = input.LA(1);

                         
                        int index34_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA34_11 = input.LA(1);

                         
                        int index34_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA34_12 = input.LA(1);

                         
                        int index34_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA34_13 = input.LA(1);

                         
                        int index34_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA34_14 = input.LA(1);

                         
                        int index34_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA34_15 = input.LA(1);

                         
                        int index34_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_Python()) ) {s = 16;}

                        else if ( (synpred3_Python()) ) {s = 17;}

                        else if ( (true) ) {s = 18;}

                         
                        input.seek(index34_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA30_eotS =
        "\17\uffff";
    static final String DFA30_eofS =
        "\17\uffff";
    static final String DFA30_minS =
        "\1\63\14\11\2\uffff";
    static final String DFA30_maxS =
        "\1\76\14\132\2\uffff";
    static final String DFA30_acceptS =
        "\15\uffff\1\2\1\1";
    static final String DFA30_specialS =
        "\17\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "\1\15\24\uffff\2\15\11\uffff\1\16\1\uffff\1\15\37\uffff\2\15"+
            "\3\uffff\2\15\1\uffff\1\15\1\uffff\6\15",
            "",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "591:9: ( (aay= augassign y1= yield_expr ) | (aat= augassign rhs= testlist[expr_contextType.Load] ) )";
        }
    }
    static final String DFA39_eotS =
        "\22\uffff";
    static final String DFA39_eofS =
        "\22\uffff";
    static final String DFA39_minS =
        "\1\11\17\0\2\uffff";
    static final String DFA39_maxS =
        "\1\132\17\0\2\uffff";
    static final String DFA39_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA39_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA39_transitionS = {
            "\1\11\24\uffff\1\17\1\1\13\uffff\1\5\37\uffff\1\2\1\3\3\uffff"+
            "\1\4\1\6\1\uffff\1\7\1\uffff\1\10\1\12\1\13\1\14\1\15\1\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "666:1: printlist returns [boolean newline, List elts] : ( ( test[null] COMMA )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )? | t+= test[expr_contextType.Load] );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA39_1 = input.LA(1);

                         
                        int index39_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA39_2 = input.LA(1);

                         
                        int index39_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA39_3 = input.LA(1);

                         
                        int index39_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA39_4 = input.LA(1);

                         
                        int index39_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA39_5 = input.LA(1);

                         
                        int index39_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA39_6 = input.LA(1);

                         
                        int index39_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA39_7 = input.LA(1);

                         
                        int index39_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA39_8 = input.LA(1);

                         
                        int index39_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA39_9 = input.LA(1);

                         
                        int index39_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA39_10 = input.LA(1);

                         
                        int index39_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA39_11 = input.LA(1);

                         
                        int index39_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA39_12 = input.LA(1);

                         
                        int index39_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA39_13 = input.LA(1);

                         
                        int index39_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA39_14 = input.LA(1);

                         
                        int index39_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA39_15 = input.LA(1);

                         
                        int index39_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred4_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index39_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 39, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA37_eotS =
        "\25\uffff";
    static final String DFA37_eofS =
        "\25\uffff";
    static final String DFA37_minS =
        "\2\7\23\uffff";
    static final String DFA37_maxS =
        "\1\62\1\132\23\uffff";
    static final String DFA37_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\16\uffff";
    static final String DFA37_specialS =
        "\25\uffff}>";
    static final String[] DFA37_transitionS = {
            "\1\2\47\uffff\1\1\2\uffff\1\2",
            "\1\2\1\uffff\1\6\24\uffff\2\6\13\uffff\1\6\6\uffff\1\2\30\uffff"+
            "\2\6\3\uffff\2\6\1\uffff\1\6\1\uffff\6\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 669:39: ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )*";
        }
    }
    static final String DFA42_eotS =
        "\22\uffff";
    static final String DFA42_eofS =
        "\22\uffff";
    static final String DFA42_minS =
        "\1\11\17\0\2\uffff";
    static final String DFA42_maxS =
        "\1\132\17\0\2\uffff";
    static final String DFA42_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA42_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\11\24\uffff\1\17\1\1\13\uffff\1\5\37\uffff\1\2\1\3\3\uffff"+
            "\1\4\1\6\1\uffff\1\7\1\uffff\1\10\1\12\1\13\1\14\1\15\1\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "687:1: printlist2 returns [boolean newline, List elts] : ( ( test[null] COMMA test[null] )=>t+= test[expr_contextType.Load] ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )* (trailcomma= COMMA )? | t+= test[expr_contextType.Load] );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_1 = input.LA(1);

                         
                        int index42_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA42_10 = input.LA(1);

                         
                        int index42_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA42_11 = input.LA(1);

                         
                        int index42_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA42_13 = input.LA(1);

                         
                        int index42_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA42_14 = input.LA(1);

                         
                        int index42_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred5_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\25\uffff";
    static final String DFA40_eofS =
        "\25\uffff";
    static final String DFA40_minS =
        "\2\7\23\uffff";
    static final String DFA40_maxS =
        "\1\62\1\132\23\uffff";
    static final String DFA40_acceptS =
        "\2\uffff\1\2\3\uffff\1\1\16\uffff";
    static final String DFA40_specialS =
        "\25\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\2\47\uffff\1\1\2\uffff\1\2",
            "\1\2\1\uffff\1\6\24\uffff\2\6\13\uffff\1\6\6\uffff\1\2\30\uffff"+
            "\2\6\3\uffff\2\6\1\uffff\1\6\1\uffff\6\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()* loopback of 690:39: ( options {k=2; } : COMMA t+= test[expr_contextType.Load] )*";
        }
    }
    static final String DFA51_eotS =
        "\4\uffff";
    static final String DFA51_eofS =
        "\4\uffff";
    static final String DFA51_minS =
        "\2\11\2\uffff";
    static final String DFA51_maxS =
        "\1\12\1\33\2\uffff";
    static final String DFA51_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA51_specialS =
        "\4\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\2\1\1",
            "\1\2\1\1\20\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "782:12: ( (d+= DOT )* dotted_name | (d+= DOT )+ )";
        }
    }
    static final String DFA78_eotS =
        "\33\uffff";
    static final String DFA78_eofS =
        "\1\2\32\uffff";
    static final String DFA78_minS =
        "\1\7\1\0\31\uffff";
    static final String DFA78_maxS =
        "\1\125\1\0\31\uffff";
    static final String DFA78_acceptS =
        "\2\uffff\1\2\27\uffff\1\1";
    static final String DFA78_specialS =
        "\1\uffff\1\0\31\uffff}>";
    static final String[] DFA78_transitionS = {
            "\1\2\1\uffff\1\2\2\uffff\1\2\13\uffff\1\2\1\uffff\1\1\21\uffff"+
            "\4\2\2\uffff\15\2\23\uffff\1\2\1\uffff\2\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA78_eot = DFA.unpackEncodedString(DFA78_eotS);
    static final short[] DFA78_eof = DFA.unpackEncodedString(DFA78_eofS);
    static final char[] DFA78_min = DFA.unpackEncodedStringToUnsignedChars(DFA78_minS);
    static final char[] DFA78_max = DFA.unpackEncodedStringToUnsignedChars(DFA78_maxS);
    static final short[] DFA78_accept = DFA.unpackEncodedString(DFA78_acceptS);
    static final short[] DFA78_special = DFA.unpackEncodedString(DFA78_specialS);
    static final short[][] DFA78_transition;

    static {
        int numStates = DFA78_transitionS.length;
        DFA78_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA78_transition[i] = DFA.unpackEncodedString(DFA78_transitionS[i]);
        }
    }

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = DFA78_eot;
            this.eof = DFA78_eof;
            this.min = DFA78_min;
            this.max = DFA78_max;
            this.accept = DFA78_accept;
            this.special = DFA78_special;
            this.transition = DFA78_transition;
        }
        public String getDescription() {
            return "1031:7: ( ( IF or_test[null] ORELSE )=> IF o2= or_test[ctype] ORELSE e= test[expr_contextType.Load] -> ^( IF[$o1.start, actions.castExpr($o2.tree), actions.castExpr($o1.tree), actions.castExpr($e.tree)] ) | -> or_test )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA78_1 = input.LA(1);

                         
                        int index78_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred7_Python()) ) {s = 26;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index78_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 78, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA87_eotS =
        "\15\uffff";
    static final String DFA87_eofS =
        "\15\uffff";
    static final String DFA87_minS =
        "\1\34\11\uffff\1\11\2\uffff";
    static final String DFA87_maxS =
        "\1\106\11\uffff\1\132\2\uffff";
    static final String DFA87_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13\1\12";
    static final String DFA87_specialS =
        "\15\uffff}>";
    static final String[] DFA87_transitionS = {
            "\1\10\1\12\1\uffff\1\11\40\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\25\uffff\1\13\13\uffff\1\14\37\uffff\2\14\3\uffff\2\14"+
            "\1\uffff\1\14\1\uffff\6\14",
            "",
            ""
    };

    static final short[] DFA87_eot = DFA.unpackEncodedString(DFA87_eotS);
    static final short[] DFA87_eof = DFA.unpackEncodedString(DFA87_eofS);
    static final char[] DFA87_min = DFA.unpackEncodedStringToUnsignedChars(DFA87_minS);
    static final char[] DFA87_max = DFA.unpackEncodedStringToUnsignedChars(DFA87_maxS);
    static final short[] DFA87_accept = DFA.unpackEncodedString(DFA87_acceptS);
    static final short[] DFA87_special = DFA.unpackEncodedString(DFA87_specialS);
    static final short[][] DFA87_transition;

    static {
        int numStates = DFA87_transitionS.length;
        DFA87_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA87_transition[i] = DFA.unpackEncodedString(DFA87_transitionS[i]);
        }
    }

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = DFA87_eot;
            this.eof = DFA87_eof;
            this.min = DFA87_min;
            this.max = DFA87_max;
            this.accept = DFA87_accept;
            this.special = DFA87_special;
            this.transition = DFA87_transition;
        }
        public String getDescription() {
            return "1099:1: comp_op returns [cmpopType op] : ( LESS | GREATER | EQUAL | GREATEREQUAL | LESSEQUAL | ALT_NOTEQUAL | NOTEQUAL | IN | NOT IN | IS | IS NOT );";
        }
    }
    static final String DFA114_eotS =
        "\23\uffff";
    static final String DFA114_eofS =
        "\23\uffff";
    static final String DFA114_minS =
        "\1\54\1\11\21\uffff";
    static final String DFA114_maxS =
        "\1\57\1\132\21\uffff";
    static final String DFA114_acceptS =
        "\2\uffff\1\2\1\1\17\uffff";
    static final String DFA114_specialS =
        "\23\uffff}>";
    static final String[] DFA114_transitionS = {
            "\1\2\2\uffff\1\1",
            "\1\3\24\uffff\2\3\13\uffff\1\3\1\2\36\uffff\2\3\3\uffff\2\3"+
            "\1\uffff\1\3\1\uffff\6\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA114_eot = DFA.unpackEncodedString(DFA114_eotS);
    static final short[] DFA114_eof = DFA.unpackEncodedString(DFA114_eofS);
    static final char[] DFA114_min = DFA.unpackEncodedStringToUnsignedChars(DFA114_minS);
    static final char[] DFA114_max = DFA.unpackEncodedStringToUnsignedChars(DFA114_maxS);
    static final short[] DFA114_accept = DFA.unpackEncodedString(DFA114_acceptS);
    static final short[] DFA114_special = DFA.unpackEncodedString(DFA114_specialS);
    static final short[][] DFA114_transition;

    static {
        int numStates = DFA114_transitionS.length;
        DFA114_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA114_transition[i] = DFA.unpackEncodedString(DFA114_transitionS[i]);
        }
    }

    class DFA114 extends DFA {

        public DFA114(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 114;
            this.eot = DFA114_eot;
            this.eof = DFA114_eof;
            this.min = DFA114_min;
            this.max = DFA114_max;
            this.accept = DFA114_accept;
            this.special = DFA114_special;
            this.transition = DFA114_transition;
        }
        public String getDescription() {
            return "()* loopback of 1413:12: ( options {k=2; } : c1= COMMA t+= test[$expr::ctype] )*";
        }
    }
    static final String DFA127_eotS =
        "\24\uffff";
    static final String DFA127_eofS =
        "\24\uffff";
    static final String DFA127_minS =
        "\1\11\1\uffff\17\0\3\uffff";
    static final String DFA127_maxS =
        "\1\132\1\uffff\17\0\3\uffff";
    static final String DFA127_acceptS =
        "\1\uffff\1\1\17\uffff\1\3\1\2\1\4";
    static final String DFA127_specialS =
        "\1\0\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\1\17\3\uffff}>";
    static final String[] DFA127_transitionS = {
            "\1\12\1\1\23\uffff\1\20\1\2\13\uffff\1\6\1\uffff\1\21\35\uffff"+
            "\1\3\1\4\3\uffff\1\5\1\7\1\uffff\1\10\1\uffff\1\11\1\13\1\14"+
            "\1\15\1\16\1\17",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA127_eot = DFA.unpackEncodedString(DFA127_eotS);
    static final short[] DFA127_eof = DFA.unpackEncodedString(DFA127_eofS);
    static final char[] DFA127_min = DFA.unpackEncodedStringToUnsignedChars(DFA127_minS);
    static final char[] DFA127_max = DFA.unpackEncodedStringToUnsignedChars(DFA127_maxS);
    static final short[] DFA127_accept = DFA.unpackEncodedString(DFA127_acceptS);
    static final short[] DFA127_special = DFA.unpackEncodedString(DFA127_specialS);
    static final short[][] DFA127_transition;

    static {
        int numStates = DFA127_transitionS.length;
        DFA127_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA127_transition[i] = DFA.unpackEncodedString(DFA127_transitionS[i]);
        }
    }

    class DFA127 extends DFA {

        public DFA127(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 127;
            this.eot = DFA127_eot;
            this.eof = DFA127_eof;
            this.min = DFA127_min;
            this.max = DFA127_max;
            this.accept = DFA127_accept;
            this.special = DFA127_special;
            this.transition = DFA127_transition;
        }
        public String getDescription() {
            return "1481:1: subscript returns [slice sltype] : (d1= DOT DOT DOT -> DOT[$d1] | ( test[null] COLON )=>lower= test[expr_contextType.Load] (c1= COLON (upper1= test[expr_contextType.Load] )? ( sliceop )? )? | ( COLON )=>c2= COLON (upper2= test[expr_contextType.Load] )? ( sliceop )? | test[expr_contextType.Load] -> ^( LPAREN[$test.start, actions.castExpr($test.tree)] ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA127_0 = input.LA(1);

                         
                        int index127_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA127_0==DOT) ) {s = 1;}

                        else if ( (LA127_0==NOT) ) {s = 2;}

                        else if ( (LA127_0==PLUS) ) {s = 3;}

                        else if ( (LA127_0==MINUS) ) {s = 4;}

                        else if ( (LA127_0==TILDE) ) {s = 5;}

                        else if ( (LA127_0==LPAREN) ) {s = 6;}

                        else if ( (LA127_0==LBRACK) ) {s = 7;}

                        else if ( (LA127_0==LCURLY) ) {s = 8;}

                        else if ( (LA127_0==BACKQUOTE) ) {s = 9;}

                        else if ( (LA127_0==NAME) ) {s = 10;}

                        else if ( (LA127_0==INT) ) {s = 11;}

                        else if ( (LA127_0==LONGINT) ) {s = 12;}

                        else if ( (LA127_0==FLOAT) ) {s = 13;}

                        else if ( (LA127_0==COMPLEX) ) {s = 14;}

                        else if ( (LA127_0==STRING) ) {s = 15;}

                        else if ( (LA127_0==LAMBDA) ) {s = 16;}

                        else if ( (LA127_0==COLON) && (synpred9_Python())) {s = 17;}

                         
                        input.seek(index127_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA127_2 = input.LA(1);

                         
                        int index127_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA127_3 = input.LA(1);

                         
                        int index127_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA127_4 = input.LA(1);

                         
                        int index127_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA127_5 = input.LA(1);

                         
                        int index127_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA127_6 = input.LA(1);

                         
                        int index127_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA127_7 = input.LA(1);

                         
                        int index127_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA127_8 = input.LA(1);

                         
                        int index127_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA127_9 = input.LA(1);

                         
                        int index127_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA127_10 = input.LA(1);

                         
                        int index127_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA127_11 = input.LA(1);

                         
                        int index127_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA127_12 = input.LA(1);

                         
                        int index127_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA127_13 = input.LA(1);

                         
                        int index127_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA127_14 = input.LA(1);

                         
                        int index127_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA127_15 = input.LA(1);

                         
                        int index127_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_15);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA127_16 = input.LA(1);

                         
                        int index127_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred8_Python()) ) {s = 18;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index127_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 127, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA131_eotS =
        "\20\uffff";
    static final String DFA131_eofS =
        "\20\uffff";
    static final String DFA131_minS =
        "\1\11\15\0\2\uffff";
    static final String DFA131_maxS =
        "\1\132\15\0\2\uffff";
    static final String DFA131_acceptS =
        "\16\uffff\1\1\1\2";
    static final String DFA131_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\2\uffff}>";
    static final String[] DFA131_transitionS = {
            "\1\10\41\uffff\1\4\37\uffff\1\1\1\2\3\uffff\1\3\1\5\1\uffff"+
            "\1\6\1\uffff\1\7\1\11\1\12\1\13\1\14\1\15",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA131_eot = DFA.unpackEncodedString(DFA131_eotS);
    static final short[] DFA131_eof = DFA.unpackEncodedString(DFA131_eofS);
    static final char[] DFA131_min = DFA.unpackEncodedStringToUnsignedChars(DFA131_minS);
    static final char[] DFA131_max = DFA.unpackEncodedStringToUnsignedChars(DFA131_maxS);
    static final short[] DFA131_accept = DFA.unpackEncodedString(DFA131_acceptS);
    static final short[] DFA131_special = DFA.unpackEncodedString(DFA131_specialS);
    static final short[][] DFA131_transition;

    static {
        int numStates = DFA131_transitionS.length;
        DFA131_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA131_transition[i] = DFA.unpackEncodedString(DFA131_transitionS[i]);
        }
    }

    class DFA131 extends DFA {

        public DFA131(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 131;
            this.eot = DFA131_eot;
            this.eof = DFA131_eof;
            this.min = DFA131_min;
            this.max = DFA131_max;
            this.accept = DFA131_accept;
            this.special = DFA131_special;
            this.transition = DFA131_transition;
        }
        public String getDescription() {
            return "1515:1: exprlist[expr_contextType ctype] returns [expr etype] : ( ( expr[null] COMMA )=>e+= expr[ctype] ( options {k=2; } : COMMA e+= expr[ctype] )* ( COMMA )? | expr[ctype] );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA131_1 = input.LA(1);

                         
                        int index131_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA131_2 = input.LA(1);

                         
                        int index131_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA131_3 = input.LA(1);

                         
                        int index131_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA131_4 = input.LA(1);

                         
                        int index131_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA131_5 = input.LA(1);

                         
                        int index131_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA131_6 = input.LA(1);

                         
                        int index131_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA131_7 = input.LA(1);

                         
                        int index131_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA131_8 = input.LA(1);

                         
                        int index131_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA131_9 = input.LA(1);

                         
                        int index131_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA131_10 = input.LA(1);

                         
                        int index131_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA131_11 = input.LA(1);

                         
                        int index131_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA131_12 = input.LA(1);

                         
                        int index131_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA131_13 = input.LA(1);

                         
                        int index131_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_Python()) ) {s = 14;}

                        else if ( (true) ) {s = 15;}

                         
                        input.seek(index131_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 131, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA129_eotS =
        "\21\uffff";
    static final String DFA129_eofS =
        "\21\uffff";
    static final String DFA129_minS =
        "\1\34\1\11\17\uffff";
    static final String DFA129_maxS =
        "\1\57\1\132\17\uffff";
    static final String DFA129_acceptS =
        "\2\uffff\1\2\1\1\15\uffff";
    static final String DFA129_specialS =
        "\21\uffff}>";
    static final String[] DFA129_transitionS = {
            "\1\2\22\uffff\1\1",
            "\1\3\22\uffff\1\2\16\uffff\1\3\37\uffff\2\3\3\uffff\2\3\1\uffff"+
            "\1\3\1\uffff\6\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA129_eot = DFA.unpackEncodedString(DFA129_eotS);
    static final short[] DFA129_eof = DFA.unpackEncodedString(DFA129_eofS);
    static final char[] DFA129_min = DFA.unpackEncodedStringToUnsignedChars(DFA129_minS);
    static final char[] DFA129_max = DFA.unpackEncodedStringToUnsignedChars(DFA129_maxS);
    static final short[] DFA129_accept = DFA.unpackEncodedString(DFA129_acceptS);
    static final short[] DFA129_special = DFA.unpackEncodedString(DFA129_specialS);
    static final short[][] DFA129_transition;

    static {
        int numStates = DFA129_transitionS.length;
        DFA129_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA129_transition[i] = DFA.unpackEncodedString(DFA129_transitionS[i]);
        }
    }

    class DFA129 extends DFA {

        public DFA129(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 129;
            this.eot = DFA129_eot;
            this.eof = DFA129_eof;
            this.min = DFA129_min;
            this.max = DFA129_max;
            this.accept = DFA129_accept;
            this.special = DFA129_special;
            this.transition = DFA129_transition;
        }
        public String getDescription() {
            return "()* loopback of 1517:44: ( options {k=2; } : COMMA e+= expr[ctype] )*";
        }
    }
    static final String DFA132_eotS =
        "\23\uffff";
    static final String DFA132_eofS =
        "\23\uffff";
    static final String DFA132_minS =
        "\2\7\21\uffff";
    static final String DFA132_maxS =
        "\1\62\1\132\21\uffff";
    static final String DFA132_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\16\uffff";
    static final String DFA132_specialS =
        "\23\uffff}>";
    static final String[] DFA132_transitionS = {
            "\1\2\47\uffff\1\1\2\uffff\1\2",
            "\1\2\1\uffff\1\4\41\uffff\1\4\6\uffff\1\2\30\uffff\2\4\3\uffff"+
            "\2\4\1\uffff\1\4\1\uffff\6\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA132_eot = DFA.unpackEncodedString(DFA132_eotS);
    static final short[] DFA132_eof = DFA.unpackEncodedString(DFA132_eofS);
    static final char[] DFA132_min = DFA.unpackEncodedStringToUnsignedChars(DFA132_minS);
    static final char[] DFA132_max = DFA.unpackEncodedStringToUnsignedChars(DFA132_maxS);
    static final short[] DFA132_accept = DFA.unpackEncodedString(DFA132_acceptS);
    static final short[] DFA132_special = DFA.unpackEncodedString(DFA132_specialS);
    static final short[][] DFA132_transition;

    static {
        int numStates = DFA132_transitionS.length;
        DFA132_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA132_transition[i] = DFA.unpackEncodedString(DFA132_transitionS[i]);
        }
    }

    class DFA132 extends DFA {

        public DFA132(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 132;
            this.eot = DFA132_eot;
            this.eof = DFA132_eof;
            this.min = DFA132_min;
            this.max = DFA132_max;
            this.accept = DFA132_accept;
            this.special = DFA132_special;
            this.transition = DFA132_transition;
        }
        public String getDescription() {
            return "()* loopback of 1531:37: ( options {k=2; } : COMMA e+= expr[expr_contextType.Del] )*";
        }
    }
    static final String DFA136_eotS =
        "\22\uffff";
    static final String DFA136_eofS =
        "\22\uffff";
    static final String DFA136_minS =
        "\1\11\17\0\2\uffff";
    static final String DFA136_maxS =
        "\1\132\17\0\2\uffff";
    static final String DFA136_acceptS =
        "\20\uffff\1\1\1\2";
    static final String DFA136_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
        "\1\15\1\16\2\uffff}>";
    static final String[] DFA136_transitionS = {
            "\1\11\24\uffff\1\17\1\1\13\uffff\1\5\37\uffff\1\2\1\3\3\uffff"+
            "\1\4\1\6\1\uffff\1\7\1\uffff\1\10\1\12\1\13\1\14\1\15\1\16",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA136_eot = DFA.unpackEncodedString(DFA136_eotS);
    static final short[] DFA136_eof = DFA.unpackEncodedString(DFA136_eofS);
    static final char[] DFA136_min = DFA.unpackEncodedStringToUnsignedChars(DFA136_minS);
    static final char[] DFA136_max = DFA.unpackEncodedStringToUnsignedChars(DFA136_maxS);
    static final short[] DFA136_accept = DFA.unpackEncodedString(DFA136_acceptS);
    static final short[] DFA136_special = DFA.unpackEncodedString(DFA136_specialS);
    static final short[][] DFA136_transition;

    static {
        int numStates = DFA136_transitionS.length;
        DFA136_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA136_transition[i] = DFA.unpackEncodedString(DFA136_transitionS[i]);
        }
    }

    class DFA136 extends DFA {

        public DFA136(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 136;
            this.eot = DFA136_eot;
            this.eof = DFA136_eof;
            this.min = DFA136_min;
            this.max = DFA136_max;
            this.accept = DFA136_accept;
            this.special = DFA136_special;
            this.transition = DFA136_transition;
        }
        public String getDescription() {
            return "1538:1: testlist[expr_contextType ctype] : ( ( test[null] COMMA )=>t+= test[ctype] ( options {k=2; } : COMMA t+= test[ctype] )* ( COMMA )? -> ^( COMMA[$testlist.start, actions.castExprs($t), ctype] ) | test[ctype] );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA136_1 = input.LA(1);

                         
                        int index136_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA136_2 = input.LA(1);

                         
                        int index136_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA136_3 = input.LA(1);

                         
                        int index136_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA136_4 = input.LA(1);

                         
                        int index136_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA136_5 = input.LA(1);

                         
                        int index136_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_5);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA136_6 = input.LA(1);

                         
                        int index136_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_6);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA136_7 = input.LA(1);

                         
                        int index136_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_7);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA136_8 = input.LA(1);

                         
                        int index136_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_8);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA136_9 = input.LA(1);

                         
                        int index136_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_9);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA136_10 = input.LA(1);

                         
                        int index136_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_10);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA136_11 = input.LA(1);

                         
                        int index136_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_11);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA136_12 = input.LA(1);

                         
                        int index136_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_12);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA136_13 = input.LA(1);

                         
                        int index136_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_13);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA136_14 = input.LA(1);

                         
                        int index136_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_14);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA136_15 = input.LA(1);

                         
                        int index136_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_Python()) ) {s = 16;}

                        else if ( (true) ) {s = 17;}

                         
                        input.seek(index136_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 136, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA134_eotS =
        "\75\uffff";
    static final String DFA134_eofS =
        "\2\2\73\uffff";
    static final String DFA134_minS =
        "\2\7\73\uffff";
    static final String DFA134_maxS =
        "\1\125\1\132\73\uffff";
    static final String DFA134_acceptS =
        "\2\uffff\1\2\47\uffff\1\1\4\uffff\1\1\15\uffff";
    static final String DFA134_specialS =
        "\75\uffff}>";
    static final String[] DFA134_transitionS = {
            "\1\2\20\uffff\1\2\1\uffff\1\2\21\uffff\3\2\1\1\2\uffff\15\2"+
            "\23\uffff\1\2\2\uffff\1\2",
            "\1\2\1\uffff\1\57\16\uffff\1\2\1\uffff\1\2\3\uffff\2\57\13"+
            "\uffff\1\57\4\2\2\uffff\15\2\14\uffff\2\57\3\uffff\2\57\1\2"+
            "\1\57\1\uffff\1\52\5\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA134_eot = DFA.unpackEncodedString(DFA134_eotS);
    static final short[] DFA134_eof = DFA.unpackEncodedString(DFA134_eofS);
    static final char[] DFA134_min = DFA.unpackEncodedStringToUnsignedChars(DFA134_minS);
    static final char[] DFA134_max = DFA.unpackEncodedStringToUnsignedChars(DFA134_maxS);
    static final short[] DFA134_accept = DFA.unpackEncodedString(DFA134_acceptS);
    static final short[] DFA134_special = DFA.unpackEncodedString(DFA134_specialS);
    static final short[][] DFA134_transition;

    static {
        int numStates = DFA134_transitionS.length;
        DFA134_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA134_transition[i] = DFA.unpackEncodedString(DFA134_transitionS[i]);
        }
    }

    class DFA134 extends DFA {

        public DFA134(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 134;
            this.eot = DFA134_eot;
            this.eof = DFA134_eof;
            this.min = DFA134_min;
            this.max = DFA134_max;
            this.accept = DFA134_accept;
            this.special = DFA134_special;
            this.transition = DFA134_transition;
        }
        public String getDescription() {
            return "()* loopback of 1540:22: ( options {k=2; } : COMMA t+= test[ctype] )*";
        }
    }
    static final String DFA137_eotS =
        "\23\uffff";
    static final String DFA137_eofS =
        "\23\uffff";
    static final String DFA137_minS =
        "\1\57\1\11\21\uffff";
    static final String DFA137_maxS =
        "\1\124\1\132\21\uffff";
    static final String DFA137_acceptS =
        "\2\uffff\1\2\1\1\17\uffff";
    static final String DFA137_specialS =
        "\23\uffff}>";
    static final String[] DFA137_transitionS = {
            "\1\1\44\uffff\1\2",
            "\1\3\24\uffff\2\3\13\uffff\1\3\37\uffff\2\3\3\uffff\2\3\1\uffff"+
            "\1\3\1\2\6\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA137_eot = DFA.unpackEncodedString(DFA137_eotS);
    static final short[] DFA137_eof = DFA.unpackEncodedString(DFA137_eofS);
    static final char[] DFA137_min = DFA.unpackEncodedStringToUnsignedChars(DFA137_minS);
    static final char[] DFA137_max = DFA.unpackEncodedStringToUnsignedChars(DFA137_maxS);
    static final short[] DFA137_accept = DFA.unpackEncodedString(DFA137_acceptS);
    static final short[] DFA137_special = DFA.unpackEncodedString(DFA137_specialS);
    static final short[][] DFA137_transition;

    static {
        int numStates = DFA137_transitionS.length;
        DFA137_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA137_transition[i] = DFA.unpackEncodedString(DFA137_transitionS[i]);
        }
    }

    class DFA137 extends DFA {

        public DFA137(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 137;
            this.eot = DFA137_eot;
            this.eof = DFA137_eof;
            this.min = DFA137_min;
            this.max = DFA137_max;
            this.accept = DFA137_accept;
            this.special = DFA137_special;
            this.transition = DFA137_transition;
        }
        public String getDescription() {
            return "()* loopback of 1549:9: ( options {k=2; } : COMMA k+= test[expr_contextType.Load] COLON v+= test[expr_contextType.Load] )*";
        }
    }
 

    public static final BitSet FOLLOW_NEWLINE_in_single_input116 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EOF_in_single_input119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_stmt_in_single_input135 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_single_input137 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EOF_in_single_input140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_stmt_in_single_input156 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_single_input158 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EOF_in_single_input161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_file_input213 = new BitSet(new long[]{0x00000FFCCFA7E280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_stmt_in_file_input223 = new BitSet(new long[]{0x00000FFCCFA7E280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_EOF_in_file_input242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEADING_WS_in_eval_input296 = new BitSet(new long[]{0x00000800C0000280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_NEWLINE_in_eval_input300 = new BitSet(new long[]{0x00000800C0000280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_eval_input304 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_eval_input308 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_EOF_in_eval_input312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_dotted_attr364 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_DOT_in_dotted_attr375 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_dotted_attr379 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_set_in_attr0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_decorator716 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dotted_attr_in_decorator718 = new BitSet(new long[]{0x0000080000000080L});
    public static final BitSet FOLLOW_LPAREN_in_decorator726 = new BitSet(new long[]{0x00031800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_arglist_in_decorator736 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_decorator780 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_decorator802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decorator_in_decorators830 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_decorators_in_funcdef867 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_DEF_in_funcdef870 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_funcdef872 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_parameters_in_funcdef874 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_funcdef876 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_funcdef878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_parameters911 = new BitSet(new long[]{0x0003180000000200L});
    public static final BitSet FOLLOW_varargslist_in_parameters920 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_parameters964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpdef_in_defparameter997 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_defparameter1001 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_defparameter1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defparameter_in_varargslist1049 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_varargslist1060 = new BitSet(new long[]{0x0000080000000200L});
    public static final BitSet FOLLOW_defparameter_in_varargslist1064 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_varargslist1076 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_STAR_in_varargslist1089 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_varargslist1093 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_varargslist1096 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1098 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_varargslist1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1118 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_varargslist1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_varargslist1160 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_varargslist1164 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_varargslist1167 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1169 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_varargslist1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_varargslist1191 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_varargslist1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_fpdef1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_fpdef1259 = new BitSet(new long[]{0x0000080000000200L});
    public static final BitSet FOLLOW_fplist_in_fpdef1261 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_fpdef1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_fpdef1284 = new BitSet(new long[]{0x0000080000000200L});
    public static final BitSet FOLLOW_fplist_in_fpdef1286 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_fpdef1288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fpdef_in_fplist1323 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_fplist1340 = new BitSet(new long[]{0x0000080000000200L});
    public static final BitSet FOLLOW_fpdef_in_fplist1344 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_fplist1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_stmt_in_stmt1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_compound_stmt_in_stmt1402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_small_stmt_in_simple_stmt1438 = new BitSet(new long[]{0x0004000000000080L});
    public static final BitSet FOLLOW_SEMI_in_simple_stmt1448 = new BitSet(new long[]{0x00000A3CCAA56200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_small_stmt_in_simple_stmt1452 = new BitSet(new long[]{0x0004000000000080L});
    public static final BitSet FOLLOW_SEMI_in_simple_stmt1457 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_NEWLINE_in_simple_stmt1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_stmt_in_small_stmt1484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_print_stmt_in_small_stmt1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_del_stmt_in_small_stmt1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pass_stmt_in_small_stmt1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_flow_stmt_in_small_stmt1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_stmt_in_small_stmt1559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_global_stmt_in_small_stmt1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exec_stmt_in_small_stmt1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assert_stmt_in_small_stmt1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_testlist_in_expr_stmt1652 = new BitSet(new long[]{0x7FF8000000000000L});
    public static final BitSet FOLLOW_augassign_in_expr_stmt1668 = new BitSet(new long[]{0x0000023000014000L});
    public static final BitSet FOLLOW_yield_expr_in_expr_stmt1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_augassign_in_expr_stmt1712 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_expr_stmt1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_testlist_in_expr_stmt1771 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_expr_stmt1798 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_expr_stmt1802 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_expr_stmt1850 = new BitSet(new long[]{0x0000023000014000L});
    public static final BitSet FOLLOW_yield_expr_in_expr_stmt1854 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_testlist_in_expr_stmt1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUSEQUAL_in_augassign1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUSEQUAL_in_augassign1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAREQUAL_in_augassign1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASHEQUAL_in_augassign2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENTEQUAL_in_augassign2019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMPEREQUAL_in_augassign2037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VBAREQUAL_in_augassign2055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CIRCUMFLEXEQUAL_in_augassign2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFTSHIFTEQUAL_in_augassign2091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHTSHIFTEQUAL_in_augassign2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESTAREQUAL_in_augassign2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESLASHEQUAL_in_augassign2145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRINT_in_print_stmt2174 = new BitSet(new long[]{0x80000800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_printlist_in_print_stmt2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHTSHIFT_in_print_stmt2210 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_printlist2_in_print_stmt2214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_printlist2306 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_printlist2318 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_printlist2322 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_printlist2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_printlist2351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_printlist22408 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_printlist22420 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_printlist22424 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_printlist22432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_printlist22453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DELETE_in_del_stmt2481 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_del_list_in_del_stmt2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PASS_in_pass_stmt2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_break_stmt_in_flow_stmt2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_continue_stmt_in_flow_stmt2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_stmt_in_flow_stmt2561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_raise_stmt_in_flow_stmt2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yield_stmt_in_flow_stmt2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BREAK_in_break_stmt2595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONTINUE_in_continue_stmt2626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURN_in_return_stmt2665 = new BitSet(new long[]{0x00000800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_return_stmt2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_yield_expr_in_yield_stmt2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RAISE_in_raise_stmt2772 = new BitSet(new long[]{0x00000800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_raise_stmt2777 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_raise_stmt2781 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_raise_stmt2785 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_raise_stmt2797 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_raise_stmt2801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_name_in_import_stmt2839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_from_in_import_stmt2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_import_name2865 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dotted_as_names_in_import_name2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_import_from2899 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_DOT_in_import_from2904 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_dotted_name_in_import_from2907 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DOT_in_import_from2913 = new BitSet(new long[]{0x0000000008000400L});
    public static final BitSet FOLLOW_IMPORT_in_import_from2917 = new BitSet(new long[]{0x0001080000000200L});
    public static final BitSet FOLLOW_STAR_in_import_from2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_as_names_in_import_from2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_import_from2988 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_import_as_names_in_import_from2992 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_COMMA_in_import_from2994 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_import_from2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_import_as_name_in_import_as_names3052 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_import_as_names3055 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_import_as_name_in_import_as_names3060 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_NAME_in_import_as_name3101 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_AS_in_import_as_name3104 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_import_as_name3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotted_name_in_dotted_as_name3149 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_AS_in_dotted_as_name3152 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_dotted_as_name3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dotted_as_name_in_dotted_as_names3190 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_dotted_as_names3193 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_dotted_as_name_in_dotted_as_names3198 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_NAME_in_dotted_name3232 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_DOT_in_dotted_name3235 = new BitSet(new long[]{0x000003FFFFFFFA00L});
    public static final BitSet FOLLOW_attr_in_dotted_name3239 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_GLOBAL_in_global_stmt3265 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_global_stmt3269 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_global_stmt3272 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_global_stmt3276 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_EXEC_in_exec_stmt3319 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_expr_in_exec_stmt3321 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_IN_in_exec_stmt3325 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_exec_stmt3329 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_exec_stmt3333 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_exec_stmt3337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSERT_in_assert_stmt3368 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_assert_stmt3372 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_assert_stmt3376 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_assert_stmt3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_compound_stmt3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_compound_stmt3422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_stmt_in_compound_stmt3430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_try_stmt_in_compound_stmt3438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_with_stmt_in_compound_stmt3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_funcdef_in_compound_stmt3463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_classdef_in_compound_stmt3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_if_stmt3489 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_if_stmt3491 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_if_stmt3494 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_if_stmt3498 = new BitSet(new long[]{0x0000000200080002L});
    public static final BitSet FOLLOW_elif_clause_in_if_stmt3501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_else_clause_in_elif_clause3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELIF_in_elif_clause3560 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_elif_clause3562 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_elif_clause3565 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_elif_clause3567 = new BitSet(new long[]{0x0000000200080002L});
    public static final BitSet FOLLOW_elif_clause_in_elif_clause3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ORELSE_in_else_clause3662 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_else_clause3664 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_else_clause3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_while_stmt3705 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_while_stmt3707 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_while_stmt3710 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_while_stmt3714 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ORELSE_in_while_stmt3718 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_while_stmt3720 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_while_stmt3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_for_stmt3763 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_exprlist_in_for_stmt3765 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_IN_in_for_stmt3768 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_for_stmt3770 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_for_stmt3773 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_for_stmt3777 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ORELSE_in_for_stmt3789 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_for_stmt3791 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_for_stmt3795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRY_in_try_stmt3838 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_try_stmt3840 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_try_stmt3844 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_except_clause_in_try_stmt3857 = new BitSet(new long[]{0x0000000200500002L});
    public static final BitSet FOLLOW_ORELSE_in_try_stmt3861 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_try_stmt3863 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_try_stmt3867 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_FINALLY_in_try_stmt3873 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_try_stmt3875 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_try_stmt3879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_try_stmt3902 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_try_stmt3904 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_try_stmt3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WITH_in_with_stmt3957 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_with_stmt3959 = new BitSet(new long[]{0x0000200000001200L});
    public static final BitSet FOLLOW_with_var_in_with_stmt3963 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_with_stmt3967 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_with_stmt3969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_with_var4004 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_expr_in_with_var4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXCEPT_in_except_clause4039 = new BitSet(new long[]{0x00002800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_except_clause4044 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_COMMA_in_except_clause4048 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_except_clause4052 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_except_clause4059 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_except_clause4061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simple_stmt_in_suite4112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NEWLINE_in_suite4128 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_INDENT_in_suite4130 = new BitSet(new long[]{0x00000FFCCFA7E280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_stmt_in_suite4139 = new BitSet(new long[]{0x00000FFCCFA7E2A0L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_DEDENT_in_suite4159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_or_test_in_test4179 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_IF_in_test4201 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_or_test_in_test4205 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ORELSE_in_test4208 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_test4212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lambdef_in_test4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_test_in_or_test4287 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_OR_in_or_test4303 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_and_test_in_or_test4307 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_not_test_in_and_test4379 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_AND_in_and_test4395 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_not_test_in_and_test4399 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_NOT_in_not_test4464 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_not_test_in_not_test4468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_test4490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_comparison4522 = new BitSet(new long[]{0x00000000B0000002L,0x000000000000007FL});
    public static final BitSet FOLLOW_comp_op_in_comparison4536 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_expr_in_comparison4540 = new BitSet(new long[]{0x00000000B0000002L,0x000000000000007FL});
    public static final BitSet FOLLOW_LESS_in_comp_op4621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATER_in_comp_op4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EQUAL_in_comp_op4657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GREATEREQUAL_in_comp_op4675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LESSEQUAL_in_comp_op4693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_NOTEQUAL_in_comp_op4711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOTEQUAL_in_comp_op4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IN_in_comp_op4747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_comp_op4765 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_IN_in_comp_op4767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_comp_op4785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IS_in_comp_op4803 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_NOT_in_comp_op4805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_xor_expr_in_expr4851 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_VBAR_in_expr4866 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_xor_expr_in_expr4870 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_and_expr_in_xor_expr4941 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_CIRCUMFLEX_in_xor_expr4956 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_and_expr_in_xor_expr4960 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_shift_expr_in_and_expr5030 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_AMPER_in_and_expr5045 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_shift_expr_in_and_expr5049 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_arith_expr_in_shift_expr5124 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_shift_op_in_shift_expr5138 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_arith_expr_in_shift_expr5142 = new BitSet(new long[]{0x8000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_LEFTSHIFT_in_shift_op5226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RIGHTSHIFT_in_shift_op5244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_term_in_arith_expr5284 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_arith_op_in_arith_expr5297 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_term_in_arith_expr5301 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001800L});
    public static final BitSet FOLLOW_PLUS_in_arith_op5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_arith_op5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_factor_in_term5467 = new BitSet(new long[]{0x0001000000000002L,0x000000000000E000L});
    public static final BitSet FOLLOW_term_op_in_term5480 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_factor_in_term5484 = new BitSet(new long[]{0x0001000000000002L,0x000000000000E000L});
    public static final BitSet FOLLOW_STAR_in_term_op5565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH_in_term_op5582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PERCENT_in_term_op5599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESLASH_in_term_op5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_factor5657 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_factor_in_factor5661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_factor5679 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_factor_in_factor5683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_factor5701 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_factor_in_factor5705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_power_in_factor5723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_power5764 = new BitSet(new long[]{0x0002080000000402L,0x0000000000020000L});
    public static final BitSet FOLLOW_trailer_in_power5769 = new BitSet(new long[]{0x0002080000000402L,0x0000000000020000L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_power5784 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_factor_in_power5786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_atom5818 = new BitSet(new long[]{0x00001A30C0014200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_yield_expr_in_atom5828 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_testlist_gexp_in_atom5847 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_atom5895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_atom5903 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EF1800L});
    public static final BitSet FOLLOW_listmaker_in_atom5912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACK_in_atom5969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LCURLY_in_atom5977 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007FB1800L});
    public static final BitSet FOLLOW_dictmaker_in_atom5987 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_RCURLY_in_atom6046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BACKQUOTE_in_atom6057 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_atom6059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_BACKQUOTE_in_atom6064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NAME_in_atom6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom6110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LONGINT_in_atom6133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom6156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMPLEX_in_atom6179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom6205 = new BitSet(new long[]{0x0000000000000002L,0x0000000004000000L});
    public static final BitSet FOLLOW_test_in_listmaker6253 = new BitSet(new long[]{0x0000800001000002L});
    public static final BitSet FOLLOW_list_for_in_listmaker6265 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_listmaker6297 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_listmaker6301 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_listmaker6330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_testlist_gexp6362 = new BitSet(new long[]{0x0000800001000002L});
    public static final BitSet FOLLOW_COMMA_in_testlist_gexp6387 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_testlist_gexp6391 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_testlist_gexp6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gen_for_in_testlist_gexp6476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LAMBDA_in_lambdef6540 = new BitSet(new long[]{0x0003280000000200L});
    public static final BitSet FOLLOW_varargslist_in_lambdef6543 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_lambdef6547 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_lambdef6549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_trailer6578 = new BitSet(new long[]{0x00031800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_arglist_in_trailer6589 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_trailer6651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACK_in_trailer6659 = new BitSet(new long[]{0x00002800C0000600L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_subscriptlist_in_trailer6661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_RBRACK_in_trailer6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_trailer6685 = new BitSet(new long[]{0x000003FFFFFFFA00L});
    public static final BitSet FOLLOW_attr_in_trailer6687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subscript_in_subscriptlist6731 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_subscriptlist6743 = new BitSet(new long[]{0x00002800C0000600L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_subscript_in_subscriptlist6747 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_subscriptlist6754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_subscript6797 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_DOT_in_subscript6799 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_DOT_in_subscript6801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_subscript6834 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_COLON_in_subscript6840 = new BitSet(new long[]{0x00002800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_subscript6845 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_sliceop_in_subscript6851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_subscript6882 = new BitSet(new long[]{0x00002800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_subscript6887 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_sliceop_in_subscript6893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_subscript6911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_sliceop6943 = new BitSet(new long[]{0x00000800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_sliceop6951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_exprlist7027 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_exprlist7039 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_expr_in_exprlist7043 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_exprlist7049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_exprlist7068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_del_list7106 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_del_list7118 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_expr_in_del_list7122 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_del_list7128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_testlist7171 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_testlist7183 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_testlist7187 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_testlist7193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_testlist7216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_dictmaker7245 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_dictmaker7248 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_dictmaker7252 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_dictmaker7271 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_dictmaker7275 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_dictmaker7278 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_dictmaker7282 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_dictmaker7296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decorators_in_classdef7334 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_CLASS_in_classdef7337 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_NAME_in_classdef7339 = new BitSet(new long[]{0x0000280000000000L});
    public static final BitSet FOLLOW_LPAREN_in_classdef7342 = new BitSet(new long[]{0x00001800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_classdef7344 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RPAREN_in_classdef7348 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_classdef7352 = new BitSet(new long[]{0x00000A3CCAA56280L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_suite_in_classdef7354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_arglist7394 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_arglist7398 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_argument_in_arglist7400 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_arglist7416 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_STAR_in_arglist7434 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_arglist7438 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_arglist7442 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_arglist7444 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_arglist7448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_arglist7469 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_arglist7473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_arglist7520 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_arglist7524 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_COMMA_in_arglist7528 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_arglist7530 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_arglist7534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLESTAR_in_arglist7553 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_arglist7557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_argument7596 = new BitSet(new long[]{0x0000C00001000000L});
    public static final BitSet FOLLOW_ASSIGN_in_argument7609 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_argument7613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gen_for_in_argument7639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_for_in_list_iter7704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_if_in_list_iter7713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_list_for7739 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_exprlist_in_list_for7741 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_IN_in_list_for7744 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_list_for7746 = new BitSet(new long[]{0x0000000005000002L});
    public static final BitSet FOLLOW_list_iter_in_list_for7750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_list_if7780 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_list_if7782 = new BitSet(new long[]{0x0000000005000002L});
    public static final BitSet FOLLOW_list_iter_in_list_if7786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gen_for_in_gen_iter7817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gen_if_in_gen_iter7826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FOR_in_gen_for7852 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_exprlist_in_gen_for7854 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_IN_in_gen_for7857 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_or_test_in_gen_for7859 = new BitSet(new long[]{0x0000800005000002L});
    public static final BitSet FOLLOW_gen_iter_in_gen_for7862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_gen_if7891 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_gen_if7893 = new BitSet(new long[]{0x0000800005000002L});
    public static final BitSet FOLLOW_gen_iter_in_gen_if7896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YIELD_in_yield_expr7924 = new BitSet(new long[]{0x00000800C0000202L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_testlist_in_yield_expr7926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred1_Python1249 = new BitSet(new long[]{0x0000080000000200L});
    public static final BitSet FOLLOW_fpdef_in_synpred1_Python1251 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred1_Python1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_testlist_in_synpred2_Python1642 = new BitSet(new long[]{0x7FF8000000000000L});
    public static final BitSet FOLLOW_augassign_in_synpred2_Python1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_testlist_in_synpred3_Python1761 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_ASSIGN_in_synpred3_Python1764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_synpred4_Python2289 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred4_Python2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_synpred5_Python2388 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred5_Python2391 = new BitSet(new long[]{0x00000800C0000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_test_in_synpred5_Python2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_decorators_in_synpred6_Python3455 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_DEF_in_synpred6_Python3458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_synpred7_Python4191 = new BitSet(new long[]{0x0000080080000200L,0x0000000007EB1800L});
    public static final BitSet FOLLOW_or_test_in_synpred7_Python4193 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_ORELSE_in_synpred7_Python4196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_synpred8_Python6821 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_COLON_in_synpred8_Python6824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COLON_in_synpred9_Python6872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_synpred10_Python7017 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred10_Python7020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_test_in_synpred11_Python7158 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred11_Python7161 = new BitSet(new long[]{0x0000000000000002L});

}