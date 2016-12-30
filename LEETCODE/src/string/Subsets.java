package string;
import java.util.*;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int psLen = 1<<nums.length;
		Arrays.sort(nums);
		for(int i=0; i < psLen; i++){
			List<Integer> temp = new ArrayList<Integer>();
			for(int j=0; j < nums.length;j++){
				if((i&(1<<j))!=0){
					temp.add(nums[j]);
				}
			}
		    result.add(temp);
		}	
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Subsets sub = new Subsets();
		List<List<Integer>> res = sub.subsets(nums);
		for(List<Integer> e : res){
			System.out.print(e+" ");
		}
	}

}
