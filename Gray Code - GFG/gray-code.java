//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.getGray(n));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int getGray(int n) {
        // code here
        int g=n ^ n>>1;
        return g;
    }
};