package binary_search;

public class Pow {

	public double myPow(double x, int n) {
		if(n == 0) { return 1.0; }
		double half = myPow(x, n/2);
		if(n % 2 == 0) { 
			return half * half; 
		} else if (n > 0) {// n % 2 == 1
			return half * half * x;
		} else {//n < 0
			return half * half / x;// pow(2,-1) => pow(2,0) * pow(2,0) / 2;
		}
	}
	
	public static void main(String[] args) {
		Pow p = new Pow();
		System.out.println(p.myPow(2,-3));
		

	}

	public double Pow(double x, int n) {
		if(n == 0) { return 1.0; }
		if(n == 1) { return x; }
		double half = myPow(x, n/2);
		if(n % 2 == 1) { 
			return x * half * half; 
		}
		// n % 2 == 0
		return half * half;	
	}
	
}
