package lc.q374.guessNumberHigherOrLower;
/*
 * 374. Guess Number Higher or Lower 
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked. 
 * Every time you guess wrong, I'll tell you whether the number is higher or lower. 
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 
*Example:
n = 10, I pick 6.
Return 6.
 * 
 */
public class GuessNumberHigherOrLowerSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/* The guess API is defined in the parent class GuessGame.
	   @param num, your guess
	   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
	      int guess(int num); */

	public static int guessNumber(int n) {
	        return bsearch(1,n);
	}
	// use a binary search method can run faster than +1 / -1 
	private static int bsearch(int start,int end){
	    // if(start>end) return -1;//R u kidding me?
	    if(guess(start)==0) return start;
	    else if(guess(end)==0) return end;
	    else
	    {
	        int mid = start+(end-start)/2;
	    if(guess(mid)==0) return mid;
	    else if(guess(mid)==-1) return bsearch(start+1,mid-1);
	    else return bsearch(mid+1,end-1);    
	    }
	}
	private static int guess(int num)
	 {
		 return num; // this is not the method, just to make eclipse looks good.
	 }
}


