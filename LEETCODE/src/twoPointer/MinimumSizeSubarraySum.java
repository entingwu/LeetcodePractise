package twoPointer;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		int len = nums.length;
		int sum = 0, result = Integer.MAX_VALUE;
		int j = 0;
		for(int i = 0; i < len; i++) {
			while(j < len) {//每次找到sum>s,j不用动，让i追
				if(sum < s) {
					sum += nums[j];
					j++;
				}else {//>=s
					break;
				}
			}
			if(sum >= s) {
				result = Math.min(j-i, result);
				sum -= nums[i];
			}
		}
		result = result == Integer.MAX_VALUE? 0 : result;
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		//int[] nums1 = {4,3,1};
		int[] nums2 = {1,1};
		MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
		int s = 7;
		int result = ms.minSubArrayLen(s, nums2);
		System.out.println(result);
	}

}
