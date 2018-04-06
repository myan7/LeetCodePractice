package lc.q344.reversestring;

public class ReverseString {
	
	public String reverseString(String s) {
        char[] answer = new char[s.length()]; 
        
        for(int i =s.length()-1 , j =0 ;i>=0; i-- , j++)
        	// length()-1 is necessary in order to avoid out of index.
        {
        	answer[j] = (char)s.charAt(i);
        }
       //String str =  answer.toString();
        // toString is not correct
        //Also you can use constructor like this
       //  String str = new String(answer); 		check
        String str = String.valueOf(answer);        //check
      /*  for(int i = 0; i<answer.length; i++)
        {
        	System.out.print(answer[i]);
        }
        */
        return str;
        
    }

}
