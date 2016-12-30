package array;

import java.util.Arrays;

public class MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		min[0] = nums[0]; 
		max[0] = nums[0];
		int maxProduct = nums[0];//不是1
		for(int i = 1; i < nums.length; i++) {
			max[i] = nums[i];
			min[i] = nums[i];
			if(nums[i] > 0) {
				max[i] = Math.max(max[i-1]*nums[i], max[i]);
				min[i] = Math.min(min[i-1]*nums[i], min[i]);
			}else if(nums[i] < 0) {
				max[i] = Math.max(min[i-1]*nums[i], max[i]);
				min[i] = Math.min(max[i-1]*nums[i], min[i]);
			}
			maxProduct = Math.max(max[i], maxProduct);
		}
		return maxProduct;
	}
	
	public static void main(String[] args) {
		

	}

}
