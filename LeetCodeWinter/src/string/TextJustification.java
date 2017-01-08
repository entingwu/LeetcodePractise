package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    /** "This", "is", "an", "example", "of", "text", "justification." */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0;//行首光标
        while (start < words.length) {// line
            int len = words[start].length();//先加第一个, 后面空格与字符成对添加
            int end = start + 1;// 1
            // offset: start - end, 行首与行尾相隔单词量
            while (end < words.length) {
                if (len + 1 + words[end].length() > maxWidth) {
                    break;
                }
                len += words[end].length() + 1;
                end++;
            }

            StringBuilder line = new StringBuilder();
            int diff = (end - 1) - start;// numbers of space
            // if last line or number of words in the line is 1, left-justified
            if (end == words.length || diff == 0) {// last line
                for (int i = start; i < end; i++) {
                    line.append(words[i] + " ");
                }
                line.deleteCharAt(line.length() - 1);
                for (int j = line.length(); j < maxWidth; j++) {
                    line.append(" ");// extra spaces at the end
                }
            } else {
                // middle justified
                int spaceLen = (maxWidth - len) / diff;
                int mod = (maxWidth - len) % diff;
                for (int i = start; i < end; i++) {
                    line.append(words[i]);
                    if (i < end - 1) {// last digit
                        for (int j = 0; j <= spaceLen + (i - start < mod ? 1 : 0); j++) {// Add mod space in the left
                            line.append(" ");
                        }
                    }
                }
            }
            result.add(line.toString());
            start = end;// 换行
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification."};
        String[] words1 = { "This", "is", "an"};
        String[] words2 = { "a", "b", "c", "d", "e"};
        int maxWidth = 16;
        TextJustification tj = new TextJustification();
        //List<String> result = tj.fullJustify(words1, maxWidth);
        //List<String> result1 = tj.fullJustify(new String[]{""}, 2);
        //List<String> result2 = tj.fullJustify(new String[]{"a"}, 1);
        List<String> result3 = tj.fullJustify(words2, 3);
        for (String str : result3) {
            System.out.print("\'" + str + "\',");
        }

    }
}
