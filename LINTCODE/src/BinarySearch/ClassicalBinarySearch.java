package BinarySearch;

public class ClassicalBinarySearch {
    /** Last Position of Target */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start =  mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        } else if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    /** First Position of Target */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end =  mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        ClassicalBinarySearch cbs = new ClassicalBinarySearch();
        int[] nums = {1, 2, 2, 4, 5, 5};
        int target = 6;
        //System.out.println(cbs.findPosition(nums, target));

        int[] nums1 = {1, 2, 3, 3, 4, 5, 10};
        int target1 = 3;
        //System.out.println(cbs.binarySearch(nums1, target1));

        int[] nums2 = {1, 2, 2, 4, 5, 5};
        int target2 = 2;
        System.out.println(cbs.lastPosition(nums2, target2));
    }

    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
