package joshua.leetcode.array;

public abstract class MergeSortedArray {

	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array.
	 * 
	 * Note: You may assume that A has enough space (size that is greater or
	 * equal to m + n) to hold additional elements from B. The number of
	 * elements initialized in A and B are m and n respectively.
	 * 
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public abstract void merge(int A[], int m, int B[], int n);

	static class Solution1 extends MergeSortedArray {

		@Override
		public void merge(int[] A, int m, int[] B, int n) {
			int len1 = m - 1, len2 = n - 1;
			int last = m + n - 1;
			while (len1 > -1 && len2 > -1) {
				if (A[len1] > B[len2]) {
					A[last--] = A[len1--];
				} else if (A[len1] < B[len2]) {
					A[last--] = B[len2--];
				} else {
					A[last--] = A[len1--];
					A[last--] = B[len2--];
				}
			}
			while (len2 > -1) {
				A[last--] = B[len2--];
			}
		}
	}

}
