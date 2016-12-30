package hashTable;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String subStr = s.substring(i, i + p.length());
            if (isAnagram(subStr, p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(String str1, String str2) {
        int[] dict = new int[256];
        for (char c1 : str1.toCharArray()) {
            dict[c1]++;
        }
        for (char c2 : str2.toCharArray()) {
            if (dict[c2] == 0) {
                return false;
            }
            dict[c2]--;
        }
        return true;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString fais = new FindAllAnagramsInAString();
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(fais.findAnagrams(s, p));

        String s1 = "abab";
        String p1 = "ab";
        System.out.println(fais.findAnagrams(s1, p1));
    }
}
