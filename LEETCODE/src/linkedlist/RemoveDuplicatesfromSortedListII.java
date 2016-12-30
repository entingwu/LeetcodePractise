package linkedlist;

class DupList{
	ListNode head;
	public DupList(){
		head = null;
	}
	
	public void insertHead(int d){
		ListNode newNode = new ListNode(d);
		newNode.next = head;
		head = newNode;
	}
	public void display(ListNode newHead){
		System.out.println("List(head->tail):");
		ListNode node = newHead;
		while(node != null){
			node.displayNode();
			node = node.next;
		}
		System.out.println();
	}
	/* 1. Remove Duplicates from Sorted List I */
	public ListNode deleteDuplicates1(ListNode head) {
		if(head == null) { return null; }
		ListNode node = head;
		while(node.next != null) {
			if(node.val == node.next.val) {
				node.next = node.next.next;
			}else {
				node = node.next;
			}
		}
		return head;
	}
	
	/* 2. Remove Duplicates from Sorted List II */
	public ListNode deleteDuplicates2(ListNode head) {
		if(head == null) { return head; }
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		
		while(head.next != null && head.next.next != null) {
			int val = head.next.val;
			if(val == head.next.next.val) {
				while(head.next!= null && head.next.val == val) {
					//如果head.next.val与记录下的val相等，就跳过这个值 
					head.next = head.next.next;
				}
			}else {
				head = head.next;
			}
		}
		return dummy.next;
	}
	
	public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}

public class RemoveDuplicatesfromSortedListII {
	public static void main(String[]args){
		DupList dupList = new DupList();
		dupList.insertHead(5); dupList.insertHead(4); dupList.insertHead(4);
		dupList.insertHead(3); dupList.insertHead(3); dupList.insertHead(2); dupList.insertHead(1);
		dupList.display(dupList.head);
		
		ListNode nonDup = dupList.deleteDuplicates1(dupList.head);
		dupList.display(dupList.head);
		
		DupList revList = new DupList();
		revList.insertHead(1); revList.insertHead(2); revList.insertHead(3); revList.insertHead(4);
		revList.display(revList.head);
		ListNode newHead = revList.reverse(revList.head);
		revList.display(newHead);
	}
}
