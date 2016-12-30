package string;

public class AddBinary {
	
	public String addBinary(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1, carry = 0;
		int bitA = 0, bitB = 0, bitR = 0;
		String result = "";
		while(i >= 0 || j >= 0) {
			bitA = i < 0 ? 0 : (a.charAt(i) - '0');//字符串右对齐，指针向左移动，长度短的字符串，index变为负数
			bitB = j < 0 ? 0 : (b.charAt(j) - '0');
			bitR = (bitA + bitB + carry) % 2;
			carry = (bitA + bitB + carry) / 2;
			result = bitR + result;
			i--;
			j--;
		}
		result = (carry == 1? carry + result : result);
		return result;
	}
	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary(a, b));
		

	}

}
