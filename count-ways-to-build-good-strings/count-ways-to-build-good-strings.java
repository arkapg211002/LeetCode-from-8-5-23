class Solution {
    int MOD=(int)Math.pow(10,9)+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int dp[]=new int[high+1];
        Arrays.fill(dp,-1);
        return f(0,low,high,zero,one,dp);
    }
    public int f(int ind,int low,int high,int zero, int one,int dp[])
    {
        if(ind>high) return 0;
        if(dp[ind]!= -1) return dp[ind];
        int count = 0;
        if(ind>=low && ind<=high) count=(count+1)%MOD;
        count=(count + f(ind+zero,low,high,zero,one,dp))%MOD;
        count=(count + f(ind+one,low,high,zero,one,dp))%MOD;
        return dp[ind]=count%MOD;
    }
}