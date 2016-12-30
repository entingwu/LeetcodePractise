package ood;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer>{
	private Iterator<Integer> iterator; 
	private Integer cache = null;
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		cache = iterator.next();//可为null
	}
	
	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return cache;
	}
	
	@Override
	public Integer next() {
		Integer current = cache;
		if(iterator.hasNext()) {
			cache = iterator.next();
		}else {
			cache = null;
		}
		return current;
	}
	
	@Override
	public boolean hasNext() {
		return cache != null;
	}

	@Override
	public void remove() {}
	
	public static void main(String[] args) {
		List<Integer> peekList = new ArrayList<Integer>();
		peekList.add(1); peekList.add(2); peekList.add(3);
		PeekingIterator pi = new PeekingIterator(peekList.iterator());
		System.out.println(pi.next());
		System.out.println(pi.peek());
		System.out.println(pi.next());
		System.out.println(pi.next());
		System.out.println(pi.hasNext());
		
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> iter = list.iterator();
		if(iter.hasNext()) {
			System.out.println(iter.next());
		}else {
			System.out.println("null");
		}

	}

}
