package queueStack;

import java.util.HashMap;

public class LRUcache {
	
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}
	
	private int capacity;
	//HashMap : key, Node, to check whether Node is already in the doubly linked list
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-1, -1);
	public LRUcache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
	}
	
	private void movetoTail(Node current) {
		current.prev = tail.prev;//prev
		tail.prev = current;
		current.prev.next = current;//next
		current.next = tail;
	}
	
	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}
		/* 1. remove current */
		Node current = map.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		/* 2. add to tail */
		movetoTail(current);
		return map.get(key).value;
	}
	
	public void set(int key, int value) {
		/* 1. LRU contains key */
		if(get(key) != -1) {
			//map.put(key, new Node(key, value)); mistake
			map.get(key).value = value;
			return;
		}
		/* 2. LRU capacity is full */
		if(map.size() == capacity) {
			map.remove(head.next.key);//mistake
			head.next = head.next.next;
			head.next.prev = head;
		}
		/* 3. LRU does not contain key */
		Node insert = new Node(key, value);
		map.put(key, insert);//mistake
		movetoTail(insert);
	}
	
	public static void main(String[] args) {
		LRUcache lru = new LRUcache(2048);
		lru.set(1178, 3401);
	}

}
