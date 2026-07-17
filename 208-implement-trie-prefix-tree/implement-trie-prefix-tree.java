class Trie {
    // Array to store links to child nodes, each index represents a letter
    Trie[] links = new Trie[26];
    // Flag indicating if this node marks the end of a word
    boolean flag = false;

    // Check if the node contains a specific key (letter)
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    // Insert a new node with a specific key (letter)
    void put(char ch, Trie node) {
        links[ch - 'a'] = node;
    }

    // Get the child node with a specific key (letter)
    Trie get(char ch) {
        return links[ch - 'a'];
    }

    // Mark the current node as the end of a word
    void setEnd() {
        flag = true;
    }

    // Check if the current node marks the end of a word
    boolean isEnd() {
        return flag;
    }

    // Constructor — initializes an empty Trie node (used as root too)
    public Trie() {
        
    }

    // Inserts a word into the Trie
    public void insert(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                node.put(ch, new Trie());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    // Returns true if the exact word exists in the Trie
    public boolean search(String word) {
        Trie node = this;
        for (char ch : word.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    // Returns true if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char ch : prefix.toCharArray()) {
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */