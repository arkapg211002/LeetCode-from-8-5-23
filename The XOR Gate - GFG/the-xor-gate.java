//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int xorGate(int arr[] , int N){
        //code here
        int xor=0;
        for(int i=0;i<arr.length;i++) xor^=arr[i];
        return xor;
    }
};

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String S[] = read.readLine().trim().split(" ");
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.xorGate(arr,N));
        }
    }
}
// } Driver Code Ends