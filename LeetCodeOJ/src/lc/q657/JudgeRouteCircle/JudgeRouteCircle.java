package lc.q657.JudgeRouteCircle;
/*
 * 657. Judge Route Circle
 * Easy
 * 
 * Initially, there is a Robot at position (0, 0). 
 * Given a sequence of its moves, judge if this robot makes a circle, 
 * which means it moves back to the original place.

The move sequence is represented by a string. 
And each move is represent by a character. 
The valid robot moves are R (Right), L (Left), U (Up) and D (down). 

The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false
 */
public class JudgeRouteCircle {

	public static void main(String[] args) 
	{

	}
	
//	80.89%
	public static boolean judgeCircle(String moves) 
	{
		int[] position = new int[2];
		for(char ch: moves.toCharArray())
		{
			char m = ch;
			switch(m)
			{
			case 'R': position[0]++;
					break;
			case 'L': position[0]--;
					break;
			case 'U':position[1]++;
				 	break;
			case 'D':position[1]--;
					break;
			default:
					break;
			}
		}
		return position[0] == 0 && position[1]==0;
    }

}
