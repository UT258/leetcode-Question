class Solution {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int prefixCount = 0;

        public boolean contains(char ch) {
            return children.containsKey(ch);
        }

        public void put(char ch, TrieNode node) {
            children.put(ch, node);
        }

        public TrieNode get(char ch) {
            return children.get(ch);
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (!node.contains(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
                node.prefixCount++; // Increment prefix count at each node
            }
        }

        // Count words with a given prefix
        public int countWordsWithPrefix(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (!node.contains(ch)) {
                    return 0; // Prefix not found
                }
                node = node.get(ch);
            }
            return node.prefixCount; // Return the count of words with this prefix
        }
    }

    public int prefixCount(String[] words, String pref) {
        // Initialize Trie
        Trie trie = new Trie();

        // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }

        // Return the count of words with the given prefix
        return trie.countWordsWithPrefix(pref);
    }
}
