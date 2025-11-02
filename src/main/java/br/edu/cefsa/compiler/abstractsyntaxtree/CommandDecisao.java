package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.util.ArrayList;

public class CommandDecisao extends AbstractCommand {

    private String condition;
    private ArrayList<AbstractCommand> listaTrue;
    private ArrayList<AbstractCommand> listaFalse;

    public CommandDecisao(String condition, ArrayList<AbstractCommand> listaTrue, ArrayList<AbstractCommand> listaFalse) {
        this.condition = condition;
        this.listaTrue = listaTrue;
        this.listaFalse = listaFalse;
    }

    @Override
    public String generateJavaCode() {
        StringBuilder sb = new StringBuilder();

        // **TRADUÇÃO IMPORTANTE**
        // Precisamos traduzir 'verdadeiro'/'falso' que possam estar
        // na string de condição (ex: "flag == verdadeiro")
        String translatedCondition = condition.replace("verdadeiro", "true")
                                              .replace("falso", "false");

        // Monta o bloco 'if'
        sb.append("if (" + translatedCondition + ") {\n");

        // Adiciona os comandos do bloco 'verdadeiro' com indentação
        for (AbstractCommand cmd : listaTrue) {
            // O .replaceAll garante que 'se' aninhados mantenham a indentação
            sb.append("\t" + cmd.generateJavaCode().replaceAll("\n", "\n\t")+ "\n");
        }
        sb.append("\n}\n");

        // Verifica se existe um bloco 'senao' (listaFalse)
        if (listaFalse != null && !listaFalse.isEmpty()) {
            sb.append("else {\n");
            
            // Adiciona os comandos do bloco 'falso' com indentação
            for (AbstractCommand cmd : listaFalse) {
                sb.append("\t" + cmd.generateJavaCode().replaceAll("\n", "\n\t")+ "\n");
            }
            sb.append("\n}\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "CommandDecisao [condition=" + condition + ", listaTrue=" + listaTrue.size() 
               + ", listaFalse=" + (listaFalse != null ? listaFalse.size() : 0) + "]";
    }
}