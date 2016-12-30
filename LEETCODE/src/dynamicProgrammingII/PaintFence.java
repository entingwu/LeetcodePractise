package dynamicProgrammingII;

public class PaintFence {
	/* no more than two adjacent fence posts have the same color.*/
	public int numWays(int n, int k) {
		if(n==0 || k==0) { return 0; }
		/* 1. initialize */
		int w1 = k;
		int w2 = k*k;
		if(n == 1) { return w1; }
		if(n == 2) { return w2; }
		
		/* 2. function */
		int curr = 0;
		for(int i = 3; i <= n; i++) {
			curr = (k-1)*w2+(k-1)*w1;//不同 + 同
			w1 = w2;
			w2 = curr;
		}
		
		/* 3. answer */
		return curr;
	}
	
	public static void main(String[] args) {
		PaintFence pf = new PaintFence();
		int n = 2, k = 1;
		System.out.println(pf.numWays(n, k));

	}

	public int numWays1(int n, int k) {
		if(n<=0 || k<=0) { return 0; }
		/* 1. state*/
		int[] s = new int[n];//i -1 and i -2 with the same color, s(n) = d(n-1)
		int[] d = new int[n];//i - 1 and i - 2 with diff color
		
		/* 2. initialize */
		s[0] = 0;
		d[0] = k;
		
		/* 3. function */
		for(int i = 1; i < n; i++) {
			s[i] = d[i-1];
			d[i] = (k-1)*(d[i-1] + s[i-1]);
		}
		
		/* 4. answer */
		return s[n-1]+d[n-1];
	}
	
	public int numWays2(int n, int k) {
		if(n<=1 || k<=0) { return n*k; }
		/* 1. state*/
		int[] f = new int[n+1];
		
		/* 2. initialize */
		f[0] = 0;
		f[1] = k;
		f[2] = k+k*(k-1);//两个相同+两个不相同
		
		/* 3. function */
		for(int i = 3; i < n; i++) {
			f[i] = (k-1)*f[i-1]+(k-1)*f[i-2];
		}
		
		/* 4. answer */
		return f[n];
	}
}
