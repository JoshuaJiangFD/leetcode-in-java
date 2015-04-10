package joshua.leetcode.linkedlist;

/**
 * 24	Swap Nodes in Pairs
 * 
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/">leetcode link</a>
 * @author joy
 *
 */
public abstract class SwapNodesinPairs {

	/**
	 * Given a linked list, swap every two adjacent nodes and return its head.

	   For example,
	   Given 1->2->3->4, you should return the list as 2->1->4->3.

	   Your algorithm should use only constant space.
	   You may not modify the values in the list, only nodes itself can be changed.
	   
	 * @param head
	 * @return
	 */
	public abstract ListNode swapPairs(ListNode head);

	static class Solution extends SwapNodesinPairs {

		@Override
		public ListNode swapPairs(ListNode head) {
			if(head==null||head.next==null)
				return head;
			ListNode node1 = head, node2 = head.next;
			ListNode curHead=null,newHead=null;
			do {
				if(newHead==null)
				{
					curHead=node2;
					newHead=curHead;
				}else{
					curHead.next=node2;
				}
				node1.next=node2.next;
				node2.next=node1;
				curHead=node1;
				node1=node1.next;
				if(node1!=null)
					node2=node1.next;
			} while (node1 != null && node2 != null);
			return newHead;
		}
	}
}
