package dynamicProgramming1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	
	private Set<String> wordDict;
	public WordBreak() {
		wordDict = new HashSet<String>();
		wordDict.add("leet"); wordDict.add("code");
	}
	
	/** Problem 7.1 */
	public boolean wordBreak(String s) {
		if(s == null || s.length() == 0) { return false; }
		int n = s.length();
        /*1. state*/
		boolean[] f = new boolean[n + 1];//前i个能不能切分
		
		/*2. initialize*/
		f[0] = true;
		int maxLength = getMaxLength(wordDict);
		
		/*3. function*/
		for(int i = 1; i <= n; i++) {
			f[i] = false;
			//枚举最后一个单词长度
			for(int lastWordLen = 1; lastWordLen<=i && lastWordLen<=maxLength; lastWordLen++) {
				String word = s.substring(i - lastWordLen,i);//4~8
				if(f[i - lastWordLen] && dict(word)) {
					f[i] = true;
					break;
				}
			}
		}
		/*4. answer*/
		return f[n];
    }
	
	private int getMaxLength(Set<String> wordDict) {
        int maxLength = 0;
        for(String word : wordDict) {
            maxLength = Math.max(word.length(), maxLength);
        }
        return maxLength;
    }
	
	private boolean dict(String word) {
		return wordDict.contains(word);
	}
	
	public static void main(String[] args) {
		String str = "leetcode";
		WordBreak wb = new WordBreak();
		System.out.println(wb.wordBreak(str));

	}
}
