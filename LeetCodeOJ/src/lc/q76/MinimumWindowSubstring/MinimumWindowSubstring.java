package lc.q76.MinimumWindowSubstring;
/*
 * 76. Minimum Window Substring
 * Hard
 * Given a string S and a string T, 
 * find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, 
return the empty string "".

If there are multiple such windows, 
you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) 
	{
		String s1 = "ABC";
		String t1 = "C";
		String s2 = "ADOBECODEBANC";
		String t2 = "ABC";
		System.out.println(minWindow(s2,t2));

	}
	
//	90.50%
//	1. Use two pointers: start and end to represent a window.
//	2. Move end to find a valid window.
//	3. When a valid window is found, move start to find a smaller window.
    public static String minWindow(String s, String t) 
    {
       String ans = "";
       int[] ascii = new int[128]; // fill the ascii, 
       for(char e: t.toCharArray())
       {
    	   ascii[e]++; // letters in String T contribute positive value to the ascii array
       }
       
       int counter = t.length(), begin = 0, end = 0,minLen = Integer.MAX_VALUE, head = 0;
//     we need to keep track of the letter left in t, where it starts and where it end.
       while(end<s.length())
       {
    	   if(ascii[s.charAt(end)]>0) 
    	   {
    		   counter--; // find one letter from String t in String s, counter--,
    	   }
    	   ascii[s.charAt(end)]--; // letters in String S contribute negative value to the ascii array
		   end++; // keep moving end to the last index of String s. 
		   // end index records the last index of the possible window.
    		  
/*
 *  once the letters in t are all traversed, counter should be zero, and we have found a possible window
 *  the while loop below is to update the begin index of the window
 *  while ascii[char] is above 0, which means a letter in string T is found in string S
 *  then counter++ and letters in String S 
 *  after a possible window is found now contribute positive values to ascii
 *  while traverse each letter in String, update the length of minimum window. 
 *  
 */
    	   while(counter ==0)  
    	   {                  
    		   if(end - begin < minLen)
    		   {
    			   head = begin;
    			   minLen = end-begin;
    		   }
    		   
    		   ascii[s.charAt(begin)]++;
    		   if(ascii[s.charAt(begin)]>0)
    		   {
    			   counter++;
    		   }
    		   begin++;
    	   }
       }
       
       if(minLen != Integer.MAX_VALUE)
    	   ans = s.substring(head, head+minLen);
       return ans;
    }
}
