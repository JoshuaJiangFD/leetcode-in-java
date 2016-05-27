package joshua.leetcode.bfs;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class WordLadder2Test {

    @Test
    public void testSolution() {
        String beginWord = "hit";
        String endWord = "cog" ;
        Set<String> wordList = Sets.newHashSet("hot","dot","dog","lot","log");
        WordLadder2 solution = new WordLadder2.Solution1();
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(result);
    }

}