package queueStack;

import java.util.Stack;

class Min_Stack{
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();
	
	public void push(int number){
		stack.push(number);
		if(minStack.isEmpty() || number <= minStack.peek()){
			minStack.push(number);
		}
	}
	public void pop(){
		if(!stack.isEmpty()){
			int value = stack.pop();
			if(value == minStack.peek()){
				minStack.pop();
			}
		}
	}
	public int top(){
		return stack.peek();
	}
	public int getMin(){
		return minStack.peek();
	}
}

public class MinStack {

	public static void main(String[] args) {
		Min_Stack stk = new Min_Stack();
		stk.push(2);stk.push(0);stk.push(3);stk.push(0);
		stk.getMin();
		stk.pop();
		stk.getMin();
		stk.pop();
		
		stk.getMin();
		stk.pop();
		int res = stk.getMin();
		System.out.println(res);

	}

}
