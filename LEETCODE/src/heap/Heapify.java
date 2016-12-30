package heap;

/** MINHEAP */
public class Heapify {
	public void heapify(int[] A) {
		int N = A.length-1;
		for(int i = N/2; i>=0; i--) {
			sink(A, i, N);
		}
	}
	private void sink(int[] A, int i, int N) {
		while(2*i <= N) {//i父 j子
			int j = 2*i;
			if(j < N && (A[j+1] < A[j])) { j++; }
			if(A[i] < A[j]) { break; }
			swap(A, i, j);
			i = j;
		}
	}
	private void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] test = {3,2,1,4,5};
		Heapify pq = new Heapify();
		pq.heapify(test);
		for(int i : test) {
			System.out.print(i + " ");
		}
	}

}
