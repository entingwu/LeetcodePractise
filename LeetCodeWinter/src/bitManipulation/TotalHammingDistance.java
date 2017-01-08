package bitManipulation;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < 32; i++) {//binary digit
            int countOne = 0;
            for (int j = 0; j < n; j++) {
                if (((nums[j] >> i) & 1) == 1) {//取第i位的1
                    countOne++;
                }
            }
            sum += countOne * (n - countOne);
        }
        return sum;
    }

    public static void main(String[] args) {
        TotalHammingDistance thd = new TotalHammingDistance();
        int[] nums = {4, 14, 2};
        System.out.println(thd.totalHammingDistance(nums));
    }
}
