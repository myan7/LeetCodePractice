package lc.q179.LargestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 179. Largest Number
 * Medium
 * Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 */
public class LargestNumber {

	public static void main(String[] args) 
	{
		int[] tc = {3,30,34,5,9};
		System.out.println(largestNumber(tc));
		
	}
	
//	78.30%
	public static String largestNumber(int[] nums) 
	{
		if(nums == null || nums.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[nums.length];
		for(int i = 0; i < nums.length; i++)
		    s_num[i] = String.valueOf(nums[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
		        String s2 = str2 + str1;
		        return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	        };
		
		Arrays.sort(s_num, comp);
                // An extreme corner case by lc, say you have only a bunch of 0 in your int array
                if(s_num[0].charAt(0) == '0')
                    return "0";
            
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	            sb.append(s);
		
		return sb.toString();
    }
	
//	public static String largestNumber1(int[] nums) 
//	{
//		List<Integer> myList = new ArrayList<Integer>();
//		for(int e: nums)
//		{
//			myList.add(e);
//		}
//		StringBuffer  sb = new StringBuffer();
//		Collections.sort(myList);
//		for(int e: myList)
//		{
//			sb.append(e+"");
//			System.out.println(e+" ");
//		}
//		return sb.toString();
//		
//	}
}
