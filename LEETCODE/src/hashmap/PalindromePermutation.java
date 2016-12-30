package hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PalindromePermutation {

	/* Palindrome Permutation I */
	
	public boolean canPermutePalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		int oddNum = 0;
		for(int freq : map.values()) {
			if(freq % 2 == 1) {
				oddNum++;
			}
		}
		return oddNum <= 1 ;//oddNum <= 1, it is palindrome. 
    }
	
	/* Palindrome Permutation II */
	
	class ResultType {
		List<Character> evenKey = new ArrayList<>();
		List<Character> oddKey = new ArrayList<>();
		ResultType(List<Character> oddKey, List<Character> evenKey) {
			this.oddKey = oddKey;
			this.evenKey = evenKey;
		}
	} 
	
	public List<String> generatePalindromes(String s) {
        List<String> palindromes = new ArrayList<>();
        ResultType permuteResult = getKeyQuantity(s);
        List<Character> evenKey = permuteResult.evenKey;
        List<Character> oddKey = permuteResult.oddKey;
		List<List<Character>> halfPalindromeChar = permutation(evenKey);
		if (oddKey.size() > 1) {// is not palindrome
        	return palindromes;
        }
		if (evenKey.size() == 0) {
        	palindromes.add(s);
        	return palindromes;
        }
		
		List<String> palindromeStr = new ArrayList<>();
		for(List<Character> list : halfPalindromeChar) {
			String front = getString(list);
			String back = reverseStr(front);
			if(oddKey.size() == 0) {
				palindromeStr.add(front + back);
			} else {
				palindromeStr.add(front + oddKey.get(0) + back);
			}
		}
		return palindromeStr;
    }
	
	private String reverseStr(String org) {
		char[] strs = org.toCharArray();
		int i = 0, j = org.length() - 1;
		while(i < j) {
			char tmp = strs[i];
			strs[i] = strs[j];
			strs[j] = tmp;
			i++;
			j--;
		}
		return new String(strs);
	}
	
	private String getString(List<Character> list) {
		StringBuilder sb = new StringBuilder(list.size());
		for(Character ch : list) {
			sb.append(ch);
		}
		return sb.toString();
	}
	
	private List<List<Character>> permutation(List<Character> chars) {
		List<List<Character>> result = new ArrayList<List<Character>>();
		List<Character> temp = new ArrayList<>();
		Collections.sort(chars);
		boolean[] used = new boolean[chars.size()];
		permuteHelper(result, temp, chars, used);
		return result;
	}
	private void permuteHelper(List<List<Character>> result, List<Character> temp, List<Character> chars, boolean[] used) {
		if (temp.size() == chars.size()) {
			result.add(new ArrayList<Character>(temp));
			return;
		}
		for(int i = 0; i < chars.size(); i++) {
			if(used[i] == true || i != 0 && chars.get(i) == chars.get(i - 1) && used[i - 1] == false) { 
				continue; 
			}
			char ch = chars.get(i);
			if (temp.contains(ch)) {
				continue;
			}
			temp.add(ch);
			used[i] = true;
			permuteHelper(result, temp, chars, used);
			temp.remove(temp.size() - 1);
			used[i] = false;
		}
	}
	
	private ResultType getKeyQuantity(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!map.containsKey(ch)) {
				map.put(ch, 1);
			} else {
				map.put(ch, map.get(ch) + 1);
			}
		}
		int oddNum = 0;
		List<Character> oddKey = new ArrayList<>();
		List<Character> evenKey = new ArrayList<>();
		for(char ch : map.keySet()) {
			if(map.get(ch) % 2 == 1) {
				oddKey.add(ch);
			} else {
				evenKey.add(ch);
			}
		}
		boolean canPermute = false;
		if (oddKey.size() <= 1) {
			canPermute = true;
			
		}
		return new ResultType(oddKey, evenKey);
    }
	
	public static void main(String[] args) {
		/* Palindrome Permutation I */
		String s1 = "code";
		String s2 = "aab";
		String s3 = "carerac";
		PalindromePermutation pp = new PalindromePermutation();
		System.out.println(pp.canPermutePalindrome(s1));
		
		/* Palindrome Permutation II */
		String s4 = "aabb";
		String s5 = "aaa";
		String s6 = "aab";
		String s7 = "as";
		ArrayList<Character> chars = new ArrayList<Character>();
		for (char c : s4.toCharArray()) {
		  chars.add(c);
		}
		List<List<Character>> permutations = pp.permutation(chars);
		System.out.println(permutations);
		
		System.out.println("evenkey:" + pp.getKeyQuantity(s4).evenKey);
		System.out.println(s4 + ":" + pp.generatePalindromes(s4));
		
		System.out.println(s5 + ":" + pp.generatePalindromes(s5));
		System.out.println(s6 + ":" + pp.generatePalindromes(s6));
		System.out.println(s7 + ":" + pp.generatePalindromes(s7));
	}

}
