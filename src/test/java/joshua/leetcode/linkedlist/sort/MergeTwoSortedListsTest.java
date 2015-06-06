package joshua.leetcode.linkedlist.sort;

import joshua.leetcode.linkedlist.ListNode;

import org.junit.Test;

public class MergeTwoSortedListsTest {

	@Test
	public void testSolution1() {
		ListNode head1=ListNode.buildList(new int[]{1,3,5});
		ListNode head2=ListNode.buildList(new int[]{2,6,9});
		
		MergeTwoSortedLists sol=new MergeTwoSortedLists.Solution1();
		ListNode newhead=sol.mergeTwoLists(head1, head2);
		System.out.println(newhead.printList());
	}

}
