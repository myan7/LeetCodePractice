package forLoopTest;

public class ForConditionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i = 0;i<3;i++)
		{
			System.out.println("a");
		}
		
		
		System.out.println();
		
		int index =0;
		for(System.out.println("a");index<3;System.out.println("b"))
		{
			System.out.print("c"+"\t");
			index++;
		}
		
		System.out.println();
//		delta triangle
		
		for(int outer = 5; outer>=0;outer--)
		{
			for(int inner = outer; inner>=0;inner--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
//		upside down delta triangle
		for(int x = 0;x<6;x++)
		{
			for(int y=0;y<=x;y++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
//		54321-4321-321-21-1
		for(int i =5;i>0;i--)
		{
			for(int j = i;j>0;j--)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
//		1-22-333-4444-55555
		for(int i=1;i<6;i++)
		{
			for(int j =0;j<i;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println();
//		9*9 multiply table
		for(int i = 1;i<10;i++)
		{
			for(int j =1;j<=i;j++)
			{
				int result = i*j;
				System.out.print(j+"*"+i+"="+result+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
//		triangle in the middle
		for(int i =0;i<5;i++)
		{
			for(int j =0;j<i;j++)
			{
				System.out.print(" ");
			}
			for(int k = 5;k>i;k--)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
