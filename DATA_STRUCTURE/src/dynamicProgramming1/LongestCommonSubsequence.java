package dynamicProgramming1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
	/* 1. Problem One */
	public int[][] longestCommonSubsequence(int[] A, int[] B) {
		/*1. state*/
		int m = A.length, n = B.length;
		int[][] f = new int[m + 1][n + 1];
		//第1个字符串的前i个字符，配上第2个字符串的前j个字符的最长公共子序列长度
		
		/*2. initialize*/
		for(int i = 0; i <= m; i++) {//第0列
			f[i][0] = 0;
		}
		for(int j = 0; j <= n; j++) {//第0行
			f[0][j] = 0;
		}
		
		/*3. function*/
		for(int i = 1; i <=m; i++) {
			for(int j = 1; j <=n; j++) {
				f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);//A[i-1]!=B[j-1]
				if(A[i - 1] == B[j - 1]) {//第i个，下标为i-1
					f[i][j] = Math.max(f[i - 1][j - 1] + 1, f[i][j]);
				}
			}
		}
		
		/*4. answer*/
		//return f[m][n];
		return f;
	}
	/* 1.1. Find solution */
	public List<Integer> lcsSolution(int[] A, int[] B, int[][] f) {
		List<Integer> solution = new ArrayList<Integer>();
		int i = A.length, j = B.length;
		while(i > 0 && j > 0) {
			if(A[i-1] == B[j-1]) {
				solution.add(0, A[i-1]);
				i--;
				j--;
			}else if(f[i-1][j] < f[i][j-1]) {//相同的是从上或左来(大)，+1的是斜来(小)，所以要取大的，f[i][j-1]对应j-1
				j--;
			}else {
				i--;
			}
		}
		return solution;
	}
	
	/* 2. Problem Two */
	public int longestCommonSubsequenceI(int[] A, int[] B) {
		/*1. state*/
		int m = A.length, n = B.length;
		int[][] f = new int[2][n + 1];//2*(n+1)的滚动数组，类似窗口
		int result = 0;
		//第1个字符串的前i个字符，配上第2个字符串的前j个字符的最长公共子序列长度
		
		/*2. initialize*/
		for(int i = 0; i <= m; i++) {//第0列
			f[i % 2][0] = 0;
		}
		for(int j = 0; j <= n; j++) {//第0行
			f[0][j] = 0;
		}
		
		/*3. function*/
		for(int i = 1; i <=m; i++) {
			for(int j = 1; j <=n; j++) {
				f[i % 2][j] = Math.max(f[(i - 1) % 2][j], f[i % 2][j - 1]);//A[i-1]!=B[j-1]
				if(A[i - 1] == B[j - 1]) {//第i个，下标为i-1
					f[i % 2][j] = Math.max(f[(i - 1) % 2][j - 1] + 1, f[i % 2][j]);
				}
				result = Math.max(f[i % 2][j], result);
			}
		}
		/*4. answer*/
		return result;
	}
	
	/* 3. Problem Three : Divide & Conquer + Memorizaiton */
	public int longestCommonSubsequenceII(int[] A, int[] B) {
		int m = A.length, n = B.length;
		int[][] hash = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				hash[i][j] = -1;
			}
		}
		int maxLength = lcsMemorization(A, m - 1, B, n - 1, hash);
		return maxLength;
	}
	
	private int lcsMemorization(int[] A, int i, int[] B, int j, int[][] hash) {
		if(i == 0 || j == 0) {
			if(A[i] == B[j]) {
				return 1;
			}
			return 0;
		}
		if(hash[i][j] == -1) {//之前递归已算，存起来再return
			hash[i][j] = Math.max(lcsMemorization(A, i - 1, B, j, hash), lcsMemorization(A, i, B, j - 1, hash));
			if(A[i] == B[j]) {
				hash[i][j] = lcsMemorization(A, i - 1, B, j, hash) + 1;
			}
		}
		return hash[i][j];
	}
	
	
	public static void main(String[] args) {
		int[] A = {1,0,0,1,0,1,0,1};
		int[] B = {0,1,0,1,1,0,1,1,0};
		int[] C = {1,2,3,4,5};
		int[] D = {2,4,3,5};
		/*Problem One*/
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int[][] result = lcs.longestCommonSubsequence(A, B);
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		//1.1
		List<Integer> solution = lcs.lcsSolution(C, D, result);
		System.out.println(solution);
		
		/*Problem Two*/
		int length = lcs.longestCommonSubsequenceII(C, D);
		System.out.println(length);
	
	
		
	}

}
