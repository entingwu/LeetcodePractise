package bitmanipulation;

public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		if(b == 0) { 
			return a; 
		}
		int sum = a ^ b;
		int carry = (a & b) << 1;//进位
		return getSum(sum, carry);
	}
	
	public static void main(String[] args) {
		int a = 3, b = 6;
		SumOfTwoIntegers st = new SumOfTwoIntegers();
		int result = st.getSum(a, b);
		System.out.println(result);
	}
}
