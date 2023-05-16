class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        int ans=n+1;
        int vis[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0 && nums[i]<=n)
                vis[nums[i]]=1;
        }
        for(int i=1;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                ans = i;
                break;
            }
        }
        return ans;
    }
}