package joshua.leetcode.binarytree;

import java.util.List;

import org.junit.Test;

public class ZigzagLevelOrderTraversalTest {

	@Test
	public void testSolution1() {
		String[] nodes=new String[]{"3","9","20","#","#","15","7"};
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(nodes);
		
		ZigzagLevelOrderTraversal.Solution solution=new ZigzagLevelOrderTraversal.Solution();
		List<List<Integer>> result=solution.zigzagLevelOrder(root);
		System.out.println(result);
	}

}
