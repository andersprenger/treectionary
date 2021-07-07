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

        System.out.println("Buscar no dicionario:");

        Scanner scn = new Scanner(System.in);
        service.printWords(scn.next());
    }
}
