package stringTest;

public class StringEqualsTest {

	public static void main(String[] args) {

		String a = "java";
		String b = "java";
		String c = new String("java");
		String d = new String("java");
		String j1 = a;
		
		
		Integer i1 = 127;
		Integer i2 = 127;
		Integer i3 = 128;
		Integer i4 = 128;
		
//		System.out.println("Integer i1 = 127 and Integer i2 = 127: "+  (i1 == i2));
//		System.out.println(i3==i4);
		
//		System.out.println("a = java, b = java : "+(a==b));
		System.out.println(("ja"+"va")==j1);
		System.out.println(("ja".concat("va"))==j1);
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(" "+a));
		System.out.println(System.identityHashCode(" "+b));
//		https://stackoverflow.com/questions/3029244/are-strings-created-with-concatenation-stored-in-the-string-pool
		System.out.println("c"+1+2);
		System.out.println("abc \r bcd");
		
		String s1 = "1";
		System.out.println(s1.concat("2"));
	}

}
