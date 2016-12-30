package queueStack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/* 1. valid parentheses
 *    (( )) stack*/
/* 2. implement a stack*/

class StackArrayListImp{
	
	private ArrayList<Integer> list;
	public StackArrayListImp(){
		list = new ArrayList<Integer>();
	}
	
	public void push(int val) {
		list.add(val);
	}
	
	public int pop() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		return list.remove(list.size()-1);
	}
	
	public int peek() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		return list.get(list.size()-1);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void empty() {
		list.clear();
	}
}

class ListNode{
	ListNode next;
	int val;
	public ListNode(int v){
		val = v;
		next = null;
	}
}

class StackLinkedListImp{
	
	private ListNode head;//no constructor
	
	public void push(int val){
		ListNode newHead = new ListNode(val);
		newHead.next = head;
		head = newHead;
	}
	
	public int pop(){
		if(isEmpty()){
			throw new NoSuchElementException();
		} else {
			int val = head.val;
			head = head.next;
			return val;
		}
	}
	
	public int peek(){
		if(isEmpty()){
			throw new NoSuchElementException();
		} else {
			return head.val;
		}
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public void empty(){
		head = null;
	}

}

class QueueLinkedListImp{
	
	private ListNode head;
	private ListNode tail;
	
	public void enqueue(int val) {
		if(isEmpty()){
			ListNode newNode = new ListNode(val);
			head = newNode;
			tail = newNode;
		}else {
			tail.next = new ListNode(val);
			tail = tail.next;
		}
	}
	
	public int dequeue() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}else {
			int val = head.val;
			head = head.next;
			return val;
		}
	}
	
	public int peek() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}else {
			return head.val;
		}
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void empty() {
		head = null;
	}
	
	public void print(){
		ListNode cur = head;
		while(cur != null){
			System.out.println(cur.val);
			cur = cur.next;
		}
	}
}

public class StackQueueChapter5 {
	public static void main(String[] args) {
		QueueLinkedListImp queue = new QueueLinkedListImp();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.print();
	}
}
