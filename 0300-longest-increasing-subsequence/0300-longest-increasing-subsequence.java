class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int max=-1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i-1;j++)
            {
                if(nums[j]<nums[i] && dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                }
            }
            max=(int)Math.max(max,dp[i]);
        }
        return max;
    }
}