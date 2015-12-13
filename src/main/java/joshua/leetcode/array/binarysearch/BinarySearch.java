package joshua.leetcode.array.binarysearch;

/**
 *Two different types of binary search.
 *
 *对num[]={1,2,2,4,4,8,10},查找target,返回值有四种情况：
 *YES_LEFT、YES_RIGHT、NO_LEFT、NO_RIGHT
 *分别代表：
 * 能找到且返回最左边的数的位置（如查找4的时候返回位置3）
 * 能找到且返回最右边的数的位置（如查找4的时候返回位置4）
 * 不能找到且返回左边与其接近的数的位置（如查找3的时候返回位置2）
 * 不能找到且返回右边与其接近的数的位置（如查找3的时候返回位置3）
 *
 * @see <a href="http://blog.csdn.net/int64ago/article/details/7425727">CSDN blog</a>
 *
 */
public class BinarySearch {

    /**
     *实现查找时，如果存在则返回最左侧的元素的下标（YES_LEFT）,
     *如果不存在则返回可插入的位置的下标，或者说第一个大于target的元素的下标(NO_RIGHT)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchForLeftMost(int[] nums,int target){
        if(nums==null)
            return -1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]>=target) high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    /**
     *实现查找时，如果存在则返回最右侧的元素的下标（YES_RIGHT）,
     *如果不存在则返回可插入的位置的下标的前一个位置，或者说最后一个小于target的元素的下标(NO_LEFT)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int searchForRightMost(int[] nums,int target){
        if(nums==null)
            return -1;
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=(low+high)>>1;
            if(nums[mid]>target) high=mid-1;
            else
                low=mid+1;
        }
        return high;
    }
}
