package joshua.leetcode.array.backtracking;

import java.util.LinkedList;
import java.util.Stack;

public abstract class WordSearch {
	
	/**
	 * Given a 2D board and a word, find if the word exists in the grid.

	   The word can be constructed from letters of sequentially adjacent cell,
	   where "adjacent" cells are those horizontally or vertically neighboring. 
		 
	   The same letter cell may not be used more than once.
		For example,
		Given board =
		[
		  ["ABCE"],
		  ["SFCS"],
		  ["ADEE"]
		]
		
		word = "ABCCED", --> returns true,
		word = "SEE", --> returns true,
		word = "ABCB", --> returns false.
		
	 * @param board
	 * @param word
	 * @return
	 */
	public abstract boolean exist(char[][] board, String word);
	
	static class Solution extends WordSearch{

		@Override
		public boolean exist(char[][] board, String word) {
			if(board==null||board.length==0||board[0].length==0)
				return false;
			if(word==null||word.length()==0)
				return true;
			int height=board.length;
			int width=board[0].length;
			Stack<Integer> track=new Stack<Integer>();
			return false;
			
		}
		private boolean search(char[][] board,String word,Stack<Integer> track){
			if(track.size()==0){
				 
			}
			return false;
		}
		
		
		
	}
}
