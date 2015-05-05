package joshua.leetcode.binarytree;


/**
 * 116	Populating Next Right Pointers in Each Node
 * 
 * @see <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node/">leetcode link</a>
 * @author joy
 *
 */
public abstract class PopulatingNextRightPointersinEachNode {

	/**
	 * Given a binary tree
	 * 
	Populate each next pointer to point to its next right node. 
	
	If there is no next right node, the next pointer should be set to NULL.
	
	Initially, all next pointers are set to NULL.
	
	Note:
	
	 1)You may only use constant extra space.
	 
	 2)You may assume that it is a perfect binary tree (i.e, all leaves are at the same level, and every parent has two children).
	 
	For example,
	
		Given the following perfect binary tree,
		         1
		       /  \
		      2    3
		     / \  / \
		    4  5  6  7
		After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \  / \
		    4->5->6->7 -> NULL
	    
	    
	 * @param root
	 */
	public abstract void connect(TreeLinkNode root); 
	
	
	/**
	 * * Definition for binary tree with next pointer.
	 */
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	/**
	 * main idea:
	 * To achieve constant space, means solution should not hold the stack by itself, and must do it recursively.
	 * 
	 * Firstly, every node's left and right must be joined.
	 * Secondly, left node's rightmost branch and right node's leftmost branch should be connected.
	 *  
	 * @author joy
	 *
	 */
	static class Solution1 extends PopulatingNextRightPointersinEachNode{

		@Override
		public void connect(TreeLinkNode root) {
			if(root==null||(root.left==null&&root.right==null))
				return;
			root.left.next=root.right;
			TreeLinkNode rightMost=root.left.right;
			TreeLinkNode leftMost=root.right.left;
			while(rightMost!=null){
				rightMost.next=leftMost;
				rightMost=rightMost.right;
				leftMost=leftMost.left;
			}
			connect(root.left);
			connect(root.right);
		}
	}
}
