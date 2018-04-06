package lc.q205.isomorphicStrings;

import java.util.HashMap;
import java.util.Map;

/*
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
 * 
 * 
 */
public class IsomorphicStringsSolution 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s = "egd";
		String t = "add";
		System.out.println(isIsomorphic1(s, t));

	}
//	my naive method, 23 ms 30 test cases. using hashmap.
	private static boolean isIsomorphic(String s, String t) 
	{
		boolean value = false;
        if(s.length()==t.length()) // if the length of both strings are equal
        {
            if(s.length()!=0) // if neither of their length is zero
            {
                int countS = 0; // count works as the value in the map
                int countT = 0; // while charAt(i) works as key in the map.
                Map<Character,Integer> mapS = new HashMap<Character,Integer>();
                Map<Character,Integer> mapT = new HashMap<Character,Integer>();

                for(char ch: s.toCharArray())
                {
                	mapS.put(ch, countS++); // map will replace duplicate key-value pair if the same key was put into the map.
                }
	            for(char ch:t.toCharArray())
	            {
	            	mapT.put(ch, countT++);
	            }
	            
	            int[] patternS = new int[s.length()]; //instantiate a pattern int array to store the value in each map respectively
	            int[] patternT = new int[t.length()];
	            for(int i =0;i<s.length();i++)
                {
            	    patternS[i]=mapS.get(s.charAt(i)); // store the value of key appears in the String at position i as the pattern[i] 
            	    patternT[i]=mapT.get(t.charAt(i));
            	    if(patternS[i]==patternT[i]) // if the value are equal to each other, it is good.
            			    value = true;
            		else
            		{
            			value = false; // but if there is a pair of values are not identical, break.
            			break;
            		}
                }
            }
            else
            {
                value = true;  // if both of them are empty strings, then they must be isomorphic
            }
        }        
        else // if the length of them are not equal, then they cannot be isomorphic
        	value = false;
        return value;
    }
	
	
//	11ms for 30 test cases other's answer I need to learn.
	public static boolean isIsomorphic1(String s, String t) {
        
	       int[] m = new int[512];
	    
	       for(int e:m)
	       {
	    	   System.out.print(e+" " );
	       }
	       
	       System.out.println();
	        for (int i = 0; i < s.length(); i++) 
	        {
	            if (m[s.charAt(i)] != m[t.charAt(i)+256]) 
	            {
	              	return false;
	            }
	            m[s.charAt(i)] = m[t.charAt(i)+256] = i+1;
	         }
	        return true;
	    }
}
