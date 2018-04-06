package lc.q224_q227.BasicCalculatorI_II;

import java.util.Stack;

/*
 * Basic Calculator II   
 * Medium
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
 */
public class BasicCalculator_II {

	public static void main(String[] args) {

	}
	
	public static int calculate(String s) 
	{
		Stack<Integer> st = new Stack<Integer>();
		int number = 0;
		int sign = 1;
		int result = 0;
		for(int i =0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			if(Character.isDigit(ch))
			{
				number = 10*number+(int)(ch-'0');
			}
			if(!Character.isDigit(ch))
				return 0;
		}
		return 0;
	}

}
