package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) { return result; }
		permuteHelper(result,temp,nums);
		return result;
	}
	private void permuteHelper(List<List<Integer>> result, List<Integer> temp, int[] nums) {
		if(temp.size() == nums.length) {
			result.add(new ArrayList(temp));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(temp.contains(nums[i])) {
				continue;
			}
			temp.add(nums[i]);
			permuteHelper(result, temp, nums);
			temp.remove(temp.size() - 1);
		}
	}
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) { return result; }
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		permuteUniqueHelper(result, temp, nums, used);
		return result;
	}
	private void permuteUniqueHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
		if(temp.size() == nums.length) {
			result.add(new ArrayList(temp));
			return;
		}
		for(int i = 0; i< nums.length; i++) {
			if(used[i] == true || i != 0 && nums[i] == nums[i - 1] && used[i - 1] == false) { continue; }
			temp.add(nums[i]);
			used[i] = true;
			System.out.println(temp);
			permuteUniqueHelper(result, temp, nums, used);
			temp.remove(temp.size()-1);
			used[i] = false;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Permutations p = new Permutations();
		System.out.println(p.permute(nums));
		int[] nums1 = {1,1,2};
		System.out.println(p.permuteUnique(nums1));

	}

}
