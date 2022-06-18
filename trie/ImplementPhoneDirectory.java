package trie;


/**
 * CodingNinja: Implement a phone directory
 * Difficulty: HARD
 * Input: 
 * 5
 * cod coding codding code coly
 * coding
 * Output: 
 * cod coding codding code coly
 * cod coding codding code coly
 * cod coding codding code 
 * coding
 * coding
 * coding
*/


import java.util.ArrayList;

class Trie {

    static TrieNode root;

    Trie() {
        root = new TrieNode('\0');
    }

    public void insertUtil(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
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
            child = root.children[index];
        }

        // recursion
        insertUtil(child, word.substring(1));
    }
    
    public ArrayList<ArrayList<String>> getSuggestions(String query){
        TrieNode prev=root, curr=null;
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        StringBuilder prefix=new StringBuilder();
        for(char c: query.toCharArray()){
            prefix.append(c);
            curr=prev.children[c-'a'];
            //not found
            if(curr==null)
                break;
            //found
            ArrayList<String> temp=new ArrayList<>();
            findSuggestion(curr,temp, prefix);
            ans.add(temp);
            prev=curr;
        }
        
        return ans;
    }
    
    public void findSuggestion(TrieNode curr, ArrayList<String> temp, StringBuilder prefix){
        if(curr.isTerminal)
            temp.add(prefix.toString());
        for(char ch='a';ch<='z';ch++){
            if(curr.children[ch-'a']!=null){
                prefix.append(curr.children[ch-'a'].data);
                findSuggestion(curr.children[ch-'a'],temp,prefix);
                prefix.deleteCharAt(prefix.length()-1);
            }
        }
    }
}

public class ImplementPhoneDirectory {
	
	public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr)
    {
        //create Trie
        Trie trie=new Trie();
        
        //insert contact list
        for(String s: contactList){
            trie.insertUtil(Trie.root, s);
        }
        
        //return answer
        return trie.getSuggestions(queryStr);
    }

}
