package queueStack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	
	Queue<Integer> queue1 = new LinkedList<Integer>();
	Queue<Integer> queue2 = new LinkedList<Integer>();
	
	// Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	while(queue1.size() > 1) {
    		int move = queue1.poll();
    		queue2.offer(move);
    	}
    	queue1.poll();
    	swap();
    }
    
    private void swap() {
    	Queue temp = queue1;
    	queue1 = queue2;
    	queue2 = temp;
    }

    // Get the top element.
    public int top() {
    	while(queue1.size() > 1) {
    		int move = queue1.poll();
    		queue2.offer(move);
    	}
    	int top = queue1.poll();
    	queue2.offer(top);
    	
    	swap();
    	return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
    
	public static void main(String[] args) {
		ImplementStackUsingQueues isq = new ImplementStackUsingQueues();
		isq.push(1);
		isq.push(2);
		isq.pop();
		int top = isq.top();
		System.out.println(top);
	}

}
