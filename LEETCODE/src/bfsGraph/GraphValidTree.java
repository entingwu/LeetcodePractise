package bfsGraph;

import java.util.Arrays;

public class GraphValidTree {
	/**Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
	 * i=0, find(0) find(1), union(0,1), father[0] = 1
	 * i=1, find(1) find(2), union(1,2), father[1] = 2
	 * i=2, find(2) find(3), union(2,3), father[2] = 3
	 * i=3, find(1) find(3), 3 == 3 false
	 * */
	public boolean validTree(int n, int[][] edges) {
		if(edges.length != n-1) { return false; }//边数等于顶点数减一
		/*1. initialize*/
		int[] father = new int[n];
		Arrays.fill(father, -1);
		
		/*2. union find*/
		for(int i = 0; i < edges.length; i++) {//找到start点通过edge能到达的最远点,是否等于end点
			int start = edges[i][0], end = edges[i][1];
			/*a. find*/
			int startFather = find(father, start);
			int endFather = find(father, end);
			if(startFather == endFather) {// if two vertices happen to be in the same set, then there's a cycle
				return false;
			}
			/*b. union*/
			father[startFather] = endFather;
		}
		return true;
	}
	/* find father recursively */
	private int find(int[] father, int i) {
		if(father[i] == -1) { return i; }//没被更新
		return find(father, father[i]);//find grandparent
	}
	
	public static void main(String[] args) {
		

	}

}
