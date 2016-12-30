package linkedlist;

public class ReorderList {

	public void reorderList(ListNode head) {
		if(head == null || head.next == null) { return; }
		ListNode mid = findMiddle(head);
		ListNode tail = reverseList(mid.next);
		mid.next = null;
		merge(head,tail);
	}
	
	private void merge(ListNode l1, ListNode l2) {
		ListNode tail = new ListNode(0);
		int index = 0;
		while(l1 != null && l2 != null) {
			if(index % 2 == 0) {//第一条链表
				tail.next = l1;
				l1 = l1.next;
			}else {//第二条链表
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
			index++;
		}
		if(l1 != null) {
			tail.next = l1;
		}
		if(l2 != null) {
			tail.next = l2;
		}
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head; 
			head = temp;
		}
		return prev;
	}
	
	private ListNode findMiddle(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ReorderList rl = new ReorderList();
		rl.reorderList(node1);
		while(node1!=null) {
			System.out.print(node1.val + " ");
			node1 = node1.next;
		}
	}

}
