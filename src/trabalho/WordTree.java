package trabalho;

/**
 * Implementação customizada de do TAD Arvore Genérica para o trabalho.
 *
 * @author Anderson Sprenger, Cassiano Flores
 */
public class WordTree {
    private final CharNode root;
    private int totalNodes;
    private int totalWords;

    /** Construtor da classe WordTree */
    public WordTree() {
      this.root = new CharNode(null, null);
      this.totalNodes = 0;
      this.totalWords = 0;
    }

    /**
     * @return o numero total de palavas na arvore.
     */
    public int getTotalWords() {
        return totalWords;
    }

    /**
     * @return o numero total de nodos na arvore.
     */
    public int getTotalNodes() {
        return totalNodes;
    }

    /**
     * Adiciona palavra na árvore.
     *
     * @param wordString palavra a ser adicionada no dicionario.
     * @param meaning significado da palavra a ser adicionada.
     */
    public void addWord(String wordString, String meaning) {

        wordString = wordString.toUpperCase();

        Word word = new Word(wordString, meaning);

        CharNode aux = root;

        for (int i = 0; i < wordString.length(); i++) {
            // verifica se o char é mesmo uma letra
            if (!isCompatibleChar(wordString.charAt(i))) {
                continue; // nesse caso, ele ignora essa letra.
            }
            // então, ele verifica se o nodo aux possui um filho cuja letra é igual a da posição na palavra
            CharNode tmp = aux.findChildByChar(wordString.charAt(i));
            // se não possui ele cria uma e coloca como filho no nodo
            if (tmp == null) {
                tmp = new CharNode(wordString.charAt(i), aux);
                this.totalNodes++;
            }
            // depois, aux recebe tmp...
            aux = tmp;
            // rotina a ser feita caso seja a ultima letra da palavra...
            if (i == wordString.length() - 1) {
                if (aux.word != null) {
                    return;
                } else {
                    aux.setWord(word);
                    this.totalWords++;
                }
            }
        }
    }

    /**
     * Vai descendo na árvore até onde conseguir encontrar a palavra.
     *
     * @param word palavra a ser buscada.
     * @return o nodo final encontrado.
     */
    public CharNode findCharNodeForWord(String word) {
        word = word.toUpperCase();
        CharNode aux = root;
        for (int i = 0; i < word.length(); i++) {
            CharNode charNodeAtIndex = aux.findChildByChar(word.charAt(i));
            // se não encontrou o nodo, a arvore não tem a palavra...
            if (charNodeAtIndex == null) {
                break;
            }
            // se encontrou o nodo, e i for length - 1, aux é o nodo da palavra...
            else if (i == word.length() - 1) {
                return charNodeAtIndex;
            }
            // caso contrario, o for continua...
            else {
                aux = charNodeAtIndex;
            }
        }

        return null;
    }

    /**
     * Percorre a árvore e retorna uma lista com as palavras iniciadas pelo prefixo dado.
     * Tipicamente, um método recursivo.
     *
     * @param prefix prefixo a ser buscado.
     */
    public MyList<Word> searchAll(String prefix) {

        prefix = prefix.toUpperCase();

        MyList<Word> list = new MyList<>();

        CharNode aux = findCharNodeForWord(prefix);

        if (aux == null) {
            return list;
        }

        positionsPreAux(aux, list);

        return list;
    }

    /**
     * Percorre toda a arvore e printa todas as palavras. Usado para fins de teste.
     */
    public void printAll() {
        MyList<Word> l = new MyList<>();
        positionsPreAux(root, l);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    /**
     * Percorre recursivamente a arvore, adicionando todas palavras encontradas.
     *
     * @param node o nodo a ser percorrido.
     * @param lista onde serão adicionadas as palavras encontradas.
     */
    private void positionsPreAux(CharNode node, MyList<Word> lista) {
        if (node != null) {
            if (node.word != null) {
                lista.add(node.word);
            }

            for (int i = 0; i < node.subTrees.size(); i++) {
                positionsPreAux(node.getChild(i), lista);
            }
        }
    }

    /**
     * Verifica se o caractere é uma letra, sendo então possível criar um CharNode com ela como character.
     *
     * @param c caractere que sera verificada a compatibilidade.
     * @return true se o caractere é compatível, ou false caso contrario.
     * @requires JDK 13 (ou mais recente)
     */
    private boolean isCompatibleChar(char c) {
        return switch (c) {
            case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
                 'u', 'v', 'w', 'x', 'y', 'z',
                 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                 'U', 'V', 'W', 'X', 'Y', 'Z' -> true;
            default -> false;
        };
    }

    /**
     * Classe referente ao no da arvore de palavras.
     */
    private class CharNode {
        private final Character character;
        private Word word;
        private final CharNode parent;
        private final MyList<CharNode> subTrees;

        public CharNode(Character character, CharNode parent) {
            if (parent != null && !isCompatibleChar(character)) { // não é root, e não tem um char compatível...
                throw new RuntimeException("Char invalido: " + character);
            } else {
                this.character = character;
                this.parent = parent;
                this.word = null;
                this.subTrees = new MyList<>();
            }

            if (parent != null) { // se não for root...
                parent.addChild(this);
            }
        }

        private void addChild(CharNode n) {
            subTrees.add(n);
        }

        /**
         * @return o numero de filhos do nodo.
         */
        public int getNumberOfChildren() {
            return subTrees.size();
        }

        /**
         * Obtém a sub arvore correspondente a posição no parametrizada.
         *
         * @param index da sub arvore
         * @return o nodo na posição indicada.
         * @throws IndexOutOfBoundsException quando index for invalido (por MyList).
         */
        public CharNode getChild(int index) throws IndexOutOfBoundsException {
            return subTrees.get(index);
        }

        public void setWord(Word word) {
            this.word = word;
        }

        /**
         * Obtém a palavra correspondente a este nodo.
         *
         * @return a palavra
         */
        private Word getWord() {
            return word;
        }

        /**
         * Encontra e retorna o nodo que tem determinado caractere.
         *
         * @param character - caractere a ser encontrado.
         */
        public CharNode findChildByChar(char character) {
            for (int i = 0; i < subTrees.size(); i++) {
                CharNode node = subTrees.get(i);

                if (node.character.equals(character)) {
                    return node;
                }
            }

            return null;
        }
    }
}
