package string;

public class OneEditDistance {

    /**
     *  1. 两个字符串的长度之差大于1，那么直接返回False
     *  2. 两个字符串的长度之差等于1，那么长的那个字符串去掉一个字符，剩下的应该和短的字符串相同
     *  3. 两个字符串的长度之差等于0，那么两个字符串对应位置的字符只能有一处不同。
     * */
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        int diff = Math.abs(sLen - tLen);
        if (diff > 1) {
            return false;
        } else if (diff == 1) {
            String longStr = sLen > tLen? s : t;
            String shortStr = sLen < tLen? s : t;
            for (int i = 0; i < shortStr.length(); i++) {
                if (shortStr.charAt(i) != longStr.charAt(i)) {
                    return shortStr.substring(i).equals(longStr.substring(i + 1));
                }
            }
            return true;// "a" "", shortStr.length() == 0 || 1
        } else if (diff == 0) {
            int count = 0;
            for (int i = 0; i < sLen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
        return false;
    }

    public static void main(String[] args) {
        OneEditDistance oed = new OneEditDistance();
        String s = "a";
        String t = "ac";
        String s1 = "cab";
        String t1 = "ad";
        System.out.println(oed.isOneEditDistance(s, t));
    }
}
