package dynamicProgramming2;

import java.util.ArrayList;
import java.util.List;

public class StringCutCost {
	
	public int cutCost(char[] str, int[] cutPoints) {
		/*1. state*/
		int strLen = str.length;
		int[][] f = new int[strLen][strLen];
		//f[i][j] : the minimum cost of breaking str[i]~str[j] in the pieces
		
		/*2. function*/
		for(int len = 0; len < strLen; len++) {
			for(int i = 0; i < strLen - len; i++) {//start
				int j = i + len;
				int[] points = getCutPoints(cutPoints, i, j);//point in [i,j]
				if(points == null) {
					// no points in [i,j], do not need to save the original string
					f[i][j] = 0;
				}else if(points.length == 1) {
					// save the length of [i,j] 
					f[i][j] = j - i + 1;
				}else {//many points in [i,j]
					int minCost = Integer.MAX_VALUE;
					for(int pt : points) {
						minCost = Math.min(f[i][pt-1] + f[pt][j] + (j-i+1), minCost);
					}
					f[i][j] = minCost;
				}
			}
		}
		/*3. answer*/
		return f[0][strLen-1];
	}
	
	private int[] getCutPoints(int[] cutPoints, int start, int end) {
		//if there are cutPoints in [i,j], return the indice of points
		List<Integer> list = new ArrayList<Integer>();
		for(int pt : cutPoints) {
			if(start <= pt && pt <= end) {
				list.add(pt);
			}
		}
		if(list.size() == 0) { return null; }
		int[] points = new int[list.size()];
		for(int i = 0; i < points.length; i++) {
			points[i] = list.get(i);
		}
		return points;
	}
	
	public static void main(String[] args) {
		char[] str = {'a','b','c','d','e','f'};//6
		int[] cutPoints = {2, 4};
		StringCutCost scc = new StringCutCost();
		System.out.println(scc.cutCost(str, cutPoints));
	}

}
