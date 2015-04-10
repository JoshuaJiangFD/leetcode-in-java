package joshua.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54 Spiral Matrix
 * @see <a href="https://leetcode.com/problems/spiral-matrix/">leetcode link</a>
 * @author joy
 *
 */
public abstract class SpiralMatrix {

	/**
	 * 
	 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

	   For example,
	   Given the following matrix:
			[
			 [ 1, 2, 3 ],
			 [ 4, 5, 6 ],
			 [ 7, 8, 9 ]
			]
	    You should return [1,2,3,6,9,8,7,4,5].
	 *
	 */
	public abstract List<Integer> spiralOrder(int[][] matrix);

	static class Solution1 extends SpiralMatrix {

		@Override
		public List<Integer> spiralOrder(int[][] matrix) {
			List<Integer> result = new ArrayList<Integer>();
			if(matrix==null||matrix.length==0||matrix[0]==null)
				return result; 
			int hLeft = 0, hRight = matrix[0].length - 1;
			int vTop = 0, vBottom = matrix.length - 1;
			int direction = 0;// 0:right,1:down,2:left,3:up
			while (hRight >= hLeft && vTop <= vBottom) {
				while (direction < 4) {
					if (direction == 0) {
						for (int i = hLeft; i <= hRight; i++) {
							result.add(matrix[vTop][i]);
						}
					} else if (direction == 1) {
						for (int j = vTop+1; j <= vBottom; j++) {
							result.add(matrix[j][hRight]);
						}
					} else if (direction == 2&&vBottom>vTop ) {
						for (int i = hRight-1; i >= hLeft; i--) {
							result.add(matrix[vBottom][i]);
						}
					}
					else if(hRight>hLeft){
						for(int j=vBottom-1;j>=vTop+1;j--){
							result.add(matrix[j][hLeft]);
						}
					}
					direction++;
					continue;
				}
				hLeft++;hRight--;
				vTop++;vBottom--;
				direction=0;
			}
			return result;
		}
	}
}
