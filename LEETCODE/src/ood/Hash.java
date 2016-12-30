package ood;

import java.util.LinkedList;

/** 1. Cell<K,V> class */
class Cell<K,V> {
	private K key;
	private V value;
	public Cell(K k, V v) {
		this.key = k;
		this.value = v;
	}
	/* a. GET */
	public K getKey() { return key; }
	public V getValue() { return value; }
	
	/* b. EQUAL */
	/*public boolean equivalent(Cell<K,V> c) {
		return equivalent(c.getKey());
	}
	public boolean equivalent(K k) {
		return key.equals(k);
	}*/
}

/** 2. Hash<K,V> class */
public class Hash<K, V> {
	
	private final int MAX_SIZE = 10;
	LinkedList<Cell<K,V>>[] listArray;//链表数组
	/* I. CONSTRUCTOR */
	public Hash() {
		//listArray = new LinkedList<Cell<K,V>>()[MAX_SIZE];
		listArray = (LinkedList<Cell<K,V>>[])new LinkedList[MAX_SIZE];
	}
	public int hashCodeOfKey(K key) {
		return key.toString().length() % listArray.length;
	}
	
	/* II. PUT */
	public void put(K key, V value) {
		/** 1.数组对应位置，若该位置无链表则新建*/
		int x = hashCodeOfKey(key);
		if(listArray[x] == null) {
			listArray[x] = new LinkedList<Cell<K,V>>();
		}
		/** 2.该位置有链表，则以list引用指向该链表头 */
		LinkedList<Cell<K,V>> list = listArray[x];
		
		/** 3.链表已有该key，删除 */
		for(Cell<K,V> c : list) {
			if(c.getKey() == key) {
				list.remove(c);
				break;
			}
		}
		
		/** 4.链表没有该key */
		Cell<K,V> c = new Cell<K,V>(key, value);
		list.add(c);
	}
	
	/* III. get */
	public V get(K key) {
		/** 1.数组对应位置，若该位置无链表则返回*/
		int x = hashCodeOfKey(key);
		if(listArray[x] == null) {
			return null;
		}
		/** 2.该位置有链表，则以list引用指向该链表头 */
		LinkedList<Cell<K,V>> list = listArray[x];
		for(Cell<K,V> c :list) {
			if(c.getKey() == key) {
				return c.getValue();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		

	}

}
