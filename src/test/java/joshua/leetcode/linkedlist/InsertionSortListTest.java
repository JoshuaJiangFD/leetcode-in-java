package joshua.leetcode.linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortListTest {

	private ListNode head;
	
	@Before
	public void setUp() throws Exception {
		head=new ListNode(4);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(1);
	}

	@Test
	public void testSolution1() {
		InsertionSortList solution=new InsertionSortList.Solution();
		ListNode head=solution.insertionSortList(this.head);
		System.out.println(head.outPutList());
	}

}
