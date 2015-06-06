package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;

/**
 * 110 Balanced Binary Tree
 * 
 * @see <a href="https://leetcode.com/problems/balanced-binary-tree/">leetcode link</a>
 * @author joy
 *
 */
public class IsBST {


	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * For this problem, a height-balanced binary tree is defined as a binary tree 
	 * in which the depth of the two subtrees of every node never differ by more than 1.
	 * 
	 * @param root
	 * @return
	 * 
	 */
	public boolean isBalanced(TreeNode root) {
		return isSubBalanced(root).isBalanced;
	}
	
	private Result isSubBalanced(TreeNode subRoot){
		if(subRoot==null)
			return new Result(true,0);
		Result leftRes=isSubBalanced(subRoot.left);
		if(!leftRes.isBalanced)
			return new Result(false,0);
		Result rightRes=isSubBalanced(subRoot.right);
		if(!rightRes.isBalanced)
			return new Result(false,0);
		if(Math.abs(leftRes.depth-rightRes.depth)<=1)
			return new Result(true,Math.max(leftRes.depth, rightRes.depth)+1);
		else
			return new Result(false,0);
	}

	class Result {
		boolean isBalanced;
		int depth;

		Result(boolean isBalanced, int depth) {
			this.isBalanced = isBalanced;
			this.depth = depth;
		}
	}
}
