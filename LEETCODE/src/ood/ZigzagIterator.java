package ood;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
	/**
	 * Your ZigzagIterator object will be instantiated and called as such:
	 * ZigzagIterator i = new ZigzagIterator(v1, v2);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	private List<Iterator<Integer>> iters;
	int count = 0;//v1/v2
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		iters = new ArrayList<Iterator<Integer>>();
		if(!v1.isEmpty()) { iters.add(v1.iterator()); }
		if(!v2.isEmpty()) { iters.add(v2.iterator()); }
	}
	
	public int next() {
		Iterator poll = iters.remove(0);
		int num = (Integer)poll.next();
		if(poll.hasNext()) { iters.add(poll); }
		return num;
	}

	public boolean hasNext() {
		return iters.size() != 0;
	}
	
	public int nextI() {
		Iterator it = iters.get(count);
		int num = (Integer)it.next();
		
		if(it.hasNext()) { count++; }
		else { iters.remove(count); }
		
		if(iters.size() != 0) { 
			count = count % iters.size();
		}
		return num;
	}
	
	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<Integer>();
		v1.add(1); v1.add(2);
		List<Integer> v2 = new ArrayList<Integer>();
		v2.add(3); v2.add(4); v2.add(5); v2.add(6);
		
		Iterator<Integer> iter1 = v1.iterator();
		while(iter1.hasNext()) {
			System.out.print(iter1.next()+ " ");
		}
		System.out.println();
		
		ZigzagIterator zi = new ZigzagIterator(v1,v2);
		while(zi.hasNext()) {
			System.out.print(zi.next() + " ");
		}
	}
	
	

}
