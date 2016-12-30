package math;

public class AddDigits {

	public int addDigits(int num) {
		if(num < 10) { return num; }
		int sum = 0;
		while(num > 0 || sum >= 10) {
			sum += num % 10;
			num = num / 10;
			if(sum >= 10 && num == 0) {
				num = sum;
				sum = 0;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int num = 19;
		AddDigits ad = new AddDigits();
		System.out.println(ad.addDigits(num));

	}

}
