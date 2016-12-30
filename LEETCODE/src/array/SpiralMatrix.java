package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length == 0) { return result; }
		int rowStart = 0;
		int rowEnd = matrix[0].length - 1;//横结束
		int colStart = 0;
		int colEnd = matrix.length - 1;//竖结束
		while(rowStart <= rowEnd && colStart <= colEnd) {
			for(int j = rowStart; j < rowEnd; j++) {
				result.add(matrix[colStart][j]);
			}
			for(int i = colStart ; i <= colEnd; i++) {
				result.add(matrix[i][rowEnd]);
			}
			//是否能回去。只有一行则不需向左回去
			if(colStart < colEnd) {
				for(int j = rowEnd-1; j >= rowStart; j-- ) {
					result.add(matrix[colEnd][j]);
				}
			}
			//是否能回去。只有一列则不需向上回去
			if(rowStart < rowEnd) {
				for(int i = colEnd-1; i >= colStart+1; i--) {//i>=colStart+1 ==> 5
					result.add(matrix[i][rowStart]);
				}
			}
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--; 
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1; matrix[0][1] = 2; matrix[0][2] = 3;
		matrix[1][0] = 4; matrix[1][1] = 5; matrix[1][2] = 6;
		matrix[2][0] = 7; matrix[2][1] = 8; matrix[2][2] = 9;
		
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> result = sm.spiralOrder(matrix);
		System.out.println(result);
	}

	public List<Integer> spiralOrderI(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if(matrix.length == 0 || matrix[0].length == 0) { return result; }
		int rowStart = 0;
		int rowEnd = matrix[0].length - 1;//横结束
		int colStart = 0;
		int colEnd = matrix.length - 1;//竖结束
		while(rowStart <= rowEnd && colStart <= colEnd) {
			for(int j = rowStart; j < rowEnd; j++) {
				result.add(matrix[colStart][j]);
			}
			for(int i = colStart ; i < colEnd; i++) {
				result.add(matrix[i][rowEnd]);
			}
			//是否能回去。只有一行则不需向左回去
			if(colStart < colEnd) {
				for(int j = rowEnd; j > rowStart; j-- ) {
					result.add(matrix[colEnd][j]);
				}
			}
			//是否能回去。只有一列则不需向上回去
			if(rowStart < rowEnd) {
				for(int i = colEnd; i > colStart; i--) {
					result.add(matrix[i][rowStart]);
				}
			}
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--; 
			
		}
		return result;
	}
	
}
