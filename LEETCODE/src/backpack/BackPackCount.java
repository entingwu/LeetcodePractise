package backpack;

public class BackPackCount {
	/* IV. BackPack
	 * nums = {2, 3, 6, 7}, target = 7
	 * Find the number of possible fill the backpack.
	 * Each item may be chosen unlimited number of times
	 * */
	public int backPackIV(int[] nums, int target) {
        //1. state
		int n = nums.length;
		int[][] f = new int[n + 1][target + 1];
		//2. initialize
		for(int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}
		for(int t = 0; t <= target; t++) {
			f[0][t] = 0;
		}
		f[0][0] = 1;// put nothing
		//3. function
		for(int i = 1; i <= n; i++) {
			for(int t = 0; t <= target; t++) {
				int k = 0;
				while (t - nums[i - 1] * k >= 0) {
					f[i][t] += f[i - 1][t - nums[i - 1] * k];
					k++;
				}
			}
		}
		//4. answer
		return f[n][target];
    }
	
	public static void main(String[] args) {
		BackPackCount bpc = new BackPackCount();
		int[] nums = {2, 3, 6, 7};
		int target = 3;
		System.out.println(bpc.backPackIV(nums, target));

	}

}
