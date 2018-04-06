package lc.q290.isomorphicWordPattern;

import java.util.HashMap;
import java.util.Map;

/*
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, 
such that there is a bijection between a letter in pattern 
and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, 
and str contains lowercase letters separated by a single space.
 * 
 */


public class WordPatternSolution {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	
//	3ms for 33 test cases my naive method.
	public static boolean wordPattern(String pattern, String str) 
	{
        boolean ans = true;
        Map<Character, Integer> pMap = new HashMap<Character,Integer>();
        Map<String, Integer> strMap = new HashMap<String,Integer>();
//      give them a common measurement to match, integer.
//      pattern map can use character as key, 
//      and the times it appears in the pattern as value for that key
        String[] strArray = str.split(" ");    
        
//      String map can use string as key, but split first
//      and the times a specific string appears in that string works as value.
        
        int pValue = 0;
        int strValue = 0;
        if(pattern.length() != strArray.length)
        {
        	ans = false;
        }        
        else
        {
        	if(pattern.length()==0)
        	{
        		ans = true;
        	}
        	else
        	{
        		for(char e:pattern.toCharArray())
                {
                	pMap.put(e, pValue++); 
                	// put the key-value pair into the pattern map,
                	// if a key appears a second time, 
                	// the put method will replace the existing pair with the new one. 
                }
                
                for(String e: strArray)
                {
                	// put the key-value pair into the String map,
                	// if a key appears a second time, 
                	// the put method will replace the existing pair with the new one. 
                	strMap.put(e, strValue++);
                }
                
                int[] p_array = new int[pattern.length()];
                int[] str_array = new int[strArray.length];
//              transfer the pattern and String pattern to something with the same metric.
                
                int pIndex = 0;
                int sIndex = 0;
                for(char e: pattern.toCharArray())
                {
                	if(pMap.containsKey(e)) 
                	{
                		p_array[pIndex++] = pMap.get(e);
                	}
                }
                
                for(String e: strArray)
                {
                	if(strMap.containsKey(e))
                	{
                		str_array[sIndex++] = strMap.get(e);
                	}
                }
                
                for(int i =0;i<pattern.length();i++)
                {
                	if(p_array[i]!=str_array[i])
                		ans = false;
                }
        	}
        }
        return ans;
    }

//	same principle as above, and also 3ms for 33 test cases.
	public static boolean wordPattern1(String pattern, String str)
	{
		String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}

}


