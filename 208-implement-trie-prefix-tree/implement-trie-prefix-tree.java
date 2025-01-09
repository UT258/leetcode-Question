class Trie {
    List<String> x;
    public Trie() {
        x=new ArrayList<String>();//initializing 
    }
    
    public void insert(String word) {
        x.add(word);//inserting a word 
    }
    
    public boolean search(String word) {
        return (x.contains(word)==true);//if it contains or not
    }
    
    public boolean startsWith(String prefix) {
        for(String y:x)
        {
            if(y.startsWith(prefix)==true)//checking each word on the list with the prefix
            {
                return true;
            }
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