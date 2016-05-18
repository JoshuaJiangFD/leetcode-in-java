package joshua.leetcode.hashtable;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GroupAnagramsTest {

    private Map<String[], List<List<String>>> cases = Maps.newHashMap();

    @Before
    public void setUp() {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> results = new ArrayList<List<String>>();
        results.add(Lists.newArrayList("ate", "eat","tea"));
        results.add(Lists.newArrayList("nat","tan"));
        results.add(Lists.newArrayList("bat"));
        cases.put(strings, results);
    }

    @Test
    public void testSolution1() {
        GroupAnagrams solution = new GroupAnagrams.Solution1();
        for(String[] testcase: cases.keySet()) {
            List<List<String>> result = solution.groupAnagrams(testcase);
            for(List<String> res :result) {
                System.out.println(res);
            }
        }
    }

}