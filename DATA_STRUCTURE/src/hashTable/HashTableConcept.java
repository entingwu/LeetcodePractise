package hashTable;

import java.util.Date;

/** hashTable */
/*  Step 1 Hash function : 
 *  	   Method for computing array index from key.
 *  Step 2 Collision resolution:
 *  	   Algorithm and data structure to handle two keys that hash to the same array index
 * */

/** Hash function : key --> table index
 *  1. Save Items in a key-indexed table (index is a function of the key)
 *     goal: each table index equally likely for each key.
 *  2. hashCode() 
 *     return : a 32-bit int
 *     If x.equals(y), then x.hashCode() == y.hashCode().
 *     If !x.equals(y), then x.hashCode() maybe == y.hashCode()
 *     Default implementation : Memory address of x.
 *     */

/** 1.1 Implementing hash code : integers, booleans, and doubles */
/*public final class Double{
	private final double value;
	public int hashCode() {
		long bits = doubleToLongBits(value);//64位
		return (int)(bits^(bits>>>32));//后32位^前32位
	}
}*/

/*IMMUTABLE: STRING
 * public final class string{// Horner's method
	private final char[] s;
	public int hashCode() {
		int hash = 0;
		for(int i = 0; i < length(); i++) {
			hash = s[i] + (31 * hash);// ith character of s
		}
		return hash;
	}
	h = s[0]*31^L-1 +...+ s[L-3]*31^2 + s[L-2]*31^1 + s[L-1]*31^0
	"call".hashCode() == 99*31^3 + 97*31^2 + 108*31^1 + 108*31^0
}*/

/* public final class string{
 * 	private int hash = 0; //cache of hash code
 * 	private final char[] s;
 *  public int hashCode() {
 *  	int h = hash; //return cached value
 *  	if(h != 0) { return h; }
 *  	for(int i = 0; i < length(); i++) {
 *  		h = s[i] + (31*h);
 *  	}
 *  	hash = h;
 *  	return h;
 *  }
 * }
 * */

/** 1.2. Implementing hash code : user-defined types */
final class Transaction implements Comparable<Transaction>{

	private final String who;
	private final Date when;
	private final double amount;
	
	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}
	// Combine each significant field using the 31x+y rule
	// If field is a primitive type, using wrapper type hashCode();
	// If field is null, return 0;
	// If field is a reference type, use hashCode(), applies rule recursively.
	// If field is an array, apply to each entry.
	public int hashCode() {
		int hash = 17;
		hash = 31*hash + who.hashCode();//reference types
		hash = 31*hash + when.hashCode();
		hash = 31*hash + ((Double)amount).hashCode();//primitive types
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (when == null) {
			if (other.when != null)
				return false;
		} else if (!when.equals(other.when))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		} else if (!who.equals(other.who))
			return false;
		return true;
	}

	public int compareTo(Transaction o) { return 0; }

}

/** 1.3. Modular hashing 
 *  Hash code : An int between -2^31 ~ 2^31-1
 *  Hash function : An int between 0 and M-1 (for use as array index)
 *  Uniform hashing assumption : Each key is equally likely to hash to an integer(0 ~ M-1)
 *  Birthday problem, Coupon collector
 * */
/*private int hash(Key key) {
	//return Math.abs(key.hashCode()) % M;//in case negative
	return (key.hashCode() & 0x7fffffff % M;) // 0~M-1
  }
*/

/** Collisions: 
 *  	Two distinct keys hashing to same index. 
 * */

/** 2.1. Seperate chaining 
 *  a. Use an array of M<N linked lists.
 *       Hash : map key to integer i between 0 ~ M-1.
 *       Insert : put at front of ith chain, if not already there.
 *       Search : need to search only ith chain.
 *  b. Proposition:
 *  	 Under uniform hashing assumption, prob.that the number of keys in
 *       a list is within a constant factor of N/M is extremely close to 1.
 *  c. Consequence:
 *  	 Number of probes for search/insert is proportional to N/M, M times faster than
 *  	 sequential search.
 *  	 M too large => too many empty chains
 *  	 M too small => chains too long
 *  	 choice : M ~ N/5 constant time ops.
 * */

//array doubling and halving code omitted
class SeperateChainingHashST<Key, Value>{
	private int M = 97; //number of chains
	private Node[] st = new Node[M]; //array of chains
	
	private static class Node{
		private Object key;//no generic array creation
		private Object val;//declare key and value of type Object
		private Node next;
	}
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public Value get(Key key) {
		int i = hash(key);
		Node x = st[i];
		while(x!=null) {
			if(key.equals(x.key)) {
				return (Value)x.val;
			}
			x = x.next;
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		int i = hash(key);
		for(Node x = st[i]; x!=null; x=x.next) {
			if(key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		//st[i] = new Node(key, val, st[i]);
	}
}

/** 2.2. Open addressing (Linear probing) 
 *  a. When a new key collides, find next empty slot, and put it there.
 *  	Hash : Map key to integer i between 0 and M-1.
 *  	Insert : Put at table index i if free; if not try i+1, i+2, etc
 *  	Search table index i: if occupied but no match, try i+1, i+2, etc
 *  
 *  	Note : Array size M must be greater than number of key-value pairs N.
 *  b.  Knuth's parking problem
 *  	Cars arrive at one-way street with M parking spaces. Each desires a random space i
 *		If space i is taken, try i+1, i+2, etc.
 *		Half-full: With M/2 cars, mean displacement is ~ 3/2.
 *	c. Parameters
 *		M too large => too many empty array entries.
 *		M too small => search time blows up.
 *		Typical choice: a = N/M ~ 1/2
 *		probes for search hit is about 3/2.
 *		probes for search miss is about 5/2.
 * */
class LinearProbingHashST<Key, Value>{
	private int M = 30001;
	private Value[] vals = (Value[])new Object[M];
	private Key[] keys = (Key[]) new Object[M];
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff) % M;
	}
	
	public void put(Key key, Value val) {
		int i;
		for(i = hash(key); keys[i] != null; i = (i+1)%M) {
			if(keys[i].equals(key)) { break; }
		}
		keys[i] = key;
		vals[i] = val;
	}
	
	public Value get(Key key) {
		for(int i = hash(key); keys[i] != null; i = (i+1)%M) {
			if(keys[i].equals(key)) { return vals[i]; }
		}
		return null;
	}
}

/** Hash tables VS Balanced search trees
 * 
 * Hash tables
 * 1. simpler to code
 * 2. No effective alternative for unordered keys.
 * 3. Faster for simple keys (a few arithmetic ops versus logN compares)
 * 4. Better system support in Java for strings. (eg. cached hash code)
 * 
 * Balanced search trees
 * 1. Stronger performance guarantee.
 * 2. Support for ordered ST operations.
 * 3. Easier to implement compareTo() correctly than equals() and hashCode().
 *	
 * Java system includes both
 * 1. Red-black BSTs: java.util.TreeMap, java.util.TreeSet
 * 2. Hash tables: java.util.HashMap, java.util.IdentityHashMap
 * */

public class HashTableConcept {

	public static void main(String[] args) {
		

	}

}
