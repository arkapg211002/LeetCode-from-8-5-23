//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.bitsAreInAltOrder(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long bitsAreInAltOrder(long n){
        // code here
        String s = Long.toBinaryString(n);
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
                return 0;
        }
        return 1;
    }
}