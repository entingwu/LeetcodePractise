package string;

public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        if (len == 0 || len == 1) {
            return false;
        }
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                String subStr = str.substring(0, i);// Time Limit Exceed
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < len / i; j++) {
                    sb.append(subStr);
                }
                if (sb.toString().equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
        String input = "abcabcabcabc";
        String input1 = "aba";
        System.out.println(rsp.repeatedSubstringPattern(input));
        System.out.println(rsp.repeatedSubstringPattern(input1));
    }
}
