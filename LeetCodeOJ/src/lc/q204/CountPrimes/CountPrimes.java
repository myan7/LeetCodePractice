package lc.q204.CountPrimes;
/*
 * 204. Count Primes
 * Easy
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {

	public static void main(String[] args) 
	{
		int tc2 = 2;
		int tc3 = 3;
		int tc1000 = 1000;
		int tc17 = 499979;  //Time Limit Exceeded   41537
//		System.out.println((int)Math.sqrt((double)9)== Math.sqrt((double)9));
		System.out.println(countPrimes(tc3));
	}
	
//	55.46% the most understandable method.
	public static int countPrimes1(int n)
	{
		boolean[] notPrime = new boolean[n];
	    int count = 0;
	    for (int i = 2; i < n; i++) 
	    {
	       if (notPrime[i] == false) 
	       {
	           count++;
	           for (int j = 2; i*j < n; j++)  // clever method 
	           {
	                 notPrime[i*j] = true;
	           }
	        }
	     }
	        return count;
	}
	
//	96.40%
	public int countPrimes2(int n) 
	{
	    if (n < 3) return 0;        
	    boolean[] f = new boolean[n];
	    //Arrays.fill(f, true); boolean[] are initialed as false by default
	    int count = n / 2;
	    for (int i = 3; i * i < n; i += 2) {
	        if (f[i])
	            continue;
	        
	        for (int j = i * i; j < n; j += 2 * i) {
	            if (!f[j]) 
	            {
	                --count;
	                f[j] = true;
	            }
	        }
	    }
	    return count;
	}
	
	public static int countPrimes(int n) 
    {
        int count =0;
        for(int i =2;i<n;i++)
        {
            int div = 2;
            boolean flag = true;
            while(flag && div<n)
            {
                if((int)Math.sqrt((double)i)== Math.sqrt((double)i)|| (i!=div && i%div == 0 ))
                    flag = false;
                else
                    div++;
            }
            if(flag == true)
             count++;
        }
        return count;
    }

	
}
