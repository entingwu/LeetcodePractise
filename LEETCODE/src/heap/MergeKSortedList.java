package heap;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode{
	int value;
	ListNode next;
	public ListNode(int val){
		value = val;
	}
}

public class MergeKSortedList {
	
	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
		public int compare(ListNode left, ListNode right){
			if(left == null){
				return 1;
			}else if(right == null){
				return -1;
			}
			return left.value - right.value;
		}
	};
	
	public ListNode mergeKLists(ArrayList<ListNode> lists){
				
		if(lists == null || lists.size() == 0){
			return null;
		}
		//size, comparator
		Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(),ListNodeComparator);
		for(int i=0; i<lists.size(); i++){
			if(lists.get(i) != null){
				heap.add(lists.get(i));
			}
		}
		
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while(!heap.isEmpty()){
			ListNode head = heap.poll();
			tail.next = head;
			tail = head;
			if(head.next != null){
				heap.add(head.next);
			}
		}
		return dummy.next;
	}
	
	
	
}

