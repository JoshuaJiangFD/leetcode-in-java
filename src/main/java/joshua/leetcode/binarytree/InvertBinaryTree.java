package joshua.leetcode.binarytree;

/**
 *Invert Binary Tree
 *
 * @see <a href="https://leetcode.com/problems/invert-binary-tree/">leetcode link</a>
 *
 * Created by joshua on 2015/8/31.
 */
public abstract class InvertBinaryTree {


    /**
     * Invert a binary tree.

             4
           /   \
          2     7
         / \   / \
        1   3 6   9
     to
             4
           /   \
          7     2
         / \   / \
        9   6 3   1


     * @param root
     * @return
     */
    public abstract TreeNode invertTree(TreeNode root);

    static class Solution1 extends InvertBinaryTree{

        @Override
        public TreeNode invertTree(TreeNode root) {
            if(root==null)
                return null;
            RecursiveRevertTree(root);
            return root;
        }

        private void RecursiveRevertTree(TreeNode root){
            TreeNode temp=root.right;
            root.right=root.left;
            root.left=temp;
            if(root.left!=null)
                RecursiveRevertTree(root.left);
            if(root.right!=null)
                RecursiveRevertTree(root.right);
        }
    }

    static class Solution2 extends InvertBinaryTree{

        @Override
        public TreeNode invertTree(TreeNode root) {
            if(root==null)
                return null;
            TreeNode left=invertTree(root.left);
            TreeNode right=invertTree(root.right);
            root.left=right;
            root.right=left;
            return root;
        }
    }

}
