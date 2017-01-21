package BinarySearch;


public class FindPeakElement {

    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] > A[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return A[end] > A[start] ? end : start;
    }

/*    public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return A[end] > A[start] ? end : start;
    }*/

    public static void main(String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(fpe.findPeak(A));
    }
}
