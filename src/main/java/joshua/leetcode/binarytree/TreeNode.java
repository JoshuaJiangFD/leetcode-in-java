package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	
	@Override
	public String toString() {
		return "TreeNode [val=" + val + "]";
	}

	/**
		OJ's Binary Tree Serialization:
		The serialization of a binary tree follows a level order traversal, 
		where '#' signifies a path terminator where no node exists below.
			Here's an example:
			   1
			  / \
			 2   3
			    /
			   4
			    \
			     5
		The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
	 * @param s
	 * @return
	 */
	public static TreeNode DeserializeTreeByLevelOrder(String[] nodesStr) {
		if (nodesStr == null || nodesStr.length==0)
			return null;
		Queue<TreeNode> nodesInLevel = new LinkedList<TreeNode>();
		TreeNode root = new TreeNode(Integer.parseInt(nodesStr[0]));
		int nextIdx = 1;
		int length = nodesStr.length;
		nodesInLevel.add(root);
		while (!nodesInLevel.isEmpty() && nextIdx < length) {
			TreeNode cur = nodesInLevel.poll();
			if (nextIdx < length) {
				String ch = nodesStr[nextIdx++];
				if (ch != "#") {
					cur.left = new TreeNode(Integer.parseInt(ch));
					nodesInLevel.add(cur.left);
				}
			}
			if (nextIdx < length) {
				String ch = nodesStr[nextIdx++];
				if (ch != "#") {
					cur.right = new TreeNode(Integer.parseInt(ch));
					nodesInLevel.add(cur.right);
				}
			}
		}
		return root;
	}

	public static String[] SerializeTreeByLevelOrder(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> nodesInLevel = new LinkedList<TreeNode>();
		TreeNode fakeNode = new TreeNode(Integer.MIN_VALUE);
		nodesInLevel.add(root);
		List<String> sBuilder = new ArrayList<String>();
		while (!nodesInLevel.isEmpty()) {
			TreeNode curNode = nodesInLevel.poll();
			if (curNode == fakeNode) {
				sBuilder.add("#");
				continue;
			}
			sBuilder.add(String.valueOf(curNode.val));
			nodesInLevel.add(curNode.left != null ? curNode.left : fakeNode);
			nodesInLevel.add(curNode.right != null ? curNode.right : fakeNode);
		}
		/**
		 * remove the last two "#"s.
		 */
		int end=sBuilder.size()-1;
		while(sBuilder.get(end)=="#"){end--;};
		return sBuilder.subList(0,end+1).toArray(new String[0]);
	}
}
