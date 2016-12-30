package binary_search;

public class SearchForARange {
	public static int[] searchRange(int[] A, int target) {
        int[] result = new int[]{-1, -1};
        if (A == null || A.length == 0) { return result; }
        /*1. First Pos*/
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (A[start] == target) {
            result[0] = start;
        }else if (A[end] == target) {
            result[0] = end;
        }
        /*2. Last Pos*/
        start = 0; end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            result[1] = end;
        }else if (A[start] == target) {
            result[1] = start;
        }
        return result;
    }
	public static void main(String[] args) {
		int[] A = {5, 5, 5, 5, 5, 5, 5, 5};
		int[] result = searchRange(A, 5);
		System.out.println("[" + result[0] + ", " + result[1] + "]");
	}
}
