package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
	/* 1. subset1 : no sort */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> set = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) { return result; }
		Arrays.sort(nums);
		subsetsHelper(result,set,nums,0);
		return result;
	}
	private void subsetsHelper(List<List<Integer>> result, List<Integer> set, int[] nums, int pos) {
		result.add(new ArrayList(set));
		for(int i = pos; i < nums.length; i++) {//从pos位置开始选数加到list里
			set.add(nums[i]);
			subsetsHelper(result,set,nums,i+1);
			set.remove(set.size()-1);
		}
	}
	/* 2. subset2 : sort, 把重复的元素挤在一起 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) { return result; }
		Arrays.sort(nums);
		subsetsWithDupHelper(result, temp, nums, 0);
		return result;
	}
	private void subsetsWithDupHelper(List<List<Integer>> result, List<Integer> temp, int[] nums, int pos) {
		result.add(new ArrayList(temp));
		for(int i= pos; i < nums.length; i++) {
			//不选重复数。同层pos不变，pos是选元素的界限，i是实际选元素的位置
			if(i != pos && nums[i] == nums[i-1]) {//1,2[1] ~~ 1,2[2], continue
				System.out.println("i=" + i + " pos="+ pos +" nums[i]= " + nums[i] + " temp " + temp);
				continue; 
			}
			temp.add(nums[i]);
			subsetsWithDupHelper(result, temp, nums, i + 1);
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		Subset ss = new Subset();
		int[] nums = {1,2,3};
		int[] dup = {1,2,2};
		List<List<Integer>> subset = ss. subsetsWithDup(dup);
		System.out.println(subset);
	}
	
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		if(S.size() == 0) { return result; }
		subsetsHelper(result, temp, S, 0);
		return result;
	}
	private void subsetsHelper(ArrayList<ArrayList<Integer>> result, 
			ArrayList<Integer> temp, ArrayList<Integer> S, int pos) {
		result.add(new ArrayList(temp));
		for(int i = pos; i < S.size(); i++) {
			temp.add(S.get(i));
			subsetsHelper(result, temp, S, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}
