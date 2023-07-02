class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int c=1,max=1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i+1]==nums[i]+1) c+=1;
            else if(nums[i+1]==nums[i]) continue;
            else c=1;
            max=(int)Math.max(max,c);
        }
        return max;
    }
}