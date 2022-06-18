package trie;

/**
 * Codeing Ninja: Implement Trie 
 * Difficulty: HARD 
 * Implement Trie Data Structure
 * to support these operations: 
 * insert(word) - To insert a string "word" in Trie
 * search(word) - To check if string "word" is present in Trie or not.
 * startsWith(word) - To check if there is any string in the Trie that starts
 * with the given prefix string "word".
 */

public class Trie {

	static TrieNode root;

	Trie() {
		root = new TrieNode('\0');
	}

	static void insertUtil(TrieNode root, String word) {
		if (word.length() == 0) {
			root.isTerminal = true;
			return;
		}

		int index = word.toUpperCase().charAt(0) - 'A';
		TrieNode child = null;
		// present in trie
		if (root.children[index] != null) {
			child = root.children[index];
		} else {
			// absent in trie
			root.children[index] = new TrieNode(word.charAt(0));
			child = root.children[index];
		}

		// recursion
		insertUtil(child, word.substring(1));
	}

	// Inserts a word into the trie

	public static void insert(String word) {
		insertUtil(root, word);
	}

	static boolean searchUtil(TrieNode root, String word) {
		if (word.length() == 0)
			return root.isTerminal;
		int index = word.toUpperCase().charAt(0) - 'A';
		TrieNode child = null;
		// present in trie
		if (root.children[index] != null)
			child = root.children[index];
		else
			return false;
		return searchUtil(child, word.substring(1));
	}

	// Returns if the word is in the trie
	public static boolean search(String word) {
		return searchUtil(root, word);
	}

	static boolean prefixCheck(TrieNode root, String word) {
		if (word.length() == 0)
			return true;
		int index = word.toUpperCase().charAt(0) - 'A';
		TrieNode next;
		if (root.children[index] != null)
			next = root.children[index];
		else
			return false;
		return prefixCheck(next, word.substring(1));
	}

	// Returns if there is any word in the trie that starts with the given prefix

	public static boolean startsWith(String prefix) {
		return prefixCheck(root, prefix);
	}
	
	//Delete a Node from Trie
	
	public static void deleteNode(TrieNode root, String word) {
		if(word.length()==0) {
			root.isTerminal=false;
			return;
		}
		int index=word.toUpperCase().charAt(0);
		TrieNode nextPtr;
		if(root.children[index]!=null)
			nextPtr=root.children[index];
		else
			return;
		deleteNode(nextPtr,word.substring(1));
	}

}
