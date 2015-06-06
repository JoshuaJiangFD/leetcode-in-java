package joshua.leetcode.linkedlist.sort;

import joshua.leetcode.linkedlist.ListNode;

/**
 * 148	Sort List
 * 
 * @see <a href="https://leetcode.com/problems/sort-list/">leetcode link</a>
 * @author joy
 *
 */
public abstract class SortList {

	/**
	 * 
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * 
	 * @param head
	 * @return
	 */
	 public abstract ListNode sortList(ListNode head);
	 
	 /**
	  * the most direct clue from O(n log n) time complexity is to use merge sort.
	  * 
	  * @author joy
	  *
	  */
	 static class Solution1 extends SortList{

		@Override
		public ListNode sortList(ListNode head) {
			if(head==null||head.next==null)
				return head;
			ListNode first=head,second=head.next;
			while(second.next!=null && second.next.next!=null){
				first=first.next;
				second=second.next.next;
			}
			if(second.next!=null) second=second.next;
			/*(head,first) and (first+1,end) are now two equal length parts*/
			second=first.next;
			first.next=null;/*cut it down into two parts.*/
			ListNode head1=sortList(head);
			ListNode head2=sortList(second);
			return merge(head1,head2);
		}
		
		/**
		 * merge two sorted list into one list
		 * @param head1
		 * @param head2
		 * @return
		 */
		private ListNode merge(ListNode head1,ListNode head2){
			ListNode newHead=null,newNext=null;
			while(head1!=null&&head2!=null){
				ListNode smaller=head1.val<head2.val?head1:head2;
				if(newNext==null){
					newHead=smaller;
					newNext=newHead;
				}
				else{
					newNext.next=smaller;
					newNext=smaller;
				}	
				if(head1.val<head2.val) head1=head1.next;
				else
					head2=head2.next;
			}
			if(head1!=null)
				newNext.next=head1;
			else if(head2!=null)
				newNext.next=head2;
			return newHead;
		}
	 } 
}
