package dynamicProgrammingII;

public class PaintHouse {

	public int minCost(int[][] costs) {
		if(costs.length == 0 || costs[0].length == 0) { return 0; }
		/* 1. state */
		int num = costs.length;
		int[][] f = new int[num][3];
		int result = 0;
		
		/* 2. initialize */
		f[0][0] = costs[0][0];
		f[0][1] = costs[0][1];
		f[0][2] = costs[0][2];
		
		/* 3. function */
		for(int i = 1; i < costs.length; i++) {
			f[i][0] = costs[i][0] + Math.min(f[i-1][1], f[i-1][2]);
			f[i][1] = costs[i][1] + Math.min(f[i-1][0], f[i-1][2]);
			f[i][2] = costs[i][2] + Math.min(f[i-1][0], f[i-1][1]);
		}
		
		/* 4. answer */
		result = Math.min(f[num-1][2],Math.min(f[num-1][0],f[num-1][1]));
		return result;
	}
	
	public static void main(String[] args) {
		

	}

}
