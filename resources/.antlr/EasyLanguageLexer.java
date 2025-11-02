// Generated from c:/Users/kauea/OneDrive/Documents/GitHub/EasyLanguageFinal/resources/EasyLanguage.g4 by ANTLR 4.13.1

	import br.edu.cefsa.compiler.datastructures.EasySymbol;
	import br.edu.cefsa.compiler.datastructures.EasyVariable;
	import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
	import br.edu.cefsa.compiler.exceptions.EasySemanticException;
	import br.edu.cefsa.compiler.abstractsyntaxtree.EasyProgram;
	import br.edu.cefsa.compiler.abstractsyntaxtree.AbstractCommand;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandLeitura;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandEscrita;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandAtribuicao;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandDecisao;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandEnquanto;
	import br.edu.cefsa.compiler.abstractsyntaxtree.CommandPara;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EasyLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, AP=12, FP=13, SC=14, OP=15, ATTR=16, VIR=17, ACH=18, 
		FCH=19, OPREL=20, ID=21, NUMBER=22, TEXTO=23, COMENTARIO=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", 
			"OPREL", "ID", "NUMBER", "TEXTO", "COMENTARIO", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'senao'", "'enquanto'", "'faca'", "'para'", "'('", "')'", "';'", 
			null, "'='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
			"TEXTO", "COMENTARIO", "WS"
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


		private int _tipo;
		private String _varName;
		private String _varValue;
		private EasySymbolTable symbolTable = new EasySymbolTable();
		private EasySymbol symbol;
		private EasyProgram program = new EasyProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private String _exprEnquanto;
		private String _paraCondicao;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<AbstractCommand> listaEnquanto;
		private ArrayList<AbstractCommand> listaPara;
		private CommandAtribuicao _paraInit;
		private CommandAtribuicao _paraIncr;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new EasySemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}


	public EasyLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "EasyLanguage.g4"; }

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
		"\u0004\u0000\u0019\u00c2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u0095\b\u0013\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0099\b\u0014\n\u0014\f\u0014\u009c\t\u0014\u0001\u0015\u0004\u0015\u009f"+
		"\b\u0015\u000b\u0015\f\u0015\u00a0\u0001\u0015\u0001\u0015\u0004\u0015"+
		"\u00a5\b\u0015\u000b\u0015\f\u0015\u00a6\u0003\u0015\u00a9\b\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u00ad\b\u0016\n\u0016\f\u0016\u00b0\t\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u00b8\b\u0017\n\u0017\f\u0017\u00bb\t\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u0019\u0001\u0000\b\u0003\u0000*+--//\u0002\u0000<<>>\u0001\u0000"+
		"az\u0003\u000009AZaz\u0001\u000009\u0001\u0000\"\"\u0002\u0000\n\n\r\r"+
		"\u0003\u0000\t\n\r\r  \u00cb\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000"+
		"\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000"+
		"\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-"+
		"\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000"+
		"\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u0003<\u0001\u0000\u0000\u0000"+
		"\u0005E\u0001\u0000\u0000\u0000\u0007L\u0001\u0000\u0000\u0000\tR\u0001"+
		"\u0000\u0000\u0000\u000bW\u0001\u0000\u0000\u0000\r_\u0001\u0000\u0000"+
		"\u0000\u000fb\u0001\u0000\u0000\u0000\u0011h\u0001\u0000\u0000\u0000\u0013"+
		"q\u0001\u0000\u0000\u0000\u0015v\u0001\u0000\u0000\u0000\u0017{\u0001"+
		"\u0000\u0000\u0000\u0019}\u0001\u0000\u0000\u0000\u001b\u007f\u0001\u0000"+
		"\u0000\u0000\u001d\u0081\u0001\u0000\u0000\u0000\u001f\u0083\u0001\u0000"+
		"\u0000\u0000!\u0085\u0001\u0000\u0000\u0000#\u0087\u0001\u0000\u0000\u0000"+
		"%\u0089\u0001\u0000\u0000\u0000\'\u0094\u0001\u0000\u0000\u0000)\u0096"+
		"\u0001\u0000\u0000\u0000+\u009e\u0001\u0000\u0000\u0000-\u00aa\u0001\u0000"+
		"\u0000\u0000/\u00b3\u0001\u0000\u0000\u00001\u00be\u0001\u0000\u0000\u0000"+
		"34\u0005p\u0000\u000045\u0005r\u0000\u000056\u0005o\u0000\u000067\u0005"+
		"g\u0000\u000078\u0005r\u0000\u000089\u0005a\u0000\u00009:\u0005m\u0000"+
		"\u0000:;\u0005a\u0000\u0000;\u0002\u0001\u0000\u0000\u0000<=\u0005f\u0000"+
		"\u0000=>\u0005i\u0000\u0000>?\u0005m\u0000\u0000?@\u0005p\u0000\u0000"+
		"@A\u0005r\u0000\u0000AB\u0005o\u0000\u0000BC\u0005g\u0000\u0000CD\u0005"+
		";\u0000\u0000D\u0004\u0001\u0000\u0000\u0000EF\u0005n\u0000\u0000FG\u0005"+
		"u\u0000\u0000GH\u0005m\u0000\u0000HI\u0005e\u0000\u0000IJ\u0005r\u0000"+
		"\u0000JK\u0005o\u0000\u0000K\u0006\u0001\u0000\u0000\u0000LM\u0005t\u0000"+
		"\u0000MN\u0005e\u0000\u0000NO\u0005x\u0000\u0000OP\u0005t\u0000\u0000"+
		"PQ\u0005o\u0000\u0000Q\b\u0001\u0000\u0000\u0000RS\u0005l\u0000\u0000"+
		"ST\u0005e\u0000\u0000TU\u0005i\u0000\u0000UV\u0005a\u0000\u0000V\n\u0001"+
		"\u0000\u0000\u0000WX\u0005e\u0000\u0000XY\u0005s\u0000\u0000YZ\u0005c"+
		"\u0000\u0000Z[\u0005r\u0000\u0000[\\\u0005e\u0000\u0000\\]\u0005v\u0000"+
		"\u0000]^\u0005a\u0000\u0000^\f\u0001\u0000\u0000\u0000_`\u0005s\u0000"+
		"\u0000`a\u0005e\u0000\u0000a\u000e\u0001\u0000\u0000\u0000bc\u0005s\u0000"+
		"\u0000cd\u0005e\u0000\u0000de\u0005n\u0000\u0000ef\u0005a\u0000\u0000"+
		"fg\u0005o\u0000\u0000g\u0010\u0001\u0000\u0000\u0000hi\u0005e\u0000\u0000"+
		"ij\u0005n\u0000\u0000jk\u0005q\u0000\u0000kl\u0005u\u0000\u0000lm\u0005"+
		"a\u0000\u0000mn\u0005n\u0000\u0000no\u0005t\u0000\u0000op\u0005o\u0000"+
		"\u0000p\u0012\u0001\u0000\u0000\u0000qr\u0005f\u0000\u0000rs\u0005a\u0000"+
		"\u0000st\u0005c\u0000\u0000tu\u0005a\u0000\u0000u\u0014\u0001\u0000\u0000"+
		"\u0000vw\u0005p\u0000\u0000wx\u0005a\u0000\u0000xy\u0005r\u0000\u0000"+
		"yz\u0005a\u0000\u0000z\u0016\u0001\u0000\u0000\u0000{|\u0005(\u0000\u0000"+
		"|\u0018\u0001\u0000\u0000\u0000}~\u0005)\u0000\u0000~\u001a\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005;\u0000\u0000\u0080\u001c\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0007\u0000\u0000\u0000\u0082\u001e\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005=\u0000\u0000\u0084 \u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005,\u0000\u0000\u0086\"\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005{\u0000\u0000\u0088$\u0001\u0000\u0000\u0000\u0089\u008a\u0005}"+
		"\u0000\u0000\u008a&\u0001\u0000\u0000\u0000\u008b\u0095\u0007\u0001\u0000"+
		"\u0000\u008c\u008d\u0005>\u0000\u0000\u008d\u0095\u0005=\u0000\u0000\u008e"+
		"\u008f\u0005<\u0000\u0000\u008f\u0095\u0005=\u0000\u0000\u0090\u0091\u0005"+
		"=\u0000\u0000\u0091\u0095\u0005=\u0000\u0000\u0092\u0093\u0005!\u0000"+
		"\u0000\u0093\u0095\u0005=\u0000\u0000\u0094\u008b\u0001\u0000\u0000\u0000"+
		"\u0094\u008c\u0001\u0000\u0000\u0000\u0094\u008e\u0001\u0000\u0000\u0000"+
		"\u0094\u0090\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000\u0000\u0000"+
		"\u0095(\u0001\u0000\u0000\u0000\u0096\u009a\u0007\u0002\u0000\u0000\u0097"+
		"\u0099\u0007\u0003\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b*\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009d\u009f\u0007\u0004\u0000\u0000\u009e\u009d"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a4\u0005.\u0000\u0000\u00a3\u00a5\u0007"+
		"\u0004\u0000\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9,\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ae\u0005\"\u0000\u0000\u00ab\u00ad\b\u0005\u0000"+
		"\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000"+
		"\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000"+
		"\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0005\"\u0000\u0000\u00b2.\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0005/\u0000\u0000\u00b4\u00b5\u0005/\u0000\u0000\u00b5\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b8\b\u0006\u0000\u0000\u00b7\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0006"+
		"\u0017\u0000\u0000\u00bd0\u0001\u0000\u0000\u0000\u00be\u00bf\u0007\u0007"+
		"\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0006\u0018"+
		"\u0000\u0000\u00c12\u0001\u0000\u0000\u0000\t\u0000\u0094\u0098\u009a"+
		"\u00a0\u00a6\u00a8\u00ae\u00b9\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}