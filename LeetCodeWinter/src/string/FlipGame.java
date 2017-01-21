package string;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    /** II. */
    public boolean canWin(String s) {
        for (int i = 1; i < s.length(); i++) {
            String subStr = s.substring(0, i - 1) + "--" + s.substring(i + 1);
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+' && !canWin(subStr)) {
                return true;
            }
        }
        return false;
    }

    /** I. */
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                String str = s.substring(0, i - 1) + "--" + s.substring(i + 1);
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FlipGame fg = new FlipGame();
        String s = "+++++";
/*        List<String> result = fg.generatePossibleNextMoves(s);
        for (String str : result) {
            System.out.print(str + ",");
        }*/
        System.out.println(fg.canWin(s));
    }
}
