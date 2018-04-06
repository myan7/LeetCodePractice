package lc.q670.MaximumSwap;
/*
 * 670. Maximum Swap
 * Medium
 * Given a non-negative integer, 
 * you could swap two digits at most once to get the maximum valued number. 
 * Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 10^8]
 * 
 */
public class MaximumSwap {

	public static void main(String[] args) {
		int tc1 = 2736;
		int tc2 = 9973;
		int tc100 = 99991999;
		System.out.println(maximumSwap2(tc100));
	}
	
//	58.71%
/*
 * The algorithm of this method is pretty smart.
 * it first transform the given integer to char array to keep a record of the original sequence.
 * then it instantiate a 0~9 int array called buckets, in order to store the index of the digits.
 * for example: 2736 
 * digits = {'2','7','3','6'};
 * 			  0,  1,  2,  3
 * buckets = {0,0,0,2,0,0,3,1,0,0} 
// * 		  0,1,2,3,4,5,6,7,8,9
 * which means the digit 2 is on position 0, 
 * the digit 7 is on position 1, 3 is on position 2, 6 is on position 3,
 * buckets[2] = 0;buckets[7] = 1; buckets[3] = 2; buckets[6] = 3
 * the largest number of this sequence within one swap is 
 * buckets[7] = 0, digits
 * everything is stored, now it it time to find out whether it is the largest number.
 * in the outer for loop, i keeps track of the index in digits
 * in the inner for loop, k keeps track of the index of the buckets.
 * 
 */
	public static int maximumSwap1(int num) {
	       char[] digits = Integer.toString(num).toCharArray();
	        int[] buckets = new int[10];
	        for (int i = 0; i < digits.length; i++) {
	            buckets[digits[i] - '0'] = i;
	        }
	        
	        for (int i = 0; i < digits.length; i++) {
	            for (int k = 9; k > digits[i] - '0'; k--) {
	                if (buckets[k] > i) {
	                    char tmp = digits[i];
	                    digits[i] = digits[buckets[k]];
	                    digits[buckets[k]] = tmp;
	                    return Integer.valueOf(new String(digits));
	                }
	            }
	        }
	        
	        return num;
		}
//	4.36%
	public static int maximumSwap(int num) 
	{
		String numStr = Integer.toString(num);
		int len = numStr.length();
        int[] numArr = new int[numStr.length()];
        int[] temp = new int[numStr.length()];
        int a = Integer.MIN_VALUE; int b =Integer.MIN_VALUE;
        for(int i = 0;i<numStr.length();i++)
        {
        	numArr[i] = numStr.charAt(i)-'0';
        	temp[i] = numStr.charAt(i)-'0';
        }
        for(int e: numArr)
        {
        	System.out.print(e+" ");
        }
        System.out.println();
        sort(temp);
        for(int e: temp)
        {
        	System.out.print(e+" ");
        }
        System.out.println();
        for(int i =0;i<len;i++)
        {
        	if(numArr[i] != temp[i])
        	{
        		a = i;
        		break;
        	}
        }
        if(a == Integer.MIN_VALUE)
        {
        	return num;
        }
        for(int i =0;i<len;i++)
        {
        	if(numArr[i] == temp[a])
        	{
        		b=i;
        	}
        }
        swap(numArr,a,b);
        int ans = 0;
       
        	for(int i =len-1;i>=0;i--)
        	{
        		ans += numArr[i]*Math.pow(10, len-1-i);
        	}
        
        return ans;
        
       
        	
    }
	private static void swap(int[] numArr,int a, int b)
	{
		numArr[a] = numArr[a]^numArr[b];
		numArr[b] = numArr[a]^numArr[b];
		numArr[a] = numArr[a]^numArr[b];
	}
	private static void sort(int[] numArr)
	{
		for(int i =0;i<numArr.length;i++)
		{
			for(int j = i;j<numArr.length;j++)
			{
				if(numArr[j]>numArr[i])
				{
					swap(numArr,i,j);
				}
			}
		}
	}
	
	
//	89.2%  Tengyue's code
	public static int maximumSwap2(int num)
	{
		int len = (int)Math.log10((double)(num))+1;
		int[] nums = new int[len];
		for(int i = len-1;i>=0;i--)
		{
			nums[i] = num%10;
			num = num/10;
		}
		boolean swap = true;
		int index = 0; // start from 0, find the max digit from this position
		
		while(swap && index<nums.length)
		{
			int max = findMax(nums,index);
			if(nums[index] == max)
			{
				index++;
			}else
			{
				for(int i = nums.length-1; i>=index;i--)
				{
					if(nums[i] == max)
					{
						int tmp = nums[index];
						nums[index] = max;
						nums[i] = tmp;
						swap = false;
					}
				}
			}
		}
		int ans = 0;
	       
    	for(int i =0;i<nums.length;i++)
    	{
    		ans = ans*10+ nums[i];
    	}
    
    return ans;
		
		
	}
	private static int findMax(int[] nums, int beg)
	{
		int max = nums[beg];
		for(int i = beg; i<nums.length;i++)
		{
			max = Math.max(nums[i], max);
		}
		return max;
	}
	
	

}
