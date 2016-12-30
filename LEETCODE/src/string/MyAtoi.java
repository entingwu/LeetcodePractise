package string;

public class MyAtoi {
	/* 1. 首先需要丢弃字符串前面的空格；
	2. 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；
	3. 字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；
	4. 如果超出int的范围，返回边界值（2147483647或-2147483648）。 */
	
	public int myAtoi(String str){
		if(str == null){ return 0; }
		str = str.trim();
		if(str.length() == 0){ return 0; }
		
		int sign = 1;
		int index = 0;
		if(str.charAt(index) == '+'){ index++;}
		else if(str.charAt(index) == '-'){ sign = -1; index++;}
		
		long num = 0;
		for(; index < str.length(); index++){
			if(str.charAt(index) < '0' || str.charAt(index) > '9'){
				break;
			}
			num = num*10 + (str.charAt(index)-'0'); //乘10+x，进位
			if(num > Integer.MAX_VALUE){
				break;
			}
		}
		if(num*sign >= Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		if(num*sign <= Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		return (int)num*sign;
	}
	public static void main(String[] args) {
	}
}
