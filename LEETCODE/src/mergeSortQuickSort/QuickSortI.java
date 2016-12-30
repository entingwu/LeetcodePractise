package mergeSortQuickSort;

public class QuickSortI {
	
	public void sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
	private void quickSort(int[] nums, int start, int end) {
		int pivot_pos = partition(nums, start, end);
		quickSort(nums, start, pivot_pos - 1);
		quickSort(nums, pivot_pos + 1, end);
	}
	
	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int curr = start;
		int i = start - 1;
		while(curr < end) {
			if (nums[curr] <= pivot) {
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
		int[] A = {3,2,1,4,5};
		QuickSort qs = new QuickSort();
		qs.sort(A);
		for(int i : A){
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
