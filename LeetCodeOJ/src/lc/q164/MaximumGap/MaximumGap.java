package lc.q164.MaximumGap;

import java.util.Arrays;
/*
 * 164. Maximum Gap
 * Hard
 * Given an unsorted array, 
 * find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Return 0 if the array contains less than 2 elements.

You may assume all elements in the array are non-negative integers 
and fit in the 32-bit signed integer range.

Credits:
 * 
 * 
 */

public class MaximumGap {

	public static void main(String[] args) {
		int[] tc1 = {10,3,7,1,5,4,2};
		int[] tc2 = {2,9999999};
		
		int[] tc3 = {10,100,1000,10000,100000,1000000};
		
		
		long start = System.currentTimeMillis();
		System.out.println(maximumGap1(tc2));
		long end = System.currentTimeMillis();
		System.out.println("method1 uses time: "+ (end - start)+ " ms");
		
		
		
		long start1	= System.currentTimeMillis();
		System.out.println(maximumGap(tc2));
		long end1	= System.currentTimeMillis();
		System.out.println("method uses time: "+ (end1 - start1)+ " ms");
		
	}
	
//	Memory limit exceed.
	public static int maximumGap(int[] nums) 
	{
      if(nums.length<2)
    	  return 0;
      int max = Integer.MIN_VALUE;
      for(int e:nums)
      {
    	  if(e>max)
    		  max = e;
      }
      int[] array = new int[max];
      for(int i = 0;i<nums.length;i++)
      {
    	  array[nums[i]-1] = nums[i]; 
      }
      
      int count = 1;
      int res = 0;
      for(int e: array)
      {
    	  if(e==0)
    	  {
    		  count++;
    		  if(count>res)
    			  res = count;
    	  }
    	  else
    	  {
    		  count = 1;
    	  }
      }
      return res;
    }
	
	public static int maximumGap1(int[] nums)
	{
		 if (nums == null || nums.length < 2)
		        return 0;
		    // get the max and min value of the array
		    int min = nums[0];
		    int max = nums[0];
//		    find min and max in one for loop.
		    for (int i:nums) {
		        min = Math.min(min, i);
		        max = Math.max(max, i);
		    }
		    // the minimum possible gap, ceiling of the integer division
		    int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
		    int[] bucketsMIN = new int[nums.length - 1]; // store the min value in that bucket
		    int[] bucketsMAX = new int[nums.length - 1]; // store the max value in that bucket
		    Arrays.fill(bucketsMIN, Integer.MAX_VALUE);
		    Arrays.fill(bucketsMAX, Integer.MIN_VALUE);
		    // put numbers into buckets
		    for (int i:nums) {
		        if (i == min || i == max)
		            continue;  //bucket sort doesn't take min and max into consideration.
		        int idx = (i - min) / gap; // index of the right position in the buckets
		        bucketsMIN[idx] = Math.min(i, bucketsMIN[idx]);
		        bucketsMAX[idx] = Math.max(i, bucketsMAX[idx]);
		    }
		    // scan the buckets for the max gap
		    int maxGap = Integer.MIN_VALUE;
		    int previous = min;
		    for (int i = 0; i < nums.length - 1; i++) {
		        if (bucketsMIN[i] == Integer.MAX_VALUE && bucketsMAX[i] == Integer.MIN_VALUE)
		            // empty bucket
		            continue;
		        // min value minus the previous value is the current gap
		        maxGap = Math.max(maxGap, bucketsMIN[i] - previous);
		        // update previous bucket value
		        previous = bucketsMAX[i];
		    }
		    maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
		    return maxGap;
	}
}
