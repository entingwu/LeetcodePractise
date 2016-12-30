package string;

public class ReverseWordsInString {
	/* II */
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length-1);
		int start = 0, end = 0;
		for(int i = 0; i < s.length; i++) {
			if(s[i] == ' ') { 
				end = i - 1;
				reverse(s, start, end);
				start = i+1;
			}
		}
		end = s.length-1;
		reverse(s, start, end);
	}
	
	private void reverse(char[] s, int start, int end) {
		int i = start, j = end;
		while(i < j) {
			swap(s, i, j);
			i++;
			j--;
		}
	}
	
	private void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
	
	/* I */
	public String reverseWordsI(String s) {
		if(s == null || s.length() == 0) { return ""; }
		String[] array = s.split(" ");
		for(String str : array) {
			System.out.println(str);
		}

		
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i >= 0; i--) {
        	if(!array[i].equals("")) {
        		sb.append(array[i]).append(" ");
        	}
        }
        String result = sb.toString();
        result = result.length() == 0 ? "" : result.substring(0, result.length()-1);
        return result;
    }
	
	public String reverseString(String s) {
        char[] strs = s.toCharArray();
        int i = 0, j = strs.length-1;
        while(i < j) {
            char tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
            i++;
            j--;
        }
        return new String(strs);
    }
	
	public static void main(String[] args) {
		ReverseWordsInString rs = new ReverseWordsInString();
		String str = "the sky is blue";
		char[] s = str.toCharArray();
		rs.reverseWords(s);
		for(char i : s) {
			System.out.print(i);
		}
		
		/*System.out.println();
		str = " 1";
		string res = rs.reverseWordsI(str);
		System.out.println(res);*/
		
		String str1 = "hello";
		String reStr1 = rs.reverseString(str1);
		System.out.println(reStr1);
		
		
	}

}
