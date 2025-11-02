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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class EasyLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, AP=12, FP=13, SC=14, OP=15, ATTR=16, VIR=17, ACH=18, 
		FCH=19, OPREL=20, ID=21, NUMBER=22, TEXTO=23, COMENTARIO=24, WS=25;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_atrib_rule = 9, RULE_cmdselecao = 10, RULE_cmdenquanto = 11, RULE_cmdpara = 12, 
		RULE_expr = 13, RULE_termo = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"cmdattrib", "atrib_rule", "cmdselecao", "cmdenquanto", "cmdpara", "expr", 
			"termo"
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

	@Override
	public String getGrammarFileName() { return "EasyLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public EasyLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			decl();
			setState(32);
			bloco();
			setState(33);
			match(T__1);
			  program.setVarTable(symbolTable);
			              program.setComandos(stack.pop());
			           	 
			           
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				declaravar();
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==T__3 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			tipo();
			setState(42);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new EasyVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                  }
				                  else{
				                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(44);
				match(VIR);
				setState(45);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new EasyVariable(_varName, _tipo, _varValue);
					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                  }
					                  else{
					                  	 throw new EasySemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(SC);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(T__2);
				 _tipo = EasyVariable.NUMBER;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(T__3);
				 _tipo = EasyVariable.TEXT;  
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);  
			          
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				cmd();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2099936L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdenquantoContext cmdenquanto() {
			return getRuleContext(CmdenquantoContext.class,0);
		}
		public CmdparaContext cmdpara() {
			return getRuleContext(CmdparaContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				cmdselecao();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				cmdenquanto();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(71);
				cmdpara();
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__4);
			setState(75);
			match(AP);
			setState(76);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();
			                        
			setState(78);
			match(FP);
			setState(79);
			match(SC);

			              	EasyVariable var = (EasyVariable)symbolTable.get(_readID);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(T__5);
			setState(83);
			match(AP);
			setState(84);
			match(ID);
			 verificaID(_input.LT(-1).getText());
				                  _writeID = _input.LT(-1).getText();
			                     
			setState(86);
			match(FP);
			setState(87);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  stack.peek().add(cmd);
			               
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdattribContext extends ParserRuleContext {
		public Atrib_ruleContext atrib_rule;
		public Atrib_ruleContext atrib_rule() {
			return getRuleContext(Atrib_ruleContext.class,0);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			((CmdattribContext)_localctx).atrib_rule = atrib_rule();
			setState(91);
			match(SC);
			 
						stack.peek().add(((CmdattribContext)_localctx).atrib_rule.atribCmd); 
					
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

	@SuppressWarnings("CheckReturnValue")
	public static class Atrib_ruleContext extends ParserRuleContext {
		public CommandAtribuicao atribCmd;
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(EasyLanguageParser.TEXTO, 0); }
		public Atrib_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrib_rule; }
	}

	public final Atrib_ruleContext atrib_rule() throws RecognitionException {
		Atrib_ruleContext _localctx = new Atrib_ruleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atrib_rule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			 verificaID(_input.LT(-1).getText());
							_exprID = _input.LT(-1).getText();
						
			setState(96);
			match(ATTR);
			 _exprContent = ""; 
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBER:
				{
				setState(98);
				expr();
				}
				break;
			case TEXTO:
				{
				setState(99);
				match(TEXTO);
				 _exprContent = _input.LT(-1).getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}


						((Atrib_ruleContext)_localctx).atribCmd =  new CommandAtribuicao(_exprID, _exprContent);
						
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(EasyLanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(EasyLanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(EasyLanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(EasyLanguageParser.FCH, i);
		}
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__6);
			setState(106);
			match(AP);
			setState(107);
			match(ID);
			 _exprDecision = _input.LT(-1).getText(); 
			setState(109);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(111);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(113);
			match(FP);
			setState(114);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>(); 
			                        stack.push(curThread);
			                    
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				cmd();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2099936L) != 0) );
			setState(121);
			match(FCH);

			                       listaTrue = stack.pop();	
			                    
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(123);
				match(T__7);
				setState(124);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	
				{
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(126);
					cmd();
					}
					}
					setState(129); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2099936L) != 0) );
				}
				setState(131);
				match(FCH);

				                   		listaFalse = stack.pop();
				                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
				                   		stack.peek().add(cmd);
				                   	
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdenquantoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdenquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdenquanto; }
	}

	public final CmdenquantoContext cmdenquanto() throws RecognitionException {
		CmdenquantoContext _localctx = new CmdenquantoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__8);
			setState(137);
			match(AP);
			setState(138);
			match(ID);
			 _exprEnquanto = _input.LT(-1).getText(); 
			setState(140);
			match(OPREL);
			 _exprEnquanto += _input.LT(-1).getText(); 
			setState(142);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprEnquanto += _input.LT(-1).getText(); 
			setState(144);
			match(FP);
			setState(145);
			match(T__9);
			setState(146);
			match(ACH);
			 
			                // 1. Inicia uma nova lista de comandos para o corpo do laço
			                curThread = new ArrayList<AbstractCommand>(); 
			                // 2. Empilha a nova lista
			                stack.push(curThread);
			              
			setState(149); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(148);
				cmd();
				}
				}
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2099936L) != 0) );
			setState(153);
			match(FCH);

			                // 4. Desempilha a lista de comandos do laço
			                listaEnquanto = stack.pop(); 
			                
			                // 5. Cria o objeto CommandEnquanto com a condição e a lista de comandos
			                CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaEnquanto);
			                
			                // 6. Adiciona o comando 'enquanto' na lista de comandos atual (a que está no topo da pilha agora)
			                stack.peek().add(cmd);
			              
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdparaContext extends ParserRuleContext {
		public Atrib_ruleContext init;
		public Atrib_ruleContext incr;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public List<TerminalNode> SC() { return getTokens(EasyLanguageParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(EasyLanguageParser.SC, i);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public List<Atrib_ruleContext> atrib_rule() {
			return getRuleContexts(Atrib_ruleContext.class);
		}
		public Atrib_ruleContext atrib_rule(int i) {
			return getRuleContext(Atrib_ruleContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdparaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdpara; }
	}

	public final CmdparaContext cmdpara() throws RecognitionException {
		CmdparaContext _localctx = new CmdparaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdpara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__10);
			setState(157);
			match(AP);
			setState(158);
			((CmdparaContext)_localctx).init = atrib_rule();
			setState(159);
			match(SC);
			 
			              _paraInit = ((CmdparaContext)_localctx).init.atribCmd;
			            
			setState(161);
			match(ID);
			 _paraCondicao = _input.LT(-1).getText(); 
			setState(163);
			match(OPREL);
			 _paraCondicao += _input.LT(-1).getText(); 
			setState(165);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_paraCondicao += _input.LT(-1).getText(); 
			setState(167);
			match(SC);
			setState(168);
			((CmdparaContext)_localctx).incr = atrib_rule();
			 
			              _paraIncr = ((CmdparaContext)_localctx).incr.atribCmd;
			            
			setState(170);
			match(FP);
			setState(171);
			match(T__9);
			setState(172);
			match(ACH);
			 
			            // Ações para o bloco de comandos
			            curThread = new ArrayList<AbstractCommand>(); 
			            stack.push(curThread);
			          
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(174);
				cmd();
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2099936L) != 0) );
			setState(179);
			match(FCH);

			            // Ações pós-bloco
			            listaPara = stack.pop(); // Pega a lista de comandos do laço
			            
			            // Cria o objeto CommandPara
			            CommandPara cmd = new CommandPara(_paraInit, _paraCondicao, _paraIncr, listaPara);
			            
			            // Adiciona o laço 'para' na pilha principal
			            stack.peek().add(cmd);
			          
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> OP() { return getTokens(EasyLanguageParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(EasyLanguageParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			termo();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(183);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(185);
				termo();
				}
				}
				setState(190);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(EasyLanguageParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termo);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					               _exprContent += _input.LT(-1).getText();
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              
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

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u00c6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004"+
		"\u0001&\b\u0001\u000b\u0001\f\u0001\'\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00020\b\u0002\n\u0002\f\u0002"+
		"3\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003;\b\u0003\u0001\u0004\u0001\u0004\u0004\u0004"+
		"?\b\u0004\u000b\u0004\f\u0004@\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005I\b\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tf\b\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\nv\b\n\u000b\n\f\nw\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0080\b\n\u000b\n\f\n\u0081"+
		"\u0001\n\u0001\n\u0001\n\u0003\n\u0087\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u0096"+
		"\b\u000b\u000b\u000b\f\u000b\u0097\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0004\f\u00b0\b\f\u000b\f\f\f\u00b1\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00bb\b\r\n\r\f\r\u00be\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c4\b\u000e\u0001"+
		"\u000e\u0000\u0000\u000f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u0000\u0001\u0001\u0000\u0015\u0016\u00c7"+
		"\u0000\u001e\u0001\u0000\u0000\u0000\u0002%\u0001\u0000\u0000\u0000\u0004"+
		")\u0001\u0000\u0000\u0000\u0006:\u0001\u0000\u0000\u0000\b<\u0001\u0000"+
		"\u0000\u0000\nH\u0001\u0000\u0000\u0000\fJ\u0001\u0000\u0000\u0000\u000e"+
		"R\u0001\u0000\u0000\u0000\u0010Z\u0001\u0000\u0000\u0000\u0012^\u0001"+
		"\u0000\u0000\u0000\u0014i\u0001\u0000\u0000\u0000\u0016\u0088\u0001\u0000"+
		"\u0000\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u00b6\u0001\u0000"+
		"\u0000\u0000\u001c\u00c3\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0001"+
		"\u0000\u0000\u001f \u0003\u0002\u0001\u0000 !\u0003\b\u0004\u0000!\"\u0005"+
		"\u0002\u0000\u0000\"#\u0006\u0000\uffff\uffff\u0000#\u0001\u0001\u0000"+
		"\u0000\u0000$&\u0003\u0004\u0002\u0000%$\u0001\u0000\u0000\u0000&\'\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000"+
		"(\u0003\u0001\u0000\u0000\u0000)*\u0003\u0006\u0003\u0000*+\u0005\u0015"+
		"\u0000\u0000+1\u0006\u0002\uffff\uffff\u0000,-\u0005\u0011\u0000\u0000"+
		"-.\u0005\u0015\u0000\u0000.0\u0006\u0002\uffff\uffff\u0000/,\u0001\u0000"+
		"\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000012\u0001"+
		"\u0000\u0000\u000024\u0001\u0000\u0000\u000031\u0001\u0000\u0000\u0000"+
		"45\u0005\u000e\u0000\u00005\u0005\u0001\u0000\u0000\u000067\u0005\u0003"+
		"\u0000\u00007;\u0006\u0003\uffff\uffff\u000089\u0005\u0004\u0000\u0000"+
		"9;\u0006\u0003\uffff\uffff\u0000:6\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000;\u0007\u0001\u0000\u0000\u0000<>\u0006\u0004\uffff\uffff"+
		"\u0000=?\u0003\n\u0005\u0000>=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A\t\u0001\u0000"+
		"\u0000\u0000BI\u0003\f\u0006\u0000CI\u0003\u000e\u0007\u0000DI\u0003\u0010"+
		"\b\u0000EI\u0003\u0014\n\u0000FI\u0003\u0016\u000b\u0000GI\u0003\u0018"+
		"\f\u0000HB\u0001\u0000\u0000\u0000HC\u0001\u0000\u0000\u0000HD\u0001\u0000"+
		"\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HG\u0001"+
		"\u0000\u0000\u0000I\u000b\u0001\u0000\u0000\u0000JK\u0005\u0005\u0000"+
		"\u0000KL\u0005\f\u0000\u0000LM\u0005\u0015\u0000\u0000MN\u0006\u0006\uffff"+
		"\uffff\u0000NO\u0005\r\u0000\u0000OP\u0005\u000e\u0000\u0000PQ\u0006\u0006"+
		"\uffff\uffff\u0000Q\r\u0001\u0000\u0000\u0000RS\u0005\u0006\u0000\u0000"+
		"ST\u0005\f\u0000\u0000TU\u0005\u0015\u0000\u0000UV\u0006\u0007\uffff\uffff"+
		"\u0000VW\u0005\r\u0000\u0000WX\u0005\u000e\u0000\u0000XY\u0006\u0007\uffff"+
		"\uffff\u0000Y\u000f\u0001\u0000\u0000\u0000Z[\u0003\u0012\t\u0000[\\\u0005"+
		"\u000e\u0000\u0000\\]\u0006\b\uffff\uffff\u0000]\u0011\u0001\u0000\u0000"+
		"\u0000^_\u0005\u0015\u0000\u0000_`\u0006\t\uffff\uffff\u0000`a\u0005\u0010"+
		"\u0000\u0000ae\u0006\t\uffff\uffff\u0000bf\u0003\u001a\r\u0000cd\u0005"+
		"\u0017\u0000\u0000df\u0006\t\uffff\uffff\u0000eb\u0001\u0000\u0000\u0000"+
		"ec\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0006\t\uffff\uffff"+
		"\u0000h\u0013\u0001\u0000\u0000\u0000ij\u0005\u0007\u0000\u0000jk\u0005"+
		"\f\u0000\u0000kl\u0005\u0015\u0000\u0000lm\u0006\n\uffff\uffff\u0000m"+
		"n\u0005\u0014\u0000\u0000no\u0006\n\uffff\uffff\u0000op\u0007\u0000\u0000"+
		"\u0000pq\u0006\n\uffff\uffff\u0000qr\u0005\r\u0000\u0000rs\u0005\u0012"+
		"\u0000\u0000su\u0006\n\uffff\uffff\u0000tv\u0003\n\u0005\u0000ut\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0005\u0013\u0000"+
		"\u0000z\u0086\u0006\n\uffff\uffff\u0000{|\u0005\b\u0000\u0000|}\u0005"+
		"\u0012\u0000\u0000}\u007f\u0006\n\uffff\uffff\u0000~\u0080\u0003\n\u0005"+
		"\u0000\u007f~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0005\u0013\u0000\u0000"+
		"\u0084\u0085\u0006\n\uffff\uffff\u0000\u0085\u0087\u0001\u0000\u0000\u0000"+
		"\u0086{\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0015\u0001\u0000\u0000\u0000\u0088\u0089\u0005\t\u0000\u0000\u0089\u008a"+
		"\u0005\f\u0000\u0000\u008a\u008b\u0005\u0015\u0000\u0000\u008b\u008c\u0006"+
		"\u000b\uffff\uffff\u0000\u008c\u008d\u0005\u0014\u0000\u0000\u008d\u008e"+
		"\u0006\u000b\uffff\uffff\u0000\u008e\u008f\u0007\u0000\u0000\u0000\u008f"+
		"\u0090\u0006\u000b\uffff\uffff\u0000\u0090\u0091\u0005\r\u0000\u0000\u0091"+
		"\u0092\u0005\n\u0000\u0000\u0092\u0093\u0005\u0012\u0000\u0000\u0093\u0095"+
		"\u0006\u000b\uffff\uffff\u0000\u0094\u0096\u0003\n\u0005\u0000\u0095\u0094"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0095"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0013\u0000\u0000\u009a\u009b"+
		"\u0006\u000b\uffff\uffff\u0000\u009b\u0017\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0005\u000b\u0000\u0000\u009d\u009e\u0005\f\u0000\u0000\u009e\u009f"+
		"\u0003\u0012\t\u0000\u009f\u00a0\u0005\u000e\u0000\u0000\u00a0\u00a1\u0006"+
		"\f\uffff\uffff\u0000\u00a1\u00a2\u0005\u0015\u0000\u0000\u00a2\u00a3\u0006"+
		"\f\uffff\uffff\u0000\u00a3\u00a4\u0005\u0014\u0000\u0000\u00a4\u00a5\u0006"+
		"\f\uffff\uffff\u0000\u00a5\u00a6\u0007\u0000\u0000\u0000\u00a6\u00a7\u0006"+
		"\f\uffff\uffff\u0000\u00a7\u00a8\u0005\u000e\u0000\u0000\u00a8\u00a9\u0003"+
		"\u0012\t\u0000\u00a9\u00aa\u0006\f\uffff\uffff\u0000\u00aa\u00ab\u0005"+
		"\r\u0000\u0000\u00ab\u00ac\u0005\n\u0000\u0000\u00ac\u00ad\u0005\u0012"+
		"\u0000\u0000\u00ad\u00af\u0006\f\uffff\uffff\u0000\u00ae\u00b0\u0003\n"+
		"\u0005\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0013"+
		"\u0000\u0000\u00b4\u00b5\u0006\f\uffff\uffff\u0000\u00b5\u0019\u0001\u0000"+
		"\u0000\u0000\u00b6\u00bc\u0003\u001c\u000e\u0000\u00b7\u00b8\u0005\u000f"+
		"\u0000\u0000\u00b8\u00b9\u0006\r\uffff\uffff\u0000\u00b9\u00bb\u0003\u001c"+
		"\u000e\u0000\u00ba\u00b7\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000"+
		"\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bd\u001b\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0005\u0015\u0000\u0000\u00c0\u00c4\u0006\u000e"+
		"\uffff\uffff\u0000\u00c1\u00c2\u0005\u0016\u0000\u0000\u00c2\u00c4\u0006"+
		"\u000e\uffff\uffff\u0000\u00c3\u00bf\u0001\u0000\u0000\u0000\u00c3\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c4\u001d\u0001\u0000\u0000\u0000\r\'1:@He"+
		"w\u0081\u0086\u0097\u00b1\u00bc\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}