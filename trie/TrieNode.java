package trie;

import java.util.Arrays;

public class TrieNode{
    char data;
    TrieNode[] children;
    boolean isTerminal;
    TrieNode(char data){
        this.data=data;
        children=new TrieNode[26];
        Arrays.fill(children,null);
        isTerminal=false;
    }
}
