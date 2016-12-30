package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
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
        result.forEach(temp -> {
            System.out.println(temp + ",");
        });
    }
}
