//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    public static boolean isPossible(int []arr,int n,int k,long mid)
    {
        long painter=1;
        long wallsum=0;
        for(int i=0;i<n;i++)
        {
            if(wallsum+arr[i]<=mid)
            {
                wallsum+=arr[i];
            }
            else
            {
                painter++;
                if(painter>k || arr[i]>mid)
                {
                 return false;   
                }
                wallsum=arr[i];
            }
        }
        return true;
    }
    static long minTime(int[] arr,int n,int k){
        long s=0;
        long sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }//Your code here
        long e=sum;
        long ans=-1;
        long mid=s+(e-s)/2;
        while(s<=e)
        {
            if(isPossible(arr,n,k,mid))
            {
                ans=mid;
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
            mid=s+(e-s)/2;
        }
        return ans;//code here
    }
}
