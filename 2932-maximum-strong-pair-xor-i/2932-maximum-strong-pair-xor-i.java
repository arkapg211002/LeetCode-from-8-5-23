class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(Math.abs(nums[i]-nums[j])<=Math.min(nums[i],nums[j]))
                    max=Math.max(max,(nums[i]^nums[j]));
            }
        }
        return max;
    }
}