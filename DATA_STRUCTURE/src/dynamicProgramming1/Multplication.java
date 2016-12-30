package dynamicProgramming1;

import java.util.HashSet;
import java.util.Set;

public class Multplication {

	public boolean multiply(int[][] matrix, int[] str, int n, int found) {
		/*1. state*/
		Set<Integer>[][] dp = new HashSet[n][n];
		
		/*2. initialize*/
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				Set<Integer> cell = new HashSet<Integer>();
				if(i == j) {
					cell.add(str[i]);
				}
				dp[i][j] = cell;//diagonal
			}
		}
		
		/*3. function*/
		for(int i = n-2; i >= 0; i--) {
			for(int j = i; j < n; j++) {
				for(int val : dp[i+1][j]){//dp[2][4] = str[2] U dp[3][4] (i=2,j=4)
					dp[i][j].add(matrix[str[i]][val]);
				}
				if(j > i){
					for(int val : dp[i][j-1]) {//dp[2][4] = dp[2][3] U str[4] (i=2,j=4)
						dp[i][j].add(matrix[val][str[j]]);
					}
				}
			}
		}
		
		/*4. answer*/
		return dp[0][n-1].contains(found);
	}
	
	public static void main(String[] args) {
		Multplication mpl = new Multplication();
		int[] string = {1, 1, 1, 1, 0, 2};
		int[] string1 = {1, 0, 2};
		int[][] matrix = {
				{1, 1, 0}, 
				{2, 1, 0}, 
				{0, 2, 2}
		};
		int found = 0;//a
		System.out.println(mpl.multiply(matrix, string, string.length, found));
		
	}

}
