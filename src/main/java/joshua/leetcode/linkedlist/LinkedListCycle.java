package joshua.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public abstract class LinkedListCycle {

	/**
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * @param head
	 * @return
	 */
	public abstract boolean hasCycle(ListNode head);
	
	/**
	 * the easiest way.
	 * start from every element, and traverse the list from the starting node to the end.
	 * if any element on the sub list has the same value with the starting node, then there is a cycle.
	 * @author Joshua.Jiang
	 *
	 */
	static class Solution1 extends LinkedListCycle{

		@Override
		public boolean hasCycle(ListNode head) {
			ListNode startNode=head;
			while(startNode!=null)
			{
				ListNode compareNode=startNode.next;
				while(compareNode != null){
					if(compareNode.next==startNode)
						return true;
					compareNode=compareNode.next;
				}
			}
			return false;
		}
		
	}
	
	/**
	 * use hash code. but with time complexity: o(n): n is the length of the list
	 * 
	 * @author Joshua.Jiang
	 *
	 */
	static class Solution2 extends LinkedListCycle{

		@Override
		public boolean hasCycle(ListNode head) {
			List<Integer> hashCodes=new ArrayList<Integer>();
			ListNode curNode=head;
			while(curNode!=null){
				int code=curNode.hashCode();
				if(hashCodes.contains(code))
					return true;
				hashCodes.add(code);
				curNode=curNode.next;
			}
			return false;
		}
	}
	
	/**
	 * two pointers way, one pointer runs faster then another one.(faster one move two steps a time, slower one moves one step a time.)
	 * If there is a cycle, two pointers will meet.
	 * If the faster one meet the end of the list, then stop and return false.
	 * 
	 * @author Joshua.Jiang
	 *
	 */
	static class Solution3 extends LinkedListCycle{

		@Override
		public boolean hasCycle(ListNode head) {
			if(head==null)
				return false;
			ListNode p1=head.next,p2=head;
			while(p1!=null){
				if(p1.val==p2.val)
					return true;
				else{
					if(p1.next==null)
						return false;
					p1=p1.next.next;
					p2=p2.next;
				}
			}
			return false;
		}
		
	}
}
