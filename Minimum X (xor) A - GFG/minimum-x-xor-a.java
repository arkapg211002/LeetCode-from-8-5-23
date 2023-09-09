//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.minVal(a, b));
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        // code here
       int setBits = Integer.bitCount(b);
        int setBits1 = Integer.bitCount(a);
        int ans = 0;

        for (int i = 0; i <= 31; i++) {
            int mask = 1 << i;
            int set = a & mask;

            // If i'th bit is set also set the
            // same bit in the required number
            if (set == 0 && setBits > setBits1) {
                ans |= (mask);
                setBits--;
            } else if (set != 0 && setBits1 > setBits) {
                setBits1--;
            } else {
                ans |= set;
            }
        }

        return ans;
    }
}