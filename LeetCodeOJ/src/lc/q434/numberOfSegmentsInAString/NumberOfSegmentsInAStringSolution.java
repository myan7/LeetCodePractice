package lc.q434.numberOfSegmentsInAString;
/*
 * 434. Number of Segments in a String
 * Count the number of segments in a string, 
 * where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
          1    2   3   4   5
Input: "Hello, my name is John"
Output: 5
 * 
 */

public class NumberOfSegmentsInAStringSolution 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
	public static int countSegments(String s) 
    {

		int res=0;
	    for(int i=0; i<s.length(); i++)
	        if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
	            res++;        
	    return res;
//	    find the combination of a 'space' and a printable char.  like " a"
//	    you need to think about how to express your thought in Java
//	    including those corner cases.
    }

	public static int countSegments1(String s) 
	{
	   int res=0;
	    for(int i=0; i<s.length(); i++)
	        if(s.charAt(i)!=' ' && (i==s.length()-1 || s.charAt(i+1)==' '))
	            res++;        
	    return res;
	}
//	find the combination of a printable char and a space like "a "
}
