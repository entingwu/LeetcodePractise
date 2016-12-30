package dynamicProgramming1;

import java.util.ArrayList;
import java.util.List;

public class MaximumSubarraySum {
	
	public List<Integer> maxSubArray1(int[] nums) {
		List<Integer> subarray = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) { return subarray; }
		/* 1. state*/
		int prefixSum = 0, minSum = 0;
		int max = Integer.MIN_VALUE, maxPos = 0;
		int minPos = 0, realMin = 0;
				
		/* 2. function */
		for(int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if(prefixSum - minSum > max) {
				max = prefixSum - minSum;
				maxPos = i;
				realMin = minPos;//realMin and maxPos are updated at the same time
			}
			if(prefixSum < minSum) {
				minSum = prefixSum;
			    minPos = i + 1;
			}
		}
		/* 3. subarray */
		for(int i = realMin; i <= maxPos; i++) {
			subarray.add(nums[i]);
		}
		return subarray;
	}

	public static void main(String[] args) {
		int[] nums = {5,15,-30,10,-5,40,10};
		int[] nums1 = {10,9,-4,-20};
		MaximumSubarraySum mss = new MaximumSubarraySum();
		System.out.println(mss.maxSubArray1(nums1));
	}
	
	public List<Integer> maxSubArray(int[] nums) {
		List<Integer> subarray = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) { return subarray; }
		/* 1. state*/
		int prefixSum = 0;
		int minSum = 0;
		int max = Integer.MIN_VALUE;
		int maxPos = 0;
				
		/* 2. function */
		for(int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if(prefixSum - minSum > max) {
				max = prefixSum - minSum;
				maxPos = i;
			}
			minSum = Math.min(prefixSum, minSum);
		}
		
		/* 3. subarray */
		int sum = max;
		for(int j = maxPos; j >= 0; j--) {
			if(sum == 0) { break; }
			subarray.add(0, nums[j]);
			sum -= nums[j];
		}
		return subarray;
	}

}
