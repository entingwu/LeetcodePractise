package array;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char start, end;
        while(i < j) {
        	start = s.charAt(i);
        	end = s.charAt(j);
            if(!validChar(start)) {
            	i++;
            	continue;
            }
            if(!validChar(end)) {
            	j--;
            	continue;
            }
            if(Character.toLowerCase(start) != Character.toLowerCase(end)) {
            	return false;
            }else {
            	i++;
            	j--;
            }
        }
        return true;
    }
	
	private boolean validChar(char c) {
		return Character.isLetter(c) || Character.isDigit(c);
	}
	
	public static void main(String[] args) {
		String test = "a.";
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome(test));
	}

}
