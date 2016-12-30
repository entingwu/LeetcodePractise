package dfs;

public class NumbersOfIslands {
	
	public int numIslands(char[][] grid) {
		int num = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					num++;
					markDFS(i, j, grid);
				}
			}
		}
		return num;
	}
	
	private void markDFS(int i, int j, char[][] grid) {
		if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}
		if(grid[i][j] == '0' || grid[i][j] == '2') {
			return;
		}
		if(grid[i][j] == '1') {
			grid[i][j] = '2';
			markDFS(i-1, j, grid);
			markDFS(i+1, j, grid);
			markDFS(i, j-1, grid);
			markDFS(i, j+1, grid);
		}
	}
	
	public static void main(String[] args) {
		char[][] test1 = new char[4][5];
		for(int i = 0; i < test1.length; i++) {
			for(int j = 0; j < test1[0].length; j++) {
				test1[i][j] = '0';
			}
		}
		test1[0][0] = '1'; test1[0][1] = '1';
		test1[1][0] = '1'; test1[1][1] = '1'; test1[2][2] = '1';
		test1[3][3] = '1'; test1[3][4] = '1';
		
		NumbersOfIslands ni = new NumbersOfIslands();
		System.out.println("Numbers of Islands: " + ni.numIslands(test1));
	}
}
