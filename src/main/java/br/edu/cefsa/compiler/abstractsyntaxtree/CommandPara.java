package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;

/**
 * Esta classe representa o comando 'para' (for loop) na árvore sintática.
 * Armazena os comandos de inicialização, incremento, a condição de parada
 * e a lista de comandos do bloco.
 */
public class CommandPara extends AbstractCommand {

    // Usaremos CommandAtribuicao para reaproveitar a lógica
    // Assumindo que você tem uma classe 'CommandAtribuicao'
    private CommandAtribuicao inicializacao;
    private String condicao;
    private CommandAtribuicao incremento; 
    
    private ArrayList<AbstractCommand> loopCommands;

    public CommandPara(CommandAtribuicao inicializacao, String condicao, 
                       CommandAtribuicao incremento, ArrayList<AbstractCommand> loopCommands) {
        this.inicializacao = inicializacao;
        this.condicao = condicao;
        this.incremento = incremento;
        this.loopCommands = loopCommands;
    }

    /**
     * Gera o código Java correspondente ao laço 'for'.
     */
    @Override
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();

        // Extrai as partes das classes CommandAtribuicao para montar o 'for'
        // Assumindo que CommandAtribuicao.generateJavaCode() retorna "var = expr;"
        // Precisamos "desmontar" para caber no ( ; ; )
        
        // Se sua CommandAtribuicao for simples (var, expr), seria algo como:
        // String initStr = inicializacao.getId() + " = " + inicializacao.getExpr();
        // String incStr = incremento.getId() + " = " + incremento.getExpr();
        
        // Mas vamos usar o generateJavaCode() e remover o ";\n"
        // Esta é uma suposição que talvez precise de ajuste dependendo da sua CommandAtribuicao
        
        String initCode = inicializacao.generateJavaCode().replace(";\n", "").replace(";", "");
        String incCode = incremento.generateJavaCode().replace(";\n", "").replace(";", "");

        // Constrói o 'for'
        sb.append("for (" + initCode + "; " + condicao + "; " + incCode + ") {\n");
        
        // Adiciona os comandos dentro do bloco do 'for', com indentação
        for (AbstractCommand cmd : loopCommands) {
            sb.append("\t" + cmd.generateJavaCode().replaceAll("\n", "\n\t"));
            sb.append("\n");
        }
        
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        // Usado para depuração
        return "CommandPara [init=" + inicializacao + ", cond=" + condicao 
                + ", inc=" + incremento + ", commands=" + loopCommands.size() + "]";
    }
}