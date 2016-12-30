package data_structure;

class Link{
	private int iData;
	public Link next;
	public Link(int data){
		iData = data;
	}
	public int getKey(){
		return iData;
	}
	public void displayLink(){
		System.out.print(iData + " ");
	}
}

class SortedLinkedList{
	private Link head;
	public SortedLinkedList(){
		head = null;
	}
	//public int hashFunc(int key){}
	public void insert(Link link){
		int key = link.getKey();//通过键值来比对
		Link prev = null;
		Link cur = head;
		
	}
	
}

public class HashMap_LinkedList_34 {
	public static void main(String[] args) {
		

	}
}
