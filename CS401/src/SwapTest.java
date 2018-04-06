
public class SwapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a = 15, b = 100;
		
		System.out.println("a= "+ a +","+ "b = "+b+".");
		
		swap(a,b);
		
		System.out.println("a= "+ a +","+ "b = "+b+".");
		
		
		int z = a;
		a = b;
		b = z;
		System.out.println("a= "+ a +","+ "b = "+b+".");

	}
	public static void swap(int a, int b)
	{
		int temp = 0;
		temp = a;
		a = b;
		b = temp;
	}
}
