package hashTable;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] AB = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int k = 0; k < B.length; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < B[0].length; j++) {
                        if (B[k][j] != 0) {
                            AB[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return AB;
    }

    public static void main(String[] args) {
        SparseMatrixMultiplication smx = new SparseMatrixMultiplication();
        int[][] A = {
            {1, 0, 0},
            {-1, 0, 3}
        };
        int[][] B = {
            {7, 0, 0},
            {0, 0, 0},
            {0, 0, 1}
        };
        //int[][] result = smx.multiply(A, B);
        int[][] A1 = {
            {1, -5}
        };
        int[][] B1 = {
            {12},
            {-1}
        };
        int[][] result = smx.multiply(A1, B1);
        for(int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }
}
