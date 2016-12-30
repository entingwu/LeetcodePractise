package math;

public class ExcelSheetColumnNumber {

	public int titleToNumber(String s) {
		int sum = 0;
		int numA = Integer.valueOf('A');
		for(int i = 0; i < s.length(); i++) {
			int cur = Integer.valueOf(s.charAt(i));
			sum = sum * 26 + (cur - numA + 1);//A从1开始,26进位
		}
		return sum;
	}
	
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			int last = (n-1) % 26;//减1，从A->1转化为A下标为0
			char lastCh = (char)('A' + last);
			sb.append(lastCh);
			n = (n-1) / 26;//n=n/26, '26' => "AZ"
		}
		sb.reverse();
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "AA";
		ExcelSheetColumnNumber es = new ExcelSheetColumnNumber();
		System.out.println(es.titleToNumber(s));
		
		int num = 28;
		System.out.println(es.convertToTitle(num));

	}

}
