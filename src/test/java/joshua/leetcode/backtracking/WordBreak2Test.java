package joshua.leetcode.backtracking;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class WordBreak2Test {


    @Test
    public void testSolution1(){
        String s="catsanddog";
        Set<String> dict=new HashSet<String>();
        dict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        WordBreak2 sol=new WordBreak2.Solution1();
        List<String> result=sol.wordBreak(s,dict);
        for(String res : result)
            System.out.println(res);
    }

}