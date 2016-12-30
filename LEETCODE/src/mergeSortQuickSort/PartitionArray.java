package mergeSortQuickSort;

public class PartitionArray {
	
	public int partitionArray(int[] nums, int k) {
		if(nums == null || nums.length == 0) { return 0; }
	    int pivot_pos = partitionHelper(nums, k);
	    int end = nums.length-1;
	    if(pivot_pos == end && nums[end] < k) {
	    	return pivot_pos+1;
	    }
	    return pivot_pos;
	}
	
	private int partitionHelper(int[] nums, int k) {
	   int pivot = k;
	   int i = -1;
	   int curr = 0;
	   while(curr < nums.length-1) {
	       if(nums[curr] <= pivot) {
	           i++;
	           swap(nums, i, curr);
	       }
	       curr++;
	   }
	   swap(nums, i+1, curr); 
	   return i+1;
	}
	
	private void swap(int[] nums, int i, int j) {
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {7,7,9,8,6,6,8,7,9,8,6,6};
		int[] nums1 = {3,2,3,3,2,1};
		PartitionArray pa = new PartitionArray();
		int k = 10;
		int result = pa.partitionArray(nums1, 2);
		System.out.println(result);
	}

}
