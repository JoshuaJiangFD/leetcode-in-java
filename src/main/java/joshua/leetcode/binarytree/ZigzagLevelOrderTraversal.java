package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class ZigzagLevelOrderTraversal {

	/**
	 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
	 * (ie, from left to right, then right to left for the next level and alternate between).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its zigzag level order traversal as:
		[
		  [3],
		  [20,9],
		  [15,7]
		]
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public abstract List<List<Integer>> zigzagLevelOrder(TreeNode root);

	static class Solution extends ZigzagLevelOrderTraversal {

		@Override
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

			Stack<TreeNode> oddLevels = new Stack<TreeNode>();
			Stack<TreeNode> evenLevels = new Stack<TreeNode>();
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			oddLevels.push(root);
			Boolean oddLevelInState = true;
			List<Integer> valuesInLevel = new ArrayList<Integer>();
			while (!oddLevels.isEmpty() || !evenLevels.isEmpty()) {

				if (oddLevelInState) {
					if (oddLevels.isEmpty()) {
						oddLevelInState = false;
						if (!valuesInLevel.isEmpty()) {
							result.add(valuesInLevel);
							valuesInLevel = new ArrayList<Integer>();
						}
						continue;
					} else {
						TreeNode cur = oddLevels.pop();
						valuesInLevel.add(cur.val);
						if (cur.left != null)
							evenLevels.push(cur.left);
						if (cur.right != null)
							evenLevels.push(cur.right);
					}
				} else {
					if (evenLevels.isEmpty()) {
						oddLevelInState = true;
						if (!valuesInLevel.isEmpty()) {
							result.add(valuesInLevel);
							valuesInLevel = new ArrayList<Integer>();
						}
						continue;
					} else {
						TreeNode cur = evenLevels.pop();
						valuesInLevel.add(cur.val);
						if (cur.right != null)
							oddLevels.push(cur.right);
						if (cur.left != null)
							oddLevels.push(cur.left);
					}
				}
			}
			if (!valuesInLevel.isEmpty()) {
				result.add(valuesInLevel);
			}
			return result;
		}
	}
}
