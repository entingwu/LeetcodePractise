package binarySearch;


public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        long start = 0, end = num;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return false;
    }

    public boolean isPerfectSquareI(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare vps = new ValidPerfectSquare();
        int num = 808201;
        System.out.println(vps.isPerfectSquare(num));
    }
}
