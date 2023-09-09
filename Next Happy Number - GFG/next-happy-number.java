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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

      
    static int nextHappy(int N){
        // code here
        if(isHappy(N)==1)
        {
            N++;
           while(isHappy(N)!=1)
             {
                 N++;
             }
            return N;
        }
        else
        {
            while(isHappy(N)!=1)
               N++;
             return N;  
        }
        
        
        
    }
    static int sqr(int n)
      {
          int ans =0;
          while(n>0)
          {
              int rem = n%10;
              ans = ans+ rem*rem;
              n=n/10;
          }          return ans;
      }
     static int isHappy(int N) { 
         //code here
         int slow = N;
         int fast = N;
         
         do{
             slow = sqr(slow);
             fast = sqr(sqr(fast));
         }while(slow!=fast);
         if(slow==1)  // if number is not  happy
            return 1;
        return 0; 
     }
    
}

