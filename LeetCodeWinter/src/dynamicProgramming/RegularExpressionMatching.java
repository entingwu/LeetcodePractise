package dynamicProgramming;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // 1. state
        boolean[][] f = new boolean[sLen + 1][pLen + 1];
        // 2. initialize
        f[0][0] = true;
        // 3. function
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*') { //'a'
                    if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 1)) && f[i - 1][j - 1]) {
                        f[i][j] = true;
                    }
                } else if (p.charAt(j - 1) == '.') { //'.'
                    if (i >= 1 && f[i - 1][j - 1]) {
                        f[i][j] = true;
                    }
                } else if (j >= 1) { //'*' is not 1st char
                    if (f[i][j - 1] || f[i][j - 2]) { // match 0 or 1 preceding element
                        f[i][j] = true;
                    } else { // match multi elements
                        if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && f[i - 1][j]) {
                            f[i][j] = true;
                        }
                    }
                }
            }
        }
        // 4. answer
        return f[sLen][pLen];
    }

    public static void main(String[] args) {
        RegularExpressionMatching rem = new RegularExpressionMatching();
        String s = "aab";
        String p = "c*a*b";
        String s1 = "a";
        String p1 = "aa";
        //System.out.println(rem.isMatch(s, p));
        System.out.println(rem.isMatch(s1, p1));
    }
}