package dynamicProgramming;

public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		/*1. state*/
		int[] f = new int[amount + 1];//f[i], value=i时,coin num
		
		/*2. initialize*/
		for(int i = 1; i <= amount; i++) {
			f[i] = Integer.MAX_VALUE-1;
		}
		
		/*3. function*/
		for(int i = 0; i <= amount; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i + coins[j] <= amount) {
					f[i + coins[j]] = Math.min(f[i] + 1, f[i + coins[j]]);
				}
			}
		}
		
		/*4. answer*/
		return f[amount] == Integer.MAX_VALUE-1? -1 : f[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		int[] coins1 = {2};
		int amount1 = 3;
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(coins1, amount1));
	}

}
