package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> nums = new ArrayList<>();
        int[] f = new int[n];
        f[0] = 1;
        // f[3] = 6, f[2] = 2, f[1] = 1
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] * i;

        }
        // nums[0] = 1, nums[1] = 2, nums[2] = 3, nums[3] = 4
        for (int i = 0; i < n; i++) {
            nums.add((char)('0' + (i + 1)));
        }
        k--;// 16, begin with 0

        for (int i = n; i >= 1; i--) {
            int j = k / f[i - 1];// 16/6=2
            k = k % f[i - 1];// 16%6=4
            sb.append(nums.get(j));
            nums.remove(j);
        }
        return sb.toString();
    }

    /** Time Limit Exceed */
    private int index = 0;
    public String getPermutationI(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permuteHelper(result, temp, n, k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.get(index).size(); i++) {
            sb.append(result.get(index).get(i));
        }
        return sb.toString();
    }

    private void permuteHelper(List<List<Integer>> result, List<Integer> temp, int n, int k) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            if (result.size() == k) {
                index = k - 1;
                return;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            permuteHelper(result, temp, n, k);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        int n = 4;
        int k = 17;
        System.out.println(ps.getPermutation(n, k));
    }
}
