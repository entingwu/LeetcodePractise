package binary_search;

class OrderedArray1 {
	private int[] array;
	private int nElement;
	public OrderedArray1(int max){
		array = new int[max];
		nElement = 0;
	}
	public int size(){
		return nElement;
	}
	public int find(){
		int[] arrayMin = {4,5,6,7,0,1,2};
		return findMin(arrayMin);
	}
	public int findMin(int[] nums){
		int start = 0, end = nums.length-1;
		int target = nums[end];
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(nums[mid] <= target){
				end = mid;
			}else {
				start = mid;
			}
		}
		if(nums[start] < nums[end]){
			return nums[start];
		}else {
			return nums[end];
		}
	}
	
	public int findMinI(int[] nums) {
		int min = nums[0];
		for(int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		return min;
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

public class FindMinimuminRotatedSortedArray {
	public static void main(String[] args) {
		OrderedArray1 array = new OrderedArray1(7);
		array.insert(4);
		array.insert(5);
		array.insert(6);
		array.insert(7);
		array.insert(0);
		array.insert(1);
		array.insert(2);
		array.display();
		int min = array.find();
		System.out.print(min);
		
	}
}