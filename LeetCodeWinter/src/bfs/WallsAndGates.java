package bfs;

/* http://www.cnblogs.com/grandyang/p/5285868.html */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int level) {
        if (i < 0 || i > rooms.length - 1 || j < 0 || j > rooms[0].length - 1 || rooms[i][j] < level) {//Don't need to change
            return;
        }
        rooms[i][j] = level;
        dfs(rooms, i - 1, j, level + 1);
        dfs(rooms, i, j - 1, level + 1);
        dfs(rooms, i, j + 1, level + 1);
        dfs(rooms, i + 1, j, level + 1);
    }

    public static void main(String[] args) {
        int[][] rooms = {
            {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
            {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
            {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(rooms);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                System.out.print(rooms[i][j] + ",");
            }
            System.out.println();
        }
    }
}
