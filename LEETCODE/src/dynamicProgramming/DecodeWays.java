package dynamicProgramming;

public class DecodeWays {

	public int numDecodings(String s) {
		if(s == null || s.length() == 0) { return 0; }
        /*1. state*/
		int len = s.length();
		int[] f = new int[len+1];
		
		/*2. initialize*/
		f[0] = 1; 
		f[1] = (s.charAt(0) == '0')? 0 : 1;
		
		/*3. function */
		for(int i = 2; i <= len; i++) {//字符串第i位 == 序号i-1
			//f[i-1]
			int digit = s.charAt(i-1)-'0';//个位1~9
			if(digit>=1 && digit <=9) {
				f[i] = f[i-1];
			}
			
			//f[i-2]
			char ch10 = s.charAt(i-2);//10
			char ch1 = s.charAt(i-1);//1
			int twoDigits = (ch10-'0')*10 + (ch1-'0'); 
			if(twoDigits >=10 && twoDigits <= 26) {
				f[i] += f[i-2];
			}
		}
		
		/*4. answer */
		return f[len];
    }
	
	
	
	public static void main(String[] args) {
		String str = "12";
		String str1 = "01";
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings(str1));

	}
	
	public int numDecodingsI(String s) {
        if(s == null || s.length() == 0) { return 0; }
        /*1. state*/
		int len = s.length();
		int[] f = new int[len+1];
		
		/*2. initialize*/
		f[0] = 1; f[1] = 1;
		
		/*3. function */
		for(int i = 2; i <= len; i++) {
			//f[i-2]
			String preStr = s.substring(i-2,i);//String的index比动规f[index]小1
			int preInt = Integer.valueOf(preStr);
			if(preInt>=1 && preInt<=26) {
				f[i] += f[i-2];
			}
			//f[i-1]
			String endStr = s.substring(i-1,i);
			int endInt = Integer.valueOf(endStr);
			if(endInt>=1 && endInt<=9) {
				//f[i-1]
				f[i] += f[i-1];
			}
		}
		
		/*4. answer */
		return f[len];
    }

}
