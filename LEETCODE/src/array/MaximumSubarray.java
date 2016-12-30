package array;

import java.util.ArrayList;

public class MaximumSubarray {
	
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		int prefixSum = 0, maxSum = Integer.MIN_VALUE, minPrefixSum = 0;
		
		for(int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			maxSum = Math.max(maxSum, prefixSum - minPrefixSum);
			minPrefixSum = Math.min(minPrefixSum, prefixSum);
		}
		
		return maxSum;
	}
	public static void main(String[] args) {
		int[] A = {-1};
		MaximumSubarray ms = new MaximumSubarray();
		System.out.print(ms.maxSubArrayI(A));
	}
	public int maxSubArrayI(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		int prefixSum = 0, maxPrefixSum = Integer.MIN_VALUE, minPrefixSum = 0;
		int maxProfit = 0;
		for(int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			maxPrefixSum = Math.max(maxPrefixSum, prefixSum);
			minPrefixSum = Math.min(minPrefixSum, prefixSum);
		}
		if(nums.length == 1) { maxProfit = prefixSum; }
		else { maxProfit = maxPrefixSum - minPrefixSum; }
		return maxProfit;
	}
}
