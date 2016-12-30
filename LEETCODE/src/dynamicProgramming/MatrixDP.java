package dynamicProgramming;

public class MatrixDP {
	/**1. MIN PATH SUM*/
	public int minPathSum(int[][] grid) {

		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		
		int row = grid.length;
		int col = grid[0].length;
		
		// 1. state
		int[][] sum = new int[row][col];
		sum[0][0] = grid[0][0];
		
		// 2. initialize
		for(int i = 1; i < row; i++){
			sum[i][0] = sum[i-1][0] + grid[i][0];//初始化第0列
		}
		for(int j = 1; j < col; j++){
			sum[0][j] = sum[0][j-1] + grid[0][j];//初始化第0行
		}
		
		// 3. function
		for(int i = 1; i < row ; i++){
			for(int j = 1; j < col ; j++){
				sum[i][j] = Math.min(sum[ i - 1 ][j],sum[i][j - 1]) + grid[i][j];
			}
		}
		// 4. result
		return sum[row - 1][col - 1];
    }
	
	
	/**2. UNIQUE PATHS
	 * The robot can only move either down or right at any point in time. 
	 * The robot is trying to reach the bottom-right corner of the grid 
	 * (marked 'Finish' in the diagram below).*/
	public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
        	return 0;
        }
		// 1. state
        int[][] pathSum = new int[m][n];
		pathSum[0][0] = 0;
		
		// 2. initialize
		for(int i = 0; i < m; i++){
			pathSum[i][0] = 1;//从(0,0)走到(i,0)的方案数
		}
		for(int j = 0; j < n; j++){
			pathSum[0][j] = 1;
		}
		
		// 3. function
		for(int i = 1; i <  m; i++){
			for(int j = 1; j < n; j++){
				pathSum[i][j] = pathSum[i - 1][j] + pathSum[i][j - 1];
			}
		}
		// 4. result
		return pathSum[m - 1][n - 1];
    }
	
	public int uniquePathWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) { return 0; }
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		/* 1. states */
		int[][] f = new int[m][n];
		//f[0][0] = 1; 障碍[[1]]
		
		/* 2. initialize */
		for(int i = 0; i < m; i++) {
			if(obstacleGrid[i][0] == 0) {
				f[i][0] = 1;
			}else {//obstacles，后面也不能走
				break;
			}
		}
		for(int j = 0; j < n; j++) {
			if(obstacleGrid[0][j] == 0) {
				f[0][j] = 1;
			}else {
				break;
			}
		}
		
		/* 3. function */
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 0) {
					f[i][j] = f[i][j-1] + f[i-1][j];
				}else {//==1
					f[i][j] = 0;
				}
			}
		}
		
		/* 4. answers */
		return f[m - 1][n - 1];	
	}
	
	public static void main(String[] args) {
		int[][] obstacleGrid = new int[3][3];
		obstacleGrid[0][0] = 0; obstacleGrid[0][1] = 0; obstacleGrid[0][2] = 0;
		obstacleGrid[1][0] = 0; obstacleGrid[1][1] = 1; obstacleGrid[1][2] = 0;
		obstacleGrid[2][0] = 0; obstacleGrid[2][1] = 0; obstacleGrid[2][2] = 0;
		
		int[][] obstacleGrid1 = new int[1][1];
		obstacleGrid[0][0] = 1;
		MatrixDP mdp = new MatrixDP();
		int num = mdp.uniquePathWithObstacles(obstacleGrid1);
		System.out.println(num);
	}
	
}
