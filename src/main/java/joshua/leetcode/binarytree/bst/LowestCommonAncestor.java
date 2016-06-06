package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;

/**
 * 235	Lowest Common Ancestor of a Binary Search Tree
 *
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">leetcode link</a>
 */
public abstract class LowestCommonAncestor {

    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     * <p/>
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
     * _______6______
     * /              \
     * ___2__          ___8__
     * /      \        /      \
     * 0      _4       7       9
     * /  \
     * 3   5
     * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6.
     * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public abstract TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

    static class Solution1 extends LowestCommonAncestor {

        /**
         * this is a binary search tree. so compare the values of two nodes with root,
         * if both are smaller than the root, repeat comparison with root's left;
         * if both are bigger than the root, repeat comparison with root's right;
         * otherwise, return the root as the LCA;
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left, p, q);
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            return root;
        }
    }
}
