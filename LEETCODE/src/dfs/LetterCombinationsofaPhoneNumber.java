package dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
	
	public List<String> letterCombinations(String digits) {
		Map<Character,String> map = new HashMap<Character,String>();
		map.put('1', ""); map.put('2', "abc"); map.put('3', "def"); map.put('4', "ghi");
		map.put('5', "jkl"); map.put('6', "mno"); map.put('7', "pqrs");
		map.put('8', "tuv"); map.put('9', "wxyz"); map.put('0', ""); 
		
		List<String> result = new ArrayList<String>();
		String temp = "";
		if(digits == null || digits.length() == 0) { return result; }
		numberDFS(map, result, temp, digits, 0);
		return result;
	}
	
	private void numberDFS(Map<Character, String> map, List<String> result, String temp, String digits, int pos) {
		if(pos == digits.length()) { 
			result.add(temp);
			return;
		}
		
		char ch = digits.charAt(pos);
		String str =  map.get(ch);
		if(str != null) {
			for(int i = 0; i < str.length(); i++) {
				//temp = temp + str.charAt(i);
				//numberDFS(map, result, temp, digits, pos+1);
				//temp = temp.substring(0, temp.length() -1 );
				numberDFS(map, result, temp + str.charAt(i), digits, pos+1);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "2";
		LetterCombinationsofaPhoneNumber lc = new LetterCombinationsofaPhoneNumber();
		List<String> result = lc.letterCombinations(str);
		System.out.println(result);
		
	}
	
	public List<String> letterCombinationsI(String digits) {
		Map<Character,String> map = new HashMap<Character,String>();
		map.put('1', ""); map.put('2', "abc"); map.put('3', "def"); map.put('4', "ghi");
		map.put('5', "jkl"); map.put('6', "mno"); map.put('7', "pqrs");
		map.put('8', "tuv"); map.put('9', "wxyz"); map.put('0', ""); 
		
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0) { return result; }
		StringBuilder temp = new StringBuilder();
		numberDFSI(map, result, temp, digits);
		return result;
	}
	
	private void numberDFSI(Map<Character, String> map, List<String> result, StringBuilder temp, String digits) {
		if(temp.length() == digits.length()) { 
			result.add(temp.toString());
			return;
		}
		
		char ch = digits.charAt(temp.length());
		String str =  map.get(ch);
		if(str != null) {
			for(int i = 0; i < str.length(); i++) {
				temp.append(str.charAt(i));
				numberDFSI(map, result, temp, digits);
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}

}
