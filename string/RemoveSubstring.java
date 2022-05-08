package string;

import java.util.Stack;

public class RemoveSubstring {
	
	/* Remove occurrence of substring from a String */
	public String removeOccurrences(String s, String part) {
		StringBuilder ans = new StringBuilder();
		Stack<Character> st = new Stack<>();
		int n = part.length();
		for (char c : s.toCharArray()) {
			st.push(c);
			if (st.size() >= n) {
				if (check(st, part)) {
					int n2 = n;
					while (n2-- != 0)
						st.pop();
				}
			}
		}

		while (!st.isEmpty())
			ans.append(st.pop());
		ans.reverse();
		return ans.toString();
	}

	/* Stack to check character by character in reverse order */
	static boolean check(Stack<Character> st, String part) {
		Stack<Character> temp = new Stack<Character>();
		int j = part.length() - 1;
		temp.addAll(st);
		while (j >= 0 && temp.peek() == part.charAt(j)) {
			temp.pop();
			j--;
		}
		return j == -1;
	}


}
