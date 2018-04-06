package lc.q238.ProductofArrayExceptSelf;
/*
 * 238. Product of Array Except Self
 * Medium
 * Given an array of n integers where n > 1, nums, 
 * return an array 
 * output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		int[] tc1 = {1,2,3,4};
		for(int e: productExceptSelf2(tc1))
		{
			System.out.print(e+" ");
		}
	}
	
/*
 * Take [1,2,3,4] for example
 * original 			1					2				3			4			set temp[0] as 1
 * 1st loop forward		1					1*1				1*1*2		1*1*2*3		set right as 1
 * 2nd loop backward	1*4*1*3*2			1*1*4*3*1		1*1*2*4		1*1*2*3*1   keep updating right as right*nums[i]
 *						right = 4*1*3*2		right=4*1*3		right=4*1	right=1
 */
	
//	29.18%
	public static int[] productExceptSelf2(int[] nums)
	{
		int[] temp = new int[nums.length];
		temp[0] =1;
		for(int i =1;i<nums.length;i++)
		{
			temp[i] = temp[i-1]*nums[i-1]; 
		}
		int right = 1;
		for(int i = nums.length-1;i>=0;i--)
		{
			temp[i] = temp[i]*right;
			right = right*nums[i];
		}
		return temp;
	}
	
	/*
	 * Take [1,2,3,4] for example
	 * original					1		 2			  3		   	   4
	 * temp1(forward)			1		1*1			1*1*2		1*1*2*3
	 * temp2(backward)		1*4*3*2		1*4*3		1*4		       1
	 * result				1*4*3*2*1   1*4*3*1*1	1*4*1*1*2	1*1*2*3*1
	 *8.78%
	 */
	public static int[] productExceptSelf1(int[] nums)
	{
		int[] temp1 = new int[nums.length];
		int[] temp2 = new int[nums.length];
		temp1[0] = 1;
		temp2[nums.length-1] =1;
		
		for(int i =0;i<nums.length-1;i++)
		{
			temp1[i+1] = temp1[i]*nums[i];
		}
		for(int i = nums.length-1;i>=1;i--)
		{
			temp2[i-1] = temp2[i]*nums[i];
		}
		for(int i = 0;i<nums.length;i++)
		{
			nums[i] = temp1[i]*temp2[i];
		}
		return nums;
	}
	
//	29.18%  using division in O(n)
	public static int[] productExceptSelf(int[] nums) 
	{
		int[] result = new int[nums.length];
		int countZero = 0;
		int product = 1;

		for(int i = 0;i<nums.length;i++)
        {
        	if(nums[i]==0)
        	{
        		countZero++;
        		continue;
        	}
        	product *= nums[i];
        }
        
        if(countZero==0)
        {
        	for(int i =0;i<nums.length;i++)
        	{
        		result[i] = product/nums[i];
        	}
        }else if(countZero == 1)
        {
        	for(int i =0;i<nums.length;i++)
        	{
        		if(nums[i]==0)
        			result[i] = product;
        		else
        			result[i] = 0;
        	}
        }else
        {
        	for(int i =0; i<nums.length;i++)
        	{
        		result[i] = 0;
        	}
        }
        return result;
    }	

}
