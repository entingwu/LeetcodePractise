package dynamicProgramming2;

public class LongestPalindromicSequence {
	// Returns the length of the longest palindromic subsequence in str
	public int longestPalindromicSequence(char[] str) {
		/* 1. state */
		int n = str.length;
		int[][] dp = new int[n][n];//dp[i][j]: ith-jth longest palindromic sequence length
		
		/* 2. initialize */
		for(int i = 0; i < n; i++) {// Strings of length 1 are palindrome of lentgh 1
			dp[i][i] = 1;
		}
		
		/* 3. function */
		// Build the table. Note that the lower diagonal values of table are
	    // useless and not filled in the process. 
		for(int len = 2; len <= n; len++) {
			for(int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;//[i,j]
				if(str[i] == str[j] && len == 2) {
					dp[i][j] = 2;
				}else if(str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}else {//str[i] != str[j]
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);//i,i+1,j-1,j
				}
			}
		}
		
		/* 4. answer */
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		char[] str = new char[14];
		str[0] = 'A'; str[1] = 'C'; str[2] = 'G'; str[3]= 'T';
		str[4] = 'G'; str[5] = 'T'; str[6] = 'C'; str[7]= 'A';
		str[8] = 'A'; str[9] = 'A'; str[10] = 'A'; str[11]= 'T';
		str[12] = 'C'; str[13] = 'G';
		
		LongestPalindromicSequence lps = new LongestPalindromicSequence();
		System.out.print(lps.longestPalindromicSequence(str));

	}
	
	public int longestPalindromicSequence1(char[] str) {
		/* 1. state */
		int n = str.length;
		int[][] dp = new int[n][n];//dp[i][j]: ith-jth longest palindromic sequence length
		
		/* 2. initialize */
		for(int i = 0; i < n; i++) {
			if(i < n-1 && str[i] == str[i+1]) {
				dp[i][i+1] = 2;
			}
			dp[i][i] = 1;
		}
		
		/* 3. function */
		for(int i = 0; i < n-1; i++) {
			for(int j = 1; j < n;j++) {
				if(str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				}else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				}
			}
		}
		
		/* 4. answer */
		return dp[0][n-1];
	}
}
