package lc.q1.TwoSum;

import java.util.HashMap;
import java.util.Map;

/*  1. Two Sum Easy
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */
public class TwoSum {

	public static void main(String[] args) {

	}
	
	public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
	
	public static int[] twoSum(int[] nums, int target) 
	{
		int[] result = new int[2];
		
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)
        {
        		map.put(nums[i], i);
        }

        /* what if [3,3], 6? the result will be 1, 1
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        
        while(iterator.hasNext())
        {
        		Integer element = iterator.next();
        		if(map.containsKey(target-element))
        		{
        			result[0]=map.get(element);
        			result[1]=map.get(target-element);
        			return result;
        		}
        }
        */
        
        for(int i =0;i<nums.length;i++)
        {
        		int complement = target-nums[i];
        		if(map.containsKey(complement) && map.get(complement) != i)
        			return new int[] {i,map.get(complement)};
        }
        return result;
    }

}
