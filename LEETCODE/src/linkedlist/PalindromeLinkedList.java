package linkedlist;

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
        if(head == null) { return true; }
        ListNode mid = findMiddle(head);
        ListNode backHalf = reverse(mid.next);
        mid.next = backHalf;
        
        ListNode p1 = head;
        ListNode p2 = mid.next;
        while(p2 != null) {
        	if(p1.val != p2.val) {
        		return false;
        	}
        	p1 = p1.next;
        	p2 = p2.next;
        }
        return true;
    }
	
	private ListNode findMiddle(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode reverse(ListNode node) {
		ListNode prev = null;
		while(node != null) {
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		PalindromeLinkedList pl = new PalindromeLinkedList();
		ListNode mid = pl.findMiddle(node1);
		ListNode backHalf = pl.reverse(mid.next);
		System.out.println(backHalf.val);
		
	}

}
