package trabalho;

import java.util.Scanner;

/**
 * A primeira classe a ser executada no trabalho.
 *
 * @author Anderson Sprenger, Cassiano Flores
 */
public class Main {
    public static void main(String[] args) {
        DictionaryService service = new DictionaryService();

        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("Buscar no dicionario:");
            String in = scn.next();

            if (in.equals("0")) { // fechar app
                System.out.println("😁 app fechado.");
                return;
            }

            else if (in.equals("-1")) { // listar todas palavras na arvore
                service.printAll();
            }

            else { // 🧐 buscar...
                service.printWords(in);
            }
        }
    }
}
