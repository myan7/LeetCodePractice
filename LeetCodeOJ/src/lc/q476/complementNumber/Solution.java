package lc.q476.complementNumber;


import java.math.*;
import java.util.Scanner;



public class Solution {

//	Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
//
//	Note:
//	The given integer is guaranteed to fit within the range of a 32-bit signed integer.
//	You could assume no leading zero bit in the integer’s binary representation.
//	Example 1:
//	Input: 5
//	Output: 2
//	Explanation: The binary representation of 5 is 101 (no leading zero bits), 
//	and its complement is 010. So you need to output 2.

	 private static Scanner kbi = new Scanner(System.in);
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please give me an integer: ");
		int userInput = kbi.nextInt();

//		Test how to use split()
//		String s = "1234";
//		String[] sArr = new String[s.length()];
//		sArr = s.split("");
//		for(String index: sArr)
//		{
//			System.out.println(index);
//		}
		
		System.out.println("The complement number of the integer you gave me is "
		+findComplement(userInput));
		
	}
	
	public static int findComplement(int num) 
    {
		int compNum = 0;
		int value = num;
		
		String valueStr = Integer.toBinaryString(value);
		
//		//transfer the integer to its binary value
//		String s = "";
//		for(int i = 0; i<32;i++)
//		{
//			if(value%2 ==1)
//			{
//				s = "1"+s;
//				value = value/2;
//			}else
//			{
//				s = "0"+s;
//				value = value/2;
//			}
//		}
		System.out.println("The number you gave me in Binary is: "+valueStr);
		
		
		// instantiate a String array to store the binary String
		String[] strArr = new String[valueStr.length()];
		strArr = valueStr.split("");
		
		int[] numBit = new int[strArr.length];
//		
//		System.out.println("This is the int version of the binary value");
//		for(int i = 0;i<strArr.length;i++)
//		{
//			numBit[i]= Integer.parseInt(strArr[i]);
//			System.out.println(numBit[i]+"the i is "+ i);
//		}
//		System.out.println();

		int[] numBitC = new int[numBit.length];
		
		for(int i = 0;i<strArr.length;i++)
		{
			if(numBit[i]==0)
			{
				numBitC[i]=1;
			}else
			{
				numBitC[i]=0;
			}
		}
		System.out.println();
		
//		System.out.println("This is after complement");
//		for(int i = 0;i<numBitC.length;i++)
//		{
//			System.out.println("when i equals "+ i+", numBitC["+i+"] is "+numBitC[i]+" ");
//		}
//
//		System.out.println("");
		
		
		// transfer binaryString to integer
		// Notice the index is not he power of 2, it is the length -i -1, 
//		I stuck on it for about an hour.
		for(int i = 0; i<numBitC.length;i++)
		{
			if(numBitC[i] !=0)
			{
				System.out.println("i = "+ i);
				System.out.println(numBitC[i]+" and "+ (numBitC.length-i-1));
				compNum += (int)(Math.pow(2.0, (double)(numBitC.length-i-1)));
			}else
			{
				compNum+=0;
			}
		}
        return compNum;
    }
	

}
