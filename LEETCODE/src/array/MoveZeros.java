package array;

public class MoveZeros {

	public void moveZeroes(int[] nums) {
		int zero = 0, nonzero = 0;//i : zero,j : nonzero
		while(zero < nums.length && nonzero < nums.length) {
			if(nums[zero] != 0){
				zero++;
				nonzero = zero;
				continue;
			}
			if(nums[nonzero] == 0) {
				nonzero++;
				continue;
			}
			if(nums[zero] == 0 && nums[nonzero] != 0) {
				int temp = nums[zero];
				nums[zero] = nums[nonzero];
				nums[nonzero] = temp;
				zero++;
				nonzero++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		int[] nums1 = {1,0};
		MoveZeros mz = new MoveZeros();
		mz.moveZeroes(nums1);
		for(int n : nums1) {
			System.out.println(n);
		}
		
	}

}
