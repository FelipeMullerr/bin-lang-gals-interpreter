# Bin Language - GALS Interpreter

## Descrição
Este projeto implementa a gramática e o interpretador de uma linguagem binária utilizando o **GALs (Generator of Analyzers for Lex and Syntax).**
O objetivo é aplicar e consolidar os conceitos de linguagens livres de contexto estudados na disciplina de Linguagens Formais e Autômatos.

A linguagem criada permite manipular **números binários inteiros sem sinal (positivos)**, possibilitando operações aritméticas, atribuição de variáveis e exibição de resultados.

---

## Tokens (Analisador Léxico)
```lex
:[\ \n\t\r\s]+
soma: "+"
subtracao: "-"
multiplicacao: "*"
divisao: "/"
exponenciacao: "^"
logaritmo: "log"
ParAbrir: "("
ParFechar: ")"
igual: "="
fim: ";"
show: "show"
numero: [0-1]+
variavel: [a-zA-Z]+
```
---
## Gramática da Linguagem
```
<listar_comandos> ::= <comando> <listar_comandos> | <comando>;
<comando> ::= <atribuicao_var> fim | <show> fim;
<atribuicao_var> ::= <nome_var> igual <D> #11;
<show> ::= show ParAbrir <nome_var> ParFechar #9;
<D> ::= <D> soma <C> #8 | <D> subtracao <C> #7 | <C>;
<C> ::= <C> multiplicacao <B> #6 | <C> divisao <B> #5 | <B>;
<B> ::= <B> exponenciacao <A> #4 | logaritmo ParAbrir <D> ParFechar #3 | <A>;
<A> ::= ParAbrir <D> ParFechar | <var_expr> | <numero>;
<nome_var> ::= variavel #10;
<var_expr> ::= variavel #2;
<numero> ::= numero #1;
```

---

## Funcionalidades
A linguagem possui as seguintes funcionalidades:

- **Atribuição** de valores ou expressões a variáveis  
- **Exibição** de valores na tela com `show()`  
- **Operações aritméticas suportadas**:
  - Soma (`+`)
  - Subtração (`-`)
  - Multiplicação (`*`)
  - Divisão (`/`)
  - Exponenciação (`^`)
  - Logaritmo (`log`)

---

##📝Exemplo de Código
```c
A = 10;
B = 11;
B = 111 + A * B;
C = B * A + 1000;
D = log(C);
show(B);
show(C);
show(D);
```
