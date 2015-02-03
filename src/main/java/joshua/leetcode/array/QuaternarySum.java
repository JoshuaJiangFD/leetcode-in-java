package joshua.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class QuaternarySum {
	/**
	 * Given an array S of n integers, are there elements a, b, c, and d in S
	 * such that a + b + c + d = target? Find all unique quadruplets in the
	 * array which gives the sum of target.
	 * 
	 * Note: Elements in a quadruplet (a,b,c,d) must be in non-descending order.
	 * (ie, a ≤ b ≤ c ≤ d) The solution set must not contain duplicate
	 * quadruplets. For example, given array S = {1 0 -1 0 -2 2}, and target =
	 * 0.
	 * 
	 * A solution set is: (-1, 0, 0, 1) (-2, -1, 1, 2) (-2, 0, 0, 2)
	 * 
	 * @param num
	 * @param target
	 * @return
	 */
	public abstract List<List<Integer>> fourSum(int[] num, int target);

	static class Solution1 extends QuaternarySum {

		@Override
		public List<List<Integer>> fourSum(int[] num, int target) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			List<Quadruplet> mediateResult = new ArrayList<Quadruplet>();
			if (num == null)
				return result;
			int length = num.length;
			if (length < 4)
				return result;
			int first = 0, fourth;
			int second, third;
			Arrays.sort(num);
			for (first = 0; first <= length - 4; first++) {
				for (fourth = length - 1; fourth >= first + 3; fourth--) {
					int subTarget = target - num[first] - num[fourth];
					second = first + 1;
					third = fourth - 1;
					while (second < third) {
						int sum = num[second] + num[third];
						if (sum < subTarget)
							second++;
						else if (sum > subTarget)
							third--;
						else {
							Quadruplet res = new Quadruplet(num[first],
									num[second], num[third], num[fourth]);
							if (!mediateResult.contains(res))
								mediateResult.add(res);
							second++;
							third--;
						}
					}
				}
			}
			for (Quadruplet res : mediateResult) {
				result.add(res.values);
			}
			return result;
		}

		private class Quadruplet {
			List<Integer> values = new ArrayList<Integer>();

			public Quadruplet(int x, int y, int z, int w) {
				values.add(x);
				values.add(y);
				values.add(z);
				values.add(w);

			}

			@Override
			public int hashCode() {
				return values.hashCode();
			}

			@Override
			public boolean equals(Object obj) {
				if (obj == null)
					return false;
				if (!(obj instanceof Quadruplet))
					return false;
				Quadruplet another = (Quadruplet) obj;
				return another.values.equals(this.values);
			}

		}
	}
}
