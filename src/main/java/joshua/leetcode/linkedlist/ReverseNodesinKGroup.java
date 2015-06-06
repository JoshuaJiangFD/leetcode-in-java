package joshua.leetcode.linkedlist;

/**
 * 25	Reverse Nodes in k-Group
 * 
 * @see <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">leetcode link</a>
 * @author joy
 *
 */
public abstract class ReverseNodesinKGroup {

	/**
	 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

		1) If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
		2) You may not alter the values in the nodes, only nodes itself may be changed.
		3) Only constant memory is allowed.
		
		For example,
		Given this linked list: 1->2->3->4->5
		For k = 2, you should return: 2->1->4->3->5
		For k = 3, you should return: 3->2->1->4->5
		
		
	 * @param head
	 * @param k
	 * @return
	 */
	public abstract ListNode reverseKGroup(ListNode head, int k);

	static class Solution extends ReverseNodesinKGroup {

		@Override
		public ListNode reverseKGroup(ListNode head, int k) {
			if(head==null)
				return null;
			ListNode prev = null;
			ListNode cur = head;
			ListNode newHead=head;
			while (cur != null) {
				int i = 1;
				ListNode kEnd=cur;
				while (i < k) {
					if (kEnd == null)
						break;
					kEnd = kEnd.next;
					i++;
				}
				if(kEnd==null)/*then left-out nodes in the end is less than k*/
					break;
				while(i>1){
					if(prev==null){/*if prev is null, every time insert element next to cur as new head.*/
						ListNode n=cur.next;
						cur.next=n.next;
						n.next=newHead;
						newHead=n;
					}else{/*every time insert cur's next after prev, repeat k-1 times to reverse.*/
						ListNode n=cur.next;
						cur.next=n.next;
						n.next=prev.next;
						prev.next=n;				
					}
					i--;
				}
				prev=cur;
				cur=cur.next;
			}
			return newHead;
		}
	}
}
