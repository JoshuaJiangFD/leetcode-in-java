package joshua.leetcode.dp;

public abstract class ClimbingStairs {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public abstract int climbStairs(int n);

	/**
	 * <b>Time Complexity</b>: 2<sup>n</sup>, due to repeated calculation</br>
	 * This is a up-bottom way of calculation. </br>
	 * 
	 * e.g. f(n)=f(n-1)+f(n-2), while f(n-1)=f(n-2)+f(n-3), f(n-2) is calculated more than once.</br>
	 * 
	 * @author Joshua.Jiang
	 *
	 */
	static class Solution1 extends ClimbingStairs {

		@Override
		public int climbStairs(int n) {
			if (n == 1)
				return 1;
			if (n == 2)
				return 2;
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}

	/**
	 * <b>Time Complexity</b>: o(n).</br>
	 * This is a bottom-up way of calculation. </br>
	 * which for every step only calculates and retains the result for next step.</br>
	 * 
	 * @author Joshua.Jiang
	 *
	 */
	static class Solution2 extends ClimbingStairs {

		@Override
		public int climbStairs(int n) {
			int a = 1, b = 1;
			for (int i = 2; i <= n; i++) {
				int temp=a+b;
				a=b;
				b=temp;
			}
			return b;
		}

	}
}
