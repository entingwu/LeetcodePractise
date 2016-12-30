package sorting_chapter1;

public class findKsmallestElement {

	public static int findKthSmallest(int[] nums, int k) {
		return quickSelect(nums, k, 0, nums.length-1);
	}
	
	private static int quickSelect(int[] nums, int k, int start, int end) {
		int pivot_pos = partition(nums, start, end);
		int pivot_rank = pivot_pos - start + 1;
		if(pivot_rank == k) {
			return nums[pivot_pos];
		}else if(pivot_rank > k) {
			return quickSelect(nums, k, start, pivot_pos-1);
		}else {// pivot_rank < k
			return quickSelect(nums, k-pivot_rank, pivot_pos+1, end);
		}
	}
	
	private static int partition(int[] nums, int start, int end) {
		int i = start-1;
		int curr = start;
		int pivot = nums[end];
		while(curr < end) {
			if(nums[curr] <= pivot) {
				i++;
				swap(nums, i, curr);
			}
			curr++;
		}
		swap(nums, i+1, curr);//pivot
		return i+1;
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {5,6,4,8,2,9,1};
		int k = 3;
		int result = findKthSmallest(nums, k);
		System.out.println(result);
	}

}
