package array;

public class FirstMissingNumber {
	/**
	 *  Q: 寻找数组中第一个未出现的正整数，题目本身比较常见，关键在于题目要求只能使用常数额外空间。
	 *  A: 虽然不能再另外开辟非常数级的额外空间，但是可以在输入数组上就地进行swap操作。
		   思路：交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。
		   3   4  -1  1
		   -1  4   3  1
		   -1  1   3  4
		   1  -1   3  4
	 */
	
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		int i = 0;
        while(i < n) {
        	if(nums[i]!=i+1 && nums[i]>=1 && nums[i]<=n && nums[nums[i]-1]!= nums[i]) {
        		/* 1. nums[i]!=i+1没有归位 
        		 * 2. nums[nums[i]-1]!= nums[i] 不相等才需要换，不然死循环*/
        		swap(nums, i, nums[i]-1);
        	}else {
        		i++;
        	}
        }
        for(i = 0; i < n; i++) {
        	if(nums[i]!=i+1) {//index+1才为第几个要返回
        		return i+1;
        	}
        }
        return n+1;
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] test = {0,1,2};
		FirstMissingNumber fmn = new FirstMissingNumber();
		int result = fmn.firstMissingPositive(test);
		System.out.println(result);
	}

}
