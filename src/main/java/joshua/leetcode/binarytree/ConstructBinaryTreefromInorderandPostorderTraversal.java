package joshua.leetcode.binarytree;

/**
 *106 Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">leetcode link</a>
 */
public abstract class ConstructBinaryTreefromInorderandPostorderTraversal {

    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.

     * @param inorder
     * @param postorder
     * @return
     */
    public abstract TreeNode buildTree(int[] inorder, int[] postorder);


    /**
     * recursively build tree by find the boundary of left and right subtree.
     *
     * @see ConstructBinaryTreefromPreorderandInorderTraversal
     */
    static class Solution extends ConstructBinaryTreefromInorderandPostorderTraversal{

        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
                return null;
            }
            return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] inorder,int[] postoreder, int inS,int inE,int postS,int postE) {
            if (inS > inE) {
                return null;
            }
            int root = postoreder[postE];
            int steps=0;
            while (steps + inS <= inE) {
                if (inorder[steps + inS] == root) {
                    break;
                }
                steps++;
            }
            TreeNode rootNode = new TreeNode(root);
            rootNode.left=buildTree(inorder,postoreder,inS,inS+steps-1,postS,postS+steps-1);
            rootNode.right=buildTree(inorder,postoreder,inS+steps+1,inE,postS+steps,postE-1);
            return rootNode;
        }
    }
}
