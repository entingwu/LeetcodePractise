package dfs;

import java.util.ArrayList;

public class NQueenII {
	private int sum = 0;
	public int totalNQueens(int n) {
		if(n <= 0) { return 0; }
		ArrayList<Integer> cols = new ArrayList<Integer>();
		search(cols, n);
		return sum;
	}
	
	private void search(ArrayList<Integer> cols, int n) {
		if(cols.size() == n) { 
			sum++;
			return;
		}
		for(int col = 0; col < n; col++) {
			if(!isValid(cols, col)) { continue; }
			cols.add(col);
			search(cols, n);
			cols.remove(cols.size()-1);
		}
	}
	
	private boolean isValid(ArrayList<Integer> cols, int col) {
		int row = cols.size();
		for(int i = 0; i < row; i++) {
			int oldCol = cols.get(i);
			if(col == oldCol) { return false; }
			int deltaX = Math.abs(i - row);
			int deltaY = Math.abs(oldCol - col);
			if(deltaX == deltaY) { return false; }
		}
		return true;
	}
	
	public static void main(String[] args) {
		NQueenII nq = new NQueenII();
		int num = nq.totalNQueens(4);
		System.out.println(num);
	}

}
