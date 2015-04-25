package joshua.leetcode.cache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LRUCacheImplTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		LRUCache cache=new LRUCacheImpl(3);
		cache.set(1, 2);
		cache.set(2, 3);
		cache.set(3, 4);
		cache.set(4, 5);
		cache.set(4, 9);
		assertEquals(-1,cache.get(1));
		assertEquals(3,cache.get(2));
		assertEquals(9,cache.get(4));
	}

}
