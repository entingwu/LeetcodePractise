package dynamicProgrammingII;

public class PalindromePartitionII {
    
	public int minCut(String s) {
		if(s == null || s.length() == 0) { return 0; }
		/* 1. state */
		int len = s.length();
		boolean[][] isPalindrome = getPalindrome(s);
		
		/* 2. initialize */
		int[] f = new int[len + 1];
		for(int i = 0; i <= len; i++) {
			f[i] = i - 1;
		}
		
		/* 3. function */
		for(int i = 1; i <= len; i++) {
			for(int j = 0; j < i; j++) {
				if(isPalindrome[j][i - 1]) {
					f[i] = Math.min(f[i], f[j] + 1);
				}
			}
		}
		/* 4. answer */
		return f[len];
	}
	
	private boolean[][] getPalindrome(String s) {
		int len = s.length();
		boolean[][] isPalindrome = new boolean[len][len];
		
		//1. 区间长度为0，单个字符为回文
		for(int i = 0; i < len;i++) {
			isPalindrome[i][i] = true;
		}
		
		//2. 区间长度为1
		for(int i = 0; i < len - 1; i++) {
			isPalindrome[i][i+1] = (s.charAt(i) == s.charAt(i+1));
		}
		
		//3. 区间长度为n-1
		for(int interval = 2; interval < len ; interval++) {
			for(int start = 0; start + interval < len; start++) {
				isPalindrome[start][start+interval] = isPalindrome[start+1][start+interval-1] 
						&& (s.charAt(start)==s.charAt(interval));
			}
		}
		return isPalindrome;
	}
	
	public static void main(String[] args) {
		String s = "abcdeaba";
		String s1 = "leet";
		PalindromePartitionII pp = new PalindromePartitionII();
		System.out.println(pp.minCut(s1));
	}
}
