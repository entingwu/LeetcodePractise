package math;

import java.util.ArrayList;

public class PlusOne {
	/** The complexity is O(1)
	 *  f(n) = 9/10 + 1/10 * O(n-1)
	 *  ==> O(n) = 10/9 = O(1) */
	public int[] plusOne(int[] digits) {
		int sum = 0, carry = 1;//+1
		for(int i = digits.length-1; i>=0; i--) {
			sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}
		if(carry == 0) {
			return digits;
		}
		//carry > 0
		int[] result = new int[digits.length + 1];
		result[0] = carry;
		for(int i = 1; i < result.length; i++) {
			result[i] = digits[i-1];
		}
		return result;
	}
	
	public static void main(String[] args) {
		PlusOne po = new PlusOne();
		int[] array = {9,9,9};
		int[] result = po.plusOne(array);
		for(int i : result) {
			System.out.print(i + " ");
		}
	}

}
