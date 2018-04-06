
public class LogBase2Calc {

	public static void main(String[] args) {
		
		System.out.println(Math.log10(9/14));
		
		System.out.println(log(2));
		
		System.out.println(log(9/14));
		
		System.out.println(-(9/14)*log(9/14)-(5/14)*log(5/14));
		
		System.out.println(0.409776378+ 0.530509581);
	}

	static double log(double x)
	{
	    return  (Math.log10(x) / Math.log10(2));
	}
}
