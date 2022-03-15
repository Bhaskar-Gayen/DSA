package stack;

import java.util.Stack;

public class MainClass {
	
	public static void main(String str[]) {
		System.out.println(removeOccurrences("axxxxyyyyb", "xy"));		
		
	}
	
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

}
