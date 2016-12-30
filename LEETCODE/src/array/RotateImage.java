package array;

public class RotateImage {
	/* 1.diagonal+mirror 
	 * 1,2  - 4,2 - 3,1
	 * 3,4	- 3,1 - 4,2
	 * */
	public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
        int n = matrix.length;
        /*1. Diagonal - right top */
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i; j++) {//i+j<n -> j<n-i
            	int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];//i+j=n-1
                matrix[n-1-j][n-1-i] = temp;
            }
        }
        /*2. mirror - horizon */
        for(int i = 0; i < n / 2; i++) {//只走一半，不然又反过来了
        	for(int j = 0; j < n; j++) {
        		int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
        	}
        }
    }
	
    /*2. onepass
     * 1 2 3	7 4 1    i,j 	  X	     j,n-1-i
     * 4 5 6    8 5 2    X		  X			X
     * 7 8 9    9 6 3    n-1-j,i  X	 n-1-i,n-1-j
     * */
	public void rotate1(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
		int len = matrix.length;
		for(int i = 0; i < len/2; i++) {
			for(int j = 0; j < (len+1)/2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[len-1-j][i];
				matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
				matrix[len-1-i][len-1-j] = matrix[j][len-1-i];
				matrix[j][len-1-i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		

	}

}
