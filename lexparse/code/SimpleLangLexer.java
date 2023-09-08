// Generated from SimpleLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLangLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Num_Const", "Char_Const", "Boolean_Const", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "EQ", "NEQ", "GT", "GTEQ", "LT", "LTEQ", "AND", "OR", "ASSIGN", 
			"INCREMENT", "DECREMENT", "SEMICOLON", "COMMA", "DOT", "LPAREN", "RPAREN", 
			"LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "PROJECT", "BREAK", "CLASS", 
			"INTERFACE", "ENUM", "ELSE", "CONST", "IF", "NEW", "PRINT", "READ", "RETURN", 
			"VOID", "FOR", "EXTENDS", "IMPLEMENTS", "CONTINUE", "ID", "STRING", "WHITE_SPACE", 
			"COMMENT"
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


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0141\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\5\2g\n\2\3"+
		"\2\6\2j\n\2\r\2\16\2k\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\5\4{\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+"+
		"\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3."+
		"\3.\3.\3.\3.\3.\3.\3.\3/\3/\7/\u0125\n/\f/\16/\u0128\13/\3\60\3\60\7\60"+
		"\u012c\n\60\f\60\16\60\u012f\13\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\7\62\u013b\n\62\f\62\16\62\u013e\13\62\3\62\3\62\2\2\63"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3\2\b\3\2\62;\5\2C"+
		"\\aac|\6\2\62;C\\aac|\3\2c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u0146\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U"+
		"\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\3f\3\2\2\2\5m\3\2\2\2\7z\3\2\2\2\t|\3\2\2\2\13~\3\2\2"+
		"\2\r\u0080\3\2\2\2\17\u0082\3\2\2\2\21\u0084\3\2\2\2\23\u0086\3\2\2\2"+
		"\25\u0089\3\2\2\2\27\u008c\3\2\2\2\31\u008e\3\2\2\2\33\u0091\3\2\2\2\35"+
		"\u0093\3\2\2\2\37\u0096\3\2\2\2!\u0099\3\2\2\2#\u009c\3\2\2\2%\u009e\3"+
		"\2\2\2\'\u00a1\3\2\2\2)\u00a4\3\2\2\2+\u00a6\3\2\2\2-\u00a8\3\2\2\2/\u00aa"+
		"\3\2\2\2\61\u00ac\3\2\2\2\63\u00ae\3\2\2\2\65\u00b0\3\2\2\2\67\u00b2\3"+
		"\2\2\29\u00b4\3\2\2\2;\u00b6\3\2\2\2=\u00be\3\2\2\2?\u00c4\3\2\2\2A\u00ca"+
		"\3\2\2\2C\u00d4\3\2\2\2E\u00d9\3\2\2\2G\u00de\3\2\2\2I\u00e4\3\2\2\2K"+
		"\u00e7\3\2\2\2M\u00eb\3\2\2\2O\u00f1\3\2\2\2Q\u00f6\3\2\2\2S\u00fd\3\2"+
		"\2\2U\u0102\3\2\2\2W\u0106\3\2\2\2Y\u010e\3\2\2\2[\u0119\3\2\2\2]\u0122"+
		"\3\2\2\2_\u0129\3\2\2\2a\u0132\3\2\2\2c\u0136\3\2\2\2eg\7/\2\2fe\3\2\2"+
		"\2fg\3\2\2\2gi\3\2\2\2hj\t\2\2\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2l\4\3\2\2\2mn\7)\2\2no\13\2\2\2op\7)\2\2p\6\3\2\2\2qr\7v\2\2rs\7t\2"+
		"\2st\7w\2\2t{\7g\2\2uv\7h\2\2vw\7c\2\2wx\7n\2\2xy\7u\2\2y{\7g\2\2zq\3"+
		"\2\2\2zu\3\2\2\2{\b\3\2\2\2|}\7-\2\2}\n\3\2\2\2~\177\7/\2\2\177\f\3\2"+
		"\2\2\u0080\u0081\7,\2\2\u0081\16\3\2\2\2\u0082\u0083\7\61\2\2\u0083\20"+
		"\3\2\2\2\u0084\u0085\7\'\2\2\u0085\22\3\2\2\2\u0086\u0087\7?\2\2\u0087"+
		"\u0088\7?\2\2\u0088\24\3\2\2\2\u0089\u008a\7#\2\2\u008a\u008b\7?\2\2\u008b"+
		"\26\3\2\2\2\u008c\u008d\7@\2\2\u008d\30\3\2\2\2\u008e\u008f\7@\2\2\u008f"+
		"\u0090\7?\2\2\u0090\32\3\2\2\2\u0091\u0092\7>\2\2\u0092\34\3\2\2\2\u0093"+
		"\u0094\7>\2\2\u0094\u0095\7?\2\2\u0095\36\3\2\2\2\u0096\u0097\7(\2\2\u0097"+
		"\u0098\7(\2\2\u0098 \3\2\2\2\u0099\u009a\7~\2\2\u009a\u009b\7~\2\2\u009b"+
		"\"\3\2\2\2\u009c\u009d\7?\2\2\u009d$\3\2\2\2\u009e\u009f\7-\2\2\u009f"+
		"\u00a0\7-\2\2\u00a0&\3\2\2\2\u00a1\u00a2\7/\2\2\u00a2\u00a3\7/\2\2\u00a3"+
		"(\3\2\2\2\u00a4\u00a5\7=\2\2\u00a5*\3\2\2\2\u00a6\u00a7\7.\2\2\u00a7,"+
		"\3\2\2\2\u00a8\u00a9\7\60\2\2\u00a9.\3\2\2\2\u00aa\u00ab\7*\2\2\u00ab"+
		"\60\3\2\2\2\u00ac\u00ad\7+\2\2\u00ad\62\3\2\2\2\u00ae\u00af\7]\2\2\u00af"+
		"\64\3\2\2\2\u00b0\u00b1\7_\2\2\u00b1\66\3\2\2\2\u00b2\u00b3\7}\2\2\u00b3"+
		"8\3\2\2\2\u00b4\u00b5\7\177\2\2\u00b5:\3\2\2\2\u00b6\u00b7\7r\2\2\u00b7"+
		"\u00b8\7t\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7l\2\2\u00ba\u00bb\7g\2\2"+
		"\u00bb\u00bc\7e\2\2\u00bc\u00bd\7v\2\2\u00bd<\3\2\2\2\u00be\u00bf\7d\2"+
		"\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7c\2\2\u00c2\u00c3"+
		"\7m\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7e\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7"+
		"\7c\2\2\u00c7\u00c8\7u\2\2\u00c8\u00c9\7u\2\2\u00c9@\3\2\2\2\u00ca\u00cb"+
		"\7k\2\2\u00cb\u00cc\7p\2\2\u00cc\u00cd\7v\2\2\u00cd\u00ce\7g\2\2\u00ce"+
		"\u00cf\7t\2\2\u00cf\u00d0\7h\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7e\2\2"+
		"\u00d2\u00d3\7g\2\2\u00d3B\3\2\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7p\2"+
		"\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7o\2\2\u00d8D\3\2\2\2\u00d9\u00da\7"+
		"g\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7g\2\2\u00ddF"+
		"\3\2\2\2\u00de\u00df\7e\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7p\2\2\u00e1"+
		"\u00e2\7u\2\2\u00e2\u00e3\7v\2\2\u00e3H\3\2\2\2\u00e4\u00e5\7k\2\2\u00e5"+
		"\u00e6\7h\2\2\u00e6J\3\2\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7g\2\2\u00e9"+
		"\u00ea\7y\2\2\u00eaL\3\2\2\2\u00eb\u00ec\7r\2\2\u00ec\u00ed\7t\2\2\u00ed"+
		"\u00ee\7k\2\2\u00ee\u00ef\7p\2\2\u00ef\u00f0\7v\2\2\u00f0N\3\2\2\2\u00f1"+
		"\u00f2\7t\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7c\2\2\u00f4\u00f5\7f\2\2"+
		"\u00f5P\3\2\2\2\u00f6\u00f7\7t\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9\7v\2"+
		"\2\u00f9\u00fa\7w\2\2\u00fa\u00fb\7t\2\2\u00fb\u00fc\7p\2\2\u00fcR\3\2"+
		"\2\2\u00fd\u00fe\7x\2\2\u00fe\u00ff\7q\2\2\u00ff\u0100\7k\2\2\u0100\u0101"+
		"\7f\2\2\u0101T\3\2\2\2\u0102\u0103\7h\2\2\u0103\u0104\7q\2\2\u0104\u0105"+
		"\7t\2\2\u0105V\3\2\2\2\u0106\u0107\7g\2\2\u0107\u0108\7z\2\2\u0108\u0109"+
		"\7v\2\2\u0109\u010a\7g\2\2\u010a\u010b\7p\2\2\u010b\u010c\7f\2\2\u010c"+
		"\u010d\7u\2\2\u010dX\3\2\2\2\u010e\u010f\7k\2\2\u010f\u0110\7o\2\2\u0110"+
		"\u0111\7r\2\2\u0111\u0112\7n\2\2\u0112\u0113\7g\2\2\u0113\u0114\7o\2\2"+
		"\u0114\u0115\7g\2\2\u0115\u0116\7p\2\2\u0116\u0117\7v\2\2\u0117\u0118"+
		"\7u\2\2\u0118Z\3\2\2\2\u0119\u011a\7e\2\2\u011a\u011b\7q\2\2\u011b\u011c"+
		"\7p\2\2\u011c\u011d\7v\2\2\u011d\u011e\7k\2\2\u011e\u011f\7p\2\2\u011f"+
		"\u0120\7w\2\2\u0120\u0121\7g\2\2\u0121\\\3\2\2\2\u0122\u0126\t\3\2\2\u0123"+
		"\u0125\t\4\2\2\u0124\u0123\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2"+
		"\2\2\u0126\u0127\3\2\2\2\u0127^\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012d"+
		"\7$\2\2\u012a\u012c\t\5\2\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u0130\u0131\7$\2\2\u0131`\3\2\2\2\u0132\u0133\t\6\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0135\b\61\2\2\u0135b\3\2\2\2\u0136\u0137\7\61\2\2\u0137"+
		"\u0138\7\61\2\2\u0138\u013c\3\2\2\2\u0139\u013b\n\7\2\2\u013a\u0139\3"+
		"\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\b\62\2\2\u0140d\3\2\2\2"+
		"\t\2fkz\u0126\u012d\u013c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}