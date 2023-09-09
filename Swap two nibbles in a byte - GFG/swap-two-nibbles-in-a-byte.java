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
            System.out.println(ob.swapNibbles(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int swapNibbles(int N) {
        //code here
        String s=Integer.toBinaryString(N);
        s=String.format("%8s",s).replace(' ','0');
        String lh=s.substring(0,4);
        String rh=s.substring(4);
        s=rh+lh;
        return Integer.parseInt(s,2);
    }
}