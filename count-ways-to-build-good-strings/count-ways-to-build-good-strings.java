class Solution {
    int MOD=(int)Math.pow(10,9)+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]=new int[high+1];
        Arrays.fill(dp,-1);
        return dfs(low,high,zero,one,0,dp);
    }
    public int dfs(int low,int high,int zero, int one,int ind,int dp[])
    {
        if(ind>high) return 0;
        if(dp[ind]!= -1) return dp[ind];
        int count = 0;
        if(ind>=low && ind<=high) count=(count+1)%MOD;
        count=(count+dfs(low,high,zero,one,ind+zero,dp))%MOD;
        count=(count+dfs(low,high,zero,one,ind+one,dp))%MOD;
        return dp[ind]=count;
    }
}