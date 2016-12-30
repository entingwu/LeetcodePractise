package unionFind;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {

    class UnionFind {
        int[] father;
        UnionFind(int num) {
            father = new int[num];
            for (int i = 0; i < num; i++) {
                father[i] = i;
            }
        }

        public int compressedFind(int x) {
            int parent = father[x];//top
            while (parent != father[parent]) {
                parent = father[parent];
            }
            while (x != father[x]) {
                x = father[x];
                father[x] = parent;
            }
            return parent;
        }

        public void union(int x, int y) {
            int parentX = compressedFind(x);
            int parentY = compressedFind(y);
            if (parentX != parentY) {
                father[parentX] = parentY;
            }
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || m == 0 || n == 0) {
            return result;
        }
        UnionFind unionFind = new UnionFind(m * n);
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int count = 0;
        int[][] island = new int[m][n];

        for (int k = 0; k < positions.length; k++) {
            count ++;// 1
            int x = positions[k][0];
            int y = positions[k][1];
            island[x][y] = 1;
            int currId = n * x + y;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextId = n * nextX + nextY;
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || island[nextX][nextY] == 0) {
                    continue;
                }
                // neighbor is an island. Check if already union
                int parentCurr = unionFind.compressedFind(currId);
                int parentNext = unionFind.compressedFind(nextId);
                if (parentCurr != parentNext) {
                    count--;
                    unionFind.union(currId, nextId);
                }
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfIslandsII nid = new NumberOfIslandsII();
        int m = 3, n = 3;
        int[][] positions = {
            {0, 0}, {0, 1}, {1, 2}, {2, 1}
        };
        System.out.println(nid.numIslands2(m, n, positions));

        int m1 = 8, n1 = 4;
        int[][] positions1 = {
            {0, 0}, {7, 1}, {6, 1}, {3, 3}, {4, 1}
        };
        System.out.println(nid.numIslands2(m1, n1, positions1));
    }
}
