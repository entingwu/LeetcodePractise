package sorting_chapter1;

public class MergeSort {

	public static void mergeSort(int[] A) {
		int[] tmp = new int[A.length];
		sort(A, tmp, 0, A.length-1);
	}
	
	/* 1. sort : 分割数组进行merge */
	private static void sort(int[] A, int[] tmp, int left, int right) {
		if(left >= right) { return; }
		int mid = left + (right - left) / 2;
		sort(A, tmp, left, mid);
		sort(A, tmp, mid+1, right);
		merge(A, tmp, left, mid+1, right);
	} 
	
	/* 2. merge */
	private static void merge(int[] A, int[] tmp, int left, int right, int rightEnd) {//Comparable[] a
		//1. A[left, leftEnd]  
		//2. A[right, rightEnd]
		//3. tmp[left, rightEnd]
		int leftEnd = right-1;
		int k = left;
		int num = rightEnd - left + 1;
		
		while(left <= leftEnd && right <= rightEnd) {//a[left].compareTo(a[right]) <= 0
			if(A[left] < A[right]) {
				tmp[k++] = A[left++];
			}else {
				tmp[k++] = A[right++];
			}
		}
		
		while(left <= leftEnd) {// Copy rest of first half
			tmp[k++] = A[left++];
		}
		while(right <= rightEnd) {// Copy rest of right half
			tmp[k++] = A[right++];
		}
		
		for(int i = 0; i < num; i++, rightEnd--) {
			A[rightEnd] = tmp[rightEnd];
		}
	}
	
	public static void main(String[] args) {
		int [] a = {6,4,5,1,7,2,4,3,4,8};
		for(int n : a) {
			System.out.print(n+" ");
		}
		System.out.println();
		mergeSort(a);
		for(int n : a) {
			System.out.print(n+" ");
		}
	}

}
