package data_structure;

class OrderArray1{
	private int[] array;
	private int nElement;
	public OrderArray1(int max){
		array = new int[max];
		nElement = 0;
	}
	public int size(){
		return nElement;
	}
	public int find(int target){
		return binarySearch(array,target);
	}
	public int binarySearch(int[] nums,int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while(start + 1 < end){
			int mid = (start + end)/2;
			if(nums[mid] == target){
				end = mid;
			}else if(nums[mid] < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(nums[start] == target){
			return start;
		}
		if(nums[end] == target){
			return end;
		}
		return -1;
	}
	
	
	public int binarySearch1(int[] nums,int target){
		int lowerBound = 0,upperBound = nums.length-1;
		int mid = 0;
		while(lowerBound <= upperBound){
			mid = lowerBound + (upperBound - lowerBound)/2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid]>target){
				upperBound = mid-1; 
			}else{
				lowerBound = mid+1;
			}
		}
		return -1;
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
public class Course2_BinarySearch {
	public static void main(String[] args) {
		OrderArray1 array = new OrderArray1(9);
		array.insert(2);
		array.insert(3);
		array.insert(5);
		array.insert(8);
		array.insert(13);
		array.insert(21);
		array.insert(34);
		array.insert(55);
		array.insert(89);
		array.display();
	    int targetIndex = array.find(13);
		System.out.println("target at " + targetIndex);

	}	
}


