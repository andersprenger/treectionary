package trabalho;

public class WordTree {

    // Atributos
    private CharNode root;
    private final int totalNodes = 0;
    private final int totalWords = 0;

    // Construtor
    public WordTree() {
      // TODO: implement code
    }

    public int getTotalWords() {
        // TODO: implement code
        return -1;
    }

    public int getTotalNodes() {
        // TODO: implement code
        return -1;
    }

    /**
     * Adiciona palavra na estrutura em árvore
     *
     * @param word
     */
    public void addWord(String word) {
        // TODO: implement code
    }

    /**
     * Vai descendo na árvore até onde conseguir encontrar a palavra
     *
     * @param word
     * @return o nodo final encontrado
     */
    private CharNode findCharNodeForWord(String word) {
        // TODO: implement code
        return null;
    }

    /**
     * Percorre a árvore e retorna uma lista com as palavras iniciadas pelo prefixo dado.
     * Tipicamente, um método recursivo.
     *
     * @param prefix
     */
    public MyList<String> searchAll(String prefix) {
        // TODO: implement code
        return null;
    }

    private class CharNode {
        private char character;
        private Word word;
        private CharNode parent;
        private MyList<CharNode> children;

        public CharNode(char character, CharNode parent) {
            this.character = character;
            this.parent = parent;
            this.word = null;
            // TODO: implement code
            // this.children = new MyList();
        }

        public CharNode(char character, Word word, CharNode parent) {
            this.character = character;
            this.parent = parent;
            this.word = word;
            // this.children = new MyList();
        }

        /**
         * Adiciona um filho (caractere) no nodo. Não pode aceitar caracteres repetidos.
         *
         * @param character caractere a ser adicionado
         */
        public CharNode addChild(char character) {
            CharNode child = new CharNode(character, this);
            // TODO: implement code
            // children.add();
            return child;
        }

        /**
         * Adiciona um filho (caractere) no nodo. Não pode aceitar caracteres repetidos.
         *
         * @param character caractere a ser adicionado.
         * @param word a palavra cujo nodo se refere, caso exista.
         */
        public CharNode addChild(char character, Word word) {
            CharNode child = new CharNode(character, word, this);
            // TODO: implement code
            // children.add();
            return child;
        }

        public int getNumberOfChildren() {
            // TODO: implement code
            // return children.size();
            return -1;
        }

        public CharNode getChild(int index) {
            // TODO: implement code
            // return children.get(i);
            return null;
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
            // TODO: implement code
            return null;
        }
    }
}
