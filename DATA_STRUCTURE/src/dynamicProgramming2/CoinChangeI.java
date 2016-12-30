package dynamicProgramming2;

public class CoinChangeI {
	/* Problem 9 */
	public boolean coinChangeII(int[] coins, int V, int K) {
		/*1. state*/
		boolean[][] f = new boolean[K+1][V+1];//f[k][v]: k coins can make up total value of v or not
		
		/*2. initialize*/
		for(int k = 0; k <= K; k++) {//coins number
			for(int i = 0; i < coins.length; i++) {//coin value
				for(int v = 0; v <= V; v++) {//total value
					if(k == 0 || v == 0) {
						f[k][v] = false;//f[0][v] || f[i][0]
					}
					if(v == coins[i]) {
						f[1][v] = true;
					}
				}
			}
		}
		
		/*3. function*/
		for(int k = 1; k <= K; k++) {//coins number
			for(int i = 0; i < coins.length; i++) {//coin value
				for(int v = 0; v <= V; v++) {//total value
					f[k][v] = f[k-1][v] || f[k][v];
					if(v-coins[i] >= 0) {
						f[k][v] = f[k-1][v-coins[i]] || f[k][v];
					}
				}
			}
		}	
		/*4. answer*/
		return f[K][V];
	}
	
	
	public static void main(String[] args) {
		int[] coins = {5, 10};
		int k = 6;
		int V = 55;
		CoinChangeI cc = new CoinChangeI();
		System.out.println(cc.coinChangeII(coins, V, k));
	}

}
