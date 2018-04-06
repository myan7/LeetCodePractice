package lc.q15_q16._3Sum_3SumClosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * 15. 3Sum
 * Medium
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 * 
 */
public class _3Sum {

	public static void main(String[] args) 
	{
		int[] tc1 = {-1,0,1,2,-1,-4};
		int[] tc52 = {-1,0,1,2,-1,-4};
		int[] tc59 = {0,0,0,0}; // expected: [[0,0,0]]
		List<List<Integer>> ans = threeSum(tc52);
			System.out.println(Arrays.asList(ans));
	}
	
//	91.60%
	public List<List<Integer>> threeSum1(int[] nums) {
	     Arrays.sort(nums);
	     List<List<Integer>> res=new ArrayList<List<Integer>>();
	     for(int i=0; i<=nums.length-3; i++)
	     {  
	    	 if(i>0 && nums[i]==nums[i-1]) 
	    		 continue;
	    	 int left=i+1, right=nums.length-1;
	    	 while(left<right)
	    	 {
	            if(nums[left]+nums[right]+nums[i]>0) 
	            	right--;
	            else if (nums[left]+nums[right]+nums[i]<0) 
	            	left++;
	            else
	            {
	                List<Integer> tmp=new ArrayList<Integer>();
	                tmp.add(nums[i]);
	                tmp.add(nums[left]);
	                tmp.add(nums[right]);
	                res.add(tmp);
	                left++;
	                right--;
	                while(left<right && nums[left]==nums[left-1]) left++;
	                while(left<right && nums[right]==nums[right+1]) right--;
	            }
	    	 }  
	     }
	        return res;
	    }
	
	public static List<List<Integer>> threeSum(int[] nums) 
	{
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		for(int i =0;i<nums.length-2;i++)
		{
			if(i==0 || (i>0 && nums[i] != nums[i-1])) 
	        {
				int low = i+1,high = nums.length-1,sum = 0-nums[i];
				while(low<high)
				{
					if(nums[low]+ nums[high] == sum)
					{
						ans.add(Arrays.asList(nums[i],nums[low],nums[high]));
						while(low<high && nums[low]==nums[low+1])
							low++;
	                    while(low<high && nums[high]==nums[high-1]) 
	                    	high--; // these two while loops remove the duplicates
	                    low++;
	                    high--;
	                }
	                else if(nums[low]+ nums[high]<sum)
	                    low++;
	                else
	                    high--;
	            }
	        }
		}
			return ans;
    }
}

