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
     * @param wordString String da palavra a ser adicionada no dicionario.
     * @param meaning significado da palavra a ser adicionada.
     */
    public void addWord(String wordString, String meaning) {
        Word word = new Word(wordString, meaning);

        // TODO: acho q funciona... tem q testar...
        CharNode aux = root;
        for (int i = 0; i < wordString.length(); i++) {
            // verifica se o nodo aux possui um filho cuja letra é igual a da posição na palavra
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
                aux.word = word;
                this.totalWords++;
            }
        }
    }

    /**
     * Vai descendo na árvore até onde conseguir encontrar a palavra
     *
     * @param word palavra a ser buscada
     * @return o nodo final encontrado
     */
    private CharNode findCharNodeForWord(String word) {
        CharNode aux = root;
        for (int i = 0; i < word.length(); i++) {
            CharNode charAtIndex = aux.findChildByChar(word.charAt(i));
            // se não encontrou o nodo, a arvore não tem a palavra...
            if (charAtIndex == null) {
                break;
            }
            // se encontrou o nodo, e i for length - 1, aux é o nodo da palavra...
            else if (i == word.length() - 1) {
                return charAtIndex;
            }
            // caso contrario, o for continua...
            else {
                aux = charAtIndex;
            }
        }

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

        public int getNumberOfChildren() {
            return subTrees.size();
        }

        public CharNode getChild(int index) {
            if (index < 0 || index >= getNumberOfChildren()) {
                throw new IndexOutOfBoundsException();
            }

            return subTrees.get(index);
        }

        public boolean setWord(Word word) {
            if (this.word != null) {
                return false;
            } else {
                this.word = word;
                return true;
            }
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
