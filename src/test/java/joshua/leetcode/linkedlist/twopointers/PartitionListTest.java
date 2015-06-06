package joshua.leetcode.linkedlist.twopointers;

import java.util.HashMap;
import java.util.Map.Entry;

import joshua.leetcode.linkedlist.ListNode;

import org.junit.Before;
import org.junit.Test;

public class PartitionListTest {

	HashMap<ListNode, Integer> parameters;
	
	@Before
	public void setUp(){
		parameters=new HashMap<ListNode,Integer>();
		parameters.put(ListNode.buildList(new int[]{1,4,3,2,5,2}),3);
		parameters.put(ListNode.buildList(new int[]{1,2,3}),4);
		parameters.put(ListNode.buildList(new int[]{2,0,4,1,3,1,4,0,3}),4);
	}
	
	
	@Test
	public void test() {
		PartitionList sol=new PartitionList.Solution1();
		for(ListNode head: this.parameters.keySet()){
			ListNode res=sol.partition(head, this.parameters.get(head));
			System.out.println(res.printList());
		}		
	}

}
