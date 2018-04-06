package test;

import java.util.Scanner;


public class Concat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please give me a number:");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		System.out.println("Please give me another number:");
		int b = input.nextInt();
		
		int sum = a+b;
		int dif = a-b;
		int pro = a*b;
		int div = a/b;
		System.out.println("a+b= "+sum);
		System.out.println("a-b= "+dif);
		System.out.println("a*b= "+pro);
		System.out.println("a/b= "+div);
	}

}
