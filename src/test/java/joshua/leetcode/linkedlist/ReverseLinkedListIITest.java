package joshua.leetcode.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReverseLinkedListIITest {


	@Test
	public void testSolution1() {
		ReverseLinkedListII sol=new ReverseLinkedListII.Solution1();
		ListNode head=ListNode.buildList(new int[]{1,2,3,4,5});
		ListNode res=sol.reverseBetween(head, 1, 4);
		System.out.println(res.printList());
		
	}

}
