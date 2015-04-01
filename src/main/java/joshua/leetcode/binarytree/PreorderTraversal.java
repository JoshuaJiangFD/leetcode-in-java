package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal 
 * @author joy
 *
 */
public abstract class PreorderTraversal {

	/**
	 * Given a binary tree, return the preorder traversal of its nodes' values.

		For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,2,3].
	 * @param root
	 * @return
	 */
	public abstract List<Integer> preorderTraversal(TreeNode root);
	
	/**
	 * iterative solution using stack.
	 */
	static class Solution1 extends PreorderTraversal{

		@Override
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result=new ArrayList<Integer>();
			if(root==null)
				return result;
			Stack<NodeInfo> nodes=new Stack<NodeInfo>();
			nodes.push(new NodeInfo(root));
			while(!nodes.isEmpty()){
				NodeInfo nodeInfo=nodes.peek();
				if(nodeInfo.visited){
					nodes.pop();
					if(nodeInfo.node.right!=null)
						nodes.push(new NodeInfo(nodeInfo.node.right));
				}else{
					result.add(nodeInfo.node.val);
					nodeInfo.visited=true;
					if(nodeInfo.node.left!=null)
						nodes.push(new NodeInfo(nodeInfo.node.left));
				}
			}
			return result;
		}
		
		private class NodeInfo{
			TreeNode node;
			Boolean visited=false;
			
			NodeInfo(TreeNode node){this.node=node;}

			@Override
			public String toString() {
				return "NodeInfo [node=" + node.val + ", visited=" + visited + "]";
			}
		}
	}
	
}
