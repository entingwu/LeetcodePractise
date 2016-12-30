package sorting_chapter1;

public class Shuffle {

	public ListNode shuffle(ListNode head) {
		if(head == null || head.next == null) { return head; }
		ListNode middle = findMiddle(head);
		ListNode right = shuffle(middle.next);
		middle.next = null;
		ListNode left = shuffle(head);
		return merge(right,left);
	}
	
	private ListNode findMiddle(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		while(l1!=null && l2!=null) {
			int random = (int)(100*Math.random())%2;
			if(random == 0) {
				tail.next = l1;
				l1 = l1.next;
			}else if(random == 1) {
				tail.next = l2;
				l2 = l2.next;
			}
			tail = tail.next;
		}
		if(l1!=null) {
			tail.next = l1;
		}
		if(l2!=null) {
			tail.next = l2;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Shuffle sfl = new Shuffle();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		
		ListNode shuffle = sfl.shuffle(node1);
		while(shuffle!=null) {
			System.out.print(shuffle.val+" ");
			shuffle = shuffle.next;
		}
		
		
	}

}
