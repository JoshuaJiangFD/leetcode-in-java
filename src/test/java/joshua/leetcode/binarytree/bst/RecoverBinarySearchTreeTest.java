package joshua.leetcode.binarytree.bst;

import java.util.HashMap;

import joshua.leetcode.binarytree.TreeNode;
import joshua.leetcode.testutils.TestUtils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class RecoverBinarySearchTreeTest {

	HashMap<String[],String[]> testCases;
	
	@Before
	public void setUp(){
		testCases=new HashMap<String[],String[]>();
		testCases.put(new String[]{"2","3","1","#","#","#","4"}, new String[]{"2","1","3","#","#","#","4"});
		testCases.put(new String[]{"4","1","3","#","#","#","2"}, new String[]{"2","1","3","#","#","#","4"});
		testCases.put(new String[]{"1","#","5","#","3","#","2"},new String[]{"1","#","2","#","3","#","5"});
		testCases.put(new String[]{"5","1","#","3","#","2","#","4"},new String[]{"5","4","#","3","#","2","#","1"});
	}
	
	
	@Test
	public void testSolution1() {
		RecoverBinarySearchTree sol=new RecoverBinarySearchTree.Solution1();
		for(String[] key: testCases.keySet()){
			TreeNode root=TreeNode.DeserializeTreeByLevelOrder(key);
			sol.recoverTree(root);
			String[] str=TreeNode.SerializeTreeByLevelOrder(root);
			System.out.println(StringUtils.join(str,";"));
			TestUtils.assertArrayEquals(testCases.get(key), str);
		}
	}

}
