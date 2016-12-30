package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HIndex {

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        // How many paper citations >= n? 囤积在最后一位
        for (int i = 0; i < citations.length; i++) {
            int curr = citations[i];
            if (curr >= n) {
                count[n]++;
            } else {
                count[curr]++;
            }
        }
        // Back to front. 把囤积的加到每一位上
        for (int i = n; i > 0; i--) {
            if (count[i] >= i) {
                return i;
            } else {
                count[i - 1] += count[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex hd = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations1 = {0, 0};
        System.out.println(hd.hIndex(citations));
    }

    public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(citations);
        for (int i : citations) {
            if(!map.containsKey(i)) {
                map.put(i, 0);
            }
        }
        for (int i = 0; i < citations.length; i++) {
            for (int j = i; j < citations.length; j++) {
                if (citations[j] >= citations[i]) {
                    map.put(citations[i], map.get(citations[i]) + 1);
                }
            }
        }
        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                return key;
            }
        }
        return 0;
    }
}