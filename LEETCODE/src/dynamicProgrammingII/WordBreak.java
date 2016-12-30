package dynamicProgrammingII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	/* WordBreak I */
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s == null || s.length() == 0) { return true; }
		int maxLength = getMaxLength(wordDict);
		
		/* 1. state */
		boolean[] canSegment = new boolean[s.length() + 1];//0~i，第i个
		
		/* 2. initialize */
		canSegment[0] = true;
		for(int i = 1; i <= s.length(); i++) {
			canSegment[i] = false;
		}
		
		/* 3. function */
		for(int i = 1; i <= s.length(); i++ ) {//f[i] : i字符处能否划分为完整单词
			for(int lastWordLength = 1; lastWordLength <= maxLength && lastWordLength <=i ; 
					lastWordLength++) {//枚举单词长度
				if(!canSegment[i - lastWordLength]) { continue; }//前j个， f[j]不能划分为完整单词，则略过
				String word = s.substring(i - lastWordLength, i);//f[j]为true，且最后单词在词典中 ==> f[i] true
				//System.out.println(word);
				if(wordDict.contains(word)) {
					canSegment[i] = true;
					break;
				}
			} 
		}
		/* 4. answers */
		return canSegment[s.length()];
	}
	
	private int getMaxLength(Set<String> wordDict) {
		int maxLength = 0;
		for(String word : wordDict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}
	
	/* WordBreak II */
	public List<String> wordBreakI(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        String temp = "";
        wordBreakHelper(s, wordDict, 0, temp, result);
        return result;
    }
	
	private void wordBreakHelper(String s, Set<String> wordDict, int start, String temp, List<String> result) {
		if(start == s.length()) {
			result.add(temp);
			return;
		}
		StringBuilder str = new StringBuilder();
		for(int i = start; i < s.length(); i++) {
			str.append(s.charAt(i));
			if(wordDict.contains(str.toString())) {
				String newTemp = temp.length()>0? (temp+" "+str.toString()) : str.toString();
				wordBreakHelper(s, wordDict, i+1, newTemp, result);
			}
		}
	}
	
	public boolean wordBreak1(String s, Set<String> dict) {
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for(int i = 1; i <= s.length(); i++) {
			for(int j = 0; j < i; j++) {
				if (f[j] == false) {
					continue;
				}
				String subStr = s.substring(j, i);
				if (dict.contains(subStr)) {
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}
	
	public boolean wordBreak2(String s, Set<String> dict) {
		int maxLen = getMaxLen(dict);
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for(int i = 1; i <= s.length(); i++) {
			for(int wordLen = 1; wordLen <= maxLen && wordLen <= i; wordLen++) {
				if (f[i-wordLen] == false) {
					continue;
				}
				String subStr = s.substring(i-wordLen, i);
				if (dict.contains(subStr)) {
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}
	
	private int getMaxLen(Set<String> dict) {
		int maxLen = Integer.MIN_VALUE;
		for(String str : dict) {
			maxLen = Math.max(str.length(), maxLen);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(s.substring(4, 8));
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(s, dict));
		System.out.println(wb.wordBreak1(s, dict));
		System.out.println(wb.wordBreak2(s, dict));
		
		/*Word Break II*/
		String str = "catsanddog";
		dict.add("cat");	dict.add("cats");
		dict.add("and");	dict.add("sand");	dict.add("dog");
		List<String> result = wb.wordBreakI(str, dict);
		System.out.println(result);
		
		
		
	}
}
