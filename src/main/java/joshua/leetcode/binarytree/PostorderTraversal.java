package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal 
 * 
 * @author joy
 *
 */
public abstract class PostorderTraversal {
	/**
	 * Given a binary tree, return the postorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [3,2,1].
	 * @param root
	 * @return
	 */
	public abstract List<Integer> postorderTraversal(TreeNode root);

	/**
	 * iterative way using stack, to avoid recursive way.
	 * @author joy
	 *
	 */
	static class Solution1 extends PostorderTraversal {

		@Override
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer>  result=new ArrayList<Integer>();
			if(root==null)
				return result;
			Stack<NodeInfo> nodeInfos=new Stack<NodeInfo>();
			nodeInfos.add(new NodeInfo(root));
			while(!nodeInfos.isEmpty()){
				NodeInfo top=nodeInfos.peek();
				if(top.leftVisited&& top.rightVisited)
				{
					result.add(top.node.val);
					nodeInfos.pop();
					continue;
				}
				if(!top.leftVisited){
					top.leftVisited=true;
					if(top.node.left!=null){
						nodeInfos.push(new NodeInfo(top.node.left));
					}
					continue;
				}if(!top.rightVisited){
					top.rightVisited=true;
					if(top.node.right!=null)
						nodeInfos.push(new NodeInfo(top.node.right));
				}
			}
			return result;
		}

		private class NodeInfo {
			TreeNode node;
			Boolean leftVisited = false;
			Boolean rightVisited = false;

			public NodeInfo(TreeNode node) {
				this.node = node;
			}
		}
	}

}
