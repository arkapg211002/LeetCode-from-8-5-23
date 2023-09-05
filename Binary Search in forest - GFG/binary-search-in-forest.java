//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG
{
    public static void main (String[] args)
	{
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        while(t-->0)
        {
            int n = in.nextInt();
            
            int tree[]= new int[n];
            for(int i=0; i<n; i++)
                tree[i] = in.nextInt();
            int k = in.nextInt();
            
            Solution x = new Solution();
            System.out.println( x.find_height(tree,n,k) );
        }
	}
}
// } Driver Code Ends

class Solution
{
    static int find_height(int treeHeights[], int n, int k)
    {
        if(n==1) {
            if(treeHeights[0]>k) return treeHeights[0]-k;
            return -1;
        }
        int minHeight=Integer.MAX_VALUE, maxHeight=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            minHeight=Math.min(minHeight, treeHeights[i]);
            maxHeight=Math.max(maxHeight, treeHeights[i]);
        }
        if(minHeight==maxHeight) {
            if(Math.ceil((double)minHeight-k/(double)n)==Math.floor((double)minHeight-k/(double)n)) {
                return minHeight-k/n;
            }
            return -1;
        }
        int l=minHeight, h=maxHeight;
        while(l<=h) {
            int mid = l+ (h-l)/2;
            int woodCollected = getWoodCollected(treeHeights, n, mid);
            if(woodCollected==k) return mid;
            if(woodCollected>k) {
                l=mid+1;
            }
            else {
                h=mid-1;
            }
        }
        return -1;
    }
    
    static int getWoodCollected(int[] treeHeights, int n, int h) {
        int totalWoodCollected = 0;
        for(int i=0;i<n;i++) {
            int woodCollected= treeHeights[i]-h;
            if(woodCollected>0) totalWoodCollected+=woodCollected;
        }
        return totalWoodCollected;
    }
}

