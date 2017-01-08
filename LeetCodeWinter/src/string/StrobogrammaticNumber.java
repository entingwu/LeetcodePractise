package string;

import java.util.ArrayList;
import java.util.List;

public class StrobogrammaticNumber {
    /* II
    * n = 3:   101, 609, 808, 906, 111, 619, 818, 916, 181, 689, 888, 986 */
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        if (n % 2 == 0) {// even
            helper(result, pairs, "", n / 2);
        } else {
            helper(result, pairs, "0", n / 2);
            helper(result, pairs, "1", n / 2);
            helper(result, pairs, "8", n / 2);
        }
        return result;
    }

    private void helper(List<String> result, char[][] pairs, String temp, int m) {
        if (m == 0) {
            result.add(temp);
            return;
        }
        for (int i = 0; i < pairs.length; i++) {
            if (m == 1 && i == 0) {
                continue;
            }
            temp = pairs[i][0] + temp + pairs[i][1];
            helper(result, pairs, temp, m - 1);
            temp = temp.substring(1, temp.length() - 1);
        }
    }

    /* I */
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        char[] numChar = num.toCharArray();
        int i = 0, j = numChar.length - 1;
        while (i <= j) {
            char start = num.charAt(i);
            char end = num.charAt(j);
            if (start == '6' && end == '9' || start == '9' && end == '6' || start == '8' && end == '8' ||
                start == '1' && end == '1' || start == '0' && end == '0') {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StrobogrammaticNumber sn = new StrobogrammaticNumber();
        //System.out.println(sn.isStrobogrammatic("2"));
        List<String> result = sn.findStrobogrammatic(3);
        System.out.println(result);
    }
}
