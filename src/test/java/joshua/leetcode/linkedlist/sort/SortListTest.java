package joshua.leetcode.linkedlist.sort;

import joshua.leetcode.linkedlist.ListNode;

import org.junit.Before;
import org.junit.Test;

public class SortListTest {

	ListNode head;
	
	@Before
	public void setUp() throws Exception {
		head=ListNode.buildList(new int[]{3,2,7,6,1,8});
	}

	@Test
	public void test_Solution1() {
		SortList sol=new SortList.Solution1();
		ListNode newHead=sol.sortList(head);
		System.out.println(newHead.printList());	
	}

}
