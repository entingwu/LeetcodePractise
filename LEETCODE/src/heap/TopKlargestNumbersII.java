package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKlargestNumbersII {
	
	private Queue<Integer> pq;
	private int maxSize;
    public TopKlargestNumbersII(int k) {
        maxSize = k;
        pq = new PriorityQueue<Integer>();
    }

    public void add(int num) {
        if (pq.size() < maxSize) {
        	pq.offer(num);
        } else {
        	if (num > pq.peek()) {//num > min ? 
        		pq.poll();
        		pq.offer(num);
        	}
        }
    }

    public List<Integer> topk() {
    	Iterator iter = pq.iterator();
        List<Integer> result = new ArrayList<Integer>();
        while(iter.hasNext()) {
        	result.add((Integer) iter.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
    
	public static void main(String[] args) {
		TopKlargestNumbersII tln = new TopKlargestNumbersII(3);
		tln.add(3);
		tln.add(10);
		System.out.println(tln.topk());
		tln.add(1000);
		tln.add(-99);
		System.out.println(tln.topk());
	}

}
