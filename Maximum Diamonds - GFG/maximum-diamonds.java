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
            int K = Integer.parseInt(S[1]);
            
            int[] A = new int[N];
            
            String S1[] = read.readLine().split(" ");
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxDiamonds(A,N,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long maxDiamonds(int[] a, int n, int k) {
        // code here
        long s=0;
        PriorityQueue<Integer>q=new PriorityQueue<Integer>(new Comparator<>(){
            @Override
            public int compare(Integer a,Integer b)
            {
                if(a>b) return -1;
                else if(a<b) return 1;
                else return 0;
            }
        });
        for(int i=0;i<n;i++) q.add(a[i]);
        while(k>0)
        {
            int h=q.peek();
            s+=h;
            q.remove();
            q.add(h/2);
            k-=1;
        }
        return s;
    }
};