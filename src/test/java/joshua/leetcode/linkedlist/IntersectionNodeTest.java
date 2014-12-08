package joshua.leetcode.linkedlist;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class IntersectionNodeTest {

	private ListNode headA, headB;
	
	@Before
	public void Setup(){
		headA=new ListNode(1);
		headA.next=new ListNode(2);
		headA.next.next=new ListNode(3);
		
		headB=new ListNode(4);
		headB.next=new ListNode(5);
		
		ListNode headC=new ListNode(6);
		headC.next=new ListNode(7);
		
		headA.next.next.next=headC;
		headB.next.next=headC;
	}
	
	@Test
	public void test_Solution1() {
		IntersectionNode sol1=new IntersectionNode.Solution1();
		ListNode intersectedNode=sol1.getIntersectionNode(headA, headB);
		assertEquals(intersectedNode.val,6);
	}

}
