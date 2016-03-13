package joshua.leetcode.array.backtracking;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PalindromePartitioningTest {

    String s;

    @Before
    public void setUp(){
        //s = "aab";
        s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
    }

    @Test
    public void testSolution1 () {
        PalindromePartitioning solution = new PalindromePartitioning.Solution1();
        List<List<String>> result = solution.partition(s);
        for(List<String> answer: result) {
            System.out.println(answer);
        }
    }
}