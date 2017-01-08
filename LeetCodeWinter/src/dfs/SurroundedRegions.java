package dfs;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j);
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {// edges
                    board[i][j] = 'O';
                }
            }
        }
    }

    /* Four edges of board */
    private void dfs(char[][] board, int x, int y) {
        board[x][y] = 'T';
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for (int k = 0; k < 4; k++) {
            int nextX = x + dx[k];
            int nextY = y + dy[k];
            // inner cycle without edge.
            if (nextX > 0 && nextX < board.length - 1 && nextY > 0 && nextY < board[0].length - 1 && board[nextX][nextY] == 'O') {
                dfs(board, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        char[][] board1 = {
            {'O', 'O'},
            {'O', 'O'}
        };
        sr.solve(board);
        sr.print(board);
    }

    private void print(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.println();
        }
    }
}
