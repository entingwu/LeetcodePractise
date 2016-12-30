package dfs;

import java.util.*;

public class NQueens {
	
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<Integer> cols = new ArrayList<Integer>();//1 3 0 2
		if(n <= 0) { return result; }
		search(result, cols, n);
		return result;
	}
	
	private void search(List<List<String>> result, List<Integer> cols, int n) {
		if(cols.size() == n) {
			result.add(drawChessboard(cols));
			return;
		}
		for(int col = 0; col < n ; col++) {
			if(!colIsValid(cols, col)) {
				continue;
			}
			cols.add(col);
			search(result, cols, n);
			cols.remove(cols.size()-1);
		}
	}
	
	private boolean colIsValid(List<Integer> cols, int col) {
		int row = cols.size();
		for(int i = 0; i < row; i++) {//遍历之前走过的两行，看第三行的col位置是否与之前的cols.get(i)冲突
			int oldCol = cols.get(i);
			/* 1. Same Column */
			if(oldCol == col) {
				return false;
			}
			/* 2. 对角线 */
			int deltaX = Math.abs(i - row);
			int deltaY = Math.abs(col - oldCol);
			if(deltaX == deltaY) {
				return false;
			}
		}
		return true;
	}
	
	private List<String> drawChessboard(List<Integer> cols) {
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < cols.size(); i++) {
			String temp = "";
			for(int j = 0; j < cols.size(); j++) {
				if(j == cols.get(i)) {
					temp = temp + "Q";
				}else {
					temp = temp + ".";
				}
			}
			//temp = temp + '\n';
			result.add(temp);
		}
		return result;
	}
	
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		int n = 4;
		List<List<String>> result = nq.solveNQueens(n);
		System.out.println(result);

	}

}
