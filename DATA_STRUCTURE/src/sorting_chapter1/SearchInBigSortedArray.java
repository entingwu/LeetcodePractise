package sorting_chapter1;

public class SearchInBigSortedArray {

	public static int searchBigSortedArray(int[] a, int x) {
		int k = 2;
		if(a[0] == x) { return 0; }
		/* 1. Narrow the search range to a[start] ~ a[end]*/
		int start = 1, end = 1; 
		while(a[end] < x) {
			start = end;
			end = k * start;
		}
		System.out.println(start);
		System.out.println(end);
		
		/* 2. Do binary search in the narrowed range */
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(a[mid] == x ) {
				return mid;
			}else if(a[mid] < x) {
				start = mid;
			}else {
				end = mid;
			}
		}
		if(a[start] == x) {
			return start;
		}
		if(a[end] == x) {
			return end;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,999,999,999,999,999,999};
		int x = 6;
		int index = searchBigSortedArray(array, x);
		System.out.println(index);
	
	}

}
