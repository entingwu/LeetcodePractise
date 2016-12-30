package linkedlist;

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) { return head; }
		ListNode oddList = head;
		ListNode evenList = head.next;
		ListNode oddHead = head;
		ListNode evenHead = head.next;
		while(oddList.next!=null && evenList.next!=null) {
			oddList.next = oddList.next.next;
			evenList.next = evenList.next.next;
			oddList = oddList.next;
			evenList = evenList.next;
		}
		oddList.next = evenHead;
		return oddHead;
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
		
		OddEvenLinkedList ol = new OddEvenLinkedList();
		ListNode result = ol.oddEvenList(node1);
		while(result!=null) {
			System.out.println(result.val+" ");
			result = result.next;
		}
	}

}
