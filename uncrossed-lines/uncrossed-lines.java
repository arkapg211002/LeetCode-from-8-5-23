class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1<n2) 
        {
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
            n1=nums1.length;
            n2=nums2.length;
        }
        int dp[]=new int[n2 + 1];
        for(int i=1;i<=n1;i++) 
        {
            int prev=0;
            for(int j=1;j<=n2;j++) 
            {
                int curr = dp[j];
                if(nums1[i-1]==nums2[j-1]) dp[j]=prev + 1;
                else dp[j] = Math.max(dp[j-1],curr);
                prev = curr;
            }
        }
        return dp[n2];
    }
}