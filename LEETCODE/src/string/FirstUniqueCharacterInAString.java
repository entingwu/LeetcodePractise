package string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
        int[] freq = new int[26];//index for character, value for frequency
        for(int i = 0; i < s.length(); i++) {
        	freq[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
        	if(freq[s.charAt(i) - 'a'] == 1) {
        		return i;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		String s = "loveleetcode";
		FirstUniqueCharacterInAString fucs = new FirstUniqueCharacterInAString();
		System.out.println(fucs.firstUniqChar(s));
	}

}
