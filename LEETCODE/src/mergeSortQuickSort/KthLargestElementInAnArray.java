package mergeSortQuickSort;

public class KthLargestElementInAnArray {
	
	public int findKthLargest(int[] nums, int k) {
        int n = nums.length-1;
        return quickSelect(nums, k, 0, n);
        //quickSort(nums, 0, n);
        //return nums[n-k+1];
    }
    //O(n)
    private int quickSelect(int[] nums, int k, int start, int end) {
        int pivotPos = partition(nums, start, end);
        int pivotDesRank = end - pivotPos + 1;
        if(pivotDesRank == k) {
            return nums[pivotPos];
        }else if(pivotDesRank < k) {
            return quickSelect(nums, k-pivotDesRank, start, pivotPos - 1);
        }else {//pivotDesRank > k,right
            return quickSelect(nums, k, pivotPos + 1, end);
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int curr = start;
        int i = start - 1;
        int pivot = nums[end];
        while(curr < end) {
            if(nums[curr] <= pivot) {
                i++;
                swap(nums, curr, i);
            }
            curr++;
        }
        swap(nums, curr, i+1);
        return i+1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    /* O(nlogn) */
    /*private void quickSort(int[] nums, int start, int end) {
        if(start > end) { return; }
        int pivotPos = partition(nums, start, end);
        quickSort(nums, start, pivotPos - 1);
        quickSort(nums, pivotPos + 1, end);
    }*/
	
	public int findKthLargest1(int[] nums, int k) {
		if(nums == null || nums.length == 0) { return 0; }
		if(k == 0) { return 0; }
		int[] result = quickSort(nums, 0, nums.length-1);
		return result[nums.length - k];
	}
	
	private int[] quickSort(int[] nums, int left, int right) {
		int i = left, j = right;
		int pivot = nums[left + (right - left) / 2];
		if(left >= right) { return nums; }
		while(i<=j) {
			while(i<=j && nums[i] < pivot) {
				i++;
			}
			while(i<=j && nums[j] > pivot) {
				j--;
			}
			if(i<=j){
				swap(nums, i, j);
				i++;
				j--;
			}
		}
		quickSort(nums, left, j);
		quickSort(nums, i, right);
		return nums;
	}
	
	public static void main(String[] args) {
		int[] A = {3,2,1,5,6,4};
		KthLargestElementInAnArray kle = new KthLargestElementInAnArray();
		int kth = kle.findKthLargest(A, 2);
		for(int i : A){
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(kth + " ");
	}

}
