package dynamicProgramming;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        // 1. function
        boolean[][] f = new boolean[sLen + 1][pLen + 1];
        // 2. initialize
        f[0][0] = true;
        // 3. function
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char ch = p.charAt(j - 1);
                if (ch != '?' && ch != '*') {
                    if (i >= 1 && ch == s.charAt(i - 1) && f[i - 1][j - 1]) {
                        f[i][j] = true;
                    }
                } else if (ch == '?') {
                    f[i][j] = (i >= 1 && f[i - 1][j - 1]);
                } else {// ch == '*'
                    f[i][j] = f[i][j - 1] || (i >= 1 && (f[i - 1][j - 1] || f[i - 1][j]));
                }
            }
        }
        // 4. answer
        return f[sLen][pLen];
    }

    public static void main(String[] args) {
        WildcardMatching wm = new WildcardMatching();
        String s = "aab";
        String p = "c*a*b";
        String s1 = "ab";
        String p1 = "?*";
        System.out.println(wm.isMatch(s, p));
        System.out.println(wm.isMatch(s1, p1));
    }

    boolean comparison(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }
}
