package joshua.leetcode.linkedlist.twopointers;

import joshua.leetcode.linkedlist.ListNode;

/**
 * 19. Remove Nth Node From End of List 
 * @author joy
 *
 */
public abstract class RemoveNthNodeFromEndOfList {

	/**
	 * Given a linked list, remove the nth node from the end of list and return its head.

		For example,
		   Given linked list: 1->2->3->4->5, and n = 2.
		   After removing the second node from the end, the linked list becomes 1->2->3->5.
	
	 * Note:
		Given n will always be valid.
		Try to do this in one pass
		
	 * @param head
	 * @param n
	 * @return
	 */
	public abstract ListNode removeNthFromEnd(ListNode head, int n);

	/* Two pointers, move the end pointer n steps rightward, then move two pointers together
	 * the head one will be at last n element when the first one meets the end.
	 * the Key is here is sanity check, to cover all cases.
	 */
	static class Solution1 extends RemoveNthNodeFromEndOfList{

		@Override
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if(head==null)
				return null;
			ListNode aHeadLeft=null,left=head,right=head;
			int i=1;
			while(i!=n){right=right.next;i++;}
			while(right.next!=null){
				right=right.next;
				aHeadLeft=left;
				left=left.next;
			}
			if(aHeadLeft==null){
				return left.next;
			}
			else{
				aHeadLeft.next=left.next;
				return head;
			}
		}
	}
}
