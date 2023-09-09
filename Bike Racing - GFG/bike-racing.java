//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            long M = Long.parseLong(a[1]);
            long L = Long.parseLong(a[2]);
            long H[] = new long[N];
            long A[] = new long[N];
            for(int i = 0; i < N; i++){
                String a1[] = in.readLine().trim().split("\\s+");
                H[i] = Long.parseLong(a1[0]);
                A[i] = Long.parseLong(a1[1]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.buzzTime(N, M, L, H, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   static long buzzTime(int N, long M, long L, long H[], long A[]){
       long l = 0;
       long r = Math.max(M,L)+1;
       long ans = 0;
       while(l <= r){
           long ts = 0;
           long mid = l+(r-l)/2;
           for(int i=0;i < N;i++){
               if(H[i] + A[i] * mid >= L){
                   ts += H[i] + A[i] * mid;
                   if(ts >= M)
                       break;
               }
           }
           if(ts>=M){
               ans = mid;
               r = mid - 1;
           }else
               l = mid + 1;
       }
       return ans;
   }
}
