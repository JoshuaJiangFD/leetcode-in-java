package joshua.leetcode.binarytree.bst;

import java.util.Stack;

import joshua.leetcode.binarytree.TreeNode;

/**
 * Implement an iterator over a binary search tree (BST). 
 * 
 * Your iterator will be initialized with the root node of a BST.

   Calling next() will return the next smallest number in the BST.

   Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * @author joy
 *
 */
public abstract class BSTIterator {
	/**
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */

	/**constructor*/
	public BSTIterator(TreeNode root) {
	}

	/** @return whether we have a next smallest number */
	public abstract boolean hasNext();

	/** @return the next smallest number */
	public abstract int next();

	static class Solution extends BSTIterator {

		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		/*Implicit super constructor BSTIterator() is undefined for default constructor. 
		 *Must define an explicit constructor*/
		public Solution(TreeNode root) {
			super(root);
			if(root==null)
				return;
			stack.push(root);
			TreeNode left=root.left;
			while(left!=null){
				stack.push(left);
				left=left.left;
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public int next() {
			TreeNode cur=stack.pop();
			/*right firstly, then right's left, then to the leftmost*/
			if(cur.right!=null)
			{
				stack.push(cur.right);
				TreeNode leftOfRight=cur.right.left;
				while(leftOfRight!=null){
					stack.push(leftOfRight);
					leftOfRight=leftOfRight.left;
				}
			}
			return cur.val;
		}

	}
}
