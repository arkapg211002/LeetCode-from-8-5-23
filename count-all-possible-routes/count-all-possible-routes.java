class Solution {
    long[][][] dp = new long[101][201][2];
    long mod = (long)1e9+7;
    public long helper(int[] locations, int start, int finish, int fuel,int flag,long[][][] dp){
        if(fuel<0) return 0;
        if(start==finish && flag==0){
            if(fuel==0) return 1;
            if(fuel>0) return 1 + helper(locations,start,finish,fuel,1,dp);
        }
        if(dp[start][fuel][flag]!=-1) return dp[start][fuel][flag];
        long ans = 0;
        for(int i=0;i<locations.length;i++){
            int x = Math.abs(locations[start]-locations[i]);
            if(i!=start){
                if(flag==0) ans += (helper(locations,i,finish,fuel-x,flag,dp)%mod);
                else ans += (helper(locations,i,finish,fuel-x,0,dp)%mod);
            }
            ans%=mod;
        }
        ans%=mod;
        return dp[start][fuel][flag]=ans;
    }
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        for(long[][] d1:dp) for(long[] d2:d1) Arrays.fill(d2,-1);
        return (int)helper(locations,start,finish,fuel,0,dp);
    }
}