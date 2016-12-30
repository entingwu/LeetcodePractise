package array;

public class SetMatrixZeros {

	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		/* 1. 第一行：标记是否有0 */
		boolean empty_row0 = false; 
		for(int i = 0; i < cols; i++) {
			if(matrix[0][i] == 0) { empty_row0 = true; }
		}
		
		/* 2. 第一列：标记是否有0 */
		boolean empty_col0 = false; 
		for(int i = 0; i < rows; i++) {
			if(matrix[i][0] == 0) { empty_col0 = true; }
		}
		
		/* 3. 在第一行、第一列标记该行列内是否有0 */
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				if(matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		/* 4. 全行全列置为0 */
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		/* 5. 往第一行、第一列填充0 */
		if(empty_row0) {
			for(int j = 0; j < cols; j++) {
				matrix[0][j] = 0;
			}
		}
		if(empty_col0) {
			for(int i = 0; i < rows; i++) {
				matrix[i][0] = 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}

}
