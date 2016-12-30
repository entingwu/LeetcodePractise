package mergeSortQuickSort;

public class SortList {
	
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) { return head; }
		ListNode mid = middleNode(head);
		ListNode right = sortList(mid.next);
		mid.next = null;
		ListNode left = sortList(head);
		return merge(left, right);
	}
	
	private ListNode middleNode(ListNode head) {
		if(head == null) { return head;}
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(head1 != null && head2 != null){
			if(head1.val < head2.val) {
				tail.next = head1;
				head1 = head1.next;
			}else {
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}
		if(head1 != null) {
			tail.next = head1;
			tail = tail.next;
		}
		if(head2 != null) {
			tail.next = head2;
			tail = tail.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node3;
		node3.next = node2;
		node2.next = null;
		SortList sl = new SortList();
		System.out.println(sl.middleNode(node1).val);
		ListNode newList = sl.sortList(node1);
		while(newList != null) {
			System.out.print(newList.val + " ");
			newList = newList.next;
		}
	}

}
