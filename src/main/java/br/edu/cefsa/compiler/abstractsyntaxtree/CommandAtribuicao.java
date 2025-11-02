package br.edu.cefsa.compiler.abstractsyntaxtree;

public class CommandAtribuicao extends AbstractCommand {

    private String id;
    private String expr;

    public CommandAtribuicao(String id, String expr) {
        this.id = id;
        this.expr = expr;
    }

    @Override
    public String generateJavaCode() {
        // Começa com o valor padrão
        String translatedExpr = expr;
        
        // Verifica se a expressão precisa ser traduzida
        if (expr.equals("verdadeiro")) {
            translatedExpr = "true";
        } else if (expr.equals("falso")) {
            translatedExpr = "false";
        }

        return id + " = " + translatedExpr + ";"; 

    }    @Override
    public String toString() {
        return "CommandAtribuicao [id=" + id + ", expr=" + expr + "]";
    }

}
