package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class InorderTraversal {

	/**
	 * Given a binary tree, return the in-order traversal of its nodes' values.
	   For example:
			Given binary tree {1,#,2,3},
			   1
			    \
			     2
			    /
			   3
			return [1,3,2].
		
	 * @param root
	 * @return
	 */
	public abstract List<Integer> inorderTraversal(TreeNode root);

	/**
	 * non-recursive way.
	 * @author joy
	 *
	 */
	static class Solution1 extends InorderTraversal {

		@Override
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<Integer>();
			if (root == null)
				return result;
			Stack<NodeInfo> nodes = new Stack<NodeInfo>();
			nodes.push(new NodeInfo(root,false));
			while (!nodes.isEmpty()) {
				NodeInfo curNode=nodes.peek();
				if(curNode.isVisited){
					result.add(curNode.node.val);
					nodes.pop();
					if(curNode.node.right!=null)
						nodes.add(new NodeInfo(curNode.node.right,false));
				}else{
					curNode.isVisited=true;
					if(curNode.node.left!=null)
						nodes.add(new NodeInfo(curNode.node.left,false));
				}
			}
			return result;
		}

		class NodeInfo {
			TreeNode node;
			Boolean isVisited;

			NodeInfo(TreeNode node, Boolean isVisited) {
				this.node = node;
				this.isVisited = isVisited;
			}
		}
	}
	
	static class Solution2 extends InorderTraversal{

		@Override
		public List<Integer> inorderTraversal(TreeNode root) {
			List<Integer> result=new ArrayList<Integer>();
			traverseSubTree(root,result);
			return result;
		}
		
		private void traverseSubTree(TreeNode subRoot,List<Integer> result){
			if(subRoot==null)
				return;
			if(subRoot.left!=null)
				traverseSubTree(subRoot.left,result);
			result.add(subRoot.val);
			if(subRoot.right!=null)
				traverseSubTree(subRoot.right,result);
		}
		
	}
}
