package dynamicProgramming2;

/* Problem 10 : at most once */
public class SubsetSum {
	public boolean subsetSum(int[] num, int V) {
		/*1. state*/
		int N = num.length;
		boolean[][] f = new boolean[V + 1][N + 1];
		
		/*2. initialize*/
		f[0][0] = true;
		for(int i = 1; i <= N; i++ ) {//0-ith
			f[0][num[i-1]] = true;//any coins no value
		}
		/*3. function*/
		for(int v = 1; v <= V; v++) {
			for(int i = 1; i <= N; i++) {
				f[v][i] = f[v][i-1] || f[v][i];
				if(v - num[i-1] >= 0) {
					f[v][i] = f[v - num[i-1]][i-1] || f[v][i];
				}
			}
		}
		
		/*4. answer*/
		return f[V][N];
		
	}
	
	public static void main(String[] args) {
		int[] num = {1, 2, 3, 4};
		int target = 8;
		SubsetSum ss = new SubsetSum();
		System.out.println(ss.subsetSum(num, target));
	}
}
