package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

    class Cell {
        int x;
        int y;
        int h;
        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    private Comparator<Cell> comparator = new Comparator<Cell>() {
        @Override
        public int compare(Cell c1, Cell c2) {// c1.h > c2.h return 1;
            return c1.h - c2.h;//minheap
        }
    };
    // Find surroundings. Used minheap to remove round==1, round==2...
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        int row = heightMap.length;
        int col = heightMap[0].length;
        int[][] visited = new int[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<>(comparator);// build wall

        for (int j = 0; j < col; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = 1;
            pq.offer(new Cell(row - 1, j, heightMap[row - 1][j]));
            visited[row - 1][j] = 1;
        }

        for (int i = 1; i < row - 1; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = 1;
            pq.offer(new Cell(i, col - 1, heightMap[i][col - 1]));
            visited[i][col - 1] = 1;
        }

        int result = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        while(!pq.isEmpty()) {
            Cell curr = pq.poll();// minCell
            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];
                if (nextX < 0 || nextX > row - 1 || nextY < 0 || nextY > col - 1 || visited[nextX][nextY] == 1) {
                    continue;
                }
                // If heightMap[nextX][nextY]> curr.h, then heightMap[nextX][nextY] is a new part of wall that should be in minheap.
                int nextH = Math.max(heightMap[nextX][nextY], curr.h);
                pq.offer(new Cell(nextX, nextY, nextH));
                visited[nextX][nextY] = 1;
                result += Math.max(curr.h - heightMap[nextX][nextY], 0);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        int[][] heightMap1 = {
            {12, 13, 0, 13},
            {13, 4, 13, 12},
            {13, 8, 10, 12},
            {12, 13, 12, 12}
        };
        TrappingRainWaterII trw = new TrappingRainWaterII();
        System.out.println(trw.trapRainWater(heightMap1));
    }
}
