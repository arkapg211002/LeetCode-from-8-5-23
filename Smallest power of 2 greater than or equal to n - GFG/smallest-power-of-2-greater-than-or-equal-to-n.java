//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nearestPowerOf2(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long nearestPowerOf2(long N){
        //code here
        if(N==0L) return 1L;
        else if((N&(N-1))==0L) return N;
        else
        {
            int count=0;
            while(N!=0)
            {
                N>>=1;
                count+=1;
            }
            return 1L<<count;
        }
    }
}