//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[]) {
        Integer[][] memo = new Integer[N + 1][W + 1];
        return solve(N, W, val, wt, memo);
    }
    
    static int solve(int N, int W, int[] val, int[] wt, Integer[][] memo) {
        if (N == 0) {
            return 0;
        }
        
        if (W < 0) {
            return 0;
        }
        
        if (memo[N][W] != null) {
            return memo[N][W];
        }
        
        int notPick = solve(N - 1, W, val, wt, memo);
        int pick = 0;
        if (wt[N - 1] <= W) {
            pick = val[N - 1] + solve(N, W - wt[N - 1], val, wt, memo);
        }
        
        return memo[N][W] = Math.max(notPick, pick);
    }
}