package string;

/** Check a string permutation present in a text or not 
 * Input: s1 = "ab", s2 = "eidbaooo"
	Output: true
 * */

public class StringPermutationCheck {
	
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

}
