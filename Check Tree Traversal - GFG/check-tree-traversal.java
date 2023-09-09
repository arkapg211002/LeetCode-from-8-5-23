//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] preorder = new int[n];
        	int[] inorder = new int[n];
        	int[] postorder = new int[n];
            for(int i=0; i<n; i++)
                preorder[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                inorder[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                postorder[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.checktree(preorder, inorder, postorder, n) )
			System.out.println("Yes");
			else
			System.out.println("No");
            t--;
        }
    }
}

// } Driver Code Ends


class Solution
{
    static int findIndex(int[] inorder,int start,int end,int target){
        for(int i = start ; i <= end; i ++)
            if(inorder[i] == target)  return i;
            
        return -1;
    }
    
    static boolean checktree(int preorder[], int inorder[], int postorder[], int n)
    {
        return helper(preorder,0,n-1,inorder,0,n-1,postorder,0,n-1);
    }
    
    static boolean helper(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,int[] postorder,int postStart,int postEnd){
        if(preStart > preEnd || inStart > inEnd || postStart > postEnd)     return true;
        
        int inRoot = findIndex(inorder,inStart,inEnd,preorder[preStart]);
        int numLeft = (inRoot - inStart);
        
        if(inRoot == -1 || preorder[preStart] != postorder[postEnd])   return false;
            
        return (helper(preorder,preStart+1,preStart+numLeft,inorder,inStart,inRoot-1,postorder,postStart,postStart+numLeft-1) && helper(preorder,preStart+numLeft+1,preEnd,inorder,inRoot+1,inEnd,postorder,postStart+numLeft,postEnd-1));
    }
}