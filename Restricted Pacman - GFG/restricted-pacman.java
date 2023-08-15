//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
     public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.candies(m,n));
            t--;
        }
    } 
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int candies(int m, int n) 
    { 
        int c= (int)Math.max(m,n);
        int k= (int)Math.min(m,n);
       
        if(c%2==0)
        return ((c-1)*(k/2));
        else
         return ((k-1)*(c/2));
    } 
}