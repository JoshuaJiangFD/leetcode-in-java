

package joshua.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree<br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public abstract String serialize(TreeNode root);

    // Decodes your encoded data to tree.
    public abstract TreeNode deserialize(String data);

    /**
     * 类似pre-order traversal算法。
     *
     * 空子节点以"*"标识，有值的子节点存值，所有的节点以","隔开。
     *
     */
    public static class Solution1 extends SerializeDeserializeBinaryTree {

        private static final String NULL = "#";

        private static final String SPILITER = ",";

        @Override
        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            buildString(stringBuilder, root);
            return stringBuilder.toString();
        }

        private void buildString(StringBuilder stringBuilder, TreeNode node) {
            if(node == null) {
                stringBuilder.append(NULL);
                return;
            }
            stringBuilder.append(node.val).append(SPILITER);
            buildString(stringBuilder, node.left);
            stringBuilder.append(SPILITER);
            buildString(stringBuilder, node.right);
        }

        @Override
        public TreeNode deserialize(String data) {
            if(data == null || data.isEmpty()) {
                return null;
            }
            String[] nodeStrs = data.split(SPILITER);
            Queue<String> strQueue = new ArrayDeque<String>();
            for(String nodeStr : nodeStrs) {
                strQueue.offer(nodeStr);
            }
            return buildTree(strQueue);
        }

        private TreeNode buildTree(Queue<String> queue) {
            if (queue.isEmpty()) {
                return null;
            }
            String polled = queue.poll();
            if (polled.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(polled));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }
}
