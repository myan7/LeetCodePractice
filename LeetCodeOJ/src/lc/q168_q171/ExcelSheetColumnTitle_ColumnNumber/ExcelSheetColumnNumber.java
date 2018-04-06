package lc.q168_q171.ExcelSheetColumnTitle_ColumnNumber;
/*
 * 171. Excel Sheet Column Number
 * Easy
 * Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		System.out.println(titleToNumber("AB"));
	}
	
//	35.28%
	public static int titleToNumber(String s) 
	{
		int ans = 0;
		int len = s.length();
		for(int i = 0;i<len;i++)
		{
			if(i==0)
				ans =  (int)(s.charAt(i)-64);
			else 
				ans = ans*26+(int)(s.charAt(i)-64);
		}
		return ans;
    }

}
