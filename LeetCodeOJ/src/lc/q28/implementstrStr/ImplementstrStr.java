package lc.q28.implementstrStr;
/*
 * 28. Implement strStr()
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	74 / 74 test cases passed.
//	Status: Accepted
//	Runtime: 7 ms  77.43%
	public static int strStr(String haystack, String needle) 
	{
   			return haystack.contains(needle)? haystack.indexOf(needle): -1;
    }

}
