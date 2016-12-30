package queueStack;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> save = new Stack<Integer>();
	
	public void push(int x) {
		stack.push(x);
	}
	
	public void pop() {
		if(save.isEmpty()) {
			while(!stack.isEmpty()) {
				save.push(stack.pop());
			}
		}
		save.pop();
	}
	
	public int peek() {
		if(save.isEmpty()) {
			while(!stack.isEmpty()) {
				save.push(stack.pop());
			}
		}
		return save.peek();
	}
	
	public boolean empty() {
		return stack.isEmpty() && save.isEmpty();
	}
	
	public static void main(String[] args) {
		ImplementQueueUsingStacks qs = new ImplementQueueUsingStacks();
		qs.push(1);
		qs.push(2);
		System.out.println(qs.peek());
		qs.pop();
		System.out.println(qs.empty());
		
	}

}
