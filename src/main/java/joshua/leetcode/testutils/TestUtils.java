package joshua.leetcode.testutils;

public  class TestUtils {

	public static Boolean assertArrayEquals(String[] strs1,String[] strs2){
		if(strs1==null ^ strs2==null)
			return false;
		if(strs1.length!=strs2.length)
			return false;
		for(int i=0;i<strs1.length;i++){
			if(strs1[i]==null ^ strs2[i]==null)
				return false;
			if(!strs1[i].equals(strs2[i]))
				return false;
		}
		return true;
	}
	
}
