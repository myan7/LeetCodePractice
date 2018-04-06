package lc.q401.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class Solution {
		String[][] hour = {{"0"},  // hours contains zero 1's
				   {"1", "2", "4", "8"},   // hours contains 1 1's
				   {"3", "5", "6", "9", "10"},  // hours contains 2 1's
				   {"7", "11"}};  // hours contains 3 1's
		String[][] minute = {{"00"},  // mins contains zero 1's
			             {"01", "02", "04", "08", "16", "32"},  // mins contains one 1's
			             {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},  // mins contains 2 1's
			             {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},  // mins contains 3 1's
			             {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},  // mins contains 4 1's
			             {"31", "47", "55", "59"}};  // mins contains 5 1's
    public List<String> readBinaryWatch(int num) {
		List<String> ret = new ArrayList<String>();
               // loop from 0 to 3 which is the max number of bits can be set in hours (4 bits)
		for (int i = 0; i <= 3 && i <= num; i++) 
		{
           // this if condition is to make sure the index from minutes array would be valid
			if (num - i <= 5)
			{
            // if we have i 1's in hours, then we need n - i 1's in minutes, 
//				that's why the arrays were created by grouping the number of 1's bits
				for (String str1 : hour[i]) 
				{
					for (String str2 : minute[num - i]) 
					{
						ret.add(str1 + ":" + str2);
					}
				}
			}
		}
		return ret;     
    }
}
