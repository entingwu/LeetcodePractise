package dynamicProgramming1;

public class RestaurantProfit {

	public static int maxProfit(int[] m, int[] p, int k) {
		/*1. state*/
		int n = m.length;
		int[] f = new int[n];//f[i] = profit for opening restaurant till i_th index
		int max = 0;
		f[0] = p[0];
		
		/*2. function*/
		for(int i = 1; i < n; i++) {
			f[i] = 0;
			for(int j = 0; j < i; j++) {
				if(m[i] - m[j] >= k) {
					f[i] = Math.max(p[i] + f[j], f[i]);
				}
				max = Math.max(f[i], max);
			}
		}
			
		/*3. answer*/
		return max;
	}
	
	public static void main(String[] args) {
		int[] mile = {0,3,4,5};
		int[] profit = {1,5,30,6};
		int k = 3;
		System.out.println(maxProfit(mile, profit, k));
		

	}
}
