package sorting_chapter1;

public class QuickSortSelect {

	public void quickSort(int[] nums, int start, int end) {//recursion interface
		/* 1. base case */
		int n = end - start + 1;
		if(n < 2) { return; }//quickSort(nums,5,4); ==> 4-5+1=0
		
		/* 2. recursion : partition has divided the array for two parts, T(n) = 2*T(n/2) + n */
		int pivot_pos = partition(nums, start, end);
		quickSort(nums, start, pivot_pos - 1);
		quickSort(nums, pivot_pos + 1, end);
	}
	
	private int partition(int[] nums, int start, int end) {
		int pivot = nums[end];
		int i = start - 1;//i选比pivot大的数。
		int curr = start;//curr选比pivot小的数
		/* 1. nums[curr]<pivot<nums[i]时, swap使得小的数到数列前面，大的数沉到后面 */
		while(curr < end) {
			if(nums[curr] <= pivot) {
				i++;//-1
				swap(nums, i, curr);
			}
			curr++;
		}
		/* 2. move pivot to right place: <pivot pivot >pivot */
		swap(nums, i+1, curr);//i++
		return i+1;//pivot_pos is at i+1;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] array = {13,21,3,0,7,99,10};
		int[] array2 = {13,19,9,5,12,8,7,4,11,2,6,21};
		QuickSortSelect qss = new QuickSortSelect();
		qss.quickSort(array, 0, array.length-1);
		int pivot2 = qss.partition(array2, 0, array2.length-1);
		System.out.println("pivot " + pivot2);
		for(int i : array2) {
			System.out.print(i + " ");
		}
		System.out.println('\n');
		
		
		int[] array1 = {13,99,15,15,0,21,15};
		qss.partition(array1, 0, array.length-1);
		for(int i : array1) {
			System.out.print(i + " ");
		}
	}

}
