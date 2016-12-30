package dynamicProgrammingII;

public class DistinctSubsequence {
	
	public int numDistinct(String s, String t) {
		if(s == null || t == null) { return 0; }
		int lenS = s.length();
		int lenT = t.length();
		
		/* 1. state */
		int[][] f = new int[lenS + 1][lenT + 1];
		
		/* 2. initialize */
		for(int i = 0; i <= lenS; i++) {
			f[i][0] = 1;
		}		
		
		/* 3. function */
		for(int i = 1; i <= lenS; i++) {
			for(int j = 1; j <= lenT; j++) {
				if(s.charAt(i-1) == t.charAt(j-1)) {
					f[i][j] = f[i-1][j-1] + f[i-1][j];
				}else {
					f[i][j] = f[i-1][j];
				}
			}
		}
		/* 4. answer */
		return f[lenS][lenT];
	}
	
	public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		DistinctSubsequence ds = new DistinctSubsequence();
		System.out.println(ds.numDistinct(S, T));
		
		
	}

}
