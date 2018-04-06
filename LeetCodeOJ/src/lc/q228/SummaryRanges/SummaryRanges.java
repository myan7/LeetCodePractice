package lc.q228.SummaryRanges;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 228. Summary Ranges
 * Medium
 * Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:
Input: [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Example 2:
Input: [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
 * 
 * 
 */
public class SummaryRanges {

	public static void main(String[] args) 
	{
		int[] tc1 = {0,1,2,4,5,7};
		int[] tc2 = {0,2,3,4,6,8,9};
		int[] tc21 = {1,3};
		int[] tc14 = {0,2,3,4,6,8,9};
		List<String> ans = summaryRanges(tc14);
		Iterator<String> it = ans.iterator();
		while(it.hasNext())
		{
			Object e = it.next();
			System.out.println(e);
		}
	}
	public static List<String> summaryRanges1(int[] nums)
	{
		 List<String> result = new ArrayList<>();
	        if(nums == null || nums.length == 0){
	            return result;
	        }
	        
	        if(nums.length == 1){
	            result.add(nums[0] + "");
	            return result;
	        }
	        for(int i = 0; i < nums.length; i++){
	            int start = nums[i];
	            while(i + 1 < nums.length && nums[i+1] - nums[i] == 1){
	                i++;
	            }
	            if(start != nums[i]){
	                result.add(start + "->" + nums[i]);
	            } else {
	                result.add(start + "");
	            }
	        }
	        
	        return result;
	}
	//	5%
	 public static List<String> summaryRanges(int[] nums) 
	 {
//		 notice if you want to use two pointers, keep track of one pointer and make sure 
//		 cover all the elements in the array.
		 List<String> ans = new ArrayList<>();
	     if(nums.length ==0 || nums==null)
	     {
	        	return ans;
	     }
         if(nums.length ==1)
         {
             ans.add(nums[0]+"");
             return ans;
         }
	        int beg = 0, end = 1;
	     while(beg<nums.length-1)
	     {
	       	end = beg+1;
	       	if(nums[end]-nums[beg] !=1)
	       	{
	       		ans.add(nums[beg]+"");
	       		if(end == nums.length-1)
	       		{
	       			ans.add(nums[end]+"");
	       		}
	       			beg++;
	        }
	        if(nums[end]-nums[beg] == 1)
	        {
	        	int distance = 1;
	        	while(end<nums.length && nums[end]-nums[beg]==distance)
		       	{
		       		end++;
		       		distance++;
		       	}
	        	ans.add(nums[beg]+"->"+nums[end-1]);
	        	beg = end;
	        	if(beg == nums.length-1)
	        	{
	        		ans.add(nums[end]+"");
		       		beg++;
	        	}
	        		distance =1;
	        }	
	      }
	        return ans;
	 }
}
