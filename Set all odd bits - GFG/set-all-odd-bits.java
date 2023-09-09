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

            System.out.println(ob.setAllOddBits(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long setAllOddBits(long n){
        // code here
         int count = 0;
         int res = 0;

            long temp=n;
            while(temp>0){
                 if (count % 2 == 0){
                res |= (1 << count);
                 }
                 count++;
                 temp>>=1;
            }
        return (n | res);
    }
}