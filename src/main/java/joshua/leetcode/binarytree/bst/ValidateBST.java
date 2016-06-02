package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;
import joshua.leetcode.solutiontag.Recursive;

/**
 * 98 Validate Binary Search Tree
 *
 * @author joy
 * @see <a href="https://leetcode.com/problems/validate-binary-search-tree/">leetcode link</a>
 */
public abstract class ValidateBST {

    /**
     * Given a binary tree, determine if it is a valid binary search tree (BST).
     * <p/>
     * Assume a BST is defined as follows:
     * <p/>
     * 1) The left subtree of a node contains only nodes with keys less than the node's key.
     * 2) The right subtree of a node contains only nodes with keys greater than the node's key.
     * 3) Both the left and right subtrees must also be binary search trees.
     *
     * @param root
     * @return
     */
    public abstract boolean isValidBST(TreeNode root);

    /**
     * 每个节点只遍历了一次, 类似DFS搜索。
     *
     * 时间复杂度 O(n)
     */
    @Recursive
    static class Solution1 extends ValidateBST {

        @Override
        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;
            return recurValidate(root).result;
        }

        private RecurResult recurValidate(TreeNode root) {
            if (root.left == null && root.right == null)
                return new RecurResult(root.val, root.val, true);

            RecurResult leftRes = root.left != null ? recurValidate(root.left) : null;

            if (leftRes != null && (!leftRes.result || root.val <= leftRes.largest))
                return RecurResult.FALSE_RES;

            RecurResult rightRes = root.right != null ? recurValidate(root.right) : null;
            if (rightRes != null
                    && (!rightRes.result || root.val >= rightRes.smallest))
                return RecurResult.FALSE_RES;

            return new RecurResult(rightRes != null ? rightRes.largest : root.val,
                    leftRes != null ? leftRes.smallest : root.val,
                    true);
        }

        static class RecurResult {
            int largest;
            int smallest;
            boolean result;

            static final RecurResult FALSE_RES = new RecurResult(0, 0, false);

            public RecurResult(int largest, int smallest, boolean result) {
                super();
                this.largest = largest;
                this.smallest = smallest;
                this.result = result;
            }
        }
    }

    /**
     * 对每个节点需要判断其是否大于左子树的最大值，以及右子树的最小值，因此每个节点的时间复杂度为log(n),
     * 总的平均复杂度为O(nlogn)
     *
     * 时间复杂度 O(nlogn)
     */
    @Recursive
    static class Solution2 extends ValidateBST {

        @Override
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.left != null) {
                TreeNode largestInLeft = root.left;
                while (largestInLeft.right != null) {
                    largestInLeft = largestInLeft.right;
                }
                if (root.val <= largestInLeft.val) {
                    return false;
                }
            }
            if (root.right != null) {
                TreeNode smallestInRight = root.right;
                while (smallestInRight.left != null) {
                    smallestInRight = smallestInRight.left;
                }
                if (root.val >= smallestInRight.val) {
                    return false;
                }
            }
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }
}
