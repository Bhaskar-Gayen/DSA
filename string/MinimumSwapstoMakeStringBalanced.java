package string;

/**LeetCode: 1963. Minimum Number of Swaps to Make the String Balanced
 * Input: s = "][]["
   Output: 1
 */

public class MinimumSwapstoMakeStringBalanced {

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


}
