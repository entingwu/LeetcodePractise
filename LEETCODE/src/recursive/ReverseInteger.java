package recursive;

import java.io.*;
class Solution {
	
	public boolean isPalindrome(int x) {
		if(x < 0) { return false; }
		return x == reverse(x);
	}
	
    public int reverse(int x) {
    	long renum = 0, lastDigit = 0;
    	int sym = x < 0? -1 : 1;
    	x = Math.abs(x);
    	while(x != 0) {
    		lastDigit = x % 10;// 123 -> 3
    		renum = renum * 10 + lastDigit;
    		if(renum > Integer.MAX_VALUE || renum < Integer.MIN_VALUE) { return 0; }
    		x = x / 10;
    	}
    	renum *= sym;
    	return (int)renum;
    }
}
public class ReverseInteger {
	public static void main(String[] args) throws IOException{
		System.out.print("Enter:");
		int input = getInt();
		Solution s = new Solution();
		System.out.println(s.reverse(input));

	}
	public static int getInt() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		return Integer.parseInt(br.readLine());
	}
}
