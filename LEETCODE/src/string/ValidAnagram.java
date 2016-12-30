package string;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) { return false; }
		
		int[] count = new int[256];//ASCII
		for(int i = 0; i < s.length(); i++) {
			count[(int)s.charAt(i)]++;
		}
		for(int i = 0; i < t.length(); i++) {
			count[(int)t.charAt(i)]--;
			if(count[(int)t.charAt(i)] < 0) {
				return false;
			}
		}
		/*for(int i = 0; i < 256; i++) {
			if(count[i] != 0) {
				return false;
			}
		}*/
		return true;
	}
	
	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		ValidAnagram va = new ValidAnagram();
		System.out.println(va.isAnagram(s, t));

	}

}
