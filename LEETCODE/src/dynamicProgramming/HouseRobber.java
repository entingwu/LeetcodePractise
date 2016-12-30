package dynamicProgramming;

public class HouseRobber {

	public int rob(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		if(nums.length == 1) { return nums[0]; }
		/* 1. state */
		int len = nums.length;
		int[] f = new int[len];
		
		/* 2. initialize */
		for(int i = 0; i < len; i++) {
			f[i] = nums[i];
		}
		f[1] = Math.max(f[0], f[1]);
		
		/* 3. function */
		for(int i = 2; i < len; i++) {
			f[i] = Math.max(f[i-1], f[i-2] + nums[i]);
		}
		/* 4. answer */
		return f[len-1];
	}
	
	public static void main(String[] args) {
		int[] nums = {3,8,4};
		int[] nums1 = {0};
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(nums));

	}
	public int rob1(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		if(nums.length == 1) { return nums[0]; }
		/* 1. state */
		int len = nums.length;
		int[] f = new int[len+1];
		
		/* 2. initialize */
		for(int i = 1; i <= len; i++) {
			f[i] = nums[i-1];
		}
		f[0] = 0; 
		f[2] = Math.max(f[1], f[2]);
		
		/* 3. function */
		for(int i = 2; i <= len; i++) {
			f[i] = Math.max(f[i-1], f[i-2] + nums[i-1]);
		}
		/* 4. answer */
		return f[len];
	}
}
