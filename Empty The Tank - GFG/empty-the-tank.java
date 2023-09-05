//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(read.readLine());
            int l = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.minDaysToEmpty(c, l));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static long minDaysToEmpty(long C, long l) {
        // code here
         long cc = C;
        
        for(long i = 0 ; i < Long.MAX_VALUE; i++){
            if(cc < C)
                cc += l;
            
            if(cc > C)
                cc = C;
            
            cc -= i;
            
            if(cc <= 0)
                return i;
        }
        
        return -1;
    }
}