package ood;

import java.util.ArrayList;
import java.util.List;

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class Vector2D {
	
	private List<Integer> list;
	private int curr = 0;
	private int size = 0;
	
	public Vector2D(List<List<Integer>> vec2d) {
		list = new ArrayList<Integer>();
		for(int i = 0; i < vec2d.size(); i++) {
			List<Integer> row = vec2d.get(i);
			for(int j = 0; j < row.size(); j++) {
				list.add(row.get(j));
			}
		}
		size = list.size();
	}
	
	public int next() {
		int next = list.get(curr);
		curr++;
		size--;
		return next;
	}
	
	public boolean hasNext() {
		return size > 0;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
		List<Integer> r1 = new ArrayList<Integer>();
		r1.add(1); r1.add(2);
		vec2d.add(r1);
		List<Integer> r2 = new ArrayList<Integer>();
		r2.add(3);
		vec2d.add(r2);
		List<Integer> r3 = new ArrayList<Integer>();
		r3.add(4); r3.add(5); r3.add(6);
		vec2d.add(r3);
		
		
		Vector2D i = new Vector2D(vec2d);
		while(i.hasNext()) {
			System.out.print(i.next() + " ");
		}
	}

}
