package lc.q242.ValidAnagram;

import java.util.Arrays;

/*
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?



 * 
 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	89.02%
	public static boolean isAnagram(String s, String t) 
	{
		int[] alphabet = new int[26];
		if(s.length() != t.length())
			return false;
		for(char e: s.toCharArray())
		{
			alphabet[e-'a']++;
		}
		for(char e: t.toCharArray())
		{
			alphabet[e-'a']--;
		}
		for(int e: alphabet)
		{
			if(e!=0)
				return false;
		}
		return true;
    }
//	31.60%
	public static boolean isAnagram1(String s, String t) 
	{
		if(s.length()!= t.length())
		{
			return false;
		}
		char[] sCh = s.toCharArray();
		char[] tCh = t.toCharArray();
		Arrays.sort(sCh);
		Arrays.sort(tCh);
		for(int i = 0;i<s.length();i++)
		{
			if(sCh[i]!=tCh[i])
				return false;
		}
		return true;
	}

}
