package mergeSortQuickSort;

public class SortColors {
	/**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
	/* 1. COUNTING SORT */
	public void sortColor1(int[] nums) {
		int[] B = new int[3];
		int[] C = new int[nums.length];
		//1
		for(int i = 0; i < nums.length; i++) {//0:4, 1:3, 2:6
			B[nums[i]]++; 
		}
		//2
		for(int i = 1; i < B.length; i++) {
			B[i] = B[i-1] + B[i];
		}
		//3
		for(int i = 0; i < C.length; i++) {
			C[B[nums[i]] - 1] = nums[i];  
			B[nums[i]]--;
		}
		//copy
		for(int i = 0; i < nums.length; i++) {
			nums[i] = C[i];
		}
	}
	
	/* 2. QUICK SORT */
	public void sortColor(int[] nums) {
		partition(nums, 0);
		partition(nums, 1);
	}
	private void partition(int[] nums, int pivot) {
		int i = 0, j = nums.length - 1;
		while(i<=j) {
			while(i<=j && nums[i] <= pivot) {
				i++;
			}
			while(i<=j && nums[j] > pivot) {
				j--;
			}
			if(i<=j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
	}

	public static void main(String[] args) {
		int[] A = {2,0,2,2,1,2,2,1,2,0,0,0,1};
		SortColors cs = new SortColors();
		cs.sortColor1(A);
		for(int i : A){
			System.out.print(i + " ");
		}
		System.out.println();

	}

}
