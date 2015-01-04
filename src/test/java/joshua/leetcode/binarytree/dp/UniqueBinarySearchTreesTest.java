package joshua.leetcode.binarytree.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueBinarySearchTreesTest {

	@Test
	public void testSolution1() {
		UniqueBinarySearchTrees.Solution1 sol = new UniqueBinarySearchTrees.Solution1();
		
		//assertEquals(5,sol.numTrees(3));
		assertEquals(14,sol.numTrees(4));

	}

}
