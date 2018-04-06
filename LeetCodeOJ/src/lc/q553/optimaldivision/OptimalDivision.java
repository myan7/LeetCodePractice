package lc.q553.optimaldivision;

/*
 * 553. Optimal Division
 * Given a list of positive integers, the adjacent integers will perform the float division. 
 * For example, [2,3,4] -> 2 / 3 / 4.
 * 
 * However, you can add any number of parenthesis at any position to change the priority of operations. 
 * You should find out how to add parenthesis to get the maximum result, 
 * and return the corresponding expression in string format. 
 * Your expression should NOT contain redundant parenthesis.

Example:
Input: [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation:
1000/(100/10/2) = 1000/([100/10]/2) = 200
However, the [] in "1000/([100/10]/2)" are redundant, 
since they don't influence the operation priority. So you should return "1000/(100/10/2)". 

Other cases:
1000/(100/10)/2 = 50
1000/(100/(10/2)) = 50
1000/100/10/2 = 0.5
1000/100/(10/2) = 2

 * Note: 
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 */

public class OptimalDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String optimalDivision(int[] nums) 
	{
//		double x = 0.0;
//        for(int i =2; i< nums.length;i++)
//        {
//        	x = (double)nums[1]/nums[i];
//        }
//        x = (double)nums[0]/x;
        StringBuffer sb = new StringBuffer();
        if(nums.length ==1)
        	return Integer.toString(nums[0]);
        if(nums.length==2)
        {
        	return nums[0]+"/"+nums[1];
        }
        else
        {
        	sb.append(nums[0]);
            sb.append('/');
            sb.append('(');
            for(int i = 1;i<nums.length-1;i++)
            {
            	sb.append(nums[i]);
            	sb.append('/');
            }
            sb.append(nums[nums.length-1]);
            sb.append(')');
            
            return sb.toString();
        }
    }

//	this is the best method more efficient using StringBuffer
	public static String optimalDivision1(int[] nums)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(nums[0]);
		for(int i =1;i<nums.length;i++)
		{
			if(i==1 && nums.length>2)
			{
				sb.append("/(").append(nums[i]);
			}else
			{
				sb.append("/").append(nums[i]);
			}
		}
		return nums.length>2 ? sb.append(")").toString() : sb.toString(); 
	}

	
//	in Java 1.8 String can be appended using "+" but it is not as efficient as StringBuffer
	public static String optimalDivision2(int[] nums)
	{
		String ans = "";
		ans = ans+nums[0];
		for(int i = 1; i<nums.length;i++)
		{
			if(i==1 && nums.length>2)
			{
				ans = ans+"/("+ nums[i];
			}
			else
			{
				ans = ans +"/" + nums[i];
			}
		}
		
		return nums.length>2? ans+")" : ans;
	}
}
