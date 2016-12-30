package math;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		if(n == 0) { return false; }
		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		while(n != 1) {
			if(set.contains(n)) { return false; }
			set.add(n);
			sum = 0;
			while(n!=0) {
				sum += (n%10) * (n%10);
				n /= 10;
			}
			n = sum;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int test = 7;
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(test));

	}

}
