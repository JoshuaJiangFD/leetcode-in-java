package joshua.leetcode.dp;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WordBreakTest {

    HashMap<Pair,Boolean> cases;


    @Before
    public void setUp() throws Exception {
        cases = new HashMap<Pair, Boolean>();
        String s="leetcode";
        Set<String> dicts= new HashSet<String>(Arrays.asList("leet","code"));
        cases.put(new Pair(s,dicts),true);
    }

    @Test
    public void testSolution1(){
        WordBreak sol=new WordBreak.Solution1();
        for(Pair key:cases.keySet()){
            assertEquals(cases.get(key),sol.wordBreak(key.str,key.wordDicts));
        }
    }

    class Pair{
        String str;
        Set<String> wordDicts;

        public Pair(String str, Set<String> wordDicts) {
            this.str = str;
            this.wordDicts = wordDicts;
        }
    }
}