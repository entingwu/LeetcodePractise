package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(candidates == null || candidates.length == 0) { return result; }
		Arrays.sort(candidates);
		combinationSumHelper(result,temp,candidates,target,0);
		return result;
	}
	private void combinationSumHelper(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int pos) {
		if(target == 0) {
			result.add(new ArrayList(temp));
			return;
		}
		int preDup = -1;
		for(int i = pos; i < candidates.length; i++) {
			if(candidates[i] > target) { break; }
			if(preDup != -1 && preDup == candidates[i]) { System.out.print(i + " " + candidates[i] + " " + temp + " "); continue;  }
			temp.add(candidates[i]);
			//System.out.println(temp);
			combinationSumHelper(result, temp, candidates, target - candidates[i], i);
			temp.remove(temp.size() - 1);
			preDup = candidates[i];
		}
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(candidates == null || candidates.length == 0) { return result; }
		Arrays.sort(candidates);
		combinationSumHelper2(result, temp, candidates, target, 0);
		return result;
	}
	private void combinationSumHelper2(List<List<Integer>> result, List<Integer> temp, int[] candidates, int target, int pos) {
		if(target == 0) {
			result.add(new ArrayList(temp));
			return;
		}
		
		for(int i = pos; i < candidates.length; i++) {
			if(candidates[i] > target) { break; }
			if(i != pos && candidates[i] == candidates[i - 1]) { continue; }
			temp.add(candidates[i]);
			combinationSumHelper2(result, temp, candidates, target - candidates[i], i + 1);
			temp.remove(temp.size() - 1);
		}
	}
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>>  result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(n <= 0 || k == 0) { return result; }
		combinationSum3Helper(result, temp, k, n, 1);
		return result;
	}
	private void combinationSum3Helper(List<List<Integer>> result, List<Integer> temp, int num, int target, int pos) {
		if(target == 0 && num == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = pos; i <= 9; i++) {
			if(i > target) { break; }
			temp.add(i);
			combinationSum3Helper(result, temp, num - 1, target - i, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,3,7};
		int target = 7;
		int[] nums1 = {10,1,2,7,6,1,5};
		int target1 = 8;
		
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(nums, target));
		
		System.out.println(cs.combinationSum2(nums1, target1));
		
		int k = 3, n = 15;
		System.out.println(cs.combinationSum3(k, n));
	}

}
