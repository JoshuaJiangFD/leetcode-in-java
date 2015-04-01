package joshua.leetcode.binarytree;

import joshua.leetcode.testutils.TestUtils;

import org.junit.Test;

public class FlattenBinaryTreetoLinkedListTest {

	String[] nodesStr;
	
	@Test
	public void testFlatten() {
		FlattenBinaryTreetoLinkedList sol=new FlattenBinaryTreetoLinkedList.Solution1();
		nodesStr=new String[]{"1","2","5","3","4","#","6"};
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(nodesStr);
		sol.flatten(root);
		String[] flattenStr=TreeNode.SerializeTreeByLevelOrder(root);
		TestUtils.assertArrayEquals(new String[]{"1","#","2","#","3","#","4","#","5","#","6"},
				flattenStr);
	}

}
