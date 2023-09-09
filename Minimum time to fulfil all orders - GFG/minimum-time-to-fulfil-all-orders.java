//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int l; 
            l = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, l);
            
            Solution obj = new Solution();
            int res = obj.findMinTime(n, l, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMinTime(int n, int l, int[] arr) {
        int low = 1, high = Integer.MIN_VALUE;
        for (Integer e: arr) 
            high = Math.max(high, e);
        high = high*n*(n+1)/2;
        
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int donuts = howMuchDonut(l, mid, arr);
            
            if (donuts >= n) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        
        return ans;
    }
    
    private static int howMuchDonut(int l, int mid, int[] arr) {
        int sum = 0;
        for (int i=0; i<l; i++) {
            int num = 2*mid/arr[i];
            int x = ( (int)Math.sqrt(1 + 4*num) - 1 )/2;
            sum += x;
        }  
        return sum;
    }
}
        
