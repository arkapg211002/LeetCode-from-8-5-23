//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[]=in.readLine().trim().split(" ");
            String a = s[0];
            String b = s[1];
            Solution g = new Solution();
            if(g.isScramble(a,b)){
                out.println("Yes");
            }
            else{
                out.println("No");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   static Map<String, Boolean> map = new HashMap<>();
    static boolean isScramble(String a,String b)
    {
        if(a.equals(b)){
            return true;
        }
        if(a.length() == 0 && b.length() == 0){
            return true;
        }  
        return Solve(a, b, map);
    }

    static boolean Solve(String a, String b, Map<String, Boolean> map){
        if(a.equals(b)){
            return true;
        }
        if(a.length() <= 1){
            return false;
        }
        String key = a + " " + b;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        int n = a.length();
        boolean ans = false;
        for(int i = 1; i < n; i++){
            boolean swapped = (Solve(a.substring(0, i), b.substring(n - i, n), map) 
            && Solve(a.substring(i, n), b.substring(0, n - i), map));
            boolean notSwapped = (Solve(a.substring(0, i), b.substring(0, i), map) 
            && Solve(a.substring(i, n), b.substring(i, n), map));
            if(swapped || notSwapped){
                ans = true;
                break;
            }
        }
        map.put(key, ans);
        return ans; 
    }
}