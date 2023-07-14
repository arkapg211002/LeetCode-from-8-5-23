class Solution {
    public int longestSubsequence(int[] nums, int difference) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            int temp=nums[i]-difference;
            int count=1;
            if(map.containsKey(temp)){
                count+=map.get(temp);
            }
            map.put(nums[i],count);
            ans=Math.max(ans,count);
        }
        return ans;
    }
}