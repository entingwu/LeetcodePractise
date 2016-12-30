package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	/* 1. DFS, 类似递归遍历二叉树 */
	int minSum = Integer.MAX_VALUE;
	public int minimumTotalDFS(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) { return 0; }
		minDFS(0, 0, 0, triangle);
		return minSum;
	}
	private void minDFS(int x, int y, int sum, List<List<Integer>> triangle) {//从0~n-1层
		if(x == triangle.size()) {//走到第n层，即虚无的一层
			minSum = Math.min(minSum, sum);
			return;
		}
		minDFS(x + 1, y, sum + triangle.get(x).get(y), triangle);
		minDFS(x + 1, y + 1, sum + triangle.get(x).get(y), triangle);
	}
	
	/* 2. Divide & Conquer */
	public int minimumTotalDC(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) { return 0; }
		//int minSum = divideConquer(0, 0, triangle);
		int[][] hash = new int[triangle.size()][triangle.size()]; 
		for(int i = 0; i < hash.length; i++) {
			for(int j = 0; j < hash[0].length; j++) {
				hash[i][j] = -1;
			}
		}
		int minSum = divideConquerII(0, 0, hash, triangle);
		return minSum;
	}
	private int divideConquer(int x, int y, List<List<Integer>> triangle) {
		if(x == triangle.size()) { return 0; }
		return triangle.get(x).get(y) 
				+ Math.min(divideConquer(x+1, y, triangle), 
				divideConquer(x+1, y+1, triangle));
	}
	
	/* 3. Divide & Conquer + Memorizaiton */
	
	public int divideConquerII(int x, int y, int[][] hash, List<List<Integer>> triangle) {
		if(x == triangle.size()) {
			return 0;
		}
		if(hash[x][y] == -1) {//之前递归已算，存起来再return
			hash[x][y] = triangle.get(x).get(y) + Math.min(divideConquerII(x+1, y, hash, triangle) , 
					     divideConquerII(x+1, y+1, hash, triangle));
		}
		return hash[x][y];
	}
	
	/* 4. Dynamic Programming */
	public int minimumTotalDP(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0) { return 0; }
		/*1. state: f[i][j]*/
		int n = triangle.size();
		int[][] sum = new int[n][n];
		/*2. initialize*/
		for(int j = 0; j < triangle.get(n-1).size(); j++) {
			sum[n-1][j] = triangle.get(n-1).get(j);
		}
		/*3. function*/
		for(int i = n-2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				sum[i][j] += triangle.get(i).get(j) + Math.min(sum[i+1][j], sum[i+1][j+1]);
			}
		}
		/*4. answer*/
		return sum[0][0];
	}
	
	public static void main(String[] args) {
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		temp.add(2); test.add(new ArrayList(temp)); temp.clear();
		temp.add(3); temp.add(4); test.add(new ArrayList(temp)); temp.clear();
		temp.add(6); temp.add(5); temp.add(7); test.add(new ArrayList(temp)); temp.clear();
		temp.add(4); temp.add(1); temp.add(8); temp.add(3); test.add(new ArrayList(temp)); temp.clear();
		System.out.println(test);
		
		Triangle tr = new Triangle();
		System.out.println(tr.minimumTotalDC(test));
		
		System.out.println(tr.minimumTotalDP(test));
	}

}
