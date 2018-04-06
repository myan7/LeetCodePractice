
public class ParseTest {

	public static void main(String[] args) {
		String str = new String("300,20,1000,4");
				
		String[] tmp = new String[4];
		tmp = str.split(",");
		
		int[] intArray = new int[tmp.length];
		System.out.print(tmp.length);
		System.out.println();

		
		for(int i = 0; i < tmp.length;i++)
		{
			intArray[i]=Integer.parseInt(tmp[i]);
			System.out.println(intArray[i]);
		}
		sort(intArray);
		
		for(int i = 0; i < tmp.length;i++)
		{
			System.out.println(intArray[i]);
		}
	}
	
	
	
	
	public static int[] sort(int[] a)
	{
		//int[] sorted = new int[a.length];
		for(int i =0; i<a.length;i++)
		{
			for(int j=i;j<a.length;j++)
			{
				if(a[j]<a[i])
				{
					swap(j,i,a);
				}
			}
		}
		return a;
	}

	public static void swap(int a, int b,int[] intArray)
	{
		int tmp = 0;
		tmp = intArray[a];
		intArray[a] = intArray[b];
		intArray[b] = tmp;
		
//		int a = 3;
//		int b =5;
//		swap(a,b);
//		System.out.print("a = "+a + "....."+"b = "+ b );
//		http://stackoverflow.com/questions/10393690/is-it-possible-to-swap-two-variables-in-java
	}
	
}
