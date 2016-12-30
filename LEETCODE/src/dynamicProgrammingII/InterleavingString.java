package dynamicProgrammingII;

public class InterleavingString {

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length() + s2.length() != s3.length()) { return false; }
		/* 1. state */
		boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];
		
		/* 2. initialize */
		f[0][0] = true;
		for(int i = 1; i <= s1.length(); i++) {
			if(f[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1)) {
				f[i][0] = true;//i个字符与空串组合成s3，true
			}
		}
		
		for(int j = 1; j <= s2.length(); j++) {
			if(f[0][j-1] && s1.charAt(j-1) == s3.charAt(j-1)) {
				f[0][j] = true;
			}
		}
		
		/* 3. function */
		for(int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if(f[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j) ||
				   f[i][j-1] && s2.charAt(j-1) == s3.charAt(i-1+j)) {
					f[i][j] = true;
					//System.out.print(i + " " + j + " " + f[i][j]);
					//System.out.println();
				}
			}
		}
		/* 4. answers */
		return f[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "b";
		String s3 = "ab";
		InterleavingString il = new InterleavingString();
		System.out.println(il.isInterleave(s1, s2, s3));
	}

}
