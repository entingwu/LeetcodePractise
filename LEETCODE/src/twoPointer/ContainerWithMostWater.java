package twoPointer;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		if(height == null || height.length == 0) { return 0; }
		int len = height.length;
		int left = 0, right = len-1;
		int max = 0, currArea = 0;
		while(left < right) {
			currArea = (right-left)*Math.min(height[left], height[right]);
			max = Math.max(currArea, max);
			if(height[left]<height[right]) {
				left++;
			}else {
				right--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] height = {1,3,2};
		ContainerWithMostWater cw = new ContainerWithMostWater();
		System.out.println(cw.maxArea(height));
	}

}
