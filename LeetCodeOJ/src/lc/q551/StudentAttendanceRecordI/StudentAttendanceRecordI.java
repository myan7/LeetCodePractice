package lc.q551.StudentAttendanceRecordI;
/*
 * 551. Student Attendance Record I
 * Easy
 * You are given a string representing an attendance record for a student. 
 * The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.

A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) 
or more than two continuous 'L' (late).
You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True

Example 2:
Input: "PPALLL"
Output: False
 * 
 */

public class StudentAttendanceRecordI {

	public static void main(String[] args) 
	{
		String tc1 = "PPALLP";
		String tc2 = "PPALLL";
		String tc111 = "LALL"; // expected True
		System.out.println(checkRecord(tc111));
	}
	
//	56.4%
	public static boolean checkRecord(String s) 
	{
        char[] rec = s.toCharArray();
        int countA = 0;
        int countL = 0;
        int count = 0;
        for(char c: rec)
        {
        	if(c == 'A')
        	{
        		countA++;
        	}
        	if(c =='L')
        	{
        		count++;
            	countL = countL>=count? countL:count;
        	}
        	else if(c!='L')
        	{
        		count=0;
        	}

        }
        return (countA<2 && countL<3);
    }
}

