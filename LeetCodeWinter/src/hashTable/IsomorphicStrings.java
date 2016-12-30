package hashTable;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) { // s = "aa", t = "ab"
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        String s = "ab";
        String t = "aa";
        System.out.println(isomorphicStrings.isIsomorphic(s, t));
    }
}
