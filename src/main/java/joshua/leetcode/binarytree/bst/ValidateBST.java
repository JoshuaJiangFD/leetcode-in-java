package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;

/**
 * 98 Validate Binary Search Tree
 * 
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">leetcode link</a>
 * @author joy
 *
 */
public abstract class ValidateBST {

	/**
	 * Given a binary tree, determine if it is a valid binary search tree (BST).

	   Assume a BST is defined as follows:
		
		1) The left subtree of a node contains only nodes with keys less than the node's key.
		2) The right subtree of a node contains only nodes with keys greater than the node's key.
		3) Both the left and right subtrees must also be binary search trees.
		
	 * @param root
	 * @return
	 */
	public abstract boolean isValidBST(TreeNode root);

	/**
	 * recursive solution.
	 * @author joy
	 *
	 */
	static class Solution1 extends ValidateBST {

		@Override
		public boolean isValidBST(TreeNode root) {
			if (root == null)
				return true;
			return recurValidate(root).result;
		}

		private RecurResult recurValidate(TreeNode root) {
			if (root.left == null && root.right == null)
				return new RecurResult(root.val, root.val, true);
			
			RecurResult leftRes = root.left != null ? recurValidate(root.left): null;
			
			if (leftRes != null&& ( !leftRes.result|| root.val <= leftRes.largest))
				return RecurResult.FALSE_RES;
			
			RecurResult rightRes = root.right != null ? recurValidate(root.right): null;
			if (rightRes != null
					&& (!rightRes.result || root.val >= rightRes.smallest  ))
				return RecurResult.FALSE_RES;

			return new RecurResult(rightRes != null ? rightRes.largest : root.val,
					               leftRes != null ? leftRes.smallest: root.val,
					               true);
		}

		static class RecurResult {
			int largest;
			int smallest;
			boolean result;

			static final RecurResult FALSE_RES = new RecurResult(0, 0, false);

			public RecurResult(int largest, int smallest, boolean result) {
				super();
				this.largest = largest;
				this.smallest = smallest;
				this.result = result;
			}
		}

	}

}
