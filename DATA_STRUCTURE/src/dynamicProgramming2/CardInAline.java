package dynamicProgramming2;

public class CardInAline {
	/** Returns optimal value possible that a player can collect from
		an array of cards of size n. Note that n must be even*/
	public int cardInaLine(int[] s, int n) {//int[] card = {8, 15, 3, 7};
		/*1. state*/
		int[][] f = new int[n][n];
		int i = 0, j = 0;
		/*2. function*/
		for(int len = 1; len <= n; len++) {
			for(i = 0; i < n; i++) {
				j = len - 1;
				/*base*/
				int x = (i+2 <= j)? f[i+2][j] : 0;
				int y = (i+1 <= j-1)? f[i+1][j-1] : 0;
				int z = (i <= j-2)? f[i][j-2] : 0;
				f[i][j] = Math.max(s[i] + Math.min(x, y), 
								   s[j] + Math.min(y, z));
			}
		}
		return f[0][n-1];
	}
	
	public static void main(String[] args) {
		int[] card = {8, 15, 3, 7};
		int n = card.length;
		CardInAline cl = new CardInAline();
		System.out.println(cl.cardInaLine(card, n));
	}

}
