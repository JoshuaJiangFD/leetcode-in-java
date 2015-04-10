package joshua.leetcode.linkedlist;

import org.junit.Before;
import org.junit.Test;

public class SwapNodesinPairsTest {

	ListNode root;
	
	@Before
	public void test(){
		root=ListNode.buildList(new int[]{1,2,3,4});
	}
	
	@Test
	public void testSolution1() {
		SwapNodesinPairs sol=new SwapNodesinPairs.Solution();
		ListNode newHead=sol.swapPairs(root);
		System.out.println(newHead.outPutList());
	}

}
