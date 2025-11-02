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
	
	public void exibeComandos(){
		for (AbstractCommand c: program.getComandos()){
			System.out.println(c);
		}
	}
	
	public void generateCode(){
		program.generateTarget();
	}
}

prog	: 'programa' decl bloco 'fimprog;'
           {  program.setVarTable(symbolTable);
              program.setComandos(stack.pop());
           	 
           } 
	;
		
decl    :  (declaravar)+
        ;
        
        
declaravar :  tipo ID  {
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
              (  VIR 
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
              )* 
               SC
           ;
           
tipo       : 'numero' { _tipo = EasyVariable.NUMBER;  }
           | 'texto'  { _tipo = EasyVariable.TEXT;  }
           ;
        
bloco	: { curThread = new ArrayList<AbstractCommand>(); 
	        stack.push(curThread);  
          }
          (cmd)+
		;
		

cmd		:  cmdleitura  
 		|  cmdescrita 
 		|  cmdattrib
 		|  cmdselecao  
		|  cmdenquanto
		|  cmdpara
		;
		
cmdleitura	: 'leia' AP
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
			
cmdescrita	: 'escreva' 
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
				expr
			|
				TEXTO { _exprContent = _input.LT(-1).getText(); }
			)
			
			{

			$atribCmd = new CommandAtribuicao(_exprID, _exprContent);
			}
		;
			
			
cmdselecao  :  'se' AP
                    ID    { _exprDecision = _input.LT(-1).getText(); }
                    OPREL { _exprDecision += _input.LT(-1).getText(); }
                    (ID | NUMBER) {_exprDecision += _input.LT(-1).getText(); }
                    FP 
                    ACH 
                    { curThread = new ArrayList<AbstractCommand>(); 
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
                   		CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
                   		stack.peek().add(cmd);
                   	}
                   )?
            ;

cmdenquanto : 'enquanto' AP
                ID          { _exprEnquanto = _input.LT(-1).getText(); }
                OPREL       { _exprEnquanto += _input.LT(-1).getText(); }
                (ID | NUMBER) {_exprEnquanto += _input.LT(-1).getText(); }
              FP 'faca' 
              ACH 
              { 
                // 1. Inicia uma nova lista de comandos para o corpo do laço
                curThread = new ArrayList<AbstractCommand>(); 
                // 2. Empilha a nova lista
                stack.push(curThread);
              }
              (cmd)+ 
              FCH
              {
                // 4. Desempilha a lista de comandos do laço
                listaEnquanto = stack.pop(); 
                
                // 5. Cria o objeto CommandEnquanto com a condição e a lista de comandos
                CommandEnquanto cmd = new CommandEnquanto(_exprEnquanto, listaEnquanto);
                
                // 6. Adiciona o comando 'enquanto' na lista de comandos atual (a que está no topo da pilha agora)
                stack.peek().add(cmd);
              }
            ;

cmdpara : 'para' AP
            // 1. Inicialização
            init=atrib_rule SC 
            { 
              _paraInit = $init.atribCmd;
            }
            
            // 2. Condição (lógica igual ao 'se' e 'enquanto')
            ID          { _paraCondicao = _input.LT(-1).getText(); }
            OPREL       { _paraCondicao += _input.LT(-1).getText(); }
            (ID | NUMBER) {_paraCondicao += _input.LT(-1).getText(); }
            SC // Ponto e vírgula depois da condição
            
            // 3. Incremento
            incr=atrib_rule 
            { 
              _paraIncr = $incr.atribCmd;
            }
          FP 'faca' // Fecha parênteses e espera o 'faca'
          ACH       // Abre Chaves
          { 
            // Ações para o bloco de comandos
            curThread = new ArrayList<AbstractCommand>(); 
            stack.push(curThread);
          }
          (cmd)+  // Analisa os comandos dentro do laço
          FCH       // Fecha Chaves
          {
            // Ações pós-bloco
            listaPara = stack.pop(); // Pega a lista de comandos do laço
            
            // Cria o objeto CommandPara
            CommandPara cmd = new CommandPara(_paraInit, _paraCondicao, _paraIncr, listaPara);
            
            // Adiciona o laço 'para' na pilha principal
            stack.peek().add(cmd);
          }
        ;
			
expr        :  termo ( 
                        OP  { _exprContent += _input.LT(-1).getText();}
                        termo
	             )*
            ;
			
termo	    : ID { verificaID(_input.LT(-1).getText());
	               _exprContent += _input.LT(-1).getText();
                 } 
            | 
              NUMBER
              {
              	_exprContent += _input.LT(-1).getText();
              }
			;
			
	
AP	: '('
	;
	
FP	: ')'
	;
	
SC	: ';'
	;
	
OP	: '+' | '-' | '*' | '/'
	;
	
ATTR : '='
     ;
	 
VIR  : ','
     ;
     
ACH  : '{'
     ;
     
FCH  : '}'
     ;
	 
	 
OPREL : '>' | '<' | '>=' | '<=' | '==' | '!='
      ;
      
ID	: [a-z] ([a-z] | [A-Z] | [0-9])*
	;
	
NUMBER	: [0-9]+ ('.' [0-9]+)?
	;

TEXTO  : '"' ( ~('"') )* '"'
    ;

COMENTARIO : '//' ~[\r\n]* -> skip
    ;
		
WS	: (' ' | '\t' | '\n' | '\r') -> skip;