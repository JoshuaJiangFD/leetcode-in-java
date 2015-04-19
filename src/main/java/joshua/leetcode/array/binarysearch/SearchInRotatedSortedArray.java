package joshua.leetcode.array.binarysearch;

public abstract class SearchInRotatedSortedArray {

	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
		
		You are given a target value to search. If found in the array return its index, otherwise return -1.
		
		You may assume no duplicate exists in the array.
	 * @param A
	 * @param target
	 * @return the index found, or -1 if not found.
	 */
	public abstract int search(int[] A, int target);

	/**
	 * Time Complexity: o(n)
	 * @author joy
	 *
	 */
	static class Solution1 extends SearchInRotatedSortedArray {

		@Override
		public int search(int[] A, int target) {
			if (A == null || A.length == 0)
				return -1;
			if (A.length == 1) {
				return A[0] == target ? 0 : -1;
			}
			/* find the rotated position */
			int begin1 = 0, end1 = 0, begin2, end2 = A.length - 1;
			/*time complexity: o(n)*/
			while (end1 < A.length - 1 && A[end1] <= A[end1 + 1])
				end1++;
			begin2 = end1 + 1;
			if (end1 == A.length - 1)
				return binarySearch(A, begin1, end1, target);

			if (A[end1] < target || target < A[begin2])
				return -1;
			if (A[end1] >= target && target >= A[begin1])
				return binarySearch(A, begin1, end1, target);
			else
				return binarySearch(A, begin2, end2, target);
		}

		private int binarySearch(int[] A, int begin, int end, int target) {
			int mid = (begin + end) / 2;
			if (A[mid] == target)
				return mid;
			else if (mid == end)
				return -1;
			if (A[mid] < target)
				return binarySearch(A, mid + 1, end, target);
			else if (mid == begin)
				return -1;
			else
				return binarySearch(A, begin, mid - 1, target);
		}

	}
	
	/**
	 * <b>The essence of binary search is every comparison can reduce half of the elements.</b><br>
	 * The variation of rotated array A[n] is that, between (left,mid) and (mid+1, right) there is only one interval is ordered.
	 * Supposed the original array is in ascending order, every comparison has left, right and mid pointers.
	 * So to combine them together, cases after every comparison should be differentiated as:
	 * <ul><li>if target==A[mid], then return the function;</li>
	 * <li>if A[mid]{@literal <}[right], then (mid,right) must be ordered, we can shrink the search interval according the value of target and A[mid]</li> 
	 * <li>A[mid]>=[right], then (left,mid) must be ordered, we can shrink the search interval according the value of target and A[mid]</li></ul>
	 * 
	 * <p>Time Complexity: o(log(n))</p>
	 * @author joy
	 *
	 */
	 static class Solution2 extends SearchInRotatedSortedArray{

		@Override
		public int search(int[] A, int target) {
			if(A==null||A.length==0)
				return -1;
			int left=0,right=A.length-1;
			while(left<=right){
				int mid=(left+right)/2;
				if(A[mid]==target)
					return mid; 
				if(A[mid]<A[right]){/*(mid, right) is an ordered interval*/
					if(target<=A[right]&&target>A[mid])
					{
						left=mid+1;
					}else{
						right=mid-1;
					}
				}else{/*(left, mid) is an ordered interval*/
					if(target<A[mid]&&target>=A[left]){
						right=mid-1;
					}else{
						left=mid+1;
					}
				}
			}
			return -1;
		}
		 
	 }
	
}
