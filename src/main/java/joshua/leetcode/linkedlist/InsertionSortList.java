package joshua.leetcode.linkedlist;

public abstract class InsertionSortList {
	/**
	 * Sort a linked list using insertion sort.
	 * @param head
	 * @return
	 */
	public abstract ListNode insertionSortList(ListNode head);
	
	static class Solution extends InsertionSortList{

		@Override
		public ListNode insertionSortList(ListNode head) {
			if(head==null)
				return null;
			ListNode cursor= head.next;
			ListNode lastSorted=head;
			while(cursor!=null){
				ListNode start=head;
				ListNode last=null;
				while(start!=lastSorted.next){
					if(start.val>cursor.val)
						break;
					else
					{
						last=start;
						start=start.next;
					}
				}
				//can't find the position between head and lastSorted, move cursor and lastSorted one step forward.
				if(start==lastSorted.next)
				{
					lastSorted=cursor;
					cursor=cursor.next;
				//cursor is the smallest element, insert before head
				}else if(last==null){
					lastSorted.next=cursor.next;
					cursor.next=head;
					head=cursor;
					cursor=lastSorted.next;
				}else{//insert between last and start.
					lastSorted.next=cursor.next;
					cursor.next=last.next;
					last.next=cursor;
					cursor=lastSorted.next;
				}
			}
			return head;
		}
	}
}
