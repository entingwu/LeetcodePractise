package array;

public class IncreasingTripletSubsequence {
	//"1,2,3,4,5" -> true
	/*This problem can be converted to be finding if there is a sequence such that 
	 * the_smallest_so_far < the_second_smallest_so_far < current. 
	 * We use n1, n2 and n to denote the 3 number respectively.*/
	public static boolean increasingTriplet(int[] nums) {
		int n1 = Integer.MAX_VALUE;
		int n2 = Integer.MAX_VALUE; 
		for(int i = 0; i < nums.length; i++) {
			int n = nums[i];
			if(n <= n1) {
				n1 = n;
			}else if(n <= n2) {
				n2 = n;
			}else {
				return true;
			}
		}
		return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		System.out.println(increasingTriplet(nums));

	}

}
