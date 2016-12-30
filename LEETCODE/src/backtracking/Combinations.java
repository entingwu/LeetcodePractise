package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		combineHelper(result,temp, n, k, 1);
		return result;
	}
	
	private void combineHelper(List<List<Integer>> result, List<Integer> temp, int n, int k, int pos) {
		if(k == 0) {
			result.add(new ArrayList(temp));
			return;
		}
		for(int i = pos; i <= n ; i++) {
			temp.add(i);
			combineHelper(result, temp, n, k-1, i+1);//新开始的位置为i+1
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		
		Combinations cs = new Combinations();
		List<List<Integer>> result = cs.combine(n, k);
		System.out.println(result);
	}

}
