package array;

public class MajorityElement {
    // [2, 2, 3, 5, 2, 2, 6]
    public int majorityElement(int[] nums) {
        int count = 0, majority = -1;
        if (nums == null || nums.length == 0) {
            return majority;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
            } else if (majority == nums[i]) {
                count++;// 2
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {2, 2, 3, 5, 2, 2, 6};
        System.out.println(me.majorityElement(nums));

        int[] nums1 = {1};
        System.out.println(me.majorityElement(nums1));
    }
}
