package stack;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int num = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                countStack.push(num);
            } else if (s.charAt(i) == '[') {
                strStack.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(strStack.pop());
                int count = countStack.pop();
                for (int j = 0; j < count; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "3[a2[c]]";
        System.out.println(ds.decodeString(s));
    }
}