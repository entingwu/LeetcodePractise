package binarySearch;

public class SplitArrayLargestSum {
    /** [1, 2, 3, 4, 5], m = 3 */
    public int splitArray(int[] nums, int m) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];// m == 1
            max = Math.max(nums[i], max);
        }
        int start = max, end = sum;// 5 15
        while (start < end) {
            int mid = start + (end - start) / 2;//10 7 6 5
            if (canSplit(nums, m, mid)) {
                end = mid;//10 7 6
            } else {
                start = mid + 1;// mid is too small
            }
        }
        return start;
    }

    private boolean canSplit(int[] nums, int m, int sum) {
        int part = 1, currNum = 0;
        for (int i = 0; i < nums.length; i++) {
            currNum += nums[i];// 1+2+3 3+4 4+5
            if (currNum > sum) {// 大于才能拆两份
                part++;//4
                currNum = nums[i];//5
                if (part > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum sls = new SplitArrayLargestSum();
        int[] nums = {1, 2, 3, 4, 5};
        int m = 3;
        int[] nums1 = {7, 2, 5, 10, 8};
        int m1 = 2;
        System.out.println(sls.splitArray(nums, m));
    }
}
