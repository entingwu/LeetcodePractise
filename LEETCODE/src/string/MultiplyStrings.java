package string;

public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) { return sb.toString();}
		/* 1. Reverse string */
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();
		/* 2. Product Array */
		int[] d = new int[num1.length() + num2.length()];//存放digit的乘积，包含进位位
		for(int i = 0; i < n1.length(); i++) {
			for(int j = 0; j < n2.length(); j++) {
				d[i+j] += (n1.charAt(i)-'0')*(n2.charAt(j)-'0');//同一column的数加起来
			}
		}
		/* 3. Add:进位 */
		for(int i = 0; i < d.length; i++) {
			int digit = d[i] % 10;
			int carry = d[i] / 10;
			if(i+1 < d.length) {
				d[i+1] += carry;
			}
			sb.insert(0, digit);//prepend
		}
		/* 4. Remove zeros */
		while(sb.charAt(0) == '0' && sb.length()>1) {//"00"*"00"=="0000"
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		String num1 = "00";
		String num2 = "00";
		String result = ms.multiply(num1, num2);
		System.out.println(result);

	}

}
