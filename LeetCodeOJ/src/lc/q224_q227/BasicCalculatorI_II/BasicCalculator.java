package lc.q224_q227.BasicCalculatorI_II;

import java.util.Stack;

/*
 * 224. Basic Calculator
 * Hard
 * Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
 */
public class BasicCalculator {

	public static void main(String[] args) 
	{
		String tc1 = "1+2+3-(4+5)+6+7";
		System.out.println(calculate(tc1));

	}
	
	public static int calculate(String s) 
	{
		Stack<Integer> st = new Stack<Integer>();
		int result = 0;
		int number = 0;
		int sign = 1;
		for(int i = 0;i<s.length();i++)
		{
			char ch = s.charAt(i);
			if(Character.isDigit(ch))
			{
				number = 10*number + Integer.parseInt(ch+"");
			}
			else if(s.charAt(i)=='(')
			{
				st.push(result);
				st.push(sign);
				result = 0;
				sign = 1;
			}
			else if(s.charAt(i)=='+')
			{
				result += sign*number;
				number = 0;
				sign = 1;
			}
			else if(s.charAt(i)=='-')
			{
				result += sign*number;
				number = 0;
				sign = -1;
			}else if(s.charAt(i)==')')
			{
				result +=sign*number;
				number =0;
				result*=st.pop();
				result+=st.pop();
			}
		}
		if(number !=0) result += sign*number;
		return result;
	}
}
