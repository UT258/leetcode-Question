class WordDictionary {
    class Node {
        Node link[] = new Node[26];
        boolean isEnd;

        boolean containsKey(char ch)
        {
            return link[ch-'a']!=null;
        }

        public void  put(char ch ,Node node )
        {
            link[ch-'a']=node;//go to refrence trie
        }
        public Node get(char ch)
        {
            return link[ch-'a'];
            
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

    }

    Node root;

    public WordDictionary() {
        root = new Node();

    }

    public void addWord(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Node());
            }
            // move to the next nod
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return searchInNode(word, root);

    }
    private boolean searchInNode(String word, Node node) {
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        if (ch == '.') {
            // Try all possible children nodes
            for (Node child : node.link) {
                if (child != null && searchInNode(word.substring(i + 1), child)) {
                    return true;
                }
            }
            return false; // No valid path found
        } else {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
    }
    return node.isEnd();
}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */