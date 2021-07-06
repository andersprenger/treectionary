package trabalho;

public class WordTree {
    private CharNode root;
    private int totalNodes;
    private int totalWords;

    // Construtor
    public WordTree() {
      this.root = new CharNode(null, null);
      this.totalNodes = 0;
      this.totalWords = 0;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getTotalNodes() {
        return totalNodes;
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
     * @param word palavra a ser buscada
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
     * @param prefix prefixo a ser buscado
     */
    public MyList<String> searchAll(String prefix) {
        // TODO: implement code
        return null;
    }

    private class CharNode {
        private Character character;
        private Word word;
        private CharNode parent;
        private MyList<CharNode> subTrees;

        public CharNode(Character character, CharNode parent) {
            this.character = character;
            this.parent = parent;
            this.word = null;
            this.subTrees = new MyList();
        }

        public CharNode(Character character, Word word, CharNode parent) {
            this.character = character;
            this.parent = parent;
            this.word = word;
            this.subTrees = new MyList();
        }

        /**
         * Adiciona um filho (caractere) no nodo. Não pode aceitar caracteres repetidos.
         *
         * @param character caractere a ser adicionado
         */
        public CharNode addChild(char character) {
            CharNode child = new CharNode(character, this);
            subTrees.add(child);
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
            subTrees.add(child);
            return child;
        }

        public int getNumberOfChildren() {
            return subTrees.size();
        }

        public CharNode getChild(int index) {
            if (index < 0 || index >= getNumberOfChildren()) {
                throw new IndexOutOfBoundsException();
            }

            return subTrees.get(index);
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
