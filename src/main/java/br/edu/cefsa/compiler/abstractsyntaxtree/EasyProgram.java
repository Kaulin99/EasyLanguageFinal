package br.edu.cefsa.compiler.abstractsyntaxtree;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import br.edu.cefsa.compiler.datastructures.EasySymbol;
import br.edu.cefsa.compiler.datastructures.EasySymbolTable;
import br.edu.cefsa.compiler.datastructures.EasyVariable;

public class EasyProgram {

    private EasySymbolTable varTable;
    private ArrayList<AbstractCommand> comandos;
    private String programName;

    public void generateTarget() {
        StringBuilder str = new StringBuilder();
        str.append("import java.util.Scanner;\n");
        str.append("public class MainClass{ \n");
        str.append(" public static void main(String args[]){\n ");
        str.append("  Scanner _key = new Scanner(System.in);\n");

        // --- PASSO 1: Gerar as DECLARAÇÕES ---
        // (Este loop você já tinha)
        for (EasySymbol symbol : varTable.getAll()) {
            str.append(symbol.generateJavaCode() + "\n");
        }

        // --- PASSO 2: Gerar as INICIALIZAÇÕES DE VETOR (NOVO!) ---
        // Precisamos de um novo loop para instanciar os vetores
        str.append("\n  // Inicializando vetores\n");
        for (EasySymbol symbol : varTable.getAll()) {
            // Verifica se o símbolo é uma EasyVariable E se é um vetor
            if (symbol instanceof EasyVariable && ((EasyVariable)symbol).isVector()) {
                EasyVariable var = (EasyVariable)symbol;
                String javaType;
                
                switch (var.getType()) {
                    case EasyVariable.NUMBER:
                        javaType = "double";
                        break;
                    case EasyVariable.TEXT:
                        javaType = "String";
                        break;
                    case EasyVariable.BOOLEAN:
                        javaType = "boolean";
                        break;
                    default:
                        javaType = "Object";
                }
                
                // Gera a linha: ex: a = new double[10];
                str.append("  " + var.getName() + " = new " + javaType + "[" + var.getVectorSize() + "];\n");
            }
        }
        str.append("\n"); // Adiciona uma linha em branco para separar

        // --- PASSO 3: Gerar os COMANDOS ---
        // (Este loop você já tinha)
        for (AbstractCommand command : comandos) {
            str.append(command.generateJavaCode() + "\n"); // generateJavaCode() já deve ter \n
        }
        
        str.append(" }\n"); // Fim do main
        str.append("}\n"); // Fim da classe

        try {
            FileWriter fr = new FileWriter(new File("./resources/MainClass.java"));
            fr.write(str.toString());
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public EasySymbolTable getVarTable() {
        return varTable;
    }

    public void setVarTable(EasySymbolTable varTable) {
        this.varTable = varTable;
    }

    public ArrayList<AbstractCommand> getComandos() {
        return comandos;
    }

    public void setComandos(ArrayList<AbstractCommand> comandos) {
        this.comandos = comandos;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

}