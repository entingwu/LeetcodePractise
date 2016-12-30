package sorting_chapter1;

public class MaxHeap {

	/* 1. MAKE MIN HEAP 
	 *    0-based-heap : parent=(i-1)/2 , 
	 *    left child = 2*i+1, right child = 2*i+2 */
	private void makeHeap(int[] nums) {
		int n = nums.length;
		for(int i = (n-1)/2; i >= 0; i--) {
			heapify(nums, i);
		}
	}
	
	/* 2. HEAPIFY 
	 *    sift-down : parent->children*/
	public void heapify(int[] nums, int i) {
		int max_index = i;
		int n = nums.length;
		if(2*i+1 < n && nums[2*i+1]>nums[max_index]) {//下面小于上面
			max_index = 2*i+1;
		}
		if(2*i+2 < n && nums[2*i+2]>nums[max_index]) {
			max_index = 2*i+2;
		}
		if(max_index != i) {
			swap(nums,i, max_index);
			heapify(nums, max_index);
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {5,3,17,10,84,19,6,22,9};
		MaxHeap mh = new MaxHeap();
		mh.makeHeap(array);
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();

	}

}
