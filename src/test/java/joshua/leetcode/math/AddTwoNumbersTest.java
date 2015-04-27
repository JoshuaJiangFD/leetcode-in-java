package joshua.leetcode.math;

import static org.junit.Assert.*;
import joshua.leetcode.linkedlist.ListNode;

import org.junit.Test;

public class AddTwoNumbersTest {

	@Test
	public void testSolution1() {
		ListNode h1=ListNode.buildList(new int[]{2,4,3});
		ListNode h2=ListNode.buildList(new int[]{5,6,4});
		AddTwoNumbers sol=new AddTwoNumbers.Solution1();
		ListNode result=sol.addTwoNumbers(h1, h2);
		System.out.println(result.outPutList());
	}

}
