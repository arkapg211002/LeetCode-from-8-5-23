//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int mat[][], int n, int m)
    {
        
        // complexity O(max(n,m))
        // Space complexity O(1)
        // code here 
        ArrayList<Integer> ans=new ArrayList<Integer>();
        
            // if there is only one column but do have row>1
            if(m==1&&n!=0){
                for(int i=0;i<n;i++){
                    ans.add(mat[i][0]);
                }
                return ans;
            }
            // traversing and saving first row
            for(int j=0;j<m;j++){
                ans.add(mat[0][j]);
                
            }
            
           // if there is only one row return here
            if(n==1){
                return ans;
            }
        
            // adding last elements from row 2nd to last -1 row
            for(int j=1;j<n-1;j++){
                ans.add(mat[j][m-1]);
                
            }
        
            // adding last row elements in rev order 
            for(int j=m-1;j>=0;j--){
                ans.add(mat[n-1][j]);
                
            }
            
            // adding first elements from row last-1 row to 2nd row in rev order
             for(int i=n-2;i>0;i--){
               ans.add(mat[i][0]);
            }
        return ans;
    }
}
