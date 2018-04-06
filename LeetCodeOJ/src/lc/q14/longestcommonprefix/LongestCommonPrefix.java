package lc.q14.longestcommonprefix;

import java.util.Arrays;

/*
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 */

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = {"a","b"};
		System.out.println(longestCommonPrefix(strs));
	}
	
//	117 / 117 test cases passed.
//	Status: Accepted
//	Runtime: 10 ms
	public static String longestCommonPrefixAnswer01(String[] strs) 
	{
		StringBuilder result = new StringBuilder();
        
        if (strs!= null && strs.length > 0) 
// if condition "strs!= null" were removed, what would happen?
//	        117 / 117 test cases passed.
//        	Status: Accepted
//        	Runtime: 11 ms
        	
//        	if condition "strs.length>0" were removed, what would happen?
        	/*
        	 * Line char[] a = strs[0].toCharArray(): java.lang.ArrayIndexOutOfBoundsException: 0
        	 * last expected: [];
        	 */
        {
        
            Arrays.sort(strs);
            
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();
            
            for (int i = 0; i < a.length; i ++)
            {
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                   break;
                }
            }
        }
        return result.toString();
	}
	
//	117 / 117 test cases passed.
//	Status: Accepted
//	Runtime: 12 ms
	public static String longestCommonPrefix(String[] strs) 
	{
		StringBuffer sb = new StringBuffer();
		if(strs.length==0)
		{
			return "";
		}
		else if(strs.length==1)
		{
			return strs[0];
		}
		else
		{
			Arrays.sort(strs);
			String beg = strs[0];
			String end = strs[strs.length-1];
			int length = beg.length()<=end.length()? beg.length():end.length();
			for(int i =0;i<length;i++)
			{
				if(beg.charAt(i)==end.charAt(i))
				{
					sb.append(beg.charAt(i));
				}
				else
				{
					break;
				}
			}
			return sb.toString();
		}
	}
	
//	Jun-19-2017
//	public static String longestCommonPrefix0(String[] strs) 
//	{
//        StringBuffer sb = new StringBuffer();
//        int i = 0,j=0;
//        for(String e: strs)
//        {
//        	for(String s: strs)
//        	{
//        		boolean boo = true;
//            	while(boo)
//            	{
//            		char ea = e.charAt(i++);
//            		char sa = s.charAt(j++);
//            		if(ea == sa)
//            		{
//            			sb.append(ea);
//            		}else
//            			boo = false;
//            	}
//        	}
//        }
//        return sb.toString();
//    }

}
