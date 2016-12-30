package backtracking;

import java.util.ArrayList;
import java.util.List;
/*
 * 	000
	001
	011
	010
	---
	110
	111
	101
	100
	可以看到第n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序的和。
 * */
public class GrayCode {	
	public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        /* 1. n <= 1 */
        if(n <= 1) {
        	for(int i = 0; i <=n; i++) {
            	result.add(i);
            }
        	return result;
        }
        /* 2. n > 1 */
        result = grayCode(n - 1);//000,001,011,010
        int base = 1 << (n-1);//100
        List<Integer> temp = reverse(result);//n-1位格雷码的逆序: 10,11,01,00
		for(int i = 0; i < temp.size(); i++) {
			temp.set(i, base + temp.get(i));//110,111,101,100
		}
		result.addAll(temp);
		return result;
    }
	
	private List<Integer> reverse(List<Integer> org) {//00,01,11,10
		List<Integer> rev = new ArrayList<Integer>();
		for(int i = org.size()-1; i >= 0; i--) {//10,11,01,00
			rev.add(org.get(i));
		}
		return rev;
	}
	
	
	public static void main(String[] args) {
		List<Integer> org = new ArrayList<Integer>();
		org.add(00);
		org.add(01);
		org.add(11);
		org.add(10);
		GrayCode gc = new GrayCode();
		System.out.println(gc.reverse(org));
		
		List<Integer> grayCode = gc.grayCode(3);
		System.out.println(grayCode);
	}

}
