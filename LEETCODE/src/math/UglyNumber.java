package math;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
	/* Ugly Number I */
	public boolean isUgly(int num) {
		while(num >= 2) {
			if(num % 2 == 0) { num = num/2; }
			else if(num % 3 == 0) { num = num/3; }
			else if(num % 5 == 0) { num = num/5; }
			else { return false; }//14
		}
		return num == 1;
	}
	
	/* Ugly Number II */
	public int nthUglyNumber(int n) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int p2 = 0, p3 = 0, p5 = 0;
        while (result.size() < n) {
        	int ugly2 = result.get(p2) * 2; 
        	int ugly3 = result.get(p3) * 3;
        	int ugly5 = result.get(p5) * 5;
        	int min = Math.min(Math.min(ugly2, ugly3), ugly5);
        	if (min == ugly2) {
        		p2++;
        	} else if (min == ugly3) {
        		p3++;
        	} else if (min == ugly5) {
        		p5++;
        	}
        	if (min != result.get(result.size() - 1)) {
        		result.add(min);
        	}
        }
        return result.get(result.size() - 1);
    }
	
	public static void main(String[] args) {
		int num = 14;
		UglyNumber un = new UglyNumber();
		System.out.println(un.isUgly(num));
		
		System.out.println(un.nthUglyNumber(9));
	}

}
