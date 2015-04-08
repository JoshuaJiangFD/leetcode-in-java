package joshua.leetcode.linkedlist.randomlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class CopyRandomListTest {

	@Test
	public void testCopyRandomList() {
		CopyRandomList sol=new CopyRandomList.Solution();
		RandomListNode root=new RandomListNode(1);
//		root.next=new RandomListNode(2);
//		root.next.next=new RandomListNode(3);
//		root.random=root.next.next;
//		root.next.random=root;
//		root.next.next.random=root.next;
		
		System.out.println(RandomListNode.printList(root));
		
		RandomListNode copied=sol.copyRandomList(root);
		System.out.println(RandomListNode.printList(copied));

	}

}
