package joshua.leetcode.dp;

public abstract class EditDistance {

	/**
	 * Given two words word1 and word2, find the minimum number of steps
	 * required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word: a) Insert a
	 * character b) Delete a character c) Replace a character
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public abstract int minDistance(String word1, String word2);

	static class Solution1 extends EditDistance {

		@Override
		public int minDistance(String word1, String word2) {
			// store the result of each steps into the two dimensional array.
			int[][] res = new int[word1.length() + 1][word2.length() + 1];
			for (int i = 0; i <= word1.length(); i++) {
				res[i][0] = i;
			}
			for (int j = 0; j <= word2.length(); j++) {
				res[0][j] = j;
			}
			// begin the main loop, the target is to calculate
			// res[word1.length()][word2.length()]
			for (int i = 1; i <= word1.length(); i++)
				for (int j = 1; j <= word2.length(); j++) {
					char charOfWord1=word1.charAt(i-1);
					char charOfWord2=word2.charAt(j-1);
					if(charOfWord1==charOfWord2){
						res[i][j]=res[i-1][j-1];
					}
					else{
						int minSteps=Math.min(Math.min(res[i-1][j], res[i][j-1]),res[i-1][j-1]);
						res[i][j]=minSteps+1;
					}
				}
			return res[word1.length()][word2.length()];
		}
	}

}
