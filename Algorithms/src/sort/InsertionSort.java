package sort;

public class InsertionSort {

	public static void main(String[] args) 
	{
		int[] nums = {9,7,6,15,16,5,10,11};
		
		display(insertionSort2(nums));
	}
	
	public static int[] insertionSort2(int[] nums)
	{
		for(int i =1; i<nums.length;i++)
		{ 
			int j = i-1;
			int key = nums[i];
			while(j>-1 && key<nums[j])
			{
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = key;
		}
		return nums;
	}

	public static int[] insertionSort(int[] nums)
	{
		int count = 0;
		for(int i = 1;i<nums.length;i++)
		{
			for(int j = 0;j<i;j++)
			{
				if(nums[i]<nums[j])
				{
					swap(nums,i,j);
					count++;
				}
			}
			display(nums);
		}
		System.out.println("count = "+ count);
		return nums;
	}
	
	public static int[] insertionSort1(int[] nums)
	{
		int count =0;
		for(int i =0;i<nums.length;i++)
		{
			int key = nums[i];
			int j = i-1;
			while(j>=0 && nums[j]>key)
			{
				nums[j+1] = nums[j];
				j--;
				count++;
			}
			nums[j+1] = key;
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
		for(int i : nums)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
