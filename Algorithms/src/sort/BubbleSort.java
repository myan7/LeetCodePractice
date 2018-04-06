package sort;

public class BubbleSort {

	public static void main(String[] args) {

		int[] nums = {9,7,6,15,16,5,10,11};
		display(bubbleSort(nums));
	}
	
	public static int[] bubbleSort(int[] nums)
	{
		int count =0;
		for(int i =nums.length-1;i>-1;i--)  // keep the largest element at the end
		{
			for(int j = 1;j<=i;j++) // find the largest element in the remains
			{
				if(nums[j-1]>nums[j])
				{
					swap(nums, j-1, j);
					count++;
				}
					
			}
			display(nums);
		}
		System.out.println("count = "+ count);
		return nums;
	}
	
	public static void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void display(int[] nums)
	{
		for(int  i : nums)
			System.out.print(i+ " ");
		System.out.println();
	}

}
