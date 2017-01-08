package rotate;

public class RotateFunction {
    /**
     * F(0) = 0A + 1B + 2C +3D
       F(1) = 0D + 1A + 2B +3C
       F(2) = 0C + 1D + 2A +3B
       F(3) = 0B + 1C + 2D +3A
       那么，我们可以得出下面的规律：
       F(1) = F(0) + sum - 4D
       F(2) = F(1) + sum - 4C
       F(3) = F(2) + sum - 4B
       那么我们就找到规律了, F(i) = F(i-1) + sum - n*A[n-i]
     **/
    public int maxRotateFunction(int[] A) {
        int init = 0, sum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            init += A[i] * i;
            sum += A[i];
        }

        int curr = init, max = init;
        for (int i = 1; i < n; i++) {
            curr = init + sum - n * A[n - i];
            max = Math.max(curr, max);
            init = curr;
        }
        return max;
    }

    public static void main(String[] args) {
        RotateFunction rf = new RotateFunction();
        int[] A = {4, 3, 2, 6};
        int[] A1 = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(rf.maxRotateFunction(A1));
    }
}
