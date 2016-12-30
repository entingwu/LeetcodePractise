package heap;

import java.util.*;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        // (t, 1), (r, 1), (e, 2)
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int frequency = entry.getValue();
            while(frequency > 0) {
                sb.append(ch);
                frequency--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency scf = new SortCharactersByFrequency();
        String s = "tree";
        System.out.println(scf.frequencySort(s));
    }

    private Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
        @Override
        public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
            return entry2.getValue() - entry1.getValue();// >
        }
    };

    public String frequencySortI(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        // (t, 1), (r, 1), (e, 2)
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>();
        list.addAll(map.entrySet());
        Collections.sort(list, comparator);

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            char ch = entry.getKey();
            int frequency = entry.getValue();
            while(frequency > 0) {
                sb.append(ch);
                frequency--;
            }
        }
        return sb.toString();
    }

}