package joshua.leetcode.linkedlist.randomlist;

import java.util.HashMap;

public abstract class CopyRandomList {

	/**
	 * Return a deep copy of the list.
	 * 
	 * @param head
	 * @return
	 */
	public abstract RandomListNode copyRandomList(RandomListNode head);
	
	static class Solution extends CopyRandomList{

		@Override
		public RandomListNode copyRandomList(RandomListNode head) {
			if(head==null)
				return null;
			RandomListNode copiedHead=new RandomListNode(head.label);
			HashMap<Integer,RandomListNode> map=new HashMap<Integer,RandomListNode>();
			map.put(head.hashCode(), copiedHead);
			RandomListNode cur=head.next;
			RandomListNode curCopiedNode=copiedHead;
			//copy nodes and next info
			while(cur!=null){
				RandomListNode newCopiedNode=new RandomListNode(cur.label);
				curCopiedNode.next=newCopiedNode;
				curCopiedNode=newCopiedNode;
				map.put(cur.hashCode(), newCopiedNode);
				cur=cur.next;
			}
			//copy randomNode 
			cur=head;
			curCopiedNode=copiedHead;
			while(cur!=null){
				if(cur.random!=null)
				{
					RandomListNode ran=cur.random;
					curCopiedNode.random=map.get(ran.hashCode());
				}
				cur=cur.next;
				curCopiedNode=curCopiedNode.next;
			}
			return copiedHead;
		}
	}
}
