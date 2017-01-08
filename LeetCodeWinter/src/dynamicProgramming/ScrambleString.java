package dynamicProgramming;

import java.util.Arrays;

public class ScrambleString {
    /** II Iterate
     * i是s1的起始字符，j是s2的起始字符，而k是当前的字符串长度，
     * f[i][j][k]表示的是以i和j分别为s1和s2起点的长度为k的字符串是不是互为scramble
     * */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        int n = s1.length();
        boolean[][][] f = new boolean[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }

        for (int len = 2; len <= n; len++) {// word length递归缩短
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {// cut offset from start
                        if (f[i][j][k] && f[i + k][j + k][len - k] ||
                            f[i][j + len - k][k] && f[i + k][j][len - k]) {
                            f[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return f[0][0][n];// from start
    }

    /** I Searching
     *  s1 = "great" s2 = "rgeat"  */
    public boolean isScrambleI(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (!isValid(s1, s2)) {
            return false;
        }

        for (int i = 1; i < s1.length(); i++) {// i == 0, deadlock
            String s11 = s1.substring(0, i);// g
            String s12 = s1.substring(i);// reat
            String s21 = s2.substring(0, i);// r
            String s22 = s2.substring(i);// geat
            String s23 = s2.substring(s2.length() - i);// t
            String s24 = s2.substring(0, s2.length() - i);// rgea

            if (isScrambleI(s11, s21) && isScrambleI(s12, s22)) {
                return true;
            }
            if (isScrambleI(s11, s23) && isScrambleI(s12, s24)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(String s1, String s2) {
        char[] strChar1 = s1.toCharArray();
        Arrays.sort(strChar1);
        char[] strChar2 = s2.toCharArray();
        Arrays.sort(strChar2);
        return new String(strChar1).equals(new String(strChar2));
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        ScrambleString ss = new ScrambleString();
        //System.out.println(ss.isScramble(s1, s2));
        System.out.println(ss.isScramble("ab", "ba"));
    }
}
