package joshua.leetcode.binarytree;

/**
 *Lowest Common Ancestor of a Binary Tree
 *
 * @see <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">leetcode link</a>
 */
public abstract class LowestCommonAncestor {

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

     According to the definition of LCA on Wikipedia:
     “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
            _______3______
           /              \
         ___5__          ___1__
        /      \        /      \
        6      _2       0       8
               /  \
               7   4
     For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     * @param root
     * @param p
     * @param q
     * @return
     */
    public abstract TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q);

    /**
     * recursive way.
     * the inefficient factor of this way is that, even the true Lowest Common ancestor is found at root's left side,
     * still need to traverse root's right side.
     *
     */
    static class Solution1 extends LowestCommonAncestor{

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null)
                return null;
            /*if root is p or q, return directly.it covers the cases when p is parent of q or the other way, or this root only contains q or p.*/
            if(root.val==p.val||root.val==q.val)
                return root;
            TreeNode left=root.left!=null?lowestCommonAncestor(root.left,p,q):null;
            TreeNode right=root.right!=null?lowestCommonAncestor(root.right,p,q):null;
            /**
             * if left and right aren't null, then p and q is found respectively(which side doesn't matter)
             * then root is the lowest common ancestor.
             */
            if(left!=null&&right!=null)
                return root;
            /*otherwise, q and  p is found at left or right side of root, just return the result from lower level.*/
            if(left!=null||right!=null)
            {
                return left!=null?left:right;
            }
            /*either p or q is root or under root. return null.*/
            return null;
        }
    }

    /**
     * improvement of solution1: if both left and right are't null, that means this unique lowest common ancestor is found so no need to traverse the remaining nodes.
     * just return directly.
     */
    static class Solution2 extends LowestCommonAncestor{

        @Override
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null)
                return null;
            LCAPair result= findLowestCommonAncestor(root,p,q);
            return result!=null?result.lca:null;
        }

        private LCAPair findLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null)
                return null;
            /*if root is p or q, return directly.it covers the cases when p is parent of q or the other way, or this root only contains q or p.*/
            if(root.val==p.val||root.val==q.val)
                return new LCAPair(root,false);
            LCAPair left= (root.left != null) ? findLowestCommonAncestor(root.left, p, q) : null;
            if(left!=null&&left.found)
                return left;
            LCAPair right= (root.right != null) ? findLowestCommonAncestor(root.right, p, q) : null;
            if(right!=null&&left.found)
                return right;
            /**
             * if left and right aren't null, then p and q is found respectively(which side doesn't matter)
             * then root is the lowest common ancestor.
             */
            if(left!=null&&right!=null)
                return new LCAPair(root,true);
            /*otherwise, q and  p is found at left or right side of root, just return the result from lower level.*/
            if(left!=null||right!=null)
            {
                return left!=null?left:right;
            }
            /*either p or q is root or under root. return null.*/
            return null;
        }

        class LCAPair {
            TreeNode lca;
            boolean  found;

            public LCAPair(TreeNode lca, boolean found) {
                this.lca = lca;
                this.found = found;
            }
        }
    }
}
