//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            String input[];
            input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            
            System.out.println(ob.replaceBit(n,k));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int replaceBit(int N, int K){
        String s=Integer.toBinaryString(N);
        StringBuilder sb=new StringBuilder(s);
        if(K>=1 && K<=s.length())sb.setCharAt(K-1,'0');
        s=sb.toString();
        return Integer.parseInt(s,2);
    }
}