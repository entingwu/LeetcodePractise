package dynamicProgramming;

public class NumberOfWaysToRepresentNCents {

	public int waysNCents(int n) {
        //1. state
		int[] f = new int[n + 1]; 
		int[] cents = new int[]{1, 5, 10, 25};
		//2. initialize
		f[0] = 1; 
		//3. function
		//每次只增一个数，这个数依次来自1，5，10，25.并不重复出现。
		for(int i = 0; i < cents.length; i++) {//f[5]不能重复出现，所以外圈是cent循环
			for(int j = 1; j <= n; j++) {
				if (j - cents[i] >= 0) {
					f[j] += f[j - cents[i]];
				}
			}
		}
		//4. answer
		return f[n];
    }
	
	public static void main(String[] args) {
		NumberOfWaysToRepresentNCents nwrc = new NumberOfWaysToRepresentNCents();
		System.out.println(nwrc.waysNCents(11));

	}

}
