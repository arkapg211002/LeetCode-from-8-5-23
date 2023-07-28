class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return backtracking(nums,0,0,0,nums.length-1,1);
    }
    public boolean backtracking(int[] nums, int s1, int s2, int st, int en, int turn)
    {
        if(st>en) return s1>=s2;
        if(turn==1)
        {
            boolean one=backtracking(nums,s1+nums[st],s2,st+1,en,2);
            boolean two=backtracking(nums,s1+nums[en],s2,st,en-1,2);
            return (one || two)?true:false;
        }
        else
        {
            boolean one=backtracking(nums,s1,s2+nums[st],st+1,en,1);
            boolean two=backtracking(nums,s1,s2+nums[en],st,en-1,1);
            return (one && two)?true:false;
        }
    }
}