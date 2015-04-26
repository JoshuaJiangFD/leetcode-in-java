package joshua.leetcode.linkedlist.sort;

import java.util.ArrayList;
import java.util.List;

import joshua.leetcode.linkedlist.ListNode;

/**
 * 23.  Merge k Sorted Lists
 * 
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">leetcode link</a>
 * @author joy
 *
 */
public abstract class MergeKSortedLists {

	/**
	 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
	 * 
	 * @param lists
	 * @return
	 */
	public abstract ListNode mergeKLists(ListNode[] lists);

	/**
	 * use heap sorting. maintain a k-size Minimum Heap.
	 * every time, pop the root node and insert root node's next element to the heap and adjust the heap shape.
	 * if root's next is null, choose the last element(the last leaf node) and make it as the root and adjust the heap.
	 * continue, until heap size becomes 1.
	 * then link the new merged list with root(implicitly link to root's next node.)
	 * 
	 * @author joy
	 *
	 */
	static class Solution1 extends MergeKSortedLists {

		@Override
		public ListNode mergeKLists(ListNode[] lists) {
			ListNode newHead = null, prev = null;
			if (lists == null || lists.length == 0)
				return null;
			List<ListNode> heapLst = new ArrayList<ListNode>();
			for (int i = 0; i < lists.length; i++)
				if (lists[i] != null)
					heapLst.add(lists[i]);/*if there is a null in the lists, ignore it*/
			int size = heapLst.size();
			initializeHeap(heapLst);
			while (size > 1) {
				/*1. link the top of heap*/
				if (prev == null) {
					newHead = heapLst.get(0);
					prev = newHead;
				} else {
					prev.next = heapLst.get(0);
					prev = prev.next;
				}
				/*2. find next element to insert to heap*/
				if (prev.next == null) {/*case 1, find the last leaf element, and set as the root*/
					heapLst.set(0, heapLst.get(size - 1));
					size--;
				} else {/*case 2: get the last root's next node as the root*/
					heapLst.set(0, prev.next);
				}
				adjustEle(heapLst, 0, size);/*adjust the heap*/
			}
			if (size == 1) {
				if (prev == null) {
					newHead = heapLst.get(0);
				} else
					prev.next = heapLst.get(0);/*now the heap size is 1, so link the prev with the last remaining list*/
			}
			return newHead;
		}

		/**
		 * initialize the heap.
		 * from the first non-leaf element to the root element, for each element do down-side adjustment.
		 * 
		 * @param heapLst
		 */
		private void initializeHeap(List<ListNode> heapLst) {
			int size = heapLst.size();
			int eleIdx = (size - 1) - 1 / 2;/*start as the first non-leaf element's idx*/
			while (eleIdx > -1) {
				adjustEle(heapLst, eleIdx, size);
				eleIdx--;
			}
		}

		/**
		 * adjust element at <code>eleIdx</code>, down to it's kids and swap with the smallest kid.
		 * until it meets the end of the heap.
		 *  
		 * @param heap
		 * @param eleIdx
		 * @param size
		 */
		private void adjustEle(List<ListNode> heap, int eleIdx, int size) {
			ListNode cur = heap.get(eleIdx);
			int leftKid = eleIdx * 2 + 1, rightKid = eleIdx * 2 + 2;
			while (leftKid < size || rightKid < size) {
				int minIdx = eleIdx;
				if (leftKid < size
						&& heap.get(minIdx).val > heap.get(leftKid).val)
					minIdx = leftKid;
				if (rightKid < size
						&& heap.get(minIdx).val > heap.get(rightKid).val)
					minIdx = rightKid;
				if (minIdx == eleIdx)/*eleIdx is now the biggest amongst its kids*/
					break;
				heap.set(eleIdx, heap.get(minIdx));
				heap.set(minIdx, cur);
				eleIdx = minIdx;
				leftKid = eleIdx * 2 + 1;
				rightKid = eleIdx * 2 + 2;
			}
		}

	}
}
