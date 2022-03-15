package stringPackge;

import java.util.Stack;

public class MainClass {
	
	/*Remove occurrence of substring from a String */
	static String removeOccurrences(String s, String part) {
		StringBuilder ans = new StringBuilder();
		Stack<Character> st = new Stack<>();
		int n = part.length();
		for(char c: s.toCharArray()) {
			st.push(c);
			if(st.size()>=n) {
				if(check(st,part)) {
					int n2=n;
					while(n2--!=0)
						st.pop();
				}
			}
		}
		
		while(!st.isEmpty()) 
			ans.append(st.pop());
		ans.reverse();
		return ans.toString();
	}
	/* Stack to check character by character in reverse order */
	static boolean check(Stack<Character> st, String part) {
		Stack<Character> temp = new Stack<Character>();
		int j = part.length()-1;
		temp.addAll(st);
		while(j>=0 && temp.peek()==part.charAt(j)) {
			temp.pop();
			j--;
		}
		return j==-1;
	}
	
	//get Maximum occurrence of character in a String
		static char getMaxChar(String s){
		    int freq[] = new int[26];
		    int max =-1;
		    char ans=0;
		    for(int i=0;i<s.length();i++){
		        char c = s.charAt(i);
		        if(c!=' '){
		            if(c>='a'||c<='z')
		                freq[c-'a']++;
		            else
		                freq[c-'A']++;
		                
		        }
		    }
		    
		    for(int i=0;i<26;i++){
		        if(freq[i]>max){
		            max=freq[i];
		            ans = (char)(i +'a');
		        }
		    }
		    return ans;
		}

}
