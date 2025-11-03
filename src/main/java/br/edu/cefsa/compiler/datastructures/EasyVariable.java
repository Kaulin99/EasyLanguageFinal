package br.edu.cefsa.compiler.datastructures;

public class EasyVariable extends EasySymbol {

    public static final int NUMBER = 0;
    public static final int TEXT = 1;
    public static final int BOOLEAN = 2;

    private int type;
    private String value; // Usado apenas para tipos simples
    private boolean isVector;
    private int vectorSize;

    // Construtor para tipos SIMPLES
    public EasyVariable(String name, int type, String value) {
        super(name);
        this.type = type;
        this.value = value;
        this.isVector = false; // Não é um vetor
        this.vectorSize = 0;
    }

    // NOVO CONSTRUTOR para VETORES
    public EasyVariable(String name, int type, int vectorSize) {
        super(name);
        this.type = type;
        this.vectorSize = vectorSize;
        this.isVector = true; // Sim, é um vetor
        this.value = null; // Vetores não têm um valor único
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public boolean isVector() {
        return isVector;
    }

    public int getVectorSize() {
        return vectorSize;
    }

    @Override
    public String toString() {
        if (isVector) {
            return "EasyVariable [name=" + name + ", type=" + type + ", isVector=true, size=" + vectorSize + "]";
        }
        return "EasyVariable [name=" + name + ", type=" + type + ", value=" + value + "]";
    }

    // ATUALIZADO para gerar declaração de vetor
    @Override
    public String generateJavaCode() {
        String javaType;
        switch (type) {
            case NUMBER:
                javaType = "double";
                break;
            case TEXT:
                javaType = "String";
                break;
            case BOOLEAN:
                javaType = "boolean";
                break;
            default:
                javaType = "Object";
        }

        // Se for um vetor, adicione os colchetes "[]"
        if (isVector) {
            javaType += "[]";
        }
        
        return javaType + " " + super.name + ";";
    }
}