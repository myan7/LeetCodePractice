package lc.q283.moveZeroes;

public class MZSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArr = {0,1,0,3,0,12,0,5,4,2,0,0,13,12};
		
		
		System.out.println(2^2);
	
		
		System.out.println("This is a test for moving zeros in an array.");
		System.out.println("The original array is: ");
		for(int e:intArr)
			System.out.print(e+" ");
		System.out.println();
		System.out.println("After the methods, the int array becomes:");
//		long starTime = System.currentTimeMillis();
//		System.out.println(starTime +"ms");
		moveZeros4(intArr);
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime +"ms");
//		
		for(int e: intArr)
			System.out.print(e+" ");
		System.out.println();
	}

	public static void moveZeros(int[] nums) {
		for(int i =0;i<nums.length;i++)
		{
			for(int j = i; j< nums.length;j++)
			{
				if(nums[i]==0 && nums[j]!=0)
					swap(nums,i,j);
			}
		}
	}
	
	public static void swap(int[] nums,int a,int b)
	{
		nums[a] = nums[a]^nums[b];
		nums[b] = nums[b]^nums[a];
		nums[a] = nums[b]^nums[a];
	}
	
	
//	method 2 is much better than the first one, 
//	no need to make a copy of the array or swap elements in it
//	what you need to do is to find out how many nonzero elements in it
//	and paste them from the beginning of the array
//	once finishing copying the nonzero elements, the rest are all zero elements. 
	public static void moveZeros2(int[] nums) 
	{
		int nonZero = 0;
		for(int i = 0;i <nums.length;i++)
		{
			if(nums[i]!=0)
			{
				nums[nonZero] = nums[i];
				nonZero++;
			}
		}
		int zero = nonZero+1;
		for(int i= zero; i<nums.length;i++)
		{
			nums[i]=0;
		}
	}
	
	public static void moveZeros3(int[] nums)
	{
		if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) 
	    {
	        if (num != 0) 
	        	nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
	
	public static void moveZeros4(int[] nums)
	{
		int j =0;
		for(int i=0;i<nums.length;i++)
		{
			if(nums[i]!=0)
			{
				nums[j]=nums[i]^nums[j];
				nums[i]=nums[j]^nums[i];
				nums[j]=nums[i]^nums[j];
				j++;
			}
		}
	}
}