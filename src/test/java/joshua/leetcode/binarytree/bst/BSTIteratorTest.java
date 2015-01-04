package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;

import org.junit.Test;

public class BSTIteratorTest {

	private BSTIterator iterator;
	
	@Test
	public void testSolution() {
		String[] nodes=new String[]{"5","1","6","#","3","#","8",
				"2","#","7","9","#","#","#","#","#","10"};
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(nodes);
		
		iterator=new BSTIterator.Solution(root);
		while(iterator.hasNext())
			System.out.print(iterator.next()+"->");
			
	}

}
