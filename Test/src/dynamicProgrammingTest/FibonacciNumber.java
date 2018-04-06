package dynamicProgrammingTest;

public class FibonacciNumber {

	public static void main(String[] args) 
	{
		long start2 = System.currentTimeMillis();
		System.out.println(fibIte(500));
		long end2 = System.currentTimeMillis();
		System.out.println("Iterative time "+ (end2-start2)+ " ms");
		
		long start1 = System.currentTimeMillis();
		System.out.println(fibRec(100));
		long end1 = System.currentTimeMillis();
		
		
		System.out.println("Recursive time "+ (end1-start1)+ " ms");
		
	}

	public static long fibRec(int n)
	{
		long res = 0;
		if(n<=2)
			res = 1;
		else if(n>2)
			res = fibRec(n-1)+fibRec(n-2);
		return res;
	}
	
	public static long fibIte(int n)
	{
		long res = 0;
		long f1=1,f2=1;
		long count = 1;
		while(count<=n)
		{
			if(count>2)
			{
				res = f1+f2;
				f1 = f2;
				f2 =res;
				
				count++;
//				System.out.println("count = "+ count+"; f1 = "+f1+", f2 = "+ f2 +"; res = "+ res);
			}
			else
			{
				res = 1;
				count++;
			}
		}
		return res;
	}
}
