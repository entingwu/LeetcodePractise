package hashmap;

public class ValidSodoku {
	
	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9) { return false; }
		/* 1. check each column */
		for(int i = 0; i < 9; i++) {
			boolean[] cols = new boolean[9];//每一列测一次
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					if(cols[board[i][j]-'1'] == true) {//同列有duplicate的数字
						return false;
					}
					cols[board[i][j]-'1'] = true;
				}
			}
		}
		/* 2. check each row */
		for(int j = 0; j < 9; j++) {
			boolean[] rows = new boolean[9];
			for(int i = 0; i < 9; i++) {
				if(board[i][j] != '.') {
					if(rows[board[i][j]-'1'] == true) {
						return false;
					}
					rows[board[i][j]-'1'] = true;
				}
			}
		}
		/* 3. check each 3*3 matrix*/
		for(int block = 0; block < 9; block++) {
			boolean[] matrix = new boolean[9];
			for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
				for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
					if (board[i][j] != '.') {
						if (matrix[board[i][j] - '1']) {
							return false;
						}
						matrix[board[i][j] - '1'] = true;
					}
				}
			}
		}
		return true;
	}
	
	public boolean isValidSudoku1(char[][] board){  
	    boolean [][] rows=new boolean[9][9];  
	    boolean [][] cols=new boolean[9][9];  
	    boolean [][] blocks=new boolean[9][9];  
	    for (int i = 0; i < 9; ++i) {    
	    	for (int j = 0; j < 9; ++j) {  
	        int c = board[i][j] - '1';  
	        if (board[i][j] == '.') continue;    
	        if (rows[i][c] || cols[j][c] || blocks[i - i % 3 + j / 3][c])    
	            return false;    
	        	rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;    
	        }    
	    }    
	    return true;    
	 }  
	
	public static void main(String[] args) {
		
	}
}
