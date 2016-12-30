package array;

import java.util.Arrays;

public class BestTimetoBuyandSellStock {
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0) { return 0; }
		int minPrice = Integer.MAX_VALUE, maxProfit = 0;
		for(int i = 0; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - minPrice);
		}
		return maxProfit;
	}
	
	public int maxProfitII(int[] prices) {
		if(prices == null || prices.length == 0 || prices.length == 1) { return 0; }
		int diff = 0, maxProfit = 0;
		for(int i = 1; i < prices.length; i++) {
			diff = prices[i] - prices[i - 1];
			if(diff > 0) {
				maxProfit += diff;
			}
		}
		return maxProfit;
	}
	
	public int maxProfit3(int[] prices) {
		if(prices == null || prices.length == 0) { return 0; }
		int n = prices.length;
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		int maxProfit = Integer.MIN_VALUE;
		/* 1. prices[i]-lowPrice */
		int lowPrice = prices[0];
		for(int i = 0; i < n; i++) {
			lowPrice = Math.min(lowPrice, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]-lowPrice);
			dp1[i] = maxProfit;
		}
		
		/* 2. highPrice - prices[i] */
		maxProfit = 0;
		int highPrice = prices[n-1];
		for(int i = n-1; i >= 0; i--) {
			highPrice = Math.max(highPrice, prices[i]);
			maxProfit = Math.max(maxProfit, highPrice-prices[i]);
			dp2[i] = maxProfit;
		}
		
		maxProfit = 0;
		for(int i = 0; i < n; i++) {
			maxProfit = Math.max(maxProfit, dp1[i] + dp2[i]);
		}
		
		return maxProfit;
	}
	
	
	public int maxProfitIII(int[] prices) {
		if(prices == null || prices.length == 0 || prices.length == 1) { return 0; }
		int maxProfit = 0, index = 0;
		int[] diff = new int[prices.length - 1];
		for(int i = 1; i < prices.length; i++) {
			diff[index++] = prices[i] - prices[i - 1];
		}
		Arrays.sort(diff);
		int len = diff.length;
		if(len == 1) { 
			maxProfit = diff[len-1] < 0 ? 0 : diff[len - 1];
		} else{
			for(int i = len - 1; i >= 0; i--) {
				maxProfit += diff[i] < 0? 0 : diff[i];
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = {3,2,3,1,2};
		int[] prices1 = {2,1,2,0,1};
		BestTimetoBuyandSellStock btb = new BestTimetoBuyandSellStock();
		int max = btb.maxProfit(prices);
		int maxProfit = btb.maxProfitII(prices1);
		System.out.println(maxProfit);
		
		//int[] prices2 = {4,4,6,1,1,4,2,5};
		int[] prices2 = {1,4,2};
		int maxProfitIII = btb.maxProfitIII(prices2);
		System.out.println(maxProfitIII);
	}

}
