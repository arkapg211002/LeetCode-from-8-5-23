class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] dp = new int[k];
        return solve(0, dp, cookies, k, k);
    }
    public int solve(int ind, int[] dp, int[] cookies, int k, int zeroCnt)
    {
        if(cookies.length - ind < zeroCnt) return Integer.MAX_VALUE;
        if(ind == cookies.length)
        {
            int ans = Integer.MIN_VALUE;
            for(int v : dp) ans = Math.max(v, ans);
            return ans;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++)
        {
            if(dp[i] == 0) zeroCnt--;
            dp[i] = dp[i] + cookies[ind];
            ans = Math.min(ans, solve(ind+1, dp, cookies, k, zeroCnt));
            dp[i] = dp[i] - cookies[ind];
            if(dp[i] == 0) zeroCnt++;
        }
        return ans;
    }
}