//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int solve(int[]dp, int[]arr, int i, int n){
        int j=i+1;
        if(j>=n)return 0;
        int max= 0;
        while(j < n){
            if(arr[i]<arr[j]){
                if(dp[j]==-1){
                    dp[j]=solve(dp, arr, j, n)+arr[j];
                }
                max = Math.max(max, dp[j]);
            }
            j++;
        }
        return max;
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[]dp=new int[n];
	    Arrays.fill(dp, -1);
	    int res = Integer.MIN_VALUE;
	    for(int i=0; i<n; i++){
	        if(dp[i]==-1)
    	        res = Math.max(res, solve(dp, arr, i, n)+arr[i]);
    	    else res = Math.max(res, dp[i]);
	    }
	   // System.out.println(Arrays.toString(dp));
	    return res;
	}  
}
