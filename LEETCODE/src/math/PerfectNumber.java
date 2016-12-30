package math;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

	public static List<Integer> perfectNum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        for (int i = 0; i< nums.length; i++) {
            if (nums[i] < 6) {
                continue;
            }
            int sum = 0;
            for (int j = 1; j <= nums[i]/2; j++) {
                if (nums[i] % j == 0) {
                    sum += j;
                }
            }
            if (nums[i] == sum) {
                res.add(nums[i]);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		

	}

}
