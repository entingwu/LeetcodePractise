package array;

import java.util.HashSet;

public class LongestConsecutiveSequence {
	/* Given [100, 4, 200, 1, 3, 2],
	   The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.*/
	
	/* The basic idea is that,we firstly put all numbers in a hash set. 
     * Then pick one element, remove all the adjacent numbers, say pick 2 and remove 3 4 .... and remove 1, 0 if the
     * array has those values.  Then pick another one, and do the similar steps. 
	 * */
	public int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		int maxLen = 0;
		for(int i = 0; i < nums.length; i++) {//[100, 4, 200, 1, 3, 2]
			set.add(nums[i]);
		}
		for(int i = 0; i < nums.length; i++) {
			if(set.contains(nums[i])) {//100  4  200  1  3
				int count = 1;//consecutive length
				int target = nums[i];//center : 100	4 200 1  3
				int increase = target;//100	4 200 1 3
				int decrease = target;//100	4 200 1 3
				/* 1. Backward */
				increase++;//101  5  201  2  4
				while(set.contains(increase)) {//2 3 4
					count++;//2->3->4
					set.remove(increase);//remove:2, 3, 4,remove:4	
					increase++;//3 4 5
				}
				/* 2. Forward */
				decrease--;//99	3 199 0 2
				while(set.contains(decrease)) {//2
					count++;//3
					set.remove(decrease);//remove:2
					decrease--;//1
				}
				maxLen = Math.max(count, maxLen);//1  2  4
			}
		}
		return maxLen;
    }
	
	public static void main(String[] args) {
		int[] num = {100, 4, 200, 1, 3, 2};
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.println(lcs.longestConsecutive(num));
	}

}
