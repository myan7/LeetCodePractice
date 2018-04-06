package lc.q567.PermutationinString;

import java.util.HashSet;
import java.util.Set;

/*
 * 567. Permutation in String
 * Medium
 * Given two strings s1 and s2, 
 * write a function to return true if s2 contains the permutation of s1. 
 * In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 * 
 */

public class PermutationinString {

	public static void main(String[] args) {

//		String s1 = "ab";
//		String s2 = "eidbaooo";
		String s1 = "a";
		String s2 = "ab";
//		String s1 = "adc";
//		String s2 = "dcda";
		System.out.println(checkInclusion(s1, s2));
	}
	
	
//	57.30%
	public static boolean checkInclusion(String s1, String s2) 
	{
		
		int[] alpha = new int[26];
		
		for(char e: s1.toCharArray())
		{
			alpha[e-'a']++;
		}
		int len = 0;
		
//		Sliding window, if you see a char that belongs to s1, then deduct the count of it in alphabet
//		len+1;
//		if you see a char that doesn't belong to s1, then add the first one back, 
//		until counts of all the previous char are added back, then move to the next position. 
		for(int i =0;i<s2.length();)
		{
			if(alpha[s2.charAt(i)-'a']>0)
			{
				alpha[s2.charAt(i)-'a']--;
				len++;
				i++;
				if(len == s1.length())
					return true;
			}else if(len>0)
			{
				alpha[s2.charAt(i-len)-'a']++;
				len--;
			}
			else
				i++;
		}
		return false;
		
    }

}
