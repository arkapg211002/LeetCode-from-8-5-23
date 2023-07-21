class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int cnt[]=new int[n];
        Arrays.fill(cnt,1);
        int max=1;
        for(int i=0;i<n;i++)
        {
            for(int prev=0;prev<=i-1;prev++)
            {
                if(nums[prev]<nums[i] && dp[prev]+1>dp[i])
                {
                    dp[i]=dp[prev]+1;
                    cnt[i]=cnt[prev];
                }
                else if(nums[prev]<nums[i] && dp[prev]+1==dp[i])
                {
                    cnt[i]+=cnt[prev];
                }
                max=(int)Math.max(max,dp[i]);
            }
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==max)res+=cnt[i];
        }
        return res;
    }
}