package dynamicProgramming;


public class PaintHouseII {
    /* int[][] f = {
        {3, 5, 8},
        {9, 7, 2},
        {1, 4, 6}
       }; */
    public int minCostII(int[][] costs) {
        int row = costs.length;
        int col = costs[0].length;
        int[][] f = costs;
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int min1 = -1, min2 = -1;
        for (int i = 0; i < row; i++) {// House
            // last line min value j col
            int last1 = min1, last2 = min2;
            // curr line min value j col
            min1 = -1; min2 = -1;

            for (int j = 0; j < col; j++) {// Color
                // Add previous sum to curr line
                if (j != last1) {// last1
                    f[i][j] += (last1 < 0 ? 0 : f[i - 1][last1]);
                } else {// last2
                    f[i][j] += (last2 < 0 ? 0 : f[i - 1][last2]);
                }
                // update min1, min2 of curr line
                if (min1 < 0 || f[i][j] < f[i][min1]) {
                    min2 = min1;// -1
                    min1 = j;// 0
                } else if (min2 < 0 || f[i][j] < f[i][min2]) {
                    min2 = j;// 1
                }
            }
        }
        return f[row - 1][min1];
    }

    public static void main(String[] args) {
        PaintHouseII ph = new PaintHouseII();
        int[][] costs = {
            {3, 5, 8},
            {9, 7, 2},
            {1, 4, 6}
        };
        System.out.println(ph.minCostII(costs));
    }
}
