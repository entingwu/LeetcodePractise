package twoPointer;

public class TrappingRainWater {
	// 关键是在于找到规律：  
    // 即第i块地方的存水量 = min(第i块左边最高的bar高度, 第i块右边最高的bar的高度) - 第i块地方bar的高度  
	public int trap(int[] height) {
		if(height == null || height.length == 0) { return 0; }
		int len = height.length;
		/* 1. state */
		int[] maxLeft = new int[len]; 
		int[] maxRight = new int[len];
		
		/* 2. initialize */
		//left->right : left数组记录到当前i为止，左边最高的bar （包含i）  
		maxLeft[0] = height[0];
		for(int i = 1; i < len; i++) {
			maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
		}
		//right->left : 数组记录到当前i为止，右边最高的bar  
		maxRight[len-1] = height[len-1];
		for(int i = len-2; i>=0; i--) {
			maxRight[i] = Math.max(maxRight[i+1], height[i]);
		}
		
		/* 3. function */
		int sum = 0;
		for(int i = 0; i < len; i++) {
			sum += Math.min(maxLeft[i], maxRight[i]) - height[i];
		}
		
		/* 4. answer */
		return sum;
	}
	
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		TrappingRainWater tr = new TrappingRainWater();
		System.out.println(tr.trap(height));

	}

}
