package joshua.leetcode.linkedlist.twopointers;

import joshua.leetcode.linkedlist.ListNode;

/**
 * Partition List 
 * 
 * @see <a href="https://leetcode.com/problems/partition-list/">leetcode link</a>
 * @author joy
 *
 */
public abstract class PartitionList {

	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

	   You should preserve the original relative order of the nodes in each of the two partitions.
		
		For example,
		Given 1->4->3->2->5->2 and x = 3,
		return 1->2->2->4->3->5.
		
		
	 * @param head
	 * @param x
	 * @return
	 */
	public abstract ListNode partition(ListNode head, int x);
	
	static class Solution1 extends PartitionList{

		@Override
		public ListNode partition(ListNode head, int x) {
			if(head==null||head.next==null)
				return head;
			ListNode first=null,second=null,cursor=head,newHead=head,firstSecond;	
			while(cursor!=null){
				if(cursor.val<x) {
					first=cursor;
					cursor=cursor.next;
				}else
					break;
			}
			if(cursor==null) return head;
			firstSecond=second=cursor;cursor=cursor.next;
			while(cursor!=null){
				if(cursor.val<x){
					second.next=cursor.next;
					if(first==null)
					{
						newHead=cursor;
						cursor.next=firstSecond;
						first=cursor;
					}else{
						cursor.next=first.next;
						first.next=cursor;
						first=first.next;
					}
					cursor=second.next;
				}
				else{
					second=cursor;
					cursor=cursor.next;
				}
			}
			return newHead;
		}
	}
}
