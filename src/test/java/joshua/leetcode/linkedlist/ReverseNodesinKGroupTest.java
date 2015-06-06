package joshua.leetcode.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReverseNodesinKGroupTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		ListNode head=ListNode.buildList(new int[]{1,2,3,4,5});
		ReverseNodesinKGroup sol=new ReverseNodesinKGroup.Solution();
		ListNode newhead=sol.reverseKGroup(head, 3);
		System.out.println(newhead.printList());
		
	}

}
