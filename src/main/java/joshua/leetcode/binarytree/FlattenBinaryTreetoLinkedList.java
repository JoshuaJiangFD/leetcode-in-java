package joshua.leetcode.binarytree;

public abstract class FlattenBinaryTreetoLinkedList {

	/**
	 * 
	 * Given a binary tree, flatten it to a linked list in-place.

		For example,
		Given
		
		         1
		        / \
		       2   5
		      / \   \
		     3   4   6
		The flattened tree should look like:
		   1
		    \
		     2
		      \
		       3
		        \
		         4
		          \
		           5
		            \
		             6
		             
	If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
	
	 * @param root
	 */
	public abstract void flatten(TreeNode root);

	/**
	 * recursive way.
	 * @author joy
	 *
	 */
	static class Solution1 extends FlattenBinaryTreetoLinkedList {

		@Override
		public void flatten(TreeNode root) {
			if (root == null)
				return;
			getsubFlatten(root);
		}
		
		private TreeNode getsubFlatten(TreeNode root){
			if(root==null)
				return null;
			TreeNode leftRoot=getsubFlatten(root.left);
			TreeNode rightRoot=getsubFlatten(root.right);
			if(leftRoot!=null)
			{
				root.right=leftRoot;
				while(leftRoot.right!=null) leftRoot=leftRoot.right;
				leftRoot.right=rightRoot;
			}
			else{
				root.right=rightRoot;
			}
			return root;
		}
	}
}
