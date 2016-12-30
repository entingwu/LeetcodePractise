package data_structure;

import java.util.*;

class Triangle{
	private int n;
	private int[][] minSum;
	private List<List<Integer>> triangle;
	//1. BottomUp
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
		if(triangle == null || triangle.size() == 0){
			return 0;
		}
		/*1. state*/
		int n = triangle.size();
		int[][] sum = new int[n][n];
		
		/*2. initialize*/
		for(int i = 0; i < n; i++){
			sum[n-1][i] = triangle.get(n-1).get(i);
		}
		
		/*3. function*/
		for(int i = n - 2; i >= 0; i --){
			for(int j = 0; j <= i; j ++){
				sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
			}
		}
		/*4. answer*/
		return sum[0][0];
	}
	
	
	//2. Divide & Conquer
	public int minimumTotal1(List<List<Integer>> triangle) {
		if(triangle == null || triangle.size() == 0){
		  return 0;	
		}

		this.n = triangle.size();
		this.minSum = new int[n][n]; 
		this.triangle = triangle;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				minSum[i][j] = Integer.MAX_VALUE; 
			}
		}
		
		return traverse1(0,0);
		//search2(0,0,0);
		
	}
	
	public int traverse1(int x,int y){
		if(x >= n){
			return 0;
		}
		if(minSum[x][y] != Integer.MAX_VALUE){
			return minSum[x][y];
		}
		minSum[x][y] = Math.min(traverse1(x+1,y), traverse1(x+1,y+1)) 
				       + triangle.get(x).get(y);
		return minSum[x][y];
	}
	//3.
	public void search2(int x,int y,int sum){
		if(x >= n){
		   return;
		}
		if(sum + triangle.get(x).get(y) >= minSum[x][y]){
		   return;
		}
		minSum[x][y] = sum + triangle.get(x).get(y);
		search2(x+1, y, minSum[x][y]);
		search2(x+1, y+1, minSum[x][y]);
	}
}

public class DynamicProgram_Triangle {
	public static void main(String[] args) {
		

	}
}
