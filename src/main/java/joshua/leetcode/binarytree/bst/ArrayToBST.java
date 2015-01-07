package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;

public abstract class ArrayToBST {

	/**
	 * Given an array where elements are sorted in ascending order, 
	 * convert it to a height balanced BST.
	 * @param num
	 * @return
	 */
	public abstract TreeNode sortedArrayToBST(int[] num);

	static class Solution1 extends ArrayToBST {

		@Override
		public TreeNode sortedArrayToBST(int[] num) {
			if (num == null || num.length == 0)
				return null;
			int mid = (num.length - 1) / 2;
			TreeNode root = new TreeNode(num[mid]);
			if (mid == num.length - 1)
				return root;
			else if (mid == 0) {
				root.right = new TreeNode(num[1]);
				return root;
			} else {
				buildSubTree(root, num, 0, mid - 1, true);
				buildSubTree(root, num, mid + 1, num.length - 1, false);
				return root;
			}
		}

		private void buildSubTree(TreeNode root, int[] num, int begin, int end,
				Boolean left) {
			int mid = (begin + end) / 2;
			TreeNode subRoot = new TreeNode(num[mid]);
			if (left)
				root.left = subRoot;
			else
				root.right = subRoot;
			if (mid == end) {
				return;
			} else if (mid == begin) {
				subRoot.right = new TreeNode(num[end]);
				return;
			} else {
				buildSubTree(subRoot, num, begin, mid - 1, true);
				buildSubTree(subRoot, num, mid + 1, end, false);
			}
		}

	}
}
