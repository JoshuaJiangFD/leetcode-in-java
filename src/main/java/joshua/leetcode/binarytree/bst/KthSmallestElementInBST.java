package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;
import joshua.leetcode.linkedlist.ListNode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *	230	Kth Smallest Element in a BST
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">leetcode link</a>
 */
public abstract class KthSmallestElementInBST {

    /**
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     * Note:
     *  You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     * @param root
     * @param k
     * @return
     */
    public abstract int kthSmallest(TreeNode root, int k);


    /**
     * fast-return recursive solution.
     *
     * check left subtree, if found return immediately, else return left subtree's size;
     * check root;
     * check right subtree, if found return immediately;
     * now we get the full size of this root, return the size so parent level can continue searching;
     *
     */
    static class Solution1 extends KthSmallestElementInBST{

        @Override
        public int kthSmallest(TreeNode root, int k) {
            return search(root,k).target.val;
        }

        private Returned search(TreeNode root,int k){
            if(root==null)
                return new Returned(null,0);
            Returned leftRe=search(root.left,k);
            if(leftRe.target!=null)
                return leftRe;
            if(k==leftRe.count+1)
                return new Returned(root,0);
            Returned rightRe=search(root.right,k-leftRe.count-1);
            if(rightRe.target!=null)
                return rightRe;
            return new Returned(null,leftRe.count+rightRe.count+1);
        }

        class Returned{
            TreeNode target;
            int count;

            Returned(TreeNode target,int count){
                this.target=target;
                this.count=count;
            }

        }
    }

    /**
     * BST树中序遍历，同时对已经遍历的节点个数计数，个数达到k即可返回
     */
    static class Solution2 extends KthSmallestElementInBST{

        @Override
        public int kthSmallest(TreeNode root, int k) {
            throw new NotImplementedException();
        }
    }
}
