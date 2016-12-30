package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumCloset {
	
	public int threeSumCloset(int[] nums, int target) {
		if(nums == null || nums.length < 3) { return 0; }
		Arrays.sort(nums);
		int closet = Integer.MAX_VALUE / 2;
		for(int i = 0; i < nums.length; i++) {
			int j = i+1, k = nums.length-1, temp = 0;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				closet = Math.abs(target-temp) < Math.abs(target-sum)? sum : closet;
				if(sum == target) {
					return sum;
				}else if(sum < target) {
					j++;
				}else{//>=
					k--;
				}
			}
		}
		return closet;
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) { return result; }
		Arrays.sort(nums);
		for(int i = 0; i < nums.length ; i++) {
			if(i != 0 && nums[i] == nums[i-1]) { continue; }
			int j = i + 1, k = nums.length - 1;
			while(j < k) {
				if(j != i+1 && nums[j] == nums[j-1]) {
					j++; continue;
				}
				if(k != nums.length-1 && nums[k] == nums[k+1]) {
					k--; continue;
				}
				if(nums[i] + nums[j] + nums[k] == 0) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					result.add(temp);
					j++;
					k--;
				}else if(nums[i] + nums[j] + nums[k] < 0) {
					j++;
				}else {
					k--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] S = {-1,0,1,2,-1,-4};
		ThreeSumCloset tsc = new ThreeSumCloset();
		List<List<Integer>> res = tsc.threeSum(S);
		System.out.println(res);
		
		int[] S1 = {-1,2,1,-4};
		int[] S2 = {0,1,2};
		int target = 1;
		int sum = tsc.threeSumCloset(S2, 3);
		System.out.println(sum);
	}
	public int threeSumClosest1(int[] nums, int target) {
        if(nums == null || nums.length < 3) { return 0; }
		int sum = nums[0] + nums[1] + nums[nums.length-1];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			int j = i+1, k = nums.length-1, temp = 0;
			while(j < k) {
				temp = nums[i] + nums[j] + nums[k];
				if(Math.abs(target-temp) < Math.abs(target-sum)){
					sum = temp;
				}
				if(temp == target) {
				    return sum;
				}else if(temp < target) {
					j++;
				}else {
					k--;
				}
			}
		}
		return sum;
    }
}
