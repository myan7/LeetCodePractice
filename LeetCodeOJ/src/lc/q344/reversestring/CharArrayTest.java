package lc.q344.reversestring;

public class CharArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is a String to test Char array.toString()";
		
		char[] chArr = new char[s.length()];
		
		for(int i =0, j=0; i <s.length();i++,j++)
		{
			chArr[i]=s.charAt(j);
		}
		System.out.println("Using char array to String");
		String chArrstr = chArr.toString();
		System.out.println(chArrstr);
		
		
		System.out.println("Using constructor");
		String chArrstr1 = new String(chArr);
		System.out.println(chArrstr1);
		
		System.out.println("Using String.valueOf");
		String chArrstr2 = String.valueOf(chArr);
		System.out.println(chArrstr2);
	}

}
