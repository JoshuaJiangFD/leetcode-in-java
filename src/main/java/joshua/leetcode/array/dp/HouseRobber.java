package joshua.leetcode.array.dp;

/**
 * 198--House Robber
 * @see <a href="https://leetcode.com/problems/house-robber/">house-robber</a>
 * @author joy
 *
 */
public abstract class HouseRobber {
	
	/**
	 * You are a professional robber planning to rob houses along a street. 
	 * Each house has a certain amount of money stashed, 
	 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
	 * and it will automatically contact the police if two adjacent houses were broken into on the same night.

		Given a list of non-negative integers representing the amount of money of each house, 
		determine the maximum amount of money you can rob tonight without alerting the police.
	 * @param num
	 * @return
	 */
	public abstract int rob(int[] num);
	
	static class Solution1 extends HouseRobber{

		/**
		 * Question is abstracted as find the optimal subsequence without adjacent elements but with maximum sum.
		 * For num[1,..n], at position i, if we know the maximum value of num[1,..i] with and without element i,
		 * as A(i):		the maximum value of num[1,..i] including element i
		 *    B(i):		the maximum value of num[1,..i] excluding element i
		 *    
		 * the the values at position i will be:
		 * 
		 * A(i) = B(i-1)+num[i]
		 * B(i) = max[A(i-1),	B(i-1)]
		 * 
		 * the maximum value of num[1,..n] will be:
		 * Max(1,..,n)=max(A(n),B(n))
		 */
		@Override
		public int rob(int[] num) {
			if(num==null||num.length==0)
				return 0;
			int A=num[0];
			int B=0;
			for(int i=1;i<=num.length-1;i++){
				int temp=A;
				A=B+num[i];
			    B=Math.max(B, temp);
			}
			return Math.max(A, B);
		}
		
	}
}