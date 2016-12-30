package linkedlist;

public class ListNode {
	ListNode next;
	int val;
	public ListNode(int x){
		val = x;
		next = null;
	}
	public void displayNode(){
		System.out.print(this.val + " ");
	}
	
}
