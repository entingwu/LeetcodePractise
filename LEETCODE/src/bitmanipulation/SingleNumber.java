package bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		//A XOR A = 0
		//(2^1^4^5^2^4^1) => ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5
		if(nums == null || nums.length == 0) { return -1; }
		int single = 0;
		for(int i = 0; i < nums.length; i++) {
			single = nums[i] ^ single;
		}
		return single;
	}
	/* BINARY SERACH */
	public int singleNumberBS(int[] nums) {//O(nlogn+logn)
		if(nums == null || nums.length == 0) { return -1; }
		Arrays.sort(nums);
		int start = 0, end = nums.length-1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(nums[mid] == nums[mid+1]) {
				start = mid;
			}else if(nums[mid] == nums[mid-1]) {
				end = mid;
			}
		}
		return nums[end+1];
	}
	
	/* SINGLE NUMBER II 
	 * 除了一个数字以外，其他的都出现了3次，如果我们把那个特殊的数剔除，并把剩下的数于每一位来加和的话，每一位上1出现的次数必然都是3的倍数。
	 * 所以，解法就在这里，将每一位数字分解到32个bit上，统计每一个bit上1出现的次数。最后对于每一个bit上1出现的个数对3取模，剩下的就是结果。*/
	public int singleNumberII(int[] nums) {
        int[] bit = new int[32];
        for(int i = 0; i < nums.length; i++) {
        	for(int j = 0; j < 32; j++) {
        		int rotated = nums[i]>>j;//取出从右到左第j位的数字,rotated还是一个数，不是位
        		if(rotated == 0) { //取完所有数位，退出循环,i++
        			break; 
        		}
        		bit[j] += rotated & 1;//取出rightmost一位
        	}
        }
		int result = 0;
		for(int i = 0; i < 32; i++) {
			result += ((bit[i] % 3) << i);//取模，从二进制变成十进制
		}
		return result;
    }
	
	
	public static void main(String[] args) {
		SingleNumber sn = new SingleNumber();
		int[] nums = {0,1,2,1,2};
		System.out.println(sn.singleNumber(nums));

	}

}
