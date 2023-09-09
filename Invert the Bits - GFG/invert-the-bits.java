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
            System.out.println(ob.invertBits(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long invertBits(long N){
        //code here
        String s=Long.toBinaryString(N);
        s=String.format("%32s",s).replace(' ','0');
        char ch[]=s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='0') ch[i]='1';
            else ch[i]='0';
        }
        s=new String(ch);
        //System.out.println(s);
        return Long.parseLong(s,2);
    }
}