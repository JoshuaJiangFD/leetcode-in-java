package joshua.leetcode.array.backtracking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordSearchTest {

	char[][] board=new char[][]{
			{'A','B','C','E'},
			{'S','F','C','S'},
			{'A','D','E','E'}
	};
	

	@Test
	public void testSolution1() {
		WordSearch sol=new WordSearch.Solution();
		assertEquals(true,sol.exist(board, "ABCCED"));
	}

}
