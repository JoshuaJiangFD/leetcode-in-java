package joshua.leetcode.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class HappyNumberTest {

    @Test
    public void testSumSqure() throws Exception {
        assertEquals(82, HappyNumber.sumSqure(19));
        assertEquals(68,HappyNumber.sumSqure(82));
    }


    @Test
    public void testSolution1() throws Exception{
        HappyNumber sol=new HappyNumber.Solution1();
        assertEquals(true, sol.isHappy(19));
        assertEquals(false,sol.isHappy(4));
    }

    @Test
    public void testSolution2(){
        HappyNumber sol=new HappyNumber.Solution2();
        assertEquals(true, sol.isHappy(19));
        assertEquals(false,sol.isHappy(4));
    }
}