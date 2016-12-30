package sorting_chapter1;

public class CountingSort {

	public int[] countingSort(int[] A, int max) {
		int[] C = new int[A.length];
		int[] B = new int[max + 1];
		if(A == null || A.length==0) { return C; }
		/* 1. count times */
		for(int i = 0; i < A.length; i++) {//0 3 1 3 1 2
			B[A[i]]++;
		}
		/* 2. count last index of digit */
		for(int i = 1; i < B.length; i++) {//0 3 4 7 8 10
			B[i] = B[i-1] + B[i];
		}
		/* 3. place in new array */
		for(int i = C.length-1; i>=0; i--) {
			C[B[A[i]]-1] = A[i];
			B[A[i]]--;
		}
		return C;
	}
	
	public int query(int[] A, int max, int a, int b) {
		int[] B = new int[max+1];
		int[] C = new int[max+1];
		int rangeNum = 0;
		for(int i = 0; i < A.length; i++) {
			B[A[i]]++;
		}
		C[0] = B[0];
		for(int i = 1; i < B.length; i++) {
			C[i] = B[i] + C[i-1];
		}
		rangeNum = C[b]-C[a]+B[a];
		return rangeNum;
	}
	
	public static void main(String[] args) {
		int[] A = {1,4,3,2,1,5,1,3,5,3};
		int[] P6 = {6,0,2,0,1,3,4,6,1,3,2};
		int k = 5;//1<=k<=5
		CountingSort cs = new CountingSort();
		int[] result = cs.countingSort(P6, 6);
		for(int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

		int max = 6;
		int a = 3, b = 5;
		System.out.println(cs.query(P6, max, a, b));
	}

}
