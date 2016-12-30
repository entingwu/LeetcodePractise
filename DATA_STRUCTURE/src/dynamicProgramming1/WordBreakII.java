package dynamicProgramming1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {
	
	private Set<String> wordDict;
	public WordBreakII() {
		wordDict = new HashSet<String>();
		wordDict.add("leet"); wordDict.add("code");
		wordDict.add("lee"); wordDict.add("tcode");
	}
	
	/** Problem 7.2 */
	public List<String> wordBreak(String s) {
		/* 1. state */
		//<index, result>, index : 
		//subString(0, index) -> result List<string>
		Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
		if(!canBreak(s)) { return new ArrayList<String>(); }
		int n = s.length();
		
		/* 2. initialize */
		List<String> base = new ArrayList<String>();
		base.add("");
		dp.put(0, base);//<0, "">
		
		/* 3. function */
		// [0...j-1] && [j...i]; condition: dp[j].size()!=0 simplified
		for(int i = 0; i < n; i++) {
			List<String> curr = new ArrayList<String>();
			dp.put(i+1, curr);
			for(int j = 0; j<=i; j++) {
				String word = s.substring(j,i+1);
				if(dict(word)) {
					for(String str : dp.get(j)) {
						String space = str.length()==0? "" : " ";
						String newStr = str + space + s.substring(j,i+1);
						dp.get(i+1).add(newStr);
					}
					
				}
			}
		}
		/* 4. answer */
		return dp.get(n);
	}
	
	private boolean canBreak(String s) {
		int n = s.length();
		boolean[] f = new boolean[n+1];
		f[0] = true;// empty str is substring
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <=i; j++ ) {// [0...j-1] && [j...i]; 
				String word = s.substring(j, i+1);
				if(dict(word) && f[j]) {
					f[i+1] = true;
					break;// break from inner for loop
				}
			}
		}
		return f[n];// return last member
	}
	
	public static void main(String[] args) {
		String str = "leetcodeleet";
		WordBreakII wb = new WordBreakII();
		System.out.println(wb.wordBreakII(str));

	}
	
	/** Way 2 */
	public List<String> wordBreakII(String s) {
		/* 1. state */
		//<index, result>, index : 
		//subString(0, index) -> result List<string>
		Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
		int n = s.length();
		
		/* 2. initialize */
		List<String> base = new ArrayList<String>();
		base.add("");
		dp.put(0, base);//<0, "">
		int maxLength = getMaxLength(wordDict);
		
		for(int i = 1; i <= n; i++) {
			List<String> curr = new ArrayList<String>();
			dp.put(i, curr);
		}
		
		/* 3. function */
		for(int i = 1; i <= n; i++) {
			List<String> curr = new ArrayList<String>();
			dp.put(i, curr);
			for(int j = 1; j<=i && j<=maxLength; j++) {
				String word = s.substring(i-j, i);
				if(dict(word)) {
					for(String str: dp.get(i-j)) {//给[leet code, lee tcode] 后加上"leet"
						String space = str.length()==0? "":" ";
						String newStr = str + space + word;
						dp.get(i).add(newStr);
					}
				}
			}
		}
		
		/* 4. answer */
		return dp.get(n);
	}
	
	public boolean canBreak1(String s) {
		int n = s.length();
		boolean[] f = new boolean[n+1];
		f[0] = true;
		int maxLength = getMaxLength(wordDict);
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <=i && j<=maxLength; j++ ) {
				String word = s.substring(i-j, i);
				if(dict(word) && f[i-j]) {
					f[i] = true;
					break;
				}
			}
		}
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
}
