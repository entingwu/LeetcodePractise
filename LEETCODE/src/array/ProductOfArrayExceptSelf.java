package array;

public class ProductOfArrayExceptSelf {
	/* 要获得一个数对应的除自己以外的所有数的乘积，可以分为2部分：
	   1. 获得该数左侧所有数的乘积。
	   2. 获得该数右侧所有数的乘积。
	      然后将这2部分相乘即可。
	   假设我们要返回的数组名为res。在第1次遍历中，res[i] = nums[i - 1] * res[i - 1]，此时res储存的是每个位置对应的左侧所有数的乘积。
	   之后我们再倒序遍历一遍，用一个整数right记录当前位置右侧所有数的乘积，然后将right乘到res的相应元素即可。
	 * */
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] result = new int[len];
        if(nums == null || nums.length == 0) { return result; }
        result[0] = 1;
        /* nums    		1  2  3  4 
         * result  		1  1  2  6
         * right   		24 12 4  1
         * result*right 24 12 8  6*/
        for(int i = 1; i < len; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for(int i = len - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
	
	public static void main(String[] args) {
		

	}

}
