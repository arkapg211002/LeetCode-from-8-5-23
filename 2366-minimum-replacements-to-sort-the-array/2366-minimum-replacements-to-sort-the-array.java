class Solution {
    public long minimumReplacement(int[] nums) {
        long result=0;
        int n = nums.length;
        int prev = nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(prev>=nums[i]){
                prev = nums[i];
            }
            else{
                int parts =(int)Math.ceil((double)nums[i]/prev)-1;
                result+=parts;
                prev = Math.min(prev,nums[i]/(parts+1));
            }
        }
        return result;
    }
}