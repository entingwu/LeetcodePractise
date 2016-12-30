package array;

import java.util.Arrays;

public class FindTheCelebrity {
    public int findCelebrityI(int n) {
        for (int i = 0; i < n; i++) {// celebrity
            int j = 0;
            for (; j < n; j++) {
                if (i != j && (knows(i, j) || !knows(j, i))) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }

    public int findCelebrity(int n) {
        boolean[] candidate = new boolean[n];
        Arrays.fill(candidate, true);
        for (int i = 0; i < n; i++) {// celebrity
            for (int j = 0; j < n; j++) {
                if (candidate[i] && i != j) {
                    if (knows(i, j) || !knows(j, i)) {
                        candidate[i] = false;
                        break;
                    }
                    if (!knows(i, j) || knows(j, i)) {
                        candidate[j] = false;
                    }
                }
            }
            if (candidate[i]) {
                return i;
            }
        }
        return -1;
    }

    private boolean knows(int i, int j) {
        return true;
    }
}
