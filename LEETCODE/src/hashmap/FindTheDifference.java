package hashmap;

import java.util.HashSet;
import java.util.Set;

public class FindTheDifference {
	
	public char findTheDifference(String s, String t) {
        char ch = 0;
        for(int i = 0; i < s.length(); i++) {
        	ch ^= s.charAt(i);
        }
        System.out.println();
        for(int i = 0; i < t.length(); i++) {
        	ch ^= t.charAt(i);
        }
        return ch;
    }
	
	public static void main(String[] args) {
		FindTheDifference fd = new FindTheDifference();
		System.out.println(fd.findTheDifference1("abcd", "abcde"));
	}
	
	public char findTheDifference1(String s, String t) {
        Set<Character> set = new HashSet<Character>();
        char ch = '0';
        for(int i = 0; i < s.length(); i++) {
        	set.add(s.charAt(i));
        }
        for(int i = 0; i < t.length(); i++) {
        	ch = t.charAt(i);
        	if(!set.contains(ch)) {
        		return ch;
        	}
        	set.remove(s.charAt(i));
        }
        return ch;
    }

}
