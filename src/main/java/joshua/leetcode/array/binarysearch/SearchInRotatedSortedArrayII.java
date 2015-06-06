package joshua.leetcode.array.binarysearch;

/**
 * 81	Search in Rotated Sorted Array II
 * 
 * @see <a href="https://leetcode.com/problems/search-in-rotated-sorted-array-ii/">leetcode link</a>
 * @author joy
 *
 */
public abstract class SearchInRotatedSortedArrayII {

	/**
	 * Follow up for "Search in Rotated Sorted Array": If duplicates are allowed.
	 * 
	 * @param A
	 * @param target
	 * @return true if a given target is in the array
	 * @see {@link joshua.leetcode.array.binarysearch.SearchInRotatedSortedArray}
	 */
	 public abstract boolean search(int[] A, int target);
	 
	 /**
	  * A variation of {@link joshua.leetcode.array.binarysearch.SearchInRotatedSortedArray.Solution2}
	  * But two points to make it different here:
	  * <ul><li>this time we compare the A[mid] and A[left];</li>
	  * <li>to address the duplicate element, we move the left pointer when the A[mid] and A[left] equals.</li></ul>
	  * @author joy
	  *
	  */
	 static class  Solution1 extends SearchInRotatedSortedArrayII{

		@Override
		public boolean search(int[] A, int target) {
			if(A==null||A.length==0)
				return false;
			int left=0,right=A.length-1;
			while(left<=right){
				int mid=(left+right)/2;
				if(A[mid]==target)
					return true;
				if(A[mid]>A[left]){/*interval (left,mid) is ordered*/
					if(target>=A[left] && target<A[mid])
					{
						right=mid-1;
					}else
						left=mid+1;
				}else if(A[mid]<A[left]){/*interval (right,mid) is ordered*/
					if(target>A[mid]&&target<=A[right]){
						left=mid+1;
					}else
						right=mid-1;
				}else{/*A[mid]==A[left], can't decide which interval is ordered one, so move the left pointer one step rightward*/
					left++;
				}
			}
			return false;
		}
		 
	 }
	
}
