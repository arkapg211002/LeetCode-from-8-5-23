//{ Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.find_xor(n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends



class Solution
{
    public int find_xor(int n)
    {
        // Code here
        int len=Integer.toBinaryString(n).length();
        int c=0;
        while(n>0)
        {
            c+=1;
            n&=(n-1);
        }
        return c^(len-c);
    }
}