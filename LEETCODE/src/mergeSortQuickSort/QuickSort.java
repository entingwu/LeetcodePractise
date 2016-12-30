package mergeSortQuickSort;

public class QuickSort {
	public void sort(int[] A) {
		quickSort(A, 0, A.length-1);
	}
	public void quickSort(int[] A, int left, int right ) {
		if(left >= right) { return; }
		int pivot = A[left + (right - left) / 2];
		int i = left, j = right;
		while(i <= j) {//等于pivot不用挪
			while(i<=j && A[i] < pivot) {
				i++;
			}
			while(i<=j && A[j] > pivot) {
				j--;
			}
			if(i<=j) {
				swap(A,i,j);
				i++;
				j--;
			}
		}
		quickSort(A, left, j);
		quickSort(A, right, i);
	}
	
	private void swap(int[] A,int i,int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
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
