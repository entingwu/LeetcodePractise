package array;

import java.util.ArrayList;

public class MaximumSubarray {

    // [-2,1,-3,4,-1,2,1,-5,4]
    /** I */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prefixSum = 0;
        int minPrefixSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];// 变量 current prefix sum
            max = Math.max(prefixSum - minPrefixSum, max);// 当前MaxSubarraySum与全局比较
            minPrefixSum = Math.min(minPrefixSum, prefixSum);// 定量,最小值 min prefix sum
        }
        return max;
    }

    /** II */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] left = new int[nums.size()];
        int minPrefixSum = 0, prefixSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            prefixSum += nums.get(i);
            max = Math.max(max, prefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            left[i] = max;
        }

        int[] right = new int[nums.size()];
        minPrefixSum = 0; prefixSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--) {
            prefixSum += nums.get(i);
            max = Math.max(max, prefixSum - minPrefixSum);
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            right[i] = max;
        }

        // breakline
        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++) {
            max = Math.max(left[i] + right[i + 1], max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = {-1};
        System.out.println(ms.maxSubArray(nums));

        ArrayList<Integer> nums2 = new ArrayList<>();
        nums2.add(1); nums2.add(3); nums2.add(-1);
        nums2.add(2); nums2.add(-1); nums2.add(2);
        int max = ms.maxTwoSubArrays(nums2);
        System.out.println(max);
    }
}
