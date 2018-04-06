package lc.q69.Sqrtx;
/*
 * 69. Sqrt(x)
 * Easy
 * Implement int sqrt(int x).

Compute and return the square root of x.
 */
public class Sqrtx {

	public static void main(String[] args) {
		int tc14  = 2147395599;
		System.out.println(mySqrt(tc14));
	}
	
	  public static int mySqrt(int x) 
	  {
		  int ans = 0;
		  long left = 1,right = x;
		  while(left<=right)  // left <= right is necessary, cause if x = 1, while loop will be skipped.
		  {
			  long mid = left+ (right-left)/2;
			  if(mid*mid>x)
			  {
				  right = mid-1;
			  }else
			  {
				  if(mid+1>x/(mid+1))
					  ans= (int)mid;
				  left = mid+1;
			  }
		  }
		  return ans;
	  }

//	  13.21%
	  public static int mySqrt1(int x)
	  {
		  if (x == 0)
		        return 0;
		    int left = 1, right = Integer.MAX_VALUE;
		    while (true) 
		    {
		        int mid = left + (right - left)/2;
		        if (mid > x/mid) 
		        {
		            right = mid - 1;
		        } 
		        else 
		        {
		            if (mid + 1 > x/(mid + 1))
		                return mid;
		            left = mid + 1;
		        }
		    }
	  }
}
