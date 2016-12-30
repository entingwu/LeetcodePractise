package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {
	/** 这题就是不停的DFS, 直到 n == 1. 有个判断条件 if (item.size() > 1)  是为了防止答案是自己本身n, 按照题意, 这是不允许的.
		可能有人会立刻想, 那为什麽不在for回圈终止条件就设置 i < n, 这样的话, 当用 n / i进入下一个DFS时, 会漏掉答案, 例如:
		时间复杂度, 个人觉得是O(n*log(n)), 一开始觉得是O(n!), 但後来想想好像没那麽大. 我的想法是,
		最一开始的for回圈是n, 但是一旦进入了下一个DFS, 每次最差都是 n / i在减小, 这边就是log(n), 所以总共是O(n*log(n)), 有错还请指正.*/

	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		if(n <= 3) { return result; }//0 1 2 3
		factorHelper(result, temp, 2, n);//start == 2
		return result;
	}
	
	private void factorHelper(List<List<Integer>> result, List<Integer> temp, int start, int n) {
		if(n == 1 && temp.size()!=1) {//temp.size() == 1即输入数
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for(int i = start; i <= n; i++) {
			if(n % i == 0) {
				temp.add(i);
				factorHelper(result, temp, i, n/i);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		FactorCombinations fc = new FactorCombinations();
		int n = 4;
		List<List<Integer>> result = fc.getFactors(n);
		System.out.println(result);
	}

}
