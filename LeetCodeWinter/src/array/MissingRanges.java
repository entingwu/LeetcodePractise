package array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    /** [0, 1, 3, 50, 75], lower = 0 and upper = 99 */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int left = lower - 1;// -1
        int i = 0;
        for (; i < nums.length; i++) {
            int right = nums[i];//0 1 3 50 75
            if ((i == 0 || left <= Integer.MAX_VALUE - 1) && left + 2 == right) {//1+2==3
                result.add(String.valueOf(left + 1));//"2"
            } else if ((i == 0 || left <= Integer.MAX_VALUE - 1) && left + 2 < right) {// missing range, 3+2<50, 50+2<75
                String str = String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
                result.add(str);
            }
            left = right;//0 1 3 50 75
            if (left >= upper) {
                break;
            }
        }
        if (i == nums.length) {
            if (left + 1 == upper) {
                result.add(String.valueOf(left + 1));
            } else if (left + 1 < upper) {//75+1<99
                result.add(String.valueOf(left + 1) + "->" + String.valueOf(upper));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MissingRanges mr = new MissingRanges();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
        //List<String> result = mr.findMissingRanges(nums, lower, upper);
        //List<String> result1 = mr.findMissingRanges(new int[]{-1}, -1, -1);

        int[] nums1 = {-2147483648, -2147483648, 0, 2147483647, 2147483647};
        int lower1 = -2147483648, upper1 = 2147483647;
        //List<String> result1 = mr.findMissingRanges(nums1, lower1, upper1);

        int[] nums2 = {};
        int lower2 = -2147483648, upper2 = 2147483647;
        //List<String> result2 = mr.findMissingRanges(nums2, lower2, upper2);
        //List<String> result3 = mr.findMissingRanges(new int[]{}, 1, 1);

        int[] nums4 = {-2147483648};
        int lower4 = -2147483648, upper4 = 2147483647;
        //List<String> result4 = mr.findMissingRanges(nums4, lower4, upper4);

        int[] nums5 = {0, 2147483646, 2147483647};
        int lower5 = 0, upper5 = 2147483647;
        List<String> result5 = mr.findMissingRanges(nums5, lower5, upper5);
        for (String str : result5) {
            System.out.println(str + ",");
        }
    }

    /** [0, 1, 3, 50, 75], lower = 0 and upper = 99 */
    public List<String> findMissingRangesI(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            if (lower == upper) {
                result.add(String.valueOf(lower));
            } else {
                result.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            }
            return result;
        }
        long left = lower;// 0
        for (int i = 0; i <= nums.length; i++) {
            // 1. within range: right = current nums[i]
            // 2. i == nums.length last element. right = upper + 1
            long right = (i < nums.length && nums[i] <= upper ? nums[i] : upper + 1);//0 1 3 50
            if (left == right) {
                left++;//1 2
            } else if (right > left) {// missing range
                if (right - left == 1) {// 3-2
                    result.add(String.valueOf(left));
                } else {// 50-4
                    String str = String.valueOf(left) + "->" + String.valueOf(right - 1);
                    result.add(str);
                }
                left = (right != Integer.MAX_VALUE ? right + 1 : right);//next range 4
            }
        }
        return result;
    }
}
