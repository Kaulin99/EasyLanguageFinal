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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyLanguageParser}.
 */
public interface EasyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(EasyLanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(EasyLanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(EasyLanguageParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(EasyLanguageParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(EasyLanguageParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(EasyLanguageParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(EasyLanguageParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(EasyLanguageParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(EasyLanguageParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(EasyLanguageParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdattrib(EasyLanguageParser.CmdattribContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdattrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdattrib(EasyLanguageParser.CmdattribContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#atrib_rule}.
	 * @param ctx the parse tree
	 */
	void enterAtrib_rule(EasyLanguageParser.Atrib_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#atrib_rule}.
	 * @param ctx the parse tree
	 */
	void exitAtrib_rule(EasyLanguageParser.Atrib_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void enterCmdselecao(EasyLanguageParser.CmdselecaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdselecao}.
	 * @param ctx the parse tree
	 */
	void exitCmdselecao(EasyLanguageParser.CmdselecaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdenquanto(EasyLanguageParser.CmdenquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdenquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdenquanto(EasyLanguageParser.CmdenquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdpara}.
	 * @param ctx the parse tree
	 */
	void enterCmdpara(EasyLanguageParser.CmdparaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdpara}.
	 * @param ctx the parse tree
	 */
	void exitCmdpara(EasyLanguageParser.CmdparaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EasyLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EasyLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(EasyLanguageParser.TermoContext ctx);
}