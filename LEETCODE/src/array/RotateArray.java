package array;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length == 0) { return; }
		int len = nums.length;
		k = k % len;//防k大于数组长度，导致越界
		reverse(nums, 0, len-1-k);//左半边含k
		reverse(nums, len-k, len-1);//右半边
		reverse(nums, 0, len-1);//total
	}
	
	private void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		int k = 3;
		RotateArray ra = new RotateArray();
		ra.rotate(array, k);
		for(int i : array) {
			System.out.print(i + " ");
		}
	}

}
