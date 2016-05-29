package joshua.leetcode.bfs;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

public class WordLadder2Test {

    private WordLadder2 solution;

    @Before
    public void setUp () {
//        solution = new WordLadder2.Solution2();
        solution = new WordLadder2.Solution3();
    }

    @Test
    public void testSolution() {
        String beginWord = "hit";
        String endWord = "cog" ;
        Set<String> wordList = Sets.newHashSet("hot","dot","dog","lot","log");
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }
}