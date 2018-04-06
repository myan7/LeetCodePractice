package lc.q38.countAndSay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
 * 
 */
public class CountAndSaySolution {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n=11;
		System.out.println(countAndSay1(n));
	}

//	This is the answer copied from the discussion board, which is still need to study.
	public static String countAndSay(int n)
	{
		StringBuilder curr=new StringBuilder("1");
    	StringBuilder prev;
    	int count;
    	char say;
        for (int i=1;i<n;i++){
        	prev=curr;
 	        curr=new StringBuilder();       
 	        count=1;
 	        say=prev.charAt(0);
 	        
 	        for (int j=1,len=prev.length();j<len;j++){
 	        	if (prev.charAt(j)!=say){
 	        		curr.append(count).append(say);
 	        		count=1;
 	        		say=prev.charAt(j);
 	        	}
 	        	else count++;
 	        }
 	        curr.append(count).append(say);
        }	       	        
        return curr.toString();
	}
	
	
	
	
//	This is not gonna work, after 5, which should be 111221 but I output 3121.
	public static String countAndSay1(int n) 
	{
		String ans = "1";
		if(n==Integer.parseInt(ans))
		{
			return "1";
		}
		else
		{
			int i =0;
			while(i<n-1)
			{
				ans = say(Integer.parseInt(ans));
				System.out.println("when i = "+ i+ " ans is "+ans);
				i++;
			}
			return ans;
		}
	}
	
// I spent two days on this one but finally I found I misunderstood the problem.
//	They ask me to find the nth number in that count-and-say sequence
//	1,11,21,1211,111221,312211,...
//	what I did is to tell you how many numbers in the parameter you pass into the method.
//	for example, 111123 is 411213 four ones,one two, and one three.
	public static String say(int n) 
	{
		String[] nums = Integer.toString(n).split("");
//		System.out.println("This is the String[]");
//		for(String str:nums)
//		{
//			System.out.print(str+" ");
//		}
//		System.out.println();
		
		int[] numsInt = new int[nums.length];
		
		Set<Integer> mySet = new HashSet<Integer>();
		ArrayList<Integer> aList = new ArrayList<Integer>();
		Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
		for(int i = 0;i<nums.length; i++)
		{
			numsInt[i] = Integer.parseInt(nums[i]);
		}
//		System.out.println("This is the int[]");
//		for(int e: numsInt)
//		{
//			System.out.print(e+" ");
//		}
//		System.out.println();
		
		for(int e:numsInt)
		{
			if(mySet.add(e))
			{
				aList.add(e); // maintain the sequence.
				maps.put(e, 0); // just to initialize the map.
			}
			
		}
		
//		System.out.println("This is mySet");
//		for(int val: mySet)
//		{
//			System.out.print(val+ " ");
//		}
//		System.out.println();
		// this is to make sure we can know how many different numbers in the array.
		
		
		
		for(int e:numsInt)
		{
			int count = 0;
			if(mySet.contains(e))
			{
//				System.out.println("maps.get(e) is "+maps.get(e));
				count = maps.get(e);
				maps.put(e, ++count);
//				Notice you need to use ++count to make it increase. 
//				count++ will not do the job because every time it enters the loop
//				count is given a value extracted from maps.
			}
		}
		
		StringBuilder ans = new StringBuilder();
		for(int val: aList)
		{
			ans.append(maps.get(val).toString()+Integer.toString(val));
		}
		
		return ans.toString();
    }

}
