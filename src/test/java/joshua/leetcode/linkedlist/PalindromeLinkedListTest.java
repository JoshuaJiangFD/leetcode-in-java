package joshua.leetcode.linkedlist;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PalindromeLinkedListTest {

    HashMap<ListNode,Boolean> cases=new HashMap<ListNode, Boolean>();

    @Before
    public void setUp() throws Exception {
        ListNode root=ListNode.buildList(new int[]{1,2,3,2,1});
        ListNode root2=ListNode.buildList(new int[]{1,2,2,1});
        ListNode root3=ListNode.buildList(new int[]{1,2,3,2,2});
        cases.put(root,true);
        cases.put(root2,true);
       cases.put(root3,false);
    }

    @Test
    public void testSolution1(){
        PalindromeLinkedList sol=new PalindromeLinkedList.Solution1();
        for (Map.Entry<ListNode,Boolean> entry: cases.entrySet()){
            assertEquals(entry.getValue(),sol.isPalindrome(entry.getKey()));
        }
    }
}