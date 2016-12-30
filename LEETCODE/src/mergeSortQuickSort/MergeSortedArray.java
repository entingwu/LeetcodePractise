package mergeSortQuickSort;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n){
		int i = m - 1, j = n - 1;
		int index = m + n -1;
		while(i >= 0 && j >= 0){
			if(nums1[i] > nums2[j]){
				nums1[index--] = nums1[i--];
			}else {
				nums1[index--] = nums2[j--];
			}
		}
		while(i >= 0){//nums1剩
			nums1[index--] = nums1[i--];
		}
		while(j >= 0){//nums2剩
			nums1[index--] = nums2[j--];
		}
	}
	
	public int[] mergeSortedArray(int[] A, int[] B) {
        int[] result = new int[A.length+B.length];
		int i = 0, j = 0, k = 0;
		while(i < A.length && j < B.length){
			if(A[i] < B[j]){
				result[k++] = A[i++]; 
			} else {
				result[k++] = B[j++];
			}
		}
		while(i < A.length){
			result[k++] = A[i++];
		}
		while(j < B.length){
			result[k++] = B[j++];
		}
		return result;
    }
	
	public static void main(String[] args) {
		

	}

}
