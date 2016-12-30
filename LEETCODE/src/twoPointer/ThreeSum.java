package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
	
	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0) { return result; }
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++) {
			if(i != 0 && nums[i] == nums[i - 1]) { 
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
			int start = i + 1, end = nums.length - 1;
			while(start < end) {
				if(start != i + 1 && nums[start] == nums[start - 1]) { 
					start++;
					continue; 
				}
				if(end != nums.length - 1 && nums[end] == nums[end + 1]) {
					end--;
					continue;
				}
				if(nums[start] + nums[end] + nums[i]< 0) {
					start++;
				}else if(nums[start] + nums[end] + nums[i] > 0) {
					end--;
				}else {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(nums[i]);
					temp.add(nums[start]);
					temp.add(nums[end]);
					result.add(temp);
					start++;
					end--;
				}
			}
		}
		return result;
	}
	
	public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) { return 0; }
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {//1
            int start = i+1, end = nums.length-1;//2,3
            while(start < end) {
                if(nums[start] + nums[end] + nums[i] >= target) {
                    end--;
                }else {
                	/* [-2,0,1,3], nums[start] = 0, nums[end] = 3 
                	 * -2 0 3 < target, 则 -2 0 1 < target, 这样的数对有(end - start)个 */
                    sum += end - start;
                    start++;
                }
            }
        }
        return sum;
    }
	
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Arrays.sort(nums);
		int[] res = new int[3]; 
		for(int i = 0; i < nums.length; i++){
			List<Integer> temp = new ArrayList<Integer>();
			int target = 0 - nums[i];
			for(int j = 0; j != i && j < nums.length - 1; j++) {
				if(map.containsKey(nums[j])) {
					temp.add(Integer.valueOf(nums[i]));
					temp.add(Integer.valueOf(nums[j]));
					temp.add(Integer.valueOf(target - nums[j]));
					break;
				} else {
					map.put(target - nums[j], j);
				}
			}
			if(temp.size() != 0 && temp != null) {
				result.add(temp);
			}	
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] time = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,
		              -15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,
		              11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,
		              -6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,
		              -3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,
		              6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		
		int[] S = {-2,0,1,1,2};
		//int[] S = {-1,0,1,2,-1,-4};
		//int[] S = {0,0,0,0};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> result = ts.threeSum(time);
		//System.out.println(result);
		
		int[] smaller = {3,1,0,-2};
		int[] smaller1 = {2,0,0,2,-2};
		int target = 2;
		int num = ts.threeSumSmaller(smaller1, target);
		System.out.println(num);
	}

}
