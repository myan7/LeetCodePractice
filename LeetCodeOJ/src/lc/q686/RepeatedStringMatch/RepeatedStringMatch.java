package lc.q686.RepeatedStringMatch;
/*
 * 686. Repeated String Match
 * Easy
 * Given two strings A and B, 
 * find the minimum number of times A has to be repeated such that B is a substring of it. 
 * If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A 3 times (“abcdabcdabcd”), 
B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 */
public class RepeatedStringMatch {

	public static void main(String[] args) {
		String A1 = "abcd";
		String B1 = "cdabcdab";
		String A2 = "a";
		String B2 = "aa";
		String A35 = "abababaaba";
		String B35 = "aabaaba";
		System.out.println(repeatedStringMatch1(A2,B2));
	}
	
	public static int repeatedStringMatch(String A, String B) 
	{
		int indexA = 0;
		int indexB = 0;
		int count = 0;
		while(indexB<B.length())
		{
			if(indexA<A.length())
			{
				if(B.charAt(indexB)==A.charAt(indexA))
				{
					indexB++;
					indexA++;
				}
				else if(B.charAt(indexB)!=A.charAt(indexA))
				{
					indexB=0;
				}
				else
				indexA++;
			}
			
			if(indexA==A.length())
			{
				++count;
				indexA=0;
			}
		}
		return indexB==B.length()? count:-1;
    }
	
	public static int repeatedStringMatch1(String A, String B) 
	{
		StringBuffer sb = new StringBuffer(A);
		int count =1;
		while(sb.length()<B.length())
		{
			sb.append(A);
			count++;
		}
		if(sb.toString().contains(B)) return count;
		if(sb.append(A).toString().contains(B)) return count+1;
		return -1;
	}

	public static int repeatedStringMatch2(String A, String B)
	{
		 StringBuilder sb = new StringBuilder();
	        sb.append(A);
	        int count = 1;
	        while(sb.indexOf(B)<0)
	        {
//If the string obtained as concatenating copies of string A 
//has a length greater than the sum of the lengths of A and B 
//and still it does not have B as a substring, then any further A-concatenation is useless.
	            if(sb.length()-A.length()>B.length()) 
	                return -1;
	            sb.append(A);
	            count++;
	        }
	        
	        return count;
	} // equivalent to repeatedStringMatch3
	
	 public static int repeatedStringMatch3(String A, String B) {
	        StringBuffer sb = new StringBuffer(A);
	        int count = 1;
	        while(sb.indexOf(B)<0)
		        {
		            sb.append(A);
	                if(sb.length()>B.length() && sb.indexOf(B)<0)
	                    return -1;
		            count++;
		        }
	        return count;
	    }
}
