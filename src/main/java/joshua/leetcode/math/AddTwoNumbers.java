package joshua.leetcode.math;

import joshua.leetcode.linkedlist.ListNode;

/**
 * 2	Add Two Numbers
 * 
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">leetcode link</a>
 * 
 * @author joy
 *
 */
public abstract class AddTwoNumbers {
	
	/**
	 * You are given two linked lists representing two non-negative numbers. 
	 * 
	 * The digits are stored in reverse order and each of their nodes contain a single digit.
	 * 
	 * Add the two numbers and return it as a linked list.

		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 0 -> 8
		
	 * @param l1
	 * @param l2
	 * @return
	 */
	public abstract ListNode addTwoNumbers(ListNode l1, ListNode l2); 
	
	static class Solution1 extends AddTwoNumbers{

		/**
		 * recursive way.
		 * calculate every digit and pass the left lists and carrying to recursive functions. 
		 * recursive method will return node of  higher digit's result and concatenated to the low digit node.  
		 */
		@Override
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			return recursiveAdd(l1,l2,0);
		}
		
		private ListNode recursiveAdd(ListNode l1, ListNode l2, int carrying){
			if(l1==null && l2==null)
				return carrying==0?null:new ListNode(carrying);
			int val1=l1==null?0:l1.val;
			int val2=l2==null?0:l2.val;
			int val=(val2+val1+carrying)%10;
			carrying=(val2+val1+carrying)/10;
			ListNode curNode=new ListNode(val);
			ListNode next=recursiveAdd(l1==null?null:l1.next,l2==null?null:l2.next,carrying);
			curNode.next=next;
			return curNode;
			
		}
		
		
	}
}
