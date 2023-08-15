//{ Driver Code Starts
//Initial Template for Java

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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            Solution obj = new Solution();
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = obj.rotation(N);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    
    ArrayList<Integer> rotation(int n){
       // Code Here
       ArrayList<Integer> res = new ArrayList<Integer>();
       int[] arr = new int[1001];
       Queue<Integer> q = new LinkedList<>();
       for(int i=1; i<=n; i++){
           q.add(i);
       }
       int i=1;
       while(!q.isEmpty()){
           int j=0;
           while(j<i){
               int x = q.peek();
               q.poll();
               q.add(x);
               j++;
           }
           int x = q.peek();
           if(arr[x] != 0){
               res.add(-1);
               return res;
           }
           arr[x] = i;
           q.poll();
           i++;
       }
       for(i=1; i<=n; i++)
           res.add(arr[i]);
       return res;
   }
}