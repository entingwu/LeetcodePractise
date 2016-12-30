package bitManipulation;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        /** 1. Mark down the digit which contains odd numbers of 1 */
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];// If there are odd numbers of 1 in the digit, the digit will be 1, or it will be 0
        }
        /** 2. Find the last digit as 1 */
        int lastDight = xor & (-xor);

        /** 3. Divide as 2 groups according to whether the last digit is 1 or 0.
         *     Extract the odd digits to different group. */
        int[] group = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((lastDight & nums[i]) == 0) {// lastdigit in nums[i] is 0
                group[0] ^= nums[i];
            } else {// lastdigit in nums[i] is 1
                group[1] ^= nums[i];
            }
        }
        return group;
    }

    public static void main(String[] args) {
        SingleNumberIII sn = new SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = sn.singleNumber(nums);
        for (int i : result) {
            System.out.print(i + ",");
        }

    }
}
