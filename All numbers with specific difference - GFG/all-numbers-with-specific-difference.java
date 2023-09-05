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
            String S[] = read.readLine().split(" ");
            Long N = Long.parseLong(S[0]);
            Long D = Long.parseLong(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.getCount(N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution {
    static Long getCount(Long N , Long D) {
        long counter=0;
        long start=1;
        long end=N;
        while(start<=end){
            long middle=start+(end-start)/2;
            if(middle-sum(middle)<D)
                start=middle+1;
            else
                end=middle-1;
        }
        return N-end;
    }
    static long sum(long digit){
        long d=0;
        while(digit>0){
            d+=digit%10;
            digit/=10;
        }
        return d;
    }
};