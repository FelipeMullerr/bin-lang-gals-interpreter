package Gals;

import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> variaveis = new HashMap<String, Integer>();
    String varAtual;
    Double result;

    public void executeAction(int action, Token token) throws SemanticError
    {
        Integer a, b;
        switch (action) {
            case 1: // Empilha numero
                stack.push(Integer.parseInt(token.getLexeme(), 2));
                break;
            case 2: // Empilha valor da variavel na pilha para ser usada por um calculo futuro
                stack.push(variaveis.get(token.getLexeme()));
                break;
            case 3: // Operacao de Log
                a = stack.pop();
                result = Math.log(a);
                stack.push(result.intValue());
                break;
            case 4: // Operacao de Exponenciacao
                b = stack.pop();
                a = stack.pop();
                result = Math.pow(a, b);
                stack.push(result.intValue());
                break;
            case 5: // Operacao Divisao
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
                break;
            case 6: // Multiplicacao
                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
                break;
            case 7: // Subtracao
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
                break;
            case 8: // Adicao
                b = stack.pop();
                a = stack.pop();
                stack.push(a + b);
                break;
            case 9: // Comando show (vai usar a varAtual capturada no Case 10 e imprimir seu valor)
                Integer var = variaveis.get(varAtual);
                System.out.println("Variavel " + varAtual + ": " + Integer.toBinaryString(var) + "\n");
                break;
            case 10: // Pegar o nome da variavel que vai receber um calculo ou ser exibida (Ex: a = 10, vai pegar o "a" e colocar em varAtual)
                varAtual = token.getLexeme();
                break;
            case 11: // Atribuicao do resultado do calculo na variavel que é capturada no Case 10
                variaveis.put(varAtual, stack.pop());
                break;
            default:
                break;
        }
    }
}
