package joshua.leetcode.linkedlist.sort;


import joshua.leetcode.linkedlist.ListNode;

import org.junit.Before;
import org.junit.Test;

public class MergeKSortedListsTest {

	ListNode[] lists;
	
	@Before
	public void setUp() throws Exception {
		ListNode head1=ListNode.buildList(new int[]{1,4,8});
		ListNode head2=ListNode.buildList(new int[]{3,6,9});
		ListNode head3=ListNode.buildList(new int[]{5,10,15});
		lists=new ListNode[]{head1,head2,head3};
		lists=new ListNode[]{null};
	}

	@Test
	public void test() {
		MergeKSortedLists sol=new MergeKSortedLists.Solution1();
		ListNode newHead=sol.mergeKLists(lists);
		System.out.println(newHead.printList());
	}

}
