//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            
            String[] xy = br.readLine().trim().split(" ");
            int n = Integer.parseInt(xy[0]);
            int m = Integer.parseInt(xy[1]);
            
            
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = Integer.parseInt(str[i]);
            
            Compute g = new Compute();
            System.out.println(g.maxProfit(a, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Compute {

    public static long maxProfit(int a[], int n, int m) {
        // Your code goes here 
        Arrays.sort(a);
        int k=m;
        long max=0,c=0;
        for(int i=0;i<n && a[i]<0;i++)
        {
            c+=((-1)*(long)a[i]);
            m-=1;
            if(m==0)
            {
                max=(long)Math.max(max,c);
                c=0;
                m=k;
            }
        }
        max=(long)Math.max(max,c);
        return max;
    }
}