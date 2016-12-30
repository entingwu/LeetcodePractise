package dynamicProgramming1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PebblingCheckerboard {
	Map<Integer, List<Integer>> pattern = new HashMap<Integer, List<Integer>>();
	Map<Integer, List<Integer>> compatible = new HashMap<Integer, List<Integer>>();
	public PebblingCheckerboard() {
		/* 1. pattern */
		for(int i = 0; i < 8; i++) {
			List<Integer> pebblePos = new ArrayList<Integer>();
			if(i >= 1 && i <= 4) {
				pebblePos.add(i-1);
			}else if(i == 5) {
				pebblePos.add(0);  pebblePos.add(2);
			}else if(i == 6) {
				pebblePos.add(0);  pebblePos.add(3);
			}else if(i == 7) {
				pebblePos.add(1);  pebblePos.add(3);
			}
			pattern.put(i, pebblePos);
		}
		
		/* 2. compatible */
		List<Integer> comp = new ArrayList<Integer>();
		comp.add(0);comp.add(1);comp.add(2);comp.add(3);comp.add(4);comp.add(5);comp.add(6);comp.add(7);
		compatible.put(0, comp);comp = new ArrayList<Integer>(); 
		
		comp.add(0);comp.add(2);comp.add(3);comp.add(4);comp.add(7);
		compatible.put(1, comp);comp = new ArrayList<Integer>();
		
		comp.add(0);comp.add(1);comp.add(3);comp.add(4);comp.add(5);comp.add(6);
		compatible.put(2, comp);comp = new ArrayList<Integer>();
		
		comp.add(0);comp.add(1);comp.add(2);comp.add(4);comp.add(6);comp.add(7);
		compatible.put(3, comp);comp = new ArrayList<Integer>();
		
		comp.add(0);comp.add(1);comp.add(2);comp.add(3);comp.add(5);comp.add(7);
		compatible.put(4, comp);comp = new ArrayList<Integer>();
		
		comp.add(0);comp.add(2);comp.add(4);comp.add(7);
		compatible.put(5, comp);comp = new ArrayList<Integer>();
		
		comp.add(0);comp.add(2);comp.add(3);
		compatible.put(6, comp);comp = new ArrayList<Integer>();
		
		comp.add(0);comp.add(1);comp.add(3);comp.add(5);
		compatible.put(7, comp);comp = new ArrayList<Integer>();

	}
	
	public int maxPebbleValueSum(int[][] matrix) {
		/*1. state*/
		int colNum = matrix[0].length;
		int [][]dp = new int[colNum+1][8];
		//dp[i][j]: from 0 ~ ith columns, when ith col picks jth pattern, the maximum sum of pebblePos
		
		/*2. initialize*/
		for(int j = 0; j < 8; j++) {
			dp[0][j] = 0; 
		}
		
		/*3. function*/
		for (int i = 1 ; i <= colNum ; ++i) {//ith column in matrix
			for(int j = 0; j < 8 ; ++j) {//jth pattern
				for (int k : compatible.get(j)) {//kth compatible patterns of jth pattern 
					dp[i][j] = Math.max(dp[i-1][k] + getMatrixValue(j, i-1, matrix), dp[i][j]);
					//jth patternIndex(mask), i-1 columnIndex, matrix[][]
				}
			}
		}
		/*4. answer*/
		int maxScore = 0;
		for (int j = 0; j < 8; ++j) {
			maxScore = Math.max(maxScore, dp[colNum][j]);
		}
		return maxScore;
	}
	
	private int getMatrixValue(int patternIdx, int col, int[][] matrix) {
		int value = 0; 
		for (Integer pebblePos : pattern.get(patternIdx)) {
			value += matrix[pebblePos][col];
		}
		return value;
	}
	
	public static void main(String[] args) {
		int [][] matrix = { {2,3,4}, {1,3,4}, {4,4,5}, {3,2,1}};
		PebblingCheckerboard b = new PebblingCheckerboard();
		int ret = b.maxPebbleValueSum(matrix);
		System.out.print(ret);

	}
	
	/* 2. compatible */
	/*for(int i = 0; i < 8; i++) {
		List<Integer> list = new ArrayList<Integer>();
		boolean isContains = false;
		for(int j : pattern.keySet()) {//compatible
			if(j!=i) {
					for(int val : pattern.get(i)) {
						if (pattern.get(j).contains(val)) {
							isContains = true;
						}
					}
					
				if (!isContains) {
					list.add(j);
				}
			}
		}
		compatible.put(i, list);
	}
	int a = 10;
	a =a -1;*/

}
