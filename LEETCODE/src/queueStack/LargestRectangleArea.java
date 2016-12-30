package queueStack;

import java.util.Stack;

public class LargestRectangleArea {
	/* O(n) */
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) { return 0; }
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		for(int i = 0; i <= heights.length; i++) {//最后加入-1来pop
			int curr = (i == heights.length? -1 : heights[i]);//用来比较并pop值,末位为-1
			while(!stack.isEmpty() && curr <= heights[stack.peek()]) {//与栈顶元素比较
				int h = heights[stack.pop()];//算哪根柱子的高度就把哪根柱子pop出
				//1. 栈空即该元素为全数组最小值，可以向左延伸 [0,i]
				//2. 由于peek的是要算的柱子的左边第一根，所以真正的范围为 i-左一-1。i为右边第一根比它小的柱子，pop它
				int w = stack.isEmpty()? i : i-stack.peek()-1;//右边界为i，左边界分栈空不空情况
				max = Math.max(h*w, max);
			}
			stack.push(i);//栈中存的都是index
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] heights = {2,1,5,6,2,3};
		LargestRectangleArea lra = new LargestRectangleArea();
		System.out.println(lra.largestRectangleArea1(heights));

	}
	/* O(n2) */
	public int largestRectangleArea1(int[] heights) {
		if(heights == null || heights.length == 0) { return 0; }
		int len = heights.length;
		int maxArea =  0;
		for(int i = 0; i < len; i++) {
			int j = 0;
			for(j = i; j < len; j++) {
				if(heights[j] < heights[i]) {
					maxArea = Math.max((j-i) * heights[i], maxArea);
					break;
				}
			}
			maxArea = Math.max((j-i) * heights[i], maxArea);
		}
		return maxArea;
	}

}
