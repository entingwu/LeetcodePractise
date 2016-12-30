package trie;

//class Trie
//public boolean hasWord;;
//private TrieNode[] children;//26

public class WordDictionary {
	private TrieNode root;
	public WordDictionary() {
		root = new TrieNode();
	}

	// Adds a word into the data structure.
    public void addWord(String word) {
    	TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
        	int index = word.charAt(i) - 'a';
        	if(curr.children[index] == null) {
        		curr.children[index] = new TrieNode();
        	}
        	curr = curr.children[index];//loop
        }
        curr.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return dfs(root, word, 0);
    }
    
    private boolean dfs(TrieNode node, String word, int pos) {
    	if(node == null || (pos == word.length() && node.hasWord == false)) {
    		return false;
    	}
    	if(pos == word.length() && node.hasWord) {
    		return true;
    	}
    	if(word.charAt(pos) == '.') {
    		for(int i = 0; i < 26; i++) {
    			boolean result = dfs(node.children[i], word, pos+1);
    			if(result) { return true; }
    		}
    		return false;
    	}else {
    		int index = word.charAt(pos) - 'a';
        	return dfs(node.children[index], word, pos+1);
    	}
    }
    
	public static void main(String[] args) {
		// Your WordDictionary object will be instantiated and called as such:
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("word");
		System.out.println(wordDictionary.search("pattern"));

	}

}
