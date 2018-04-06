package lc.q476.complementNumber;

public class SolutionL {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int i =10;
		int compNum = ~i;
		System.out.println(compNum);
	}

//	To find complement of num = 5 which is 101 in binary.
//			First ~num gives ...11111010 but we only care about the rightmost 3 bits.
//			Then to erase the 1s before 010 we can add 1000

	public int findComplement(int num) 
	{
		return ~num + (Integer.highestOneBit(num) << 1);
	}


//I post solution first and then give out explanation. Please think why does it work before read my explanation.


    public int findComplement2(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }

//According to the problem, the result is
//
//The flipped version of the original input but
//Only flip N bits within the range from LEFTMOST bit of 1 to RIGHTMOST.
//For example input = 5 (the binary representation is 101), 
//the LEFTMOST bit of 1 is the third one from RIGHTMOST (100, N = 3). 
//Then we need to flip 3 bits from RIGHTMOST and the answer is 010
//To achieve above algorithm, we need to do 3 steps:
//
//Step1:
//Create a bit mask which has N bits of 1 from RIGHTMOST. 
//In the above example, the mask is 111. 
//And we can use the decent Java built-in function Integer.highestOneBit 
//to get the LEFTMOST bit of 1, left shift one, and then minus one. 
//Please remember this wonderful trick to create bit masks with N ones at RIGHTMOST, 
//you will be able to use it later.
    
//Step2:
//Negate the whole input number.
//Step3:
    
//Bit AND numbers in step 1 and 2.
//Three line solution if you think one line solution is too confusing:

	
    public int findComplement3(int num) 
    {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }
}
