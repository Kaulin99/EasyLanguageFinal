package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;

/*
* Esta classe representa o comando 'enquanto' na árvore sintática.
* Ela armazena a condição e a lista de comandos do bloco.
*/
public class CommandEnquanto extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> loopCommands;

    public CommandEnquanto(String condition, ArrayList<AbstractCommand> loopCommands) {
        this.condition = condition;
        this.loopCommands = loopCommands;
    }

    @Override
    public String generateJavaCode() {
        // Vou assumir que o alvo é parecido com Java para este exemplo.
        StringBuilder sb = new StringBuilder();
        
        // Constrói a condição do while
        sb.append("while (" + condition + ") {\n");
        
        // Adiciona os comandos dentro do bloco do while, com indentação
        for (AbstractCommand cmd : loopCommands) {
            // Adiciona um "tab" para indentar o código dentro do laço
            sb.append("\t" + cmd.generateJavaCode() + "\n"); 
        }
        
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        // Usado para depuração, como no seu método exibeComandos()
        return "CommandEnquanto [condition=" + condition + ", commands=" + loopCommands.size() + "]";
    }
}