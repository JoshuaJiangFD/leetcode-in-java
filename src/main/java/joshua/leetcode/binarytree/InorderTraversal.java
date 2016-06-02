package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class InorderTraversal {

    /**
     * Given a binary tree, return the in-order traversal of its nodes' values.
     * For example:
     * Given binary tree {1,#,2,3},
     * 1
     * \
     * 2
     * /
     * 3
     * return [1,3,2].
     *
     * @param root
     * @return
     */
    public abstract List<Integer> inorderTraversal(TreeNode root);

    /**
     * non-recursive way.
     *
     * @author joy
     */
    static class Solution1 extends InorderTraversal {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null)
                return result;
            Stack<NodeInfo> nodes = new Stack<NodeInfo>();
            nodes.push(new NodeInfo(root, false));
            while (!nodes.isEmpty()) {
                NodeInfo curNode = nodes.peek();
                if (curNode.isVisited) {
                    result.add(curNode.node.val);
                    nodes.pop();
                    if (curNode.node.right != null)
                        nodes.add(new NodeInfo(curNode.node.right, false));
                } else {
                    curNode.isVisited = true;
                    if (curNode.node.left != null)
                        nodes.add(new NodeInfo(curNode.node.left, false));
                }
            }
            return result;
        }

        class NodeInfo {
            TreeNode node;
            Boolean isVisited;

            NodeInfo(TreeNode node, Boolean isVisited) {
                this.node = node;
                this.isVisited = isVisited;
            }
        }
    }

    static class Solution2 extends InorderTraversal {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            traverseSubTree(root, result);
            return result;
        }

        private void traverseSubTree(TreeNode subRoot, List<Integer> result) {
            if (subRoot == null)
                return;
            if (subRoot.left != null)
                traverseSubTree(subRoot.left, result);
            result.add(subRoot.val);
            if (subRoot.right != null)
                traverseSubTree(subRoot.right, result);
        }
    }

    /**
     * Morris Traversal算法。
     *
     * 不占用任何额外空间，空间复杂度为常量。
     *
     */
    static class Solution3 extends InorderTraversal {

        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            TreeNode curNode = root;
            while (curNode != null) {
                // 该节点的左子树为空，说明curNode本身已经是最左下角的元素，中序遍历条件下访问该元素，同时
                // 继续访问该节点的右子树，如果该节点本身没有右子树,它的右子树在这之前已经被标记为中序遍历下的它的后继节点，
                // （见后面的分支），这样就达到了Solution1使用栈同样的效果，就是找到了父节点
                if (curNode.left == null) {
                    result.add(curNode.val);
                    curNode = curNode.right;
                } else {
                    // 开始找curNode在中序遍历下的前驱节点，即leftNode的最右下节点
                    TreeNode prevNode = curNode.left;
                    while (prevNode.right != null && prevNode.right != curNode) {
                        prevNode = prevNode.right;
                    }
                    // 找到了中序下的前驱节点，而且prevNode.right == null 说明是第一次访问curNode,所以将前驱关系标好，
                    // 方便后面回到前驱节点
                    if(prevNode.right == null) {
                        prevNode.right = curNode;
                        curNode = curNode.left;
                    // curNode的前驱节点就是curNode本身，说明之前已经被标记过，说明curNode的整个左子树都遍历完了。
                    // 所以访问自身，同时开始访问右子树。
                    } else {
                        prevNode.right = null;
                        result.add(curNode.val);
                        curNode = curNode.right;
                    }
                }
            }
            return result;
        }
    }
}
