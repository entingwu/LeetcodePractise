package mergeSortQuickSort;

public class mergeSort {
	public void sort(int[] A) {
		//quickSort(A, 0, A.length-1);
	}
	public void mergeSort(int[] A, int[] temp, int left, int right) {
		if(left >= right) { return; }
		int middle = left + (right - left) / 2;
		mergeSort(A, temp, left, middle);
		mergeSort(A, temp, middle + 1, right);
		merge(A, temp, left, middle, right);
	}
	
	private void merge(int[]A, int[] temp, int left, int middle, int right) {
		//int[] temp = new int[right - left + 1];
		int i = left, j = middle + 1;
		for(int k = 0; k < right - left + 1; k++) {
			//放左半边的数
			if(i <= middle && (j > right || A[i] <= A[j])){
				temp[k] = A[i];
				i++;
			} else{
				temp[k] = A[j];
				j++;
			}
		}
		
		for(int k = 0; k< right - left + 1; ++k) {
				A[k + left] = temp[k];
		}
	}
	
	public static void main(String[] args) {
		int [] a = {6,4,5,1,7,2,4,3,4,8};
		for(int n : a) {
			System.out.println(n);
		}
		
	}

}
