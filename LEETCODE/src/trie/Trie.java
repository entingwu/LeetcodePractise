package trie;

//TrieNode class

public class Trie {
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	/* Insert a word into the trie */
	public void insert(String word) {
		root.insertNode(word, 0);
	}
	
	/* Return if the word is in the trie */
	public boolean search(String word) {
		TrieNode node = root.searchNode(word,0);
		return node!=null && node.hasWord;
	}
	
	/* Return if there is any word in the trie that starts with the given prefix */
	public boolean startsWith(String prefix) {
		TrieNode node = root.searchNode(prefix, 0);
		return node!=null;
	}
	
	public static void main(String[] args) {
		

	}

}
