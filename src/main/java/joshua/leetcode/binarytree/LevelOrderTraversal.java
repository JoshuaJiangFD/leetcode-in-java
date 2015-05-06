package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102	Binary Tree Level Order Traversal<br>
 * 107	Binary Tree Level Order Traversal II
 * 
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">leetcode link of 102</a>
 * @see <a href="https://leetcode.com/problems/binary-tree-level-order-traversal-ii/">leetcode link of 107</a>
 * @author joy
 *
 */
public abstract class LevelOrderTraversal {

	/**
	 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

		For example:
		Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its bottom-up level order traversal as:
		[
		  [15,7],
		  [9,20],
		  [3]
		]
	 * @param root
	 * @return
	 */
	public abstract List<List<Integer>> levelOrderBottom(TreeNode root);

	/**
	 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

			For example:
			Given binary tree {3,9,20,#,#,15,7},
			    3
			   / \
			  9  20
			    /  \
			   15   7
			return its level order traversal as:
			[
			  [3],
			  [9,20],
			  [15,7]
			]
	 * @param root
	 * @return
	 */
	public abstract List<List<Integer>> levelOrder(TreeNode root);

	/**
	 * 
	 * 
	 * @author Joshua.Jiang
	 *
	 */
	static class Solution1 extends LevelOrderTraversal {

		/**
		 * recursive way to solve level traversal
		 */
		@Override
		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			nodes.add(root);
			traverseByLevel(result, nodes);
			return result;
		}

		private void traverseByLevel(List<List<Integer>> result,
				List<TreeNode> parentNodes) {
			if (parentNodes.isEmpty())
				return;
			ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
			ArrayList<Integer> values = new ArrayList<Integer>();
			for (TreeNode node : parentNodes) {
				if (node.left != null) {
					nodes.add(node.left);
				}
				if (node.right != null) {
					nodes.add(node.right);
				}
				values.add(node.val);
			}
			traverseByLevel(result, nodes);
			result.add(values);
		}

		/**
		 * use queue  to solve level traversal
		 */
		@Override
		public List<List<Integer>> levelOrder(TreeNode root) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			List<List<Integer>> result = new ArrayList<List<Integer>>();
			if (root == null)
				return result;
			queue.add(root);
			TreeNode flagNode = new TreeNode(-1);// flag node to indicate the end of a level
			queue.add(flagNode);
			List<Integer> levelVals = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.equals(flagNode)) {
					result.add(levelVals);
					levelVals = new ArrayList<Integer>();
					if (!queue.isEmpty())
						queue.add(flagNode);
				} else {
					levelVals.add(node.val);
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
				}
			}
			return result;
		}

	}

}
