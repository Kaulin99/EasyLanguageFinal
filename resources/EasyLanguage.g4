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
        
declaravar :    tipo ID {
                        _varName = _input.LT(-1).getText();
                        _varValue = null;
                        symbol = new EasyVariable(_varName, _tipo, _varValue);
                        if (!symbolTable.exists(_varName)){
                            symbolTable.add(symbol);    
                        }
                        else{
                            throw new EasySemanticException("Symbol "+_varName+" already declared");
                        }
                    } 
                (   VIR 
                    ID {
                        _varName = _input.LT(-1).getText();
                        _varValue = null;
                        symbol = new EasyVariable(_varName, _tipo, _varValue);
                        if (!symbolTable.exists(_varName)){
                            symbolTable.add(symbol);    
                        }
                        else{
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
                        ID { verificaID(_input.LT(-1).getText());
                             _readID = _input.LT(-1).getText();
                           } 
                        FP 
                        SC 
                  {
                     EasyVariable var = (EasyVariable)symbolTable.get(_readID);
                     CommandLeitura cmd = new CommandLeitura(_readID, var);
                     stack.peek().add(cmd);
                  }   
                ;
                
cmdescrita  : 'escreva' 
                AP 
                ID { verificaID(_input.LT(-1).getText());
                     _writeID = _input.LT(-1).getText();
                   } 
                FP 
                SC
              {
                 CommandEscrita cmd = new CommandEscrita(_writeID);
                 stack.peek().add(cmd);
              }
            ;
            
cmdattrib
        :   atrib_rule SC 
        { 
            stack.peek().add($atrib_rule.atribCmd); 
        }
        ;
    
atrib_rule returns [CommandAtribuicao atribCmd]
        :   ID { verificaID(_input.LT(-1).getText());
                 _exprID = _input.LT(-1).getText();
               } 
            ATTR 
            { _exprContent = ""; } 
            (
                expr    // Expressão matemática
            |
                TEXTO { _exprContent = _input.LT(-1).getText(); } // Valor de Texto
            |
                (VERDADEIRO | FALSO) { _exprContent = _input.LT(-1).getText(); } // Valor Booleano
            )
            {
                $atribCmd = new CommandAtribuicao(_exprID, _exprContent);
            }
        ;

/*
 * --- SEÇÃO DE EXPRESSÃO LÓGICA (para 'se', 'enquanto', 'para') ---
 */

expr_logica returns [String str]
        : t1=termo_logico { $str = $t1.str; }
          ( OU t2=termo_logico { $str += " || " + $t2.str; } )* // Traduz 'ou' para '||'
        ;

termo_logico returns [String str]
        : f1=fator_logico { $str = $f1.str; }
          ( E f2=fator_logico { $str += " && " + $f2.str; } )* // Traduz 'e' para '&&'
        ;

fator_logico returns [String str]
        : NAO nao_f=fator_logico { $str = "!(" + $nao_f.str + ")"; }
        | AP expr_f=expr_logica FP { $str = "(" + $expr_f.str + ")"; }
        | c=comparacao { $str = $c.str; }
        | v=(ID | VERDADEIRO | FALSO) { 
              if ($v.type == ID) verificaID($v.getText());
              $str = $v.getText().equals("verdadeiro") ? "true" : 
                     $v.getText().equals("falso") ? "false" : 
                     $v.getText(); 
          }
        ;

comparacao returns [String str]
        : (ID | NUMBER) { 
              if (_input.LT(-1).getType() == ID) verificaID(_input.LT(-1).getText());
              // Pega o valor (ex: "flag" ou "5")
              $str = _input.LT(-1).getText(); 
          }
          OPREL { $str += _input.LT(-1).getText(); } // Pega o operador (ex: "==")
          
          (ID | NUMBER | VERDADEIRO | FALSO) { 
              if (_input.LT(-1).getType() == ID) verificaID(_input.LT(-1).getText());
              
              // **AQUI ESTÁ A CORREÇÃO**
              // Aplica a mesma lógica de tradução do fator_logico
              String val = _input.LT(-1).getText();
              $str += val.equals("verdadeiro") ? "true" :
                      val.equals("falso") ? "false" :
                      val;
          }
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
            
termo       : ID { verificaID(_input.LT(-1).getText());
                   _exprContent += _input.LT(-1).getText();
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