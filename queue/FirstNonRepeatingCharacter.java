package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * GFG: First non-repeating character in a stream Input: A = "aabc" Output:"a#bb"
 */

public class FirstNonRepeatingCharacter {

	public String FirstNonRepeating(String A) {
		int[] count = new int[26];
		Queue<Character> q = new LinkedList<>();
		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			count[c - 'a']++;
			q.add(c);
			while (!q.isEmpty()) {
				if (count[q.peek() - 'a'] > 1)
					q.remove();
				else {
					ans.append(q.peek());
					break;
				}

			}
			if (q.isEmpty())
				ans.append('#');
		}
		return ans.toString();
	}

}
