package topologicalSort;

import java.util.*;

/**
 *[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
 **/
public class AlienDictionary {

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Set<Character>> map = new HashMap<>();// t[f], w[e], r[t], e[r]
        Map<Character, Integer> degree = new HashMap<>();
        for (String word : words) {
            for (Character ch : word.toCharArray()) {
                if (!degree.containsKey(ch)) {
                    degree.put(ch, 0);
                }
            }
        }
        boolean isInvalid = buildGraph(map, degree, words);
        // "wrtkj", "wrt"
        return isInvalid ? "" : topologicalSort(map, degree);
    }

    private boolean buildGraph(Map<Character, Set<Character>> map, Map<Character, Integer> degree, String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int minStrLen = Math.min(curr.length(), next.length());
            for (int j = 0; j < minStrLen; j++) {
                char ch1 = curr.charAt(j);
                char ch2 = next.charAt(j);
                if (ch1 != ch2) {
                    Set<Character> set = new HashSet<>();
                    if (map.containsKey(ch1)) {
                        set = map.get(ch1);
                    }
                    if (!set.contains(ch2)) {
                        set.add(ch2);// t[f]
                        map.put(ch1, set);
                        degree.put(ch2, degree.get(ch2) + 1);// w:0, r:1, t:1, e:1, f:1
                    }
                    break;
                } else {
                    // "wrtky", "wrt" 指向k时
                    if (j + 1 <= curr.length() - 1 && j + 1 > next.length() - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private String topologicalSort(Map<Character, Set<Character>> map, Map<Character, Integer> degree) {
        String result = "";
        Queue<Character> queue = new LinkedList<>();
        degree.keySet().forEach(ch -> {
            if (degree.get(ch) == 0) {
                queue.add(ch);//w
            }
        });
        // t[f], w[e], r[t], e[r]
        // w:0, r:1, t:1, e:1, f:1
        while (!queue.isEmpty()) {
            Character ch1 = queue.poll();//w
            result += ch1;
            if (map.containsKey(ch1)) {
                for (Character ch2 : map.get(ch1)) {//ch1==w, ch2==e
                    degree.put(ch2, degree.get(ch2) - 1);//e:0
                    if (degree.get(ch2) == 0) {
                        queue.add(ch2);
                    }
                }
            }
        }
        if (result.length() != degree.size()) {
            return "";
        }
        return result;
    }

    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {
            "wrt",
            "wrf",
            "er",
            "ett",
            "rftt"};
        String[] words1 = {
            "wrtkj", "wrt"
        };
        String[] words2 = {
            "z", "z"
        };
        String[] words3 = {
            "wrt", "wrtkj"
        };
        String[] words4 = {
            "za", "zb", "ca", "cb"
        };
        System.out.println("Des:" + alienDictionary.alienOrder(words1));
        //System.out.println(alienDictionary.alienOrder(words2));
        //System.out.println("Ins:" + alienDictionary.alienOrder(words3));
        //System.out.println(alienDictionary.alienOrder(words4));
    }
}