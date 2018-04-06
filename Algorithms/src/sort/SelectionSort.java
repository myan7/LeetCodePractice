package sort;

public class SelectionSort {

	public static void main(String[] args) {

		int[] nums = {9,7,6,15,16,5,10,11};
		display(selectionSort(nums));
		
	}

	public static int[] selectionSort(int[] nums)
	{
		for(int i =0;i<nums.length;i++)
		{
			int min = nums[i];
			int index = i;
			for(int j = i+1;j<nums.length;j++)
			{
				if(nums[j]<min)
				{
					min = nums[j];
					index = j;
				}
			}
			if(min<nums[i])
			{
			nums[index] = nums[i]; 
			nums[i] = min;
			}
		}
		return nums;
	}
	
	public static void display(int[] nums)
	{
		for(int  i : nums)
			System.out.print(i+ " ");
		System.out.println();
	}
	
}
