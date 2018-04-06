package lc.q169_q229.MajorityElementI_II;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 229. Majority Element II
 * Medium
 * Given an integer array of size n, 
 * find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */

public class MajorityElementII {

	public static void main(String[] args) 
	{
		int[] tc0 = {};  // next time you work with array, do not forget there is an empty one possible
		int[] tc1= {1,2,3,4,4,1,1,4,2,1,2};
		int[] tc2 = {1,2};
		int[] tc3 = {1}; // what if there is only one element but your code may produce two answers?
		int[] tc65 = {1,2,2,3,2,1,1,3};  //{1,2}
		List<Integer> ans = majorityElement(tc65);
		Iterator it = ans.iterator();
		while(it.hasNext())
		{
			Object e= it.next();
			System.out.println(e);
		}
		
	}
	
//	47.59%
    public static List<Integer> majorityElement(int[] nums) 
    {
    	List<Integer> ans = new ArrayList<>();
    	if(nums.length ==0 || nums == null)
    		return ans;
    	int count1 = 0,count2 =0;
    	int num1 = nums[0],num2 = nums[0];
    	int threshold = nums.length/3;
    	for(int e: nums)
    	{
//    		The order of this if-else set is very important!!! figure out why this is the correct one.
    		if(num1 == e)
    		{
    			count1++;
    		}else if(num2 == e)
    		{
    			count2++;
    		}else if(count1 ==0)
    		{
    			num1 = e;
    			count1=1;
    		}else if(count2 == 0)
    		{
    			num2 = e;
    			count2 =1;
    		}else
    		{
    			count1--;
    			count2--;
    		}
    	}
    	count1 = 0;
    	count2 = 0;
    	for(int e: nums)
    	{
    		if(num1 ==e)
    			count1++;
    		if(num2 ==e)
    			count2++;
    	}
    	if(count1>threshold)
    	{
    		ans.add(num1);
    	}
    	if(count2>threshold && num2!=num1)
    	{
    		ans.add(num2);
    	}
    	return ans;
    }
}
