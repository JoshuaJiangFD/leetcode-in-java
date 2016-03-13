package joshua.leetcode.array.backtracking;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 79	Word Search
 * @see <a href="https://leetcode.com/problems/word-search/">leetcode link</a>
 * @author joy
 *
 */
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
			return search(board,word,track,height,width);
		}

		private boolean search(char[][] board,String word,Stack<Integer> track,int height,int width){
			if(track.size()==0){
				for(int i=0;i<height;i++)
					for(int j=0;j<width;j++){
						if(board[i][j]==(word.charAt(0))){
							track.add(i*width+j);
							if(search(board,word,track,height,width))
								return true;
							else 
								track.pop();
						}
					}
				return false;
			}
			else if(track.size()==word.length())
				return true;
			else{
				int top=track.peek();
				int vIdx=top/width,hIdx=top%width;
				//left
				if(hIdx!=0){/*has left element*/
					if(word.charAt(track.size())==board[vIdx][hIdx-1]&&!track.contains(top-1))
					{
						track.add(top-1);
						if(search(board,word,track,height,width))
							return true;
						else 
							track.pop();
					}
				}
				//right
				if(hIdx!=width-1){/*has right element*/
					if(word.charAt(track.size())==board[vIdx][hIdx+1]&&!track.contains(top+1))
					{
						track.add(top+1);
						if(search(board,word,track,height,width))
							return true;
						else
							track.pop();
					}
				}
				//up
				if(vIdx!=0){
					if(word.charAt(track.size())==board[vIdx-1][hIdx]&&!track.contains(top-width))
					{
						track.add(top-width);
						if(search(board,word,track,height,width))
							return true;
						else
							track.pop();
					}
				}
				//down
				if(vIdx!=height-1){
					if(word.charAt(track.size())==board[vIdx+1][hIdx]&&!track.contains(top+width))
					{
						track.add(top+width);
						if(search(board,word,track,height,width))
							return true;
						else
							track.pop();
					}
				}
				return false;
			}
		}
	}
}
