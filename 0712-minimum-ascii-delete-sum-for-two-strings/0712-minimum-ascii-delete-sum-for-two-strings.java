class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] presum1 = new int[m];
        int[] presum2 = new int[n];
        for(int i=0;i<m;++i)
        {
            if(i==0) presum1[i] = s1.charAt(i);
            else presum1[i] = presum1[i-1] + s1.charAt(i);
        }
        for(int i=0;i<n;++i)
        {
            if(i==0) presum2[i] = s2.charAt(i);
            else presum2[i] = presum2[i-1] + s2.charAt(i);
        }
        int[][] dp = new int[m][n];
        for(int[] r : dp) Arrays.fill(r,-1);
        return helper(m-1,n-1,s1,s2,presum1,presum2,dp);
    }
    public int helper(int m,int n,String s1,String s2,int[] presum1,int[] presum2,int[][] dp)
    {
        if(m<0 && n<0) return 0;
        if(m<0) return presum2[n];
        if(n<0) return presum1[m];
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m)==s2.charAt(n))
            return dp[m][n] = helper(m-1,n-1,s1,s2,presum1,presum2,dp);
        else return dp[m][n] = Math.min((s1.charAt(m) + helper(m-1,n,s1,s2,presum1,presum2,dp)),(s2.charAt(n) + helper(m,n-1,s1,s2,presum1,presum2,dp)));
    }
}