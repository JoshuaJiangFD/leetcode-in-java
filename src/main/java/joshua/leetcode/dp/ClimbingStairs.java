package joshua.leetcode.dp;

public abstract class ClimbingStairs {

	/**
	 * 
	 * @param n
	 * @return
	 */
	public abstract int climbStairs(int n);

	/**
	 * time complexity: o(power(2,n)) due to repeated calculation
	 * f(n)=f(n-1)+f(n-2), while f(n-1)=f(n-2)+f(n-3), f(n-2) is calculated more
	 * than once.
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
	 * time complexity: o(n). 
	 * which for every step only calculates and retains the result for next step.
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
