package ood;

import java.util.ArrayList;

class Hasher<K,V>{
	/** 1. LinkedListNode class. Used only within hashTable. */
	private static class LinkedListNode<K,V> {/* Implemented by Doubly LinkedList */
		public LinkedListNode<K,V> next;
		public LinkedListNode<K,V> prev;
		public K key;
		public V value;
		public LinkedListNode(K k, V v){//constructor
			this.key = k;
			this.value = v;
		}
	}
	
	/** 2. ArrayList of Doubly LinkedListNode*/
	private ArrayList<LinkedListNode<K,V>> arr;
	
	/** 3. Hasher<K,V> constructor */
	public Hasher(int capacity){
		arr = new ArrayList<LinkedListNode<K,V>>();//create list of LinkedList at a particular size.
		arr.ensureCapacity(capacity);
		for(int i = 0; i < capacity; i++) {//Fill list with null values.
			arr.add(null);
		}
	}
	
	/** 4. Get Method */
	/*  4.1 Get value from key */
	public V get(K key) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		V v = node.value;
		return v;
	}
	/*  4.2 Get key from index */
	public int getIndexForKey(K key) {//key.hashCode() == int
		return Math.abs(key.hashCode() % arr.size());
	}
	
	/*  4.3 Get LinkedListNode from a key */
	public LinkedListNode<K,V> getNodeForKey(K key) {
		//1.find head in ArrayList
		int index = getIndexForKey(key);
		LinkedListNode<K,V> head = arr.get(index); 
		//2.go down to find the node
		while(head != null) {
			if(head.key == key) {
				return head;
			}
			head = head.next;
		}
		return null;
	}

	/** 5. Insert key and value into the hashTable */
	public void put(K key, V value) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		//1. node != null
		if(node != null) {
			node.value = value;
			return;
		}
		//2. node == null
		node = new LinkedListNode<K,V>(key,value);
		int index = getIndexForKey(key);
		LinkedListNode<K,V> head = arr.get(index);
		//2.1 数组该位链表头非空
		if(head != null) {
			node.next = head;//以node为主
			node.next.prev = node;
		}else {
			arr.set(index, node);
		}
	}
	
	/** 6. Remove node for key */
	public void remove(K key) {
		LinkedListNode<K,V> node = getNodeForKey(key);
		//1. node.prev
		if(node.prev != null) {
			node.prev.next = node.next;
		}else {
			//Removing head - update
			int hashKey = getIndexForKey(key);
			arr.set(hashKey, node.next);
		}
		//2. node.next
		if(node.next != null) {
			node.next.prev = node.prev;
		}
		
	}

}


public class HashTable {
	
	public static void main(String[] args) {
		
	}

}
