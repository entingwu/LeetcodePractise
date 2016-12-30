package sortedArray;

import java.util.ArrayList;

class SortedArray1{

	public double findMedianSortedArrays(int A[],int B[]){
		int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
	}
	
	// find kth number of two sorted array
    public static int findKth(int[] A, int A_start,
                              int[] B, int B_start,
                              int k){		
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}

		if (k == 1) {
			return Math.min(A[A_start], B[B_start]);
		}
		
		int A_key = A_start + k / 2 - 1 < A.length
		            ? A[A_start + k / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = B_start + k / 2 - 1 < B.length
		            ? B[B_start + k / 2 - 1]
		            : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		} else {
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		}
	}
    
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len % 2 == 1) {//odd
            return findKth1(nums1, 0, nums2, 0, len / 2 + 1);//kth,index+1
        }
        //even
        return (findKth1(nums1, 0, nums2, 0, len / 2) + findKth1(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }
   	
   /* find kth number of two sorted array 
   	* n+m => (n+m)/2 => k
   	* findMedian() => findKth()
   	* k => k/2, drop k/2 个数 in O(1) => move nums1,nums2 的首地址
   	*/
    public static int findKth1(int[] nums1, int start1, int[] nums2, int start2, int k) {
        /* base case */
        if(start1 >= nums1.length) {//nums1 has no item in nums1[k/2]
            return nums2[start2 + k - 1];
        }
        if(start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if(k == 1) { 
            return Math.min(nums1[start1], nums2[start2]); 
        }
        
        /* k/2 index */
        int key1 = start1 + k/2 - 1 < nums1.length? 
                   nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;//A less than k/2 items
        int key2 = start2 + k/2 - 1 < nums2.length?
                   nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;//B less than k/2 items
        /* drop smaller */
        if(key1 < key2) {//drop nums1[0-k/2]
            return findKth1(nums1, start1 + k/2, nums2, start2, k - k/2);
        }else {
            return findKth1(nums1, start1, nums2, start2 + k/2, k - k/2);
        }
        
    }
}

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		SortedArray1 array = new SortedArray1();
		int A[] = {1,2,3,4,5,6};
		int B[] = {2,3,4,5};
		//double median = array.findMedianSortedArrays1(A,B);
		//System.out.println(median);
		
		int A1[] = {100000};
		int B1[] = {100001};
		double median1 = array.findMedianSortedArrays1(A1, B1);
		System.out.println(median1);
	}

}
