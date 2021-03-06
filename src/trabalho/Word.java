package trabalho;

/**
 * Representação de uma palavra do dicionario e seu significado.
 *
 * @author Anderson Sprenger, Cassiano Flores
 */

public class Word {
    private String word;
    private String meaning;

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return "Palavra: " + word + "\nSignificado: " + meaning + '\n';
    }
}
