package string;

/**
 * LeetCode: 392. Is Subsequence Input: s = "abc", t = "ahbgdc" Output: true
 * Input: s = "axc", t = "ahbgdc" Output: false
 */

public class CheckSubsequence {

	public boolean isSubsequence(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		if (slen > tlen)
			return false;
		int ptr = -1;
		for (int i = 0; i < slen; i++) {
			ptr++;
			for (; ptr < tlen; ptr++) {
				if (t.charAt(ptr) == s.charAt(i))
					break;
			}
			if (ptr >= tlen)
				return false;
		}
		return true;
	}

}
