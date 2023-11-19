class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int i=nums.length-1;i>0;i--)
            if(nums[i-1]!=nums[i]) res+=(nums.length-i);
        return res;
    }
}
