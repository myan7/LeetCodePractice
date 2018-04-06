package lc.q532.KdiffPairsinanArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 532. K-diff Pairs in an Array  Easy
 * 
 * Given an array of integers and an integer k, 
 * you need to find the number of unique k-diff pairs in the array. 
 * Here a k-diff pair is defined as an integer pair (i, j), 
 * where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).

Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).

Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
 * 
 */
public class KdiffPairsinanArray {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] tc67 = {1,2,3,4,5};
		int[] tc68 = {1,1,1,2,2};
		int[] tc69 ={1,3,1,4,5};
		int k = 0;
		System.out.println(findPairs(tc69,k));

	}
	
//	32.43%
	public static int findPairs(int[] nums, int k) 
	{
        int count =0;
        if(k<0 ||nums.length<2)
        {
            return 0;
        }
		Arrays.sort(nums);
		if(k == 0)
		{
			if(nums[0]==nums[nums.length-1])
            {
               return count=1;
            }
			if(nums[0]==nums[1])
				count++;
			for(int i =2; i<nums.length;i++)
			{
				
                if(nums[i] == nums[i-1] && nums[i-2]!= nums[i] )
                    count++;
			}
		}
		else
		{
			Set<Integer> myset = new HashSet<Integer>();
	        for(int e: nums)
	        {
	        	myset.add(e);
	        }
	        // this is to remove those duplicate numbers.
	        for(int e:myset)
	        {
	        	if(myset.contains((e+k)))
	        			{
	        		count ++;
	        			}
	        }
		}
        
        return count;
    }
	
//	98.79%
	public static int findPairs1(int[] nums, int k) 
	{
		if(k<0)
		{
			return 0;
		}
		
		Arrays.sort(nums);
		
		int i =0, j=1,count=0;
		while(j<nums.length)  // make sure j is not larger than nums.length
		{
			if(nums[j]-nums[i]==k) // if the difference is k, meet the condition
			{
				while(j<nums.length && nums[j]-nums[i]==k) 
				{
					j++; // since I have already sort the array, if one element meet the condition
//					I need to see if the next one still meet the condition, for example,
//					[1,1,1,1,1,2,2], k =0; once the last '1' is traversed, jump out of the loop
				}
//				then count+1;
				count++;
			}
//			since i still stay put while j is moving towards the end
//			if the difference between nums[j] and nums[i] is larger than k, which means i needs to move
			else if(nums[j]-nums[i]>k)
			{
				i++;
				if(i ==j) 
				{
					j++;
				}
			}else
			{
				j++;
			}
		}
		return count;
	}

}
