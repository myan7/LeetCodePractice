package lc.q167.twoSumII;

public class TwoSumII {

	
/*
* 167. Two Sum II - Input array is sorted
* Given an array of integers that is already sorted in ascending order, 
* find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers 
such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution 
and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
* 
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {0,0,3,4,5,6,7};	
		int[] numbers1 = {-1,0};//-1
		int[] numbers2 = {0,0,3,4};//0
		int[] combo = twoSum2(numbers2, 0);
		
		for(int e: combo)
		{
			System.out.print(e+" ");
		}
		

	}
	
	public static int[] twoSum(int[] numbers, int target) 
	{
		int[] ans = new int[2];
		int index1 = 0,index2 = 0;
        for(int i =0;i<numbers.length;i++)
        {
        	if(numbers[i]>=target)
        	{
        		index2= i;
        		break;
        	}else
        	{
        	    index2=numbers.length;
        	}
        }
        for(int i=0;i<index2;i++)
        	for(int j=index2;j>=i;j--)
        	{
        		if(numbers[i]+numbers[j]==target && i<j)
        		{
        			ans[0]=i+1;
        			System.out.print("ans[0] is "+ ans[0]+"\n");
        			ans[1]=j+1;
        			System.out.print("ans[1] is "+ ans[1]+"\n");
        			break;
        		}
        	}
        return ans;
    }
	
	
	public static int[] twoSum1(int[] numbers, int target) 
	{
        int[] ans = new int[2];
        for(int i=0;i<numbers.length;i++)
        	for(int j=0;j<numbers.length;j++)
        	{
        		if(numbers[i]+numbers[j]==target)
        		{
        			ans[0]=Math.min(i+1, j+1);
        			ans[1]=Math.max(i+1, j+1);
        			break;
        		}
        	}
        return ans;
    }
	
	public static int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        int low = 0;
        int high = numbers.length-1;
        
        while(low<high)
        {
            int sum = numbers[low]+numbers[high];
            
            if(sum>target)
            {
                high--;
                System.out.println("sum is "+ sum); 
                System.out.println("high is "+ high);
            }
            else if(sum<target)
            {
                low++;    
                System.out.println("sum is "+ sum); 
                System.out.println("low is "+ low);
            }
            else
            {
                ans[0] = low+1;
                ans[1] = high+1;
                break;
                // break is necessary here because it can stop when it finds the
                //answer.
                // also if the first two ints are the answer, while loop will be 
                // indefinite if you don't add the line break to tell java to stop.
            }
        }
        return ans;
    }

}
