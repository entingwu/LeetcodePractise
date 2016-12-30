package dynamicProgrammingII;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		int n = nums.length;
		int max = 0;
		/*1. state*/
		int[] f = new int[n];//f[i]表示跳到第i个位置的LIS是什么
		
		/*2. initialize*/
		for(int i = 0; i < n; i++) {
			f[i] = 1;
		}
		
		/*3. function*/
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {//f[i],f[j]不重叠
				if(nums[j] < nums[i]) {
					f[i] = Math.max(f[j] + 1, f[i]);
				}
			}
			max = Math.max(f[i], max);//f[n-1]不一定是最大的LIS，需要求过程中出现的最大的LIS
			//nums: 1,3,6,7,9,4,10,5,6
			//LIS : 1,2,3,4,5,3,6, 4,5
		}
		/*4. answer*/
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums1 = {2,2};
		int[] nums2 = {1,3,6,7,9,4,10,5,6};
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.lengthOfLIS(nums2));

	}

}
