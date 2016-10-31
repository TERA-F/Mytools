class TrieNode {
    TrieNode[] list = new TrieNode[26];
    boolean[] haslist = new boolean[26];
    public TrieNode() {
        
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null || word.length()==0)return;
        TrieNode tmp = root;
        for(int i = 0 ; i < word.length(); i++){
            int loc = word.charAt(i)-'a';
            if(tmp.list[loc]==null)
                tmp.list[loc] = new TrieNode();
            if(i==word.length()-1){
                tmp.haslist[loc] = true;
            }
            tmp = tmp.list[loc];
            
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word==null || word.length()==0)return true;
        TrieNode tmp = root;
        for(int i = 0 ; i < word.length(); i++){
            int loc = word.charAt(i)-'a';
            if(tmp.list[loc]==null)
                return false;
            if(i==word.length()-1){
                return tmp.haslist[loc];
            }
            tmp = tmp.list[loc];
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix==null || prefix.length()==0)return true;
        TrieNode tmp = root;
        for(int i = 0 ; i < prefix.length(); i++){
            int loc = prefix.charAt(i)-'a';
            if(tmp.list[loc]==null)
                return false;
            tmp = tmp.list[loc];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
