package joshua.leetcode.binarytree.dp;

import java.util.ArrayList;
import java.util.List;

public abstract class UniqueBinarySearchTrees {
	/**
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

		For example,
		Given n = 3, there are a total of 5 unique BST's.
	
			1         3     3      2      1
			\       /     /      / \      \
			 3     2     1      1   3      2
			/     /       \                 \
			2     1         2                 3

	 * @param n
	 * @return
	 */
	public abstract int numTrees(int n);

	static class Solution1 extends UniqueBinarySearchTrees {

		@Override
		public int numTrees(int n) {
			if (n == 0)
				return 0;
			if (n == 1)
				return 1;
			if (n == 2)
				return 2;
			List<Integer> result = new ArrayList<Integer>();
			result.add(1);
			result.add(1);
			result.add(2);
			int i = 3;
			while (i <= n) {
				if (i % 2 == 0) {
					int num = 0;
					int sentry = i - 1;
					while (sentry >= i / 2) {
						num += 2 * result.get(sentry)
								* result.get(i - 1 - sentry);
						sentry--;
					}
					result.add(num);
				} else {
					int num = 0;
					int sentry = i - 1;
					while (sentry >= i / 2) {
						if (sentry > i / 2)
							num += 2 * result.get(sentry)
									* result.get(i - 1 - sentry);
						else
							num += result.get(sentry) * result.get(sentry);
						sentry--;
					}
					result.add(num);
				}
				i++;
			}
			return result.get(result.size() - 1);
		}
	}
}
