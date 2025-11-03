package br.edu.cefsa.compiler.abstractsyntaxtree;

import br.edu.cefsa.compiler.datastructures.EasyVariable;

public class CommandLeitura extends AbstractCommand {

    private String id; // Armazena a string completa (ex: "a" ou "vetor[i]")
    private EasyVariable var; // Armazena a variável (para sabermos o tipo)

    public CommandLeitura(String id, EasyVariable var) {
        this.id = id;
        this.var = var;
    }

    @Override
    public String generateJavaCode() {
        // Gera o comando de scanner correto com base no tipo
        String scanCmd = "";
        switch (var.getType()) {
            case EasyVariable.NUMBER:
                scanCmd = "_key.nextDouble();";
                break;
            case EasyVariable.TEXT:
                scanCmd = "_key.nextLine();";
                break;
            case EasyVariable.BOOLEAN:
                scanCmd = "_key.nextBoolean();";
                break;
            default:
                scanCmd = "_key.next();"; // Fallback
        }
        return id + " = " + scanCmd + "\n";
    }

    @Override
    public String toString() {
        return "CommandLeitura [id=" + id + ", type=" + var.getType() + "]";
    }
}