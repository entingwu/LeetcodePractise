package string;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		String res = "";
		int start = 0, end = 0;
		for(int i = 0; i < s.length(); i++) {
			start = i; end = i;
			while(start >= 0 && end < s.length()) {
				if(s.charAt(start) == s.charAt(end)) {
					res = s.substring(start, end+1);
					start--;
					end++;
				}else {
					break;
				}
			}
		}
		return res;
	}
	
	public String longestPalindromeI(String s) {
        int start = 0; 
        int end = 0; 
        String res = s.substring(0,1);
        for(int i = 0  ;i  < s.length(); ++i){
            start = i; 
            end = i ;
            while(start >=0 && end< s.length()){
                if(s.charAt(start) == s.charAt(end)){
                    if(res.length() < end - start + 1){
                        res = s.substring(start, end +1 ); 
                    }
                    --start; ++end;
                } else {
                    break;
                }
            }
            start = i - 1; 
            end = i ;
            while(start >= 0 && end < s.length()){
                if(s.charAt(start) == s.charAt(end)){
               if(res.length() < end - start + 1){
                        res = s.substring(start, end +1 ); 
                    }
                    --start; ++end;
                } else {
                    break; 
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String str = "abcdzdcab";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindromeI(str));

	}

}
