package lc.q392.IsSubsequence;
/*
 * 392. Is Subsequence
 * Medium
 * Category: DP
 * 
 * Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. 
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string 
which is formed from the original string by deleting some (can be none) of the characters 
without disturbing the relative positions of the remaining characters. 
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
and you want to check one by one to see if T has its subsequence. 
In this scenario, how would you change your code?


 */
public class IsSubsequence {

	public static void main(String[] args) 
	{
		String s = "axc";
		String t = "ahbgdc";
		
		System.out.println(isSubsequence(s, t));
	}
//96.53%
/*
 * The idea is pretty simple here:
 * if s.charAt(0) exists in String t,
 * record the position+1 as start, then search the next character in String s from start in String t.
 * if from start, there is no letter in s in t, return false.
 */
	public static boolean isSubsequence(String s, String t) 
	{
        int start = 0 ;
	    for( char c : s.toCharArray())
	    {
	        int index = t.indexOf(c,start);
	        if(index == -1 ) 
	        	return false ;
	        start = index + 1 ;
	    }
	    return true ;
	}
	
	
//	14.54%
	public static boolean isSubsequence1(String s, String t) 
	{
		if(s.equals(""))
			return true;
		
        for(int i = 0,j=0; i<t.length()&& j<s.length();i++)
        {
        	if(s.charAt(j) == t.charAt(i))
        	{
        		j++;
        	}
        	if(j == s.length())
        		return true;
        }
        return false;
    }
}
