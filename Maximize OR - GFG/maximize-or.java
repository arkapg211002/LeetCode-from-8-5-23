//{ Driver Code Starts
// Initial template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int X = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.getCount(X));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int getCount(int X) {
        // code here
        int count=0;
        int n = X;
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n>>=1;
        }
        return (X-(int)Math.pow(2,count)+1);
    }
}

