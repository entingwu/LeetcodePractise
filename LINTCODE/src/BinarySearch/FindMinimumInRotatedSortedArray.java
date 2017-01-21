package BinarySearch;

public class FindMinimumInRotatedSortedArray {
    /** I */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        // find the first element <= nums[end]
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] <= nums[end]) {// first position
                end = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        return nums[end];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fm = new FindMinimumInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums1 = {4, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(fm.findMin(nums1));
    }
}
