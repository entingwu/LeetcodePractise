package math;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

	public int romanToInt(String s) {
		if(s == null || s.length() == 0) { return 0; }
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int len = s.length();
		int result = map.get(s.charAt(len - 1));//最后一位
		for(int i = len - 2; i >= 0; i--) {//i+1 ==> len-2, i ==> len-1
			if(map.get(s.charAt(i+1)) <= map.get(s.charAt(i))) {
				result += map.get(s.charAt(i));//VI 1+5
			}else {
				result -= map.get(s.charAt(i));//IV 5-1
			}
		}
		
		return result;
	}
	
	public String intToRoman(int num) {
		if(num <= 0) { return ""; }
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder res = new StringBuilder();
		int i = 0;//ith symbol
		while(num > 0) {
			int times = num / nums[i];//the times of symbols[i] need to print in the output
			num -= nums[i] * times;//remaining
			for(; times>0; times--) {//print
				res.append(symbols[i]);
			}
			i++;//next symbol
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		String str = "VI";
		RomantoInteger ri = new RomantoInteger();
		System.out.println(ri.romanToInt(str));
		
		int num = 1;
		String result = ri.intToRoman(num);
		System.out.println(result);
	}

}
