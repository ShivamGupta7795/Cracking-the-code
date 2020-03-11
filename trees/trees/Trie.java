package trees;

public class Trie {

	/*
	 * 	Trie trie = new Trie();
		trie.insert("apple");
		trie.search("apple");   // returns true
		trie.search("app");     // returns false
		trie.startsWith("app"); // returns true
		trie.insert("app");   
		trie.search("app");     // returns true
*/
    /** Initialize your data structure here. */
   
    trieNode root;
    public Trie() {
        root = new trieNode();
    }
    
   
    /** Inserts a word into the trie. */
    public void insert(String word) {
        trieNode node= root;
        
        for(int i=0;i<word.length();i++){
            if(node.strings[word.charAt(i)-'a'] == null)
                node.strings[word.charAt(i)-'a'] = new trieNode();
            node = node.strings[word.charAt(i)-'a'];
        }
        node.isWord = true;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        trieNode node = root;
        
        for(int i=0;i<word.length();i++){
            if(node.strings[word.charAt(i)-'a']==null)
                return false;
            node = node.strings[word.charAt(i)-'a'];
        }
        return node.isWord;
    }
    
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        trieNode node = root;
        for(int i=0;i<prefix.length();i++){
            if(node.strings[prefix.charAt(i)-'a']==null)
                return false;
            node = node.strings[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

class trieNode{
    boolean isWord;
    trieNode[] strings;
    public trieNode(){
        strings = new trieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
