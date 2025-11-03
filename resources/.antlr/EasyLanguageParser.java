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
		FCH=19, AC=20, FC=21, OPREL=22, E=23, OU=24, NAO=25, BOOLEANO=26, VERDADEIRO=27, 
		FALSO=28, ID=29, NUMBER=30, TEXTO=31, COMENTARIO=32, WS=33;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_designador = 8, 
		RULE_cmdattrib = 9, RULE_atrib_rule = 10, RULE_expr_logica = 11, RULE_termo_logico = 12, 
		RULE_fator_logico = 13, RULE_comparacao = 14, RULE_cmdselecao = 15, RULE_cmdenquanto = 16, 
		RULE_cmdpara = 17, RULE_expr = 18, RULE_termo = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
			"designador", "cmdattrib", "atrib_rule", "expr_logica", "termo_logico", 
			"fator_logico", "comparacao", "cmdselecao", "cmdenquanto", "cmdpara", 
			"expr", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog;'", "'numero'", "'texto'", "'leia'", "'escreva'", 
			"'se'", "'faca'", "'senao'", "'enquanto'", "'para'", "'('", "')'", "';'", 
			null, "'='", "','", "'{'", "'}'", "'['", "']'", null, "'e'", "'ou'", 
			"'nao'", "'booleano'", "'verdadeiro'", "'falso'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "AC", "FC", "OPREL", 
			"E", "OU", "NAO", "BOOLEANO", "VERDADEIRO", "FALSO", "ID", "NUMBER", 
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
	    
	    // Adicionei uma verificação de 'null' aqui por segurança
	    public void exibeComandos(){
	        if (program.getComandos() != null) {
	            for (AbstractCommand c: program.getComandos()){
	                System.out.println(c);
	            }
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
			setState(40);
			match(T__0);
			setState(41);
			decl();
			setState(42);
			bloco();
			setState(43);
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
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				declaravar();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 67108888L) != 0) );
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
		public Token n;
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public List<TerminalNode> AC() { return getTokens(EasyLanguageParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(EasyLanguageParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(EasyLanguageParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(EasyLanguageParser.FC, i);
		}
		public List<TerminalNode> VIR() { return getTokens(EasyLanguageParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(EasyLanguageParser.VIR, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(EasyLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(EasyLanguageParser.NUMBER, i);
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
			setState(51);
			tipo();
			setState(52);
			match(ID);

			                   _varName = _input.LT(-1).getText();
			                   _varValue = null;
			                   symbol = new EasyVariable(_varName, _tipo, _varValue); // Assume que é simples
			               
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AC) {
				{
				setState(54);
				match(AC);
				setState(55);
				((DeclaravarContext)_localctx).n = match(NUMBER);
				setState(56);
				match(FC);

				                    // Se for um vetor, cria o símbolo de vetor
				                    int size = Integer.parseInt(((DeclaravarContext)_localctx).n.getText());
				                    symbol = new EasyVariable(_varName, _tipo, size);
				                 
				}
			}


			                  // Adiciona o primeiro símbolo (seja simples ou vetor)
			                  if (!symbolTable.exists(_varName)){
			                      symbolTable.add(symbol);    
			                  } else {
			                      throw new EasySemanticException("Symbol "+_varName+" already declared");
			                  }
			               
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(61);
				match(VIR);
				setState(62);
				match(ID);

				                    _varName = _input.LT(-1).getText();
				                    _varValue = null;
				                    symbol = new EasyVariable(_varName, _tipo, _varValue); // Assume que é simples
				                 
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AC) {
					{
					setState(64);
					match(AC);
					setState(65);
					((DeclaravarContext)_localctx).n = match(NUMBER);
					setState(66);
					match(FC);

					                     int size = Integer.parseInt(((DeclaravarContext)_localctx).n.getText());
					                     symbol = new EasyVariable(_varName, _tipo, size);
					                   
					}
				}


				                    // Adiciona o símbolo (seja simples ou vetor)
				                    if (!symbolTable.exists(_varName)){
				                        symbolTable.add(symbol);    
				                    } else {
				                        throw new EasySemanticException("Symbol "+_varName+" already declared");
				                    }
				                 
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
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
		public TerminalNode BOOLEANO() { return getToken(EasyLanguageParser.BOOLEANO, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(T__2);
				 _tipo = EasyVariable.NUMBER;   
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(T__3);
				 _tipo = EasyVariable.TEXT;     
				}
				break;
			case BOOLEANO:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
				match(BOOLEANO);
				 _tipo = EasyVariable.BOOLEAN; 
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
			          
			setState(88); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(87);
				cmd();
				}
				}
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 536874208L) != 0) );
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
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				cmdleitura();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				cmdattrib();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				cmdselecao();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(96);
				cmdenquanto();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 6);
				{
				setState(97);
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
		public DesignadorContext d;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public DesignadorContext designador() {
			return getRuleContext(DesignadorContext.class,0);
		}
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
			setState(100);
			match(T__4);
			setState(101);
			match(AP);
			setState(102);
			((CmdleituraContext)_localctx).d = designador();
			 _readID = ((CmdleituraContext)_localctx).d.str; 
			setState(104);
			match(FP);
			setState(105);
			match(SC);

			                 // Passa a string ("vetor[i]") e a variável base (para tipo)
			                 EasyVariable var = (EasyVariable)symbolTable.get(((CmdleituraContext)_localctx).d.baseName);
			                 CommandLeitura cmd = new CommandLeitura(((CmdleituraContext)_localctx).d.str, var);
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
		public DesignadorContext d;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode SC() { return getToken(EasyLanguageParser.SC, 0); }
		public DesignadorContext designador() {
			return getRuleContext(DesignadorContext.class,0);
		}
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
			setState(108);
			match(T__5);
			setState(109);
			match(AP);
			setState(110);
			((CmdescritaContext)_localctx).d = designador();
			 _writeID = ((CmdescritaContext)_localctx).d.str; 
			setState(112);
			match(FP);
			setState(113);
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
	public static class DesignadorContext extends ParserRuleContext {
		public String str;
		public String baseName;
		public boolean isIndexed;
		public Token ID;
		public Token i;
		public Token n;
		public List<TerminalNode> ID() { return getTokens(EasyLanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(EasyLanguageParser.ID, i);
		}
		public TerminalNode AC() { return getToken(EasyLanguageParser.AC, 0); }
		public TerminalNode FC() { return getToken(EasyLanguageParser.FC, 0); }
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public DesignadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_designador; }
	}

	public final DesignadorContext designador() throws RecognitionException {
		DesignadorContext _localctx = new DesignadorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_designador);

		            EasyVariable var;
		        
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			((DesignadorContext)_localctx).ID = match(ID);

			            ((DesignadorContext)_localctx).baseName =  (((DesignadorContext)_localctx).ID!=null?((DesignadorContext)_localctx).ID.getText():null);
			            verificaID(_localctx.baseName);
			            ((DesignadorContext)_localctx).str =  _localctx.baseName; // String padrão
			            ((DesignadorContext)_localctx).isIndexed =  false;
			            var = (EasyVariable)symbolTable.get(_localctx.baseName);
			        
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AC) {
				{
				setState(118);
				match(AC);

				                if (!var.isVector()) {
				                    throw new EasySemanticException("Symbol "+_localctx.baseName+" is not a vector and cannot be accessed with []");
				                }
				                ((DesignadorContext)_localctx).isIndexed =  true;
				            
				setState(124);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
					{
					setState(120);
					((DesignadorContext)_localctx).i = match(ID);

					                    verificaID((((DesignadorContext)_localctx).i!=null?((DesignadorContext)_localctx).i.getText():null));
					                    EasyVariable indexVar = (EasyVariable)symbolTable.get((((DesignadorContext)_localctx).i!=null?((DesignadorContext)_localctx).i.getText():null));
					                    if (indexVar.getType() != EasyVariable.NUMBER) {
					                        throw new EasySemanticException("Vector index "+(((DesignadorContext)_localctx).i!=null?((DesignadorContext)_localctx).i.getText():null)+" is not a 'numero'");
					                    }
					                    _localctx.str += "[" + (((DesignadorContext)_localctx).i!=null?((DesignadorContext)_localctx).i.getText():null) + "]"; // Gera "vetor[i]"
					                
					}
					break;
				case NUMBER:
					{
					setState(122);
					((DesignadorContext)_localctx).n = match(NUMBER);

					                    int index = Integer.parseInt((((DesignadorContext)_localctx).n!=null?((DesignadorContext)_localctx).n.getText():null));
					                    // Verificação de limites
					                    if (index < 0 || index >= var.getVectorSize()) {
					                        throw new EasySemanticException("Vector index "+index+" out of bounds for "+_localctx.baseName+"[0.."+(var.getVectorSize()-1)+"]");
					                    }
					                    _localctx.str += "[" + (((DesignadorContext)_localctx).n!=null?((DesignadorContext)_localctx).n.getText():null) + "]"; // Gera "vetor[5]"
					                
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(126);
				match(FC);
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
		enterRule(_localctx, 18, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			((CmdattribContext)_localctx).atrib_rule = atrib_rule();
			setState(130);
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
		public DesignadorContext d;
		public TerminalNode ATTR() { return getToken(EasyLanguageParser.ATTR, 0); }
		public DesignadorContext designador() {
			return getRuleContext(DesignadorContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TEXTO() { return getToken(EasyLanguageParser.TEXTO, 0); }
		public TerminalNode VERDADEIRO() { return getToken(EasyLanguageParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(EasyLanguageParser.FALSO, 0); }
		public Atrib_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrib_rule; }
	}

	public final Atrib_ruleContext atrib_rule() throws RecognitionException {
		Atrib_ruleContext _localctx = new Atrib_ruleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atrib_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((Atrib_ruleContext)_localctx).d = designador();
			 // Usa 'designador'
			                EasyVariable var = (EasyVariable)symbolTable.get(((Atrib_ruleContext)_localctx).d.baseName);
			                // Verificação semântica: não podemos atribuir a um vetor inteiro
			                if (var.isVector() && !((Atrib_ruleContext)_localctx).d.isIndexed) {
			                    throw new EasySemanticException("Cannot assign value to whole vector '"+((Atrib_ruleContext)_localctx).d.baseName+"'. Specify an index [].");
			                }
			                _exprID = ((Atrib_ruleContext)_localctx).d.str; // _exprID agora é "a" ou "vetor[i]"
			            
			setState(135);
			match(ATTR);
			 _exprContent = ""; 
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUMBER:
				{
				setState(137);
				expr();
				}
				break;
			case TEXTO:
				{
				setState(138);
				match(TEXTO);
				 _exprContent = _input.LT(-1).getText(); 
				}
				break;
			case VERDADEIRO:
			case FALSO:
				{
				setState(140);
				_la = _input.LA(1);
				if ( !(_la==VERDADEIRO || _la==FALSO) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
	public static class Expr_logicaContext extends ParserRuleContext {
		public String str;
		public Termo_logicoContext t1;
		public Termo_logicoContext t2;
		public List<Termo_logicoContext> termo_logico() {
			return getRuleContexts(Termo_logicoContext.class);
		}
		public Termo_logicoContext termo_logico(int i) {
			return getRuleContext(Termo_logicoContext.class,i);
		}
		public List<TerminalNode> OU() { return getTokens(EasyLanguageParser.OU); }
		public TerminalNode OU(int i) {
			return getToken(EasyLanguageParser.OU, i);
		}
		public Expr_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_logica; }
	}

	public final Expr_logicaContext expr_logica() throws RecognitionException {
		Expr_logicaContext _localctx = new Expr_logicaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr_logica);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((Expr_logicaContext)_localctx).t1 = termo_logico();
			 ((Expr_logicaContext)_localctx).str =  ((Expr_logicaContext)_localctx).t1.str; 
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OU) {
				{
				{
				setState(148);
				match(OU);
				setState(149);
				((Expr_logicaContext)_localctx).t2 = termo_logico();
				 _localctx.str += " || " + ((Expr_logicaContext)_localctx).t2.str; 
				}
				}
				setState(156);
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
	public static class Termo_logicoContext extends ParserRuleContext {
		public String str;
		public Fator_logicoContext f1;
		public Fator_logicoContext f2;
		public List<Fator_logicoContext> fator_logico() {
			return getRuleContexts(Fator_logicoContext.class);
		}
		public Fator_logicoContext fator_logico(int i) {
			return getRuleContext(Fator_logicoContext.class,i);
		}
		public List<TerminalNode> E() { return getTokens(EasyLanguageParser.E); }
		public TerminalNode E(int i) {
			return getToken(EasyLanguageParser.E, i);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			((Termo_logicoContext)_localctx).f1 = fator_logico();
			 ((Termo_logicoContext)_localctx).str =  ((Termo_logicoContext)_localctx).f1.str; 
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==E) {
				{
				{
				setState(159);
				match(E);
				setState(160);
				((Termo_logicoContext)_localctx).f2 = fator_logico();
				 _localctx.str += " && " + ((Termo_logicoContext)_localctx).f2.str; 
				}
				}
				setState(167);
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
	public static class Fator_logicoContext extends ParserRuleContext {
		public String str;
		public Fator_logicoContext f;
		public Expr_logicaContext e;
		public ComparacaoContext c;
		public DesignadorContext d;
		public Token v;
		public TerminalNode NAO() { return getToken(EasyLanguageParser.NAO, 0); }
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public Expr_logicaContext expr_logica() {
			return getRuleContext(Expr_logicaContext.class,0);
		}
		public ComparacaoContext comparacao() {
			return getRuleContext(ComparacaoContext.class,0);
		}
		public DesignadorContext designador() {
			return getRuleContext(DesignadorContext.class,0);
		}
		public TerminalNode VERDADEIRO() { return getToken(EasyLanguageParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(EasyLanguageParser.FALSO, 0); }
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fator_logico);
		int _la;
		try {
			setState(185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(NAO);
				setState(169);
				((Fator_logicoContext)_localctx).f = fator_logico();
				 ((Fator_logicoContext)_localctx).str =  "!(" + ((Fator_logicoContext)_localctx).f.str + ")"; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(AP);
				setState(173);
				((Fator_logicoContext)_localctx).e = expr_logica();
				setState(174);
				match(FP);
				 ((Fator_logicoContext)_localctx).str =  "(" + ((Fator_logicoContext)_localctx).e.str + ")"; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(177);
				((Fator_logicoContext)_localctx).c = comparacao();
				 ((Fator_logicoContext)_localctx).str =  ((Fator_logicoContext)_localctx).c.str; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				((Fator_logicoContext)_localctx).d = designador();
				 // Acesso simples (ex: 'se (flag)' ou 'se (vetor[i])')
				              EasyVariable var = (EasyVariable)symbolTable.get(((Fator_logicoContext)_localctx).d.baseName);
				              if (var.isVector() && !((Fator_logicoContext)_localctx).d.isIndexed) {
				                   throw new EasySemanticException("Cannot use whole vector '"+((Fator_logicoContext)_localctx).d.baseName+"' in a boolean expression");
				              }
				              if (var.getType() != EasyVariable.BOOLEAN) {
				                   throw new EasySemanticException("Cannot use non-boolean variable '"+((Fator_logicoContext)_localctx).d.str+"' in a boolean expression");
				              }
				              
				              String val = ((Fator_logicoContext)_localctx).d.str;
				              ((Fator_logicoContext)_localctx).str =  val.equals("verdadeiro") ? "true" :
				                     val.equals("falso") ? "false" :
				                     val;
				          
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
				((Fator_logicoContext)_localctx).v = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VERDADEIRO || _la==FALSO) ) {
					((Fator_logicoContext)_localctx).v = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 // Literal (ex: 'se (verdadeiro)')
				             String val = ((Fator_logicoContext)_localctx).v.getText();
				             ((Fator_logicoContext)_localctx).str =  val.equals("verdadeiro") ? "true" : "false";
				          
				}
				break;
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
	public static class ComparacaoContext extends ParserRuleContext {
		public String str;
		public DesignadorContext d1;
		public Token n1;
		public DesignadorContext d2;
		public Token n2;
		public Token v;
		public TerminalNode OPREL() { return getToken(EasyLanguageParser.OPREL, 0); }
		public List<DesignadorContext> designador() {
			return getRuleContexts(DesignadorContext.class);
		}
		public DesignadorContext designador(int i) {
			return getRuleContext(DesignadorContext.class,i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(EasyLanguageParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(EasyLanguageParser.NUMBER, i);
		}
		public TerminalNode VERDADEIRO() { return getToken(EasyLanguageParser.VERDADEIRO, 0); }
		public TerminalNode FALSO() { return getToken(EasyLanguageParser.FALSO, 0); }
		public ComparacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparacao; }
	}

	public final ComparacaoContext comparacao() throws RecognitionException {
		ComparacaoContext _localctx = new ComparacaoContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_comparacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(187);
				((ComparacaoContext)_localctx).d1 = designador();
				 // Lado Esquerdo
				              EasyVariable var = (EasyVariable)symbolTable.get(((ComparacaoContext)_localctx).d1.baseName);
				              if (var.isVector() && !((ComparacaoContext)_localctx).d1.isIndexed) {
				                  throw new EasySemanticException("Cannot use whole vector '"+((ComparacaoContext)_localctx).d1.baseName+"' in a comparison");
				              }
				              ((ComparacaoContext)_localctx).str =  ((ComparacaoContext)_localctx).d1.str;
				          
				}
				break;
			case NUMBER:
				{
				setState(190);
				((ComparacaoContext)_localctx).n1 = match(NUMBER);
				 ((ComparacaoContext)_localctx).str =  ((ComparacaoContext)_localctx).n1.getText(); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(194);
			match(OPREL);
			 _localctx.str += _input.LT(-1).getText(); 
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(196);
				((ComparacaoContext)_localctx).d2 = designador();
				 // Lado Direito
				              EasyVariable var = (EasyVariable)symbolTable.get(((ComparacaoContext)_localctx).d2.baseName);
				              if (var.isVector() && !((ComparacaoContext)_localctx).d2.isIndexed) {
				                  throw new EasySemanticException("Cannot use whole vector '"+((ComparacaoContext)_localctx).d2.baseName+"' in a comparison");
				              }
				              String val = ((ComparacaoContext)_localctx).d2.str;
				              _localctx.str += val.equals("verdadeiro") ? "true" :
				                      val.equals("falso") ? "false" :
				                      val;
				          
				}
				break;
			case NUMBER:
				{
				setState(199);
				((ComparacaoContext)_localctx).n2 = match(NUMBER);
				 _localctx.str += ((ComparacaoContext)_localctx).n2.getText(); 
				}
				break;
			case VERDADEIRO:
			case FALSO:
				{
				setState(201);
				((ComparacaoContext)_localctx).v = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==VERDADEIRO || _la==FALSO) ) {
					((ComparacaoContext)_localctx).v = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				 // Lado direito pode ser um booleano
				              String val = ((ComparacaoContext)_localctx).v.getText();
				              _localctx.str += val.equals("verdadeiro") ? "true" : "false";
				          
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdselecaoContext extends ParserRuleContext {
		public Expr_logicaContext c;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(EasyLanguageParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(EasyLanguageParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(EasyLanguageParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(EasyLanguageParser.FCH, i);
		}
		public Expr_logicaContext expr_logica() {
			return getRuleContext(Expr_logicaContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__6);
			setState(206);
			match(AP);
			setState(207);
			((CmdselecaoContext)_localctx).c = expr_logica();
			 _exprDecision = ((CmdselecaoContext)_localctx).c.str; 
			setState(209);
			match(FP);
			setState(210);
			match(T__7);
			setState(211);
			match(ACH);
			 
			                    curThread = new ArrayList<AbstractCommand>(); 
			                    stack.push(curThread);
			                
			setState(214); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				cmd();
				}
				}
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 536874208L) != 0) );
			setState(218);
			match(FCH);

			                    listaTrue = stack.pop();
			                
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(220);
				match(T__8);
				setState(221);
				match(ACH);

				                        curThread = new ArrayList<AbstractCommand>();
				                        stack.push(curThread);
				                    
				{
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(223);
					cmd();
					}
					}
					setState(226); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 536874208L) != 0) );
				}
				setState(228);
				match(FCH);

				                        listaFalse = stack.pop();
				                    
				}
			}


			                    CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			                    stack.peek().add(cmd);
			                    listaFalse = null; // Reseta listaFalse para o próximo 'se'
			                
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
		public Expr_logicaContext c;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public Expr_logicaContext expr_logica() {
			return getRuleContext(Expr_logicaContext.class,0);
		}
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
		enterRule(_localctx, 32, RULE_cmdenquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__9);
			setState(236);
			match(AP);
			setState(237);
			((CmdenquantoContext)_localctx).c = expr_logica();
			 _exprEnquanto = ((CmdenquantoContext)_localctx).c.str; 
			setState(239);
			match(FP);
			setState(240);
			match(T__7);
			setState(241);
			match(ACH);
			 
			                    curThread = new ArrayList<AbstractCommand>(); 
			                    stack.push(curThread);
			                
			setState(244); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(243);
				cmd();
				}
				}
				setState(246); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 536874208L) != 0) );
			setState(248);
			match(FCH);

			                    listaEnquanto = stack.pop(); 
			                    CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaEnquanto);
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
		public Expr_logicaContext c;
		public Atrib_ruleContext incr;
		public TerminalNode AP() { return getToken(EasyLanguageParser.AP, 0); }
		public List<TerminalNode> SC() { return getTokens(EasyLanguageParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(EasyLanguageParser.SC, i);
		}
		public TerminalNode FP() { return getToken(EasyLanguageParser.FP, 0); }
		public TerminalNode ACH() { return getToken(EasyLanguageParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(EasyLanguageParser.FCH, 0); }
		public List<Atrib_ruleContext> atrib_rule() {
			return getRuleContexts(Atrib_ruleContext.class);
		}
		public Atrib_ruleContext atrib_rule(int i) {
			return getRuleContext(Atrib_ruleContext.class,i);
		}
		public Expr_logicaContext expr_logica() {
			return getRuleContext(Expr_logicaContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_cmdpara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__10);
			setState(252);
			match(AP);
			setState(253);
			((CmdparaContext)_localctx).init = atrib_rule();
			setState(254);
			match(SC);
			 
			                  _paraInit = ((CmdparaContext)_localctx).init.atribCmd; 
			                
			setState(256);
			((CmdparaContext)_localctx).c = expr_logica();
			 _paraCondicao = ((CmdparaContext)_localctx).c.str; 
			setState(258);
			match(SC);
			setState(259);
			((CmdparaContext)_localctx).incr = atrib_rule();
			 
			                  _paraIncr = ((CmdparaContext)_localctx).incr.atribCmd; 
			                
			setState(261);
			match(FP);
			setState(262);
			match(T__7);
			setState(263);
			match(ACH);
			 
			                curThread = new ArrayList<AbstractCommand>(); 
			                stack.push(curThread);
			            
			setState(266); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(265);
				cmd();
				}
				}
				setState(268); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 536874208L) != 0) );
			setState(270);
			match(FCH);

			                listaPara = stack.pop();
			                CommandPara cmd = new CommandPara(_paraInit, _paraCondicao, _paraIncr, listaPara);
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
		enterRule(_localctx, 36, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			termo();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(274);
				match(OP);
				 _exprContent += _input.LT(-1).getText();
				setState(276);
				termo();
				}
				}
				setState(281);
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
		public DesignadorContext d;
		public DesignadorContext designador() {
			return getRuleContext(DesignadorContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(EasyLanguageParser.NUMBER, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_termo);
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				((TermoContext)_localctx).d = designador();
				 
				                   EasyVariable var = (EasyVariable)symbolTable.get(((TermoContext)_localctx).d.baseName);
				                   // Verificação semântica: não pode usar vetor inteiro em matemática
				                   if (var.isVector() && !((TermoContext)_localctx).d.isIndexed) {
				                       throw new EasySemanticException("Cannot use whole vector '"+((TermoContext)_localctx).d.baseName+"' in a math expression");
				                   }
				                   // Verificação semântica: não pode usar texto/booleano em matemática
				                   if (var.getType() != EasyVariable.NUMBER) {
				                        throw new EasySemanticException("Cannot use non-numeric variable '"+((TermoContext)_localctx).d.str+"' in a math expression");
				                   }
				                   _exprContent += ((TermoContext)_localctx).d.str;
				                 
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
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
		"\u0004\u0001!\u0122\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u00010\b\u0001\u000b\u0001"+
		"\f\u00011\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002E\b\u0002\u0001\u0002\u0005\u0002H\b\u0002\n\u0002\f\u0002"+
		"K\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0004\u0004Y\b\u0004\u000b\u0004\f\u0004Z\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005c\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b}\b\b\u0001\b"+
		"\u0003\b\u0080\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u008f\b\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u0099\b\u000b\n\u000b\f\u000b\u009c\t\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00a4\b\f\n\f\f\f\u00a7"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00ba\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00c1\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00cc\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u00d7\b\u000f"+
		"\u000b\u000f\f\u000f\u00d8\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0004\u000f\u00e1\b\u000f\u000b\u000f\f\u000f"+
		"\u00e2\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e8\b\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u00f5"+
		"\b\u0010\u000b\u0010\f\u0010\u00f6\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u010b\b\u0011\u000b\u0011"+
		"\f\u0011\u010c\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0116\b\u0012\n\u0012\f\u0012\u0119"+
		"\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u0120\b\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0001\u0001\u0000\u001b\u001c\u012d\u0000(\u0001\u0000\u0000\u0000\u0002"+
		"/\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006T\u0001"+
		"\u0000\u0000\u0000\bV\u0001\u0000\u0000\u0000\nb\u0001\u0000\u0000\u0000"+
		"\fd\u0001\u0000\u0000\u0000\u000el\u0001\u0000\u0000\u0000\u0010t\u0001"+
		"\u0000\u0000\u0000\u0012\u0081\u0001\u0000\u0000\u0000\u0014\u0085\u0001"+
		"\u0000\u0000\u0000\u0016\u0092\u0001\u0000\u0000\u0000\u0018\u009d\u0001"+
		"\u0000\u0000\u0000\u001a\u00b9\u0001\u0000\u0000\u0000\u001c\u00c0\u0001"+
		"\u0000\u0000\u0000\u001e\u00cd\u0001\u0000\u0000\u0000 \u00eb\u0001\u0000"+
		"\u0000\u0000\"\u00fb\u0001\u0000\u0000\u0000$\u0111\u0001\u0000\u0000"+
		"\u0000&\u011f\u0001\u0000\u0000\u0000()\u0005\u0001\u0000\u0000)*\u0003"+
		"\u0002\u0001\u0000*+\u0003\b\u0004\u0000+,\u0005\u0002\u0000\u0000,-\u0006"+
		"\u0000\uffff\uffff\u0000-\u0001\u0001\u0000\u0000\u0000.0\u0003\u0004"+
		"\u0002\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u00002\u0003\u0001\u0000\u0000"+
		"\u000034\u0003\u0006\u0003\u000045\u0005\u001d\u0000\u00005:\u0006\u0002"+
		"\uffff\uffff\u000067\u0005\u0014\u0000\u000078\u0005\u001e\u0000\u0000"+
		"89\u0005\u0015\u0000\u00009;\u0006\u0002\uffff\uffff\u0000:6\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<I\u0006"+
		"\u0002\uffff\uffff\u0000=>\u0005\u0011\u0000\u0000>?\u0005\u001d\u0000"+
		"\u0000?D\u0006\u0002\uffff\uffff\u0000@A\u0005\u0014\u0000\u0000AB\u0005"+
		"\u001e\u0000\u0000BC\u0005\u0015\u0000\u0000CE\u0006\u0002\uffff\uffff"+
		"\u0000D@\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001\u0000"+
		"\u0000\u0000FH\u0006\u0002\uffff\uffff\u0000G=\u0001\u0000\u0000\u0000"+
		"HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JL\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0005\u000e"+
		"\u0000\u0000M\u0005\u0001\u0000\u0000\u0000NO\u0005\u0003\u0000\u0000"+
		"OU\u0006\u0003\uffff\uffff\u0000PQ\u0005\u0004\u0000\u0000QU\u0006\u0003"+
		"\uffff\uffff\u0000RS\u0005\u001a\u0000\u0000SU\u0006\u0003\uffff\uffff"+
		"\u0000TN\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000U\u0007\u0001\u0000\u0000\u0000VX\u0006\u0004\uffff\uffff"+
		"\u0000WY\u0003\n\u0005\u0000XW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\t\u0001\u0000"+
		"\u0000\u0000\\c\u0003\f\u0006\u0000]c\u0003\u000e\u0007\u0000^c\u0003"+
		"\u0012\t\u0000_c\u0003\u001e\u000f\u0000`c\u0003 \u0010\u0000ac\u0003"+
		"\"\u0011\u0000b\\\u0001\u0000\u0000\u0000b]\u0001\u0000\u0000\u0000b^"+
		"\u0001\u0000\u0000\u0000b_\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000"+
		"\u0000ba\u0001\u0000\u0000\u0000c\u000b\u0001\u0000\u0000\u0000de\u0005"+
		"\u0005\u0000\u0000ef\u0005\f\u0000\u0000fg\u0003\u0010\b\u0000gh\u0006"+
		"\u0006\uffff\uffff\u0000hi\u0005\r\u0000\u0000ij\u0005\u000e\u0000\u0000"+
		"jk\u0006\u0006\uffff\uffff\u0000k\r\u0001\u0000\u0000\u0000lm\u0005\u0006"+
		"\u0000\u0000mn\u0005\f\u0000\u0000no\u0003\u0010\b\u0000op\u0006\u0007"+
		"\uffff\uffff\u0000pq\u0005\r\u0000\u0000qr\u0005\u000e\u0000\u0000rs\u0006"+
		"\u0007\uffff\uffff\u0000s\u000f\u0001\u0000\u0000\u0000tu\u0005\u001d"+
		"\u0000\u0000u\u007f\u0006\b\uffff\uffff\u0000vw\u0005\u0014\u0000\u0000"+
		"w|\u0006\b\uffff\uffff\u0000xy\u0005\u001d\u0000\u0000y}\u0006\b\uffff"+
		"\uffff\u0000z{\u0005\u001e\u0000\u0000{}\u0006\b\uffff\uffff\u0000|x\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0080\u0005\u0015\u0000\u0000\u007fv\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0011\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0003\u0014\n\u0000\u0082\u0083\u0005\u000e\u0000\u0000\u0083\u0084\u0006"+
		"\t\uffff\uffff\u0000\u0084\u0013\u0001\u0000\u0000\u0000\u0085\u0086\u0003"+
		"\u0010\b\u0000\u0086\u0087\u0006\n\uffff\uffff\u0000\u0087\u0088\u0005"+
		"\u0010\u0000\u0000\u0088\u008e\u0006\n\uffff\uffff\u0000\u0089\u008f\u0003"+
		"$\u0012\u0000\u008a\u008b\u0005\u001f\u0000\u0000\u008b\u008f\u0006\n"+
		"\uffff\uffff\u0000\u008c\u008d\u0007\u0000\u0000\u0000\u008d\u008f\u0006"+
		"\n\uffff\uffff\u0000\u008e\u0089\u0001\u0000\u0000\u0000\u008e\u008a\u0001"+
		"\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0006\n\uffff\uffff\u0000\u0091\u0015\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0003\u0018\f\u0000\u0093\u009a\u0006\u000b"+
		"\uffff\uffff\u0000\u0094\u0095\u0005\u0018\u0000\u0000\u0095\u0096\u0003"+
		"\u0018\f\u0000\u0096\u0097\u0006\u000b\uffff\uffff\u0000\u0097\u0099\u0001"+
		"\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0099\u009c\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u009b\u0001"+
		"\u0000\u0000\u0000\u009b\u0017\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009d\u009e\u0003\u001a\r\u0000\u009e\u00a5\u0006\f"+
		"\uffff\uffff\u0000\u009f\u00a0\u0005\u0017\u0000\u0000\u00a0\u00a1\u0003"+
		"\u001a\r\u0000\u00a1\u00a2\u0006\f\uffff\uffff\u0000\u00a2\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a3\u009f\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a6\u0019\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0005\u0019\u0000\u0000\u00a9\u00aa\u0003"+
		"\u001a\r\u0000\u00aa\u00ab\u0006\r\uffff\uffff\u0000\u00ab\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0005\f\u0000\u0000\u00ad\u00ae\u0003\u0016"+
		"\u000b\u0000\u00ae\u00af\u0005\r\u0000\u0000\u00af\u00b0\u0006\r\uffff"+
		"\uffff\u0000\u00b0\u00ba\u0001\u0000\u0000\u0000\u00b1\u00b2\u0003\u001c"+
		"\u000e\u0000\u00b2\u00b3\u0006\r\uffff\uffff\u0000\u00b3\u00ba\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0003\u0010\b\u0000\u00b5\u00b6\u0006\r\uffff"+
		"\uffff\u0000\u00b6\u00ba\u0001\u0000\u0000\u0000\u00b7\u00b8\u0007\u0000"+
		"\u0000\u0000\u00b8\u00ba\u0006\r\uffff\uffff\u0000\u00b9\u00a8\u0001\u0000"+
		"\u0000\u0000\u00b9\u00ac\u0001\u0000\u0000\u0000\u00b9\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000"+
		"\u0000\u0000\u00ba\u001b\u0001\u0000\u0000\u0000\u00bb\u00bc\u0003\u0010"+
		"\b\u0000\u00bc\u00bd\u0006\u000e\uffff\uffff\u0000\u00bd\u00c1\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0005\u001e\u0000\u0000\u00bf\u00c1\u0006\u000e"+
		"\uffff\uffff\u0000\u00c0\u00bb\u0001\u0000\u0000\u0000\u00c0\u00be\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"\u0016\u0000\u0000\u00c3\u00cb\u0006\u000e\uffff\uffff\u0000\u00c4\u00c5"+
		"\u0003\u0010\b\u0000\u00c5\u00c6\u0006\u000e\uffff\uffff\u0000\u00c6\u00cc"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u001e\u0000\u0000\u00c8\u00cc"+
		"\u0006\u000e\uffff\uffff\u0000\u00c9\u00ca\u0007\u0000\u0000\u0000\u00ca"+
		"\u00cc\u0006\u000e\uffff\uffff\u0000\u00cb\u00c4\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c7\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000"+
		"\u00cc\u001d\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0007\u0000\u0000"+
		"\u00ce\u00cf\u0005\f\u0000\u0000\u00cf\u00d0\u0003\u0016\u000b\u0000\u00d0"+
		"\u00d1\u0006\u000f\uffff\uffff\u0000\u00d1\u00d2\u0005\r\u0000\u0000\u00d2"+
		"\u00d3\u0005\b\u0000\u0000\u00d3\u00d4\u0005\u0012\u0000\u0000\u00d4\u00d6"+
		"\u0006\u000f\uffff\uffff\u0000\u00d5\u00d7\u0003\n\u0005\u0000\u00d6\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0013\u0000\u0000\u00db\u00e7"+
		"\u0006\u000f\uffff\uffff\u0000\u00dc\u00dd\u0005\t\u0000\u0000\u00dd\u00de"+
		"\u0005\u0012\u0000\u0000\u00de\u00e0\u0006\u000f\uffff\uffff\u0000\u00df"+
		"\u00e1\u0003\n\u0005\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2"+
		"\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0005\u0013\u0000\u0000\u00e5\u00e6\u0006\u000f\uffff\uffff\u0000\u00e6"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e7\u00dc\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0006\u000f\uffff\uffff\u0000\u00ea\u001f\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0005\n\u0000\u0000\u00ec\u00ed\u0005\f\u0000\u0000\u00ed"+
		"\u00ee\u0003\u0016\u000b\u0000\u00ee\u00ef\u0006\u0010\uffff\uffff\u0000"+
		"\u00ef\u00f0\u0005\r\u0000\u0000\u00f0\u00f1\u0005\b\u0000\u0000\u00f1"+
		"\u00f2\u0005\u0012\u0000\u0000\u00f2\u00f4\u0006\u0010\uffff\uffff\u0000"+
		"\u00f3\u00f5\u0003\n\u0005\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000\u0000\u00f6"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0005\u0013\u0000\u0000\u00f9\u00fa\u0006\u0010\uffff\uffff\u0000"+
		"\u00fa!\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005\u000b\u0000\u0000\u00fc"+
		"\u00fd\u0005\f\u0000\u0000\u00fd\u00fe\u0003\u0014\n\u0000\u00fe\u00ff"+
		"\u0005\u000e\u0000\u0000\u00ff\u0100\u0006\u0011\uffff\uffff\u0000\u0100"+
		"\u0101\u0003\u0016\u000b\u0000\u0101\u0102\u0006\u0011\uffff\uffff\u0000"+
		"\u0102\u0103\u0005\u000e\u0000\u0000\u0103\u0104\u0003\u0014\n\u0000\u0104"+
		"\u0105\u0006\u0011\uffff\uffff\u0000\u0105\u0106\u0005\r\u0000\u0000\u0106"+
		"\u0107\u0005\b\u0000\u0000\u0107\u0108\u0005\u0012\u0000\u0000\u0108\u010a"+
		"\u0006\u0011\uffff\uffff\u0000\u0109\u010b\u0003\n\u0005\u0000\u010a\u0109"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010a"+
		"\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d\u010e"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u0013\u0000\u0000\u010f\u0110"+
		"\u0006\u0011\uffff\uffff\u0000\u0110#\u0001\u0000\u0000\u0000\u0111\u0117"+
		"\u0003&\u0013\u0000\u0112\u0113\u0005\u000f\u0000\u0000\u0113\u0114\u0006"+
		"\u0012\uffff\uffff\u0000\u0114\u0116\u0003&\u0013\u0000\u0115\u0112\u0001"+
		"\u0000\u0000\u0000\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0001\u0000\u0000\u0000\u0118%\u0001\u0000"+
		"\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u0003\u0010"+
		"\b\u0000\u011b\u011c\u0006\u0013\uffff\uffff\u0000\u011c\u0120\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0005\u001e\u0000\u0000\u011e\u0120\u0006\u0013"+
		"\uffff\uffff\u0000\u011f\u011a\u0001\u0000\u0000\u0000\u011f\u011d\u0001"+
		"\u0000\u0000\u0000\u0120\'\u0001\u0000\u0000\u0000\u00161:DITZb|\u007f"+
		"\u008e\u009a\u00a5\u00b9\u00c0\u00cb\u00d8\u00e2\u00e7\u00f6\u010c\u0117"+
		"\u011f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}