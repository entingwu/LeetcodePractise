package queueStack;

import java.util.NoSuchElementException;

class Stack {
    
    private ListNode head;
    
    // Push a new item into the stack
    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
    }

    // Pop the top of the stack
    public void pop() {
    	if(!this.isEmpty()) {
    		throw new NoSuchElementException(); 
    	}else {
    		head = head.next;
    	}
    }

    // Return the top of the stack
    public int top() {
    	if(this.isEmpty()) {
    		throw new NoSuchElementException();
    	}else {
    		return head.val;
    	}
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        return head == null;
    }    
}

public class ImplementStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
