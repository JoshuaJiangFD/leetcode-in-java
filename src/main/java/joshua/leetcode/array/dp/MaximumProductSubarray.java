package joshua.leetcode.array.dp;

/**
 * 152	Maximum Product Subarray
 * @see <a href="https://leetcode.com/problems/maximum-product-subarray/">leetcode link</a>
 * @author joy
 *
 */
public abstract class MaximumProductSubarray {

	/*
	 * Find the contiguous sub-array within an array (containing at least one number) 
	 * which has the largest product.

	 * For example, given the array [2,3,-2,4], the contiguous sub-array [2,3] has the largest product = 6.
	 */
	public abstract int maxProduct(int[] A);
	
	static class Solution extends MaximumProductSubarray{

		/**
		 * Define A[i...j] is the sub-array of A indexed from 1 to j:
		 * <ul><li>MP[i...j] is the the largest product of contiguous sub-array within A[i...j];</li>
		 * <li>MaxPj[i...j] is the the largest product of contiguous sub-array within A[i...j] AND ended at index j;</li>
		 * <li>MinPj[i...j] is the the smallest product of contiguous sub-array within A[i...j] AND ended at index j;</li></ul>
		 * 
		 * Due to negative number, the MaxPj[i...j+1] and MinPj[i...j+1] is decided by <b>three</b> factors:</br>
		 * <i>preMax*A[i]</i>, <i>A[i]</i>, <i>preMin*A[i]</i></br>
		 */
		@Override
		public int maxProduct(int[] A) {
			if(A==null || A.length==0)
				return 0;
			int globalMP=A[0];
			int preMax=A[0];
			int preMin=A[0];
			for(int i=1;i<A.length;i++){
				int max=Math.max(preMax*A[i],Math.max( A[i],preMin*A[i]));
				preMin=Math.min(preMax*A[i],Math.min( A[i],preMin*A[i]));
				preMax=max;
				globalMP=Math.max(preMax, globalMP);
			}
			return globalMP;
		}
	}
}
