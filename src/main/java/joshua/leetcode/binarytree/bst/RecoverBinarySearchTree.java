package joshua.leetcode.binarytree.bst;



import joshua.leetcode.binarytree.TreeNode;

/**
 * 99	Recover Binary Search Tree
 * 
 * @see <a href="https://leetcode.com/problems/recover-binary-search-tree/">leetcode link</a>
 * @author joy
 *
 */
public abstract class RecoverBinarySearchTree {

	/**
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * Recover the tree without changing its structure. 
	 * 
	 * @param root
	 */
	public abstract void recoverTree(TreeNode root);

	/**
	 * Depth First Search.
	 * 
	 * To detect the first swapped node, need to compare every node with it's successor in In-Order traversal, 
	 * the first element with a smaller successor is the target.
	 * 
	 * To detect the second swapped node, need to compare every node with it's pioneer in In-Order traversal,
	 * the last element with a bigger pioneer is the target. 
	 * 
	 * @author joy
	 *
	 */
	static class Solution1 extends RecoverBinarySearchTree {

		/**
		 * use constant space.
		 */
		@Override
		public void recoverTree(TreeNode root) {
			if (root == null || (root.left == null && root.right == null))
				return;
			TreeNode[] targets=new TreeNode[2];
			checkElement(root,null,targets);
			if(targets[0]!=null&&targets[1]!=null){
				int temp=targets[0].val;
				targets[0].val=targets[1].val;
				targets[1].val=temp;
			}
		}

		private TreeNode checkElement(TreeNode cur, TreeNode pioneer,TreeNode[] targets) {
			/*If current node has left node, then pass the pioneer to the left.
			 * current node have no left node, then passed-in pioneer is current node's pioneer,compare them to decide the
			 * swapped nodes.
			 */
			if (cur.left != null) {
				pioneer= checkElement(cur.left, pioneer,
						targets);
			}
			if (pioneer != null) {/*pioneer equals null means current node is the first node*/
				if (cur.val < pioneer.val) {
					if (targets[0] == null)
						targets[0] = pioneer;
					targets[1] = cur;
				}
			}
			if(cur.right!=null)
				return checkElement(cur.right,cur,targets);
			else 
				return cur;
		}

	}
}
