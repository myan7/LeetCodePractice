package lc.q468.validateipaddress;
/*
 * 468. Validate IP Address
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * 
 * IPv4 addresses are canonically represented in dot-decimal notation, 
 * which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), 
 * e.g.,172.16.254.1;
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * 
 * 
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, 
 * each group representing 16 bits. The groups are separated by colons (":"). 
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. 
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters 
 * in the address to upper-case ones, 
 * so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * 
 * However, we don't replace a consecutive group of zero value with a single empty group 
 * using two consecutive colons (::) to pursue simplicity. 
 * For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * 
 * Besides, extra leading zeros in the IPv6 is also invalid. 
 * For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * 
 * Note: You may assume there is no extra space or special characters in the input string.

Example 1:
Input: "172.16.254.1"

Output: "IPv4"

Explanation: This is a valid IPv4 address, return "IPv4".
Example 2:
Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"

Output: "IPv6"

Explanation: This is a valid IPv6 address, return "IPv6".
Example 3:
Input: "256.256.256.256"

Output: "Neither"

Explanation: This is neither a IPv4 address nor a IPv6 address.
 * 
 */

public class ValidateIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String IP = "01.01.01.01";
		String IP1 = "20EE:Fb8:85a3:0:0:8A2E:0370:7334";
		String IP2 = "2001:0db8:85a3:00000:0:8A2E:0370:7334";
		String IP3 = "2001:0db8:85a3:0000:0:8A2E:0370:733a";

		System.out.println(validIPAddress1(IP3));

	}
	
//	regular expression.
//	reference:   https://deerchao.net/tutorials/regex/regex.htm
	public String validIPAddress(String IP) 
	{
        if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))return "IPv4";
        if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))return "IPv6";
        return "Neither";
    }
	
	
	
	public static String validIPAddress1(String IP)
	{
		if(IP.length() == 0) return "Neither"; // first thing to think about, empty IP
        else if(IP.charAt(IP.length()-1) == ':'||IP.charAt(IP.length()-1) == '.') return "Neither"; 
		// for the last digit is invalid situation. for example: "192.168.1.1."
        else if(IPv4(IP)) return "IPv4";
		else if(IPv6(IP)) return "IPv6";
		else return "Neither";
	}
	public static boolean IPv4(String IP)
	{
//		https://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java
		String[] parts = IP.split("\\."); // use the escape character
		
		boolean result = true;
		if(parts.length!=4)
		{
			return false;
		}
		else
		{
			for(String e: parts)
			{
				try{
					if(Integer.parseInt(e)<0 || Integer.parseInt(e)>255|| !Character.isDigit(e.charAt(0)))
					{
						return false;
					}
					if(e.length()>1 && e.charAt(0)=='0')
					{
						return false;
					}
				}catch(Exception x)
				{
					return false;
				}
			}
		}		
		return result;
	}
	
	public static boolean IPv6(String IP)
	{
		boolean result = true;
			String[] parts = IP.split(":");
			if(parts.length!=8)
			{
				return false;
			}
			else
			{
				for(String e: parts)
				{
				    if(e.length()==0)  // for two consecutive colons, if true, return false
					{
						return false;
					}
						char ch = e.charAt(0); // this is only for examine the first character, in case it is the negative sign "-";
						boolean isDigit = ch>=48 && ch<=57;
					    boolean isUppercaseAF = ch>=65 && ch<=70;
					    boolean isLowerCaseAF = ch>=97 && ch<=102;
					    if(!(isDigit || isUppercaseAF || isLowerCaseAF)) 
						    return false;
					try
					{
						Long.parseLong(e, 16); // for transfer to hexadecimal number, if exception happens, then return false
						if(e.length()> 4) // for invalid length of a value. e.g. ":00000:"" 
					    {
					        return false;
					    }
					}catch(Exception x)
					{
						return false;
					}
				}
			}
		return result;
	}
}
