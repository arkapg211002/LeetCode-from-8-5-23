class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int cur=nums[0];
        int ans=cur;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==cur)
            {
                ans=nums[i];
                break;
            }
            cur=nums[i];
        }
        return ans;
    }
}