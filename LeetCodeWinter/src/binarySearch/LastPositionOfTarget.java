package binarySearch;

public class LastPositionOfTarget {

    public int lastPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        LastPositionOfTarget lpt = new LastPositionOfTarget();
        int[] nums = {1, 2, 2, 4, 5, 5};
        int target = 5;
        System.out.println(lpt.lastPosition(nums, target));
    }
}
