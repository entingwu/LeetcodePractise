package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
//import java.util.PriorityQueue;
import java.util.Queue;


public class PriorityFFQueue {

	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
		public int compare(ListNode left, ListNode right){
			if(left == null){
				return 1;
			}else if(right == null){
				return -1;
			}
			return left.value - right.value;
		}
	};

	
	private void abc() {
		PriorityQueue pq1 = new PriorityQueue<Integer>();
	}
	
	public static void main(String[] args) {
		
		Comparator<Integer> integerComparator = new Comparator<Integer>(){
			public int compare(Integer num1, Integer num2) {
				/*
				 * if(num1 - num2 > 0) {
				 * 		return 1;
				 * }else if(num1 - num2 < 0) {
				 * 		return -1;
				 * }else {
				 * 		return 0;
				 * }*/
				return num1 - num2;
			}
		};
		PriorityQueue pq1 = new PriorityQueue<Integer>(100, integerComparator);
		pq1.add(10); pq1.add(9); pq1.add(11);
		while (!pq1.isEmpty()) {
			System.out.print( pq1.poll());
			System.out.print('\n');
		}
		
		
	}

}
