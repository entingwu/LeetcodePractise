package dynamicProgramming1;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	/** Returns the maximum value that can be put in a knapsack of capacity W*/
	public static int[][] knapsack(int[] wt, int[] val, int W, int n) {
		/*1. state*/
		int[][] dp = new int[n+1][W+1];
		//the maximum value, which item set 0,1,..i, knapsack capacity is w, 
		
		/*2. initialize*/
		for(int i = 0; i <= n; i++) { 
			dp[i][0] = 0; //不取，价值为0
		}
		for(int w = 0; w <= W; w++) {
			dp[0][w] = 0; //no bag
		}
		
		/*3. function*/
		for(int i = 1; i <= n; i++) {
			for(int w = 1; w <= W; w++) {
				dp[i][w] = dp[i-1][w];
				if(wt[i-1] <= w) {
					dp[i][w] = Math.max(dp[i-1][w-wt[i-1]] + val[i-1], dp[i][w]);
				}
			}
		}
		/*4. answer*/
		return dp;
		//return dp[n][W];
	}
	
	/* Solution */
	public static List<Integer> knapsackSolution(int[][] dp, int[] wt, int W, int n) {
		List<Integer> result = new ArrayList<Integer>();
		int w = W, i = n;
		while(i > 0 && w > 0) {
			if(dp[i][w] != dp[i-1][w]) {//take item
				result.add(0, i-1);
				w = w - wt[i-1];
			}
			i--;
		}
		return result;
	}
	
	/* Memorization */
	public static int knapsackMemo(int[] wt, int[] val, int W, int n) {
		int[][] hash = new int[n+1][W+1];
		for(int i = 0; i <= n; i++) {
			for(int w = 0; w <= W; w++) {
				hash[i][w] = -1;
			}
		}
		int maxValue = knapsackMemoHelper(hash, wt, val, W, n);
		return maxValue;
	}
	
	public static int knapsackMemoHelper(int[][] hash, int[] wt, int[] val, int w, int n) {
		if(w == 0 || n == 0) {
			return 0;
		}
		
		if(hash[n][w] == -1) {
			/* If weight of the nth item is more than Knapsack capacity W, then
			   this item cannot be included in the optimal solution */
			if(wt[n-1] > w) {
				hash[n][w] = knapsackMemoHelper(hash, wt, val, w, n-1);
			}else {//nth item included or not
				hash[n][w] = Math.max(knapsackMemoHelper(hash, wt, val, w - wt[n-1], n-1) + val[n-1], hash[n][w]);
			}
		}
		
		return hash[n][w];
	}
	
	public static void main(String[] args) {
		int[] val = {60, 100, 120};
		int[] weight = {1, 3, 5};
		int W = 8;
		int items = 3;//items
		int[][] dp = knapsack(weight, val, W, items);
		
		//find solution
		List<Integer> result = knapsackSolution(dp, weight, W, items);
		System.out.println(result);
		
		//Memorization
		int maxValue = knapsackMemo(weight, val, W, items);
		System.out.println(maxValue);
	}

}
