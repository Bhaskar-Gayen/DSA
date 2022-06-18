package trie;

import java.util.Arrays;

class TrieNode{
    char data;
    TrieNode[] children;
    int childCount;
    boolean isTerminal;
    TrieNode(char data){
        this.data=data;
        children=new TrieNode[26];
        Arrays.fill(children,null);
        childCount=0;
        isTerminal=false;
    }
}
class Trie{
    static TrieNode root;
    public Trie(){
        root=new TrieNode('\0');
    }
    
    public void insert(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminal=true;
            return;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = null;
        // present in trie
        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            // absent in trie
            root.children[index] = new TrieNode(word.charAt(0));
            root.childCount++;
            child = root.children[index];
        }
        // recursion
        insert(child, word.substring(1));
    }
    public String findPrefix(TrieNode root, StringBuilder str){
         if(root.isTerminal|| root.childCount>1){
            if(root.data!='\0')
            str.append(root.data);
            return str.toString();
        }
        if(root.data!='\0')
            str.append(root.data);
        for(int i=0;i<26;i++){
            if(root.children[i]!=null)
               return findPrefix(root.children[i], str);
        }
        return str.toString();
    }
    
}

public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] arr, int n) {
		Trie trie=new Trie();
        for(int i=0;i<n;i++){
            trie.insert(Trie.root,arr[i]);
        }
        StringBuilder str=new StringBuilder();
         return trie.findPrefix(Trie.root, str);
	}

}

