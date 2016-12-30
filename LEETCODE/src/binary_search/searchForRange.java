package binary_search;

class OrderedArray {
	private int[] array;
	private int nElement;
	public OrderedArray(int max){
		array = new int[max];
		nElement = 0;
	}
	public int size(){
		return nElement;
	}
	public int[] range(int target){
		return searchRange(array,target);
	}
	public int[] searchRange(int[] nums, int target) {
		int start = 0, end = nums.length - 1, mid = 0;
		int[] range = new int[2];
		/* 1. left bound */
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				end = mid;
			}else if(nums[mid] < target) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(nums[start] == target) {
			range[0] = start;
		}else if(nums[end] == target) {
			range[0] = end;
		}else {
			range[0] = -1; range[1] = -1;
			return range;
		}
		
		/* 2. right bound */
		start = 0;
		end = nums.length - 1;
		while(start + 1 < end) {
			mid = start + (end - start) / 2;
			if(nums[mid] == target) {
				start = mid;
			}else if(nums[mid] < target) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(nums[end] == target) {
			range[1] = end;
		}else if(nums[start] == target) {
			range[1] = start;
		}else {
			range[0] = -1; range[1] = -1;
			return range;
		}
		return range;
	}
	public int[] searchRange1(int[] nums, int target) {
		int[] range = new int[2];
		int lowerBound = 0 , upperBound = nums.length - 1;
		int mid = 0;
		if(nums == null || nums.length == 0){
			return range;}
		while(lowerBound < upperBound){
			mid = lowerBound + (upperBound - lowerBound)/2;
			if(nums[mid] == target){
				upperBound = mid;
			}else if(nums[mid] < target){
				lowerBound = mid + 1;
			}else{
				upperBound = mid - 1;
			}
		}
		if(nums[lowerBound] == target){
			range[0] = lowerBound;
		}else{
			range[0] = -1;	
		}
		//lowerBound不更新，range[0]
		upperBound = nums.length-1;
		while(lowerBound < upperBound){
			mid = lowerBound + (upperBound - lowerBound)/2;
			if(nums[mid] == target){
				lowerBound = mid;
			}else if(nums[mid] < target){
				lowerBound = mid + 1;
			}else{
				upperBound = mid - 1;
			}
		}
		if(nums[lowerBound] == target){
			range[1] = lowerBound;
		}else{
			range[1] = -1;
		}
		return range;
	}
	
	/*有序插入*/
	public void insert(int value){
		int i;
		for(i=0;i<nElement;i++){
			if(array[i]>value){break;}//找到插入位置
		}
		for(int j=nElement;j>i;j--){//挪位
			array[j] = array[j-1];
		}
		array[i] = value;
		nElement++;//插入增加一个
	}
	public void display(){
		for(int i=0;i<nElement;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}

public class searchForRange {
	public static void main(String[] args) {
		OrderedArray array = new OrderedArray(6);
		array.insert(5);
		array.insert(7);
		array.insert(7);
		array.insert(8);
		array.insert(8);
		array.insert(10);
		array.display();
		int[] sort = array.range(8);
		for(int i=0; i<sort.length;i++){
			System.out.print(sort[i]+" ");
		}
		System.out.println();
		
	}
}
