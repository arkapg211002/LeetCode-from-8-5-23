//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String s = br.readLine().trim();
		  
		    Complete obj = new Complete();
		    
		    System.out.println(obj.Sandwiched_Vowel(s));
		        
		}
		
	}
}



// } Driver Code Ends


//User function Template for Java

class Complete{
    
   
    public static String Sandwiched_Vowel(String str) 
    { 
        // Complete function
        char ch[]=str.toCharArray();
        for(int i=1;i<str.length()-1;i++)
        {
            if(check(ch[i])==1 && check(ch[i-1])==0 && check(ch[i+1])==0)
            {
                ch[i]=' ';
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char c:ch)
        {
            if(c!=' ') sb.append(c);
        }
        return sb.toString();
    } 
    public static int check(char ch)
    {
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return 1;
        else return 0;
    }
}
