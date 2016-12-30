package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergeKsortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) { return null; }
		return mergeOrderDC(lists, 0, lists.length-1);
	}
	
	private ListNode mergeOrderDC(ListNode[] lists, int start, int end) {
		if(start == end) {//base case
			return lists[start];
		} else if(start < end) {
		    int mid = start + (end - start) / 2;
		    ListNode left = mergeOrderDC(lists, start, mid);
		    ListNode right = mergeOrderDC(lists, mid + 1, end);
		    return mergeTwoSortedList(left, right);
		} else {
		    return null;
		}
	}
	
	private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
		if(l1 == null) { return l2; }
		if(l2 == null) { return l1; }
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				tail.next = l1;
				l1 = l1.next;
				tail = tail.next;
			}else {
				tail.next = l2;
				l2 = l2.next;
				tail = tail.next;
			}
		}
		if(l1 != null) {
			tail.next = l1;
		}
		if(l2 != null) {
			tail.next = l2;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(9);
		node1.next = node2;
		node2.next = node3;
		
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(10);
		node4.next = node5;

		ListNode node6 = new ListNode(2);
		ListNode node7 = new ListNode(8);
		node6.next = node7;
		
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(node1);
		lists.add(node4);
		lists.add(node6);
		
		MergeKsortedLists mk = new MergeKsortedLists();
		ListNode[] emptylists = new ListNode[1];
		ListNode list = mk.mergeKLists(emptylists);
		System.out.println(list);
		while(list!= null) {
			System.out.print(list.val + " ");
			list = list.next;
		}
	}

}
