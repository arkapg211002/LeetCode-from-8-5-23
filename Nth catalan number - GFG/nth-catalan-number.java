//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends






class Solution {
    public static int findCatalan(int n) {
        // code here
        
         long dp[]=new long[n+1];
        dp[0]=1;
        dp[1]=1;
        long mod=1000000007;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]=(dp[i]%mod)+(dp[j]*dp[i-j-1])%mod;
            }
        }
        int ans=(int)(dp[n]%mod);
        return ans;
    }
}
            
