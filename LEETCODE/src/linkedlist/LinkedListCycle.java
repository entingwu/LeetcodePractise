package linkedlist;

public class LinkedListCycle {
	/* 1. LinkedList 1 */
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) { return false; }
		ListNode fast = head, slow = head;
		while(fast != null && fast.next != null ) {
			fast = fast.next.next; // fast pointer moves two steps each time. 
			slow = slow.next; //slow pointer moves one step each time.
			if(fast == slow) {
				return true; // two pointers meet, return true. 
			}
		}
		return false; //no loops detected, return false
	}
	/* 2. LinkedList 2 */
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) { return null; }//[1]
		ListNode fast = head, slow = head;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) { break; }
		}
		//相遇时把fast拉到开始处
		if(fast == slow) {
			fast = head;
			while(fast != slow) {
				fast = fast.next;
				slow = slow.next;
			}
			return fast;
		}else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		LinkedListCycle lc = new LinkedListCycle();
		System.out.println(lc.hasCycle(node1));
		
	}

}
