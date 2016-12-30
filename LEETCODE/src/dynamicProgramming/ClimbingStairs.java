package dynamicProgramming;

public class ClimbingStairs {

	public int climbStairs(int n) {
        if(n < 2) { return 1; }
       
        /* 1. state */
        int[] f = new int[n+1];
       
        /* 2. initiate */
        f[0] = 1; f[1] = 1;
       
        /* 3. function */
        for(int i = 2; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
       
        /* 4. answer */
        return f[n];
    }
	
	public int climbStairs2(int n) {
		if(n < 2) { return 1; }
		int[] f = new int[n + 1];
        f[0] = 1; 
        f[1] = 1; 
        f[2] = 2;
        for(int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2] + f[i-3];
        }
        return f[n];
    }
	
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs2(1));

	}

}
