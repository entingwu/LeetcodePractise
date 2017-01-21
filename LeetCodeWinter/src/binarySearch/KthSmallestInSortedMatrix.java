package binarySearch;


import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    /**
     * matrix =
     * [[ 1,  5,  9],
        [10, 11, 13],
        [12, 13, 15]],     k = 8 */
    /** O(nlg(max-min))
       每列也是有序的，我们可以利用这个性质，从数组的左下角开始查找，如果比目标值小，我们就向右移一位，
       而且我们知道当前列的当前位置的上面所有的数字都小于目标值，那么cnt += i+1，反之则向上移一位，这样我们也能算出cnt的值。
    */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = searchLessEqual(matrix, mid);
            if (count == k) {
                end = mid;
            } else if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int searchLessEqual(int[][] matrix, int value) {
        int n = matrix.length;
        int i = n - 1;// left bottom corner
        int j = 0;
        int sum = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= value) {
                sum += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return sum;
    }

    // O(n^2lgk)
    public int kthSmallestI(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix ksm = new KthSmallestInSortedMatrix();
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        int[][] matrix1 = {
            {1, 2},
            {1, 3}
        };
        int k1 = 1;
        System.out.println(ksm.kthSmallest(matrix, k));
    }
}
