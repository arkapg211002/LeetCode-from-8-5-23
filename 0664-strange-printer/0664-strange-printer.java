class Solution {
    public int strangePrinter(String s) {
        int n=s.length();
        int dp[][]=new int[n][n]; 
      for(int i=n-1;i>=0;i--)
      {
        for(int j=0;j<n;j++)
        {
          if(i > j) continue;
          else if(i == j) dp[i][j] = 1;
          else
          {
            int min = Integer.MAX_VALUE;
            for(int k=i;k<j;k++) 
                min=(int)Math.min(min,dp[i][k]+dp[k+1][j]); 
            if(s.charAt(i) == s.charAt(j)) min--;
            dp[i][j] = min;
          }
        }
      }
      return dp[0][s.length() - 1];
    }
    public int solveMemo(String s, int i, int j, Integer[][] dp)
    {
      if(i == j) return 1;
      if(dp[i][j] != null) return dp[i][j];
      int ans=Integer.MAX_VALUE;
      for(int k=i;k<j;k++)
        ans = Math.min(ans, solveMemo(s, i, k, dp) + solveMemo(s, k + 1, j, dp));     
      return dp[i][j] = s.charAt(i) == s.charAt(j) ? (ans - 1) : ans;
    }
}