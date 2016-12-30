package dynamicProgrammingII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakII {

	public List<String> wordBreak(String s, Set<String> dict) {
		/* 1. state */
		//<index, result>, index : 
		//subString(0, index) -> result List<string>
		Map<Integer, List<String>> dp = new HashMap<Integer, List<String>>();
		if(!canBreak(s, dict)) { return new ArrayList<String>(); }
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
				if(dict.contains(word)) {
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
	
	private boolean canBreak(String s, Set<String> dict) {
		int n = s.length();
		boolean[] f = new boolean[n+1];
		f[0] = true;// empty str is substring
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <=i; j++ ) {// [0...j-1] && [j...i]; 
				String word = s.substring(j, i+1);
				if(dict.contains(word) && f[j]) {
					f[i+1] = true;
					break;// break from inner for loop
				}
			}
		}
		return f[n];// return last member
	}
	
	
	public static void main(String[] args) {
		String str = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");	dict.add("cats");
		dict.add("and");	dict.add("sand");	dict.add("dog");
		WordBreakII wb = new WordBreakII();
		List<String> result = wb.wordBreak(str, dict);
		System.out.println(result);

	}

}
