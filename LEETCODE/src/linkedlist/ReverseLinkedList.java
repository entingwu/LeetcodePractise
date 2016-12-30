package linkedlist;

public class ReverseLinkedList {
	/** 1. ITERATOR */
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode temp = head.next;
			head.next = prev;
			prev = head;
			head = temp;
		}
		return prev;
	}
	
	/** 2. RECURSIVE */
	public ListNode recursive(ListNode head) {
		if(head == null || head.next == null) { return head; }
		ListNode temp = head.next;
		ListNode newHead = recursive(temp);
		head.next = null;
		temp.next = head;
		return newHead;
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m >= n || head == null) { return head;}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		/* 1. head到m前,使preM==head,preM用于连接翻转节点 */
		for(int i = 1; i < m; i++) {
			if(head == null) { return null; }
			head = head.next;
		}
		
		/* 2. 初始化翻转链表需用节点 */
		ListNode preM = head;
		ListNode mNode = head.next;
		ListNode nNode = mNode;
		ListNode postN = mNode.next;
		
		/* 3. 翻转m->n节点， 翻转动作以postN(I中的head)为中心, temp用于保存postN */
		for(int i = m; i < n; i++){
			if(postN == null) { return null; }//don't forget
			ListNode temp = postN.next;
			postN.next = nNode;
			nNode = postN;
			postN = temp;
		}
		
		/* 4. 外围节点连接,preM,mNode */
		preM.next = nNode;
		mNode.next = postN;
		
		return dummy.next;
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
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode node = rl.recursive(node1);
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		/*int m = 2, n = 4;
		ListNode test = rl.reverseBetween(node1, 2, 4);
		while(test!=null) {
			System.out.print(test.val + " ");
			test = test.next;
		}*/

	}

}
