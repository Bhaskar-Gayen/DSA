package string;

public class MaximumCharacter {
	
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
