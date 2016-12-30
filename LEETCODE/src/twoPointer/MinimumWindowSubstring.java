package twoPointer;

public class MinimumWindowSubstring {
	/** 
	 *  S = "ADOBECODEBANC"
		T = "ABC"
		Minimum window is "BANC".
		出现第二个B时，valid才return true
	 * */
	public String minWindow(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        /* hash */
		int[] sourceHash = new int[256];
        int[] targetHash = new int[256];
        
        /* 1. init targetHash */
        for(char ch : t.toCharArray()) {
        	targetHash[ch]++;
        }
        
        int i = 0, j = 0;
        for(i = 0; i < s.length(); i++) {//遍历source
        	/* 2. sourceHash */
        	while(!valid(sourceHash, targetHash) && j < s.length()) {//valid return false, when j==9, (i=0)
        		sourceHash[s.charAt(j)]++;
        		if(j < s.length()) { j++; }
        		else { break; }
        	}
        	if(valid(sourceHash, targetHash)) {
        		if(j - i < minLen) {
        			minLen = Math.min(j-i, minLen);
        			minStr = s.substring(i, j);
        			//j==9为t中字符第二次出现index, "ADOBECODE"
        		}
        	}
        	sourceHash[s.charAt(i)]--;//从i+1位检查
        }
		return minStr;//i=9,j=13
    }
	
	private boolean valid(int[] sourceHash, int[] targetHash) {
		//只要t中有一个字符在s中没出现，就是false.
		//当t中字符有一个第二次出现时，valid才return true
		for(int i = 0; i < 256; i++) {
			if(targetHash[i] > sourceHash[i]) { return false; }
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow(s, t));
		
	}

}
