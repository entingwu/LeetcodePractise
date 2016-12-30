package math;

public class IntegerToEnglishWords {
	//1,234,567
	//"One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
	public String numberToWords(int num) {
	  String[] bigs = new String[]{" Thousand", " Million", " Billion"};
      StringBuilder result = new StringBuilder();
      result.append(convertToWords(num % 1000));//567
      num = num / 1000;//1234
      int i = 0;// bigs index
      while(num > 0) {
    	  if(num % 1000 != 0) {//1234 % 1000 == 234
    		  String thousand = convertToWords(num % 1000) + bigs[i];//234 thousand //1 million
        	  result.insert(0, thousand);//前插
    	  }
    	  num = num / 1000;//1234 / 1000 == 1
    	  i++;//million
      }
      return result.length() == 0? "Zero" : result.toString().trim();//把第一位空格删掉
    }
	
	private String convertToWords(int num) {
		String[] digit = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"};
		String[] tenDigit = {" Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
		String[] tenMultiDigit = {"", "", " Twenty", " Thirty", " Forty", " Fifty"," Sixty", " Seventy", " Eighty", " Ninety"};
		StringBuilder temp = new StringBuilder();
		
		//567,"Five Hundred Sixty Seven"
		if(num >= 100) {
			temp.append(digit[num / 100]).append(" Hundred");//500
			num = num % 100;//67
		}
		//67,"Sixty Seven"
		if(num >= 20) {//20~100
			temp.append(tenMultiDigit[num / 10]);//60
			num = num % 10;//7
			temp.append(digit[num]);
		}else if(num > 9 && num < 20) {//10~19
			temp.append(tenDigit[num - 10]);
		}else {//0~9
			temp.append(digit[num]);
		}
		return temp.toString();
	}
	
	public static void main(String[] args) {
		IntegerToEnglishWords ew = new IntegerToEnglishWords();
		System.out.println(ew.convertToWords(506));
		System.out.println(ew.numberToWords(1234567));
	}

}
