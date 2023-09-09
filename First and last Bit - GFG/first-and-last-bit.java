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
                    long n = sc.nextLong();
                    Solution ob = new Solution();
                    System.out.println(ob.onlyFirstAndLastAreSet(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int onlyFirstAndLastAreSet(long n)
    {
        //code here.
        long len=Long.toBinaryString(n).length();
        int mask = 1 << (len-1);
        if(((n ^ 1) ^ mask) == 0 ) return 1;
        else return 0;
    }
}
