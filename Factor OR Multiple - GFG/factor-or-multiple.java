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
            int N = Integer.parseInt(S[0]);
            int X = Integer.parseInt(S[1]);
            
            String arr[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++)
                A[i]=Integer.parseInt(arr[i]);

            Solution ob = new Solution();
            System.out.println(ob.factorOrMultiple(N,X,A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int factorOrMultiple(int N,int X,int A[]) {
        // code here
        int res=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]%X==0) res=res | A[i];
        }
        return res;
    }
};