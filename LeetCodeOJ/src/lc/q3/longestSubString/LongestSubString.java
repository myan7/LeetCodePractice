package lc.q3.longestSubString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "abcabcbb";
		int answer = sol.lengthOfLongestSubstring(s);
		System.out.print(answer);// wrong answer
		
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstring1(s));
		System.out.println(lengthOfLongestSubstring2(s));
	}

	
//	10.93%
	public static int lengthOfLongestSubstring(String s) 
	{
		char[] chArr = s.toCharArray();
		int max = 0;
		for(int i =0;i<chArr.length;i++)
		{
			int j =i;
			Set<Character> set = new HashSet<>();
			while(j<chArr.length && set.add(chArr[j]))
			{
				j++;
			}
			max = Math.max(max, set.size());
		}
		return max;
	}
	
//	34%  basic sliding window
	public static int lengthOfLongestSubstring1(String s) 
	{
		Set<Character> set = new HashSet<>();
		int max = 0, i=0,j=0;
		while(i<s.length() && j<s.length())
		{
			if(!set.contains(s.charAt(j)))
			{
				set.add(s.charAt(j));
				max = Math.max(set.size(), max);
				j++;
			}else
			{
				set.remove(s.charAt(i));
				i++;
			}
		}
		return max;
	}
	
	
//	38.86%
	public static int lengthOfLongestSubstring2(String s) 
	{
		int max = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i =0, j=0; i<s.length() && j<s.length();i++)
		{
			if(map.containsKey(s.charAt(i)))
			{
				j = Math.max(map.get(s.charAt(i)), j); 
			}
			max = Math.max(max, i-j);
			map.put(s.charAt(i), i);
		}
		return max;
	}
	
	
//	98.31%
	public int lengthOfLongestSubstring3(String s) {
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
	
	
}
