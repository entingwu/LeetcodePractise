package sortedArray;

import java.util.ArrayList;

class SortedArray{
	ArrayList<Integer> nums = new ArrayList<Integer>();
	public void insert(int n){
		nums.add(n);
	}
	public void display(){
		for(int i=0; i<nums.size(); i++){
			System.out.print(nums.get(i)+" ");
		}
		System.out.println();
	}
	public void recoverRotateSortedArray(ArrayList<Integer> nums){
		for(int index = 0; index < nums.size() - 1; index++){
			if(nums.get(index) > nums.get(index + 1)){
				reverse(nums, 0, index);
				reverse(nums, index + 1, nums.size() - 1);
				reverse(nums, 0, nums.size() - 1);
			}
		}
	}
	public void reverse(ArrayList<Integer> nums, int start, int end){
		for(int i = start, j = end; i<j; i++, j--){
			int temp = nums.get(i);
			nums.set(i, nums.get(j));
			nums.set(j, temp);
		}
	}
}

public class RecoverRotatedSortedArray {
	public static void main(String[] args) {
		SortedArray array = new SortedArray();
		array.insert(4); array.insert(5); array.insert(1);
		array.insert(2); array.insert(3);
		array.display();
		array.recoverRotateSortedArray(array.nums);
		array.display();
	}
}
