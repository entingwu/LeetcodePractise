package dfs;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int cells = 0, neighbors = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    cells++;
                    neighbors += (i - 1 >= 0 && grid[i - 1][j] == 1)? 1 : 0;// down
                    neighbors += (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 1)? 1 : 0;// right
                }
            }
        }
        return cells * 4 - neighbors * 2;
    }

    private int sum = 0;
    public int islandPerimeterI(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return sum;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = -1;
        sum += (i == 0 || grid[i - 1][j] == 0) ? 1 : 0;// top
        sum += (j == 0 || grid[i][j - 1] == 0) ? 1 : 0;// left
        sum += (i == grid.length - 1 || grid[i + 1][j] == 0) ? 1 : 0;// down
        sum += (j == grid[0].length - 1 || grid[i][j + 1] == 0) ? 1 : 0;// right
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j);
    }

    public static void main(String[] args) {
        IslandPerimeter islp = new IslandPerimeter();
        int[][] grid = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        System.out.println(islp.islandPerimeter(grid));
    }
}
