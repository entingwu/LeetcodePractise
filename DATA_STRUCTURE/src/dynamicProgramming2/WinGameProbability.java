package dynamicProgramming2;

public class WinGameProbability {
	/**Two teams A and B are playing a match to see who is the first to win n games. 
	 * Suppose that A and B are equally competent, so each team has a 50% chance of winning any particular game. 
	 * Let P(i,j) be the probability that if A needs i games to win, and B need j games, that A will eventually win the match.  
	 * when n = 3, i=n-1=2, j=n-3=0; f[i][j]=7/8 
	 * */
	public double winGame(int n, int a, int b) {
		/*1. state*/
		//f[i][j] : the probability that if A needs i games to win ,and B need j games that A will eventually win the match
		double[][] f = new double[n+1][n+1];
		
		/*2. initialize*/
		//f[i][0] = 0 : A must fail
		for(int i = 0; i <= n; i++) {
			f[i][0] = 0;
		}
		//f[0][j] = 1 : A must win
		for(int j = 0; j <= n; j++) {
			f[0][j] = 1;
		}
		
		/*3. function*/
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				//f[i-1][j]: A wins, f[i][j-1]:B wins
				f[i][j] = f[i-1][j]*1/2 + f[i][j-1]*1/2;
			}
		}
		
		/*4. answer*/
		return f[a][b];
	}
	
	public static void main(String[] args) {
		WinGameProbability wgp = new WinGameProbability();
		int n = 3;
		System.out.println(wgp.winGame(n, 1, 3));//0.875
	}

}
