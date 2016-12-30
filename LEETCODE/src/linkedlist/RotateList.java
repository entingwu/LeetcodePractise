package linkedlist;

public class RotateList {
	
	public ListNode rotateRight(ListNode head, int k) {
		/* 1. length */
		if(head == null) { return null; }
		int len = getLength(head);
		k = k % len;
		
		/* 2. dummy node */
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode tail = dummy;//用于断开链表
		
		/* 3. head走k步 */
		while(k > 0) { head = head.next; k--; }//2.1
		
		/* 4. head.tail同时走，直到head位于链表末节 */
		while(head.next != null) {
			head = head.next;
			tail = tail.next;
		}
		
		/* 5. reorganize */
		head.next = dummy.next;//loop
		dummy.next = tail.next;//find head
		tail.next = null;//break;
		
		return dummy.next;
	}
	
	private int getLength(ListNode head) {
		int len = 0;
		while(head != null) {
			len++;
			head = head.next;
		}
		return len;
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
		
		RotateList rl = new RotateList();
		int k = 2;
		ListNode res = rl.rotateRight(node1, k);
		while(res != null) {
			System.out.print(res.val+" ");
			res = res.next;
		}
		
		
	}

}
