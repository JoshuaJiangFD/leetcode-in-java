package joshua.leetcode.linkedlist.twopointers;

import joshua.leetcode.linkedlist.ListNode;

/**
 * 143	Reorder List
 * 
 * @see <a href="https://leetcode.com/problems/reorder-list/">leetcode link</a>
 * @author joy
 *
 */
public abstract class ReorderList {

	
	/**
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
						
	   You must do this in-place without altering the nodes' values.
	   For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	   
	 * @param head
	 */
	 public abstract void reorderList(ListNode head);
	 

	 static class Solution1 extends ReorderList{

		@Override
		public void reorderList(ListNode head) {
			if(head==null||head.next==null)
				return;
			ListNode mid=head,cur=head;
			while(cur.next!=null&&cur.next.next!=null){
				cur=cur.next.next;
				mid=mid.next;
			}
			if(mid==head)
			{
				return;
			}
			cur=mid;
			int size=0;/*start as the length after mid.*/
			while(cur.next!=null){
				cur=cur.next;size++;
			}
			cur=head;
			ListNode startNode=mid;
			while(size>0){
				ListNode p=cur,s=startNode;
				startNode=cur;/*next start to move from*/
				cur=cur.next;/*next start to move to*/
				for(int i=0;i<size;i++){/*move n nodes starting from startNode after p.*/
					ListNode oldNext=p.next;
					p.next=s.next;
					s.next=s.next.next;
					p.next.next=oldNext;
					p=p.next;
				}
				size--;
			}
		}
	 }
	 
	 
	 static class Solution2 extends ReorderList{

		@Override
		public void reorderList(ListNode head) {
			if(head==null||head.next==null)
				return;
			ListNode mid=head,cur=head;
			while(cur.next!=null&&cur.next.next!=null){
				cur=cur.next.next;
				mid=mid.next;
			}
			cur=mid.next;
			mid.next=null;/*split list into two part, (head,mid) and (cur,end)*/
			/*reverse second sub list*/
			ListNode after=cur;
			while(after.next!=null){
				ListNode node=after.next;
				after.next=node.next;
				node.next=cur;
				cur=node;
			}
			/*intersperse the original first part and the reserved second part*/
			ListNode first=head;
			while(cur!=null){
				ListNode second=cur.next;
				ListNode nextFirst=first.next;
				first.next=cur;
				cur.next=nextFirst;
				first=nextFirst;
				cur=second;
			}
		}
		 
	 }
}
