package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public String getPermutation(int n, int k) {
        if(n == 1) { return "1"; }
        if(k <= 0) { return ""; }
        List<String> list = new ArrayList<String>();
        String str = new String();
        permutationHelper(list, str, n);
        return list.get(k-1);
    }
	
	private void permutationHelper(List<String> list, String str, int n) {
		if(str.length() == n) {
			list.add(str);
			return;
		}
		for(int i = 1; i <= n; i++) {
			if(isContained(str,i)) { continue; }
			str = str + Integer.toString(i);
			permutationHelper(list, str, n);
			str = str.substring(0, str.length()-1);
		}
	}
	
	private boolean isContained(String str, int num) {
		for(int i = 0; i<str.length(); i++) {
			if(Integer.valueOf(str.charAt(i)) == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int n = 3, k = 1;
		PermutationSequence ps = new PermutationSequence();
		String str = ps.getPermutation(n, k);
		System.out.println(str);
	}

}
