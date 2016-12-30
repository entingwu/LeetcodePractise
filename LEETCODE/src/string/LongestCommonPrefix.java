package string;

//1. Method 1, start from the first one, compare prefix with next string, until end;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) { return ""; }
		String prefix = strs[0];
		for(int i = 1; i < strs.length; i++) {//except for strs[0]
			String curr = strs[i];
			int j = 0;
			while(j < prefix.length() && j < curr.length() && prefix.charAt(j) == curr.charAt(j)) {
				j++;
			}
			if(j == 0) { return ""; }//防止死循环，j不增加 "ab" "c"
			prefix = prefix.substring(0,j);
		}
		return prefix;
	}
	
	public static void main(String[] args) {
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		String[] strs = new String[2];
		strs[0] = "aa";
		strs[1] = "ab";
		String prefix = lcp.longestCommonPrefix(strs);
		System.out.println(prefix);
	}

}
