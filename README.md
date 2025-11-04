# Relatório Técnico: Compilador EasyLanguage
**Faculdade:** Faculdade Engenheiro Salvador Arena  
**ALUNO:** Robson Guilherme Ferrarezi - 082220015    
**ALUNO:** Kauê dos Santos Andrade - 082220027

---

## 1. Documentação Técnica

Esta seção detalha a especificação formal da sintaxe da linguagem e fornece exemplos práticos de sua aplicação.

### Especificação Formal da Sintaxe (EBNF)

A sintaxe da `EasyLanguage` foi definida usando a gramática ANTLR (`EasyLanguage.g4`). Abaixo está uma representação simplificada em EBNF (Extended Backus-Naur Form) das regras principais:

```ebnf
(* Regra Inicial *)
prog ::= 'programa' decl bloco 'fimprog;' [cite: 10]

(* Declarações *)
decl ::= (declaravar)+ [cite: 12]
declaravar ::= tipo ID ('[' NUMBER ']')? (',' ID ('[' NUMBER ']')? )* ';' [cite: 13-23]
tipo ::= 'numero' | 'texto' | 'booleano' [cite: 24-27]

(* Bloco de Comandos *)
bloco ::= (cmd)+ [cite: 28-29]
cmd ::= cmdleitura | cmdescrita | cmdattrib | cmdselecao | cmdenquanto | cmdpara [cite: 30-33]

(* Comandos *)
cmdleitura ::= 'leia' '(' designador ')' ';' [cite: 33-35]
cmdescrita ::= 'escreva' '(' designador ')' ';' [cite: 36-38]
cmdattrib ::= designador '=' (expr | TEXTO | VERDADEIRO | FALSO) ';' [cite: 51, 56-58]
cmdselecao ::= 'se' '(' expr_logica ')' 'faca' '{' (cmd)+ '}' ('senao' '{' (cmd)+ '}')? [cite: 78-85]
cmdenquanto ::= 'enquanto' '(' expr_logica ')' 'faca' '{' (cmd)+ '}' 
cmdpara ::= 'para' '(' cmdattrib expr_logica ';' cmdattrib ')' 'faca' '{' (cmd)+ '}' 

(* Designadores e Expressões *)
designador ::= ID ('[' (ID | NUMBER) ']')? [cite: 39-50]
expr ::= termo (('+' | '-' | '*' | '/') termo)* [cite: 96-97]
termo ::= designador | NUMBER [cite: 98-104]

(* Expressões Lógicas *)
expr_logica ::= termo_logico ('ou' termo_logico)* [cite: 58-60]
termo_logico ::= fator_logico ('e' fator_logico)* [cite: 60-61]
fator_logico ::= 'nao' fator_logico [cite: 62]
               | '(' expr_logica ')' [cite: 63]
               | comparacao [cite: 64]
               | designador [cite: 65-71]
               | VERDADEIRO [cite: 71-72]
               | FALSO [cite: 71-72]
               
comparacao ::= (designador | NUMBER) OPREL (designador | NUMBER | VERDADEIRO | FALSO) [cite: 73-77]

(* Terminais (Tokens) Principais *)
ID ::= [a-z] ([a-z] | [A-Z] | [0-9])* [cite: 111]
NUMBER ::= [0-9]+ ('.' [0-9]+)? [cite: 111-112]
TEXTO ::= '"' ( ~('"') )* '"' 
OPREL ::= '>' | '<' | '>=' | '<=' | '==' | '!=' [cite: 108]
```
### Exemplos Práticos de Programas `.easy`

[cite_start]Os exemplos a seguir demonstram as funcionalidades implementadas na linguagem, com base no arquivo `input.easy` [cite: 829-834] [cite_start]e nas regras da gramática [cite: 690-801].

#### 1. Declaração de Variáveis e Vetores

[cite_start]A linguagem suporta tipos `numero`, `texto` e `booleano` [cite: 713-716]. [cite_start]Vetores são declarados com um tamanho fixo [cite: 703-705, 709-710].

```java
// Exemplo de declarações (baseado em input.easy e EasyLanguage.g4)
programa

  numero a, i;
  numero vet[5]; // Declaração de um vetor de 5 posições
  texto msg;
  booleano flag; // A gramática suporta 'booleano'

  // ... comandos ...
fimprog;
```

#### 2. Atribuição, Leitura e Escrita (Arquivo `input.easy`)

[cite_start]Este exemplo demonstra atribuições simples, acesso a vetores (com variável e literal) e os comandos de E/S [cite: 829-834].

```java
// Conteúdo de input.easy
programa

  numero a, i;
  numero vet[5];
  texto msg;

  a = 10;
  i = 0;

  // Teste de atribuição e acesso
  vet[0] = a;       // Atribui 'a' (10) à posição 0
  vet[1] = 20;      // Atribui o literal 20 à posição 1
  // vet[i + 2] = 30; // ERRO! [cite_start]Expressões no índice não são suportadas [cite: 830-831]
  
  // Teste de leitura
  msg = "Digite um numero para o vetor[3]:";
  escreva(msg);
  leia(vet[3]); // Lê um valor do usuário para a posição 3
  
  // Teste de escrita
  msg = "O valor de vetor[1] eh:";
  escreva(msg);
  escreva(vet[1]); // Escreve o valor 20
  
  // Teste em condição
  se (vet[0] < vet[1]) faca {
      msg = "vetor[0] eh menor que vetor[1]";
      escreva(msg);
  }

fimprog;
```
[cite_start]*Fonte: `input.easy` [cite: 829-834]*

#### 3. Comando de Decisão (Se / Senao)

[cite_start]A gramática suporta blocos `senao` opcionais [cite: 770-772].

```java
// Exemplo de 'se' / 'senao' (baseado em EasyLanguage.g4)
programa
  numero a;
  a = 5;

  se (a == 10) faca {
      escreva("A eh 10");
  } senao {
      escreva("A nao eh 10");
  }

fimprog;
```

#### 4. Comando de Repetição (Enquanto)

[cite_start]A gramática implementa o loop `enquanto` (while) [cite: 775-778].

```java
// Exemplo de 'enquanto' (baseado em EasyLanguage.g4)
programa
  numero i;
  i = 0;

  enquanto (i < 5) faca {
      escreva(i);
      i = i + 1; [cite_start]// Expressão de incremento [cite: 785-786]
  }

fimprog;
```

#### 5. Comando de Repetição (Para)

[cite_start]A gramática implementa o loop `para` (for) com inicialização, condição e incremento [cite: 779-784].

```java
// Exemplo de 'para' (baseado em EasyLanguage.g4)
programa
  numero i;

  para (i = 0; i < 5; i = i + 1) faca {
      escreva(i);
  }

fimprog;
```

#### 6. Expressões Lógicas (E / Ou / Nao)

[cite_start]A linguagem suporta operadores lógicos `e`, `ou` e `nao` [cite: 747-752, 798].

```java
// Exemplo de operadores lógicos (baseado em EasyLanguage.g4)
programa
  booleano a, b;
  a = verdadeiro;
  b = falso;

  se (a e (nao b)) faca {
      escreva("A eh verdadeiro E B eh falso");
  }

fimprog;
```
## 2. Integração Curricular

Este projeto de compilador integra conceitos de múltiplas disciplinas do curso de Engenharia da Computação.

### Uso de Estruturas de Dados

A implementação do compilador faz uso extensivo de estruturas de dados fundamentais:

* **Tabela de Símbolos (HashMap):** A classe `EasySymbolTable.java` utiliza um `HashMap<String, EasySymbol>`. Esta estrutura é ideal para a tabela de símbolos por permitir a inserção (`add`) e busca (`get`, `exists`) de variáveis pelo nome (chave) em tempo O(1), em média.
* **Lista de Comandos (ArrayList):** A classe `EasyProgram.java` armazena a sequência de comandos em um `ArrayList<AbstractCommand>`. Isso permite que os comandos sejam armazenados na ordem em que aparecem e, posteriormente, iterados durante a fase de geração de código.
* [cite_start]**Pilha de Contexto (Stack):** Durante a análise sintática (parsing), a gramática `EasyLanguage.g4` (nos `@members`) utiliza uma `Stack<ArrayList<AbstractCommand>>`[cite: 699]. A pilha é essencial para gerenciar os escopos dos comandos. [cite_start]Quando o parser entra em um novo bloco (como `se`, `enquanto` ou `para`), ele "empilha" (push) uma nova lista de comandos [cite: 717, 768-769, 776-777, 782-783]. Ao final do bloco, ele "desempilha" (pop) a lista e a associa ao comando-pai.
* [cite_start]**Abstração de Vetor (Array):** A classe `EasyVariable.java` implementa a lógica para tratar uma variável como um vetor, gerenciando seu tamanho [cite: 703-704, 709-710] [cite_start]e validando o acesso aos seus índices (visto na regra `designador` de `EasyLanguage.g4` [cite: 731-737]).

### Aplicação de Linguagens Formais e Autômatos

O projeto é uma aplicação direta dos conceitos de linguagens formais e autômatos:

* [cite_start]**Linguagem Formal:** A sintaxe da `EasyLanguage` é uma linguagem formal, definida rigorosamente pela gramática EBNF (conforme visto na Seção 1) e implementada no arquivo `EasyLanguage.g4` [cite: 690-801].
* [cite_start]**Analisador Léxico (Autômato Finito):** O `EasyLanguageLexer.java` (gerado pelo ANTLR a partir das regras léxicas no final de `EasyLanguage.g4` [cite: 794-801]) atua como um Autômato Finito. Ele lê o fluxo de caracteres do arquivo `input.easy` e o converte em um fluxo de *tokens* (ex: `PROGRAMA`, `ID`, `NUMBER`, `ATTR`). [cite_start]Tokens como `WS` (espaço em branco) e `COMENTARIO` são reconhecidos e descartados (`-> skip`) [cite: 800-801].
* [cite_start]**Analisador Sintático (Autômato de Pilha):** O `EasyLanguageParser.java` (gerado pelo ANTLR a partir das regras sintáticas de `EasyLanguage.g4` [cite: 699-793]) funciona como um Autômato de Pilha (implementado como um parser de descida recursiva LL). Ele consome os tokens do léxico e os valida contra as regras da gramática, construindo uma árvore de análise (parse tree) e executando as ações semânticas embutidas.

### Implementação de Fases de Compiladores

O projeto implementa as fases clássicas de um compilador, traduzindo o código `.easy` para código Java.

1.  **Análise Léxica:**
    * [cite_start]**Responsável:** `EasyLanguageLexer.java` (gerado de `EasyLanguage.g4` [cite: 794-801]).
    * [cite_start]**Entrada:** Arquivo `input.easy` [cite: 829-834].
    * **Saída:** Fluxo de Tokens (ex: `T__0` ('programa'), `ID` ('a'), `ATTR` ('='), `NUMBER` ('10'), `SC` (';')).

2.  **Análise Sintática:**
    * [cite_start]**Responsável:** `EasyLanguageParser.java` (gerado de `EasyLanguage.g4` [cite: 699-793]).
    * **Entrada:** Fluxo de Tokens do Léxico.
    * **Saída:** Uma Árvore Sintática Abstrata (AST) implícita, representada pela `EasyProgram` que contém a lista de `AbstractCommand`. [cite_start]O parser dispara as ações de construção da AST [cite: 700, 717, 724, 727, 740, 773-774, 778, 784].

3.  **Análise Semântica:**
    * [cite_start]**Responsável:** Ações semânticas embutidas em `EasyLanguage.g4` [cite: 696, 705-707, 710-712, 730, 731-732, 733-734, 735-737, 741-743, 754-757, 762-763, 764-765, 787-790] e classes de estruturas de dados (como `EasySymbolTable.java` e `EasyVariable.java`).
    * **Processo:** Ocorre *durante* a análise sintática.
    * [cite_start]**Verificação de Declaração:** Usa `symbolTable.exists(id)` [cite: 696] [cite_start]antes de usar uma variável ou ao declará-la [cite: 705-707, 710-712]. Lança `EasySemanticException` se o símbolo não existe ou já foi declarado.
    * [cite_start]**Verificação de Tipos:** Verifica se o índice de um vetor é do tipo `numero` [cite: 733-734] [cite_start]ou se variáveis usadas em expressões matemáticas são numéricas [cite: 789-790].
    * [cite_start]**Verificação de Uso:** Impede a atribuição a um vetor inteiro (ex: `vet = 5`) [cite: 741-743] [cite_start]ou o uso de um vetor inteiro em expressões [cite: 754-755, 762-763, 764-765, 787-789].
    * [cite_start]**Verificação de Limites:** Valida se o índice literal de um vetor está dentro dos limites declarados [cite: 735-737].

4.  **Geração de Código (Tradução):**
    * **Responsável:** O método `generateTarget()` em `EasyProgram.java` e os métodos `generateJavaCode()` em cada classe `Command...` (ex: `CommandAtribuicao.java`, `CommandEscrita.java`, `CommandDecisao.java`, etc.).
    * **Processo:** `EasyProgram.java` cria o "esqueleto" do arquivo `.java` final (incluindo `main`, `Scanner`, e declarações de variáveis). Em seguida, ele itera pela lista de `AbstractCommand` e chama o método `generateJavaCode()` de cada comando.
    * **Exemplo (Tradução):**
        * `escreva(msg);` (em `.easy`) é traduzido para `System.out.println(msg);` (em Java) pela `CommandEscrita.java`.
        * `a = 10;` (em `.easy`) é traduzido para `a = 10;` (em Java) pela `CommandAtribuicao.java`.
        * `se (a < b) faca { ... }` (em `.easy`) é traduzido para `if (a < b) { ... }` (em Java) pela `CommandDecisao.java`.

