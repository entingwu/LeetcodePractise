package dynamicProgramming2;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
	/* Problem 7 */
	public boolean coinChange(int[] coins, int V) {
		/*1. state*/
		boolean[] f = new boolean[V + 1];//f[i], value=i时,coin num
		
		/*2. function*/
		for(int i = 0; i <= V; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(i == coins[j]) {//initialize
					f[i] = true;
				}
				if((i + coins[j] <= V) && f[i] == true) {
					f[i + coins[j]] = true;
				}
			}
		}
		
		/*3. answer*/
		return f[V];
	}
	
	/* Problem 8 : at most once */
	public List<Integer> coinChangeI(int[] coins, int V) {
		/*1. state*/
		int[] f = new int[V + 1];//f[i]=index 的前i个硬币由哪个coins[index]组成到达
		
		/*2. initialize*/
		for(int v = 0; v <= V; v++) {
			f[v] = -1;
		}
		
		/*3. function*/
		for(int i = 0; i < coins.length; i++) {
			int [] tmp = new int[V + 1];
			for(int v = 0; v <= V; v++) {//copy array f to tmp, make element unique, only contain 1,5,10,20
				tmp[v] = f[v];
			}
			for(int v = 0; v + coins[i] <= V; v++) {
				if(f[v] != -1) {
					tmp[v + coins[i]] = i;//record the prev one index
				}
			}
			for(int v = 0; v <= V; v++) {
				f[v] = tmp[v];
			}
			if(coins[i] <= V) {
				f[coins[i]] = i;
			}
		}
		
		/*4. answer*/
		List<Integer> result = new ArrayList<Integer>();
		while(V != 0) {
			int index = f[V];
			if(index == -1) { break; }	
			result.add(0, coins[index]);
			V = V - coins[index];
		}
		return result;
	}
	
	public static void main(String[] args) {
		/* Problem 7 */
		int[] coins = {5, 10};
		int amount = 15;
		CoinChange cc = new CoinChange();
		System.out.println(cc.coinChange(coins, amount));
		
		/* Problem 8 */
		int[] coins1 = {1, 5, 10, 20};
		int amount1 = 7;
		System.out.println(cc.coinChangeI(coins1, amount1));
	}

}
