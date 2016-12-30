package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {

	private Comparator<Integer> maxHeapComparator = new Comparator<Integer>() {
		public int compare(Integer i, Integer j) { return j-i; }
	};
	private Queue<Integer> maxHeap = new PriorityQueue<Integer>(1000, maxHeapComparator);
	private Queue<Integer> minHeap = new PriorityQueue<Integer>();
	
	// Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.offer(num);
        int n = minHeap.poll();//把最小值移到左边
        maxHeap.offer(n);
        int lenMax = maxHeap.size();//左小
        int lenMin = minHeap.size();//右大
        if(lenMax > lenMin) {//左堆大小等于右堆，不用做。左堆大，则把左堆最大值移回右堆
        	int m = maxHeap.poll();
        	minHeap.offer(m);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        double median = 0;
    	int lenMax = maxHeap.size();
        int lenMin = minHeap.size();
        if(lenMax == lenMin) {
        	median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        }else if(lenMax > lenMin) {
        	median = maxHeap.peek();
        }else {
        	median = minHeap.peek();
        }
        return median;
    }
	
	public static void main(String[] args) {
		FindMedianFromDataStream fm = new FindMedianFromDataStream();
		fm.addNum(1);
		fm.addNum(2);
		System.out.println(fm.findMedian());
		fm.addNum(3);
		System.out.println(fm.findMedian());
	}

}
