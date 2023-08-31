//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0)
        { 
            int N=sc.nextInt();
    	    int M=sc.nextInt();
    	    char c[]=new char[2*N];
    	    for(int i=0;i<c.length;i++)
    	       c[i]=sc.next().charAt(0);
    	    String s=sc.next();
            
            Solution obj = new Solution();
            int res = obj.count_pairs(c, s, 2*N, M);
            System.out.println(res);
        }

	}
	
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    
    public static int count_pairs(char arr[], String s, int n, int m) 
    { 
        // Complete the function
        int count=0;
        for(int i=0;i<n-1;i=i+2)
        {
           if(s.indexOf(arr[i])>=0 && s.indexOf(arr[i+1])>=0)
           {
               count++;
           }
        }
        return count;
    }
    
}
