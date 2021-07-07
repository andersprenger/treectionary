package trabalho;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Armazena e interage com a estrutura de dados, lidando com a entrada e saida de dados.
 *
 * @author Anderson Sprenger, Cassiano Flores
 */
public class DictionaryService {
    private WordTree dictionary;

    public DictionaryService() {
        this.dictionary = new WordTree();
        this.load();
    }

    public void printAll() {
        dictionary.printAll();
    }

    public void printWords(String str) {
        if (str.length() < 2) {
            System.out.println("Favor digitar mais de 2 caracteres.");
            return;
        }

        MyList<Word> search = dictionary.searchAll(str);
        for (int i = 0; i < search.size(); i++) {
            if (i == 0) {
                System.out.println(search.get(i));
                System.out.println("Outros resultados:");
            } else {
                System.out.println(search.get(i).getWord());
            }
        }
        System.out.println(); // nova linha
    }

    private void load() {
        String fileName = "dicionario.csv";
        Path path = Path.of(fileName).toAbsolutePath();
        try (Scanner sc = new Scanner(Files.newBufferedReader(path, StandardCharsets.UTF_8))) {

            while (sc.hasNext()) {
                String[] wordRaw = sc.nextLine().split(";");
                dictionary.addWord(wordRaw[0], wordRaw[1]);
            }

        } catch (IOException e) {
            System.err.format("Erro de E/S: %s%n", e);
        }
    }
}
