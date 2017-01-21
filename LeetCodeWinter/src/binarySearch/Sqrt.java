package binarySearch;

public class Sqrt {

    public int sqrt(int x) {
        // find the last number which square of it <= x
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end * end == x) {
            return (int)end;
        } else {
            return (int)start;
        }
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(2147395599));
    }
}
