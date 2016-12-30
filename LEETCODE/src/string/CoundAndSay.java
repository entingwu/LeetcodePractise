package string;

public class CoundAndSay {

	public String countAndSay(int n) {
		String str = "1";
		for (int i = 0 ;i < n-1; ++i) {
		   str = countSay(str);
		}
	    return str;
	}
		
	private String countSay(String str) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
	    char ch = str.charAt(0);
	    for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i-1)) {
				ch = str.charAt(i);
				count++;
			}else {
			    sb.append(count).append(ch);
			    ch = str.charAt(i);
		        count = 1;
	        }
	    } 
	    if(count > 0) {
	    	sb.append(count).append(ch);
		}
		return sb.toString();
	}

	
	public static void main(String[] args) {
		int n = 6;
		CoundAndSay cs = new CoundAndSay();
		System.out.println(cs.countAndSay(n));
		System.out.println(cs.countSay("122211"));
	}

}
