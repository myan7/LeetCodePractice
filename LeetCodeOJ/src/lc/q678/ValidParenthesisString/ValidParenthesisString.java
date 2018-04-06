package lc.q678.ValidParenthesisString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 678. Valid Parenthesis String
 * Medium
 * Given a string containing only three types of characters: '(', ')' and '*', 
 * write a function to check whether this string is valid. 
 * We define the validity of a string by these rules:

	Any left parenthesis '(' must have a corresponding right parenthesis ')'.
	Any right parenthesis ')' must have a corresponding left parenthesis '('.
	Left parenthesis '(' must go before the corresponding right parenthesis ')'.
	'*' could be treated as a single right parenthesis ')' 
		or a single left parenthesis '(' 
		or an empty string.
		
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 */
public class ValidParenthesisString {

	public static void main(String[] args) 
	{
		String tc1 ="()";
		String tc2 = "(*()";
		String tc54 = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
		String tc56 = "()*()(()(*()(((())()()())*))()*()(*)(((*))(())(())((*()*(()(())()*(((*(**))((())*)(((()()))(())()))";
		System.out.println(checkValidString2(tc1));
	}
	
//	41.71%
	public static boolean checkValidString(String s) 
    {
		Stack<Character> left = new Stack<Character>();
		for(int i = 0; i< s.length();i++)
		{
			if(s.charAt(i)=='*')
				left.push('*');
			if(s.charAt(i)=='(')
				left.push('(');
			if(s.charAt(i)==')')
			{
				if(!left.isEmpty()&& left.peek()=='(')
				{
					left.pop();
				}else if(!left.isEmpty() && left.peek()=='*'&&left.contains('('))
				{
					left.remove(left.lastIndexOf('('));
				}else if(!left.isEmpty() && left.peek()=='*'&&!left.contains('('))
				{
					left.pop();
				}else
					return false;
			}
		}
		int countS = 0;
		if(left.isEmpty())
		{
			return true;
		}
		while(!left.isEmpty())
		{
            if(left.peek()=='('&& countS==0)
                return false;
            else if(left.peek()=='(' && countS>0)
            {
                left.pop();
                countS--;
            }else
            {
                left.pop();
                countS++;
            }
               
		}
		return countS>=0; // return true;
    }
	
//	69.51% very smart move
	 public boolean checkValidString1(String s) {
	        int left = 0;
			int right = 0;
			for (int i =0;i<s.length();i++) 
	        {
				if (s.charAt(i) == '(') 
				{
					left++;  // count left parenthesis as positive
				} else {
					left--;  // everything other than left p could cancel one left p 
				}
				if (s.charAt(i) == ')') 
				{
					right--;  // count right parenthesis as negative
				} else {
					right++; // everything other than right p could cancel one right p
				}
				if (right < 0)  // if right p cannot be cancelled out,
				{
					return false; 
				}
				left = Math.max(left, 0); 
			}
			return left == 0;
	    }
	 
//	 43.53%
	 public static boolean checkValidString2(String s)
	 {
		 StringBuffer sb = new StringBuffer(s);
		 int index = 0;
		 while(index<sb.length())
		 {
			 if(sb.charAt(index)==')' && sb.lastIndexOf("(", index)!=-1)
			 {
				 int left = sb.lastIndexOf("(", index);
				 sb.deleteCharAt(index);
				 sb.deleteCharAt(left);
				 index = left;
			 }
			 else if (sb.charAt(index)==')' && sb.lastIndexOf("*", index)!=-1)
			 {
				 int left = sb.lastIndexOf("*", index);
				 sb.deleteCharAt(index);
				 sb.deleteCharAt(left);
				 index = left;
			 }else
				 index++;
		 }
		 
		 index = 0;
		 while(index<sb.length())
		 {
			 if(sb.charAt(index)=='(' && sb.indexOf(")",index)!=-1)
			 {
				 int right = sb.indexOf(")", index);
				  sb.deleteCharAt(right);
                 sb.deleteCharAt(index);
				
//                 index=0;  you don't need to reset the index, 
//                 because the deleted ')' must be right to index
			 }
			 else if(sb.charAt(index)=='(' && sb.indexOf("*",index)!=-1)
			 {
				 int right = sb.indexOf("*", index);
				 sb.deleteCharAt(right);
                 sb.deleteCharAt(index);
				
//                 index=0;
			 }else
				 index++;
		 }
		 return sb.indexOf("(")<0 && sb.indexOf(")")<0;
	 }

//	 69.12%  Yue's code
	 public static boolean checkValidString3(String s) {
	        int[] balance = new int[s.length()];
	        List<Integer> star = new ArrayList<>();
	        for(int i = 0;i<s.length();i++){
	            if(i == 0){
	                if(s.charAt(i) == '(')
	                    balance[i] = 1;
	                else if(s.charAt(i) == ')')
	                    balance[i] = -1;
	                else{
	                    balance[i] = 0;
	                    star.add(i);
	                }
	            }
	            else{
	                if(s.charAt(i) == '(')
	                    balance[i] = balance[i-1] + 1;
	                else if(s.charAt(i) == ')')
	                    balance[i] = balance[i-1] -1;
	                else{
	                    balance[i] = balance[i-1];
	                    star.add(i);
	                }
	            }
	            if(balance[i]<0){
	                if(star.size() != 0){
	                    int index = star.remove(0);
	                    for(int j = index;j<=i;j++)
	                        balance[j]++;
	                }
	                else
	                    return false;
	            }
	        }
	        if(balance.length > 0){
	            if(star.size()<balance[balance.length - 1])
	                return false;
	            while(balance[balance.length - 1]>0){
	                int index = star.remove(star.size()-1);
	                for(int i = balance.length - 1;i >= index;i--){
	                    if(balance[i] > 0)
	                        balance[i] --;
	                    else
	                        return false;
	                }
	            }
	            return true;
	        }
	        return true;
	       
	    }
}
