package BinarySearch;


public class WoodCut {

    public int woodCut(int[] L, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < L.length; i++) {
            // max is the longest piece of length.
            max = Math.max(max, L[i]);
        }
        // find the largest length that can cut more than k pieces of wood.
        int start = 1, end = max;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int pieces = countPiece(L, mid);
            if (pieces == k) {// last position
                start = mid;
            } else if (pieces > k) {// piece--, length++.
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countPiece(L, end) >= k) {
            return end;
        }
        if (countPiece(L, start) >= k) {
            return start;
        }
        return 0;
    }

    private int countPiece(int[] L, int length) {
        int count = 0;
        for(int i = 0; i < L.length; i++) {
            count += L[i] / length;
        }
        return count;
    }

    public static void main(String[] args) {
        WoodCut wc = new WoodCut();
        int[] L = {232, 124, 456};
        int k = 7;
        int[] L1 = {2147483644,2147483645,2147483646,2147483647};
        int k1 = 4;
        System.out.println(wc.woodCut(L1, k1));
    }
}
