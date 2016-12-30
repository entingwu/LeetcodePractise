package dfs;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if(board.length == 0 || board[0].length == 0) { return false; }
		if(word.length() == 0) { return true; }
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				/* 在board[i][j]这个位置能不能找到word */
				if(boardDFS(board, i, j, word, 0)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean boardDFS(char[][] board, int i, int j, String word, int pos) {
		if(pos == word.length()) {//base case
			return true;
		}
		
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
			return false;
		}
		if(board[i][j] != word.charAt(pos) || board[i][j] == '#') { 
			return false; 
		}
		
		/* board[i][j] == word.charAt(pos) */
		char mark = word.charAt(pos);//1.存储,为了避免走到曾走过的地方
		board[i][j] = '#';//2.标记
		boolean result = boardDFS(board, i-1, j, word, pos+1) || boardDFS(board, i, j-1, word, pos+1)
					|| boardDFS(board, i+1, j, word, pos+1) || boardDFS(board, i, j+1, word, pos+1);
		
		board[i][j] = mark;//3.恢复
		return result;
	}
	
	public static void main(String[] args) {
		char[][] board = new char[3][4];
		board[0][0] = 'A'; board[0][1] = 'B'; board[0][2] = 'C'; board[0][3] = 'E';
		board[1][0] = 'S'; board[1][1] = 'F'; board[1][2] = 'C'; board[1][3] = 'S';
		board[2][0] = 'A'; board[2][1] = 'D'; board[2][2] = 'E'; board[2][3] = 'E';
		
		WordSearch ws = new WordSearch();
		String word = "ABCB";
		System.out.println(ws.exist(board, word));
	}

}
