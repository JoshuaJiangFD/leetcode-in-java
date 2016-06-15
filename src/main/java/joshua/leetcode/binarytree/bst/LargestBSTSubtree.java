

package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;

/**
 * 333. Largest BST Subtree <br/>
 * <p/>
 * <a href="https://leetcode.com/problems/largest-bst-subtree/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class LargestBSTSubtree {

    /**
     * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
     * <p/>
     * Note:
     * A subtree must include all of its descendants.
     * Here's an example:
     * 10
     * / \
     * 5  15
     * / \   \
     * 1   8   7
     * The Largest BST Subtree in this case is the highlighted one.
     * The return value is the subtree's size, which is 3.
     */
    public abstract int largestBSTSubtree(TreeNode root);

    /**
     *
     *
     */
    public static class Solution1 extends LargestBSTSubtree {

        private int largestBSTSize = 0;

        @Override
        public int largestBSTSubtree(TreeNode root) {
            largestBSTSize = 0;
            if (root != null) {
                traverseNode(root);
            }
            return largestBSTSize;
        }

        private NodeInfo traverseNode(TreeNode root) {
            if (root.left == null && root.right == null) {
                largestBSTSize = Math.max(largestBSTSize, 1);
                return new NodeInfo(root.val, root.val, true, 1);
            }
            NodeInfo infoFromLeft = root.left != null ? traverseNode(root.left) : null;
            NodeInfo infoFromRight = root.right != null ? traverseNode(root.right) : null;
            if (infoFromLeft != null) {
                if (!infoFromLeft.isBST || root.val <= infoFromLeft.largestInSubTree) {
                    return new NodeInfo(0, 0, false, 0);
                }
            }
            if (infoFromRight != null) {
                if (!infoFromRight.isBST || root.val >= infoFromRight.smallestInSubTree) {
                    return new NodeInfo(0, 0, false, 0);
                }
            }
            int subTreeSmallest = infoFromLeft != null ? infoFromLeft.smallestInSubTree : root.val;
            int subTreeLargest = infoFromRight != null ? infoFromRight.largestInSubTree : root.val;


            int BSTSize = 1;
            if (infoFromLeft != null) {
                BSTSize += infoFromLeft.size;
            }
            if (infoFromRight != null) {
                BSTSize += infoFromRight.size;
            }
            largestBSTSize = Math.max(largestBSTSize, BSTSize);
            return new NodeInfo(subTreeSmallest, subTreeLargest, true, BSTSize);
        }

        class NodeInfo {
            int smallestInSubTree;
            int largestInSubTree;
            int size;
            boolean isBST;

            public NodeInfo(int smallestInSubTree, int largestInSubTree, boolean isBST, int size) {
                this.smallestInSubTree = smallestInSubTree;
                this.largestInSubTree = largestInSubTree;
                this.isBST = isBST;
                this.size = size;
            }
        }
    }
}
