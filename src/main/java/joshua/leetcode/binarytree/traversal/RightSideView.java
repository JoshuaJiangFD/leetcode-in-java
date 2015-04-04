package joshua.leetcode.binarytree.traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import joshua.leetcode.binarytree.TreeNode;


public  abstract class  RightSideView {

	/**
	 * Given a binary tree, imagine yourself standing on the right side of it,
	 *  return the values of the nodes you can see ordered from top to bottom.

		For example:
		Given the following binary tree,
		   1            <---
		 /   \
		2     3         <---
		 \     \
		  5     4       <---
		You should return [1, 3, 4].
		
	 * @param root
	 * @return
	 */
    public abstract List<Integer> rightSideView(TreeNode root);
    
    /**
     * breadth first search
     * @author joy
     *
     */
    static class Solution1 extends RightSideView{

		@Override
		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> result=new ArrayList<Integer>();
			if(root==null)
				return result;
			Queue<TreeNode> queue=new LinkedList<TreeNode>();
			queue.add(root);
			TreeNode delimiterNode=new TreeNode(-1);
			queue.add(delimiterNode);
			TreeNode last=null;
			while(!queue.isEmpty()){
				TreeNode cur=queue.poll();
				if(cur==delimiterNode){
					if(last!=null){
						result.add(last.val);
						last=null;
						queue.add(delimiterNode);
					}
				}else{
					last=cur;
					if(cur.left!=null)
						queue.add(cur.left);
					if(cur.right!=null)
						queue.add(cur.right);
				}
			}
			return result;
		}
    }
}
