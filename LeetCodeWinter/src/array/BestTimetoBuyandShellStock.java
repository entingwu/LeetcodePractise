package array;

public class BestTimetoBuyandShellStock {
    /** I */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = Integer.MAX_VALUE, maxProfit = Integer.MIN_VALUE;
        // 相当于prefixSum数组中求current - min, 得出最大差值
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);//if minprice appears at the end. put minprice ahead of maxProfit
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandShellStock bts = new BestTimetoBuyandShellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println(bts.maxProfit(prices1));
    }
}
