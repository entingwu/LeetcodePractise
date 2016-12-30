package dynamicProgramming;

public class RangeSumQuery {

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
	private int[] prefixSum;
    public RangeSumQuery(int[] nums) {
    	prefixSum = new int[nums.length + 1];
    	prefixSum[0] = 0;
    	for(int i = 1; i <= nums.length; i++) {
    		prefixSum[i] = prefixSum[i-1] + nums[i-1];
    	}
    }

    public int sumRange(int i, int j) {
	    return prefixSum[j+1] - prefixSum[i+1-1];    
	}
	
	public static void main(String[] args) {
		int[] nums = {-2,0,3,-5,2,-1};
		RangeSumQuery numArray = new RangeSumQuery(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(0, 5));
	}

}
