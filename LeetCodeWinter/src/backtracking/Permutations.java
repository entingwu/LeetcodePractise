package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /** II */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(result, temp, nums, used);
        return result;
    }

    /* 在递归函数中要判断前面一个数和当前的数是否相等，如果相等，前面的数必须已经使用了，
       即对应的visited中的值为1，当前的数字才能使用，否则需要跳过，这样就不会产生重复排列了 */
    private void permuteUniqueHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i >= 1 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            permuteUniqueHelper(result, temp, nums, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    /** I */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        permuteHelper(result, temp, nums);
        return result;
    }

    private void permuteHelper(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            permuteHelper(result, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        //List<List<Integer>> result = permutations.permute(nums);

        int[] nums1 = {1, 2, 2};
        List<List<Integer>> result1 = permutations.permuteUnique(nums1);
        for (List<Integer> temp : result1) {
            System.out.print(temp + ",");
        }
    }
}
