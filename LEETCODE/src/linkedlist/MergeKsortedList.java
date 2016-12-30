package linkedlist;

import java.util.LinkedList;
import java.util.List;

class SubList{
	ListNode head;
	int val;
	public SubList(){
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
}

public class MergeKsortedList {
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists.size() == 0){
			return null;
		}
		return mergeHelper(lists, 0, lists.size() - 1);
	}
	private ListNode mergeHelper (List<ListNode> lists, int start, int end){
		if(start == end){
			return lists.get(start);
		}
		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);
		return mergeTwoLists(left,right);
	}
	private ListNode mergeTwoLists(ListNode list1, ListNode list2){
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(list1 != null && list2 != null){
			if(list1.val < list2.val){
				tail.next = list1;
				tail = list1;
				list1 = list1.next;
			}else{
				tail.next = list2;
				tail = list2;
				list2 = list2.next;
			}
		}
		if(list1 != null){
			tail.next = list1;
		}else{
			tail.next = list2;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		

	}

}
