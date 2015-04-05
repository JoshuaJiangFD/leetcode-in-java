package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;
import joshua.leetcode.linkedlist.ListNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author joy
 *
 */
public abstract class ListToBST {
	
	public abstract TreeNode sortedListToBST(ListNode head);
	
	/**
	 * Similar way to ArrayToBST algorithm.
	 * The tricky part is how to evenly split the linked list and find the location of the root quickly:
	 * a) for linked list with length n, set pointer1 as the head of the list, pointer2 as the second element;
	 * b) every time pointer1 moves one step forward, pointer2 moves two steps forward;
	 * c) iterates until pointer2 can't move two steps forward anymore(either reaches the end or the last but one element.);
	 * d) then pointer1's next element is chosen as the root to keep two sides balanced(with subsection of sizes less than 1.) 
	 * 
	 * @author joy
	 *
	 */
	static class Solution1 extends ListToBST{

		@Override
		public TreeNode sortedListToBST(ListNode head) {
			if(head==null)
				return null;
			if(head.next==null)
				return new TreeNode(head.val);
			ListNode p1=head,p2=head.next;
			while(p2.next!=null && p2.next.next!=null){
				p1=p1.next;
				p2=p2.next.next;
			}
			TreeNode root=new TreeNode(p1.next.val);
			p2=p1.next.next;
			p1.next=null;
			root.left=sortedListToBST(head);
			root.right=sortedListToBST(p2);
			return root;
		}		
	}
}
