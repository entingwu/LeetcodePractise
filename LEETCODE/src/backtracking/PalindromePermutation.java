package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class PalindromePermutation {

	public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        String halfStr = "", mid = "";
        for(int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (map.containsKey(ch)) {
        		map.put(ch, map.get(ch) + 1);
        	} else {
        		map.put(ch, 1);
        	}
        }
        for(Character key : map.keySet()) {
        	/* odd */
        	if (map.get(key) % 2 == 1) {
        		mid += key;	
        	}
        	/* odd & even */
        	for (int i = map.get(key) / 2; i > 0; i--) {
        		halfStr += key;
        	}
        	if (mid.length() > 1) { return result; }
        }
        /* Update map */
        for(Character key : map.keySet()) {
        	map.put(key, map.get(key) / 2);
        }
        permuteHelper(result, map, halfStr, mid, "");
        return result;
	}
	
	private void permuteHelper(List<String> result, Map<Character, Integer> map, String halfStr, String mid, String temp) {
		if (temp.length() == halfStr.length()) {
			String tempReverse = new StringBuilder(temp).reverse().toString();
			result.add(temp + mid + tempReverse);
			return;
		}
		for(Character key : map.keySet()) {
			if (map.get(key) > 0) {
				map.put(key, map.get(key) - 1);
				permuteHelper(result, map, halfStr, mid, temp + key);
				map.put(key, map.get(key) + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		PalindromePermutation pp = new PalindromePermutation();
		String s1 = "aabb";
		List<String> result = pp.generatePalindromes(s1);
		for(String str : result) {
			System.out.print(str + ",");
		}
		System.out.println();
	}

}
