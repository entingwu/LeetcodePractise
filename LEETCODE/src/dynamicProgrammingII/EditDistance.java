package dynamicProgrammingII;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		
		/* 1. state */
		int[][] f = new int[len1 + 1][len2 + 1];
		
		/* 2. initialize */
		for(int i = 0; i <= len1; i++) {
			f[i][0] = i;
		}
		for(int j = 0; j <= len2; j++) {
			f[0][j] = j;
		}
		
		/* 3. function */
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(word1.charAt(i-1) != word2.charAt(j-1)) {
					// insert,delete
					f[i][j] = Math.min(f[i][j-1] + 1, f[i-1][j] + 1);
					f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);//replace
				}else {
					f[i][j] = Math.min(f[i][j-1] + 1, f[i-1][j] + 1);
					f[i][j] = Math.min(f[i][j], f[i-1][j-1]);//replace
				}
			}
		}
		
		/* 4. answer */
		return f[len1][len2];
	}
	
	public static void main(String[] args) {
		String word1 = "mart";
		String word2 = "karma";
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance(word1, word2));

	}

}
