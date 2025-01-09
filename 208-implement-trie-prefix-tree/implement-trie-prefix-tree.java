class Trie {
    class Node{
        Node link[]=new Node[26];
        boolean flag;
        public void put(char ch,Node node)
        {
            link[ch-'a']=node;
            //put the element and point to refrence trie
        }
        public boolean isEnd()
        {
            return flag;
        }
        public Node get(char ch)
        {
            return link[ch-'a'];
        }
        public boolean contains(char ch)
        {
            return link[ch-'a']!=null;
        }
        public void setEnd()
        {
            flag=true;
        }
    }
    Node root;
     
    public Trie() {
        root=new Node();//intialize the root
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i)))
            {
                //means it does not contain create a new one
                node.put(word.charAt(i),new Node());
            }
            //move to the refrence trie
            node=node.get(word.charAt(i));
        }
        //if we are at the end of the striing set the end of this current 
        //reference trie to true
        node.setEnd();
    }
    
    public boolean search(String word) {
        //now to search go to each of the char by character
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            if(!node.contains(word.charAt(i)))
            {
                return false;
            }
            //move to the next ref trie
            node=node.get(word.charAt(i));

        }
        //now check if you finished the word or not 
        //if you are the end of the word if this is the end word
        //then only we considered true
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node =root;
        for(int i=0;i<prefix.length();i++)
        {
            if(!node.contains(prefix.charAt(i)))
            {
                return false;
            }
            node=node.get(prefix.charAt(i));
        }
        return true;//if you are at the end then word can 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */