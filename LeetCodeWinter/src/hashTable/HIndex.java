package hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HIndex {
    /* I */
    public int hIndexI(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        // How many paper citations >= n? 囤积在最后一位
        for (int i = 0; i < n; i++) {
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

    /* II */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length;
        int start = 0, end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (len - mid == citations[mid]) {
                return len - mid;
            } else if (len - mid < citations[mid]) {// ranking++ < citi--, left
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return len - start;
    }

    public static void main(String[] args) {
        HIndex hd = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations1 = {0, 0};
        int[] citations2 = {0, 1, 3, 5, 6};
        int[] citations3 = {0, 0};
        //System.out.println(hd.hIndex(citations2));
        System.out.println(hd.hIndex(citations3));
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