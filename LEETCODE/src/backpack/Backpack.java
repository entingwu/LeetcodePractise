package backpack;

public class Backpack {
	/* I. Backpack
	 * Given n items with size Ai, an integer m denotes the size of a backpack. 
	 * How full you can fill this backpack?
	 * weight: A = [2, 3, 5, 7]; 
	 * capacity W: m = 10; return 10;[2, 3, 5] */
	public int backPack(int m, int[] A) {
		//1. state
		int n = A.length;
        int[][] f = new int[n + 1][m + 1];//f[i][j] represents i items, j capacity, how much does it fill?
        //2. initialize
        for(int i = 0; i <= n; i++) {
        	f[i][0] = 0;
        }
        for(int w = 0; w <= m; w++) {
        	f[0][w] = 0;
        }
        //3. function
        for(int i = 1; i <= n; i++) {
        	for(int w = 1; w <= m; w++) {
        		f[i][w] = f[i - 1][w];//do not put
        		if (w - A[i - 1] >= 0) {
        			f[i][w] = Math.max(f[i - 1][w - A[i - 1]] + A[i - 1], f[i][w]);
        		}
        	}
        }
        //4. answer
        return f[n][m];
    }
	/* II. BackPack
	 * Each item only uses once */
	public int backPackII(int m, int[] A, int V[]) {
        //1. state
        int n = A.length;
        int[][] f = new int[n + 1][m + 1];
        //2. initialize
		for(int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}
		for(int w = 0; w <= n; w++) {
			f[0][w] = 0;
		}
		//3. function
		for(int i = 1; i <= n; i++ ) {
			for(int w = 1; w <= m; w++) {
				f[i][w] = f[i - 1][w];
				if (w - A[i - 1] >= 0) {
					f[i][w] = Math.max(f[i - 1][w - A[i - 1]] + V[i - 1], f[i][w]);
				}
			}
		}
		//4. answer
		return f[n][m];
    }
	
	/* III. Backpack
	 * Each item has an infinite number available
	 * weight: A = [2, 3, 5, 7]; 
	 * value:  V = [1, 5, 2, 4];
	 * capacity W: m = 10; return 15; */
	public int backPackIII(int[] A, int[] V, int m) {
		//1. state
		int n = A.length;//n items
		int[][] f = new int[n + 1][m + 1];// n items, m capacity cost f[n][m] values.
		//2. initialize
		for(int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}
		for(int w = 0; w <= n; w++) {
			f[0][w] = 0;
		}
		//3. function
		for(int i = 1; i <= n; i++ ) {
			for(int w = 1; w <= m; w++) {
				f[i][w] = f[i - 1][w];
				if (w - A[i - 1] >= 0) {
					f[i][w] = Math.max(f[i][w - A[i - 1]] + V[i - 1], f[i][w]);
				}
			}
		}
		//4. answer
		return f[n][m];
	}
	
	public static void main(String[] args) {
		Backpack bp = new Backpack();
		int[] A = {2, 3, 5, 7};
		int m = 10;
		/* I. Backpack
		 * weight: A = [2, 3, 5, 7]; 
		 * capacity W: m = 10; return 10;[2, 3, 5] */
		System.out.println(bp.backPack(10, A));
		
		/* III. Backpack
		 * weight: A = [2, 3, 5, 7]; 
		 * value:  V = [1, 5, 2, 4];
		 * capacity W: m = 10; return 15; */
		int[] V = {1, 5, 2, 4};
		System.out.println(bp.backPackIII(A, V, m));
		
	}
}


