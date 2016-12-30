package binary_search;

public class SearchInARotateSortedArray {
	 
	public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0) { return -1; }
		int start = 0, end = nums.length - 1;
		int mid;
		
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[start] < nums[mid]){
				// red line
				if(nums[start] <= target && target <= nums[mid]){
					end = mid;
				}else{
					start = mid;
				}
				
			}else{
				// green line
				if(nums[mid] <= target && target <= nums[end]){
					start = mid;
				}else{
					end = mid;
				}
			}
		}
		
		if(nums[start] == target) {
			return start;
		}else if(nums[end] == target) {
			return end;
		}
		
		return -1;
		
	}
	
	public boolean searchII(int[] nums, int target) {
		// it ends up the same as sequential search
		// We used linear search for this question just to indicate that the 
		// time complexity of this question is O(n) regardless of binary search is applied or not.
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == target){
				return true;
			}
		}
		return false;
	}
}
