//{ Driver Code Starts
//Initial Template for Java

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
            Solution ob = new Solution();
            ArrayList<Integer> v = new ArrayList<Integer>();
            v = ob.printNumHavingAltBitPatrn(N);
            for(int i : v)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    ArrayList<Integer> printNumHavingAltBitPatrn(int n)
    {
        // Code Here
        ArrayList<Integer> list = new ArrayList<>();

        

        int res=1;

        int count=2;

        while(res<=n)

        {

            list.add(res); 

            //right shift to mulyiply by 2

            res=res<<1;

            

            //tracking by using count variable 

            if(count%2!=0)

            {

                res=res|1;

            }

            count++;

        }

       return list;
    }
}
