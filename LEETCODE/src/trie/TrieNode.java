package trie;

//Implement Trie
public class TrieNode {
	public boolean hasWord;;
	public TrieNode[] children;
	
	public TrieNode() {
		hasWord = false;
		children = new TrieNode[26];
	}
	
	public void insertNode(String word, int index) {
		if(index == word.length()) {
			this.hasWord = true;
			return;
		}
		int pos = word.charAt(index) - 'a';
		if(this.children[pos] == null) {
			this.children[pos] = new TrieNode();
		}
		this.children[pos].insertNode(word, index+1);//传入root.children[pos]
	}
	
	public TrieNode searchNode(String word, int index) {
		if(index == word.length()) {
			return this;
		}
		int pos = word.charAt(index) - 'a';
		if(this.children[pos] == null) {
			return null;
		}
		TrieNode node = this.children[pos].searchNode(word, index+1);
		return node;
	}
	
}
