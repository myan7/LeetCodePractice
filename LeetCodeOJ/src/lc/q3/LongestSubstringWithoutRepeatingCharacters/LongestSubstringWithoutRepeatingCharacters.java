package lc.q3.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import lc.q58.lengthoflastword.LengthOfLastWord;

/*
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


 * 
 * 
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String tc1 = "abcabcbb";
		String tc2 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(tc1));
	}
	
//	10.72%
	public static int lengthOfLongestSubstring(String s) 
	{
		 Set<Character> mySet1  = new HashSet<Character>();
		 Set<Character> mySet2  = new HashSet<Character>();
		 int count = 0;
		 int max = 0;
		 for(int i =0; i<s.length();i++)
		 {
			 if(mySet1.add(s.charAt(i)))
			 {
				 int idx = i;
				 while(idx<s.length() && mySet2.add(s.charAt(idx)) )
				 {
					 count=mySet2.size();
					 idx++;
				 }// once the while loop is over, it means that the character in position idx repeats
				 if(count>max) // renew the max if count is larger.
						 max = count;
					 mySet1.clear();
					 mySet2.clear();
					 count=0;
				 }
			 }
		 return max;
	}
	
//	35.93%
	public static int lengthOfLongestSubstring1(String s)
	{
		int slow = 0, fast = 0, max = 0;
	    Set<Character> set = new HashSet<>();
	    
	    while (fast < s.length()) {
	        if (!set.contains(s.charAt(fast))) 
	        {
	            set.add(s.charAt(fast++));
	            max = Math.max(max, set.size()); // keep the size of the set is the largest.
	        } 
	        else 
	        {
	            set.remove(s.charAt(slow++));//remove the element of the set from the very beginning.
	        }
	    }
	    return max;
	}
	
//	9.74%  
	public static int lengthOfLongestSubstring2(String s)
	{
		Set<Character> mySet  = new HashSet<Character>();
		 int count = 0;
		 int max = 0;
		 for(int i =0; i<s.length();i++)
		 {
			 if(!mySet.contains(s.charAt(i)))
			 {
				 int idx = i;
				 while(idx<s.length() && mySet.add(s.charAt(idx)))
				 {
					 count=mySet.size();
					 idx++;
				 }
				 max = count>max? count: max;
				 mySet.clear();
				 count=0;
			 	}
		 	}
		 return max;
	}
	
//	91.67%
	public static int lengthOfLongestSubstring3(String s) {
	       // for ASCII char sequence, use this as a hashmap
		int[] map = new int[128];
	    int max = 0, j = 0;
	    char[] str = s.toCharArray();
	    int length = s.length();

	    for(int i = 0; i < length; i++) {
	        if(map[str[i]] > 0)
	            j =  Math.max(j, map[str[i]]);
	        map[str[i]] = i + 1;
	        max = Math.max(max, i - j + 1);
	    }
	    return max;
	  }
	
	
//	53.94%
	/*
	 * the basic idea is, 
	 * keep a hashmap which stores the characters in string as keys and their positions as values, 
	 * and keep two pointers which define the max substring. 
	 * move the right pointer to scan through the string , 
	 * and meanwhile update the hashmap. 
	 * 
	 * If the character is already in the hashmap, 
	 * then move the left pointer to the right of the same character last found. 
	 * Note that the two pointers can only move forward.
	 */
	public static int lengthOfLongestSubstring4(String s)
	{
		if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
	}
}
