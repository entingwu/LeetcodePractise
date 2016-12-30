package twoPointer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/*Two Pointers : in order*/
	public int[] twoSum1(int[] nums, int target) {
		if(nums == null || nums.length == 0) { return null;}
		int[] result = new int[2];
		int i = 0, j = nums.length - 1;
		while(i <= j && i < nums.length && j >= 0) {
			if(nums[i] + nums[j] == target) {
				break;
			}else if(nums[i] + nums[j] < target) {
				i++;
			}else {
				j--;
			}
		}
		result[0] = i + 1;
		result[1] = j + 1;
		return result;
	}
		
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				result[0] = map.get(nums[i]);
				result[1] = i + 1;
				break;
			} else {
				map.put(target - nums[i], i + 1); 
			}
		}
		return result;
	}
	
	/* Two Sum III */
	HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //number,times
	public void add(int number) {
		if(map.containsKey(number)) {
			int preTimes = map.get(number);
			map.put(number, preTimes + 1);
		}else {
			map.put(number, 1);
		}
	}
	
	public boolean find(int value) {
		for(int i : map.keySet()) {//every number
			if(map.containsKey(value - i)) {//target - number
				if(value - i != i) {//当target - number != i时，尽管hashmap只有一个值，但肯定不是自己
					return true;
				}
				if(value - i == i && map.get(i) >= 2) {//当target - number == i时，防止hashmap搜到的是自己 
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		//int[] numbers = {3,2,4};
		int[] numbers = {2,7,11,15};
		//int[] numbers = {0,4,3,0};
		int target = 9;
		TwoSum ts = new TwoSum();
		int[] result = ts.twoSum(numbers, target);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		ts.add(0);
		System.out.println(ts.find(0));
	}
}
