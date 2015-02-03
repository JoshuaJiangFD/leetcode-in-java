package joshua.leetcode.linkedlist.twopointers;

import joshua.leetcode.linkedlist.ListNode;

/**
 * @see <a  href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates from Sorted List</a>
 * @see <a href="https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/">Remove Duplicates from Sorted List II </a>
 * 
 * @author joy
 *
 */
public abstract class RemoveDuplicatesFromSortedList {

	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.

		For example,
		Given 1->1->2, return 1->2.
		Given 1->1->2->3->3, return 1->2->3.
		
	 * @param head
	 * @return
	 */
	public abstract ListNode deleteDuplicates(ListNode head);

	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
	 * leaving only distinct numbers from the original list.

		For example,
		Given 1->2->3->3->4->4->5, return 1->2->5.
		Given 1->1->1->2->3, return 2->3.
	 * @param head
	 * @return
	 */
	public abstract ListNode deleteDuplicates2(ListNode head);

	static class Solution extends RemoveDuplicatesFromSortedList {

		@Override
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode p1 = head, p2 = head.next;
			while (p2 != null) {
				if (p2.val == p1.val)
					p2 = p2.next;
				else {
					p1.next = p2;
					p1 = p2;
					p2 = p2.next;
				}
			}
			p1.next = null;
			return head;
		}

		@Override
		public ListNode deleteDuplicates2(ListNode head) {
			if (head == null)
				return head;
			ListNode newHead = null, pre = null;
			ListNode p1 = head, p2 = head.next;
			while (p2 != null) {
				if (p2.val == p1.val)
					p2 = p2.next;
				else {
					if (p1.next == p2) {
						pre = p1;
						if (newHead == null)
							newHead = pre;
					} else {
						if (pre != null)
							pre.next = p2;
					}
					p1 = p2;
					p2 = p2.next;
				}
			}
			if (p1 != null) {
				if (p1.next != null) {
					if (pre != null)
						pre.next = null;
				} else {
					if (pre == null) {
						pre = p1;
						if (newHead == null)
							newHead = pre;
					}
				}
			}
			return newHead;
		}

	}
}
