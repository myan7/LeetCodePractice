import java.util.*;
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("According to this order A, B, and C, please input 3 integers.");
		System.out.println("These integers stand for the capacities of three buckets, separated by "+ "\",\""+".");
		Scanner scan = new Scanner(System.in);
		String line;
		String[] lineVector;

        line = scan.nextLine(); //read 1,2,3

        //separate all values by comma
        lineVector = line.split(",");

        //parsing the values to Integer
        int a =Integer.parseInt(lineVector[0]);
        int b =Integer.parseInt(lineVector[1]);
        int c =Integer.parseInt(lineVector[2]);

		int[] arr1 ={a,b,c}; 
		
		Vertex myCombo = new Vertex(arr1);
		//myCombo.output();
		
		System.out.println("input t ");
	}

}
