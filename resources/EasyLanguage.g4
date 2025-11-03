grammar EasyLanguage;

@header{
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
}

@members{
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
}

/*
 * --- REGRAS DO PARSER ---
 */

prog    : 'programa' decl bloco 'fimprog;'
            {   program.setVarTable(symbolTable);
                program.setComandos(stack.pop());
            } 
        ;
        
decl    :   (declaravar)+
        ;
        
declaravar : tipo 
               // Processa o PRIMEIRO identificador
               ID {
                   _varName = _input.LT(-1).getText();
                   _varValue = null;
                   symbol = new EasyVariable(_varName, _tipo, _varValue); // Assume que é simples
               }
               // VERIFICA SE É UM VETOR (opcional)
               ( 
                 AC n=NUMBER FC {
                    // Se for um vetor, cria o símbolo de vetor
                    int size = Integer.parseInt($n.getText());
                    symbol = new EasyVariable(_varName, _tipo, size);
                 }
               )?
               {
                  // Adiciona o primeiro símbolo (seja simples ou vetor)
                  if (!symbolTable.exists(_varName)){
                      symbolTable.add(symbol);    
                  } else {
                      throw new EasySemanticException("Symbol "+_varName+" already declared");
                  }
               }

               // Processa os OUTROS identificadores (opcional)
               ( 
                 VIR 
                 ID {
                    _varName = _input.LT(-1).getText();
                    _varValue = null;
                    symbol = new EasyVariable(_varName, _tipo, _varValue); // Assume que é simples
                 }
                 // VERIFICA SE É UM VETOR (opcional)
                 (
                   AC n=NUMBER FC {
                     int size = Integer.parseInt($n.getText());
                     symbol = new EasyVariable(_varName, _tipo, size);
                   }
                 )?
                 {
                    // Adiciona o símbolo (seja simples ou vetor)
                    if (!symbolTable.exists(_varName)){
                        symbolTable.add(symbol);    
                    } else {
                        throw new EasySemanticException("Symbol "+_varName+" already declared");
                    }
                 }
               )* SC
            ;
            
tipo        : 'numero' { _tipo = EasyVariable.NUMBER;   }
            | 'texto'  { _tipo = EasyVariable.TEXT;     }
            | BOOLEANO { _tipo = EasyVariable.BOOLEAN; }
            ;
        
bloco   : { curThread = new ArrayList<AbstractCommand>(); 
            stack.push(curThread);  
          }
          (cmd)+
        ;
        
cmd     :   cmdleitura  
        |   cmdescrita 
        |   cmdattrib
        |   cmdselecao  
        |   cmdenquanto
        |   cmdpara
        ;
        
cmdleitura  : 'leia' AP
              d=designador { _readID = $d.str; } // Usa 'designador'
              FP 
              SC 
              {
                 // Passa a string ("vetor[i]") e a variável base (para tipo)
                 EasyVariable var = (EasyVariable)symbolTable.get($d.baseName);
                 CommandLeitura cmd = new CommandLeitura($d.str, var);
                 stack.peek().add(cmd);
              }   
            ;
            
cmdescrita  : 'escreva' 
                AP 
                d=designador { _writeID = $d.str; } // Usa 'designador'
                FP 
                SC
              {
                 CommandEscrita cmd = new CommandEscrita(_writeID);
                 stack.peek().add(cmd);
              }
            ;

designador returns [String str, String baseName, boolean isIndexed]
        @init {
            EasyVariable var;
        }
        : ID {
            $baseName = $ID.text;
            verificaID($baseName);
            $str = $baseName; // String padrão
            $isIndexed = false;
            var = (EasyVariable)symbolTable.get($baseName);
        }
        ( // Bloco opcional para acesso a vetor
            AC {
                if (!var.isVector()) {
                    throw new EasySemanticException("Symbol "+$baseName+" is not a vector and cannot be accessed with []");
                }
                $isIndexed = true;
            }
            (
                // Opção 1: Índice é uma variável (ex: i)
                i=ID {
                    verificaID($i.text);
                    EasyVariable indexVar = (EasyVariable)symbolTable.get($i.text);
                    if (indexVar.getType() != EasyVariable.NUMBER) {
                        throw new EasySemanticException("Vector index "+$i.text+" is not a 'numero'");
                    }
                    $str += "[" + $i.text + "]"; // Gera "vetor[i]"
                }
            |
                // Opção 2: Índice é um número literal (ex: 5)
                n=NUMBER {
                    int index = Integer.parseInt($n.text);
                    // Verificação de limites
                    if (index < 0 || index >= var.getVectorSize()) {
                        throw new EasySemanticException("Vector index "+index+" out of bounds for "+$baseName+"[0.."+(var.getVectorSize()-1)+"]");
                    }
                    $str += "[" + $n.text + "]"; // Gera "vetor[5]"
                }
            )
            FC
        )? // O bloco de acesso é opcional
        ;
            
cmdattrib
        :   atrib_rule SC 
        { 
            stack.peek().add($atrib_rule.atribCmd); 
        }
        ;
    
atrib_rule returns [CommandAtribuicao atribCmd]
        :   d=designador { // Usa 'designador'
                EasyVariable var = (EasyVariable)symbolTable.get($d.baseName);
                // Verificação semântica: não podemos atribuir a um vetor inteiro
                if (var.isVector() && !$d.isIndexed) {
                    throw new EasySemanticException("Cannot assign value to whole vector '"+$d.baseName+"'. Specify an index [].");
                }
                _exprID = $d.str; // _exprID agora é "a" ou "vetor[i]"
            } 
            ATTR 
            { _exprContent = ""; } 
            (
                expr
            |
                TEXTO { _exprContent = _input.LT(-1).getText(); }
            |
                (VERDADEIRO | FALSO) { _exprContent = _input.LT(-1).getText(); }
            )
            {
                $atribCmd = new CommandAtribuicao(_exprID, _exprContent);
            }
        ;

expr_logica returns [String str]
        : t1=termo_logico { $str = $t1.str; }
          ( OU t2=termo_logico { $str += " || " + $t2.str; } )* // Traduz 'ou' para '||'
        ;

termo_logico returns [String str]
        : f1=fator_logico { $str = $f1.str; }
          ( E f2=fator_logico { $str += " && " + $f2.str; } )* // Traduz 'e' para '&&'
        ;

fator_logico returns [String str]
        : NAO f=fator_logico { $str = "!(" + $f.str + ")"; }
        | AP e=expr_logica FP { $str = "(" + $e.str + ")"; }
        | c=comparacao { $str = $c.str; }
        | d=designador { // Acesso simples (ex: 'se (flag)' ou 'se (vetor[i])')
              EasyVariable var = (EasyVariable)symbolTable.get($d.baseName);
              if (var.isVector() && !$d.isIndexed) {
                   throw new EasySemanticException("Cannot use whole vector '"+$d.baseName+"' in a boolean expression");
              }
              if (var.getType() != EasyVariable.BOOLEAN) {
                   throw new EasySemanticException("Cannot use non-boolean variable '"+$d.str+"' in a boolean expression");
              }
              
              String val = $d.str;
              $str = val.equals("verdadeiro") ? "true" :
                     val.equals("falso") ? "false" :
                     val;
          }
        | v=(VERDADEIRO | FALSO) { // Literal (ex: 'se (verdadeiro)')
             String val = $v.getText();
             $str = val.equals("verdadeiro") ? "true" : "false";
          }
        ;

comparacao returns [String str]
        : ( d1=designador { // Lado Esquerdo
              EasyVariable var = (EasyVariable)symbolTable.get($d1.baseName);
              if (var.isVector() && !$d1.isIndexed) {
                  throw new EasySemanticException("Cannot use whole vector '"+$d1.baseName+"' in a comparison");
              }
              $str = $d1.str;
          }
        | n1=NUMBER { $str = $n1.getText(); } 
        )
        
          OPREL { $str += _input.LT(-1).getText(); } 
          
        ( d2=designador { // Lado Direito
              EasyVariable var = (EasyVariable)symbolTable.get($d2.baseName);
              if (var.isVector() && !$d2.isIndexed) {
                  throw new EasySemanticException("Cannot use whole vector '"+$d2.baseName+"' in a comparison");
              }
              String val = $d2.str;
              $str += val.equals("verdadeiro") ? "true" :
                      val.equals("falso") ? "false" :
                      val;
          }
        | n2=NUMBER { $str += $n2.getText(); } 
        | v=(VERDADEIRO | FALSO) { // Lado direito pode ser um booleano
              String val = $v.getText();
              $str += val.equals("verdadeiro") ? "true" : "false";
          }
        )
        ;

/*
 * --- SEÇÃO DE COMANDOS DE CONTROLE ---
 */
                
cmdselecao  :   'se' AP
                c=expr_logica { _exprDecision = $c.str; }
                FP 
                'faca'
                ACH 
                { 
                    curThread = new ArrayList<AbstractCommand>(); 
                    stack.push(curThread);
                }
                (cmd)+ 
                FCH
                {
                    listaTrue = stack.pop();
                } 
                ('senao' 
                    ACH
                    {
                        curThread = new ArrayList<AbstractCommand>();
                        stack.push(curThread);
                    } 
                    (cmd+) 
                    FCH
                    {
                        listaFalse = stack.pop();
                    }
                )?
                {
                    CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                    stack.peek().add(cmd);
                    listaFalse = null; // Reseta listaFalse para o próximo 'se'
                }
            ;

cmdenquanto : 'enquanto' AP
                c=expr_logica { _exprEnquanto = $c.str; }
                FP 'faca' 
                ACH 
                { 
                    curThread = new ArrayList<AbstractCommand>(); 
                    stack.push(curThread);
                }
                (cmd)+ 
                FCH
                {
                    listaEnquanto = stack.pop(); 
                    CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaEnquanto);
                    stack.peek().add(cmd);
                }
            ;

cmdpara : 'para' AP
                init=atrib_rule SC 
                { 
                  _paraInit = $init.atribCmd; 
                }
                
                c=expr_logica { _paraCondicao = $c.str; }
                SC 

                incr=atrib_rule 
                { 
                  _paraIncr = $incr.atribCmd; 
                }
            FP 'faca'
            ACH
            { 
                curThread = new ArrayList<AbstractCommand>(); 
                stack.push(curThread);
            }
            (cmd)+  
            FCH     
            {
                listaPara = stack.pop();
                CommandPara cmd = new CommandPara(_paraInit, _paraCondicao, _paraIncr, listaPara);
                stack.peek().add(cmd);
            }
        ;

/*
 * --- SEÇÃO DE EXPRESSÃO MATEMÁTICA (para atribuição) ---
 */
                
expr        :   termo ( 
                        OP  { _exprContent += _input.LT(-1).getText();}
                        termo
                    )*
            ;
            
termo       : d=designador { 
                   EasyVariable var = (EasyVariable)symbolTable.get($d.baseName);
                   // Verificação semântica: não pode usar vetor inteiro em matemática
                   if (var.isVector() && !$d.isIndexed) {
                       throw new EasySemanticException("Cannot use whole vector '"+$d.baseName+"' in a math expression");
                   }
                   // Verificação semântica: não pode usar texto/booleano em matemática
                   if (var.getType() != EasyVariable.NUMBER) {
                        throw new EasySemanticException("Cannot use non-numeric variable '"+$d.str+"' in a math expression");
                   }
                   _exprContent += $d.str;
                 } 
            | 
              NUMBER 
              {
                _exprContent += _input.LT(-1).getText();
              }
            ;
            
/* * --- SEÇÃO DE TOKENS (LEXER) ---
 */
    
AP  : '(';
FP  : ')';
SC  : ';';
OP  : '+' | '-' | '*' | '/';
ATTR : '=';
VIR  : ',';
ACH  : '{';
FCH  : '}';
AC   : '['; 
FC   : ']'; 
     
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!=' ;

/*
 * TOKENS DE PALAVRA-CHAVE (ANTES do ID)
 */
E   : 'e';
OU  : 'ou';
NAO : 'nao'; 
BOOLEANO   : 'booleano';
VERDADEIRO : 'verdadeiro';
FALSO      : 'falso';
     
/*
 * TOKENS GENÉRICOS
 */
ID  : [a-z] ([a-z] | [A-Z] | [0-9])* ; 
NUMBER  : [0-9]+ ('.' [0-9]+)? ;
TEXTO   : '"' ( ~('"') )* '"' ;

/*
 * TOKENS A SEREM IGNORADOS
 */
COMENTARIO : '//' ~[\r\n]* -> skip ;
WS  : (' ' | '\t' | '\n' | '\r') -> skip ;