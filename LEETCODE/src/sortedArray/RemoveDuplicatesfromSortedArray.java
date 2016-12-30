package sortedArray;

public class RemoveDuplicatesfromSortedArray {
	
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		int index = 0;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i - 1]) {
				index++;
				nums[index] = nums[i];
			}
		}
		return index + 1;
	}
	
	public int removeDuplicatesII(int[] nums) {
		if(nums == null || nums.length == 0) { return 0; }
		int index = 0;//后
		int occur = 1;//一进来就出现一次
		for(int i = 1; i < nums.length; i++) {//前
			if(nums[index] == nums[i]) {
				if(occur == 2) {
					continue;
				}
				occur++;//重复度加1
			}else {
				occur = 1;//首次出现重复度=1
			}
			index++;
			nums[index] = nums[i]; 
		}
		return index + 1;
	}
	
	public static void main(String[] args) {
		int[] A = {1,1,2};
		RemoveDuplicatesfromSortedArray rdfa = new RemoveDuplicatesfromSortedArray();
		System.out.println(rdfa.removeDuplicates(A));
		for(int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		int[] nums = {1,1,1,2,2,3};
		System.out.println(rdfa.removeDuplicatesII(nums));
		
	}
}
