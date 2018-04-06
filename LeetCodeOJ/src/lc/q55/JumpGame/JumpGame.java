package lc.q55.JumpGame;
/*
 * 55. Jump Game  
 * Medium
 * 
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] testcase1 = {2,3,1,1,4};
		int[] testcase2 = {3,2,1,0,4};
		int[] testcase55 = {2,0};//55 / 75 test cases passed.
		int[] testcase65 = {2,0,0}; // 65 / 75 test cases passed.
		int[] testcase69 = {2,5,0,0};//69 / 75 test cases passed.
		System.out.println(canJump(testcase65));

	}
	
	/* stuck on 69/75 and I found I made a mistake.
	 * public boolean canJump(int[] nums) {
        boolean ans = false;
        int current = 0;
        int end = nums.length-1;
        if(nums.length <=1)
        	ans = true;
        else
        {
        	while(current<end && !ans && nums[current]!=0)
            {
            	current = current + nums[current];
            	if(current >=end)
            		ans = true;
            }
        }
        return ans;
    }
	 * 
	 */
	
	public static boolean canJump(int[] nums) 
	{
        boolean ans = false;
        int staIndex = 0;
        int finIndex = 0;
        int current = 0;
        int end = nums.length-1;
        if(nums.length <=1)
        	ans = true;
        else
        {
        	while(finIndex<end && !ans && nums[finIndex]!=0)
            {
        		staIndex = 
            	finIndex = staIndex + nums[staIndex];
            	for(int i =staIndex; i<=finIndex;i++)
            	{
            		if(current >=end)
                		ans = true;
            	}	
            }
        }
        return ans;
    }
	
	
//	75 / 75 test cases passed.
//	Status: Accepted
//	Runtime: 7 ms    93.17%
//	Idea is to work backwards from the last index. 
//	Keep track of the smallest index that can "jump" to the last index. 
//	Check whether the current index can jump to this smallest index.
	public static boolean canJump1(int[] nums)
	{
		int last=nums.length-1,i=0;
		for(i=nums.length-2;i>=0;i--)
		{
			if(i+nums[i]>=last)
				last=i;
		}
		return last<=0;
    }

//	75.27%
	public static boolean canJump2(int[] nums) {
	    int maxLocation = 0;
	    for(int i=0; i<nums.length; i++) {
	        if(maxLocation<i) return false; 
	        // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
	        maxLocation = (i+nums[i]) > maxLocation ? i+nums[i] : maxLocation; // greedy:
	    }
	    return true;
	}
}
