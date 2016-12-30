package hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0) { return false; }
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) {
				return false;
			}
			set.add(nums[i]);
		}
		return true;
	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2) { return false; }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//value, index
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		int j = map.get(nums[i]);
        		if(i - j <= k) {
        			return true;
        		}
        		map.put(nums[i], i);//求最新相同值的间隔，更新
        	}else {
        		map.put(nums[i], i);
        	}
        }
        return false;
    }
	
	public static void main(String[] args) {
		

	}

}
