package dynamicProgrammingII;

public class LongestCommonSubsequence {
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     * 最长公共子序列
     */
    public int longestCommonSubsequence(String A, String B) {
    	int lenA = A.length();
    	int lenB = B.length();
    	
    	/* 1. state */
    	int[][] f = new int[lenA + 1][lenB + 1];
    	
    	/* 2. initialize */
    	for(int i = 0; i <= lenA; i++ ) {
    		f[i][0] = 0;
    	}
    	for(int j = 0; j <= lenB; j++) {
    		f[0][j] = 0;
    	}
    	
    	/* 3. function */
    	for(int i = 1; i <= lenA; i++) {
    		for(int j = 1; j <= lenB; j++) {
    			f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
    			if(A.charAt(i-1) == B.charAt(j-1)) {
    				f[i][j] = Math.max(f[i][j], f[i-1][j-1] + 1);
    			}
    		}
    	}
    	
    	/* 4. answer */
    	return f[lenA][lenB];
    }
    
    public static void main(String[] args) {
    	String A = "ABCD";
    	String B = "EACB";
    	LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    	System.out.println(lcs.longestCommonSubsequence(A, B));
    }
}
