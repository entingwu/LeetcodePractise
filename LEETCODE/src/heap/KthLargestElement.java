package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	Comparator<Integer> comparator = new Comparator<Integer>(){
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
	};
	
	
	public int kthLargestElement(int k, int[][] nums) {
		Queue<Integer> heap = new PriorityQueue<Integer>(nums.length, comparator);
		for(int i = 0; i < nums.length; i++) {
			heap.add(nums[i][0]);
		}
		int index = 0, result = 0;
		while(!heap.isEmpty()) {
			result = heap.poll();
			index++;
			if(index == k) { 
				break; 
			}
			
		}
		return result;
		
	}
	
	public static void main(String[] args) {
		int[][] nums = new int[4][4];
		nums[0][0] = 5; nums[0][1] = 3; nums[0][2] = 2; nums[0][3] = 1;
		nums[1][0] = 10; nums[1][1] = 9; nums[1][2] = 8; nums[1][3] = 1;
		nums[2][0] = 8; nums[2][1] = 9; nums[2][2] = 1; nums[2][3] = 4;
		nums[3][0] = 12; nums[3][1] = 3; nums[3][2] = 6; nums[3][3] = 7;

		
		
		
	}

}
