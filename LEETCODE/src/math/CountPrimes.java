package math;

public class CountPrimes {

	public int countPrimes(int n) {
		if(n < 2) { return 0; }
		boolean[] table = new boolean[n];
		int nonPrime = 0;
		for(int i = 2; i < n; i++) {//2 is smallest prime
			if(table[i] == false) {
				for(int j = 2; i*j < n; j++) {
					if(table[i*j] == false) {
						table[i*j] = true;
						nonPrime++;
					}
				}
			}
		}
		return n - 2 - nonPrime;
	}
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(10));
		

	}

}
