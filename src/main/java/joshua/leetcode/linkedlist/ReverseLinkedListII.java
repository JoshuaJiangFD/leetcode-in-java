package joshua.leetcode.linkedlist;


/**
 * 	92	Reverse Linked List II
 * 
 * @see <a href="https://leetcode.com/problems/reverse-linked-list-ii/">leetcode link</a>
 * @author joy
 *
 */
public abstract class ReverseLinkedListII {

	/**
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

		For example:
		Given  1->2->3->4->5->NULL, m = 2 and n = 4,
		
		return 1->4->3->2->5->NULL.
		
		Note:
		Given m, n satisfy the following condition:
		1 ≤ m ≤ n ≤ length of list.
		
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public abstract ListNode reverseBetween(ListNode head, int m, int n);
	
	
	static class Solution1 extends ReverseLinkedListII{

		@Override
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if(head==null)
				return null;
			ListNode first=null;
			ListNode newHead=head;
			int i=m;
			while(i>1){
				first=(first==null)?head:first.next;
				i--;
			}/*first now points to one element before the starting point to move, in this example is 1.*/
			i=n-m;
			ListNode sentinal=first!=null?first.next:head;
			while(i>0){
				if(first!=null){
					ListNode temp=first.next;
					first.next=sentinal.next;
					sentinal.next=sentinal.next.next;
					first.next.next=temp;					
				}else{
					ListNode temp=newHead;
					newHead=sentinal.next;
					sentinal.next=sentinal.next.next;
					newHead.next=temp;
				}
				i--;
			}
			return newHead;
		}
		
	}
	
}
