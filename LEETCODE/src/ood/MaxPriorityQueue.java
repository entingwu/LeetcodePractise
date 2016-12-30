package ood;

public class MaxPriorityQueue<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N = 0;
	
	/** 0. CONSTRUCTOR */
	public MaxPriorityQueue(int capacity) {
		pq = (Key[])new Comparable[capacity + 1];
	}
	
	/** 1. INSERT : O(lgN)
	 *  Add node at end, then swim it up*/
	public void insert(Key k) {
		N++;
		pq[N] = k;
		swim(N);
	}
	/* Promotion :
	 * parent of node at k is at k/2 */
	private void swim(int k) {
		while(k>1 && less(k/2, k)) {//pq[k]父 < pq[k/2]子
			swap(pq, k/2, k);
			k = k/2;//往上游
		}
	}
	
	/** 2. DELETE MAX : O(lgN)
	 *  Exchange root with node at end, then sink it down */
	public Key delMax() {
		Key max = pq[1];
		swap(pq, 1, N);
		N--;//remove node from heap
		sink(pq, 1, N);//sink down
		pq[N+1] = null;
		return max;
	}
	/* Demotion in a heap 
	 * Exchange key in parent with key in larger child
	 * Repeat until heap order restored */
	private void sink(Key[] pq, int k, int N) {//index
		while(2*k <= N) {//k==1 (top)
			int j = 2*k;
			if(j<N && less(j,j+1)) {//选出pq[j]与pq[j+1]中较大者
				j++;
			}
			if(!less(k,j)) { break; }//pq[k] > pq[j]已符合要求
			swap(pq, k, j);
			k = j;//往下沉
		}
	}
	
	/** 3. HELPER */	
	/* 判断pq[i]是否小于pq[j] */
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
	
	/* swap pq[i] <==> pq[j] */
	private void swap(Key[] pq, int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}
	public boolean isEmpty() { 
		return N == 0; 
	}
	public void print() {
		for(Key k : pq) {
			System.out.print(k + " ");
		}
	}
	
	/** 4. SORT */
	public void sort(Key[] pq) {
		int N = pq.length;
		/* 1.Build heap */
		for(int k = N/2; k>=1; k--) {
			sink(pq, k, N);
		}
		/* 2.Remove max */
		while(N>1) {
			swap(pq, 1, N);
			N--;
			sink(pq, 1, N);
		}
	}
	
	public static void main(String[] args) {
		MaxPriorityQueue<Character> pq = new MaxPriorityQueue<Character>(3);
		pq.insert('E');
		pq.insert('T');
		pq.insert('W');
		pq.print();
		
		MaxPriorityQueue<Integer> pq1 = new MaxPriorityQueue<Integer>(9);
		pq1.insert(5); pq1.insert(3); pq1.insert(17);
		pq1.insert(10); pq1.insert(84); pq1.insert(19);
		pq1.insert(6); pq1.insert(22); pq1.insert(9);
		pq1.print();
		

	}

}
