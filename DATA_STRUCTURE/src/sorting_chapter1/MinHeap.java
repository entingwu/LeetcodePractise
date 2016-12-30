package sorting_chapter1;

public class MinHeap {
	
	private int[] heap;
	private int n = 0;
	
	public MinHeap(int capacity) {
		n = capacity;
		heap = new int[n+1];
	}
	
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
		int min_index = i;
		int n = nums.length;
		if(2*i+1 < n && nums[2*i+1]<nums[min_index]) {//下面小于上面
			min_index = 2*i+1;
		}
		if(2*i+2 < n && nums[2*i+2]<nums[min_index]) {
			min_index = 2*i+2;
		}
		if(min_index != i) {
			swap(nums,i, min_index);
			heapify(nums, min_index);
		}
	}
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	/* 3. HEAP SORT */
	public void heapSort(int[] nums) {
		/* 1 Make Heap*/
		makeHeap(nums);
		/* 2 */
		for(int i = 0; i < nums.length-1; i++) {//0~n-2
			delete_min(nums);
		}
	}
	
	public void delete_min(int[] nums) {
		swap(nums, 0, n-1);
		n--;
		heapify(nums,0);
	}
	
	/* 4. INSERT */
	public void insert(int key) {
		heap[++n] = key;
		swim(n);
	}
	
	private void swim(int k) {//children->parent
		while(k>1 && heap[k]<heap[k/2]) {
			swap(heap,k,k/2);
			k = k/2;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {6,18,12,5,17,21};
		MinHeap mh = new MinHeap(array.length);
		mh.makeHeap(array);
		for(int i : array) {
			System.out.print(i+" ");
		}
		System.out.println();
		
	}

}
