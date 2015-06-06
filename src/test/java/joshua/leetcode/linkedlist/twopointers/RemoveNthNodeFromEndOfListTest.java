package joshua.leetcode.linkedlist.twopointers;

import static org.junit.Assert.*;
import joshua.leetcode.linkedlist.ListNode;

import org.junit.Before;
import org.junit.Test;

public class RemoveNthNodeFromEndOfListTest {

	ListNode head;

	RemoveNthNodeFromEndOfList sol;

	@Before
	public void setUp(){
		head=ListNode.buildList(new int[]{1,2,3});
		sol=new RemoveNthNodeFromEndOfList.Solution1();
	}
	
	@Test
	public void testRemoveNthFromEnd_1() {
		assertEquals("2-->3",sol.removeNthFromEnd(head, 3).outPutList());
	}

	@Test
	public void testRemoveNthFromEnd_2(){
		assertEquals("1-->3",sol.removeNthFromEnd(head, 2).outPutList());
	}
	
	@Test
	public void testRemoveNthFromEnd_3(){
		assertEquals("1-->2",sol.removeNthFromEnd(head, 1).outPutList());
	}
}
