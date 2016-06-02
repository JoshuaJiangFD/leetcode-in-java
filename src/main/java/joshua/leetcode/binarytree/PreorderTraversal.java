package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import joshua.leetcode.solutiontag.Stacks;

/**
 * Binary Tree Preorder Traversal
 *
 * @author joy
 */
public abstract class PreorderTraversal {

    /**
     * Given a binary tree, return the preorder traversal of its nodes' values.
     * <p/>
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     * \
     * 2
     * /
     * 3
     * return [1,2,3].
     *
     * @param root
     * @return
     */
    public abstract List<Integer> preorderTraversal(TreeNode root);

    /**
     * iterative solution using stack.
     * <p/>
     * 时间复杂度为O(n), 每个节点访问了两遍。
     * 空间复杂度为O(logn), 最坏情况下为n，如果出现单侧树的情况下。
     */
    @Stacks
    static class Solution1 extends PreorderTraversal {

        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null)
                return result;
            Stack<NodeInfo> nodes = new Stack<NodeInfo>();
            nodes.push(new NodeInfo(root));
            while (!nodes.isEmpty()) {
                NodeInfo nodeInfo = nodes.peek();
                if (nodeInfo.visited) {
                    nodes.pop();
                    if (nodeInfo.node.right != null)
                        nodes.push(new NodeInfo(nodeInfo.node.right));
                } else {
                    // visit the root firstly, then push the left node into stack.
                    result.add(nodeInfo.node.val);
                    nodeInfo.visited = true;
                    if (nodeInfo.node.left != null)
                        nodes.push(new NodeInfo(nodeInfo.node.left));
                }
            }
            return result;
        }

        private class NodeInfo {
            TreeNode node;
            Boolean visited = false;

            NodeInfo(TreeNode node) {
                this.node = node;
            }

            @Override
            public String toString() {
                return "NodeInfo [node=" + node.val + ", visited=" + visited + "]";
            }
        }
    }

    /**
     * Morris Traversal
     * <p/>
     * 时间复杂度为O(n), 空间复杂度为常量，即不占用任何空间，而是利用了叶子节点上的空指针。
     * 本文主要解决一个问题，如何实现二叉树的前中后序遍历，有两个要求：
     *
     * 1. O(1)空间复杂度，即只能使用常数空间；
     * 2. 二叉树的形状不能被破坏（中间过程允许改变其形状）。
     *
     * 通常，实现二叉树的前序（preorder）、中序（inorder）、后序（postorder）遍历有两个常用的方法：一是递归(recursive)，
     * 二是使用栈实现的迭代版本(stack+iterative)。
     * 这两种方法都是O(n)的空间复杂度（递归本身占用stack空间或者用户自定义的stack），所以不满足要求。
     *
     * Morris Traversal方法可以做到这两点，与前两种方法的不同在于该方法只需要O(1)空间，而且同样可以在O(n)时间内完成。
     *
     * 要使用O(1)空间进行遍历，最大的难点在于，遍历到子节点的时候怎样重新返回到父节点（假设节点中没有指向父节点的p指针）。
     * 由于不能用栈作为辅助空间。为了解决这个问题，Morris方法用到了线索二叉树（threaded binary tree）的概念。
     *
     * 在Morris方法中不需要为每个节点额外分配指针指向其前驱（predecessor）和后继节点（successor），
     * 只需要利用叶子节点中的左右空指针指向某种顺序遍历下的前驱节点或后继节点就可以了。
     *
     *
     * <a href = "http://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html">详细的博客</a>
     */
    static class Solution2 extends PreorderTraversal {

        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            TreeNode curNode = root;
            while (curNode != null) {
                if (curNode.left == null) {
                    result.add(curNode.val);
                    curNode = curNode.right;
                } else {
                    TreeNode prevNode = curNode.left;
                    while (prevNode.right != null  && prevNode.right != curNode) {
                        prevNode = prevNode.right;
                    }
                    // curNode is visited for the first time
                    if (prevNode.right == null) {
                        // visit curNode. 'cause this is preorder traversal
                        result.add(curNode.val);
                        prevNode.right = curNode;
                        curNode = curNode.left;
                    } else {
                        // recover the pointer back into null
                        prevNode.right = null;
                        curNode = curNode.right;
                    }
                }
            }
            return result;
        }
    }

}
