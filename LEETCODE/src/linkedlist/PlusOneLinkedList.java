package linkedlist;

public class PlusOneLinkedList {
	
	public ListNode plusOne(ListNode head) {
		if(head == null) { return null; }
		ListNode newHead = reverse(head);
		newHead.val += 1;
		if(newHead.val < 10) {
			return reverse(newHead);
		}
		int carry = 0, digit = 0;
		ListNode node = newHead;
		while(node != null) {
			digit = (node.val + carry) % 10;
			carry = (node.val + carry) / 10;
			node.val = digit;
			if(node.next == null && carry != 0) {
				node.next = new ListNode(carry);
				break;
			}
			node = node.next;
		}
		return reverse(newHead); 
    }
	
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		while(head != null) {
			ListNode temp = head.next;
			head.next = pre;
			pre = head;
			head = temp;
		}
		return pre;
	} 
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(9);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		PlusOneLinkedList pol = new PlusOneLinkedList();
		ListNode newHead = pol.plusOne(node1);
		while(newHead != null) {
			System.out.println(newHead.val + ",");
			newHead = newHead.next;
		}
	}

}
