package lc.q168_q171.ExcelSheetColumnTitle_ColumnNumber;
/*
 * 168. Excel Sheet Column Title
 * Easy
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		int tc1 = 53;
		System.out.println(convertToTitle(tc1));
	}
	public static String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
        while(n>0)
        {
        	sb.append((char)((n-1)%26+'A')+"");
        		n = (n-1)/26;
        }
        return sb.reverse().toString();
    }
	
	public static String convertToTitle1(int n )
	{
		String res = "";
	    while(n != 0) {
	        char ch = (char)((n - 1) % 26 + 65);
	        n = (n - 1) / 26;
	        res = ch + res;
	    }
	    return res;
	}
}
