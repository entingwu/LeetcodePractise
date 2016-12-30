package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
		if(nums == null || nums.length == 0) { return result; }
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 3; i++) {
			if(i != 0 && nums[i] == nums[i-1]) { continue; }
			for(int j = i + 1; j < nums.length -2 ; j++) {
				if(j != i + 1 && nums[j] == nums[j-1]) { continue; }
				int start = j + 1, end = nums.length-1;
				while(start < end) {
					if(start != j + 1 && nums[start] == nums[start-1]) {
						start++; 
						continue;
					}
					if(end != nums.length - 1 && nums[end] == nums[end+1]) {
						end--; 
						continue;
					}
					if(nums[i] + nums[j] + nums[start] + nums[end] == 0) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						result.add(new ArrayList(temp));
						start++;
						end--;
					}else if(nums[i] + nums[j] + nums[start] + nums[end] < 0) {
						start++;
					}else{
						end--;
					}
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] S = {1,0,-1,0,-2,2};
		int[] S1 = {-483,-476,-475,-460,-450,-431,-428,-419,-410,-374,-347,-345,-311,-303,
		             -299,-286,-278,-271,-260,-257,-240,-227,-217,-203,-196,-191,-189,-179,
		             -171,-151,-150,-144,-134,-130,-112,-107,-97,-96,-94,-70,-62,-54,-38,
		             -38,-23,-12,-11,-2,2,4,30,33,38,51,51,54,69,90,108,111,112,112,121,129,
		             163,182,184,194,198,199,210,228,229,232,236,237,249,249,259,282,303,312,
		             317,329,329,342,349,368,375,380,384,393,420,433,441,446,460,474,497};
		int target = 0;
		int target1 = -2306;
		FourSum fs = new FourSum();
		List<List<Integer>> result = fs.fourSum(S1, target1);
		System.out.println(result);
	}

}
