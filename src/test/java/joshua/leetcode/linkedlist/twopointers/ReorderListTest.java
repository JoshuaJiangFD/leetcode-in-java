package joshua.leetcode.linkedlist.twopointers;

import static org.junit.Assert.*;
import joshua.leetcode.linkedlist.ListNode;

import org.junit.Before;
import org.junit.Test;

public class ReorderListTest {


	@Test
	public void testSolution1() {
		ReorderList sol=new ReorderList.Solution1();
		ListNode head=ListNode.buildList(new int[]{1,2});
		sol.reorderList(head);
		System.out.println(head.printList());
	}

	
	@Test
	public void testSoluion2(){
		ReorderList sol=new ReorderList.Solution2();
		ListNode head=ListNode.buildList(new int[]{1});
		sol.reorderList(head);
		System.out.println(head.printList());
	}
}


