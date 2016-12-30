package sortingMethod;

class ListNode{
	int val;
	ListNode next;
	ListNode(int x){ val = x; }
	public void displayNode(){
		System.out.print(val+" ");
	}
}
class Solution{
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode resDumpHead = new ListNode(0);//The node before the actual returned result
		ListNode resIterator = resDumpHead;//iterator to loop over the returned result
		
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				resIterator.next = l1;
				resIterator = resIterator.next;//point to current
				l1 = l1.next;
			}else{
				resIterator.next = l2;
				resIterator = resIterator.next;
				l2 = l2.next;
			}
		}
		while(l1!=null){
			resIterator.next = l1;
			resIterator = resIterator.next;
			l1 = l1.next;
		}
		while(l2!=null){
			resIterator.next = l2;
			resIterator = resIterator.next;
			l2 = l2.next;
		}
		return resDumpHead.next;
	}
}

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode l1_0 = new ListNode(1);
		ListNode l1_1 = new ListNode(7);
		l1_0.next = l1_1;
		ListNode l2_0 = new ListNode(2);
		ListNode l2_1 = new ListNode(3);
		ListNode l2_2 = new ListNode(5);
		l2_0.next = l2_1;
		l2_1.next = l2_2;
		
		displayList(l1_0);
		displayList(l2_0);
		Solution solu = new Solution();
		ListNode mergeSortedList = solu.mergeTwoLists(l1_0, l2_0);
		displayList(mergeSortedList);
		
	}
	public static void displayList(ListNode node){
		while(node!=null){
			node.displayNode();
			node = node.next;
		}
		System.out.println();
	}
}
