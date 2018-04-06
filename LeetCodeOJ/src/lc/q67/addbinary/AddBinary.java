package lc.q67.addbinary;

import java.util.Stack;

/*
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 * 
 */

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String a = "0";
//		String b = "0";
//		String result = addBinary(a,b);
//		System.out.println(result);
		char a = '1';
		char b = '0';
		int c = a-b;
		System.out.println();

	}
	
	/*
	 * 294 / 294 test cases passed.
Status: Accepted
Runtime: 4 ms
	 */
	public static String addBinary3(String a, String b) {
       	StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
	
	
	public static String addBinary2(String a, String b) 
	{
		char[] chA = a.toCharArray();
		char[] chB = b.toCharArray();
		StringBuffer res = new StringBuffer();
		Stack<Integer> aST = new Stack<Integer>();
		Stack<Integer> bST = new Stack<Integer>();
		for(char e: chA)
		{
			aST.push(e-'0');
		}
		for(char e:chB)
		{
			bST.push(e-'0');
		}
		
		int carry = 0;
		
		while(!aST.isEmpty()&&!bST.isEmpty())
		{
			int aa = aST.pop();
			int bb = bST.pop();
			int sum = aa+bb+carry;
			if(sum==3)
			{
				res.append('1');
				carry =1;
			}
			else if(sum ==2)
			{
				res.append('0');
				carry = 1;
			}
			else if(sum ==1)
			{
				res.append('1');
				carry = 0;
			}
			else
			{
				res.append('0');
				carry = 0;
			}
		}
		
		while(!aST.isEmpty() && bST.isEmpty())
		{
			int aa = aST.pop();
			
			int sum = aa+carry;
			if(sum ==2)
			{
				res.append('0');
				carry = 1;
			}
			else if(sum ==1)
			{
				res.append('1');
				carry = 0;
			}
			else
			{
				res.append('0');
				carry = 0;
			}
		}
		
		while(aST.isEmpty() && !bST.isEmpty())
		{
			int bb = bST.pop();
			
			int sum = bb+carry;
			if(sum ==2)
			{
				res.append('0');
				carry = 1;
			}
			else if(sum ==1)
			{
				res.append('1');
				carry = 0;
			}
			else
			{
				res.append('0');
				carry = 0;
			}
		}
		
		if( carry == 1)
			res.append('1');
		
		return res.reverse().toString();
	}
	
//	294 / 294 test cases passed.
//	Status: Accepted
//	Runtime: 10 ms  6.84%
	public static String addBinary(String a, String b) 
	{
		char[] chA = a.toCharArray();
		char[] chB = b.toCharArray();
		StringBuffer res = new StringBuffer();
		Stack<Character> aST = new Stack<Character>();
		Stack<Character> bST = new Stack<Character>();
		int carry =0;
		
		for(char e: chA)
		{
			aST.push(e);
		}
		for(char e:chB)
		{
			bST.push(e);
		}
		
		
		while(!aST.isEmpty()&&!bST.isEmpty())
		{
			char aa = aST.pop();
			char bb = bST.pop();
			if(aa=='1'&& bb=='0'&& carry ==0)
			{
				res.append('1');
				carry =0;
			}
			else if(aa=='1'&&bb=='0'&&carry ==1)
			{
				res.append('0');
				carry =1;
			}
			else if(aa=='1'&&bb=='1'&&carry ==1)
			{
				res.append('1');
				carry =1;
			}
			else if(aa=='1'&&bb=='1'&&carry ==0)
			{
				res.append('0');
				carry =1;
			}
			else if(aa=='0'&&bb=='0'&&carry ==0)
			{
				res.append('0');
				carry =0;
			}
			else if(aa=='0'&&bb=='0'&&carry ==1)
			{
				res.append('1');
				carry =0;
			}
			else if(aa=='0'&&bb=='1'&&carry ==1)
			{
				res.append('0');
				carry =1;
			}
			else if(aa=='0'&&bb=='1'&&carry ==0)
			{
				res.append('1');
				carry =0;
			}
		}
		
		while(!aST.isEmpty()&&bST.isEmpty())
		{
			char aa = aST.pop();
			if(aa=='1' && carry ==0)
			{
				res.append('1');
				carry =0;
			}
			else if(aa=='1' && carry ==1)
			{
				res.append('0');
				carry =1;
			}
			else if(aa=='0' && carry ==0)
			{
				res.append('0');
				carry =0;
			}
			else if(aa=='0' && carry ==1)
			{
				res.append('1');
				carry =0;
			}
		}
		
		while(aST.isEmpty()&&!bST.isEmpty())
		{
			char bb = bST.pop();
			if(bb=='1' && carry ==0)
			{
				res.append('1');
				carry =0;
			}
			else if(bb=='1' && carry ==1)
			{
				res.append('0');
				carry =1;
			}
			else if(bb=='0' && carry ==0)
			{
				res.append('0');
				carry =0;
			}
			else if(bb=='0' && carry ==1)
			{
				res.append('1');
				carry =0;
			}
		}
		if( carry == 1)
			res.append('1');
		
		return res.reverse().toString();
	}
}
