package joshua.leetcode.array.sorting;

/**
 * Sorting by a series of swap actions. </br>
 * 1) quick sorting.</br>
 * 
 * 2) bubble sorting.</br>
 * 
 * @author Joshua.Jiang
 *
 */
public abstract class SwapSorting {

	/**
	 * A generic signature of quickSort method.</br></br>
	 * {@literal T extends Comparable<T>>} is called as
	 * "recursive type bound".</br> It means restricting type parameter T by an
	 * expression({@literal T extends Comparable<T>)}),which contains the type
	 * parameter T itself.</br>
	 * 
	 * @param array
	 */
	public  abstract <T extends Comparable<T>> void quickSort(T[] array);

	/**
	 * Quick Sorting algorithm.</br></br>
	 * <b>Best TC:</b> o(n*log<SUB>2</SUB>n), the more unordered the array is, the more efficient this algorithm is, and vice versa.</br>
	 * <b>Average TC:</b> o(n*log<SUB>2</SUB>n), which is the best amongst all sorting algorithms.</br>
	 * <b>Total Comparison Times:</b> unrelated with initial array itself.</br>
	 * 
	 * @author Joshua.Jiang
	 *
	 */
	public static class QuickSort extends SwapSorting {

		@Override
		public <T extends Comparable<T>> void quickSort(T[] array) {
			int start = 0, end = array.length-1;
			quickSort(array,start,end);

		}
		
		/**
		 * One time of quick sorting.</br>
		 * Choose an element as the pivot(usually the first one), move all other elements bigger than pivot to the right side, and the smaller ones to the left side.
		 * @param array
		 * @param start
		 * @param end
		 */
		private <T extends Comparable<T>> void quickSort(T[] array, int start,
				int end) {
			T temp;
			int i = start, j = end;
			if (start < end) {
				temp = array[start];//the pivot element

				while (i != j) {
					// find the first element smaller than temp from end to
					// start.
					while (j > i && array[j].compareTo(temp) > 0)
						j--;
					if (i < j) {
						array[i] = array[j];
						i++;
					}
					// find the first element bigger than temp form start to
					// end.
					while (i < j && array[i].compareTo(temp) < 0)
						i++;
					if (i < j) {
						array[j] = array[i];
						j--;
					}
				}// stop when j==i, and i(or j) is the final index of temp.
				array[i] = temp;
				quickSort(array, start, i - 1);
				quickSort(array, i + 1, end);
			}
		}
	}

}
