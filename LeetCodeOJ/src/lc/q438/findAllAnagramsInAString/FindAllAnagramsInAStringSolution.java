package lc.q438.findAllAnagramsInAString;

import java.util.*;
import java.util.ArrayList;

/*
 * 
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, 
 * find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only 
and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * 	https://www.youtube.com/watch?v=h4MCwdfZZas here is a good video to use HashMap to 
 * do the job. easy to understand but I haven't implement the idea yet. 
 * Updated: 02/14/2017
 * 
 */
public class FindAllAnagramsInAStringSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findAnagrams1(String s, String p)
	{
		List<Integer> ans = new ArrayList<>();
		Map<Character, Integer> pattern = new HashMap<Character,Integer>();
		int countP = 0;
		for(int i =0;i<p.length();i++)
		{
			pattern.put(p.charAt(i), countP++);
		}
		
		
		Map<Character,Integer> strMap = new HashMap<Character,Integer>();
		int countS = 0;
		for(int i =0; i<s.length();i++)
		{
			
		}
		
		return ans;
	}
	public static boolean mapsAreEqual(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {

	    try{
	        for (Character k : mapB.keySet())
	        {
	            if (!mapA.get(k).equals(mapB.get(k))) {
	                return false;
	            }
	        } 
	        for (Character y : mapA.keySet())
	        {
	            if (!mapB.containsKey(y)) {
	                return false;
	            }
	        } 
	    } catch (NullPointerException np) {
	        return false;
	    }
	    return true;
	}
	
	public static <K, V> boolean equalMaps(Map<K,V>m1, Map<K,V>m2) {
		   if (m1.size() != m2.size())
		      return false;
		   for (K key: m1.keySet())
		      if (!m1.get(key).equals(m2.get(key)))
		         return false;
		   return true;
		}
	
//	25ms for 36 test cases. other's answer.
	public List<Integer> findAnagrams2(String s, String p)
	{
		int[] chars = new int[26];
	    List<Integer> result = new ArrayList<>();

	    if (s == null || p == null || s.length() < p.length())
	        return result;
	    for (char c : p.toCharArray())
	        chars[c-'a']++;

	    int start = 0, end = 0, count = p.length();
	    // Go over the string
	    while (end < s.length()) {
	        // If the char at start appeared in p, we increase count
	        if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
	            count++;
	        // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
	        if (--chars[s.charAt(end++)-'a'] >= 0)
	            count--;
	        if (count == 0)
	            result.add(start);
	    }
	    
	    return result;
	}
	
	
	
	
	
//  this is the idea doesn't work.
//	updated: 02/14/2017
	public List<Integer> findAnagrams(String s, String p) 
	{
//		my idea is to calculate the sum of the pattern, since every letter has its own
//		value according ASCII, and I find out if I can get the sum of the substring in s
//		if it equals to the sum of p, then the anagram is found and return the starting
//		index.
		List<Integer> ans = new ArrayList<Integer>();
		int pattern = 0;
        for(char e: p.toCharArray())
        {
        	pattern += e;
        }
        if(p.length()>s.length())
        {
        	ans.clear();
        }
        else
        {
        	for(int i=0;i<=s.length()-p.length();i++)
            {
            	int temp = 0;
            	for(int j = i;j<i+p.length();j++)
            	{
            		temp +=s.charAt(j);
            	}
            	if(temp == pattern)
            		ans.add(i);
            }
        }
        return ans;
        /*
         * in the fist for loop, if i<s.length()-p.length() it will
         * failed in this one 
         * Input: "abab", "ab"
         * Output: [0,1]
         * Expected: [0,1,2]
         * teaches me a lesson that I should consider the boundary throughly.
         * Once I modified the boundary, a new wrong answer appeared, which was another 
         * mistake I made.
         * Input: "af" "be" 
         * Output:  [0]  
         * Expected:  []
         * a is 97, b 98 c 99 d 100 e 101 f 102
         * a+f == b+e == c+d 
         * so this way doesn't make sense.
         * 
         * I also wanted to use the style I learnt from the duplicate numbersII, which 
         * was to find out if there were duplicate numbers within the distance of k.
         * for(int i =0; i < nums.length;i++)
         * {
         * 		if(i>k) mySet.remove(nums[i-k-1]);
         * 		if(!mySet.add(nums[i])) return true;
         * }
         * return false;
         * 
         * int sum = 0;
         * for(int i=0;i<=s.length();i++)
         * {
         * 		if(i>p.length())
         * 			sum = ans - s.charAt(i-p.length()-1);
         * 		else if(i<p.length())
         * 			sum += s.charAt(i);
         * 		if((1+1)%p.length() ==0)
         * 		{
         * 				if(temp == pattern)
         * 					ans.add(i); 
         * 		}
         * }
         */ 
    }
 }
