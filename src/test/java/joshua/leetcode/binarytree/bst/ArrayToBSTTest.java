package joshua.leetcode.binarytree.bst;

import static org.junit.Assert.*;
import joshua.leetcode.binarytree.TreeNode;

import org.junit.Test;

public class ArrayToBSTTest {

	private ArrayToBST sol=new ArrayToBST.Solution1();
	
	@Test
	public void testSortedArrayToBST() {
//		TreeNode tree=sol.sortedArrayToBST(new int[]{1,2,3,4});
//		assertEquals(2,tree.val);
//		tree=sol.sortedArrayToBST(new int[]{1,3});
		TreeNode tree2=sol.sortedArrayToBST(new int[]{0,1,2,3,4,5});
	}

}
