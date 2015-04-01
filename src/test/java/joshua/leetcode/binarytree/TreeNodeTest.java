package joshua.leetcode.binarytree;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class TreeNodeTest {

	
	@Test
	public void testLevelOrderSerialzation() {
		String[] nodes=new String[]{"3","9","20","#","#","15","7"};
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(nodes);
		String[] serialized=TreeNode.SerializeTreeByLevelOrder(root);
		assertArrayEquals(nodes,serialized);
	}

}
