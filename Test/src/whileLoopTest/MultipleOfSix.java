package whileLoopTest;

public class MultipleOfSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The count of multiple of 6 within 100 is "+ multiSix(103));
		System.out.println("The count of multiple of 6 within 100 is "+ multiSix1(103));
		System.out.println("The count of multiple of 6 within 100 is "+ multiSix2(103));
	}

	public static int multiSix(int n)
	{
		int count =0;
		int result = 6,i=1;
		while(result<=n)
		{
			result = 6*i;
//			System.out.println(result);
			i++;
			count++; // you need to know that the count who makes this loop end, 
			//should be excluded. 
		}
		
		return count-1;// that's why we minus 1 here.
	}
	public static int multiSix1(int n)
	{
		int count=0;
		while(6*count<=n)
		{
			count++;
		}
		
		return count-1;
	}
	
	public static int multiSix2(int n)
	{
		int result = 1,count=0;
		while(result<=n)
		{
			if(result%6==0)
			{
//				System.out.println(result);
				count++;
			}
			result++;
		}
		
		return count; // in this situation, the increment variable is the condition.
	}
	
}
