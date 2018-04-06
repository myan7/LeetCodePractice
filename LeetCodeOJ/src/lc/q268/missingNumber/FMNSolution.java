package lc.q268.missingNumber;

public class FMNSolution {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,5,6,7,8,9};
		
		System.out.println(missingNumber(nums));
	}
	public static int missingNumber(int[] nums) 
	{
		
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor^i^nums[i];
		}

		return xor^i;
    }
}
