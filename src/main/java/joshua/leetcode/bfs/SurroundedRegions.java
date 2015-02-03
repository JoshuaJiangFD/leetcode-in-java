package joshua.leetcode.bfs;

public abstract class SurroundedRegions {

	/**
	 * Given a 2D board containing 'X' and 'O', capture all regions surrounded
	 * by 'X'.
	 * 
	 * A region is captured by flipping all 'O's into 'X's in that surrounded
	 * region.
	 * 
	 * For example, 
	 *  X X X X
	 *  X O O X 
	 *  X X O X 
	 *  X O X X
	 * 
	 * After running your function, the board should be:
	 *  X X X X 
	 *  X X X X 
	 *  X X X X
	 *  X O X X
	 * 
	 * @param board
	 */
	public abstract void solve(char[][] board);
	
	public static void printArrays(char[][] arrays) {
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[0].length; j++) {
				System.out.print(String.valueOf(arrays[i][j]) + '\t');
			}
			System.out.println();
		}
	}

	public static class Solution1 extends SurroundedRegions {

		/**
		 * union find algorithm. Observation: if an 'O' is not surrounded, it
		 * has a path to a 'O' on the border.
		 * Boolean[board.width*board.height], 1) find all the 'O's, tag all the
		 * 'O's on the border;
		 */
		@Override
		public void solve(char[][] board) {
			if (board == null)
				return;
			if (board.length == 0 || board[0].length == 0)
				return;
			int height = board.length;
			int width = board[0].length;
			// every element's ultimate root on the path to border.
			int[] paths = new int[height * width];
			// whether the element is connected to'O' on the border.
			Boolean[] connected = new Boolean[paths.length];
			//initiation
			for(int idx=0;idx<paths.length;idx++){
			    int i=idx/width;
				int j=idx%width;
				paths[idx] = idx;
				char cur = board[i][j];
			    connected[idx]=cur == 'O' && (i == 0 || i == (height - 1) || j == 0 || j == (width - 1));
			}
		   // scan all the elements
			for(int idx=0;idx<paths.length;idx++){
			    int i=idx/width;
				int j=idx%width;
				char cur = board[i][j];
				if (cur == 'X')
					continue;
				// the up one
				if (i > 0) {
					char up = board[i - 1][j];
					if (up == 'O') {
						join(idx,idx-width,paths,connected);
					}
				}
				// the left one
				if (j > 0) {
					char left = board[i][j - 1];
					if (left == 'O') {
						join(idx,idx-1,paths,connected);
					}
				}
			}
			// check all the 'O', if it's connected to the border, then it is
			// in surrounded region, otherwise change it as 'X'
			for(int idx=0;idx<paths.length;idx++){
				int i=idx/width;
				int j=idx%width;
				char cur = board[i][j];
				if (cur == 'X')
					continue;
				int root=findParent(idx,paths);
				if(connected[root]==true)
					continue;
				 board[i][j]='X';
			}
		}

		private void join(int i, int j, int[] paths,Boolean[] connected) {
			int iParent = findParent(i, paths);
			int jParent=findParent(j, paths);
			Boolean isConnected = connected[iParent]|| connected[jParent];
			paths[iParent] = jParent;
			connected[jParent]=isConnected;
		}


		private int findParent(int i, int[] paths) {
			while (paths[i] != i)
				i = paths[i];
			return i;
		}

	}

}
