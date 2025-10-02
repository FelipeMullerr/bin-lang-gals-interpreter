package Main;

import Gals.*;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException{
        try
        {
            //Lexico lexico = new Lexico("A = 10; B = 11; C = A * B; D = B / A; show(C); show(D);");
            //Lexico lexico = new Lexico("A=(100+11*11)^11;B=A;show(B);");
            Lexico lexico = new Lexico("A = log(1010);show(A);");

            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
        catch ( LexicalError | SyntacticError | SemanticError e )
        {
            System.out.println("Comando não identificado.");
        }
    }
}
