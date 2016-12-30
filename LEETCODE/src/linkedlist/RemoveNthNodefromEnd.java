package linkedlist;

public class RemoveNthNodefromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) { return null; }
		ListNode fast = head, slow = head;
		for(int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if(fast == null) { return head.next; }//[1] 1,防空指针
		while(fast.next != null) {//fast at the end of list
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		RemoveNthNodefromEnd rn = new RemoveNthNodefromEnd();
		ListNode node = rn.removeNthFromEnd(node1, 2);
		while(node!=null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		
	}

}
