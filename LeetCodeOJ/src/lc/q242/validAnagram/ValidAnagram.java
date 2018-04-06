package lc.q242.validAnagram;

import java.util.HashSet;
import java.util.Set;

/*
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
 * 
 */
public class ValidAnagram {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

//	4ms for 34 test cases beat 89.58%
	private static boolean isAnagram(String s, String t) 
	{
		boolean value = true;
		int[] alpha = new int[26];
		for(char e: s.toCharArray())
		{
			alpha[e-'a']++;
		}
		
		for(char e:t.toCharArray())
		{
			alpha[e-'a']--;
		}
		
		for(int e:alpha)
		{
			if(e!=0)
				value =false;
		}

		return value;
    }
	
	
	private static boolean isAnagram1(String s, String t)
	{
//		you may not get the correct answer, because if s = "aa" and t = "bb"
//		the answer is 0 but the two strings are not anagram.
//		s = "xaaddy", t "xbbccy"
		boolean value = false;
		int a = 0;
		int sum = 0;
		for(char e:s.toCharArray())
		{
			sum +=e;
			a ^=e;
		}
		for(char e: t.toCharArray())
		{
			sum -=e;
			a^= e;
		}
		if(a==0 && sum ==0)
		{
			value = true;
		}
		return value;
	}
	
	private static boolean isAnagram2(String s, String t)
	{
//		you may also not get the correct answer 
//		for example, if  s ="acaa" and t = "caac".
		if(s.length()!=t.length())
		{
			return false;
		}
		else
		{
			Set<Character> mySet = new HashSet<Character>();
			for(char e:s.toCharArray())
			{
				mySet.add(e);
			}
			int length = mySet.size();
			for(char e:t.toCharArray())
			{
				mySet.add(e);
			}
			if(mySet.size()==length)
				return true;
			else
				return false;
		}
	}
	
}
