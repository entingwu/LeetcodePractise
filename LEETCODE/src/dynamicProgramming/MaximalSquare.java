package dynamicProgramming;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
		int row = matrix.length;
		int col = matrix[0].length;
		int max = 0;
		/* 1. states */
		int[][] f = new int[row][col];
		
		/* 2. initialize */
		for(int i = 0; i < row; i++) {
			f[i][0] = matrix[i][0]-'0';
			max = Math.max(max, f[i][0]);
		}
		for(int j = 0; j < col; j++) {
			f[0][j] = matrix[0][j]-'0';
			max = Math.max(max, f[0][j]);
		}
		
		/* 3. function 
		 *    f[i][j] 表示以i和j作为正方形右下角可以拓展的最大边长*/
		for(int i = 1; i < row; i++) {
			for(int j = 1; j < col; j++) {
				if(matrix[i][j] == '1') {
					int min = Math.min(Math.min(f[i-1][j-1], f[i-1][j]),f[i][j-1]);//周围最小为1，证明是个2*2正方形
					f[i][j] = min + 1;//当前的1
				}else {//matrix[i][j] == '0'
					f[i][j] = 0;
				}
				max = Math.max(f[i][j], max);
			}
		}
		/* 4. answer */
		return max*max;
	}
	
	public static void main(String[] args) {
		char[][] matrix = new char[4][5];
		matrix[0][0] = '1'; matrix[0][1] = '0'; matrix[0][2] = '1'; matrix[0][3] = '0'; matrix[0][4] = '0';
		matrix[1][0] = '1'; matrix[1][1] = '0'; matrix[1][2] = '1'; matrix[1][3] = '1'; matrix[1][4] = '1';
		matrix[2][0] = '1'; matrix[2][1] = '1'; matrix[2][2] = '1'; matrix[2][3] = '1'; matrix[2][4] = '1';
		matrix[3][0] = '1'; matrix[3][1] = '0'; matrix[3][2] = '0'; matrix[3][3] = '1'; matrix[3][4] = '0';
		
		
		char[][] matrix1 = new char[4][3];
		matrix[0][0] = '0'; matrix[0][1] = '0'; matrix[0][2] = '0'; 
		matrix[1][0] = '0'; matrix[1][1] = '0'; matrix[1][2] = '0';
		matrix[2][0] = '0'; matrix[2][1] = '0'; matrix[2][2] = '0'; 
		matrix[3][0] = '0'; matrix[3][1] = '0'; matrix[3][2] = '0'; 
		
		MaximalSquare ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(matrix1));
	}

}
