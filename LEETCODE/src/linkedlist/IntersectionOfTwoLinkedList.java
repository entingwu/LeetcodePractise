package linkedlist;

public class IntersectionOfTwoLinkedList {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) { return null; }
		int lenA = 0, lenB = 0, diff = 0;
		ListNode pA = headA, pB = headB;
		while(pA != null) { pA = pA.next; lenA++; }
		while(pB != null) { pB = pB.next; lenB++; }
		
		/* 1. 移到同一起跑线 */
		pA = headA; pB = headB;
		if(lenA > lenB) {
			diff = lenA - lenB;
			while(diff > 0) {
				pA = pA.next;
				diff--;
			}
		}else {
			diff = lenB - lenA;
			while(diff > 0) {
				pB = pB.next;
				diff--;
			}
		}
		/* 2. 一起走 */
		while(pA != null && pB != null) {
			if(pA.val == pB.val) { return pA; }
			pA = pA.next;
			pB = pB.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		

	}

}
