package sorting_chapter1;

public class RadixSort {

	/**  
     * Rearranges the array of W-character strings in ascending order.
     *
     * @param a the array to be sorted
     * @param W the number of characters per string
     */
	public static void radixSort(String[] a, int W) {
		int N = a.length;
		int R = 256;   // extend ASCII alphabet size
		String[] aux = new String[N];//aux ~ a
		
		/* sort by key-indexed counting on dth character */
		for(int d = W-1; d >= 0; d--) {
			/* 1. compute frequency counts */
			int[] count = new int[R+1];
			for(int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}
			/* 2. compute char cumulates */
			for(int r = 0; r < R; r++) {
				count[r+1] += count[r];
			}
			/* 3. move data */
			for(int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			/* 4. copy back */
			for(int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"cow", "dog", "sea", "rug", "row", "mob", "box",
				"tab", "bar", "ear", "tar", "dig", "big", "tea", "now", "fox"};
		for(String str : words) {
			System.out.print(str + " ");
		}
		System.out.println();
		
		int W = words[0].length();
		radixSort(words, W);
		for(String str : words) {
			System.out.print(str + " ");
		}
		
		
	}

}
