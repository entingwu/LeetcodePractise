package linkedlist;

public class DeleteNodeinaLinkedList {

	public void deleteNode(ListNode node) {
		if(node == null) { return; }
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) { return null; }
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while(head.next != null) {
			if(head.next.val == val) {
				head.next = head.next.next;
			}else {
				head = head.next;
			}
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		int val = 6;
		
		DeleteNodeinaLinkedList dl = new DeleteNodeinaLinkedList();
		ListNode res = dl.removeElements(node1, val);
		while(res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
		
	}

}
