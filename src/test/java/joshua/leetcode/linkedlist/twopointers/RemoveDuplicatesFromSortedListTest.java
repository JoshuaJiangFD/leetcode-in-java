package joshua.leetcode.linkedlist.twopointers;

import static org.junit.Assert.*;
import joshua.leetcode.linkedlist.ListNode;

import org.junit.Test;

public class RemoveDuplicatesFromSortedListTest {

	private RemoveDuplicatesFromSortedList solution=new RemoveDuplicatesFromSortedList.Solution();
	
	@Test
	public void testDeleteDuplicates() {
		ListNode head=ListNode.buildList(new int[]{0,1,1,2,2,3,3,3,4});
		solution.deleteDuplicates(head);
		System.out.println(head.printList());
	}

	@Test
	public void testDeleteDuplicates2() {
		ListNode head=ListNode.buildList(new int[]{0,1,1,2,2,3,3,3,4});
		ListNode newHead=solution.deleteDuplicates2(head);
		System.out.println(newHead.printList());
		
		ListNode head2=ListNode.buildList(new int[]{1,2,3});
		ListNode newHead2=solution.deleteDuplicates2(head2);
		System.out.println(newHead2.printList());
		
		ListNode head3=ListNode.buildList(new int[]{1,2,3,3});
		ListNode newHead3=solution.deleteDuplicates2(head3);
		System.out.println(newHead3.printList());
	}

}
