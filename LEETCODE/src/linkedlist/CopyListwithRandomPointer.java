package linkedlist;

import java.util.HashMap;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
};

public class CopyListwithRandomPointer {
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) { return null; }
		HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode pre = dummy;//固定了链表头，使最后可以return dummy.next
		RandomListNode newNode = null;
		while(head != null) {
			/* 1. copy node */
			if(map.containsKey(head)) {//根据head来更新newNode
				newNode = map.get(head);
			}else {//一开始
				newNode = new RandomListNode(head.label);
				map.put(head, newNode);
			}
			pre.next = newNode;
			
			/* 2. copy random pointer */
			if(head.random != null) {//防止空指针
				if(map.containsKey(head.random)) {//random指向自己
					newNode.random = map.get(head.random);
				}else {
					newNode.random = new RandomListNode(head.random.label);
					map.put(head.random, newNode.random);
				}
			}

			pre = newNode;//pre = map.get(head);
			head = head.next;
		}
		return dummy.next;
	}
	
	/*第一遍扫的时候巧妙运用next指针， 开始数组是1->2->3->4  。 然后扫描过程中 先建立copy节点 1->1`->2->2`->3->3`->4->4`, 然后第二遍copy的时候去建立边的copy， 拆分节点, 一边扫描一边拆成两个链表，这里用到两个dummy node。第一个链表变回  1->2->3 , 然后第二变成 1`->2`->3`  */
	//No HashMap version
	public RandomListNode copyRandomList1(RandomListNode head) {
		if (head == null) {
			return null;
		}
		copyNext(head);
		copyRandom(head);
		return splitList(head);
	}
	
	private void copyNext(RandomListNode head) {
		while (head != null) {
			RandomListNode newNode = new RandomListNode(head.label);
			newNode.random = head.random;
			newNode.next = head.next;
			head.next = newNode;
			head = head.next.next;
		}
	}

	private void copyRandom(RandomListNode head) {
		while (head != null) {
			if (head.next.random != null) {
				head.next.random = head.random.next;
			}
			head = head.next.next;
		}
	}

	private RandomListNode splitList(RandomListNode head) {
		RandomListNode newHead = head.next;
		while (head != null) {
			RandomListNode temp = head.next;
			head.next = temp.next;
			head = head.next;
			if (temp.next != null) {
				temp.next = temp.next.next;
			}
		}
		return newHead;
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node1.random = node1;
		node2.random = node3;
		node3.random = node2;
		node4.random = null;
		
		CopyListwithRandomPointer crp = new CopyListwithRandomPointer();
		RandomListNode node = crp.copyRandomList(node1);
		while(node != null) {
			System.out.print(node.label + " ");
			node = node.next;
		}
	}

}
