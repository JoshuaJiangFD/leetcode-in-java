package joshua.leetcode.linkedlist;

/**
 *  206	Reverse Linked List
 *  
 *  <a href="https://leetcode.com/problems/reverse-linked-list/">leetcode link</a>
 * 
 * @author joy
 *
 */
public abstract class ReverseLinkedList {

	 public abstract ListNode reverseList(ListNode head);
	
	 
	 /**
	  * solution1 : recursive way.
	  * 
	  * @author joy
	  *
	  */
	 static class Solution1 extends  ReverseLinkedList{

		@Override
		public ListNode reverseList(ListNode head) {
			return reverse(null,head);
		}

		 /**
		  * remove head from  the left and add to the head of the reversed.
		  * @param reversed list already reversed
		  * @param left  remaining list
		  * @return
		  */
		private ListNode reverse(ListNode reversed, ListNode left){
			if(left==null)
				return reversed;
			ListNode next=left.next;
			left.next=reversed;
			return reverse(left,next);
		}
	 }

}
