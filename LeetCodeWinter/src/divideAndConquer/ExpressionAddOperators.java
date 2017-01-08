package divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, target, 0L, 0L, "", result);
        return result;
    }

    /* "232", 8 -> ["2*3+2", "2+3*2"] */
    private void dfs(String num, int target, Long diff, Long currNum, String temp, List<String> result) {
        if (num.length() == 0 && currNum == target) {
            result.add(temp);
        }
        for (int i = 1; i <= num.length(); i++) {
            String curr = num.substring(0, i);// "2", "3"
            String next = num.substring(i);// "32", "2"
            if (curr.charAt(0) == '0' && curr.length() > 1) {// "105", ["1*0+5","1*05","10-5"]
                return;
            }
            if (temp.length() > 0) {
                // "+"
                // dfs("2", 8, 3, "2 + 3", [])
                dfs(next, target, Long.parseLong(curr), currNum + Long.parseLong(curr), temp + "+" + curr, result);
                // "-"
                dfs(next, target, -Long.parseLong(curr), currNum - Long.parseLong(curr), temp + "-" + curr, result);
                // "*"
                // dfs("", 8, 2, "2 + 3 * 2", [])
                dfs(next, target, diff * Long.parseLong(curr), (currNum - diff) + diff * Long.parseLong(curr), temp + "*" + curr, result);
            } else {// initialize
                // dfs("32", 8, 2, 2, "2", []);
                dfs(next, target, Long.parseLong(curr), Long.parseLong(curr), curr, result);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators edo = new ExpressionAddOperators();
        String num = "232";
        int target = 8;
        String num1 = "105";
        int target1 = 5;
        List<String> result = edo.addOperators(num1, target1);
        result.forEach(str -> System.out.print(str + ","));
    }
}