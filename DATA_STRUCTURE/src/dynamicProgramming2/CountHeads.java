package dynamicProgramming2;

public class CountHeads {

	public double countHeads(double[] p, int K) {
		/*1. state*/
		int N = p.length;//n coins
		double[][] f = new double[N + 1][K + 1];
		//f[n][k] : the probability of n coins tossed with k heads turned up.
		
		/*2. initialize*/
		for(int n = 1; n <= N; n++) {//nth coin 0 head ==> 1-p[n-1]
			f[n][0] = 1 - p[n-1];
		}
		for(int k = 0; k <= K; k++) {//no coin k head
			f[0][k] = 0;
		}
		
		/*3. function*/
		for(int n = 1; n <= N; n++) {//nth coin
			for(int k = 1; k <= K; k++) {//kth head
				//f[n-1][k-1] : nth coin is head ==> p[n-1]
				//f[n-1][k] : nth coin is tail ==> 1-p[n-1]
				f[n][k] = f[n-1][k-1] * p[n-1] + f[n-1][k] * (1-p[n-1]);
			}
		}
		
		/*4. answer*/
		return f[N][K];
		
	}
	
	public static void main(String[] args) {
		double[] p = {0.3, 0.1, 0.7, 0.5};
		int k = 3;
		CountHeads ch = new CountHeads();
		System.out.println(ch.countHeads(p, k));
		
	}

}
