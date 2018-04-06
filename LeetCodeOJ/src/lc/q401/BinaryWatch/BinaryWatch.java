package lc.q401.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

/*
 * 401. Binary Watch
 * Easy
 * 
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), 
 * and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

top:
	8	4	2	1
	0	0	1	1
bottom:
	32	16	8	4	2	1
	0	1	1	0	0	1

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, 
return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
Note:
The order of output does not matter.
The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
The minute must be consist of two digits and may contain a leading zero, 
for example "10:2" is not valid, it should be "10:02".
 * 
 */

public class BinaryWatch {

	public static void main(String[] args) 
	{
		System.out.println(readBinaryWatch(1));
	}

//	25.96%
	public static List<String> readBinaryWatch(int num) 
	{
        List<String> ans = new ArrayList<String>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h * 64 + m) == num)
                    ans.add(String.format("%d:%02d", h, m));
        return ans;        
    }
	
//	90.76%
	public static List<String> readBinaryWatch1(int num)
	{
		List<String> result = new ArrayList<>();
        for (int i=0; i<1024; i++){
            if (countBits(i)==num){
                int h = (i>>6) & 0xf;
                int m = i & 0x3f;
                if (h>=0 && h<=11 && m>=0 && m<=59){
                    result.add(""+h+":"+(m<10?"0":"")+m);
                }
            }
        }
        return result;
    }
    
    private static int countBits(int x) {
        int count = 0;
        while (x!=0){
            x = x & (x-1);
            count++;
        }
        return count;
	}
	
}
