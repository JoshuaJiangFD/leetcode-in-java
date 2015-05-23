package joshua.leetcode.array.twopointers;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumSizeSubarraySumTest {


    @Test
    public void testSolution1(){
        MinimumSizeSubarraySum sol=new MinimumSizeSubarraySum.Solution1();
        int[] args=new int[]{2,3,1,2,4,3};
        assertEquals(2,sol.minSubArrayLen(7,args));
    }

    @Test
    public void testSolution2(){
        MinimumSizeSubarraySum sol=new MinimumSizeSubarraySum.Solution2();
        int[] args=new int[]{2,3,1,2,4,3};
        assertEquals(2,sol.minSubArrayLen(7,args));
    }

    @Test
    public void testSolution3(){
        MinimumSizeSubarraySum sol=new MinimumSizeSubarraySum.Solution3();
        int[] args=new int[]{2,3,1,2,4,3};
        assertEquals(2,sol.minSubArrayLen(7,args));
    }
    
    @Test
    public void testSolution4(){
        MinimumSizeSubarraySum sol=new MinimumSizeSubarraySum.Solution4();
        int[] args=new int[]{2,3,1,2,4,3};
        assertEquals(2,sol.minSubArrayLen(7,args));
    }

}