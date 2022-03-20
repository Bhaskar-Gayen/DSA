package stringpack;

import java.util.Stack;

public class MainClass {
	
	/*LeetCode: 1963. Minimum Number of Swaps to Make the String Balanced
	 * Input: s = "][]["
	   Output: 1
	 */
	public int minSwaps(String s) {
		int open = 0;
		int close = 0;

		for (char c : s.toCharArray()) {
			if (c == '[')
				open++;
			else if (c == ']') {
				if (open > 0) // are there any open brackets before this ']'
					open--; // we found a pair for some previous '[' let's not consider that one anymore.
				else
					close++; // otherwise it's just another invalid closing bracket
			}
		}
		// find and return number of swaps required
		return (close + 1) / 2;
	}

	
	/* Check a string permutation present in a text or not 
	 * Input: s1 = "ab", s2 = "eidbaooo"
		Output: true
	 * */
	public boolean checkInclusion(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() > s2.length())
			return false;
		if (s2.indexOf(s1) >= 0)
			return true;
		// create frequency table
		int[] count1 = new int[26];
		int[] count2 = new int[26];
		int l1 = s1.length(), l2 = s2.length(), i = 0;
		for (; i < l1; i++) {
			count1[s1.charAt(i) - 'a']++;
			count2[s2.charAt(i) - 'a']++;
		}
		if (checkSubString(count1, count2))
			return true;
		for (; i < l2; i++) {
			char cur = s2.charAt(i);
			char pre = s2.charAt(i - l1);
			count2[cur - 'a']++;
			count2[pre - 'a']--;
			if (checkSubString(count1, count2))
				return true;
		}

		return false;
	}

	static boolean checkSubString(int count1[], int count2[]) {
		for (int i = 0; i < 26; i++)
			if (count1[i] != count2[i])
				return false;
		return true;
	}

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

	// get Maximum occurrence of character in a String
	static char getMaxChar(String s) {
		int freq[] = new int[26];
		int max = -1;
		char ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				if (c >= 'a' || c <= 'z')
					freq[c - 'a']++;
				else
					freq[c - 'A']++;

			}
		}

		for (int i = 0; i < 26; i++) {
			if (freq[i] > max) {
				max = freq[i];
				ans = (char) (i + 'a');
			}
		}
		return ans;
	}

}
