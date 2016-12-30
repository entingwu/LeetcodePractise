package linkedlist;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		int bit = 0, carry = 0;
		while(l1!=null && l2!=null) {
			bit = (l1.val + l2.val + carry) % 10;
			carry = (l1.val + l2.val + carry) / 10;
			ListNode node = new ListNode(bit);
			tail.next = node;
			tail = node;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null) {
			bit = (l1.val + carry) % 10;
			carry = (l1.val + carry) / 10;
			ListNode node = new ListNode(bit);
			tail.next = node;
			tail = node;
			l1 = l1.next;
		}
		while(l2 != null) {
			bit = (l2.val + carry) % 10;
			carry = (l2.val + carry) / 10;
			ListNode node = new ListNode(bit);
			tail.next = node;
			tail = node;
			l2 = l2.next;
		}
		if(carry == 1) {
			tail.next = new ListNode(carry);
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		

	}

}
