package lc.q560.SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;
/*
 * 560. Subarray Sum Equals K
 * Medium 
 * Given an array of integers and an integer k, 
 * you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2

Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

next 523. Continuous Subarray Sum
 */

public class SubarraySumEqualsK {

	public static void main(String[] args) 
	{
		int[] tc1 = {1,1,1};
		int[] tc2 = {1,1,2,-1,-3,3,-1};
		int k2 = 2;
		int[] tc33 = {28,54,7,-70,22,65,-6};
		int k33 =100;	// expected 1;
		int[] tc60 ={0,0,0,0,0,0,0,0,0,0};
		int k60 = 0; // expected 55;
		System.out.println(subarraySum(tc2, k2));
	}
	

//	24.08%
	public static int subarraySum(int[] nums, int k) 
	{
		int len = nums.length;
		int sum = 0;
		int beg = 0;
		int end = 0;
		int count = 0;
		while(beg <len)
		{
			sum = nums[beg];
			if(sum ==k)
			{
				count++;
			}
			end = beg+1;
			while(end<len)
			{
				sum +=nums[end];
				if(sum==k)
				{
					count++;
				}
				end++;
			}
			beg++;
		}
		return count;
	}
	
//	75.20%
	public static int subarraySum1(int[] nums, int k)
	{
/*
 *we know the key to solve this problem is SUM[i, j]. 
 *So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
 *To achieve this, we just need to go through the array, 
 *calculate the current sum and save number of all seen PreSum to a HashMap. 
 *Time complexity O(n), Space complexity O(n). 
 */
		int count=0;
		Map<Integer,Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
/*
 * sum is the presum for first i+1 numbers in the array, for example, sum of first 1 number is nums[0].
preSum.put(0,1); because the sum of first 0 number is 0 and this is an empty array[], 
which is also a subarray for nums. In other words, the number of time sum = 0 exists is 1.

then we loop through the array, 
calculate the presum for first i+1 number and check if the map contains key (sum - k) , 
if it is, we increase the result by the number of (sum - k) we get from hash map.
We also need to put all sum in the map, 
that's what this line of code does: preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
 */
		// means the first 0 numbers added together whose sum is 0, and count as 1.
		// this put(0,1) can be seen as the empty array is subarray to every array.
		int sum = 0;
		for(int i = 0;i<nums.length;i++)
		{
			sum += nums[i];
			if(preSum.containsKey(sum-k))
			{
				count +=preSum.get(sum-k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
		}
        return count;
	}
	
//	86.79%
	public static int subarraySum2(int[] nums, int k) {
        //key: sum , value:number of indexes
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k){
                count++;
            }
            
            if(sumMap.containsKey(sum - k)) {
                int size = sumMap.get(sum - k);
                count += size;
            }
            
            if (sumMap.containsKey(sum)) {
                int newCount = sumMap.get(sum) + 1;
                sumMap.put(sum, newCount);
            } else {
                sumMap.put(sum, 1);
            }
        }
        return count;
    }

}
