class Trie {
    List<String> words;
    public Trie() {
        this.words = new ArrayList<>();        
    }
    
    public void insert(String word) {
        words.add(word);
    }
    
    public boolean search(String word) {
        if (words.contains(word))
            return true;
        else
            return false;    
    }
    
    public boolean startsWith(String prefix) {
        for (String a:words) {
            if (a.startsWith(prefix))
                return true;
        }
        return false;    
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */