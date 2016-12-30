package dynamicProgramming2;

public class LongestCommonSubstring {
	
	public int longestCommonSubstring(String A, String B) {
		/*1. state */
		int n = A.length();
		int m = B.length();
		int[][] dp = new int[n+1][m+1];
		int result = 0;
		
		/*2. initialize*/
		for(int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for(int j = 0; j <= m; j++) {
			dp[0][j] = 0;
		}
		
		/*3. function*/
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				result = Math.max(dp[i][j], result);
			}
		}
		
		/*4. answer*/
		return result;
	}
	
	public static void main(String[] args) {
    	String A = "ABCD";
    	String B = "CBCED";
    	LongestCommonSubstring lcs = new LongestCommonSubstring();
    	System.out.println(lcs.longestCommonSubstring(A, B));
    }
}
