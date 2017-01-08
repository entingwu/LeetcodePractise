package array;

import java.util.Random;

public class RandomPickIndex {

    private int[] nums;
    private Random random;
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0, result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                // randomly select an int from 0 to the nums of target. If x equals 0, set the res as the current index.
                // The probability is always 1/nums for the latest appeared number.
                // For example, 1 for 1st num, 1/2 for 2nd num, 1/3 for 3nd num (1/2 * 2/3 for each of the first 2 nums).
                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        RandomPickIndex rpi = new RandomPickIndex(nums);
        System.out.println(rpi.pick(2));

    }
}
