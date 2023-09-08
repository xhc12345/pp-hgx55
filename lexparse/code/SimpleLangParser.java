// Generated from SimpleLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Num_Const=1, Char_Const=2, Boolean_Const=3, ADD=4, SUB=5, MUL=6, DIV=7, 
		MOD=8, EQ=9, NEQ=10, GT=11, GTEQ=12, LT=13, LTEQ=14, AND=15, OR=16, ASSIGN=17, 
		INCREMENT=18, DECREMENT=19, SEMICOLON=20, COMMA=21, DOT=22, LPAREN=23, 
		RPAREN=24, LBRACKET=25, RBRACKET=26, LBRACE=27, RBRACE=28, PROJECT=29, 
		BREAK=30, CLASS=31, INTERFACE=32, ENUM=33, ELSE=34, CONST=35, IF=36, NEW=37, 
		PRINT=38, READ=39, RETURN=40, VOID=41, FOR=42, EXTENDS=43, IMPLEMENTS=44, 
		CONTINUE=45, ID=46, STRING=47, WHITE_SPACE=48, COMMENT=49;
	public static final int
		RULE_project = 0, RULE_constDecl = 1, RULE_enumDecl = 2, RULE_varDecl = 3, 
		RULE_var = 4, RULE_classDecl = 5, RULE_interfaceDecl = 6, RULE_interfaceMethodDecl = 7, 
		RULE_methodDecl = 8, RULE_formPars = 9, RULE_formPar = 10, RULE_type = 11, 
		RULE_statement = 12, RULE_designatorStatement = 13, RULE_actPars = 14, 
		RULE_condition = 15, RULE_condTerm = 16, RULE_condFact = 17, RULE_expr = 18, 
		RULE_term = 19, RULE_factor = 20, RULE_designator = 21, RULE_assignop = 22, 
		RULE_relop = 23, RULE_addop = 24, RULE_mulop = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"project", "constDecl", "enumDecl", "varDecl", "var", "classDecl", "interfaceDecl", 
			"interfaceMethodDecl", "methodDecl", "formPars", "formPar", "type", "statement", 
			"designatorStatement", "actPars", "condition", "condTerm", "condFact", 
			"expr", "term", "factor", "designator", "assignop", "relop", "addop", 
			"mulop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", 
			"'>'", "'>='", "'<'", "'<='", "'&&'", "'||'", "'='", "'++'", "'--'", 
			"';'", "','", "'.'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'project'", 
			"'break'", "'class'", "'interface'", "'enum'", "'else'", "'const'", "'if'", 
			"'new'", "'print'", "'read'", "'return'", "'void'", "'for'", "'extends'", 
			"'implements'", "'continue'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Num_Const", "Char_Const", "Boolean_Const", "ADD", "SUB", "MUL", 
			"DIV", "MOD", "EQ", "NEQ", "GT", "GTEQ", "LT", "LTEQ", "AND", "OR", "ASSIGN", 
			"INCREMENT", "DECREMENT", "SEMICOLON", "COMMA", "DOT", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "PROJECT", "BREAK", "CLASS", 
			"INTERFACE", "ENUM", "ELSE", "CONST", "IF", "NEW", "PRINT", "READ", "RETURN", 
			"VOID", "FOR", "EXTENDS", "IMPLEMENTS", "CONTINUE", "ID", "STRING", "WHITE_SPACE", 
			"COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProjectContext extends ParserRuleContext {
		public TerminalNode PROJECT() { return getToken(SimpleLangParser.PROJECT, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public List<ConstDeclContext> constDecl() {
			return getRuleContexts(ConstDeclContext.class);
		}
		public ConstDeclContext constDecl(int i) {
			return getRuleContext(ConstDeclContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public List<EnumDeclContext> enumDecl() {
			return getRuleContexts(EnumDeclContext.class);
		}
		public EnumDeclContext enumDecl(int i) {
			return getRuleContext(EnumDeclContext.class,i);
		}
		public List<InterfaceDeclContext> interfaceDecl() {
			return getRuleContexts(InterfaceDeclContext.class);
		}
		public InterfaceDeclContext interfaceDecl(int i) {
			return getRuleContext(InterfaceDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ProjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_project; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterProject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitProject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectContext project() throws RecognitionException {
		ProjectContext _localctx = new ProjectContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_project);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(PROJECT);
			setState(53);
			match(ID);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CLASS) | (1L << INTERFACE) | (1L << ENUM) | (1L << CONST) | (1L << ID))) != 0)) {
				{
				setState(59);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CONST:
					{
					setState(54);
					constDecl();
					}
					break;
				case ID:
					{
					setState(55);
					varDecl();
					}
					break;
				case CLASS:
					{
					setState(56);
					classDecl();
					}
					break;
				case ENUM:
					{
					setState(57);
					enumDecl();
					}
					break;
				case INTERFACE:
					{
					setState(58);
					interfaceDecl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(LBRACE);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOID || _la==ID) {
				{
				{
				setState(65);
				methodDecl();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(RBRACE);
			setState(72);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(SimpleLangParser.CONST, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLangParser.ASSIGN, i);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleLangParser.SEMICOLON, 0); }
		public List<TerminalNode> Num_Const() { return getTokens(SimpleLangParser.Num_Const); }
		public TerminalNode Num_Const(int i) {
			return getToken(SimpleLangParser.Num_Const, i);
		}
		public List<TerminalNode> Char_Const() { return getTokens(SimpleLangParser.Char_Const); }
		public TerminalNode Char_Const(int i) {
			return getToken(SimpleLangParser.Char_Const, i);
		}
		public List<TerminalNode> Boolean_Const() { return getTokens(SimpleLangParser.Boolean_Const); }
		public TerminalNode Boolean_Const(int i) {
			return getToken(SimpleLangParser.Boolean_Const, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitConstDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(CONST);
			setState(75);
			type();
			setState(76);
			match(ID);
			setState(77);
			match(ASSIGN);
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Num_Const) | (1L << Char_Const) | (1L << Boolean_Const))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(79);
				match(COMMA);
				setState(80);
				match(ID);
				setState(81);
				match(ASSIGN);
				setState(82);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Num_Const) | (1L << Char_Const) | (1L << Boolean_Const))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDeclContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(SimpleLangParser.ENUM, 0); }
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(SimpleLangParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(SimpleLangParser.ASSIGN, i);
		}
		public List<TerminalNode> Num_Const() { return getTokens(SimpleLangParser.Num_Const); }
		public TerminalNode Num_Const(int i) {
			return getToken(SimpleLangParser.Num_Const, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public EnumDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterEnumDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitEnumDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitEnumDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDeclContext enumDecl() throws RecognitionException {
		EnumDeclContext _localctx = new EnumDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_enumDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(ENUM);
			setState(91);
			match(ID);
			setState(92);
			match(LBRACE);
			setState(93);
			match(ID);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(94);
				match(ASSIGN);
				setState(95);
				match(Num_Const);
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(98);
				match(COMMA);
				setState(99);
				match(ID);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(100);
					match(ASSIGN);
					setState(101);
					match(Num_Const);
					}
				}

				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(SimpleLangParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			type();
			setState(112);
			var();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(113);
				match(COMMA);
				setState(114);
				var();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LBRACKET() { return getToken(SimpleLangParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(SimpleLangParser.RBRACKET, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(123);
				match(LBRACKET);
				setState(124);
				match(RBRACKET);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(SimpleLangParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(SimpleLangParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(SimpleLangParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(SimpleLangParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(SimpleLangParser.RBRACE, i);
		}
		public TerminalNode EXTENDS() { return getToken(SimpleLangParser.EXTENDS, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode IMPLEMENTS() { return getToken(SimpleLangParser.IMPLEMENTS, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(CLASS);
			setState(128);
			match(ID);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(129);
				match(EXTENDS);
				setState(130);
				type();
				}
			}

			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(133);
				match(IMPLEMENTS);
				setState(134);
				type();
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(135);
					match(COMMA);
					setState(136);
					type();
					}
					}
					setState(141);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(144);
			match(LBRACE);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(145);
				varDecl();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(151);
				match(LBRACE);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID || _la==ID) {
					{
					{
					setState(152);
					methodDecl();
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(158);
				match(RBRACE);
				}
			}

			setState(161);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDeclContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(SimpleLangParser.INTERFACE, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public List<InterfaceMethodDeclContext> interfaceMethodDecl() {
			return getRuleContexts(InterfaceMethodDeclContext.class);
		}
		public InterfaceMethodDeclContext interfaceMethodDecl(int i) {
			return getRuleContext(InterfaceMethodDeclContext.class,i);
		}
		public InterfaceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInterfaceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInterfaceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInterfaceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDeclContext interfaceDecl() throws RecognitionException {
		InterfaceDeclContext _localctx = new InterfaceDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_interfaceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(INTERFACE);
			setState(164);
			match(ID);
			setState(165);
			match(LBRACE);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOID || _la==ID) {
				{
				{
				setState(166);
				interfaceMethodDecl();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceMethodDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(SimpleLangParser.SEMICOLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SimpleLangParser.VOID, 0); }
		public FormParsContext formPars() {
			return getRuleContext(FormParsContext.class,0);
		}
		public InterfaceMethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterInterfaceMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitInterfaceMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInterfaceMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceMethodDeclContext interfaceMethodDecl() throws RecognitionException {
		InterfaceMethodDeclContext _localctx = new InterfaceMethodDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_interfaceMethodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(174);
				type();
				}
				break;
			case VOID:
				{
				setState(175);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(178);
			match(ID);
			setState(179);
			match(LPAREN);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(180);
				formPars();
				}
			}

			setState(183);
			match(RPAREN);
			setState(184);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(SimpleLangParser.VOID, 0); }
		public FormParsContext formPars() {
			return getRuleContext(FormParsContext.class,0);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(186);
				type();
				}
				break;
			case VOID:
				{
				setState(187);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(190);
			match(ID);
			setState(191);
			match(LPAREN);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(192);
				formPars();
				}
			}

			setState(195);
			match(RPAREN);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(196);
				varDecl();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
			match(LBRACE);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << BREAK) | (1L << IF) | (1L << PRINT) | (1L << READ) | (1L << RETURN) | (1L << FOR) | (1L << CONTINUE) | (1L << ID))) != 0)) {
				{
				{
				setState(203);
				statement();
				}
				}
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(209);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormParsContext extends ParserRuleContext {
		public List<FormParContext> formPar() {
			return getRuleContexts(FormParContext.class);
		}
		public FormParContext formPar(int i) {
			return getRuleContext(FormParContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public FormParsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formPars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFormPars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFormPars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFormPars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormParsContext formPars() throws RecognitionException {
		FormParsContext _localctx = new FormParsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_formPars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			formPar();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(212);
				match(COMMA);
				setState(213);
				formPar();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormParContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LBRACKET() { return getToken(SimpleLangParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(SimpleLangParser.RBRACKET, 0); }
		public FormParContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formPar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFormPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFormPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFormPar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormParContext formPar() throws RecognitionException {
		FormParContext _localctx = new FormParContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formPar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			type();
			setState(220);
			match(ID);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(221);
				match(LBRACKET);
				setState(222);
				match(RBRACKET);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public List<DesignatorStatementContext> designatorStatement() {
			return getRuleContexts(DesignatorStatementContext.class);
		}
		public DesignatorStatementContext designatorStatement(int i) {
			return getRuleContext(DesignatorStatementContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(SimpleLangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(SimpleLangParser.SEMICOLON, i);
		}
		public TerminalNode IF() { return getToken(SimpleLangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(SimpleLangParser.ELSE, 0); }
		public TerminalNode FOR() { return getToken(SimpleLangParser.FOR, 0); }
		public TerminalNode BREAK() { return getToken(SimpleLangParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(SimpleLangParser.CONTINUE, 0); }
		public TerminalNode RETURN() { return getToken(SimpleLangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode READ() { return getToken(SimpleLangParser.READ, 0); }
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(SimpleLangParser.PRINT, 0); }
		public TerminalNode COMMA() { return getToken(SimpleLangParser.COMMA, 0); }
		public TerminalNode Num_Const() { return getToken(SimpleLangParser.Num_Const, 0); }
		public TerminalNode LBRACE() { return getToken(SimpleLangParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(SimpleLangParser.RBRACE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		int _la;
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				designatorStatement();
				setState(228);
				match(SEMICOLON);
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				match(IF);
				setState(231);
				match(LPAREN);
				setState(232);
				condition();
				setState(233);
				match(RPAREN);
				setState(234);
				statement();
				setState(237);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(235);
					match(ELSE);
					setState(236);
					statement();
					}
					break;
				}
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(FOR);
				setState(240);
				match(LPAREN);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(241);
					designatorStatement();
					}
				}

				setState(244);
				match(SEMICOLON);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Num_Const) | (1L << Char_Const) | (1L << Boolean_Const) | (1L << SUB) | (1L << LPAREN) | (1L << NEW) | (1L << ID))) != 0)) {
					{
					setState(245);
					condition();
					}
				}

				setState(248);
				match(SEMICOLON);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(249);
					designatorStatement();
					}
				}

				setState(252);
				match(RPAREN);
				setState(253);
				statement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 4);
				{
				setState(254);
				match(BREAK);
				setState(255);
				match(SEMICOLON);
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(256);
				match(CONTINUE);
				setState(257);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 6);
				{
				setState(258);
				match(RETURN);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Num_Const) | (1L << Char_Const) | (1L << Boolean_Const) | (1L << SUB) | (1L << LPAREN) | (1L << NEW) | (1L << ID))) != 0)) {
					{
					setState(259);
					expr();
					}
				}

				setState(262);
				match(SEMICOLON);
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 7);
				{
				setState(263);
				match(READ);
				setState(264);
				match(LPAREN);
				setState(265);
				designator();
				setState(266);
				match(RPAREN);
				setState(267);
				match(SEMICOLON);
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 8);
				{
				setState(269);
				match(PRINT);
				setState(270);
				match(LPAREN);
				setState(271);
				expr();
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(272);
					match(COMMA);
					setState(273);
					match(Num_Const);
					}
				}

				setState(276);
				match(RPAREN);
				setState(277);
				match(SEMICOLON);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 9);
				{
				setState(279);
				match(LBRACE);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << BREAK) | (1L << IF) | (1L << PRINT) | (1L << READ) | (1L << RETURN) | (1L << FOR) | (1L << CONTINUE) | (1L << ID))) != 0)) {
					{
					{
					setState(280);
					statement();
					}
					}
					setState(285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(286);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesignatorStatementContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public AssignopContext assignop() {
			return getRuleContext(AssignopContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public TerminalNode INCREMENT() { return getToken(SimpleLangParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(SimpleLangParser.DECREMENT, 0); }
		public ActParsContext actPars() {
			return getRuleContext(ActParsContext.class,0);
		}
		public DesignatorStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designatorStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignatorStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignatorStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignatorStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorStatementContext designatorStatement() throws RecognitionException {
		DesignatorStatementContext _localctx = new DesignatorStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_designatorStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			designator();
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				{
				setState(290);
				assignop();
				setState(291);
				expr();
				}
				break;
			case LPAREN:
				{
				setState(293);
				match(LPAREN);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Num_Const) | (1L << Char_Const) | (1L << Boolean_Const) | (1L << SUB) | (1L << LPAREN) | (1L << NEW) | (1L << ID))) != 0)) {
					{
					setState(294);
					actPars();
					}
				}

				setState(297);
				match(RPAREN);
				}
				break;
			case INCREMENT:
				{
				setState(298);
				match(INCREMENT);
				}
				break;
			case DECREMENT:
				{
				setState(299);
				match(DECREMENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActParsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public ActParsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actPars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterActPars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitActPars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitActPars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActParsContext actPars() throws RecognitionException {
		ActParsContext _localctx = new ActParsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_actPars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			expr();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(303);
				match(COMMA);
				setState(304);
				expr();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<CondTermContext> condTerm() {
			return getRuleContexts(CondTermContext.class);
		}
		public CondTermContext condTerm(int i) {
			return getRuleContext(CondTermContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(SimpleLangParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(SimpleLangParser.OR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			condTerm();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(311);
				match(OR);
				setState(312);
				condTerm();
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondTermContext extends ParserRuleContext {
		public List<CondFactContext> condFact() {
			return getRuleContexts(CondFactContext.class);
		}
		public CondFactContext condFact(int i) {
			return getRuleContext(CondFactContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(SimpleLangParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimpleLangParser.AND, i);
		}
		public CondTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCondTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCondTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCondTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondTermContext condTerm() throws RecognitionException {
		CondTermContext _localctx = new CondTermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			condFact();
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(319);
				match(AND);
				setState(320);
				condFact();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondFactContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelopContext relop() {
			return getRuleContext(RelopContext.class,0);
		}
		public CondFactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condFact; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterCondFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitCondFact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCondFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondFactContext condFact() throws RecognitionException {
		CondFactContext _localctx = new CondFactContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_condFact);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			expr();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << GTEQ) | (1L << LT) | (1L << LTEQ))) != 0)) {
				{
				setState(327);
				relop();
				setState(328);
				expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode SUB() { return getToken(SimpleLangParser.SUB, 0); }
		public List<AddopContext> addop() {
			return getRuleContexts(AddopContext.class);
		}
		public AddopContext addop(int i) {
			return getRuleContext(AddopContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(332);
				match(SUB);
				}
			}

			setState(335);
			term();
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(336);
				addop();
				setState(337);
				term();
				}
				}
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<MulopContext> mulop() {
			return getRuleContexts(MulopContext.class);
		}
		public MulopContext mulop(int i) {
			return getRuleContext(MulopContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			factor();
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(345);
				mulop();
				setState(346);
				factor();
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public DesignatorContext designator() {
			return getRuleContext(DesignatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(SimpleLangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleLangParser.RPAREN, 0); }
		public ActParsContext actPars() {
			return getRuleContext(ActParsContext.class,0);
		}
		public TerminalNode Num_Const() { return getToken(SimpleLangParser.Num_Const, 0); }
		public TerminalNode Char_Const() { return getToken(SimpleLangParser.Char_Const, 0); }
		public TerminalNode Boolean_Const() { return getToken(SimpleLangParser.Boolean_Const, 0); }
		public TerminalNode NEW() { return getToken(SimpleLangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(SimpleLangParser.LBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(SimpleLangParser.RBRACKET, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_factor);
		int _la;
		try {
			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				designator();
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(354);
					match(LPAREN);
					setState(356);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Num_Const) | (1L << Char_Const) | (1L << Boolean_Const) | (1L << SUB) | (1L << LPAREN) | (1L << NEW) | (1L << ID))) != 0)) {
						{
						setState(355);
						actPars();
						}
					}

					setState(358);
					match(RPAREN);
					}
				}

				}
				break;
			case Num_Const:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				match(Num_Const);
				}
				break;
			case Char_Const:
				enterOuterAlt(_localctx, 3);
				{
				setState(362);
				match(Char_Const);
				}
				break;
			case Boolean_Const:
				enterOuterAlt(_localctx, 4);
				{
				setState(363);
				match(Boolean_Const);
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 5);
				{
				setState(364);
				match(NEW);
				setState(365);
				type();
				setState(370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(366);
					match(LBRACKET);
					setState(367);
					expr();
					setState(368);
					match(RBRACKET);
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(372);
				match(LPAREN);
				setState(373);
				expr();
				setState(374);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DesignatorContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(SimpleLangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(SimpleLangParser.DOT, i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(SimpleLangParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(SimpleLangParser.LBRACKET, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(SimpleLangParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(SimpleLangParser.RBRACKET, i);
		}
		public DesignatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterDesignator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitDesignator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDesignator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DesignatorContext designator() throws RecognitionException {
		DesignatorContext _localctx = new DesignatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_designator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(ID);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==LBRACKET) {
				{
				setState(385);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					{
					setState(379);
					match(DOT);
					setState(380);
					match(ID);
					}
					}
					break;
				case LBRACKET:
					{
					{
					setState(381);
					match(LBRACKET);
					setState(382);
					expr();
					setState(383);
					match(RBRACKET);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignopContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(SimpleLangParser.ASSIGN, 0); }
		public AssignopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAssignop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAssignop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignopContext assignop() throws RecognitionException {
		AssignopContext _localctx = new AssignopContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(ASSIGN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelopContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(SimpleLangParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(SimpleLangParser.NEQ, 0); }
		public TerminalNode GT() { return getToken(SimpleLangParser.GT, 0); }
		public TerminalNode GTEQ() { return getToken(SimpleLangParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(SimpleLangParser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(SimpleLangParser.LTEQ, 0); }
		public RelopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterRelop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitRelop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitRelop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelopContext relop() throws RecognitionException {
		RelopContext _localctx = new RelopContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_relop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << GT) | (1L << GTEQ) | (1L << LT) | (1L << LTEQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddopContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(SimpleLangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(SimpleLangParser.SUB, 0); }
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitAddop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAddop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(SimpleLangParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(SimpleLangParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(SimpleLangParser.MOD, 0); }
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleLangListener ) ((SimpleLangListener)listener).exitMulop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMulop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0191\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2>\n\2\f\2\16\2A\13"+
		"\2\3\2\3\2\7\2E\n\2\f\2\16\2H\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\7\3V\n\3\f\3\16\3Y\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4c\n\4\3\4\3\4\3\4\3\4\5\4i\n\4\7\4k\n\4\f\4\16\4n\13\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\7\5v\n\5\f\5\16\5y\13\5\3\5\3\5\3\6\3\6\3\6\5\6\u0080\n\6\3"+
		"\7\3\7\3\7\3\7\5\7\u0086\n\7\3\7\3\7\3\7\3\7\7\7\u008c\n\7\f\7\16\7\u008f"+
		"\13\7\5\7\u0091\n\7\3\7\3\7\7\7\u0095\n\7\f\7\16\7\u0098\13\7\3\7\3\7"+
		"\7\7\u009c\n\7\f\7\16\7\u009f\13\7\3\7\5\7\u00a2\n\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\7\b\u00aa\n\b\f\b\16\b\u00ad\13\b\3\b\3\b\3\t\3\t\5\t\u00b3\n\t"+
		"\3\t\3\t\3\t\5\t\u00b8\n\t\3\t\3\t\3\t\3\n\3\n\5\n\u00bf\n\n\3\n\3\n\3"+
		"\n\5\n\u00c4\n\n\3\n\3\n\7\n\u00c8\n\n\f\n\16\n\u00cb\13\n\3\n\3\n\7\n"+
		"\u00cf\n\n\f\n\16\n\u00d2\13\n\3\n\3\n\3\13\3\13\3\13\7\13\u00d9\n\13"+
		"\f\13\16\13\u00dc\13\13\3\f\3\f\3\f\3\f\5\f\u00e2\n\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f0\n\16\3\16\3\16\3\16"+
		"\5\16\u00f5\n\16\3\16\3\16\5\16\u00f9\n\16\3\16\3\16\5\16\u00fd\n\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0107\n\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u0115\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u011c\n\16\f\16\16\16\u011f\13\16\3\16\5\16\u0122"+
		"\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u012a\n\17\3\17\3\17\3\17\5\17"+
		"\u012f\n\17\3\20\3\20\3\20\7\20\u0134\n\20\f\20\16\20\u0137\13\20\3\21"+
		"\3\21\3\21\7\21\u013c\n\21\f\21\16\21\u013f\13\21\3\22\3\22\3\22\7\22"+
		"\u0144\n\22\f\22\16\22\u0147\13\22\3\23\3\23\3\23\3\23\5\23\u014d\n\23"+
		"\3\24\5\24\u0150\n\24\3\24\3\24\3\24\3\24\7\24\u0156\n\24\f\24\16\24\u0159"+
		"\13\24\3\25\3\25\3\25\3\25\7\25\u015f\n\25\f\25\16\25\u0162\13\25\3\26"+
		"\3\26\3\26\5\26\u0167\n\26\3\26\5\26\u016a\n\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u0175\n\26\3\26\3\26\3\26\3\26\5\26\u017b"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0184\n\27\f\27\16\27\u0187"+
		"\13\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\2\2\34\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\6\3\2\3\5\3\2\13\20\3"+
		"\2\6\7\3\2\b\n\2\u01b5\2\66\3\2\2\2\4L\3\2\2\2\6\\\3\2\2\2\bq\3\2\2\2"+
		"\n|\3\2\2\2\f\u0081\3\2\2\2\16\u00a5\3\2\2\2\20\u00b2\3\2\2\2\22\u00be"+
		"\3\2\2\2\24\u00d5\3\2\2\2\26\u00dd\3\2\2\2\30\u00e3\3\2\2\2\32\u0121\3"+
		"\2\2\2\34\u0123\3\2\2\2\36\u0130\3\2\2\2 \u0138\3\2\2\2\"\u0140\3\2\2"+
		"\2$\u0148\3\2\2\2&\u014f\3\2\2\2(\u015a\3\2\2\2*\u017a\3\2\2\2,\u017c"+
		"\3\2\2\2.\u0188\3\2\2\2\60\u018a\3\2\2\2\62\u018c\3\2\2\2\64\u018e\3\2"+
		"\2\2\66\67\7\37\2\2\67?\7\60\2\28>\5\4\3\29>\5\b\5\2:>\5\f\7\2;>\5\6\4"+
		"\2<>\5\16\b\2=8\3\2\2\2=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>A\3\2"+
		"\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BF\7\35\2\2CE\5\22\n\2DC\3"+
		"\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\36\2\2JK"+
		"\7\2\2\3K\3\3\2\2\2LM\7%\2\2MN\5\30\r\2NO\7\60\2\2OP\7\23\2\2PW\t\2\2"+
		"\2QR\7\27\2\2RS\7\60\2\2ST\7\23\2\2TV\t\2\2\2UQ\3\2\2\2VY\3\2\2\2WU\3"+
		"\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Z[\7\26\2\2[\5\3\2\2\2\\]\7#\2\2]"+
		"^\7\60\2\2^_\7\35\2\2_b\7\60\2\2`a\7\23\2\2ac\7\3\2\2b`\3\2\2\2bc\3\2"+
		"\2\2cl\3\2\2\2de\7\27\2\2eh\7\60\2\2fg\7\23\2\2gi\7\3\2\2hf\3\2\2\2hi"+
		"\3\2\2\2ik\3\2\2\2jd\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2n"+
		"l\3\2\2\2op\7\36\2\2p\7\3\2\2\2qr\5\30\r\2rw\5\n\6\2st\7\27\2\2tv\5\n"+
		"\6\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\26"+
		"\2\2{\t\3\2\2\2|\177\7\60\2\2}~\7\33\2\2~\u0080\7\34\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\13\3\2\2\2\u0081\u0082\7!\2\2\u0082\u0085\7\60"+
		"\2\2\u0083\u0084\7-\2\2\u0084\u0086\5\30\r\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0090\3\2\2\2\u0087\u0088\7.\2\2\u0088\u008d\5\30"+
		"\r\2\u0089\u008a\7\27\2\2\u008a\u008c\5\30\r\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0091\3\2"+
		"\2\2\u008f\u008d\3\2\2\2\u0090\u0087\3\2\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0096\7\35\2\2\u0093\u0095\5\b\5\2\u0094\u0093\3"+
		"\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u00a1\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009d\7\35\2\2\u009a\u009c\5"+
		"\22\n\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a2\7\36"+
		"\2\2\u00a1\u0099\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\7\36\2\2\u00a4\r\3\2\2\2\u00a5\u00a6\7\"\2\2\u00a6\u00a7\7\60\2"+
		"\2\u00a7\u00ab\7\35\2\2\u00a8\u00aa\5\20\t\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2"+
		"\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af\7\36\2\2\u00af\17\3\2\2\2\u00b0\u00b3"+
		"\5\30\r\2\u00b1\u00b3\7+\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b5\7\60\2\2\u00b5\u00b7\7\31\2\2\u00b6\u00b8\5"+
		"\24\13\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\7\32\2\2\u00ba\u00bb\7\26\2\2\u00bb\21\3\2\2\2\u00bc\u00bf\5\30"+
		"\r\2\u00bd\u00bf\7+\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\7\60\2\2\u00c1\u00c3\7\31\2\2\u00c2\u00c4\5"+
		"\24\13\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c9\7\32\2\2\u00c6\u00c8\5\b\5\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3"+
		"\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cc\u00d0\7\35\2\2\u00cd\u00cf\5\32\16\2\u00ce\u00cd"+
		"\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\u00d3\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00d4\7\36\2\2\u00d4\23\3\2\2"+
		"\2\u00d5\u00da\5\26\f\2\u00d6\u00d7\7\27\2\2\u00d7\u00d9\5\26\f\2\u00d8"+
		"\u00d6\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\25\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\5\30\r\2\u00de\u00e1"+
		"\7\60\2\2\u00df\u00e0\7\33\2\2\u00e0\u00e2\7\34\2\2\u00e1\u00df\3\2\2"+
		"\2\u00e1\u00e2\3\2\2\2\u00e2\27\3\2\2\2\u00e3\u00e4\7\60\2\2\u00e4\31"+
		"\3\2\2\2\u00e5\u00e6\5\34\17\2\u00e6\u00e7\7\26\2\2\u00e7\u0122\3\2\2"+
		"\2\u00e8\u00e9\7&\2\2\u00e9\u00ea\7\31\2\2\u00ea\u00eb\5 \21\2\u00eb\u00ec"+
		"\7\32\2\2\u00ec\u00ef\5\32\16\2\u00ed\u00ee\7$\2\2\u00ee\u00f0\5\32\16"+
		"\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u0122\3\2\2\2\u00f1\u00f2"+
		"\7,\2\2\u00f2\u00f4\7\31\2\2\u00f3\u00f5\5\34\17\2\u00f4\u00f3\3\2\2\2"+
		"\u00f4\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\7\26\2\2\u00f7\u00f9"+
		"\5 \21\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fc\7\26\2\2\u00fb\u00fd\5\34\17\2\u00fc\u00fb\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7\32\2\2\u00ff\u0122\5\32\16"+
		"\2\u0100\u0101\7 \2\2\u0101\u0122\7\26\2\2\u0102\u0103\7/\2\2\u0103\u0122"+
		"\7\26\2\2\u0104\u0106\7*\2\2\u0105\u0107\5&\24\2\u0106\u0105\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0122\7\26\2\2\u0109\u010a\7"+
		")\2\2\u010a\u010b\7\31\2\2\u010b\u010c\5,\27\2\u010c\u010d\7\32\2\2\u010d"+
		"\u010e\7\26\2\2\u010e\u0122\3\2\2\2\u010f\u0110\7(\2\2\u0110\u0111\7\31"+
		"\2\2\u0111\u0114\5&\24\2\u0112\u0113\7\27\2\2\u0113\u0115\7\3\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0117\7\32"+
		"\2\2\u0117\u0118\7\26\2\2\u0118\u0122\3\2\2\2\u0119\u011d\7\35\2\2\u011a"+
		"\u011c\5\32\16\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b\3"+
		"\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0122\7\36\2\2\u0121\u00e5\3\2\2\2\u0121\u00e8\3\2\2\2\u0121\u00f1\3"+
		"\2\2\2\u0121\u0100\3\2\2\2\u0121\u0102\3\2\2\2\u0121\u0104\3\2\2\2\u0121"+
		"\u0109\3\2\2\2\u0121\u010f\3\2\2\2\u0121\u0119\3\2\2\2\u0122\33\3\2\2"+
		"\2\u0123\u012e\5,\27\2\u0124\u0125\5.\30\2\u0125\u0126\5&\24\2\u0126\u012f"+
		"\3\2\2\2\u0127\u0129\7\31\2\2\u0128\u012a\5\36\20\2\u0129\u0128\3\2\2"+
		"\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012f\7\32\2\2\u012c"+
		"\u012f\7\24\2\2\u012d\u012f\7\25\2\2\u012e\u0124\3\2\2\2\u012e\u0127\3"+
		"\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3\2\2\2\u012f\35\3\2\2\2\u0130"+
		"\u0135\5&\24\2\u0131\u0132\7\27\2\2\u0132\u0134\5&\24\2\u0133\u0131\3"+
		"\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\37\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u013d\5\"\22\2\u0139\u013a\7\22"+
		"\2\2\u013a\u013c\5\"\22\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e!\3\2\2\2\u013f\u013d\3\2\2\2"+
		"\u0140\u0145\5$\23\2\u0141\u0142\7\21\2\2\u0142\u0144\5$\23\2\u0143\u0141"+
		"\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146"+
		"#\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014c\5&\24\2\u0149\u014a\5\60\31"+
		"\2\u014a\u014b\5&\24\2\u014b\u014d\3\2\2\2\u014c\u0149\3\2\2\2\u014c\u014d"+
		"\3\2\2\2\u014d%\3\2\2\2\u014e\u0150\7\7\2\2\u014f\u014e\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0157\5(\25\2\u0152\u0153\5\62"+
		"\32\2\u0153\u0154\5(\25\2\u0154\u0156\3\2\2\2\u0155\u0152\3\2\2\2\u0156"+
		"\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\'\3\2\2\2"+
		"\u0159\u0157\3\2\2\2\u015a\u0160\5*\26\2\u015b\u015c\5\64\33\2\u015c\u015d"+
		"\5*\26\2\u015d\u015f\3\2\2\2\u015e\u015b\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161)\3\2\2\2\u0162\u0160\3\2\2\2"+
		"\u0163\u0169\5,\27\2\u0164\u0166\7\31\2\2\u0165\u0167\5\36\20\2\u0166"+
		"\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\7\32"+
		"\2\2\u0169\u0164\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u017b\3\2\2\2\u016b"+
		"\u017b\7\3\2\2\u016c\u017b\7\4\2\2\u016d\u017b\7\5\2\2\u016e\u016f\7\'"+
		"\2\2\u016f\u0174\5\30\r\2\u0170\u0171\7\33\2\2\u0171\u0172\5&\24\2\u0172"+
		"\u0173\7\34\2\2\u0173\u0175\3\2\2\2\u0174\u0170\3\2\2\2\u0174\u0175\3"+
		"\2\2\2\u0175\u017b\3\2\2\2\u0176\u0177\7\31\2\2\u0177\u0178\5&\24\2\u0178"+
		"\u0179\7\32\2\2\u0179\u017b\3\2\2\2\u017a\u0163\3\2\2\2\u017a\u016b\3"+
		"\2\2\2\u017a\u016c\3\2\2\2\u017a\u016d\3\2\2\2\u017a\u016e\3\2\2\2\u017a"+
		"\u0176\3\2\2\2\u017b+\3\2\2\2\u017c\u0185\7\60\2\2\u017d\u017e\7\30\2"+
		"\2\u017e\u0184\7\60\2\2\u017f\u0180\7\33\2\2\u0180\u0181\5&\24\2\u0181"+
		"\u0182\7\34\2\2\u0182\u0184\3\2\2\2\u0183\u017d\3\2\2\2\u0183\u017f\3"+
		"\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186"+
		"-\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7\23\2\2\u0189/\3\2\2\2\u018a"+
		"\u018b\t\3\2\2\u018b\61\3\2\2\2\u018c\u018d\t\4\2\2\u018d\63\3\2\2\2\u018e"+
		"\u018f\t\5\2\2\u018f\65\3\2\2\2\61=?FWbhlw\177\u0085\u008d\u0090\u0096"+
		"\u009d\u00a1\u00ab\u00b2\u00b7\u00be\u00c3\u00c9\u00d0\u00da\u00e1\u00ef"+
		"\u00f4\u00f8\u00fc\u0106\u0114\u011d\u0121\u0129\u012e\u0135\u013d\u0145"+
		"\u014c\u014f\u0157\u0160\u0166\u0169\u0174\u017a\u0183\u0185";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}