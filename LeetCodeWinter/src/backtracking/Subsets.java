package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    /** II */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetDupHelper(result, temp, nums, 0);
        return result;
    }

    private void subsetDupHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, int pos) {
        result.add(new ArrayList<>(temp));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {// backtrack. i = 2, pos = 1
                continue;
            }
            temp.add(nums[i]);
            subsetDupHelper(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /** I */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetHelper(result, temp, nums, 0);
        return result;
    }

    private void subsetHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, int curr) {
        result.add(new ArrayList<>(temp));
        for (int i = curr; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetHelper(result, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets.subsets(nums);

        int[] numsDup = {1, 2, 2};
        List<List<Integer>> resultDup = subsets.subsetsWithDup(numsDup);
        resultDup.forEach(temp -> {
            System.out.println(temp + ",");
        });
    }
    // Same as permutation II
    /*private void subsetDupHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used, int curr) {
        result.add(new ArrayList<>(temp));
        for (int i = curr; i < nums.length; i++) {
            if (used[i] || i >= 1 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            subsetDupHelper(result, temp, nums, used, i + 1);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }*/
}
