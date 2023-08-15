//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int k=Integer.parseInt(s[1]);
            Solution ob=new Solution();
            out.println(ob.distributeTicket(n,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static int distributeTicket(int n,int k)
    {
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=1;i<=n;i++)q.add(i);
        int res=0;
        int c=0;
        while(!q.isEmpty())
        {
            c=k;
            while(c>0 && !q.isEmpty())
            {
                res=q.getFirst();
                q.removeFirst();
                c-=1;
            }
            c=k;
            while(c>0 && !q.isEmpty())
            {
                res=q.getLast();
                q.removeLast();
                c-=1;
            }
        }
        return res;
    }
}