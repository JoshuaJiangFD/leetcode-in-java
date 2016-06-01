// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.binarytree;

import joshua.leetcode.solutiontag.Recursive;

/**
 * 100. Same Tree <br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/same-tree/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class SameTree {

    /**
     * Given two binary trees, write a function to check if they are equal or not.
     * <p/>
     * Two binary trees are considered equal
     * <p/>
     * if they are structurally identical and the nodes have the same value.
     *
     */
    public abstract boolean isSameTree(TreeNode p, TreeNode q);

    @Recursive
    public static class Solution1 extends SameTree {

        @Override
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null ^ q == null) {
                return false;
            }
            if (p == null && q == null) {
                return true;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
