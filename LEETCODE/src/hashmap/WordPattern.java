package hashmap;

import java.util.HashMap;

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if(strs.length != pattern.length()) { return false; }
		HashMap<Character,String> map = new HashMap<Character,String>();
		for(int i = 0; i < pattern.length(); i++) {
			char p = pattern.charAt(i);
			if(!map.containsKey(p)) {
				if(map.containsValue(strs[i])) { //a->dog, b->dog
					return false; 
				}else { 
					map.put(p, strs[i]); 
				}
			}else {//p已出现
				if(!map.get(p).equals(strs[i])) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog dog dog dog";
		String pattern1 = "jquery";
		String str1 = "jquery";
		WordPattern wp = new WordPattern();
		System.out.println(wp.wordPattern(pattern, str));
		

	}

	
	public boolean wordPattern1(String pattern, String str) {
		int begin = 0, index = 0;
		HashMap<String,Character> map = new HashMap<String,Character>();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				String word = str.substring(begin,i);
				begin = i+1;
				if(map.containsKey(word)) {
					char p = pattern.charAt(index);
					if(map.get(word) != p) {
						return false;
					}
				}else {
					char p = pattern.charAt(index);
					index++;
					map.put(word, p);
				}
			}
		}
		return true;
	}
}
