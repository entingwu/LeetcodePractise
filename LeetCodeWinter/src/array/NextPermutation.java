package array;

public class NextPermutation {
    /**
     * 1 2 7 4 3 1
     * 1 3 7 4 2 1
     * 1 3 1 2 4 7
     * */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        for (; i >= 0; i--) {//i == 0
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,7,4,3,1};
        int[] nums1 = {1, 3, 2};
        NextPermutation np = new NextPermutation();
        np.nextPermutation(nums1);
        for (int i : nums1) {
            System.out.print(i + ",");
        }
    }
}