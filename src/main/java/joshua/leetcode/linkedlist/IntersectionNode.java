package joshua.leetcode.linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * @author Joshua.Jiang
 *
 */
public abstract class IntersectionNode {

	/**
	 *  * Write a program to find the node at which the intersection of two singly linked lists begins.

		For example, the following two linked lists:
		
		A:          a1 → a2
	                   		↘
		                     c1 → c2 → c3
	                   		↗            
		B:     b1 → b2 → b3
		begin to intersect at node c1.
		
		
		Notes:
		
		If the two linked lists have no intersection at all, return null.
		The linked lists must retain their original structure after the function returns.
		You may assume there are no cycles anywhere in the entire linked structure.
		Your code should preferably run in O(n) time and use only O(1) memory.
	 * @param headA
	 * @param headB
	 * @return
	 */
	public abstract ListNode getIntersectionNode(ListNode headA, ListNode headB);
	
	
	static class Solution1 extends IntersectionNode {

		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			int leng1 = 0;
			int leng2 = 0;
			ListNode head = headA;
			while (head != null) {
				leng1++;
				head = head.next;
			}
			head = headB;
			while (head != null) {
				leng2++;
				head = head.next;
			}
			int subLen = Math.abs(leng1 - leng2);
			ListNode head2;
			if (leng1 >= leng2) {
				head = headA;
				head2 = headB;
			} else {
				head = headB;
				head2 = headA;
			}
			while (subLen > 0) {
				head = head.next;
				subLen--;
			}
			while(head!=null && head2!=null){
				if(head.val== head2.val){
					return head;
				}
				head=head.next;
				head2=head2.next;
			}
			return null;
		}
	}
}
