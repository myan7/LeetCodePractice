package lc.q152.MaximumProductSubarray;
/*
 * 152. Maximum Product Subarray
 * Medium
 * Find the contiguous subarray within an array 
 * (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */
public class MaximumProductSubarray {

	public static void main(String[] args) {
		int[] tc1 = {3,-2,2,5,0,7};
		int[] tc2 = {-1,-2,-9,-6};
		System.out.println(maxProduct1(tc2));
/*		3	-2	2	5	0	7
 * max	3	-2	2	10	0	7	
 * min	3	-6	-12	-60	0	0
 * res	3	3	3	10	10	10
 */
	}
	
	public static int maxProduct(int[] nums) 
    {
		int result = nums[0];
		int min = nums[0],max = nums[0];
		
		for(int i =1;i<nums.length;i++)
		{
			if(nums[i]>=0)
			{
				max = Math.max(max*nums[i], nums[i]);
				min = Math.min(min*nums[i], nums[i]);
//				System.out.println("max = "+ max+ "; min = "+ min);
			}else
			{
				int temp = max;
				max = Math.max(min*nums[i], nums[i]);
				min = Math.min(temp*nums[i], nums[i]);
//				System.out.println("max = "+ max+ "; min = "+ min);
			}
			result = Math.max(max,result);
//			System.out.println("result = "+ result);
		}
		return result;
    }
	
	public static int maxProduct1(int[] nums)
	{
		int[] maxArr = new int[nums.length];
		int[] minArr = new int[nums.length];
		maxArr[0] = nums[0];
		minArr[0] = nums[0];
		int result = nums[0];
		for(int i = 1;i<nums.length;i++)
		{
			maxArr[i] = Math.max(Math.max(minArr[i-1]*nums[i], maxArr[i-1]*nums[i]), nums[i]);
			minArr[i] = Math.min(Math.min(minArr[i-1]*nums[i], maxArr[i-1]*nums[i]), nums[i]);
			result= Math.max(result, maxArr[i]);
//			System.out.println("max = "+ maxArr[i]+ "; min = "+ minArr[i]+"; result = "+ result);
		}
		return result;
	}

}
