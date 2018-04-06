package lc.q473.MatchstickstoSquare;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 473. Matchsticks to Square
 * Medium
 * Remember the story of Little Match Girl? 
 * By now, you know exactly what matchsticks the little match girl has, 
 * please find out a way you can make one square by using up all those matchsticks. 
 * You should not break any stick, but you can link them up, 
 * and each matchstick must be used exactly one time.

Your input will be several matchsticks the girl has, 
represented with their stick length. 
Your output will either be true or false, 
to represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true

Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: [3,3,3,3,4]
Output: false

Explanation: You cannot find a way to form a square with all the matchsticks.
Note:
The length sum of the given matchsticks is in the range of 0 to 10^9.
The length of the given matchstick array will not exceed 15.
 * 
 */
public class MatchstickstoSquare {

	public static void main(String[] args) 
	{
		int[] tc = {5,1,3,3,3,5};
		int[] tc2 = {1,1,1,1,1,2,3,5,5,5,5,5,5};
		int[] tc133 = {5,5,5,5,4,4,4,4,3,3,3,3};
		System.out.println(makesquare(tc133));
	}
	
	public static boolean makesquare(int[] nums) 
	{
		int sum = 0;
		for(int e: nums)
		{
			sum +=e;
		}
//		pre-exam: if the length of nums is less than 4, or sum of all elements cannot be divided by 4.
		if(nums.length<4 || (sum!=0 && sum%4 !=0))
			return false;
		
		Arrays.sort(nums);
		int edge = sum/4;
		
		int max = nums[nums.length-1];
		if(max>edge)
			return false;
		
		Map<Integer,Integer> myMap = new HashMap<>();
		for(int e:nums)
		{
			if(myMap.containsKey(e))
			{
				myMap.put(e, myMap.get(e)+1);
			}else
			{
				myMap.put(e, 1);
			}
		}
		
//		int count = 0;
//		count how many max's in the original array.
//		for(int i =0;i<nums.length;i++)
//		{
//			if(nums[i]==max)
//				count++;
//		}
		
		int beg = 0;
		int end = nums.length-1;
		int edgeCount = 4;
		while(beg<end && edgeCount>0)
		{
			int edgeLen = nums[beg]+nums[end];
			if(edgeLen==edge)
			{
				beg++;
				end--;
				edgeCount--;
			}else if(edgeLen<edge)
			{
				do
				{
					beg++;
					edgeLen = edgeLen+nums[beg];
				}
				while(edgeLen<edge);
				if(edgeLen == edge)
				{
					beg++;
					end--;
					edgeCount--;
				}
			}else if(edgeLen>edge)
			{
				if(nums[end]==edge)
				{
					end--;
					edgeCount--;
				}else
					return false;
			}
		}
		if(beg == end+1 && edgeCount ==0)
			return true;
		else
			return false;
		
    }
	
//	88.23%
	public static boolean makesquare1(int[] nums)
	{
		if (nums.length < 4) return false;
        
	    int perimeter = 0;
	    for (int ele : nums) perimeter += ele;
	    if (perimeter % 4 != 0) return false;
	        
	    Arrays.sort(nums);
	    int side = perimeter / 4;
	        
	    for (int i = 0; i < 3; i++) {
	        if (!makesquareSub(nums, nums.length - 1, side, new HashSet<>())) return false;
	    }
	    
	    return true;
	}
	    
	private static boolean makesquareSub(int[] nums, int i, int sum, Set<Integer> set) {
	    if (sum == 0) return true;
	    if (set.contains(sum) || i < 0) return false;
	    
	    if (nums[i] > 0 && nums[i] <= sum) {
	        nums[i] = -nums[i];
	        if (makesquareSub(nums, i - 1, sum + nums[i], set)) return true;
	        nums[i] = -nums[i];
	    }
	        
	    if (makesquareSub(nums, i - 1, sum, set)) return true;
	        
	    set.add(sum);
	    return false;
	}
	
//	65.28%
	public boolean makesquare3(int[] nums) 
	{
	       
		if (nums.length < 4) return false;
        
	    int perimeter = 0;
	    for (int ele : nums) perimeter += ele;
	    if (perimeter % 4 != 0) return false;
	        
	    Arrays.sort(nums);
	    int side = perimeter / 4;
	
	    return makesquareSub(nums, nums.length - 1, new int[] {side, side, side, side});
}
    
	private boolean makesquareSub(int[] nums, int i, int[] s) 
	{
	    if (i < 0) return s[0] == 0 && s[1] == 0 && s[2] == 0 && s[3] == 0;
	        
	    for (int j = 0; j < s.length; j++) {
	        if (nums[i] > s[j]) continue;
	        s[j] -= nums[i];
	        if (makesquareSub(nums, i - 1, s)) return true;
	        s[j] += nums[i];
	    }
	        
	    return false;
		
    }
}
