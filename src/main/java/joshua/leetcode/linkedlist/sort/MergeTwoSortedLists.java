package joshua.leetcode.linkedlist.sort;

import joshua.leetcode.linkedlist.ListNode;

/**
 * 21 Merge Two Sorted Lists 
 * 
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">leetcode link</a>
 * @author joy
 *
 */
public abstract class MergeTwoSortedLists {

	/**
	 * Merge two sorted linked lists and return it as a new list. 
	 * 
	 * The new list should be made by splicing together the nodes of the first two lists.
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public abstract ListNode mergeTwoLists(ListNode l1, ListNode l2);
	
	static class Solution1 extends MergeTwoSortedLists{

		@Override
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode head1=l1,head2=l2;
			ListNode newHead=null, prev=null;
			while(head1!=null && head2!=null){
				ListNode smaller=head1.val<head2.val?head1:head2;
				if(prev==null){
					prev=newHead=smaller;
				}else{
					prev.next=smaller;
					prev=prev.next;
				}
				if(head1.val<head2.val)
					head1=head1.next;
				else 
					head2=head2.next;
			}
			if(head1==null & head2==null)
				return newHead;
			ListNode remains=head1==null?head2:head1;
			if(newHead==null)
				return remains;
			else
				prev.next=remains;
			return newHead;
		}
		
	}
}
