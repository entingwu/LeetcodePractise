package recursive;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		Permutation p = new Permutation();
		int [] nums = {1,2,3};
		List<List<Integer>> res = p.permute(nums);
		for(List<Integer> e : res){
			System.out.print(e);
		}

	}
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> restore = new ArrayList<List<Integer>>();
    	List<Integer> numList = new ArrayList<Integer>();
    	for(int i=0;i<nums.length;i++){
    		numList.add(nums[i]);
    	}
    	permuteHelper(restore,numList,0);
    	return restore;
    }
    public void permuteHelper (List<List<Integer>> res,List<Integer> numList, int i ) {
        if(i == numList.size()){
        	res.add(new ArrayList<Integer>(numList));
        }else{
        	for(int pos=i;pos<numList.size();pos++){
        		swap(numList,i,pos);
        		permuteHelper(res,numList,i+1);
        		swap(numList,i,pos);
        	}
        }
    }
    
    public void swap(List<Integer> numList,int i,int j){
    	int temp = numList.get(i);
    	numList.set(i, numList.get(j));
    	numList.set(j, temp);
    }
}
