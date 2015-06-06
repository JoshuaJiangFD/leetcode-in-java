package joshua.leetcode.binarytree;

/**
 * 105 Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @see <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">leetcode link</a>
 */
public abstract class ConstructBinaryTreefromPreorderandInorderTraversal {


    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public abstract TreeNode buildTree(int[] preorder, int[] inorder);


    /**
     * recursive method.
     * pre-order is root first then left then right, in-order is left first then root then right.
     * use pre-order's root info to cut in-order array as two. build the tree with current root and build the left and right subtree recursively.
     */
    public static class Solution1 extends ConstructBinaryTreefromPreorderandInorderTraversal {

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder==null||preorder.length==0||inorder==null||inorder.length==0)
                return null;
            return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        }

        /**
         * recursive build sub tree indicated by the four index cursors, i.e. PreS, preE, inS, inE.
         * @param preOrder pre-order result of the whole tree
         * @param inOrder in-order result of the whole tree
         * @param preS start index of pre-order sub-sequence after pre-order traversal.
         * @param preE
         * @param inS  start index of in-order sub-sequence after in-order traversal.
         * @param inE
         * @return
         */
        private TreeNode buildTree(int[] preOrder, int[] inOrder, int preS, int preE, int inS, int inE) {
            if(preS>preE)
                return null;
            int root=preOrder[preS];
            int moves=0;
            while(moves+inS<=inE){
                if(inOrder[moves+inS]==root)
                    break;
                moves++;
            }
            TreeNode rootNode = new TreeNode(root);
            rootNode.left=buildTree(preOrder,inOrder,preS+1,preS+moves,inS,inS+moves-1);
            rootNode.right=buildTree(preOrder,inOrder,preS+moves+1,preE,inS+moves+1,inE);
            return  rootNode;
        }
    }
}
