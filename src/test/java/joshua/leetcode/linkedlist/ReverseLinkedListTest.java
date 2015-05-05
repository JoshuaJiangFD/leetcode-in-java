package joshua.leetcode.linkedlist;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class ReverseLinkedListTest {

	HashMap<int[],String> testCases;
	
	@Before
	public void setUp(){
		testCases=new HashMap<int[],String>();
		testCases.put(new int[]{1,2,3,4,5}, "5->4->3->2->1");
		testCases.put(new int[]{1}, "1");
		testCases.put(new int[]{1,2}, "2->1");
	}
	
	@Test
	public void testSolution1() {
		ReverseLinkedList sol=new ReverseLinkedList.Solution1();
		for(int[] key: testCases.keySet()){
			ListNode head=ListNode.buildList(key);
			ListNode reversed=sol.reverseList(head);
			assertEquals(testCases.get(key),reversed.printList());
		}
	}

}
