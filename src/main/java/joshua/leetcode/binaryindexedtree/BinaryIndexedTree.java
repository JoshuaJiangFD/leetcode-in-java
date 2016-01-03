package joshua.leetcode.binaryindexedtree;

/**
 * Binary Indexed Tree implementation(abbr. BIT).
 * BIT is for quick access and update on array with average Time Complexity o(logn).
 * BIT is used for quickly getting cumulative values of original array.
 *
 * @see <a href="https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/">
 * top coder explanation</a>
 * <p>
 * Created by joshua on 1/2/16.
 */
public class BinaryIndexedTree {

    private int maxVal;

    private int[] tree;

    public BinaryIndexedTree(int[] original) {
        maxVal = original.length;
        // tree[0] is empty, just for calculation facility
        tree = new int[maxVal + 1];
        /*
         * iterate over the original array from left to right.
         * for each element, update the tree
         */
        for (int i = 1; i <= maxVal; i++) {
            updateTreeElement(i, original[i - 1]);
        }
    }

    /**
     * Get the cumulative value within range [0, index]
     *
     * @param index The index in original array
     * @return the cumulative value.
     */
    public int getCumulativeValue(int index) {
        int idxInTree = index + 1;
        int sum = 0;
        /*
         * find the pioneer recursively. e.g. for 14(1110), pioneers are 12(1100), 8(1000)
         * and the result is tree[14] + tree[12] + tree[8]
         */
        while (idxInTree > 0) {
            sum += tree[idxInTree];
            idxInTree -= (idxInTree & -idxInTree);
        }
        return sum;
    }

    /**
     * Find the index in original array with given value.
     * Here we do it on BIT rather than the original array.
     *
     * @param idx The index in original array
     * @return value in original array
     */
    public int getValueInOringalArray(int idx) {
        if (idx < 0)
            throw new IllegalArgumentException(String.format("Index %d out of boundary", idx));
        int idxInTree = idx + 1;
        int sum = tree[idxInTree];
        if (idxInTree > 0) {
            int commonNode = idxInTree - (idxInTree & -idxInTree);
            int pioneerIdx = idxInTree-1; // The left index of the target.
            // At some iteration pioneerIdx will meet the commonNode
            while (pioneerIdx != commonNode) {
                //Substract tree frequency which is between pioneerIdx and the common node
                sum -= tree[pioneerIdx];
                pioneerIdx -= (pioneerIdx & -pioneerIdx);
            }
        }
        return sum;
    }

    /**
     * Find index with given cumulative value.
     * If in tree exists more than one index with a same cumulative value,
     * this procedure will return the greatest one.
     *
     * @param value the value
     * @return The index in original array.
     */
    public int FindGreatestIndexWithGivenCumulativeValue(int value) {
        int idx = 0;
        int bitMask = getHighestBit(maxVal);
        while(bitMask!=0 && idx <= maxVal){
            int tIdx = idx + bitMask;
            if(tIdx >maxVal){
                break;
            }
            if(value >= tree[tIdx]){
                //if current cumulative value equals to the target. we are still looking for higher index(if exists)
                idx = tIdx;
                value -= tree[tIdx];
            }
            bitMask >>= 1;
        }
        if(value != 0){
            return -1;
        }else{
            return idx-1;
        }
    }

    public int FindIndexWithGivenCumulativeValue(int value){
        int idx = 0;//this is the result, but starting from 1
        int bitMask = getHighestBit(maxVal);
        while(bitMask!=0 && idx<= maxVal){
            int tIdx = idx + bitMask;
            if(value == tree[tIdx]){
                idx = tIdx;
                break;
            }else if (value >tree[tIdx]){
                //if tree value 'can fit' into target value, then include it
                idx = tIdx;//update index for next loop
                value -= tree[tIdx];//set target value for next loop
            }
            bitMask >>= 1;
        }
        if(value != 0){
            return -1;
        }else{
            return idx-1;
        }
    }

    /**
     * Update the element in tree
     *
     * @param idx       The index to update
     * @param increment The increment to add into tree
     */
    public void updateTreeElement(int idx, int increment) {
        /*
         * find the successor recursively.if one element in original array got updated.
         * In BIT, all elements which are responsible for that element should be updated as well.
         * these element's index can be found by such recursion.
         * Every element in BIT represents cumulation of some range of oringal array, we call it the
         * Responsibility here.
         * for example, tree[12] cover the range [9,10, 11,12], the range is last digit 1 of '1100'.
         */
        while (idx <= maxVal) {
            tree[idx] += increment;
            idx += (idx & -idx);// 12 & -12 is  the last digit of 1100, namely 4.
        }
    }

    /**
     * Get another copy of the tree array.
     *
     * @return The copied tree.
     */
    public int[] getTree() {
        int[] copied =new int[maxVal+1];
        System.arraycopy(tree,0,copied,0,maxVal+1);
        return copied;
    }

    /**
     * Get the highest bit of a positive integer
     *
     * @param value
     * @return
     */
    public static int getHighestBit(int value) {
        if (value < 0)
            throw new IllegalArgumentException(String.format("value %d should be greater than 0", value));
        if (value == 0)
            return 0;
        int bits = 0;
        while (value > 0) {
            value = value >> 1;
            bits++;
        }
        return 1 << (bits - 1);
    }
}