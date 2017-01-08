package dfs;

public class AndroidUnlockPatterns {
    /** 如果两个数字经过了一个数字, 那么这个数字必须之前访问过 */
    public int numberOfPatterns(int m, int n) {
        int[][] jump = new int[10][10];
        jump[1][3] = jump[3][1] = 2;
        jump[4][6] = jump[6][4] = 5;
        jump[7][9] = jump[9][7] = 8;
        jump[1][7] = jump[7][1] = 4;
        jump[2][8] = jump[8][2] = 5;
        jump[3][9] = jump[9][3] = 6;
        jump[1][9] = jump[9][1] = jump[3][7] = jump[7][3] = 5;

        int result = 0;
        boolean[] visited = new boolean[10];
        result += dfs(1, 1, 0, m, n, jump, visited) * 4;
        result += dfs(2, 1, 0, m, n, jump, visited) * 4;
        result += dfs(5, 1, 0, m, n, jump, visited);
        return result;
    }

    private int dfs(int num, int len, int result, int m, int n, int[][] jump, boolean[] visited) {
        if (len >= m) {
            result++;
        }
        len++;
        if (len > n) {// currLength
            return result;
        }
        for (int next = 1; next <= 9; next++) {
            visited[num] = true;
            // If visited[i] is not visited and (two numbers are adjacent or skip number is already visited)
            int jumpNum = jump[num][next];
            if (!visited[next] && (jumpNum == 0 || visited[jumpNum])) {// jump has been selected in prev pattern
                result = dfs(next, len, result, m, n, jump, visited);
            }
            visited[num] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        AndroidUnlockPatterns aup = new AndroidUnlockPatterns();
        System.out.println(aup.numberOfPatterns(1, 1));
    }
}
