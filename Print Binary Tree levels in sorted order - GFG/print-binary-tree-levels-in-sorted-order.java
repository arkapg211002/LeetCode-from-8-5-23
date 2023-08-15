//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		ArrayList <ArrayList <Integer>> res = new Solution().binTreeSortedLevels (arr, n);
    		
    		for (int i = 0; i < res.size(); i++)
    		{
    		    for (int j = 0; j < (res.get (i).size()); j++)
    		    {
    		        System.out.print (res.get(i).get(j) + " ");
    		    }
    		    System.out.println ();
    		}
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static ArrayList <ArrayList <Integer>> binTreeSortedLevels (int arr[], int n)
    {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        int lev=0;
        int req=1<<lev;
        for(int i=0;i<n;i++){
            if(temp.size()==req){
                lev++;
                req=1<<lev;
                Collections.sort(temp);
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
            temp.add(arr[i]);
        }
        if(temp.size()!=0){
            Collections.sort(temp);
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}