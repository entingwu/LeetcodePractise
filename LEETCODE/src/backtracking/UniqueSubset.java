package backtracking;

import java.util.*;

class SubsetsII{
	public List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){ return res; }
		Arrays.sort(nums);
		List<Integer> path = new ArrayList<Integer>();
		addSet(res,path,0,nums);
		return res;
	}
	public void addSet(List<List<Integer>> res,List<Integer> path,int pos,int[] nums){
		res.add(new ArrayList<Integer>(path));
		System.out.println(res+"");
		for(int i = pos; i<nums.length; i++){
			if(i!=pos && nums[i] == nums[i-1]){
				continue;
			}else{
				path.add(nums[i]);
				addSet(res,path,i+1,nums);
				path.remove(path.size()-1);
			}
		}
	}
}

public class UniqueSubset {
	public static void main(String[] args) {
		int[] nums = {1,2};
		SubsetsII sub = new SubsetsII();
		List<List<Integer>> res = sub.subsetsWithDup(nums);
		for(List<Integer> e : res){
			System.out.print(e+" ");
		}
	}

}
