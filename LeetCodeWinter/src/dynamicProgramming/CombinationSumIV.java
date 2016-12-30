package dynamicProgramming;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        //1. state
        int[] f = new int[target + 1];
        //2. initialize
        f[0] = 1;
        //3. function
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    f[i] += f[i - num];
                }
            }
        }
        //4. answer
        return f[target];
    }

    public static void main(String[] args) {
        CombinationSumIV csi = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(csi.combinationSum4(nums, target));
    }
}
