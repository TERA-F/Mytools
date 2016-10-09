public class WordDictionary {

    private class Node{
        boolean isword;
        Node[] next = new Node[26];
    }
    
    private Node root = new Node();
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        Node p = root;
        for(char c : word.toCharArray()){
            int id = c - 'a';
            if(p.next[id] == null)
                p.next[id] = new Node();
            p = p.next[id];
        }
        p.isword = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word,0,root);
    }
    
    private boolean helper(String word, int id, Node n){
        if(n == null) return false;
        if(id == word.length()) return n.isword;
        
        char c = word.charAt(id);
        if(c=='.'){
            for(Node rep: n.next)
                if(helper(word,id+1,rep))
                    return true;
            return false;
        }
        return helper(word,id+1,n.next[c-'a']);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
