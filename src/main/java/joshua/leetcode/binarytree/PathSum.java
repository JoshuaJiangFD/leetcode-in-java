package joshua.leetcode.binarytree;

public abstract class PathSum {

	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

		For example:
		Given the below binary tree and sum = 22,
		              5
		             / \
		            4   8
		           /   / \
		          11  13  4
		         /  \      \
		        7    2      1
		return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
	 * @param root
	 * @param sum
	 * @return
	 */
	 public abstract boolean hasPathSum(TreeNode root, int sum);
	 
	 static class Solution1 extends PathSum{

		@Override
		public boolean hasPathSum(TreeNode root, int sum) {
			if (root == null)
				return false;
			int diff = sum - root.val;
			if (diff == 0 && root.left == null && root.right == null)
				return true;
			if (root.left != null ) {
				Boolean flag = hasPathSum(root.left, diff);
				if (flag == true)
					return flag;
			}
			if (root.right != null ){
				Boolean flag = hasPathSum(root.right, diff);
				if (flag == true)
					return flag;
			}
			return false;
		}
		 
	 }
}
